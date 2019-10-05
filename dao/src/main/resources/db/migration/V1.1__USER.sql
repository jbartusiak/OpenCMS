CREATE TABLE user
(
  ID        bigint(20)   NOT NULL AUTO_INCREMENT,
  USERNAME  varchar(100) NOT NULL,
  PASSWORD  char(255)    NOT NULL,
  EMAIL     varchar(255) NOT NULL,
  FIRSTNAME varchar(100) NOT NULL,
  LASTNAME  varchar(100),
  CDATE     datetime(6)  NOT NULL,
  UDATE     datetime(6)  NOT NULL,
  CONSTRAINT PK_USER PRIMARY KEY (ID)
);