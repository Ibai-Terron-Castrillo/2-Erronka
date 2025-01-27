-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: erronka2
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bezeroa`
--

DROP TABLE IF EXISTS `bezeroa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bezeroa` (
  `idBezeroa` int NOT NULL AUTO_INCREMENT,
  `Izena` varchar(100) NOT NULL,
  `Abizena` varchar(150) NOT NULL,
  `Erabiltzailea` varchar(100) NOT NULL,
  `Pasahitza` varchar(100) NOT NULL,
  `Email` varchar(150) NOT NULL,
  `Telefonoa` varchar(20) DEFAULT NULL,
  `Nan` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idBezeroa`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `Nan` (`Nan`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bezeroa`
--

LOCK TABLES `bezeroa` WRITE;
/*!40000 ALTER TABLE `bezeroa` DISABLE KEYS */;
INSERT INTO `bezeroa` VALUES (1,'Jon','Etxeberria','jon123','pass1234','jon@example.com','600123456','12345678A'),(2,'Ane','Lopez','ane456','password','ane@example.com','600654321','87654321B'),(3,'Mikel','Aranburu','mikel789','mikelpass','mikel@example.com','600987654','12348765C'),(4,'Nerea','Garcia','nerea111','nereapass','nerea@example.com','600345678','23456789D'),(5,'Iker','Martinez','iker222','ikerpass','iker@example.com','600876543','34567890E'),(6,'Maite','Zabala','maite333','maitepass','maite@example.com','600234567','45678901F'),(7,'Ander','Agirre','ander444','anderpass','ander@example.com','600543210','56789012G'),(8,'Maitane','Etxano','maitane555','maitanepass','maitane@example.com','600789123','67890123H'),(9,'Unai','Bengoetxea','unai666','unaipass','unai@example.com','600321654','78901234I'),(10,'Leire','Olaizola','leire777','leirepass','leire@example.com','600654987','89012345J'),(11,'Xabier','Oiarzabal','xabier888','xabierpass','xabier@example.com','600987321','90123456K'),(12,'Irati','Sarasola','irati999','iratipass','irati@example.com','600123789','10234567L'),(13,'Aitor','Muguruza','aitor101','aitorpass','aitor@example.com','600456123','11234567M'),(14,'Garazi','Zuloaga','garazi202','garazipass','garazi@example.com','600789456','12234567N'),(15,'Iñaki','Lasa','iñaki303','iñakipass','iñaki@example.com','600321987','13234567O'),(16,'Nahia','Ormaetxea','nahia404','nahiapass','nahia@example.com','600654123','14234567P'),(17,'Koldo','Urkullu','koldo505','koldopass','koldo@example.com','600987654','15234567Q'),(18,'Uxue','Egibar','uxue606','uxuepass','uxue@example.com','600123456','16234567R'),(19,'Gorka','Urrutia','gorka707','gorkapass','gorka@example.com','600456789','17234567S'),(20,'Alazne','Aizpurua','alazne808','alaznepass','alazne@example.com','600789012','18234567T'),(21,'Eneko','Iturbe','eneko909','enekopass','eneko@example.com','600321654','19234567U'),(22,'Arantxa','Beristain','arantxa010','arantxapass','arantxa@example.com','600654987','20234567V'),(23,'Jonander','Jauregi','jonander020','jonanderpass','jonander@example.com','600987321','21234567W'),(24,'Aiala','Zarautz','aiala030','aialapass','aiala@example.com','600123789','22234567X'),(25,'Aritz','Goikoetxea','aritz040','aritzpass','aritz@example.com','600456123','23234567Y'),(26,'June','Altuna','june050','junepass','june@example.com','600789456','24234567Z'),(27,'Markel','Otegi','markel060','markelpass','markel@example.com','600321987','25234567A'),(28,'Aiora','Odriozola','aiora070','aiorapass','aiora@example.com','600654123','26234567B'),(29,'Eider','Legorburu','eider080','eiderpass','eider@example.com','600987654','27234567C'),(30,'Asier','Mendizabal','asier090','asierpass','asier@example.com','600123456','28234567D');
/*!40000 ALTER TABLE `bezeroa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biltegia`
--

DROP TABLE IF EXISTS `biltegia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `biltegia` (
  `ProduktuId` int NOT NULL AUTO_INCREMENT,
  `ProduktuIzena` varchar(150) NOT NULL,
  `ProduktuMota` varchar(100) DEFAULT NULL,
  `ProduktuEgoera` enum('Oso ona','Ona','Egokia') DEFAULT NULL,
  `ProduktuIruId` varchar(100) DEFAULT NULL,
  `ProduktuPrezioa` decimal(10,2) DEFAULT NULL,
  `ProduktuKantitatea` int NOT NULL,
  PRIMARY KEY (`ProduktuId`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biltegia`
--

LOCK TABLES `biltegia` WRITE;
/*!40000 ALTER TABLE `biltegia` DISABLE KEYS */;
/*!40000 ALTER TABLE `biltegia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `erosketa`
--

DROP TABLE IF EXISTS `erosketa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `erosketa` (
  `idErosketa` int NOT NULL AUTO_INCREMENT,
  `ProduktuKantitatea` int NOT NULL,
  `data` date NOT NULL,
  `ProduktuPrezioa` decimal(10,2) DEFAULT NULL,
  `ProduktuIrudia` varchar(100) DEFAULT NULL,
  `ProduktuEgoera` varchar(100) DEFAULT NULL,
  `ProduktuMota` varchar(100) DEFAULT NULL,
  `ProduktuIzena` varchar(150) DEFAULT NULL,
  `idHornitzailea` int DEFAULT NULL,
  PRIMARY KEY (`idErosketa`),
  UNIQUE KEY `idHornitzailea` (`idHornitzailea`),
  CONSTRAINT `fk_erosketa_hornitzailea` FOREIGN KEY (`idHornitzailea`) REFERENCES `hornitzailea` (`idHornitzailea`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `erosketa`
--

LOCK TABLES `erosketa` WRITE;
/*!40000 ALTER TABLE `erosketa` DISABLE KEYS */;
INSERT INTO `erosketa` VALUES (1,5,'2025-01-01',100.50,NULL,'Oso ona','Elektronika','Ordenagailua',1),(2,10,'2025-01-02',200.00,NULL,'Ona','Elektronika','Tableta',2),(3,15,'2025-01-03',300.75,NULL,'Txarra','Elektronika','Mugikorra',3),(4,2,'2025-01-04',400.99,NULL,'Oso ona','Osagarriak','Teclatua',4),(5,6,'2025-01-05',50.00,NULL,'Txarra','Osagarriak','Sagu Optikoa',5),(6,3,'2025-01-06',1200.00,NULL,'Oso ona','Elektronika','Telefonoa',6),(7,7,'2025-01-07',1500.00,NULL,'Ona','Elektronika','Telebista',7),(8,12,'2025-01-08',20.99,NULL,'Oso ona','Osagarriak','Kable USB',8),(9,8,'2025-01-09',300.00,NULL,'Txarra','Gailuak','Arbel Digitala',9),(10,9,'2025-01-10',450.50,NULL,'Txarra','Elektronika','Dronea',10),(11,30,'2025-01-11',5.99,NULL,'Oso ona','Osagarriak','Bateriak',11),(12,4,'2025-01-12',250.00,NULL,'Ona','Elektronika','Impresora',12),(13,1,'2025-01-13',500.99,NULL,'Oso ona','Elektronika','Pantaila',13),(14,2,'2025-01-14',700.00,NULL,'Ona','Etxetresnak','Arropa Garbigailua',14),(15,5,'2025-01-15',800.00,NULL,'Oso ona','Etxetresnak','Labe Elektrikoa',15),(16,3,'2025-01-16',150.00,NULL,'Txarra','Etxetresnak','Mikrouhinak',16),(17,10,'2025-01-17',100.00,NULL,'Ona','Altzariak','Bulegoko Mahaia',17),(18,12,'2025-01-18',300.00,NULL,'Oso ona','Altzariak','Aulki Ergonomikoa',18),(19,8,'2025-01-19',450.00,NULL,'Txarra','Altzariak','Sofa',19),(20,6,'2025-01-20',20.00,NULL,'Oso ona','Papergintza','Liburua',20),(21,15,'2025-01-21',5.99,NULL,'Ona','Papergintza','Koadernoa',21),(22,50,'2025-01-22',1.50,NULL,'Txarra','Papergintza','Errotulagailua',22),(23,5,'2025-01-23',200.00,NULL,'Oso ona','Etxetresnak','Esne Makina',23),(24,7,'2025-01-24',100.00,NULL,'Ona','Etxetresnak','Zuku Makina',24),(25,3,'2025-01-25',50.00,NULL,'Oso ona','Osagarriak','Erloju Digitala',25),(26,8,'2025-01-26',80.00,NULL,'Oso ona','Elektronika','Kanpoko Diskoa',26),(27,20,'2025-01-27',30.00,NULL,'Ona','Osagarriak','Power Bank',27),(28,10,'2025-01-28',200.00,NULL,'Oso ona','Elektronika','Smart Watch',28),(29,18,'2025-01-29',100.00,NULL,'Ona','Osagarriak','Bozgorailuak',29),(30,10,'2025-01-30',300.00,NULL,'Oso ona','Etxetresnak','Kafe Makina',30);
/*!40000 ALTER TABLE `erosketa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eskaera`
--

DROP TABLE IF EXISTS `eskaera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eskaera` (
  `idEskaera` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `helbidea` varchar(200) DEFAULT NULL,
  `eskaeraEgoera` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idEskaera`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eskaera`
--

LOCK TABLES `eskaera` WRITE;
/*!40000 ALTER TABLE `eskaera` DISABLE KEYS */;
INSERT INTO `eskaera` VALUES (1,'2025-01-01','Donostia, Kale Nagusia 10','Prozesatzen'),(2,'2025-01-02','Bilbo, Errekalde 5','Bidaltzeko prest'),(3,'2025-01-03','Gasteiz, Armentia 3','Bidalia'),(4,'2025-01-04','Iruñea, San Fermin 12','Itxaron zerrendan'),(5,'2025-01-05','Donostia, Miramart 6','Prozesatzen'),(6,'2025-01-06','Bilbo, Zorrotza 11','Bidaltzeko prest'),(7,'2025-01-07','Gasteiz, Lakua 9','Bidalia'),(8,'2025-01-08','Iruñea, Mendillorri 4','Itxaron zerrendan'),(9,'2025-01-09','Donostia, Antiguo 14','Prozesatzen'),(10,'2025-01-10','Bilbo, San Mames 8','Bidaltzeko prest'),(11,'2025-01-11','Gasteiz, Txagorritxu 5','Bidalia'),(12,'2025-01-12','Iruñea, Azpilagaña 1','Itxaron zerrendan'),(13,'2025-01-13','Donostia, Gros 2','Prozesatzen'),(14,'2025-01-14','Bilbo, Deustu 7','Bidaltzeko prest'),(15,'2025-01-15','Gasteiz, Sansomendi 6','Bidalia'),(16,'2025-01-16','Iruñea, Berriozar 3','Itxaron zerrendan'),(17,'2025-01-17','Donostia, Amara 9','Prozesatzen'),(18,'2025-01-18','Bilbo, Abando 10','Bidaltzeko prest'),(19,'2025-01-19','Gasteiz, Judimendi 2','Bidalia'),(20,'2025-01-20','Iruñea, Artika 7','Itxaron zerrendan'),(21,'2025-01-21','Donostia, Igara 15','Prozesatzen'),(22,'2025-01-22','Bilbo, Rekaldeberri 12','Bidaltzeko prest'),(23,'2025-01-23','Gasteiz, Zabalgana 8','Bidalia'),(24,'2025-01-24','Iruñea, Iturrama 6','Itxaron zerrendan'),(25,'2025-01-25','Donostia, Loiola 11','Prozesatzen'),(26,'2025-01-26','Bilbo, Indautxu 4','Bidaltzeko prest'),(27,'2025-01-27','Gasteiz, Salburua 13','Bidalia'),(28,'2025-01-28','Iruñea, Mendigorria 5','Itxaron zerrendan'),(29,'2025-01-29','Donostia, Aiete 2','Prozesatzen'),(30,'2025-01-30','Bilbo, Basurtu 10','Bidaltzeko prest');
/*!40000 ALTER TABLE `eskaera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eskaera_biltegia`
--

DROP TABLE IF EXISTS `eskaera_biltegia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eskaera_biltegia` (
  `idEskaera` int NOT NULL,
  `ProduktuId` int NOT NULL,
  `Kantitatea` int NOT NULL,
  `GuztiraPrezioa` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idEskaera`,`ProduktuId`),
  KEY `ProduktuId` (`ProduktuId`),
  CONSTRAINT `eskaera_biltegia_ibfk_1` FOREIGN KEY (`idEskaera`) REFERENCES `eskaera` (`idEskaera`) ON DELETE CASCADE,
  CONSTRAINT `eskaera_biltegia_ibfk_2` FOREIGN KEY (`ProduktuId`) REFERENCES `biltegia` (`ProduktuId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eskaera_biltegia`
--

LOCK TABLES `eskaera_biltegia` WRITE;
/*!40000 ALTER TABLE `eskaera_biltegia` DISABLE KEYS */;
/*!40000 ALTER TABLE `eskaera_biltegia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garraiolaria`
--

DROP TABLE IF EXISTS `garraiolaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garraiolaria` (
  `idGarraiolaria` int NOT NULL AUTO_INCREMENT,
  `Izena` varchar(100) NOT NULL,
  `Helbidea` varchar(200) DEFAULT NULL,
  `Abizenak` varchar(150) DEFAULT NULL,
  `Nan` varchar(20) DEFAULT NULL,
  `Telefonoa` varchar(20) DEFAULT NULL,
  `Enpresa` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idGarraiolaria`),
  UNIQUE KEY `Nan` (`Nan`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garraiolaria`
--

LOCK TABLES `garraiolaria` WRITE;
/*!40000 ALTER TABLE `garraiolaria` DISABLE KEYS */;
INSERT INTO `garraiolaria` VALUES (1,'Aitor','Kalea 1, Donostia','Etxebarria','12345678A','688123456','EuskoGarraioak S.L.'),(2,'Amaia','Bide Nagusia 12, Bilbo','Agirre','87654321B','688654321','BizkaiaGarraioa'),(3,'Mikel','Zubiaurre 5, Gasteiz','Lertxundi','56781234C','687321456','Arabako Bidaiak'),(4,'Maialen','Ibilbide 8, Iruñea','Olabarri','34567812D','687654321','Nafarroako Garraioak'),(5,'Jon','Etxeondo 3, Hernani','Irazusta','23456781E','688987654','Gipuzkoa Mugitzen'),(6,'Irati','Santiago 21, Tolosa','Zubizarreta','78912345F','689123654','Zubiondo Logistika'),(7,'Unai','Haritza 6, Beasain','Arrieta','65432187G','689654321','BaserriBidaiak'),(8,'Ane','Eguzki Plazako 9, Durango','Zabaleta','98765432H','688321654','Durangoko Bidaiak'),(9,'Iker','Landako 14, Azpeitia','Etxegarai','19283746J','688789456','Azkoitia Garraioak'),(10,'Nerea','Geltoki 7, Ordizia','Lizarralde','74638291K','687456321','LurBidea S.L.'),(11,'Ander','Amara Plaza 4, Donostia','Odriozola','29174638L','687987654','Donosti Mugituz'),(12,'Uxue','Itsasondo Kalea 11, Zarautz','Altuna','56382749M','689321987','ItsasoGarraioak'),(13,'Ekaitz','Zirkuitu 2, Urnieta','Bengoetxea','38291564N','688654987','Mugimendu Bizkorra'),(14,'Leire','Iparralde 3, Getxo','Aranguren','91827364P','688321789','Getxo Garraioa'),(15,'Gorka','Hegoalde 17, Gernika','Laskurain','37491826Q','688789123','GernikaLogistika'),(16,'Aritz','Olatuak 5, Zumaia','Egaña','87654319R','689123987','ItsasBidea S.L.'),(17,'Eneko','Txintxarri 7, Deba','Goikoetxea','91287364S','687987123','Debako Garraioak'),(18,'Olaia','Zabalguneko 9, Oñati','Urrutia','46382715T','687321789','Mendibidean Logistika'),(19,'Igor','Kale Nagusia 16, Markina','Arregi','82736491U','689654123','Markina Bidaiak'),(20,'Lorea','Eguzki Bidea 8, Lekunberri','Etxaniz','91827364V','688987321','Nafarroako Logistika'),(21,'Beñat','Gernikako Arbola 6, Lekeitio','Mendizabal','37491826W','688321654','Euskal Itsas Garraioa'),(22,'Maddalen','Bide Luzea 12, Zarautz','Goirizelaia','65432718X','689987654','Zarautz Mugitzen'),(23,'Xabier','Kale Zaharra 3, Eibar','Beristain','91827364Y','687654321','Eibarko Garraioak'),(24,'Ainhoa','Udaletxe 4, Hondarribia','Iribarren','82736491Z','688321789','Hondartza Bidaiak'),(25,'Markel','Itsasaldeko 2, Bermeo','Artetxe','46382715A','689123456','Bermeo Logistika'),(26,'Izaro','Arbola 8, Zestoa','Azkarraga','37491826B','688789456','Zestoa Garraioak'),(27,'Oier','Txantxangorri Kalea 5, Elgoibar','Legazpi','82736491C','689456321','Elgoibar Mugitzen'),(28,'Aiert','Txiki Plaza 7, Tolosa','Sarasola','91827364D','687123654','Tolosako Logistika'),(29,'Garazi','Kale Berria 9, Bergara','Jauregi','65432718E','688456987','Bergarako Garraioak'),(30,'Iraitz','Lur Gorria 11, Usurbil','Etxebeste','82736491F','689789123','Usurbil Garraioak');
/*!40000 ALTER TABLE `garraiolaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hornitzailea`
--

DROP TABLE IF EXISTS `hornitzailea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hornitzailea` (
  `idHornitzailea` int NOT NULL AUTO_INCREMENT,
  `Izena` varchar(100) NOT NULL,
  `Deskripzioa` text,
  PRIMARY KEY (`idHornitzailea`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hornitzailea`
--

LOCK TABLES `hornitzailea` WRITE;
/*!40000 ALTER TABLE `hornitzailea` DISABLE KEYS */;
INSERT INTO `hornitzailea` VALUES (1,'TeknoBerrikuntza','Ordenagailu eta tresna teknologiko berritzaileen hornitzailea.'),(2,'EguzkiEnergia','Eguzki-plakak eta energia berriztagarrien sistemak.'),(3,'PantailaHandia','Pantaila eta monitore profesionalak.'),(4,'ZiberTek','Zibersegurtasun tresna eta software hornitzailea.'),(5,'AudioMaster','Audio ekipamendu profesional eta etxekoak.'),(6,'KodeLab','Software garapenerako tresna eta lizentziak.'),(7,'ArgiDigitala','LED argiak eta argiztapen adimenduna.'),(8,'DronEusk','Dronak eta horien osagarriak.'),(9,'TeknoMugikorra','Mugikor berrienak eta osagarriak.'),(10,'Ikus-entzunezkoak','Kamera profesionalak eta bideo-editatzeko tresnak.'),(11,'RobotikaEtxea','Robotika aplikatu eta etxeko soluzio adimendunak.'),(12,'HodeiLab','Hodeiko biltegiratze eta zerbitzuak.'),(13,'GamingGear','Jokoetarako ordenagailuak eta osagarriak.'),(14,'IoTEusk','Gailu adimendunak eta IoT soluzioak.'),(15,'AutoElektrikoa','Auto elektrikoen kargagailuak eta osagarriak.'),(16,'Berrikuntza3D','3D inprimagailuak eta erabili beharreko materialak.'),(17,'SmartEtxea','Etxe adimenduneko soluzioak eta tresnak.'),(18,'TeknoLanabesak','Industria teknologikorako tresneria espezializatua.'),(19,'HodeiSegurua','Hodeiko segurtasun sistemak eta zerbitzuak.'),(20,'TekSmart','Gailu adimendunak eta AI soluzioak.'),(21,'EuskRobot','Robotika eta automatizazio industriala.'),(22,'ZiberSarea','Sare eta komunikazio teknologiarako osagaiak.'),(23,'OrdenagailuGunea','Ordenagailu eramangarriak eta mahaigainekoak.'),(24,'EuskDatuak','Datu analitika eta biltegiratzeko sistemak.'),(25,'TeknoLurruna','Lurrun bidezko garbiketa tresnak eta sistemak.'),(26,'ZiberIkaskuntza','Ikaskuntza digitalerako tresnak eta hezkuntza softwareak.'),(27,'BideoKonferentzia','Bideo-konferentziarako gailuak eta zerbitzuak.'),(28,'WiFiPro','WiFi gailuak eta sare indartzaileak.'),(29,'DroneSegurua','Droneen segurtasun sistemak eta zerbitzuak.'),(30,'EuskAI','Adimen artifizialeko garapen tresnak eta zerbitzuak.');
/*!40000 ALTER TABLE `hornitzailea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `langilea`
--

DROP TABLE IF EXISTS `langilea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `langilea` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Izena` varchar(100) NOT NULL,
  `Abizenak` varchar(150) NOT NULL,
  `Helbidea` varchar(200) DEFAULT NULL,
  `Erabiltzailea` varchar(100) NOT NULL,
  `Pasahitza` varchar(100) NOT NULL,
  `Nan` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Nan` (`Nan`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `langilea`
--

LOCK TABLES `langilea` WRITE;
/*!40000 ALTER TABLE `langilea` DISABLE KEYS */;
INSERT INTO `langilea` VALUES (1,'Jon','Agirre','Kale Nagusia 1','jagirre','pasahitz1','12345678A'),(2,'Amaia','Etxeberria','Etxebide 2','amaetxe','pasahitz2','87654321B'),(3,'Mikel','Iribarren','Zubi Kalea 3','mikiri','pasahitz3','11223344C'),(4,'Ane','Iraola','Olarra Kalea 4','aneira','pasahitz4','33445566D'),(5,'Unai','Olaizola','Aranburu Plaza 5','unola','pasahitz5','55667788E'),(6,'Maite','Zubizarreta','Egur Bidea 6','maizubi','pasahitz6','99887796F'),(7,'Iker','Goikoetxea','Ibilbide Nagusia 7','ikgoi','pasahitz7','99887766F'),(8,'Nerea','Mendieta','Mendi Kalea 8','nermendi','pasahitz8','77665548K'),(9,'Ander','Arozena','Laino Bidea 9','andaroz','pasahitz9','77665544G'),(10,'Uxue','Elorza','Urdaneta 10','uxelor','pasahitz10','2233444I'),(11,'Gorka','Urkullu','Baserria Kalea 11','gorkurk','pasahitz11','12349876H'),(12,'Leire','Iturralde','Ur Bidea 12','leiturr','pasahitz12','22334455I'),(13,'Asier','Aranburu','Haritz Kalea 13','asaran','pasahitz13','99887755J'),(14,'Irati','Bereziartua','Sagarrondo Kalea 14','iraber','pasahitz14','66554433K'),(15,'Aitor','Murgia','Lizar Kalea 15','aitmur','pasahitz15','11225544L'),(16,'Maitane','Larrañaga','Erreka Kalea 16','mailarr','pasahitz16','43445662B'),(17,'Iñaki','Urrutia','Zuhaitz Kalea 17','inurrut','pasahitz17','77668899M'),(18,'Eneko','Egaña','Ipar Bidea 18','enega','pasahitz18','33221144N'),(19,'June','Arregi','Hego Kalea 19','junarr','pasahitz19','43445522T'),(20,'Alaia','Etxebeste','Ertz Bidea 20','alaetxe','pasahitz20','44556677O'),(21,'Xabier','Lertxundi','Oinezko Kalea 21','xablert','pasahitz21','99887722P'),(22,'Arantxa','Zubiaurre','Zubi Bidea 22','arazubi','pasahitz22','11223366Q'),(23,'Ane','Salaberria','Salburua Kalea 23','anesala','pasahitz23','77889944R'),(24,'Unax','Lizaso','Egur Plaza 24','unliz','pasahitz24','55667799S'),(25,'Edurne','Altuna','Aranburu Kalea 25','edualtu','pasahitz25','33445522T'),(26,'Eider','Larrañaga','Tximeleta Bidea 26','eidlar','pasahitz26','98335637K'),(27,'Xabi','Etxaniz','Arbel Kalea 27','xabetxa','pasahitz27','99881122U'),(28,'Andoni','Zarautz','Hondartza Kalea 28','andzar','pasahitz28','22334488V'),(29,'Oier','Lezama','Lezama Kalea 29','oilez','pasahitz29','66558877W'),(30,'Ainhoa','Beitia','Beheko Kalea 30','ainbeit','pasahitz30','66589789M');
/*!40000 ALTER TABLE `langilea` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-27  8:43:45
