create table if not exists roles
(
    id   NUMBER not null,
    name varchar(255),
    primary key (id)
);

create table if not exists user_roles
(
    id          NUMBER not null,
    role_id     NUMBER not null,
    user_userid NUMBER not null,
    primary key (id)
);

create table if not exists users
(
    USERID      NUMBER not null,
    USERNAME    VARCHAR(255),
    PASSWORD    VARCHAR(50),
    LASTNAME    VARCHAR(255),
    FIRSTNAME   VARCHAR(255),
    GROUPS      NUMBER(10, 0),
    USERTYPE    NUMBER(10, 0),
    PHONE       VARCHAR(50),
    EMAIL       VARCHAR(255),
    CUSURL      VARCHAR(255),
    PHOTOPATH   VARCHAR(400),
    USERGROUP   VARCHAR(100),
    ISACTIVE    NUMBER(10, 0),
    CONTACTTYPE NUMBER(10, 0),
    ID          VARCHAR(50),
    primary key (USERID)
);


create table if not exists chain
(
    chain_id           NUMBER not null,
    name               varchar(255),
    symbol             varchar(255),
    description        varchar(255),
    long_description   varchar(255),
    icon_url           varchar(255),
    category           varchar(255),
    chain_list_icon    varchar(255),
    rpc_url            varchar(255),
    id                 NUMBER,
    block_explorer_url varchar(255),
    primary key (chain_id)
);
create table if not exists chain_users
(
    id       NUMBER auto_increment not null,
    chain_id NUMBER                not null,
    userid   NUMBER                not null,
    primary key (id)
);
--     create table if not exists attribute (attrid NUMBER, trait_type varchar(255), valu varchar(255), metadata_metadata_id NUMBER, primary key (attrid));

create table if not exists address
(
    id                 NUMBER not null,
    description        varchar(255),
    email              varchar(255),
    address            varchar(255), -- nft_address
    chain              varchar(255),
    icon_url           varchar(255),
    block_explorer_url varchar(255),
    userid             NUMBER,
    chain_id            NUMBER,
    primary key (id)
);
create table if not exists nft
(
    id          NUMBER not null,
    amount      NUMBER,
    name        varchar(255),
    metadata_id NUMBER,
    primary key (id)
);
create table if not exists nft_address
(
    id           NUMBER not null,
    address      varchar(255),
    native_token NUMBER(53),
    native       NUMBER(53),
    tokens       NUMBER(24),
    primary key (id)
);
create table if not exists nft_ref
(
    id      NUMBER not null,
    address varchar(255),
    chain   varchar(255),
    email   varchar(255),
    name    varchar(255),
    owner   varchar(255),
    primary key (id)
);

create table if not exists COINTABLE
(
    coinid     NUMBER not null,
    coinsymbol varchar(255),
    cointoken  varchar(255),
    pricetotal NUMBER(53),
    purchased  NUMBER not null,
    primary key (coinid)
);
CREATE TABLE if not exists WEBLINK(id bigint PRIMARY KEY
                         auto_increment,
                     title varchar(500) ,
                     url varchar(250) NOT NULL ,
                     host varchar(250) ,
                     downloadstatus TINYINT,
                     htmlpage    varchar(255));

-- create table if not exists weblinks
-- (
--     id             NUMBER not null,
--     downloadstatus smallint,
--     host           varchar(255),
--     htmlpage       varchar(255),
--     url            varchar(255),
--     primary key (id)
-- );

create table if not exists ATTRIBUTE
(
    attrid               NUMBER,
    trait_type           varchar(255),
    valu                 varchar(255),
    metadata_metadata_id NUMBER,
    primary key (attrid)
);

create table METADATA
(
    metadata_id NUMBER not null,
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    nft_id      NUMBER,
    primary key (metadata_id)
);

create sequence address_seq start with 10 increment by 50;
create sequence attribute_seq start with 1000 increment by 50;
create sequence chain_seq start with 101 increment by 50;
create sequence cointable_seq start with 20 increment by 50;
create sequence id_maker start with 1 increment by 50;
create sequence metadata_seq start with 200 increment by 50;
create sequence nft_ref_seq start with 500 increment by 50;
create sequence nft_seq start with 600 increment by 50;
create sequence roles_seq start with 700 increment by 50;
create sequence weblinks_seq start with 800 increment by 50;

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