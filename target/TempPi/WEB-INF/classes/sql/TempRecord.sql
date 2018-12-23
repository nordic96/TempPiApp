CREATE TABLE `TempRecord` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `rec_year` int(4) DEFAULT NULL,
  `rec_month` int(2) DEFAULT NULL,
  `rec_date` int(2) DEFAULT NULL,
  `rec_time` time DEFAULT NULL,
  `temp` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=611 DEFAULT CHARSET=utf8mb4;

