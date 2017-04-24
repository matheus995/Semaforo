-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23-Abr-2017 às 03:22
-- Versão do servidor: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `semaforo`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `ruas`
--

CREATE TABLE `ruas` (
  `p1` int(11) NOT NULL DEFAULT '0',
  `p2` int(11) NOT NULL DEFAULT '0',
  `p3` int(11) NOT NULL DEFAULT '0',
  `p4` int(11) NOT NULL DEFAULT '0',
  `a1` int(11) NOT NULL DEFAULT '0',
  `a2` int(11) NOT NULL DEFAULT '0',
  `a3` int(11) NOT NULL DEFAULT '0',
  `i1` int(11) NOT NULL DEFAULT '0',
  `i2` int(11) NOT NULL DEFAULT '0',
  `i3` int(11) NOT NULL DEFAULT '0',
  `b1` int(11) NOT NULL DEFAULT '0',
  `b2` int(11) NOT NULL DEFAULT '0',
  `c1` int(11) NOT NULL DEFAULT '0',
  `c2` int(11) NOT NULL DEFAULT '0',
  `g1` int(11) NOT NULL DEFAULT '0',
  `g2` int(11) NOT NULL DEFAULT '0',
  `g3` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `ruas`
--

INSERT INTO `ruas` (`p1`, `p2`, `p3`, `p4`, `a1`, `a2`, `a3`, `i1`, `i2`, `i3`, `b1`, `b2`, `c1`, `c2`, `g1`, `g2`, `g3`) VALUES
(11, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `s1`
--

CREATE TABLE `s1` (
  `tempoverde` int(11) DEFAULT NULL,
  `tempoamarelo` int(11) DEFAULT NULL,
  `tempovermelho` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `s1`
--

INSERT INTO `s1` (`tempoverde`, `tempoamarelo`, `tempovermelho`) VALUES
(27, 2, 33);

-- --------------------------------------------------------

--
-- Estrutura da tabela `s2`
--

CREATE TABLE `s2` (
  `tempoverde` int(11) DEFAULT NULL,
  `tempoamarelo` int(11) DEFAULT NULL,
  `tempovermelho` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `s2`
--

INSERT INTO `s2` (`tempoverde`, `tempoamarelo`, `tempovermelho`) VALUES
(33, 2, 27);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
