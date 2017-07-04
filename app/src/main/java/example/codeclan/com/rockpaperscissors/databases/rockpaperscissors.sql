DROP TABLE scores;

CREATE TABLE scores (
  ID INTEGER PRIMARY KEY AUTOINCREMENT,
  wins INTEGER,
  draws INTEGER,
  losses INTEGER
);

INSERT INTO scores (wins, draws, losses) VALUES (0, 0, 0);