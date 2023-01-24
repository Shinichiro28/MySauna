CREATE TABLE IF NOT EXISTS sauna(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(20),
  sauna_temp INT NOT NULL,
  sauna_time INT NULL,
  sauna_satisfaction INT NOT NULL,
  water_temp INT NOT NULL,
  water_time INT NULL,
  water_satisfaction INT NOT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users(
  id SERIAL PRIMARY KEY,
  username VARCHAR(20),
  password VARCHAR(10)
);