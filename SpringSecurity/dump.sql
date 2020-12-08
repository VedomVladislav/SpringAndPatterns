DROP TABLE IF EXISTS `group_authorities`;

CREATE TABLE `group_authorities` (
                                   `group_id` bigint(20) unsigned NOT NULL,
                                   `authority` varchar(50) NOT NULL,
                                   KEY `group_id` (`group_id`),
                                   CONSTRAINT `group_authorities_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `group_authorities` WRITE;
INSERT INTO `group_authorities` VALUES (2,'ROLE_ADMIN'),(2,'ROLE_USER'),(1,'ROLE_USER');
UNLOCK TABLES;


DROP TABLE IF EXISTS `group_members`;
CREATE TABLE `group_members` (
                               `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                               `username` varchar(50) NOT NULL,
                               `group_id` bigint(20) unsigned NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `group_id` (`group_id`),
                               CONSTRAINT `group_members_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

LOCK TABLES `group_members` WRITE;
INSERT INTO `group_members` VALUES (1,'admin',2),(2,'user',1);
UNLOCK TABLES;


DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
                        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
                        `group_name` varchar(50) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

LOCK TABLES `groups` WRITE;
INSERT INTO `groups` VALUES (1,'users'),(2,'administrators');
UNLOCK TABLES;


DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
                                   `username` varchar(64) NOT NULL,
                                   `series` varchar(64) NOT NULL,
                                   `token` varchar(64) NOT NULL,
                                   `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                                   PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `persistent_logins` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                       `username` varchar(45) NOT NULL,
                       `password` varchar(45) NOT NULL,
                       `enabled` tinyint(4) NOT NULL DEFAULT '1',
                       PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES ('admin','admin',1),('user','user',1);
UNLOCK TABLES;