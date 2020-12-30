-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 27 Avril 2018 à 17:05
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `javaproject`
--
CREATE DATABASE IF NOT EXISTS `javaproject` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `javaproject`;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `idCat` int(11) NOT NULL AUTO_INCREMENT,
  `libCat` varchar(150) NOT NULL,
  PRIMARY KEY (`idCat`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`idCat`, `libCat`) VALUES
(1, 'agro-alimentaire'),
(3, 'Commerce'),
(5, 'Medical'),
(8, 'Agricole');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `idCl` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `adresse` varchar(150) NOT NULL,
  `tel` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`idCl`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `idcmd` int(11) NOT NULL AUTO_INCREMENT,
  `qteD` int(11) NOT NULL,
  `pu` int(11) NOT NULL,
  `dateCmd` date NOT NULL,
  `idCl` int(11) NOT NULL,
  `idprod` int(11) NOT NULL,
  PRIMARY KEY (`idcmd`),
  KEY `idCl` (`idCl`),
  KEY `idprod` (`idprod`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `idprod` int(11) NOT NULL AUTO_INCREMENT,
  `libProd` varchar(55) NOT NULL,
  `Qte` int(11) NOT NULL,
  `Prix` int(11) NOT NULL,
  `idCat` int(11) NOT NULL,
  PRIMARY KEY (`idprod`),
  KEY `idCat` (`idCat`),
  KEY `idCat_2` (`idCat`),
  KEY `idCat_3` (`idCat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  ` nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `Login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`idUser`, ` nom`, `prenom`, `Login`, `password`) VALUES
(1, 'DOUCOURE', 'Moustapha', 'elmoustapha', 'passer'),
(2, 'DIEYE', 'Elgo', 'admin1', 'passer1');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`idCl`) REFERENCES `client` (`idCl`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`idprod`) REFERENCES `produit` (`idprod`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`idCat`) REFERENCES `categorie` (`idCat`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
