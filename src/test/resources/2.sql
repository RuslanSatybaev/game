DROP TABLE IF EXISTS player;

CREATE TABLE player
(
    id             BIGINT(20) NOT NULL AUTO_INCREMENT,
    name           VARCHAR(12) NULL,
    title          VARCHAR(30) NULL,
    race           VARCHAR(20) NULL,

    birthday       DATE NULL,
    banned         BIT(1) NULL,
    experience     INT(10) NULL,
    level          INT(3) NULL,
    untilNextLevel INT(10) NULL,
    PRIMARY KEY (id)
);

INSERT INTO player(name, title, race,  birthday, banned, experience, level, untilNextLevel)
VALUES
     ('Аттирис', 'и.о.Карвандоса', 'ELF',  '2010-04-15', true, 60520, 34, 2480);