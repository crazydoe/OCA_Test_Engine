CREATE TABLE question
(
  id BIGINT (20) NOT NULL AUTO_INCREMENT,
  title VARCHAR (255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  body VARCHAR (1000) CHARACTER SET utf8 COLLATE utf8_polish_ci,
  footer VARCHAR (255) CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  body_type ENUM ('RAW','CODE') NOT NULL,
  answer_type ENUM ('SINGLE','MULTIPLE') NOT NULL,
  certainty TINYINT (1) DEFAULT FALSE,
  visible TINYINT (1) DEFAULT FALSE,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE answer
(
  id BIGINT (20) NOT NULL AUTO_INCREMENT,
  body VARCHAR (255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  correct TINYINT (1) NOT NULL,
  explanation VARCHAR (255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  question_id BIGINT (11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (question_id) REFERENCES question (id)
);

CREATE TABLE category
(
  id BIGINT (20) NOT NULL AUTO_INCREMENT,
  name VARCHAR (255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  description VARCHAR(1000) CHARACTER SET utf8 COLLATE utf8_polish_ci,
  visible TINYINT (1) DEFAULT TRUE,
  PRIMARY KEY (id)
);

CREATE TABLE tag
(
  id BIGINT (20) NOT NULL AUTO_INCREMENT,
  name VARCHAR (255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  description VARCHAR (255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  visible TINYINT (1) DEFAULT TRUE,
  PRIMARY KEY (id)
);

CREATE TABLE question_set
(
  id BIGINT (20) NOT NULL AUTO_INCREMENT,
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  random TINYINT (1) DEFAULT FALSE,
  PRIMARY KEY (id)
);

CREATE TABLE question_tag
(
  id BIGINT (20) NOT NULL AUTO_INCREMENT,
  question_id BIGINT (20) NOT NULL,
  tag_id BIGINT (20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (question_id) REFERENCES question (id),
  FOREIGN KEY (tag_id) REFERENCES tag (id)
);

CREATE TABLE question_category
(
  id BIGINT (20) NOT NULL AUTO_INCREMENT,
  question_id BIGINT (20) NOT NULL,
  category_id BIGINT (20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (question_id) REFERENCES question (id),
  FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE question_set_category
(
  id BIGINT (20) NOT NULL AUTO_INCREMENT,
  question_set_id BIGINT (20) NOT NULL,
  category_id BIGINT (20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (question_set_id) REFERENCES question_set (id),
  FOREIGN KEY (category_id) REFERENCES category (id)
);

CREATE TABLE question_set_tag
(
  id BIGINT (20) NOT NULL AUTO_INCREMENT,
  question_set_id BIGINT (20) NOT NULL,
  tag_id BIGINT (20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (question_set_id) REFERENCES question_set (id),
  FOREIGN KEY (tag_id) REFERENCES tag (id)
);

CREATE TABLE question_set_question
(
  id BIGINT (20) NOT NULL AUTO_INCREMENT,
  question_set_id BIGINT (20) NOT NULL,
  question_id BIGINT (20) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (question_set_id) REFERENCES question_set (id),
  FOREIGN KEY (question_id) REFERENCES question (id)
)