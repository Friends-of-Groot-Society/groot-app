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

create table chain
(
    chain_id           INT not null,
    name               varchar(255),
    symbol             varchar(255),
    description        varchar(255),
    long_description   varchar(255),
    icon_url           varchar(255),
    category           varchar(255),
    chain_list_icon    varchar(255),
    rpc_url            varchar(255),
    id                 INT,
    block_explorer_url varchar(255),
    primary key (chain_id)
);
create table chain_users
(
    id       INT  not null,
    chain_id INT                not null,
    userid   INT                not null,
    primary key (id)
);
--     create table attribute (attrid INT, trait_type varchar(255), valu varchar(255), metadata_metadata_id INT, primary key (attrid));

create table address
(
    id                 INT not null,
    description        varchar(255),
    email              varchar(255),
    address            varchar(255), -- nft_address
    chain              varchar(255),
    icon_url           varchar(255),
    block_explorer_url varchar(255),
    userid             INT,
    chain_id            INT,
    primary key (id)
);
create table nft
(
    id          INT not null,
    amount      INT,
    name        varchar(255),
    metadata_id INT,
    primary key (id)
);
create table nft_address
(
    id           INT not null,
    address      varchar(255),
    native_token INT,
    native       INT,
    tokens       INT,
    primary key (id)
);
create table nft_ref
(
    id      INT not null,
    address varchar(255),
    chain   varchar(255),
    email   varchar(255),
    name    varchar(255),
    owner   varchar(255),
    primary key (id)
);

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
                     url varchar(250)   ,
                     host varchar(250) ,
                     downloadstatus TINYINT,
                     htmlpage    varchar(255));

-- create table weblinks
-- (
--     id             INT not null,
--     downloadstatus smallint,
--     host           varchar(255),
--     htmlpage       varchar(255),
--     url            varchar(255),
--     primary key (id)
-- );

create table ATTRIBUTE
(
    attrid               INT,
    trait_type           varchar(255),
    valu                 varchar(255),
    metadata_metadata_id INT,
    primary key (attrid)
);

create table METADATA
(
    metadata_id INT not null,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    nft_id      INT,
    primary key (metadata_id)
);
#
# create table NFT
    # (
    #     nft_id     INT not null,
    #     amount     INT,
    #     name       varchar(255),
    #     metadataid INT,
    #     primary key (nft_id)
    # );

-- MANY TO ON
alter table attribute
    add constraint FKik918ybmves03ibw6l10jj8d2 foreign key (metadata_metadata_id) references metadata;

alter table metadata
    add constraint FK7xw0e76t7gnn5x9a254683a8 foreign key (nft_id) references nft;
alter table nft
    add constraint FK7w00r1rprr2020ho6cbmwc5kh foreign key (metadata_id) references metadata;
alter table nft
    add constraint FKav9aho8kdsp9rh22jdlocuy7r foreign key (id) references nft_address;

 -- MANY TO MANY
alter table chain_users
    add constraint FKc12l3fx8me9k15hv0epjpjpbl foreign key (chain_id) references chain;
alter table chain_users
    add constraint FK3psni4ui5db7mcih64fov3v39 foreign key (userid) references users;