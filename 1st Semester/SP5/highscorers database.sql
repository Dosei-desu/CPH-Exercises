-- CREATE DATABASE puck_man_highscorers;
USE puck_man_highscorers;

/*
CREATE TABLE highscorers(
-- Id becomes an auto-incrementing primary key
	id int NOT NULL AUTO_INCREMENT,
-- timestamp
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
-- name
	player varchar(5) NOT NULL,
-- score
	score int NOT NULL,
-- time (in seconds)
	`time` int NOT NULL,
    PRIMARY KEY (id)
);
*/

SELECT * FROM highscorers ORDER BY score DESC, id ASC;