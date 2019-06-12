CREATE TABLE user_authority
(
  FK_USER_ID     bigint(20) NOT NULL,
  FK_AUTORITY_ID bigint(20) NOT NULL,
  PRIMARY KEY (FK_USER_ID, FK_AUTORITY_ID),
  KEY FKUSER_AUTHO278605 (FK_AUTORITY_ID),
  CONSTRAINT C_FK_AUTHORITY_ID FOREIGN KEY (FK_AUTORITY_ID) REFERENCES authority (ID),
  CONSTRAINT C_FK_USER_ID FOREIGN KEY (FK_USER_ID) REFERENCES user (ID)
);