<?php require_once("Style+Js.php"); ?>
<?PHP require_once("itzuli.html"); ?>

<title> Zure erregistroa </title>

<header>
    <a href="berriak.php" class="openbtn"><i class="fa fa-home" aria-hidden="true"></i></a>
    <h1>Kontua sortu</h1>
</header>
<form class="registroform" action="registro.php" method="post">
    <label for="izena">Izena</label>
    <input type="text" name="izena" id="izena" placeholder="zure izena"  required>

    <label for="abizena">Abizenak</label>
    <input type="text" name="abizena" id="abizena" placeholder="zure abizena" required>

    <label for="erabiltzailea">Erabiltzaile Izena</label>
    <input type="text" name="erabiltzailea" id="erabiltzailea" placeholder="alex123" required>

    <label for="pasahitza">Pasahitza</label>
    <input type="password" name="pasahitza" id="pasahitza" placeholder="p123" required>

    <label for="pasahitza_confirm">Pasahitza Baieztatu</label>
    <input type="password" name="pasahitza_confirm" id="pasahitza_confirm" placeholder="berdina jarri" required>

    <label for="email">Helbide Elektronikoa</label>
    <input type="email" name="email" id="email" placeholder="jaujajja@gmail.com" required>

    <label for="telefonoa">Telefonoa</label>
    <input type="text" name="telefonoa" id="telefonoa"   placeholder="666 0898 22">

    <label for="nan">NAN</label>
    <input type="text" name="nan" id="nan" placeholder="73247622M">

    <input class="button" type="submit" value="Erregistratu" >
</form>