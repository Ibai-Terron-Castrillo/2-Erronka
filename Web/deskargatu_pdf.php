<?php
require('fpdf.php');

$idEskaera = $_GET['id'];

require_once("db.php");
$conn = konexioaSortu();
$conn->set_charset("utf8mb4");

$sql = "SELECT 
            Eskaera.idEskaera AS EskaeraID,
            CONCAT(Bezeroa.Izena, ' ', Bezeroa.Abizenak) AS Bezeroa,
            Bezeroa.email AS Email,
            Bezeroa.telefonoa AS Telefonoa,
            Eskaera.data AS 'Eskaera Data',
            Eskaera.helbidea AS Helbidea,
            GROUP_CONCAT(CONCAT(biltegia.ProduktuIzena, ' (', ' x ', eskaera_biltegia.Kantitatea, ')') SEPARATOR ', ') AS Produktuak,
            CONCAT(SUM(eskaera_biltegia.Kantitatea * biltegia.ProduktuPrezioa), '€') AS Guztira,
            CONCAT(garraiolaria.Izena, ' ', garraiolaria.Abizenak, ' | ', garraiolaria.Enpresa) AS Garraiolaria,
            eskaeraEgoera AS 'Eskaera Egoera'
        FROM 
            Bezeroa
        INNER JOIN 
            Eskaera ON Bezeroa.idBezeroa = Eskaera.idBezeroa
        INNER JOIN 
            eskaera_biltegia ON Eskaera.idEskaera = eskaera_biltegia.idEskaera
        INNER JOIN 
            biltegia ON eskaera_biltegia.ProduktuId = biltegia.ProduktuId
        INNER JOIN 
            garraiolaria ON Eskaera.idGarraiolaria = garraiolaria.idGarraiolaria
        WHERE 
            Eskaera.idEskaera = $idEskaera
        GROUP BY 
            Eskaera.idEskaera";

$result = $conn->query($sql);
if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();

    $pdf = new FPDF();
    $pdf->AddPage();
    $pdf->SetFont('Arial', 'B', 16);

    $pdf->Ln(10);
$pdf->Cell(200, 10, 'Eskaera', 0, 1, 'C');
$pdf->Ln(10); 
$pdf->Cell(200, 10, 'ID: ' . $row["EskaeraID"], 0, 1);
$pdf->Ln(5); 
$pdf->Cell(200, 10, 'Bezeroa: ' . $row["Bezeroa"], 0, 1);
$pdf->Ln(5);
$pdf->Cell(200, 10, 'Email: ' . $row["Email"], 0, 1);
$pdf->Ln(5);
$pdf->Cell(200, 10, 'Telefonoa: ' . $row["Telefonoa"], 0, 1);
$pdf->Ln(5);
$pdf->Cell(200, 10, 'Helbidea: ', 0, 1);
$pdf->MultiCell(200, 10, $row["Helbidea"]);
$pdf->Ln(5);
$pdf->Cell(200, 10, 'Produktuak: ', 0, 1);
$pdf->MultiCell(180, 10, $row["Produktuak"]); 
$pdf->Ln(5);
$guztira = str_replace("€", chr(128), $row["Guztira"]);
$pdf->Cell(200, 10, 'Guztira: ' . $guztira, 0, 1);
$pdf->Ln(5);
$pdf->Cell(200, 10, 'Garraioa: ' . $row["Garraiolaria"], 0, 1);


    $pdf->Output();
} else {
    echo "Ez da aurkitu.";
}
?>
