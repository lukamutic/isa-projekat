-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 07, 2023 at 03:00 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `students_ads_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `ad`
--

CREATE TABLE `ad` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `ad`
--

INSERT INTO `ad` (`id`, `user_id`, `category_id`, `date`, `title`, `description`, `price`, `active`) VALUES
(11, 2, 2, '2023-06-01', 'Traim cimera', 'Poeljno sa TF', '0.00', 0),
(13, 2, 1, '2023-05-30', 'Traim cimera', 'Potreban cimer, poeljno sa Tehni&#269;kog fakulteta.', '0.00', 0),
(16, 2, 3, '2023-06-01', '&#268;asovi iz matematike', 'Primprema za polaganje matematika na svim fakultetima.', '1000.00', 0),
(19, 2, 4, '2023-06-12', 'aomi x150', 'O&#269;uvan telefon, ispravan.', '100.00', 0),
(24, 2, 1, '2023-06-13', 'Traim cimera', '', '500.00', 0),
(44, 2, 3, '2023-06-01', '&#268;asovi iz programiranja', 'Drim &#269;asove iz: osnova programiranja i objektnog programiranja za sve fakultete.', '1500.00', 0),
(45, 2, 4, '2023-06-14', 'Punja&#269; za telefon', 'Odli&#269;an punja&#269;, o&#269;uvan.', '250.00', 0),
(46, 3, 3, '2023-08-25', '&#268;asovi iz matematike', 'Povoljno.', '999.00', 0),
(48, 2, 5, '2023-09-13', 'Prodajem cimerov komp', 'Pourite dok se cimer ne vrati sa mora!\r\n\r\n', '300.00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Knjige'),
(2, 'Smetaj'),
(3, 'Podu&#269;avanje'),
(4, 'Telefoni i oprema'),
(5, 'Ra&#269;unari i oprema'),
(6, 'Ostalo'),
(29, 'Ode&#263;a');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `phone`, `email`, `password`, `role`, `active`) VALUES
(2, 'Vladimir', '0691316837', 'vlado@test.com', 'vlado', 'user', 0),
(3, 'Miki', '0638513283', 'miki@exampleloremipsum.com', 'bilja', NULL, 0),
(6, 'Vasilije', '0632784545', 'vaso@test.com', 'vaso', NULL, 0),
(7, 'Luka Mutic', '0692784544', 'lukamuticxy@gmail.com', 'luka', 'admin', 1),
(8, 'petar', '0692784545', 'petar@test.com', 'petar', 'user', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ad`
--
ALTER TABLE `ad`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ad`
--
ALTER TABLE `ad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
