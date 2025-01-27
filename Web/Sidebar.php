<div class="topnav sidebar" id="mySidebar">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
    <a href="Berriak.php">Berriak</a>
    <a href="GuriBuruz.php">Guri Buruz</a>
    <a href="Kontaktua.php">Kontaktua</a>
    <a href="#">Katalogoa</a>
    <?php if (isset($_SESSION['loggedin']) && $_SESSION['loggedin'] === true): ?>
            <li><a href="">Hornitzaile Bihurtu</a></li>
        <?php endif; ?>
</div>