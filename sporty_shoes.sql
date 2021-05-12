-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2021 at 05:09 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sporty_shoes`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `picture` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `picture`) VALUES
(1, 'Sports', 'na'),
(2, 'Casual', 'na'),
(6, 'Stylish', 'na'),
(7, 'Party wear', 'na');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(19);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `purchase_date` datetime DEFAULT NULL,
  `products_id` int(11) DEFAULT NULL,
  `sporty_shoes_user_details_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `picture1` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `description`, `name`, `picture1`, `price`, `category_id`) VALUES
(17, 'product 1 description', 'product 1', 'https://images.unsplash.com/photo-1460353581641-37baddab0fa2?ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8c2hvZXN8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80', 1504, 6),
(2, 'product 2 description', 'Product 2', 'https://assets.ajio.com/medias/sys_master/root/h0e/h57/14092954894366/-473Wx593H-460455972-black-MODEL.jpg', 5000, 2),
(3, 'product 3 description', 'Product 3', 'https://images-eu.ssl-images-amazon.com/images/I/41Leu3gBUFL.jpg', 1200, 2),
(4, 'product 4 description', 'Product 4', 'https://cdn.vox-cdn.com/thumbor/S4ka2uwWyJ9rHJFDwVa8BQCqMHA=/1400x788/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22406771/Exbfpl2WgAAQkl8_resized.jpeg', 4220, 2),
(18, 'product 5 description', 'Product 5', 'https://image.cnbcfm.com/api/v1/image/105680013-1547583426762nike1.jpg?v=1547583682&w=678&h=381', 4000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `shopping_cart`
--

CREATE TABLE `shopping_cart` (
  `sporty_shoes_user_details_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `shopping_cart_product_details`
--

CREATE TABLE `shopping_cart_product_details` (
  `shopping_cart_sporty_shoes_user_details_id` int(11) NOT NULL,
  `product_details_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `shopping_cart_sporty_shoes_user_details`
--

CREATE TABLE `shopping_cart_sporty_shoes_user_details` (
  `shopping_cart_id` int(11) NOT NULL,
  `sporty_shoes_user_details_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `sporty_shoes_user_details`
--

CREATE TABLE `sporty_shoes_user_details` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `is_admin` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sporty_shoes_user_details`
--

INSERT INTO `sporty_shoes_user_details` (`id`, `email`, `is_admin`, `password`, `username`) VALUES
(1, 'admin@admin.com', b'1', 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_46ccwnsi9409t36lurvtyljak` (`name`) USING HASH;

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1gb3bxe4u93n4cd7ptoq3e3ax` (`products_id`),
  ADD KEY `FK61tsp7njjokrb68w9b59v92n8` (`sporty_shoes_user_details_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);

--
-- Indexes for table `shopping_cart`
--
ALTER TABLE `shopping_cart`
  ADD PRIMARY KEY (`sporty_shoes_user_details_id`);

--
-- Indexes for table `shopping_cart_product_details`
--
ALTER TABLE `shopping_cart_product_details`
  ADD PRIMARY KEY (`shopping_cart_sporty_shoes_user_details_id`,`product_details_id`),
  ADD KEY `FKq3ll0qjs651fojc7rvwinfvc4` (`product_details_id`);

--
-- Indexes for table `shopping_cart_sporty_shoes_user_details`
--
ALTER TABLE `shopping_cart_sporty_shoes_user_details`
  ADD PRIMARY KEY (`shopping_cart_id`,`sporty_shoes_user_details_id`),
  ADD KEY `FKdxv7m3ucffaiexe785qu6cu2b` (`sporty_shoes_user_details_id`);

--
-- Indexes for table `sporty_shoes_user_details`
--
ALTER TABLE `sporty_shoes_user_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_dfbb85ntdyftn621gjrg8q9vs` (`email`) USING HASH,
  ADD UNIQUE KEY `UK_rupkxfv65gofnkwss6tbovct1` (`username`) USING HASH;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
