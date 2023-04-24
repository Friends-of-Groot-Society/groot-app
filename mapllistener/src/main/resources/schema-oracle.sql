- drop table USERS_ROLES CASCADE  CONSTRAINTS;
  create table USERS_ROLES
  (
      id          NUMBER not null,
      role_id     NUMBER not null,
      user_userid NUMBER not null,
      primary key (id)
  );

  -- drop table chain_users CASCADE  CONSTRAINTS;
  create table chain_users
  (
      id       NUMBER  not null,
      userid   NUMBER  not null,
      chain_id NUMBER  not null,
      primary key (id)
  );


  -- drop table users CASCADE  CONSTRAINTS;
  create table users
  (
      USERID      NUMBER not null,
      USERNAME    VARCHAR(255),
      PASSWORD    VARCHAR(120),
      LASTNAME    VARCHAR(255),
      FIRSTNAME   VARCHAR(255),
      USERTYPE    NUMBER(10, 0),
      PHONE       VARCHAR(50),
      EMAIL       VARCHAR(255),
      CUSURL      VARCHAR(255),
      PHOTOPATH   VARCHAR(400),
      ISACTIVE    NUMBER(10, 0),
      CONTACTTYPE NUMBER(10, 0) ,
      primary key (USERID)
  );

  -- drop table roles CASCADE  CONSTRAINTS;
  create table  roles
  (
      id   NUMBER not null,
      name varchar(255),
      primary