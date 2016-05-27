-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Tempo de geração: 27/05/2016 às 02:03
-- Versão do servidor: 10.1.13-MariaDB
-- Versão do PHP: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `easter`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `comment`
--

CREATE TABLE `comment` (
  `idComment` int(11) NOT NULL,
  `text` longtext NOT NULL,
  `date` date NOT NULL,
  `qtyLikes` int(11) NOT NULL DEFAULT '0',
  `idAuthor` int(11) NOT NULL,
  `qtyDislikes` int(11) NOT NULL DEFAULT '0',
  `idEasterEgg` int(11) NOT NULL,
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `comment`
--

INSERT INTO `comment` (`idComment`, `text`, `date`, `qtyLikes`, `idAuthor`, `qtyDislikes`, `idEasterEgg`, `createdAt`) VALUES
(1, 'nunca iria imaginar LOL ', '2016-04-06', 0, 8, 0, 5, '2016-05-15 20:46:13'),
(2, 'legal!', '2016-05-09', 5, 16, 4, 8, '2016-05-17 07:34:18');

-- --------------------------------------------------------

--
-- Estrutura para tabela `commentMedia`
--

CREATE TABLE `commentMedia` (
  `idCommentMedia` int(11) NOT NULL,
  `text` longtext NOT NULL,
  `date` date NOT NULL,
  `qtyLikes` int(11) NOT NULL DEFAULT '0',
  `idAuthor` int(11) NOT NULL,
  `qtyDislikes` int(11) NOT NULL DEFAULT '0',
  `idMedia` int(11) NOT NULL,
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `easteregg`
--

CREATE TABLE `easteregg` (
  `idEasterEgg` int(11) NOT NULL,
  `description` longtext NOT NULL,
  `imageUrl` varchar(45) DEFAULT NULL,
  `idMedia` int(11) NOT NULL,
  `idWritter` int(11) NOT NULL,
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `easteregg`
--

INSERT INTO `easteregg` (`idEasterEgg`, `description`, `imageUrl`, `idMedia`, `idWritter`, `createdAt`) VALUES
(1, 'finalAeon', NULL, 3, 1, '2016-05-01 00:00:00'),
(2, 'professor xavier', NULL, 1, 1, '2016-05-01 00:00:00'),
(3, 'x-men kk', NULL, 1, 8, '2016-05-01 00:00:00'),
(4, 'teste', NULL, 6, 8, '2016-05-01 00:00:00'),
(5, 'vencendo  o homem formiga', NULL, 6, 11, '2016-05-01 00:00:00'),
(6, 'Emboscada secreta - Missão #4', NULL, 8, 11, '2016-05-15 17:34:16'),
(7, 'Luta Secreta - Raiden', NULL, 9, 1, '2016-05-02 19:45:30'),
(8, 'Aparição do Stan Lee - Boate', NULL, 1, 11, '2016-05-17 06:29:20'),
(9, 'Cena da explosão - Quicksilver', NULL, 11, 8, '2016-05-03 06:36:12');

-- --------------------------------------------------------

--
-- Estrutura para tabela `evaluatedcomment`
--

CREATE TABLE `evaluatedcomment` (
  `Comment_idComment` int(11) NOT NULL,
  `User_idUser` int(11) NOT NULL,
  `evaluate` tinyint(1) NOT NULL,
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura para tabela `evaluatedeasteregg`
--

CREATE TABLE `evaluatedeasteregg` (
  `EasterEgg_idEasterEgg` int(11) NOT NULL,
  `User_idUser` int(11) NOT NULL,
  `score` float NOT NULL,
  `createdAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `evaluatedeasteregg`
--

INSERT INTO `evaluatedeasteregg` (`EasterEgg_idEasterEgg`, `User_idUser`, `score`, `createdAt`) VALUES
(1, 1, 4, '2016-05-01 22:34:39'),
(1, 8, 4, '2016-05-01 22:35:43'),
(1, 11, 3, '2016-05-21 21:46:09'),
(2, 1, 2, '2016-05-01 22:34:56'),
(2, 8, 3, '2016-05-01 22:35:37'),
(2, 11, 4, '2016-05-21 21:46:05'),
(3, 1, 1, '2016-05-21 21:53:42'),
(3, 8, 2, '2016-05-21 21:55:02'),
(3, 11, 1, '2016-05-21 21:52:21'),
(4, 1, 2, '2016-05-21 21:53:19'),
(4, 8, 4, '2016-05-21 21:55:24'),
(4, 11, 4, '2016-05-21 21:52:38'),
(5, 1, 3, '2016-05-21 21:43:43'),
(5, 8, 1, '2016-05-21 21:45:40'),
(5, 11, 3, '2016-05-21 21:45:58');

-- --------------------------------------------------------

--
-- Estrutura para tabela `fallowedeasteregg`
--

CREATE TABLE `fallowedeasteregg` (
  `User_idUser` int(11) NOT NULL,
  `EasterEgg_idEasterEgg` int(11) NOT NULL,
  `status` float NOT NULL DEFAULT '0',
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `fallowedeasteregg`
--

INSERT INTO `fallowedeasteregg` (`User_idUser`, `EasterEgg_idEasterEgg`, `status`, `createdAt`) VALUES
(8, 1, 0, '2016-05-02 00:17:42'),
(8, 2, 0, '2016-05-02 00:08:06');

-- --------------------------------------------------------

--
-- Estrutura para tabela `fallowedmedia`
--

CREATE TABLE `fallowedmedia` (
  `User_idUser` int(11) NOT NULL,
  `Media_idMedia` int(11) NOT NULL,
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `fallowedmedia`
--

INSERT INTO `fallowedmedia` (`User_idUser`, `Media_idMedia`, `createdAt`) VALUES
(8, 1, '2016-05-02 00:05:59'),
(8, 2, '2016-05-02 00:16:28'),
(8, 3, '2016-05-02 00:17:42');

-- --------------------------------------------------------

--
-- Estrutura para tabela `fallowedtask`
--

CREATE TABLE `fallowedtask` (
  `idTask` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `status` double NOT NULL DEFAULT '0',
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `fallowedtask`
--

INSERT INTO `fallowedtask` (`idTask`, `idUser`, `status`, `createdAt`) VALUES
(4, 8, 0, '2016-05-02 00:25:40'),
(5, 8, 0, '2016-05-02 00:25:40'),
(6, 8, 0, '2016-05-02 00:25:40');

-- --------------------------------------------------------

--
-- Estrutura para tabela `media`
--

CREATE TABLE `media` (
  `idMedia` int(11) NOT NULL,
  `title` varchar(105) NOT NULL,
  `category` varchar(45) NOT NULL,
  `image` varchar(250) DEFAULT NULL,
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `media`
--

INSERT INTO `media` (`idMedia`, `title`, `category`, `image`, `createdAt`) VALUES
(1, 'deadpool', 'Movies', NULL, '0000-00-00 00:00:00'),
(2, 'x-men 3', 'Movies', NULL, '0000-00-00 00:00:00'),
(3, 'final fantasy', 'Games', NULL, '0000-00-00 00:00:00'),
(4, 'harry potter', 'Books', NULL, '0000-00-00 00:00:00'),
(6, 'guerra civil', 'Movies', NULL, '0000-00-00 00:00:00'),
(7, 'o império contra ataca', 'Movies', NULL, '0000-00-00 00:00:00'),
(8, 'Call of Duty', 'Games', NULL, '2016-05-26 05:06:12'),
(9, 'mortal kombat', 'Games', NULL, '2016-05-15 13:17:06'),
(10, 'Harry Potter', 'Books', NULL, '2016-05-08 07:00:00'),
(11, 'X-men: Apocalipse', 'Movies', NULL, '2016-05-09 11:14:35'),
(12, 'The Walking Dead', 'Tv Shows', NULL, '2016-05-16 05:23:39'),
(13, 'Game of Thrones', 'Tv Shows', NULL, '2016-05-17 04:31:15');

-- --------------------------------------------------------

--
-- Estrutura para tabela `reference`
--

CREATE TABLE `reference` (
  `EasterEgg_idEasterEgg` int(11) NOT NULL,
  `Media_idMedia` int(11) NOT NULL,
  `createdAt` datetime NOT NULL,
  `title` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `reference`
--

INSERT INTO `reference` (`EasterEgg_idEasterEgg`, `Media_idMedia`, `createdAt`, `title`) VALUES
(2, 2, '2016-05-01 18:41:42', NULL),
(5, 7, '2016-05-15 17:15:01', 'Pernas do robô');

-- --------------------------------------------------------

--
-- Estrutura para tabela `task`
--

CREATE TABLE `task` (
  `idTask` int(11) NOT NULL,
  `description` longtext,
  `EasterEgg_idEasterEgg` int(11) NOT NULL,
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `task`
--

INSERT INTO `task` (`idTask`, `description`, `EasterEgg_idEasterEgg`, `createdAt`) VALUES
(4, 'paco 1', 1, '2016-05-01 18:41:42'),
(5, 'paco 2', 1, '2016-05-01 18:41:42'),
(6, 'paco 3', 1, '2016-05-01 18:41:42');

-- --------------------------------------------------------

--
-- Estrutura para tabela `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `acessTokenFacebook` varchar(100) DEFAULT NULL,
  `userName` varchar(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(25) DEFAULT NULL,
  `imageUrl` varchar(250) DEFAULT NULL,
  `email` varchar(55) NOT NULL,
  `profileName` varchar(250) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  `createdAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `user`
--

INSERT INTO `user` (`idUser`, `acessTokenFacebook`, `userName`, `age`, `gender`, `imageUrl`, `email`, `profileName`, `password`, `createdAt`) VALUES
(1, NULL, 'icaroribeiro', 20, 'Male', '', 'icaro_felipe@hotmail.com', 'Icaro Ribeiro', '123', '2016-05-01 00:00:00'),
(8, NULL, 'icarofelipe', 20, 'Male', 'abcde', 'icarofeliperibeiro@gmail.com', 'Icaro Ribeiro', '123', '2016-05-01 00:00:00'),
(11, 'abcde', 'icaro.ribeiro13', 20, 'Male', '', 'icarofeliperibeiro@gmail.com', 'Icaro Ribeiro', NULL, '2016-05-15 15:59:57'),
(12, NULL, 'neto', 1, 'M', NULL, 'jneto@email.com', 'Neto', '123', '2016-05-02 15:19:35'),
(13, NULL, 'francois', 2, 'M', NULL, 'francois@email.com', 'François', '123', '2016-05-23 04:21:10'),
(16, NULL, 'a', 1, 'm', NULL, 'a@a.com', 'a', '1', '2016-05-06 07:33:32'),
(17, NULL, 'guilherme', 3, 'm', NULL, 'guilherme@email.com', 'Guilherme', '123', '2016-05-29 04:27:40');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`idComment`),
  ADD KEY `fk_Comentario_EasterEgg1_idx` (`idEasterEgg`),
  ADD KEY `fk_idUser_idx` (`idAuthor`);

--
-- Índices de tabela `commentMedia`
--
ALTER TABLE `commentMedia`
  ADD PRIMARY KEY (`idCommentMedia`),
  ADD KEY `fk_Comentario_idMedia_idx` (`idMedia`),
  ADD KEY `fk_idUser2_idx` (`idAuthor`);

--
-- Índices de tabela `easteregg`
--
ALTER TABLE `easteregg`
  ADD PRIMARY KEY (`idEasterEgg`),
  ADD KEY `fk_EasterEgg_Obra1_idx` (`idMedia`),
  ADD KEY `fk_EasterEgg_Usuario1_idx` (`idWritter`);

--
-- Índices de tabela `evaluatedcomment`
--
ALTER TABLE `evaluatedcomment`
  ADD PRIMARY KEY (`Comment_idComment`,`User_idUser`),
  ADD KEY `fk_Comentario_has_Usuario_Usuario1_idx` (`User_idUser`),
  ADD KEY `fk_Comentario_has_Usuario_Comentario1_idx` (`Comment_idComment`);

--
-- Índices de tabela `evaluatedeasteregg`
--
ALTER TABLE `evaluatedeasteregg`
  ADD PRIMARY KEY (`EasterEgg_idEasterEgg`,`User_idUser`),
  ADD KEY `fk_EasterEgg_has_Usuario_Usuario1_idx` (`User_idUser`),
  ADD KEY `fk_EasterEgg_has_Usuario_EasterEgg1_idx` (`EasterEgg_idEasterEgg`);

--
-- Índices de tabela `fallowedeasteregg`
--
ALTER TABLE `fallowedeasteregg`
  ADD PRIMARY KEY (`User_idUser`,`EasterEgg_idEasterEgg`),
  ADD KEY `fk_Usuario_has_EasterEgg_EasterEgg1_idx` (`EasterEgg_idEasterEgg`),
  ADD KEY `fk_Usuario_has_EasterEgg_Usuario1_idx` (`User_idUser`);

--
-- Índices de tabela `fallowedmedia`
--
ALTER TABLE `fallowedmedia`
  ADD PRIMARY KEY (`User_idUser`,`Media_idMedia`),
  ADD KEY `fk_Usuario_has_Obra_Obra1_idx` (`Media_idMedia`),
  ADD KEY `fk_Usuario_has_Obra_Usuario_idx` (`User_idUser`);

--
-- Índices de tabela `fallowedtask`
--
ALTER TABLE `fallowedtask`
  ADD PRIMARY KEY (`idTask`,`idUser`),
  ADD KEY `fk_Usuario_has_Task_User_idx` (`idUser`);

--
-- Índices de tabela `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`idMedia`);

--
-- Índices de tabela `reference`
--
ALTER TABLE `reference`
  ADD PRIMARY KEY (`EasterEgg_idEasterEgg`,`Media_idMedia`),
  ADD KEY `fk_EasterEgg_has_Obra_Obra1_idx` (`Media_idMedia`),
  ADD KEY `fk_EasterEgg_has_Obra_EasterEgg1_idx` (`EasterEgg_idEasterEgg`);

--
-- Índices de tabela `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`idTask`),
  ADD KEY `fk_Task_EasterEgg1_idx` (`EasterEgg_idEasterEgg`);

--
-- Índices de tabela `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`),
  ADD UNIQUE KEY `userName_UNIQUE` (`userName`),
  ADD UNIQUE KEY `acessTokenFacebook_UNIQUE` (`acessTokenFacebook`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `comment`
--
ALTER TABLE `comment`
  MODIFY `idComment` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de tabela `commentMedia`
--
ALTER TABLE `commentMedia`
  MODIFY `idCommentMedia` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de tabela `easteregg`
--
ALTER TABLE `easteregg`
  MODIFY `idEasterEgg` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de tabela `media`
--
ALTER TABLE `media`
  MODIFY `idMedia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de tabela `task`
--
ALTER TABLE `task`
  MODIFY `idTask` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de tabela `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `fk_Comentario_EasterEgg1` FOREIGN KEY (`idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_idUser` FOREIGN KEY (`idAuthor`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `commentMedia`
--
ALTER TABLE `commentMedia`
  ADD CONSTRAINT `fk_Comentario_idMedia` FOREIGN KEY (`idMedia`) REFERENCES `media` (`idMedia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_idUser2` FOREIGN KEY (`idAuthor`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `easteregg`
--
ALTER TABLE `easteregg`
  ADD CONSTRAINT `fk_EasterEgg_Obra1` FOREIGN KEY (`idMedia`) REFERENCES `media` (`idMedia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_EasterEgg_Usuario1` FOREIGN KEY (`idWritter`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `evaluatedcomment`
--
ALTER TABLE `evaluatedcomment`
  ADD CONSTRAINT `fk_Comentario_has_Usuario_Comentario1` FOREIGN KEY (`Comment_idComment`) REFERENCES `comment` (`idComment`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Comentario_has_Usuario_Usuario1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `evaluatedeasteregg`
--
ALTER TABLE `evaluatedeasteregg`
  ADD CONSTRAINT `fk_EasterEgg_has_Usuario_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_EasterEgg_has_Usuario_Usuario1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `fallowedeasteregg`
--
ALTER TABLE `fallowedeasteregg`
  ADD CONSTRAINT `fk_Usuario_has_EasterEgg_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usuario_has_EasterEgg_Usuario1` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `fallowedmedia`
--
ALTER TABLE `fallowedmedia`
  ADD CONSTRAINT `fk_Usuario_has_Obra_Obra1` FOREIGN KEY (`Media_idMedia`) REFERENCES `media` (`idMedia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usuario_has_Obra_Usuario` FOREIGN KEY (`User_idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `fallowedtask`
--
ALTER TABLE `fallowedtask`
  ADD CONSTRAINT `fk_Usuario_has_Task_Task` FOREIGN KEY (`idTask`) REFERENCES `task` (`idTask`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usuario_has_Task_User` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `reference`
--
ALTER TABLE `reference`
  ADD CONSTRAINT `fk_EasterEgg_has_Obra_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_EasterEgg_has_Obra_Obra1` FOREIGN KEY (`Media_idMedia`) REFERENCES `media` (`idMedia`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para tabelas `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `fk_Task_EasterEgg1` FOREIGN KEY (`EasterEgg_idEasterEgg`) REFERENCES `easteregg` (`idEasterEgg`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
