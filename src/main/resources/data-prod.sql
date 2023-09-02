

Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (211, 'Tom1@gmail.com', 'password', 'Smith', 'Tom1', 3,  '5055087707',        'Tom1@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a1.jpg', 'photoPath', 0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (212, 'Tom2@gmail.com', 'password', 'Maestas', 'Tom2', 3, '5055087707',        'Tom2@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a2.jpg','photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (213,'Tom3@gmail.com', 'password', 'Smith', 'Tom3', 3,  '5055087707', 'Tom3@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a3.jpg', 'photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (214,'Tom4@gmail.com', 'password', 'Smith', 'Tom4', 0, '5055087707', 'Tom4@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a4.jpg', 'photoPath',  0, 0);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (215, 'Tom5@gmail.com', 'password', 'Smith', 'Tom5', 3, '5055087707','Tom5@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a6.jpg', 'photoPath',  0,    1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (216,'tom7@gmail.com', 'password', 'maestas', 'tom7', 4, '999-999-9999','tom7@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (217,'Tom8@gmail.com', 'password', 'Smith', 'Tom8', 3,  '5055087707','Tom8@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath', 0,     1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (218, 'thomas.maestas@hotmail.com', 'password', 'Maestas', 'thomas', 0, '5055087707','thomas.maestas@hotmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 0);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (219, 'thomasm1.maestas@gmail.com', 'password', 'Maestas', 'thomasm1', 3, '5055087707','thomasm1.maestas@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 1);


INSERT INTO ROLES (id, name) VALUES (2,'ROLE_ADMIN');
INSERT INTO ROLES (id, name) VALUES (1,'ROLE_USER');

INSERT into USERS_ROLES (ID, ROLE_ID, USER_USERID, USERID) VALUES (1,2,211,211);
INSERT into USERS_ROLES (ID, ROLE_ID, USER_USERID, USERID) VALUES (2,2,212,212);
INSERT into USERS_ROLES (ID, ROLE_ID, USER_USERID, USERID) VALUES (3,2,213,213);
INSERT into USERS_ROLES (ID, ROLE_ID, USER_USERID, USERID) VALUES (4,2,214,214);
INSERT into USERS_ROLES (ID, ROLE_ID, USER_USERID, USERID) VALUES (5,2,215,215);
INSERT into USERS_ROLES (ID, ROLE_ID, USER_USERID, USERID) VALUES (6,2,216,216);
INSERT into USERS_ROLES (ID, ROLE_ID, USER_USERID, USERID) VALUES (7,2,217,217);
INSERT into USERS_ROLES (ID, ROLE_ID, USER_USERID, USERID) VALUES (8,2,218,218);
INSERT into USERS_ROLES (ID, ROLE_ID, USER_USERID, USERID) VALUES (9,2,219,219);



-- INSERT CHAIN
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11501, 'polygon', 'MATIC_2', 'matic  Chain', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/polygon.jpg', 'Mainnet', null, 'https://api.matic.network/ext/bc/C/rpc', 2402, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11551, 'avalanche', 'avax', 'avalanche C-Chain', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/avax.png', 'Mainnet', null, 'https://api.avax.network/ext/bc/C/rpc', 3,        null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11601, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT   0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png', 'https://rpc.pulsechain.io', 4, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11651, 'solana', 'sol', 'solana Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/solana.jpg', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png','https://api.mainnet-beta.solana.com', 3, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11701, 'polygon', 'matic', 'polygon Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/polygon.jpg', 'Mainnet', null, ' https://rpc-mainnet.maticvigil.com/', 3,null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11751, 'pulsechain', 'TPLS', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet', null, 'https://rpc.testnet.pulsechain.com',240, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11801, 'ethereum', 'ETH23', 'ethereum Mainnet 23', 'NFT  0x1',        'https://s3.amazonaws.com/tmm.net/img/ether.png', 'ethereum', null, 'ETH RPC23', 3, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11851, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 4, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11901, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',  'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 434, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11951, 'pulsechain7', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',        'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 23, null);

-- -- INSERT PROJECT_user_RELATION
insert into chain_users (CHAIN_USERS.id, userid, chain_id)values (1, 211, 11501);
insert into chain_users (CHAIN_USERS.id, userid, chain_id)values (2, 212, 11551);
insert into chain_users (CHAIN_USERS.id, userid, chain_id)values (3, 213, 11601);
insert into chain_users (CHAIN_USERS.id, userid, chain_id)values (4, 214, 11651);
insert into chain_users (CHAIN_USERS.id, userid, chain_id)values (5, 215, 11701);
insert into chain_users (CHAIN_USERS.id, userid, chain_id)values (6, 215, 11751);
insert into chain_users (CHAIN_USERS.id, userid, chain_id)values (7, 216, 11801);
insert into chain_users (CHAIN_USERS.id, userid, chain_id)values (8, 217, 11851);
insert into chain_users (CHAIN_USERS.id, userid, chain_id)values (9, 218, 11901);
insert into chain_users (CHAIN_USERS.id, userid, chain_id)values (10, 219,11951);


Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERS_USERID, CHAIN_ID )values (address_seq.nextval, 'description', 'Tom1@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',             'ropstein', 'ICON_URL', 'BLOCK_EXPLORER_URL', 1, 101);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERS_USERID, CHAIN_ID )values (address_seq.nextval, 'description', 'Tom2@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',             'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  51, 151);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERS_USERID, CHAIN_ID )values (address_seq.nextval, 'description', 'Tom3@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',             'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',  101,201);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERS_USERID, CHAIN_ID )values (address_seq.nextval, 'description', 'Tom4@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',            'polygon', 'ICON_URL', 'BLOCK_EXPLORER_URL',  151, 251);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERS_USERID, CHAIN_ID )values (address_seq.nextval, 'description', 'Tom5@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',            'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  201, 301);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERS_USERID, CHAIN_ID )values (address_seq.nextval, 'description', 'Tom6@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',             'ropstein', 'ICON_URL', 'BLOCK_EXPLORER_URL', 251, 351);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERS_USERID, CHAIN_ID )values (address_seq.nextval, 'description', 'Tom7@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',            'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL', 301, 401);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERS_USERID, CHAIN_ID )values (address_seq.nextval, 'description', 'Tom8@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',            'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',  351, 451);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERS_USERID, CHAIN_ID )values (address_seq.nextval, 'description', 'thomas.maestas@hotmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF','polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  401, 501);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERS_USERID, CHAIN_ID )values (address_seq.nextval, 'description', 'thomasm1.maestas@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A', 'goerli', 'ICON_URL', 'BLOCK_EXPLORER_URL', 451, 551);


Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'ethereum',   'ETH', 12000.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'polygon',    'MATIC', 9.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'binance',    'BNB', 19.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'avalanche',  'AVAX', 119.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'pulsechain', 'SAA', 123.33, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'Hex',        'HEX', 0.03, 1);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'binance',    'bsc', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (cointable_seq.nextval, 'binance',    'bnb', 45000, 0);

INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (nft_seq.nextval,'ethereum',5656,1);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (nft_seq.nextval,'polygon',454,  2);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (nft_seq.nextval,'avalanche',75757,3);

