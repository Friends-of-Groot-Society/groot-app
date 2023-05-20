create table ROLES
(
    id   INT not null,
    name varchar(255),
    primary key (id)
);
commit;
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
    chain_id   INT ,
    email_id    INT ,
    address_id  INT ,
    nft_id  INT ,

    primary key (id)
);

select * from Users;

create table COINTABLE
(
    coinid     INT not null,
    coinsymbol varchar(255),
    cointoken  varchar(255),
    pricetotal INT ,
    purchased  INT  ,
    primary key (coinid)
);
CREATE TABLE WEBLINK(id BIGINT PRIMARY KEY ,
                     title varchar(500) ,
                     url varchar(250) NOT NULL ,
                     host varchar(250) ,
                     downloadstatus TINYINT,
                     htmlpage    varchar(255));

#
# create sequence cointable_seq start with 20 increment by 50;
# create sequence id_maker start with 1 increment by 50;
# create sequence nft_ref_seq start with 500 increment by 50;
# create sequence roles_seq start with 700 increment by 50;
# create sequence weblinks_seq start with 800 increment by 50;
# create sequence movies_seq start with 900 increment by 50;
