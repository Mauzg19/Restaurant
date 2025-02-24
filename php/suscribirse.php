<?php
header('Content-Type: application/json');

// Verificar si el índice 'REQUEST_METHOD' existe en el arreglo $_SERVER
if (!isset($_SERVER['REQUEST_METHOD'])) {
    echo json_encode([
        'success' => false,
        'message' => 'Método no permitido'
    ]);
    exit();
}

// Verificar si el método de solicitud es POST
if ($_SERVER['REQUEST_METHOD'] !== 'POST') {
    echo json_encode([
        'success' => false,
        'message' => 'Método no permitido'
    ]);
    exit();
}

// Aquí empieza el manejo del POST request
// Obtener datos del cuerpo de la solicitud
$data = json_decode(file_get_contents('php://input'), true);

// Validar si los datos están presentes
if (!isset($data['email']) || empty($data['email'])) {
    echo json_encode([
        'success' => false,
        'message' => 'Falta el email'
    ]);
    exit();
}

// Procesar los datos (por ejemplo, guardar en la base de datos)
// Aquí va el código para guardar los datos en la base de datos

// Suponiendo que todo salió bien
echo json_encode([
    'success' => true,
    'message' => 'Suscripción exitosa'
]);

?>
