<div class="topnav login" id="login">
    <a href="javascript:void(0)" class="closebtn" onclick="closeLogin()">×</a>
    <h1>Saioa Hasi</h1>

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
    </form>
</div>