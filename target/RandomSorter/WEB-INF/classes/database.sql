CREATE DATABASE `random` /*!40100 DEFAULT CHARACTER SET utf8 */;

DROP TABLE IF EXISTS `random`.`SORT_TBL`;
CREATE TABLE `random`.`SORT_TBL` (
`id` int(11) NOT NULL AUTO_INCREMENT, 
`givenString` varchar(100) NOT NULL, 
`positions` varchar(100) NOT NULL, 
`resultString` varchar(100) NOT NULL, 
`expendedTime` VARCHAR(25) NOT NULL, 
PRIMARY KEY (`id`) ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;