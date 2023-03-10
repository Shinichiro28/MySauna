CREATE TABLE IF NOT EXISTS sauna(
  id BIGINT NOT NULL AUTO_INCREMENT,
  user_id BIGINT,
  name VARCHAR(20),
  sauna_temp INT NOT NULL,
  sauna_time INT NULL,
  sauna_satisfaction INT NOT NULL,
  water_temp INT NOT NULL,
  water_time INT NULL,
  water_satisfaction INT NOT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY(user_id)
    REFERENCES users(id)
      ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS users(
  id BIGINT NOT NULL AUTO_INCREMENT,
  username VARCHAR(20),
  password VARCHAR(60),
  rolename VARCHAR(10),
  PRIMARY KEY(id)
);