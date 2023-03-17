    create table if not exists users (
        USERID NUMBER auto_increment primary key,
        USERNAME VARCHAR(60 ),
        PASSWORD VARCHAR(20 ),
        LASTNAME VARCHAR(60 ),
        FIRSTNAME VARCHAR(60 ),
        GROUPS NUMBER(10,0) ,
        USERTYPE NUMBER(10,0),
        PHONE VARCHAR(50 ),
        EMAIL VARCHAR(30 ),
        CUSURL VARCHAR(100 ),
        PHOTOPATH VARCHAR(400 ),
        USERGROUP VARCHAR(100 ),
        ISACTIVE NUMBER(10,0),
        CONTACTTYPE NUMBER(10,0),
        ID VARCHAR(50  )
    );

    create table if not exists chain (
        chainId NUMBER  auto_increment primary key,
        name  VARCHAR(60 ),
        symbol  VARCHAR(60 ),
        description  VARCHAR(60 ),
        longDescription  VARCHAR(60 ),
        iconUrl  VARCHAR(60 ),
        category  VARCHAR(60 ),
        chainListIcon  VARCHAR(60 ),
        rpcUrl  VARCHAR(60 ),
        id NUMBER,
        blockExplorerUrl  VARCHAR(60 )
    );

    create table if not exists chain_users (
        chainId NUMBER  auto_increment primary key,
        userId  VARCHAR(60 ),
        address  VARCHAR(60 ),
        privateKey  VARCHAR(60 ),
        publicKey  VARCHAR(60 ),
        mnemonic  VARCHAR(60 ),
        balance  VARCHAR(60 ),
        isDefault  VARCHAR(60 )
    );
    create table if not exists chain (
                                         chainId NUMBER  auto_increment primary key,
                                         name  VARCHAR(60 ),
                                         symbol  VARCHAR(60 ),
                                         description  VARCHAR(60 ),
                                         longDescription  VARCHAR(60 ),
                                         iconUrl  VARCHAR(60 ),
                                         category  VARCHAR(60 ),
                                         chainListIcon  VARCHAR(60 ),
                                         rpcUrl  VARCHAR(60 ),
                                         id NUMBER,
                                         blockExplorerUrl  VARCHAR(60 )
    );
    -- CREATE SEQUENCE IF NOT EXISTS user_seq;
    --
    -- CREATE TABLE IF NOT EXISTS user (
    --
    --     user_id BIGINT NOT NULL DEFAULT nextval('user_seq') PRIMARY KEY,
    --     email VARCHAR(100) NOT NULL,
    --     first_name VARCHAR(100) NOT NULL,
    --     last_name VARCHAR(100) NOT NULL
    --
    --     );

    -- CREATE SEQUENCE IF NOT EXISTS chain_seq;
-- CREATE TABLE IF NOT EXISTS chain (
--     chain_id BIGINT NOT NULL DEFAULT nextval('chain_seq') PRIMARY KEY,
--     name VARCHAR(100) NOT NULL,
--     stage VARCHAR(100) NOT NULL,
--     description VARCHAR(500) NOT NULL
--
--     );


-- CREATE TABLE IF NOT EXISTS chain_user (
--
--                                                 chain_id BIGINT REFERENCES chain,
--                                                 user_id BIGINT REFERENCES user
--
-- );
    CREATE TABLE  if not exists   ADDRESS
    (	ID NUMBER(10,0),      ADDRESS VARCHAR2(255 ),
         BLOCK_EXPLORER_URL VARCHAR2(255 ),
         CHAIN VARCHAR2(255 ),
         CHAIN_ID NUMBER(10,0),
         DESCRIPTION VARCHAR2(255 ),
         ICON_URL VARCHAR2(255 ),
         OWNER VARCHAR2(255 ),
         USER_ID NUMBER(10,0),
         USERID NUMBER(10,0),
         NFT_ID NUMBER(10,0),
         NFT_ADDRESS NUMBER(10,0),
         EMAIL VARCHAR2(255 ),
         NFT_ADDRESS_ID NUMBER(10,0),
         NFT_ADDRESS_NFT_ADDRESS_ID NUMBER(10,0)
    );
--     create table if not exists attribute (attrid NUMBER, trait_type varchar(255), valu varchar(255), metadata_metadata_id NUMBER, primary key (attrid));
    alter table chain add chain_id NUMBER  ;
    alter table chain add block_explorer_url varchar(255);
    alter table chain add chain_list_icon varchar(255);
    alter table chain add icon_url varchar(255);
    alter table chain add long_description varchar(255);
    alter table chain add rpc_url varchar(255);
    alter table chain_users add  chain_id NUMBER NOT NULL;
--     create table cointable (coinid NUMBER not null, coinsymbol varchar(255), cointoken varchar(255), pricetotal float(53), purchased NUMBER not null, primary key (coinid));
    CREATE TABLE COINTABLE
    (	COINID NUMBER(10,0)  NOT NULL,
         COINTOKEN VARCHAR2(30  ),
         COINSYMBOL VARCHAR2(10  ),
         PRICETOTAL NUMBER(10,2),
         PURCHASED NUMBER(1,0 )
    );
--     CREATE TABLE cointable (
--                                coinid NUMBER(10) NOT NULL,
--                                cointoken VARCHAR(30 ),
--                                coinsymbol VARCHAR(10 ),
--                                pricetotal NUMBER(10,2),
--                                purchased NUMBER(1));
--     commit;

--     CREATE TABLE nfttable (
--                               nftid NUMBER(10) NOT NULL UNIQUE,
--                               name VARCHAR(100),
--                               amount NUMBER(10),
--                               metadata  NUMBER(10) NOT NULL   );
--
--     CREATE TABLE nftMetadata (
--                                  metaid NUMBER(10) not null unique,
--                                  name VARCHAR(100),
--                                  description VARCHAR(400),
--                                  image VARCHAR(200),
--                                  attributes NUMBER(10) NOT NULL);

create table metadata (metadata_id NUMBER not null, description varchar(255), image varchar(255), name varchar(255), nft_id NUMBER, primary key (metadata_id));
    create table nft (id NUMBER not null, amount NUMBER not null, name varchar(255), metadata_id_metadata_id NUMBER, nft_address_nft_address_id NUMBER, primary key (id));
    create table nft_address (nft_address_id NUMBER generated by default as identity, address varchar(255), native_token float(53), native float(53), tokens float(24), primary key (nft_address_id));
    create table nft_ref (id NUMBER not null, address varchar(255), chain varchar(255), email varchar(255), name varchar(255), owner varchar(255), primary key (id));
    create table roles (id NUMBER not null, name varchar(255), primary key (id));
    create table weblinks (id NUMBER not null, downloadstatus smallint, host varchar(255), htmlpage varchar(255), url varchar(255), primary key (id));
    create sequence address_seq start with 10 increment by 1;
    create sequence attribute_seq start with 1000 increment by 1;
    create sequence chain_seq start with 100 increment by 1;
    create sequence cointable_seq start with 20 increment by 1;
    create sequence id_maker start with 2000 increment by 1;
    create sequence metadata_seq start with 200 increment by 1;
    create sequence nft_ref_seq start with 500 increment by 1;
    create sequence nft_seq start with 600 increment by 1;
    create sequence roles_seq start with 700 increment by 1;
    create sequence weblinks_seq start with 800 increment by 1;
    alter table  address add constraint FKsb9kcjn7av3aujmp83pagwiny foreign key (nft_address_id) references nft_address;
    alter table address add constraint FKt3i7rgmxmmkev35dxs947wasb foreign key (userid) references users;
    alter table attribute add constraint FKik918ybmves03ibw6l10jj8d2 foreign key (metadata_metadata_id) references metadata;
    alter table chain_users add constraint FKc12l3fx8me9k15hv0epjpjpbl foreign key (chain_id) references chain;
    alter table chain_users add constraint FK3psni4ui5db7mcih64fov3v39 foreign key (userid) references users;
    alter table metadata add constraint FK7xw0e76t7gnn5x9a254683a8 foreign key (nft_id) references nft;
    alter table nft add constraint FK7w00r1rprr2020ho6cbmwc5kh foreign key (metadata_id_metadata_id) references metadata;
    alter table nft add constraint FKav9aho8kdsp9rh22jdlocuy7r foreign key (nft_address_nft_address_id) references nft_address;