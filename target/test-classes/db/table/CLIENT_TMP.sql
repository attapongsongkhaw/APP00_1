DROP TABLE IF EXISTS CLIENT_TMP;
CREATE TABLE CLIENT_TMP (
  CLIENT_CODE varchar(20) NOT NULL,
  CLIENT_NAME varchar(255) NOT NULL,
  CORP_CODE varchar(20) NOT NULL,
  CIS_ID varchar(12) DEFAULT NULL,
  ACTIVE_STATUS char(1) NOT NULL,
  AUTHORIZE_STATUS char(1) NOT NULL,
  REJECT_REASON varchar(255) DEFAULT NULL,
  OPERATION_FLAG char(1) NOT NULL,
  CREATED_DATE datetime NOT NULL,
  CREATED_BY varchar(20) NOT NULL,
  AUTHORIZED_DATE datetime DEFAULT NULL,
  AUTHORIZED_BY varchar(20) DEFAULT NULL,
  LAST_UPDATED_DATE datetime NOT NULL,
  LAST_UPDATED_BY varchar(20) NOT NULL,
  PRIMARY KEY (CLIENT_CODE),
  );
  