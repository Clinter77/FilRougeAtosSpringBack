-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le :  ven. 12 juin 2020 à 15:45
-- Version du serveur :  10.4.6-MariaDB
-- Version de PHP :  7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `atosdevbackend`
--

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `id_agc` int(11) NOT NULL,
  `lib` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `agence`
--

INSERT INTO `agence` (`id_agc`, `lib`) VALUES
(1, 'Metz'),
(2, 'Nancy'),
(8, 'Nicdsae'),
(6, 'Nice'),
(3, 'Strasbourg');

-- --------------------------------------------------------

--
-- Structure de la table `besoin`
--

CREATE TABLE `besoin` (
  `id_bsn` int(11) NOT NULL,
  `d_debut` date DEFAULT NULL,
  `d_echeance` date DEFAULT NULL,
  `f_cloture` bit(1) DEFAULT NULL,
  `f_recurent` bit(1) DEFAULT NULL,
  `intitule` varchar(250) DEFAULT NULL,
  `remarque` varchar(1000) DEFAULT NULL,
  `ts` datetime NOT NULL,
  `id_ctc` int(11) DEFAULT NULL,
  `id_sit` int(11) DEFAULT NULL,
  `id_usr` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `besoin`
--

INSERT INTO `besoin` (`id_bsn`, `d_debut`, `d_echeance`, `f_cloture`, `f_recurent`, `intitule`, `remarque`, `ts`, `id_ctc`, `id_sit`, `id_usr`) VALUES
(1, '2020-06-01', '2020-06-03', b'0', NULL, 'Développeur java expérimenté', 'null', '2020-05-07 16:06:29', 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `besoin_competence`
--

CREATE TABLE `besoin_competence` (
  `id_bsn` int(11) NOT NULL,
  `id_cpc` int(11) NOT NULL,
  `id_exp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `besoin_competence`
--

INSERT INTO `besoin_competence` (`id_bsn`, `id_cpc`, `id_exp`) VALUES
(1, 14, 2);

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur`
--

CREATE TABLE `collaborateur` (
  `id_clb` int(11) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `f_actif` bit(1) NOT NULL,
  `f_dispo` bit(1) NOT NULL,
  `matricule` varchar(50) DEFAULT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `id_agc` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `collaborateur`
--

INSERT INTO `collaborateur` (`id_clb`, `email`, `f_actif`, `f_dispo`, `matricule`, `nom`, `prenom`, `id_agc`) VALUES
(1, 'michel@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'ARNOLD', 'Michel', 1),
(2, 'vogt@atos.fr', b'1', b'1', 'XYCHROMSOMEdvtzetae', 'VOGT', 'Dale', 1),
(3, 'juls@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'JANOVEC', 'Julien', 1),
(4, 'chris', b'1', b'1', 'XYCHROMOSOME', 'DUMORTIER', 'Christophe', 1),
(5, 'erol@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'DEMIRCAN', 'Erol', 2),
(6, 'paddy@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'MARIAGE', 'Paddy', 3),
(7, 'jule@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'TARDY', 'Julien', 1),
(8, 'dora@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'VERDUN', 'Bertrand', 2),
(9, 'nico@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'SMITH', 'Nicolas', 1),
(10, 'adrien@atas.fr', b'1', b'1', 'XYCHROMOSOME', 'FEK', 'Adrien', 2),
(11, 'just@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'GRACIA', 'Justine', 3),
(12, 'mda@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'DAHAOUI', 'Mustapha', 1),
(13, 'paye@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'PAYE', 'Baba', 2),
(14, 'bostien@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'DOCQUOIS', 'Bastien', 3),
(16, 'erners@atos.fr', b'1', b'1', 'XYCHROMOSOME', 'LAVERDURE', 'Ernest', 1);

-- --------------------------------------------------------

--
-- Structure de la table `collaborateur_competence`
--

CREATE TABLE `collaborateur_competence` (
  `id_clb` int(11) NOT NULL,
  `id_cpc` int(11) NOT NULL,
  `id_exp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `collaborateur_competence`
--

INSERT INTO `collaborateur_competence` (`id_clb`, `id_cpc`, `id_exp`) VALUES
(1, 18, 1),
(1, 22, 1),
(11, 14, 1),
(12, 22, 1),
(1, 14, 2),
(2, 14, 2),
(2, 18, 2),
(2, 23, 2),
(1, 23, 3),
(1, 27, 3),
(6, 18, 3);

-- --------------------------------------------------------

--
-- Structure de la table `competence`
--

CREATE TABLE `competence` (
  `id_cpc` int(11) NOT NULL,
  `lib` varchar(255) DEFAULT NULL,
  `id_tcp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `competence`
--

INSERT INTO `competence` (`id_cpc`, `lib`, `id_tcp`) VALUES
(14, 'Developpeur', 1),
(15, 'CP', 1),
(16, 'Architecte technique', 1),
(17, 'Archtecte fonctionnel', 1),
(18, 'Java', 2),
(19, '.net', 2),
(20, 'Windows', 2),
(21, 'Linux', 2),
(22, 'Scrum', 3),
(23, 'Merise', 3),
(24, 'Mantis', 4),
(25, 'Jira', 4),
(26, 'Visual Studio', 4),
(27, 'Cobol', 2);

-- --------------------------------------------------------

--
-- Structure de la table `contact_client`
--

CREATE TABLE `contact_client` (
  `id_ctc` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fax` varchar(100) DEFAULT NULL,
  `nom` varchar(100) DEFAULT NULL,
  `poste` varchar(100) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `tel1` varchar(100) DEFAULT NULL,
  `tel2` varchar(100) DEFAULT NULL,
  `id_sit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `contact_client`
--

INSERT INTO `contact_client` (`id_ctc`, `email`, `fax`, `nom`, `poste`, `prenom`, `tel1`, `tel2`, `id_sit`) VALUES
(1, 'lisa@gamil.com', '+33 5555 44445 55555', 'Simpson', 'Commercial', 'Lisa', '03 29 26 24 58 ', '03 02 555 555', 1);

-- --------------------------------------------------------

--
-- Structure de la table `contact_competence`
--

CREATE TABLE `contact_competence` (
  `id_ctc` int(11) NOT NULL,
  `id_cpc` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `contact_competence`
--

INSERT INTO `contact_competence` (`id_ctc`, `id_cpc`) VALUES
(1, 27);

-- --------------------------------------------------------

--
-- Structure de la table `experience`
--

CREATE TABLE `experience` (
  `id_exp` int(11) NOT NULL,
  `lib` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `experience`
--

INSERT INTO `experience` (`id_exp`, `lib`) VALUES
(1, 'Junior'),
(2, 'Experimente'),
(3, 'Expert'),
(4, 'Top');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1),
(1),
(1),
(1),
(1),
(1);

-- --------------------------------------------------------

--
-- Structure de la table `proposition`
--

CREATE TABLE `proposition` (
  `id_pro` int(11) NOT NULL,
  `d_pro` date DEFAULT NULL,
  `d_relance` date DEFAULT NULL,
  `marge` float NOT NULL,
  `prix_achat` float DEFAULT NULL,
  `prix_vente` float DEFAULT NULL,
  `ts` datetime NOT NULL,
  `id_bsn` int(11) DEFAULT NULL,
  `id_clb` int(11) DEFAULT NULL,
  `id_spr` int(11) DEFAULT NULL,
  `id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `proposition`
--

INSERT INTO `proposition` (`id_pro`, `d_pro`, `d_relance`, `marge`, `prix_achat`, `prix_vente`, `ts`, `id_bsn`, `id_clb`, `id_spr`, `id`) VALUES
(1, '2020-06-01', '2020-06-27', 30, 130, 185.72, '2020-05-07 16:06:29', 1, 1, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_MANAGER'),
(4, 'ROLE_COMMERCIALE'),
(5, 'ROLE_COLLAB');

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

CREATE TABLE `site` (
  `id_sit` int(11) NOT NULL,
  `adr` varchar(100) DEFAULT NULL,
  `code_postal` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `fax` varchar(100) DEFAULT NULL,
  `lib` varchar(100) DEFAULT NULL,
  `tel1` varchar(100) DEFAULT NULL,
  `tel2` varchar(100) DEFAULT NULL,
  `ville` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`id_sit`, `adr`, `code_postal`, `email`, `fax`, `lib`, `tel1`, `tel2`, `ville`) VALUES
(1, 'rue de la pente ', '57000', 'ataos@atos.fr', '+33 5555 555555 5555', NULL, '03 29 65 9 6 35', '03 29 65 9 6 30', 'Metz');

-- --------------------------------------------------------

--
-- Structure de la table `statut_prop`
--

CREATE TABLE `statut_prop` (
  `id_spr` int(11) NOT NULL,
  `lib` varchar(100) DEFAULT NULL,
  `ordr` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `statut_prop`
--

INSERT INTO `statut_prop` (`id_spr`, `lib`, `ordr`) VALUES
(1, 'Recherche', 1),
(2, 'Qualification', 10),
(3, 'KO Atos', 20),
(4, 'KO Candidat', 30),
(5, 'EnvoyÃ©', 40),
(6, 'KO Client', 50),
(7, 'Satisfaite', 60);

-- --------------------------------------------------------

--
-- Structure de la table `type_competence`
--

CREATE TABLE `type_competence` (
  `id_tcp` int(11) NOT NULL,
  `lib` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `type_competence`
--

INSERT INTO `type_competence` (`id_tcp`, `lib`) VALUES
(1, 'Metier'),
(2, 'Technologie'),
(3, 'Methode'),
(4, 'Outils');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES
(1, 'admin@atos.fr', '$2a$10$8UkmLA7tLGUn8UcHhHGgyuHTBju1zP6ZFbcZFUMqbVqOIkLVMSN9u', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(1, 2),
(1, 3);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`id_agc`),
  ADD UNIQUE KEY `UK_pasvq7v5gp7ex9ob2glnxf206` (`lib`);

--
-- Index pour la table `besoin`
--
ALTER TABLE `besoin`
  ADD PRIMARY KEY (`id_bsn`),
  ADD KEY `FKd0xmjmu3dmef8r0umi41wvy07` (`id_ctc`),
  ADD KEY `FKdtxmc8twlibuc2xdhpn5t895` (`id_sit`),
  ADD KEY `FK6j2f4vwlyb8xs4bev6kw89vh2` (`id_usr`);

--
-- Index pour la table `besoin_competence`
--
ALTER TABLE `besoin_competence`
  ADD PRIMARY KEY (`id_bsn`,`id_cpc`),
  ADD KEY `FK3d04ts9qaco84ot2gg89m5cgg` (`id_cpc`),
  ADD KEY `FK62s3wkbl86b2n2cw5cssrqid5` (`id_exp`);

--
-- Index pour la table `collaborateur`
--
ALTER TABLE `collaborateur`
  ADD PRIMARY KEY (`id_clb`),
  ADD KEY `FKma0v7brlw44n9ld4pwt5q2brs` (`id_agc`);

--
-- Index pour la table `collaborateur_competence`
--
ALTER TABLE `collaborateur_competence`
  ADD PRIMARY KEY (`id_clb`,`id_cpc`),
  ADD KEY `FK4798wit2n73lxr27yox9fl3hb` (`id_cpc`),
  ADD KEY `FK36qdebdrkppq818o1bln4f0at` (`id_exp`);

--
-- Index pour la table `competence`
--
ALTER TABLE `competence`
  ADD PRIMARY KEY (`id_cpc`),
  ADD UNIQUE KEY `UK_nyoyhq84ms6htcg3iq8fkgfdi` (`lib`),
  ADD KEY `FKgq6h9j49jvhqrs7pvgf2q0y12` (`id_tcp`);

--
-- Index pour la table `contact_client`
--
ALTER TABLE `contact_client`
  ADD PRIMARY KEY (`id_ctc`),
  ADD KEY `FKbnk0c33j6j3mst9k5krwvq9j4` (`id_sit`);

--
-- Index pour la table `contact_competence`
--
ALTER TABLE `contact_competence`
  ADD PRIMARY KEY (`id_ctc`,`id_cpc`),
  ADD KEY `FK3gis6ij4ewpju00tdg1xeb6ny` (`id_cpc`);

--
-- Index pour la table `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`id_exp`);

--
-- Index pour la table `proposition`
--
ALTER TABLE `proposition`
  ADD PRIMARY KEY (`id_pro`),
  ADD KEY `FKiswe2826748k1jj0tkcu0vgug` (`id_bsn`),
  ADD KEY `FKhi36kl4vyhnpbshxusltdau6i` (`id_clb`),
  ADD KEY `FK1fhxkl5hjkp5lx9rokeef676x` (`id_spr`),
  ADD KEY `FK1kb31us63yqd153kms451ytym` (`id`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`id_sit`);

--
-- Index pour la table `statut_prop`
--
ALTER TABLE `statut_prop`
  ADD PRIMARY KEY (`id_spr`);

--
-- Index pour la table `type_competence`
--
ALTER TABLE `type_competence`
  ADD PRIMARY KEY (`id_tcp`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Index pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `collaborateur`
--
ALTER TABLE `collaborateur`
  MODIFY `id_clb` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `competence`
--
ALTER TABLE `competence`
  MODIFY `id_cpc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `besoin`
--
ALTER TABLE `besoin`
  ADD CONSTRAINT `FK6j2f4vwlyb8xs4bev6kw89vh2` FOREIGN KEY (`id_usr`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKd0xmjmu3dmef8r0umi41wvy07` FOREIGN KEY (`id_ctc`) REFERENCES `contact_client` (`id_ctc`),
  ADD CONSTRAINT `FKdtxmc8twlibuc2xdhpn5t895` FOREIGN KEY (`id_sit`) REFERENCES `site` (`id_sit`);

--
-- Contraintes pour la table `besoin_competence`
--
ALTER TABLE `besoin_competence`
  ADD CONSTRAINT `FK3d04ts9qaco84ot2gg89m5cgg` FOREIGN KEY (`id_cpc`) REFERENCES `competence` (`id_cpc`),
  ADD CONSTRAINT `FK62s3wkbl86b2n2cw5cssrqid5` FOREIGN KEY (`id_exp`) REFERENCES `experience` (`id_exp`),
  ADD CONSTRAINT `FKis4c9l8pyj06ntx9ylg3b5egk` FOREIGN KEY (`id_bsn`) REFERENCES `besoin` (`id_bsn`);

--
-- Contraintes pour la table `collaborateur`
--
ALTER TABLE `collaborateur`
  ADD CONSTRAINT `FKma0v7brlw44n9ld4pwt5q2brs` FOREIGN KEY (`id_agc`) REFERENCES `agence` (`id_agc`);

--
-- Contraintes pour la table `collaborateur_competence`
--
ALTER TABLE `collaborateur_competence`
  ADD CONSTRAINT `FK2aduph4aw6dqkdm2kvwi59pyg` FOREIGN KEY (`id_clb`) REFERENCES `collaborateur` (`id_clb`),
  ADD CONSTRAINT `FK36qdebdrkppq818o1bln4f0at` FOREIGN KEY (`id_exp`) REFERENCES `experience` (`id_exp`),
  ADD CONSTRAINT `FK4798wit2n73lxr27yox9fl3hb` FOREIGN KEY (`id_cpc`) REFERENCES `competence` (`id_cpc`);

--
-- Contraintes pour la table `competence`
--
ALTER TABLE `competence`
  ADD CONSTRAINT `FKgq6h9j49jvhqrs7pvgf2q0y12` FOREIGN KEY (`id_tcp`) REFERENCES `type_competence` (`id_tcp`);

--
-- Contraintes pour la table `contact_client`
--
ALTER TABLE `contact_client`
  ADD CONSTRAINT `FKbnk0c33j6j3mst9k5krwvq9j4` FOREIGN KEY (`id_sit`) REFERENCES `site` (`id_sit`);

--
-- Contraintes pour la table `contact_competence`
--
ALTER TABLE `contact_competence`
  ADD CONSTRAINT `FK3gis6ij4ewpju00tdg1xeb6ny` FOREIGN KEY (`id_cpc`) REFERENCES `competence` (`id_cpc`),
  ADD CONSTRAINT `FKqe6e2jcyphfftb798u6utdvwr` FOREIGN KEY (`id_ctc`) REFERENCES `contact_client` (`id_ctc`);

--
-- Contraintes pour la table `proposition`
--
ALTER TABLE `proposition`
  ADD CONSTRAINT `FK1fhxkl5hjkp5lx9rokeef676x` FOREIGN KEY (`id_spr`) REFERENCES `statut_prop` (`id_spr`),
  ADD CONSTRAINT `FK1kb31us63yqd153kms451ytym` FOREIGN KEY (`id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKhi36kl4vyhnpbshxusltdau6i` FOREIGN KEY (`id_clb`) REFERENCES `collaborateur` (`id_clb`),
  ADD CONSTRAINT `FKiswe2826748k1jj0tkcu0vgug` FOREIGN KEY (`id_bsn`) REFERENCES `besoin` (`id_bsn`);

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
