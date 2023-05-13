create table ROLES
(
    id   INT not null,
    name varchar(255),
    primary key (id)
);

create table USERS_ROLES
(
    id          INT not null,
    role_id     INT not null,
    user_userid INT not null,
    primary key (id)
);

create table  USERS
(
    USERID      INT not null,
    USERNAME    VARCHAR(255),
    PASSWORD    VARCHAR(120),
    LASTNAME    VARCHAR(255),
    FIRSTNAME   VARCHAR(255),
    USERTYPE    FLOAT(10),
    PHONE       VARCHAR(50),
    EMAIL       VARCHAR(255),
    CUSURL      VARCHAR(255),
    PHOTOPATH   VARCHAR(400),
    ISACTIVE    FLOAT(10),
    CONTACTTYPE FLOAT(10),
    primary key (USERID)
);

create table NFT_REF
(
    id      INT not null,
    name    varchar(255),
    owner   varchar(255),
    chain_id   INT(53),
    email_id    INT(53),
    address_id  INT(53),
    nft_id  INT(53),

    primary key (id)
);

create table COINTABLE
(
    coinid     INT not null,
    coinsymbol varchar(255),
    cointoken  varchar(255),
    pricetotal INT(53),
    purchased  INT not null,
    primary key (coinid)
);
CREATE TABLE WEBLINK(id BIGINT PRIMARY KEY ,
                     title varchar(500) ,
                     url varchar(250) NOT NULL ,
                     host varchar(250) ,
                     downloadstatus TINYINT,
                     htmlpage    varchar(255));


