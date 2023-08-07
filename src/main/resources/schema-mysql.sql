create table ROLES
(
    id   INT not null auto_increment,
    name varchar(255),
    primary key (id)
);

create table USERS_ROLES
(
    id          INT not null auto_increment,
    role_id     INT not null,
    user_userid INT not null,
    primary key (id)
);

create table  USERS
(
    USERID      INT not null auto_increment,
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

CREATE TABLE CATEGORY
(
    id                 VARCHAR(36)  NOT NULL,
    version            BIGINT       NULL,
    created_date       datetime     NULL,
    last_modified_date datetime     NULL,
    `description`      VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE CHAIN
(
    chain_id           VARCHAR(36)  NOT NULL,
    version            INT          NULL,
    name               VARCHAR(250) NOT NULL,
    symbol             INT          NULL,
    `description`      VARCHAR(255) NULL,
    long_description   VARCHAR(255) NULL,
    icon_url           VARCHAR(255) NULL,
    category           VARCHAR(255) NULL,
    chain_list_icon    VARCHAR(255) NULL,
    rpc_url            VARCHAR(255) NULL,
    block_explorer_url VARCHAR(255) NULL,
    id                 INT          NULL,
    created_date       datetime     NOT NULL,
    date_created       datetime     NOT NULL,
    last_updated       datetime     NULL,
    updated_at         datetime     NULL,
    CONSTRAINT pk_chain PRIMARY KEY (chain_id)
);

CREATE TABLE CHAIN_ORDER
(
    id          VARCHAR(36)  NOT NULL,
    user_ref    VARCHAR(255) NULL,
    user_userid INT          NULL,
    CONSTRAINT pk_chainorder PRIMARY KEY (id)
);

CREATE TABLE CHAIN_ORDER_LINE
(
    id             VARCHAR(36) NOT NULL,
    version        BIGINT      NULL,
    created_date   datetime    NOT NULL,
    date_created   datetime    NOT NULL,
    last_updated   datetime    NULL,
    updated_at     datetime    NULL,
    chain_order_id VARCHAR(36) NULL,
    chain_chain_id VARCHAR(36) NULL,
    CONSTRAINT pk_chainorderline PRIMARY KEY (id)
);

CREATE TABLE CHAIN_CATEGORY
(
    category_id VARCHAR(36) NOT NULL,
    chain_id    VARCHAR(36) NOT NULL,
    CONSTRAINT pk_chain_category PRIMARY KEY (category_id, chain_id)
);

create table CHAIN_USERS
(
    id       INT  not null  auto_increment,
    chain_id INT                not null,
    userid   INT                not null,
    primary key (id)
);
--     create table attribute (attrid INT, trait_type varchar(255), valu varchar(255), metadata_metadata_id INT, primary key (attrid));

create table ADDRESS
(
    id                 INT not null  auto_increment,
    description        varchar(255),
    email              varchar(255),
    address            varchar(255), -- NFTADDRESS
    chain              varchar(255),
    icon_url           varchar(255),
    block_explorer_url varchar(255),
    userid             INT,
    chain_id            INT,
    primary key (id)
);
create table NFT
(
    id          INT not null auto_increment,
    amount      INT,
    name        varchar(255),
    metadata_id INT,
    primary key (id)
);
create table NFTADDRESS
(
    id           INT not null auto_increment,
    address      varchar(255),
    native_token INT,
    native       INT,
    tokens       INT,
    primary key (id)
);
create table NFT_REF
(
    id      INT not null auto_increment,
    address varchar(255),
    chain   varchar(255),
    email   varchar(255),
    name    varchar(255),
    owner   varchar(255),
    primary key (id)
);
create table NFT_TOKEN
(
    id      INT not null auto_increment,
    address varchar(255),
    chain   varchar(255),
    email   varchar(255),
    name    varchar(255),
    owner   varchar(255),
    primary key (id)
);

create table ATTRIBUTE
(
    attrid               INT auto_increment,
    trait_type           varchar(255),
    valu                 varchar(255),
    metadata_metadata_id INT,
    primary key (attrid)
);

create table METADATA
(
    metadata_id INT not null auto_increment,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    nft_id      INT,
    primary key (metadata_id)
);
