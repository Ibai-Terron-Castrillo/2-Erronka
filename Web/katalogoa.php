<?php
session_start();
$isLoggedIn = isset($_SESSION['loggedin']) && $_SESSION['loggedin'] === true ? 'true' : 'false';
?>
<script>
    var isLoggedIn = <?php echo json_encode($isLoggedIn); ?>;
</script>

<?php require_once("Style+Js.php"); ?>
<title>Katalogoa</title>
</head>

<body>
    <header>
        <?PHP require_once("header.php"); ?>
        <h1>Katalogoa</h1>
        <p>Ikusi Gure Katalogoa</p>
    </header>
    <?PHP require_once("Sidebar.php"); ?>
    <?PHP require_once("Login.php"); ?>

    <div class="container" id="prod-container">

    </div>

    <button class="load-more" id="load-more-prod">Kargatu gehiago</button>

</body>

</html>