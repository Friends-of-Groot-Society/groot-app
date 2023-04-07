-- INSERT userS

Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
values (ID_MAKER.nextval, 'Tom1@gmail.com', 'password', 'Smith', 'Tom1', 3, 1, '5055087707',
        'Tom1@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a1.jpg',
        'photoPath', 'userGroup', 0, 1, '1');
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
values (ID_MAKER.nextval, 'Tom2@gmail.com', 'password', 'Maestas', 'Tom2', 3, 1, '5055087707',
        'Tom2@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a2.jpg',
        'photoPath', 'userGroup', 0, 1, '1');
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
values (ID_MAKER.nextval,'Tom3@gmail.com', 'password', 'Smith', 'Tom3', 3, 1, '5055087707', 'Tom3@gmail.com',
        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a3.jpg', 'photoPath', 'userGroup', 0, 1,
        '1');
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
values (ID_MAKER.nextval,'Tom4@gmail.com', 'password', 'Smith', 'Tom4', 0, 0, '5055087707', 'Tom4@gmail.com',
        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a4.jpg', 'photoPath', null, 0, 0, '5');
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
values (ID_MAKER.nextval, 'Tom5@gmail.com', 'password', 'Smith', 'Tom5', 3, 1, '5055087707','Tom5@gmail.com',
        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a6.jpg', 'photoPath', 'userGroup', 0, 1,
        '1');
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
values (ID_MAKER.nextval, 'Tom6@gmail.com', 'password', 'Smith', 'Tom6', 3, 1, '5055087707','Tom6@gmail.com',
        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a7.jpg', 'photoPath', 'userGroup', 0, 1,
        '5');
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
values (ID_MAKER.nextval,'tom7@gmail.com', 'password', 'maestas', 'tom7', 4, 2, '999-999-9999','tom7@gmail.com',
        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath', 'userGroup', 0, 1,
        '1');
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
values (ID_MAKER.nextval,'Tom8@gmail.com', 'password', 'Smith', 'Tom8', 3, 1, '5055087707','Tom8@gmail.com',
        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath', 'userGroup', 0, 1,
        '1');
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
values (ID_MAKER.nextval, 'thomas.maestas@hotmail.com', 'password', 'Maestas', 'thomas',0, 0, '5055087707','thomas.maestas@hotmail.com',
        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath', null, 0, 0, null);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
values (ID_MAKER.nextval, 'thomasm1.maestas@gmail.com', 'password', 'Maestas', 'thomasm1', 3, 1, '5055087707','thomasm1.maestas@gmail.com',
        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath', 'userGroup', 0, 1,
        '1');


-- INSERT CHAIN
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
values (chain_seq.nextval, 'polygon', 'MATIC_2', 'matic  Chain', 'NFT - 0x1',
        'https://s3.amazonaws.com/tmm.net/img/polygon.jpg', 'Mainnet', null, 'https://api.matic.network/ext/bc/C/rpc',
        2402, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
values (chain_seq.nextval, 'avalanche', 'avax', 'avalanche C-Chain', 'NFT - 0x1',
        'https://s3.amazonaws.com/tmm.net/img/avax.png', 'Mainnet', null, 'https://api.avax.network/ext/bc/C/rpc', 3,
        null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
values (chain_seq.nextval, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT   0x1',
        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',
        'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',
        'https://rpc.pulsechain.io', 4, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
values (chain_seq.nextval, 'solana', 'sol', 'solana Mainnet', 'NFT - 0x1',
        'https://s3.amazonaws.com/tmm.net/img/solana.jpg', 'Mainnet',
        'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',
        'https://api.mainnet-beta.solana.com', 3, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
values (chain_seq.nextval, 'polygon', 'matic', 'polygon Mainnet', 'NFT - 0x1',
        'https://s3.amazonaws.com/tmm.net/img/polygon.jpg', 'Mainnet', null, ' https://rpc-mainnet.maticvigil.com/', 3,
        null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
values (chain_seq.nextval, 'pulsechain', 'TPLS', 'pulsechain Mainnet', 'NFT - 0x1',
        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet', null, 'https://rpc.testnet.pulsechain.com',
        240, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
values (chain_seq.nextval, 'ethereum', 'ETH23', 'ethereum Mainnet 23', 'NFT  0x1',
        'https://s3.amazonaws.com/tmm.net/img/ether.png', 'ethereum', null, 'ETH RPC23', 3, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
values (chain_seq.nextval, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',
        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',
        'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',
        'https://rpc.pulsechain.io', 4, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
values (chain_seq.nextval, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',
        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',
        'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',
        'https://rpc.pulsechain.io', 434, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
values (chain_seq.nextval, 'pulsechain7', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',
        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',
        'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',
        'https://rpc.pulsechain.io', 23, null);


insert into CHAIN_USERS (id, userid, chain_id) values (chain_users_seq.nextval, 1, 101);
insert into CHAIN_USERS (id, userid, chain_id) values (chain_users_seq.nextval, 51, 151);
insert into CHAIN_USERS (id, userid, chain_id) values (chain_users_seq.nextval, 101, 201);
insert into CHAIN_USERS (id, userid, chain_id) values (chain_users_seq.nextval, 151, 251);
insert into CHAIN_USERS (id, userid, chain_id) values (chain_users_seq.nextval, 201, 301);
insert into CHAIN_USERS (id, userid, chain_id) values (chain_users_seq.nextval, 251, 351);
insert into CHAIN_USERS (id, userid, chain_id) values (chain_users_seq.nextval, 301, 401);
insert into CHAIN_USERS (id, userid, chain_id) values (chain_users_seq.nextval, 351, 451);
insert into CHAIN_USERS (id, userid, chain_id) values (chain_users_seq.nextval, 401, 501);
insert into CHAIN_USERS (id, userid, chain_id) values (chain_users_seq.nextval, 451, 551);


-- SQLINES LICENSE FOR EVALUATION USE ONLY
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )
values (address_seq.nextval, 'description', 'Tom1@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',
        'ropstein', 'ICON_URL', 'BLOCK_EXPLORER_URL', 1, 101);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )
values (address_seq.nextval, 'description', 'Tom2@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  51, 151);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )
values (address_seq.nextval, 'description', 'Tom3@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',  101,201);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )
values (address_seq.nextval, 'description', 'Tom4@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'polygon', 'ICON_URL', 'BLOCK_EXPLORER_URL',  151, 251);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )
values (address_seq.nextval, 'description', 'Tom5@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  201, 301);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )
values (address_seq.nextval, 'description', 'Tom6@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'ropstein', 'ICON_URL', 'BLOCK_EXPLORER_URL', 251, 351);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )
values (address_seq.nextval, 'description', 'Tom7@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',
        'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL', 301, 401);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )
values (address_seq.nextval, 'description', 'Tom8@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',
        'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',  351, 451);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )
values (address_seq.nextval, 'description', 'thomas.maestas@hotmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',
        'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  401, 501);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )
values (address_seq.nextval, 'description', 'thomasm1.maestas@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'goerli', 'ICON_URL', 'BLOCK_EXPLORER_URL', 451, 551);


Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'ethereum', 'ETH', 12000.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'polygon', 'MATIC', 9.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'binance', 'BNB', 19.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'avalanche', 'AVAX', 119.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'pulsechain', 'SAA', 123.33, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'Hex', 'HEX', 0.03, 1);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'binance', 'bsc', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (cointable_seq.nextval, 'binance', 'bnb', 45000, 0);

INsert into WEBLINKS ( id ,downloadstatus ,host, htmlpage,url) values (weblinks_seq.nextval,0,'https://www.coingecko.com/en/coins/pulsechain','https://www.coingecko.com/en/coins/pulsechain','https://www.coingecko.com/en/coins/pulsechain');
INsert into WEBLINKS ( id ,downloadstatus ,host, htmlpage,url) values (weblinks_seq.nextval,0,'https://www.coingecko.com/en/coins/pulsechain','https://www.coingecko.com/en/coins/pulsechain','https://www.coingecko.com/en/coins/pulsechain');
INsert into WEBLINKS ( id ,downloadstatus ,host, htmlpage,url) values (weblinks_seq.nextval,0,'https://www.coingecko.com/en/coins/pulsechain','https://www.coingecko.com/en/coins/pulsechain','https://www.coingecko.com/en/coins/pulsechain');
INsert into WEBLINKS ( id ,downloadstatus ,host, htmlpage,url) values (weblinks_seq.nextval,0,'https://www.coingecko.com/en/coins/pulsechain','https://www.coingecko.com/en/coins/pulsechain','https://www.coingecko.com/en/coins/pulsechain');
INsert into WEBLINKS ( id ,downloadstatus ,host, htmlpage,url) values (weblinks_seq.nextval,0,'https://www.coingecko.com/en/coins/pulsechain','https://www.coingecko.com/en/coins/pulsechain','https://www.coingecko.com/en/coins/pulsechain');



INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID_METADATA_ID) VALUES (nft_seq.nextval,'ethereum',5656,1);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID_METADATA_ID) VALUES (nft_seq.nextval,'polygon',454,  2);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID_METADATA_ID) VALUES (nft_seq.nextval,'avalanche',75757,3);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID_METADATA_ID) VALUES (nft_seq.nextval,'binance',5656,4);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID_METADATA_ID) VALUES (nft_seq.nextval,'ethereum',5656,5);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID_METADATA_ID) VALUES (nft_seq.nextval,'ethereum',5656,6);

INSERT INTO METADATA (METADATA_ID,NAME,DESCRIPTION,IMAGE,NFT_ID) VALUES (metadata_seq.nextval,'ethereum','ethereum','https://www.coingecko.com/en/coins/pulsechain',1);
INSERT INTO METADATA (METADATA_ID,NAME,DESCRIPTION,IMAGE,nft_id) VALUES (metadata_seq.nextval,'polygon','polygon','https://www.coingecko.com/en/coins/pulsechain',1);
INSERT INTO METADATA (METADATA_ID,NAME,DESCRIPTION,IMAGE,nft_id) VALUES (metadata_seq.nextval,'avalanche','avalanche','https://www.coingecko.com/en/coins/pulsechain',1);
INSERT INTO METADATA (METADATA_ID,NAME,DESCRIPTION,IMAGE,nft_id) VALUES (metadata_seq.nextval,'binance','binance','https://www.coingecko.com/en/coins/pulsechain',1);
INSERT INTO METADATA (METADATA_ID,NAME,DESCRIPTION,IMAGE,nft_id) VALUES (metadata_seq.nextval,'ethereum','ethereum','https://www.coingecko.com/en/coins/pulsechain',1);
INSERT INTO METADATA (METADATA_ID,NAME,DESCRIPTION,IMAGE,nft_id) VALUES (metadata_seq.nextval,'ethereum','ethereum','https://www.coingecko.com/en/coins/pulsechain',1);



-- SELECT u.firstname as firstName, u.lastname as lastName, COUNT(cu.userid) as chainCount FROM CHAIN_USERS cu left join USERS u ON u.userid = cu.userid;
-- SELECT u.firstname as firstName, u.lastname as lastName, COUNT(cu.userid) as chainCount FROM CHAINUSERS u left join CHAIN_USERS cu ON cu.userid = u.userid GROUP BY  u.lastname ORDER BY  chainCount;
