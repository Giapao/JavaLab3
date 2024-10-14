
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


CREATE TABLE `manufacture` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(128) NOT NULL,
  `Location` varchar(128) NOT NULL,
  `Employee` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `manufacture` (`ID`, `Name`, `Location`, `Employee`) VALUES
('1', 'Nguyễn Gia Bảo', 'Lê Văn Lương, Q7', 10),
('2', 'Hồ Anh Nhân', 'CMT T8, Q1', 0),
('3', 'Nguyễn Trung Nghĩa', 'Nguyễn Hữu Thọ, Nhà Bè', 0);


CREATE TABLE `mobilephone` (
  `ID` varchar(10) NOT NULL,
  `Name` varchar(128) NOT NULL,
  `Price` int(11) NOT NULL,
  `color` varchar(10) NOT NULL,
  `Country` varchar(10) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `manufacture_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `mobilephone` (`ID`, `Name`, `Price`, `color`, `Country`, `Quantity`, `manufacture_id`) VALUES
('1', 'Iphone 11', 90000, 'black', 'VN', 2, 1),
('2', 'Xiaomi 10', 5000, 'pink', 'VN', 2, 1),
('3', 'Samsung S22', 9000, 'red', 'KR', 1, 1),
('4', 'LG G6', 5000, 'blue', 'KR', 1, 1),
('5', 'Oppo F3', 1233, 'black', 'CN', 5, 1);


ALTER TABLE `mobilephone`
  ADD PRIMARY KEY (`ID`);
COMMIT;


