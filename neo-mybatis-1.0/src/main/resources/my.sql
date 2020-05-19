CREATE TABLE `blog` (
  `bid` int NOT NULL,
  `author_id` int DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;