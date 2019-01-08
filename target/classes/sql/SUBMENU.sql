CREATE TABLE `SUBMENU` (
  `SUB_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUB_NAME` tinytext,
  `CONTEXT` tinytext,
  `MENU_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SUB_ID`),
  KEY `MENU_ID` (`MENU_ID`),
  CONSTRAINT `SUBMENU_ibfk_1` FOREIGN KEY (`MENU_ID`) REFERENCES `MENU` (`MENU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
