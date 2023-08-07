CREATE TABLE ADDRESS
(
    id                 INT          NOT NULL,
    `description`      VARCHAR(255) NULL,
    email              VARCHAR(255) NULL,
    address            VARCHAR(255) NULL,
    chain              VARCHAR(255) NULL,
    icon_url           VARCHAR(255) NULL,
    block_explorer_url VARCHAR(255) NULL,
    users_userid       INT          NULL,
    chain_id           INT          NULL,
    nftaddress_id      INT          NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
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
CREATE TABLE ATTRIBUTE
(
    attrid               INT          NOT NULL,
    valu                 VARCHAR(255) NULL,
    trait_type           VARCHAR(255) NULL,
    metadata_metadata_id INT          NULL,
    CONSTRAINT pk_attribute PRIMARY KEY (attrid)
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

CREATE TABLE CHAIN_CATEGORY
(
    category_id VARCHAR(36) NOT NULL,
    chain_id    VARCHAR(36) NOT NULL,
    CONSTRAINT pk_chain_category PRIMARY KEY (category_id, chain_id)
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

CREATE TABLE CHAIN_USERS
(
    chain_id VARCHAR(36) NOT NULL,
    userid   INT         NOT NULL
);

CREATE TABLE METADATA
(
    metadata_id   INT          NOT NULL,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    image         VARCHAR(255) NULL,
    nft_id        INT          NULL,
    CONSTRAINT pk_metadata PRIMARY KEY (metadata_id)
);

CREATE TABLE NFT
(
    id                      INT          NOT NULL,
    name                    VARCHAR(255) NULL,
    amount                  DOUBLE       NULL,
    metadata_id_metadata_id INT          NULL,
    nftaddress_id           INT          NULL,
    CONSTRAINT pk_nft PRIMARY KEY (id)
);

CREATE TABLE NFT_REF
(
    id           INT          NOT NULL,
    version      INT          NULL,
    created_date datetime     NOT NULL,
    date_created datetime     NOT NULL,
    last_updated datetime     NULL,
    updated_at   datetime     NULL,
    name         VARCHAR(255) NULL,
    owner        VARCHAR(255) NULL,
    email        VARCHAR(255) NULL,
    address      VARCHAR(255) NULL,
    chain        VARCHAR(255) NULL,
    CONSTRAINT pk_nft_ref PRIMARY KEY (id)
);

CREATE TABLE ROLES
(
    id   INT          NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE USERS
(
    userid      INT          NOT NULL,
    username    VARCHAR(255) NULL,
    password    VARCHAR(120) NULL,
    lastname    VARCHAR(255) NULL,
    firstname   VARCHAR(255) NULL,
    usertype    INT          NULL,
    phone       VARCHAR(255) NULL,
    email       VARCHAR(255) NULL,
    cusurl      VARCHAR(255) NULL,
    photopath   VARCHAR(255) NULL,
    isactive    INT          NULL,
    contacttype INT          NULL,
    CONSTRAINT pk_users PRIMARY KEY (userid)
);

CREATE TABLE USERS_ROLES
(
    role_id INT NOT NULL,
    userid  INT NOT NULL,
    CONSTRAINT pk_users_roles PRIMARY KEY (role_id, userid)
);

ALTER TABLE NFTADDRESS
    ADD created_date datetime NULL;

ALTER TABLE NFTADDRESS
    MODIFY created_date datetime NOT NULL;

ALTER TABLE USER_ACCOUNTS
    ADD created_date datetime NULL;

ALTER TABLE USER_ACCOUNTS
    MODIFY created_date datetime NOT NULL;

ALTER TABLE USERS
    ADD CONSTRAINT uc_users_email UNIQUE (email);

ALTER TABLE USERS
    ADD CONSTRAINT uc_users_username UNIQUE (username);

ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_NFTADDRESS FOREIGN KEY (nftaddress_id) REFERENCES nftaddress (id);

ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_USERS_USERID FOREIGN KEY (users_userid) REFERENCES USERS (userid);

ALTER TABLE attribute
    ADD CONSTRAINT FK_ATTRIBUTE_ON_METADATA_METADATA FOREIGN KEY (metadata_metadata_id) REFERENCES metadata (metadata_id);

ALTER TABLE chain_order_line
    ADD CONSTRAINT FK_CHAINORDERLINE_ON_CHAINORDER FOREIGN KEY (chain_order_id) REFERENCES chain_order (id);

ALTER TABLE chain_order_line
    ADD CONSTRAINT FK_CHAINORDERLINE_ON_CHAIN_CHAIN FOREIGN KEY (chain_chain_id) REFERENCES chain (chain_id);

ALTER TABLE chain_order
    ADD CONSTRAINT FK_CHAINORDER_ON_USER_USERID FOREIGN KEY (user_userid) REFERENCES USERS (userid);

ALTER TABLE metadata
    ADD CONSTRAINT FK_METADATA_ON_NFT FOREIGN KEY (nft_id) REFERENCES nft (id);

ALTER TABLE nft
    ADD CONSTRAINT FK_NFT_ON_METADATA_ID_METADATA FOREIGN KEY (metadata_id_metadata_id) REFERENCES metadata (metadata_id);

ALTER TABLE nft
    ADD CONSTRAINT FK_NFT_ON_NFTADDRESS FOREIGN KEY (nftaddress_id) REFERENCES nftaddress (id);

ALTER TABLE chain_category
    ADD CONSTRAINT fk_chacat_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE chain_category
    ADD CONSTRAINT fk_chacat_on_chain FOREIGN KEY (chain_id) REFERENCES chain (chain_id);

ALTER TABLE chain_users
    ADD CONSTRAINT fk_chause_on_chain FOREIGN KEY (chain_id) REFERENCES chain (chain_id);

ALTER TABLE chain_users
    ADD CONSTRAINT fk_chause_on_user FOREIGN KEY (userid) REFERENCES USERS (userid);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (userid) REFERENCES USERS (userid);

DROP TABLE COINTABLE;

DROP TABLE NFT_ADDRESS;

DROP TABLE NFT_TOKEN;

DROP TABLE WEBLINK;

DROP TABLE address_seq;

DROP TABLE attribute_seq;

DROP TABLE chain_seq;

DROP TABLE id_maker;

DROP TABLE metadata_seq;

DROP TABLE nft_address_seq;

DROP TABLE nft_ref_seq;

DROP TABLE nft_seq;

DROP TABLE nftaddress_seq;

DROP TABLE raw_token_seq;

DROP TABLE roles_seq;

DROP TABLE USER_ACCOUNTS_SEQ;

ALTER TABLE CHAIN_USERS
    DROP PRIMARY KEY;

ALTER TABLE nftaddress
    DROP COLUMN created_at;

ALTER TABLE USER_ACCOUNTS
    DROP COLUMN created_at;

ALTER TABLE CHAIN_USERS
    DROP COLUMN id;

ALTER TABLE USERS_ROLES
    DROP COLUMN id;

ALTER TABLE USERS_ROLES
    DROP COLUMN user_userid;

ALTER TABLE NFT
    DROP COLUMN metadata_id;

ALTER TABLE NFTADDRESS
    DROP COLUMN native;

ALTER TABLE NFTADDRESS
    DROP COLUMN tokens;

ALTER TABLE ADDRESS
    DROP COLUMN userid;
