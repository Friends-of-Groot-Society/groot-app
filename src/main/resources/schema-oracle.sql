-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table roles
(
    id   NUMBER not null,
    name varchar2(255),
    primary key (id)
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table user_roles
(
    id          NUMBER not null,
    role_id     NUMBER not null,
    user_userid NUMBER not null,
    primary key (id)
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table users
(
    USERID      NUMBER not null,
    USERNAME    VARCHAR2(255),
    PASSWORD    VARCHAR2(50),
    LASTNAME    VARCHAR2(255),
    FIRSTNAME   VARCHAR2(255),
    GROUPS      NUMBER(10, 0),
    USERTYPE    NUMBER(10, 0),
    PHONE       VARCHAR2(50),
    EMAIL       VARCHAR2(255),
    CUSURL      VARCHAR2(255),
    PHOTOPATH   VARCHAR2(400),
    USERGROUP   VARCHAR2(100),
    ISACTIVE    NUMBER(10, 0),
    CONTACTTYPE NUMBER(10, 0),
    ID          VARCHAR2(50),
    primary key (USERID)
);


-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table chain
(
    chain_id           NUMBER not null,
    name               varchar2(255),
    symbol             varchar2(255),
    description        varchar2(255),
    long_description   varchar2(255),
    icon_url           varchar2(255),
    category           varchar2(255),
    chain_list_icon    varchar2(255),
    rpc_url            varchar2(255),
    id                 NUMBER,
    block_explorer_url varchar2(255),
    primary key (chain_id)
);
-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table chain_users
(
    id       NUMBER not null,
    chain_id NUMBER                not null,
    userid   NUMBER                not null,
    primary key (id)
);

-- Generate ID using sequence and trigger
-- create sequence chain_users_seq start with 1 increment by 1;
--
-- create or replace trigger chain_users_seq_tr
--  before insert on chain_users for each row
--  when (new.id is null)
-- begin
-- select chain_users_seq.nextval into :new.id from dual;
-- end;
--
-- SQLINES DEMO *** if not exists attribute (attrid NUMBER, trait_type varchar(255), valu varchar(255), metadata_metadata_id NUMBER, primary key (attrid));

-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table address
(
    id                 NUMBER not null,
    description        varchar2(255),
    email              varchar2(255),
    address            varchar2(255), -- nft_address
    chain              varchar2(255),
    icon_url           varchar2(255),
    block_explorer_url varchar2(255),
    userid             NUMBER,
    chain_id            NUMBER,
    primary key (id)
);
-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table nft
(
    id          NUMBER not null,
    amount      NUMBER,
    name        varchar2(255),
    metadata_id NUMBER,
    primary key (id)
);
-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table nft_address
(
    id           NUMBER not null,
    address      varchar2(255),
    native_token NUMBER(53),
    native       NUMBER(53),
    tokens       NUMBER(24),
    primary key (id)
);
-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table nft_ref
(
    id      NUMBER not null,
    address varchar2(255),
    chain   varchar2(255),
    email   varchar2(255),
    name    varchar2(255),
    owner   varchar2(255),
    primary key (id)
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table cointable
(
    coinid     NUMBER not null,
    coinsymbol varchar2(255),
    cointoken  varchar2(255),
    pricetotal NUMBER(53),
    purchased  NUMBER not null,
    primary key (coinid)
);
-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table weblinks
(
    id             NUMBER not null,
    downloadstatus number(5),
    host           varchar2(255),
    htmlpage       varchar2(255),
    url            varchar2(255),
    primary key (id)
);


-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table attribute
(
    attrid               NUMBER,
    trait_type           varchar2(255),
    valu                 varchar2(255),
    metadata_metadata_id NUMBER,
    primary key (attrid)
);

-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table metadata
(
    metadata_id NUMBER not null,
    description varchar2(255),
    image       varchar2(255),
    name        varchar2(255),
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