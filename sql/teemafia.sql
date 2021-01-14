-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 14. Jan 2021 um 13:53
-- Server-Version: 10.4.11-MariaDB
-- PHP-Version: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `teemafia`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `tblblueprint`
--

CREATE TABLE `tblblueprint` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `tblblueprint`
--

INSERT INTO `tblblueprint` (`ID`, `Name`) VALUES
(4, 'hk16');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `tblblueprintpart`
--

CREATE TABLE `tblblueprintpart` (
  `ID` int(11) NOT NULL,
  `BlueprintID` int(11) NOT NULL,
  `WeaponpartID` int(11) NOT NULL,
  `Amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `tblblueprintpart`
--

INSERT INTO `tblblueprintpart` (`ID`, `BlueprintID`, `WeaponpartID`, `Amount`) VALUES
(2, 4, 4, 66),
(4, 4, 6, 66),
(5, 4, 3, 66);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `tbluser`
--

CREATE TABLE `tbluser` (
  `ID` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Rank` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `tbluser`
--

INSERT INTO `tbluser` (`ID`, `Username`, `Password`, `Rank`) VALUES
(1, 'a', 'a', '');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `tblweaponparts`
--

CREATE TABLE `tblweaponparts` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `tblweaponparts`
--

INSERT INTO `tblweaponparts` (`ID`, `Name`) VALUES
(1, 'Waffenteil'),
(2, 'Mechanische Teile'),
(3, 'Anbauteil'),
(4, 'Hochwertige Waffenteil'),
(5, 'Hochwertige Mechanische Teile'),
(6, 'Hochwertige Anbauteil');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `tblblueprint`
--
ALTER TABLE `tblblueprint`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `tblblueprintpart`
--
ALTER TABLE `tblblueprintpart`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `tbluser`
--
ALTER TABLE `tbluser`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `tblweaponparts`
--
ALTER TABLE `tblweaponparts`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `tblblueprint`
--
ALTER TABLE `tblblueprint`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `tblblueprintpart`
--
ALTER TABLE `tblblueprintpart`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT für Tabelle `tbluser`
--
ALTER TABLE `tbluser`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `tblweaponparts`
--
ALTER TABLE `tblweaponparts`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
