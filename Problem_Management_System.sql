-- MySQL dump 10.13  Distrib 5.7.15, for Win64 (x86_64)
--
-- Host: localhost    Database: Problem_Management_System
-- ------------------------------------------------------
-- Server version	5.7.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` varchar(15) NOT NULL,
  `pid` varchar(15) NOT NULL,
  `date` date NOT NULL,
  KEY `id` (`id`),
  KEY `pid` (`pid`),
  CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`),
  CONSTRAINT `answer_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `problem` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classictest`
--

DROP TABLE IF EXISTS `classictest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classictest` (
  `ctid` varchar(15) NOT NULL,
  `pid` varchar(15) NOT NULL,
  PRIMARY KEY (`ctid`),
  KEY `pid` (`pid`),
  CONSTRAINT `classictest_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `problem` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classictest`
--

LOCK TABLES `classictest` WRITE;
/*!40000 ALTER TABLE `classictest` DISABLE KEYS */;
/*!40000 ALTER TABLE `classictest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprise1`
--

DROP TABLE IF EXISTS `comprise1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprise1` (
  `pid` varchar(15) NOT NULL,
  `tid` varchar(15) NOT NULL,
  KEY `pid` (`pid`),
  CONSTRAINT `comprise1_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `problem` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprise1`
--

LOCK TABLES `comprise1` WRITE;
/*!40000 ALTER TABLE `comprise1` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprise1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprise2`
--

DROP TABLE IF EXISTS `comprise2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprise2` (
  `pid` varchar(15) NOT NULL,
  `ctid` varchar(15) NOT NULL,
  KEY `pid` (`pid`),
  KEY `ctid` (`ctid`),
  CONSTRAINT `comprise2_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `problem` (`pid`),
  CONSTRAINT `comprise2_ibfk_2` FOREIGN KEY (`ctid`) REFERENCES `classictest` (`ctid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprise2`
--

LOCK TABLES `comprise2` WRITE;
/*!40000 ALTER TABLE `comprise2` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprise2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `cid` char(8) NOT NULL,
  `cname` varchar(50) NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('AL******','All'),('WL21001*','AdvancedMathematics'),('WY110011','ENGLISH1');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deleteduser`
--

DROP TABLE IF EXISTS `deleteduser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deleteduser` (
  `id` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `joinTime` date NOT NULL,
  `name` varchar(15) NOT NULL,
  `authority` char(1) NOT NULL,
  `handleId` varchar(15) NOT NULL,
  `deleteTime` date NOT NULL,
  PRIMARY KEY (`id`,`deleteTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deleteduser`
--

LOCK TABLES `deleteduser` WRITE;
/*!40000 ALTER TABLE `deleteduser` DISABLE KEYS */;
INSERT INTO `deleteduser` VALUES ('User_4','user4','2016-10-25','用户4','B','Admin','2016-12-13'),('User_5','user5','2016-10-31','用户5','B','Admin','2016-12-13'),('User_6','aaa','2016-10-31','aaa','B','Admin','2016-12-13');
/*!40000 ALTER TABLE `deleteduser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genxin`
--

DROP TABLE IF EXISTS `genxin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genxin` (
  `administratorId` varchar(15) NOT NULL,
  `pid` varchar(15) NOT NULL,
  `date` date NOT NULL,
  KEY `pid` (`pid`),
  KEY `administratorId` (`administratorId`),
  CONSTRAINT `genxin_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `problem` (`pid`),
  CONSTRAINT `genxin_ibfk_2` FOREIGN KEY (`administratorId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genxin`
--

LOCK TABLES `genxin` WRITE;
/*!40000 ALTER TABLE `genxin` DISABLE KEYS */;
/*!40000 ALTER TABLE `genxin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problem`
--

DROP TABLE IF EXISTS `problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `problem` (
  `pid` varchar(15) NOT NULL,
  `classification` varchar(50) NOT NULL,
  `faculty` varchar(50) NOT NULL,
  `subject` varchar(50) NOT NULL,
  `question` varchar(15) NOT NULL,
  `difficulty` char(1) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problem`
--

LOCK TABLES `problem` WRITE;
/*!40000 ALTER TABLE `problem` DISABLE KEYS */;
INSERT INTO `problem` VALUES ('ADMATH0001','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','1'),('ADMATH0002','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','1'),('ADMATH0003','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','1'),('ADMATH0004','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','1'),('ADMATH0005','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','1'),('ADMATH0006','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','2'),('ADMATH0007','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','2'),('ADMATH0008','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','2'),('ADMATH0009','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','2'),('ADMATH0010','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','Proof','3'),('ADMATH0011','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','1'),('ADMATH0012','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','1'),('ADMATH0013','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','1'),('ADMATH0014','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','1'),('ADMATH0015','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','1'),('ADMATH0016','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','2'),('ADMATH0017','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','2'),('ADMATH0018','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','2'),('ADMATH0019','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','FillBlank','2'),('ADMATH0020','NaturalScience','MathematicsAndAppliedMathematics','AdvancedMathematics','Proof','3'),('ENGLISH0001','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0002','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0003','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0004','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0005','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0006','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0007','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0008','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0009','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0010','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0011','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0012','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0013','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0014','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0015','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0016','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0017','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0018','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0019','Literature','ENGLISH','ENGLISH1','Choice','1'),('ENGLISH0020','Literature','ENGLISH','ENGLISH1','Choice','1');
/*!40000 ALTER TABLE `problem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relation`
--

DROP TABLE IF EXISTS `relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relation` (
  `pid1` varchar(15) NOT NULL,
  `pid2` varchar(15) NOT NULL,
  `relationLevel` char(1) DEFAULT NULL,
  KEY `pid1` (`pid1`),
  KEY `pid2` (`pid2`),
  CONSTRAINT `relation_ibfk_1` FOREIGN KEY (`pid1`) REFERENCES `problem` (`pid`),
  CONSTRAINT `relation_ibfk_2` FOREIGN KEY (`pid2`) REFERENCES `problem` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relation`
--

LOCK TABLES `relation` WRITE;
/*!40000 ALTER TABLE `relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trolley`
--

DROP TABLE IF EXISTS `trolley`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trolley` (
  `id` varchar(15) NOT NULL,
  `pid` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trolley`
--

LOCK TABLES `trolley` WRITE;
/*!40000 ALTER TABLE `trolley` DISABLE KEYS */;
INSERT INTO `trolley` VALUES ('3','ADMATH0001'),('3','ADMATH0002'),('3','ADMATH0003'),('3','ADMATH0004'),('3','ADMATH0005'),('3','ADMATH0006'),('3','ADMATH0007'),('3','ADMATH0008'),('3','ADMATH0009'),('3','ADMATH0013'),('3','ENGLISH0001'),('3','ENGLISH0002'),('3','ENGLISH0003'),('3','ENGLISH0005'),('3','ENGLISH0007'),('3','ENGLISH0009'),('User','ADMATH0013'),('User','ADMATH0014'),('User','ADMATH0017'),('3','ENGLISH0006'),('3','ENGLISH0004'),('3','ENGLISH0008'),('Admin1','ADMATH0001'),('Admin1','ADMATH0002'),('Admin1','ADMATH0003'),('Admin','ADMATH0001'),('Admin','ADMATH0003'),('Admin','ADMATH0004'),('Admin','ADMATH0005'),('Admin','ADMATH0007'),('Admin','ADMATH0008'),('Admin','ADMATH0009'),('Admin','ADMATH0012'),('Admin','ADMATH0014');
/*!40000 ALTER TABLE `trolley` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `joinTime` date NOT NULL,
  `name` varchar(15) NOT NULL,
  `authority` char(1) NOT NULL,
  `online` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1111','111111','2016-11-01','1111','B',NULL),('1223322','23','2016-12-13','123','B',NULL),('aaaa','ffff','2016-11-01','aaa','B',NULL),('Admin','admin','2016-10-14','管理员','A',1),('Admin1','admin1','2016-12-13','管理员','A',0),('ggggg','ggg','2016-11-01','ggg','B',NULL),('hjhg','hhhk','2016-12-13','ffgj','B',NULL),('lawrence','123','2016-12-13','lawrence','B',0),('qqqqq','qqq','2016-11-01','qqqq','B',NULL),('User_2','user2','2016-10-22','用户2','B',NULL),('User_3','user3','2016-10-22','用户3','B',NULL),('weer','etrttyy','2016-12-13','Werrt','B',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usersdocument`
--

DROP TABLE IF EXISTS `usersdocument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usersdocument` (
  `did` varchar(15) NOT NULL,
  `pid` varchar(15) NOT NULL,
  `ctid` varchar(15) NOT NULL,
  `package` varchar(15) NOT NULL,
  KEY `pid` (`pid`),
  KEY `ctid` (`ctid`),
  CONSTRAINT `usersdocument_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `problem` (`pid`),
  CONSTRAINT `usersdocument_ibfk_2` FOREIGN KEY (`ctid`) REFERENCES `classictest` (`ctid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usersdocument`
--

LOCK TABLES `usersdocument` WRITE;
/*!40000 ALTER TABLE `usersdocument` DISABLE KEYS */;
/*!40000 ALTER TABLE `usersdocument` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-20 23:11:23
