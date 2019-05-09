-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 26, 2017 at 11:27 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

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
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Name` varchar(50) NOT NULL,
  `ID` int(20) NOT NULL,
  `Password` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Name`, `ID`, `Password`) VALUES
('Parvez', 1000, 500),
('Nihal', 2000, 600);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `Name` varchar(50) NOT NULL,
  `ID` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`Name`, `ID`) VALUES
('OOP1', 1),
('OOP2', 2),
('OOAD', 3),
('COMPUTER NETWORK', 4),
('PHYSICS', 5),
('ENGLISH READING', 6),
('DIFF CALCULUS', 7),
('COMPUTER FUNDAMENTALS', 8),
('DC', 9),
('INTEGRAL CALCULUS', 10),
('DISCRETE MATH', 11),
('AC', 12),
('ECONOMICS', 13),
('COMPLEX VARIABLE', 14),
('DATA STRACTURE', 15),
('DATABASE', 16),
('ALGORITHMS', 17),
('ARTIFICIAL INTELLIGENCE', 18),
('OPERATING SYSTEM', 19),
('SOFTWARE ENGINEERING', 20),
('THEORY OF COMPUTATION', 21),
('WEB TECHNILOGIES', 22),
('CS MATH', 23),
('HUMAN COMPUTER INTERACTION', 24),
('DATA WAREHOUSING AND DATA MINING ', 25),
('SOFTWARE QUALITY AND TESTING', 26),
('CONTROL SYSTEM', 27),
('COMPUTER GRAPHICS', 28),
('RESEARCH METHODOLOGY', 29),
('CHEMISTRY', 30),
('COMPUTER VISION AND PATTERN RECOGNITION', 31),
('E-GOVERNANCE', 32),
('MATHEMATICAL METHODS OF ENGINEERING', 33),
('MATRICES, VECTORS, FOURIER ANALYSIS', 34),
('STATISTICS AND PROBABILITY', 35),
('REMEDIAL MATHEMATICS', 36),
('MODERN PHYSICS', 37),
('ENTREPRENEURSHIP DEVELOPMENT ', 38),
('GLOBAL TRADE', 39),
('RINCIPLES OF MANAGEMENT', 40);

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `Name` varchar(50) NOT NULL,
  `ID` int(20) NOT NULL,
  `Department` varchar(10) NOT NULL,
  `Password` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`Name`, `ID`, `Department`, `Password`) VALUES
('Abir', 100, 'CSE', 123),
('Rifat', 200, 'CSE', 1234);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Name` varchar(50) NOT NULL,
  `ID` int(20) NOT NULL,
  `Department` varchar(10) NOT NULL,
  `Password` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Name`, `ID`, `Department`, `Password`) VALUES
('Tawhid', 10, 'CSE', 111),
('Eman', 20, 'CSE', 112),
('Imran', 30, 'CSE', 113);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD UNIQUE KEY `ID` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
