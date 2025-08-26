$ErrorActionPreference = 'Stop'

# Asegurar carpeta de salida
if (-not (Test-Path 'target')) {
	New-Item -ItemType Directory -Path 'target' | Out-Null
}

# Rutas candidatas de Edge y Chrome
$pf = ${env:ProgramFiles}
$pf86 = ${env:ProgramFiles(x86)}
$candidates = @(
	(Join-Path $pf 'Microsoft\Edge\Application\msedge.exe'),
	(Join-Path $pf86 'Microsoft\Edge\Application\msedge.exe'),
	(Join-Path $pf 'Google\Chrome\Application\chrome.exe'),
	(Join-Path $pf86 'Google\Chrome\Application\chrome.exe')
)

# Seleccionar navegador disponible
$browser = $null
foreach ($c in $candidates) {
	if (Test-Path $c) { $browser = $c; break }
}
if (-not $browser) {
	Write-Error 'No se encontró Microsoft Edge ni Google Chrome instalados.'
	exit 1
}

# Rutas de entrada/salida
$html = Resolve-Path 'src\main\resources\static\resumen-proyecto.html'
$pdfDir = Resolve-Path 'target'
$pdf = Join-Path $pdfDir 'resumen-proyecto.pdf'

# Construir URI file:/// para headless
$htmlUri = 'file:///' + ($html.Path -replace '\\','/')

# Ejecutar en modo headless
& $browser --headless --disable-gpu --print-to-pdf="$pdf" "$htmlUri"

# Verificar resultado
if (Test-Path $pdf) {
	Write-Host "PDF generado correctamente: $pdf"
} else {
	Write-Error 'Falló la generación del PDF.'
	exit 2
} 