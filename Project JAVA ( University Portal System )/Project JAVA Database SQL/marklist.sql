-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 27, 2017 at 01:10 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `imran`
--

-- --------------------------------------------------------

--
-- Table structure for table `marklist`
--

CREATE TABLE `marklist` (
  `Marks` varchar(20) NOT NULL,
  `Grades` varchar(10) NOT NULL,
  `Grade Points` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marklist`
--

INSERT INTO `marklist` (`Marks`, `Grades`, `Grade Points`) VALUES
('90-100', 'A+', 4.00),
('85-90', 'A', 3.75),
('80-85', 'B+', 3.50),
('75-80', 'B', 3.25),
('70-75', 'C+', 3.00),
('60-65', 'D+', 2.50),
('50-60', 'D', 2.25),
('< 50', 'F', 0.00),
('Incomplete', 'I', 0.00),
('Withdrawal', 'W', 0.00),
('UnofficiallyWithdraw', 'UW', 0.00);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
