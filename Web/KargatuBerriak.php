<?php
// Configuración de la base de datos
$host = 'localhost';
$dbname = 'Erronka2';
$user = 'root';
$password = '1MG2024';

// Conexión a la base de datos
try {
    $pdo = new PDO("mysql:host=$host;dbname=$dbname;charset=utf8", $user, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    http_response_code(500);
    echo json_encode(["error" => "Error de conexión a la base de datos: " . $e->getMessage()]);
    exit;
}

// Obtener el número de página desde la solicitud
$page = isset($_GET['page']) ? (int)$_GET['page'] : 1;
$limit = 5; // Número de berriak por página
$offset = ($page - 1) * $limit;

// Consultar las berriak desde la base de datos
try {
    $stmt = $pdo->prepare("SELECT title, description, image_url FROM berriak ORDER BY created_at DESC LIMIT :limit OFFSET :offset");
    $stmt->bindValue(':limit', $limit, PDO::PARAM_INT);
    $stmt->bindValue(':offset', $offset, PDO::PARAM_INT);
    $stmt->execute();

    $news = $stmt->fetchAll(PDO::FETCH_ASSOC);

    // Devolver las berriak en formato JSON
    header('Content-Type: application/json');
    echo json_encode($news);
} catch (PDOException $e) {
    http_response_code(500);
    echo json_encode(["error" => "Error al obtener las berriak: " . $e->getMessage()]);
    exit;
}
?>
