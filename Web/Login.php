<div class="topnav login" id="login">
    <a href="javascript:void(0)" class="closebtn" onclick="closeLogin()">×</a>

    <?php
    if (!isset($_SESSION['loggedin']) || $_SESSION['loggedin'] !== true) {
        echo'<h1>Saioa Hasi</h1>
        <form action="autenticacion.php" method="post">
        <label for="username">
            <i class="fas fa-user"></i>
        </label>
        <input type="text" name="username" placeholder="Erabiltzailea" id="username" required>
        <label for="password">
            <i class="fas fa-lock"></i>
        </label>
        <input type="password" name="password" placeholder="Pasahitza" id="password" required>
        <input type="submit" value="Sartu">
    </form>';
    }
    ?>
    

    <?php if (isset($_SESSION['loggedin']) && $_SESSION['loggedin'] === true): ?>
        <form action="saioaItxi.php" method="post"
            onsubmit="return confirm('Saioa itxi nahi duzu?');">
            <button type="submit">Saioa Itxi</button>
        </form>

    <?php endif; ?>

</div>