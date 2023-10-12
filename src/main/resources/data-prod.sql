

Insert into USERS (USERS.USERID, USERS.USERNAME, USERS.PASSWORD, USERS.LASTNAME, USERS.FIRSTNAME, USERS.USERTYPE, USERS.PHONE, USERS.EMAIL, USERS.CUSURL, USERS.PHOTOPATH, USERS.ISACTIVE, USERS.CONTACTTYPE)values (211, 'Tom1@gmail.com',            '$2a$10$I7m.Qj.5UwBlL2uiVQqyI.pyNbVFMpeD/H81OvFxV5BRiz8FHcShy', 'Smith', 'Tom1', 3,  '5055087707',        'Tom1@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a1.jpg', 'photoPath', 0, 1);
Insert into USERS (USERS.USERID, USERS.USERNAME, USERS.PASSWORD, USERS.LASTNAME, USERS.FIRSTNAME, USERS.USERTYPE, USERS.PHONE, USERS.EMAIL, USERS.CUSURL, USERS.PHOTOPATH, USERS.ISACTIVE, USERS.CONTACTTYPE)values (212, 'Tom2@gmail.com',            '$2a$10$lCq.Iea1zFOt7lFMB1eoQuqQr6tihZB78SnEee1oSfrt107TSge0m', 'Maestas', 'Tom2', 3, '5055087707',        'Tom2@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a2.jpg','photoPath',  0, 1);
Insert into USERS (USERS.USERID, USERS.USERNAME, USERS.PASSWORD, USERS.LASTNAME, USERS.FIRSTNAME, USERS.USERTYPE, USERS.PHONE, USERS.EMAIL, USERS.CUSURL, USERS.PHOTOPATH, USERS.ISACTIVE, USERS.CONTACTTYPE)values (213,'Tom3@gmail.com',             '$2a$10$lCq.Iea1zFOt7lFMB1eoQuqQr6tihZB78SnEee1oSfrt107TSge0m', 'Smith', 'Tom3', 3,  '5055087707', 'Tom3@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a3.jpg', 'photoPath',  0, 1);
Insert into USERS (USERS.USERID, USERS.USERNAME, USERS.PASSWORD, USERS.LASTNAME, USERS.FIRSTNAME, USERS.USERTYPE, USERS.PHONE, USERS.EMAIL, USERS.CUSURL, USERS.PHOTOPATH, USERS.ISACTIVE, USERS.CONTACTTYPE)values (214,'Tom4@gmail.com',             '$2a$10$lCq.Iea1zFOt7lFMB1eoQuqQr6tihZB78SnEee1oSfrt107TSge0m', 'Smith', 'Tom4', 0, '5055087707', 'Tom4@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a4.jpg', 'photoPath',  0, 0);
Insert into USERS (USERS.USERID, USERS.USERNAME, USERS.PASSWORD, USERS.LASTNAME, USERS.FIRSTNAME, USERS.USERTYPE, USERS.PHONE, USERS.EMAIL, USERS.CUSURL, USERS.PHOTOPATH, USERS.ISACTIVE, USERS.CONTACTTYPE)values (215, 'Tom5@gmail.com',            '$2a$10$lCq.Iea1zFOt7lFMB1eoQuqQr6tihZB78SnEee1oSfrt107TSge0m', 'Smith', 'Tom5', 3, '5055087707','Tom5@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a6.jpg', 'photoPath',  0,    1);
Insert into USERS (USERS.USERID, USERS.USERNAME, USERS.PASSWORD, USERS.LASTNAME, USERS.FIRSTNAME, USERS.USERTYPE, USERS.PHONE, USERS.EMAIL, USERS.CUSURL, USERS.PHOTOPATH, USERS.ISACTIVE, USERS.CONTACTTYPE)values (216,'tom7@gmail.com',             '$2a$10$lCq.Iea1zFOt7lFMB1eoQuqQr6tihZB78SnEee1oSfrt107TSge0m', 'maestas', 'tom7', 4, '999-999-9999','tom7@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 1);
Insert into USERS (USERS.USERID, USERS.USERNAME, USERS.PASSWORD, USERS.LASTNAME, USERS.FIRSTNAME, USERS.USERTYPE, USERS.PHONE, USERS.EMAIL, USERS.CUSURL, USERS.PHOTOPATH, USERS.ISACTIVE, USERS.CONTACTTYPE)values (217,'Tom8@gmail.com',             '$2a$10$lCq.Iea1zFOt7lFMB1eoQuqQr6tihZB78SnEee1oSfrt107TSge0m', 'Smith', 'Tom8', 3,  '5055087707','Tom8@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath', 0,     1);
Insert into USERS (USERS.USERID, USERS.USERNAME, USERS.PASSWORD, USERS.LASTNAME, USERS.FIRSTNAME, USERS.USERTYPE, USERS.PHONE, USERS.EMAIL, USERS.CUSURL, USERS.PHOTOPATH, USERS.ISACTIVE, USERS.CONTACTTYPE)values (218, 'thomas.maestas@hotmail.com','$2a$10$I7m.Qj.5UwBlL2uiVQqyI.pyNbVFMpeD/H81OvFxV5BRiz8FHcShy', 'Maestas', 'thomas', 0, '5055087707','thomas.maestas@hotmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 0);
Insert into USERS (USERS.USERID, USERS.USERNAME, USERS.PASSWORD, USERS.LASTNAME, USERS.FIRSTNAME, USERS.USERTYPE, USERS.PHONE, USERS.EMAIL, USERS.CUSURL, USERS.PHOTOPATH, USERS.ISACTIVE, USERS.CONTACTTYPE)values (219, 'thomasm1.maestas@gmail.com','$2a$10$I7m.Qj.5UwBlL2uiVQqyI.pyNbVFMpeD/H81OvFxV5BRiz8FHcShy', 'Maestas', 'thomasm1', 3, '5055087707','thomasm1.maestas@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 1);


INSERT INTO ROLES (ROLES.id, ROLES.name) VALUES (2,'ROLE_ADMIN');
INSERT INTO ROLES (ROLES.id, ROLES.name) VALUES (1,'ROLE_USER');

INSERT into USERS_ROLES (USERS_ROLES.ID, USERS_ROLES.USERID, USERS_ROLES.ROLE_ID) VALUES (1,211,2);
INSERT into USERS_ROLES (USERS_ROLES.ID, USERS_ROLES.USERID, USERS_ROLES.ROLE_ID) VALUES (2,212,2);
INSERT into USERS_ROLES (USERS_ROLES.ID, USERS_ROLES.USERID, USERS_ROLES.ROLE_ID) VALUES (3,213,2);
INSERT into USERS_ROLES (USERS_ROLES.ID, USERS_ROLES.USERID, USERS_ROLES.ROLE_ID) VALUES (4,214,2);
INSERT into USERS_ROLES (USERS_ROLES.ID, USERS_ROLES.USERID, USERS_ROLES.ROLE_ID) VALUES (5,215,1);
INSERT into USERS_ROLES (USERS_ROLES.ID, USERS_ROLES.USERID, USERS_ROLES.ROLE_ID) VALUES (6,216,1);
INSERT into USERS_ROLES (USERS_ROLES.ID, USERS_ROLES.USERID, USERS_ROLES.ROLE_ID) VALUES (7,217,1);
INSERT into USERS_ROLES (USERS_ROLES.ID, USERS_ROLES.USERID, USERS_ROLES.ROLE_ID) VALUES (8,218,1);
INSERT into USERS_ROLES (USERS_ROLES.ID, USERS_ROLES.USERID, USERS_ROLES.ROLE_ID) VALUES (9,219,1);



-- INSERT CHAIN
Insert into CHAIN (CHAIN.CHAIN_ID, CHAIN.NAME, CHAIN.SYMBOL, CHAIN.DESCRIPTION, CHAIN.LONG_DESCRIPTION, CHAIN.ICON_URL, CHAIN.CATEGORY, CHAIN.CHAIN_LIST_ICON, CHAIN.RPC_URL,CHAIN.ID, CHAIN.BLOCK_EXPLORER_URL)values (11501, 'polygon', 'MATIC_2', 'matic  Chain', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/polygon.jpg', 'Mainnet', null, 'https://api.matic.network/ext/bc/C/rpc', 2402, null );
Insert into CHAIN (CHAIN.CHAIN_ID, CHAIN.NAME, CHAIN.SYMBOL, CHAIN.DESCRIPTION, CHAIN.LONG_DESCRIPTION, CHAIN.ICON_URL, CHAIN.CATEGORY, CHAIN.CHAIN_LIST_ICON, CHAIN.RPC_URL,CHAIN.ID, CHAIN.BLOCK_EXPLORER_URL)values (11551, 'avalanche', 'avax', 'avalanche C-Chain', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/avax.png', 'Mainnet', null, 'https://api.avax.network/ext/bc/C/rpc', 3,        null );
Insert into CHAIN (CHAIN.CHAIN_ID, CHAIN.NAME, CHAIN.SYMBOL, CHAIN.DESCRIPTION, CHAIN.LONG_DESCRIPTION, CHAIN.ICON_URL, CHAIN.CATEGORY, CHAIN.CHAIN_LIST_ICON, CHAIN.RPC_URL,CHAIN.ID, CHAIN.BLOCK_EXPLORER_URL)values (11601, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT   0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png', 'https://rpc.pulsechain.io', 4, null);
Insert into CHAIN (CHAIN.CHAIN_ID, CHAIN.NAME, CHAIN.SYMBOL, CHAIN.DESCRIPTION, CHAIN.LONG_DESCRIPTION, CHAIN.ICON_URL, CHAIN.CATEGORY, CHAIN.CHAIN_LIST_ICON, CHAIN.RPC_URL,CHAIN.ID, CHAIN.BLOCK_EXPLORER_URL)values (11651, 'solana', 'sol', 'solana Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/solana.jpg', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png','https://api.mainnet-beta.solana.com', 3, null);
Insert into CHAIN (CHAIN.CHAIN_ID, CHAIN.NAME, CHAIN.SYMBOL, CHAIN.DESCRIPTION, CHAIN.LONG_DESCRIPTION, CHAIN.ICON_URL, CHAIN.CATEGORY, CHAIN.CHAIN_LIST_ICON, CHAIN.RPC_URL,CHAIN.ID, CHAIN.BLOCK_EXPLORER_URL)values (11701, 'polygon', 'matic', 'polygon Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/polygon.jpg', 'Mainnet', null, ' https://rpc-mainnet.maticvigil.com/', 3,null);
Insert into CHAIN (CHAIN.CHAIN_ID, CHAIN.NAME, CHAIN.SYMBOL, CHAIN.DESCRIPTION, CHAIN.LONG_DESCRIPTION, CHAIN.ICON_URL, CHAIN.CATEGORY, CHAIN.CHAIN_LIST_ICON, CHAIN.RPC_URL,CHAIN.ID, CHAIN.BLOCK_EXPLORER_URL)values (11751, 'pulsechain', 'TPLS', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet', null, 'https://rpc.testnet.pulsechain.com',240, null);
Insert into CHAIN (CHAIN.CHAIN_ID, CHAIN.NAME, CHAIN.SYMBOL, CHAIN.DESCRIPTION, CHAIN.LONG_DESCRIPTION, CHAIN.ICON_URL, CHAIN.CATEGORY, CHAIN.CHAIN_LIST_ICON, CHAIN.RPC_URL,CHAIN.ID, CHAIN.BLOCK_EXPLORER_URL)values (11801, 'ethereum', 'ETH23', 'ethereum Mainnet 23', 'NFT  0x1',        'https://s3.amazonaws.com/tmm.net/img/ether.png', 'ethereum', null, 'ETH RPC23', 3, null);
Insert into CHAIN (CHAIN.CHAIN_ID, CHAIN.NAME, CHAIN.SYMBOL, CHAIN.DESCRIPTION, CHAIN.LONG_DESCRIPTION, CHAIN.ICON_URL, CHAIN.CATEGORY, CHAIN.CHAIN_LIST_ICON, CHAIN.RPC_URL,CHAIN.ID, CHAIN.BLOCK_EXPLORER_URL)values (11851, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 4, null);
Insert into CHAIN (CHAIN.CHAIN_ID, CHAIN.NAME, CHAIN.SYMBOL, CHAIN.DESCRIPTION, CHAIN.LONG_DESCRIPTION, CHAIN.ICON_URL, CHAIN.CATEGORY, CHAIN.CHAIN_LIST_ICON, CHAIN.RPC_URL,CHAIN.ID, CHAIN.BLOCK_EXPLORER_URL)values (11901, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',  'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 434, null);
Insert into CHAIN (CHAIN.CHAIN_ID, CHAIN.NAME, CHAIN.SYMBOL, CHAIN.DESCRIPTION, CHAIN.LONG_DESCRIPTION, CHAIN.ICON_URL, CHAIN.CATEGORY, CHAIN.CHAIN_LIST_ICON, CHAIN.RPC_URL,CHAIN.ID, CHAIN.BLOCK_EXPLORER_URL)values (11951, 'pulsechain7', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',        'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 23, null);

-- -- INSERT PROJECT_user_RELATION
insert into chain_users (CHAIN_USERS.id, CHAIN_USERS.userid, CHAIN_USERS.chain_id)values (1, 211, 11501);
insert into chain_users (CHAIN_USERS.id, CHAIN_USERS.userid, CHAIN_USERS.chain_id)values (2, 212, 11551);
insert into chain_users (CHAIN_USERS.id, CHAIN_USERS.userid, CHAIN_USERS.chain_id)values (3, 213, 11601);
insert into chain_users (CHAIN_USERS.id, CHAIN_USERS.userid, CHAIN_USERS.chain_id)values (4, 214, 11651);
insert into chain_users (CHAIN_USERS.id, CHAIN_USERS.userid, CHAIN_USERS.chain_id)values (5, 215, 11701);
insert into chain_users (CHAIN_USERS.id, CHAIN_USERS.userid, CHAIN_USERS.chain_id)values (6, 215, 11751);
insert into chain_users (CHAIN_USERS.id, CHAIN_USERS.userid, CHAIN_USERS.chain_id)values (7, 216, 11801);
insert into chain_users (CHAIN_USERS.id, CHAIN_USERS.userid, CHAIN_USERS.chain_id)values (8, 217, 11851);
insert into chain_users (CHAIN_USERS.id, CHAIN_USERS.userid, CHAIN_USERS.chain_id)values (9, 218, 11901);
insert into chain_users (CHAIN_USERS.id, CHAIN_USERS.userid, CHAIN_USERS.chain_id)values (10, 219,11951);


Insert into ADDRESS (ADDRESS.ID, ADDRESS.DESCRIPTION, ADDRESS.EMAIL, ADDRESS.ADDRESS, ADDRESS.CHAIN, ADDRESS.ICON_URL, ADDRESS.BLOCK_EXPLORER_URL, ADDRESS.USERS_USERID, ADDRESS.CHAIN_ID )values (1, 'description', 'Tom1@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',             'ropstein', 'ICON_URL', 'BLOCK_EXPLORER_URL', 1, 101);
Insert into ADDRESS (ADDRESS.ID, ADDRESS.DESCRIPTION, ADDRESS.EMAIL, ADDRESS.ADDRESS, ADDRESS.CHAIN, ADDRESS.ICON_URL, ADDRESS.BLOCK_EXPLORER_URL, ADDRESS.USERS_USERID, ADDRESS.CHAIN_ID )values (2, 'description', 'Tom2@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',             'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  51, 151);
Insert into ADDRESS (ADDRESS.ID, ADDRESS.DESCRIPTION, ADDRESS.EMAIL, ADDRESS.ADDRESS, ADDRESS.CHAIN, ADDRESS.ICON_URL, ADDRESS.BLOCK_EXPLORER_URL, ADDRESS.USERS_USERID, ADDRESS.CHAIN_ID )values (3, 'description', 'Tom3@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',             'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',  101,201);
Insert into ADDRESS (ADDRESS.ID, ADDRESS.DESCRIPTION, ADDRESS.EMAIL, ADDRESS.ADDRESS, ADDRESS.CHAIN, ADDRESS.ICON_URL, ADDRESS.BLOCK_EXPLORER_URL,  ADDRESS.USERS_USERID, ADDRESS.CHAIN_ID )values(4, 'description', 'Tom4@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',            'polygon', 'ICON_URL', 'BLOCK_EXPLORER_URL',  151, 251);
Insert into ADDRESS (ADDRESS.ID, ADDRESS.DESCRIPTION, ADDRESS.EMAIL, ADDRESS.ADDRESS, ADDRESS.CHAIN, ADDRESS.ICON_URL, ADDRESS.BLOCK_EXPLORER_URL,  ADDRESS.USERS_USERID, ADDRESS.CHAIN_ID )values(5, 'description', 'Tom5@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',            'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  201, 301);
Insert into ADDRESS (ADDRESS.ID, ADDRESS.DESCRIPTION, ADDRESS.EMAIL, ADDRESS.ADDRESS, ADDRESS.CHAIN, ADDRESS.ICON_URL, ADDRESS.BLOCK_EXPLORER_URL, ADDRESS.USERS_USERID, ADDRESS.CHAIN_ID )values (6, 'description', 'Tom6@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',             'ropstein', 'ICON_URL', 'BLOCK_EXPLORER_URL', 251, 351);
Insert into ADDRESS (ADDRESS.ID, ADDRESS.DESCRIPTION, ADDRESS.EMAIL, ADDRESS.ADDRESS, ADDRESS.CHAIN, ADDRESS.ICON_URL, ADDRESS.BLOCK_EXPLORER_URL,  ADDRESS.USERS_USERID, ADDRESS.CHAIN_ID )values(7, 'description', 'Tom7@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',            'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL', 301, 401);
Insert into ADDRESS (ADDRESS.ID, ADDRESS.DESCRIPTION, ADDRESS.EMAIL, ADDRESS.ADDRESS, ADDRESS.CHAIN, ADDRESS.ICON_URL, ADDRESS.BLOCK_EXPLORER_URL,  ADDRESS.USERS_USERID, ADDRESS.CHAIN_ID )values(8, 'description', 'Tom8@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',            'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',  351, 451);
Insert into ADDRESS (ADDRESS.ID, ADDRESS.DESCRIPTION, ADDRESS.EMAIL, ADDRESS.ADDRESS, ADDRESS.CHAIN, ADDRESS.ICON_URL, ADDRESS.BLOCK_EXPLORER_URL,  ADDRESS.USERS_USERID, ADDRESS.CHAIN_ID )values(9, 'description', 'thomas.maestas@hotmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF','polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  401, 501);
Insert into ADDRESS (ADDRESS.ID, ADDRESS.DESCRIPTION, ADDRESS.EMAIL, ADDRESS.ADDRESS, ADDRESS.CHAIN, ADDRESS.ICON_URL, ADDRESS.BLOCK_EXPLORER_URL, ADDRESS.USERS_USERID, ADDRESS.CHAIN_ID )values (10, 'description', 'thomasm1.maestas@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A', 'goerli', 'ICON_URL', 'BLOCK_EXPLORER_URL', 451, 551);


Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (1, 'ethereum',   'ETH', 12000.22, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (2, 'polygon',    'MATIC', 9.22, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (3, 'binance',    'BNB', 19.22, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (4, 'avalanche',  'AVAX', 119.22, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (5, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (6, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (7, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (8, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (9, 'pulsechain', 'SAA', 123.33, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (10, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (11, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (12, 'Hex',        'HEX', 0.03, 1);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (13, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (14, 'binance',    'bsc', 45000, 0);
Insert into COINTABLE (COINTABLE.COINID, COINTABLE.COINTOKEN, COINTABLE.COINSYMBOL, COINTABLE.PRICETOTAL, COINTABLE.PURCHASED)values (15, 'binance',    'bnb', 45000, 0);

INSERT INTO NFT (NFT.ID,NFT.NAME,NFT.AMOUNT,NFT.METADATA_ID) VALUES (1001,'ethereum',5656,1);
INSERT INTO NFT (NFT.ID,NFT.NAME,NFT.AMOUNT,NFT.METADATA_ID) VALUES (4001,'ethereum',5656,1);
INSERT INTO NFT (NFT.ID,NFT.NAME,NFT.AMOUNT,NFT.METADATA_ID) VALUES (4002,'polygon',454,  2);
INSERT INTO NFT (NFT.ID,NFT.NAME,NFT.AMOUNT,NFT.METADATA_ID) VALUES (4003,'avalanche',75757,3);
INSERT INTO NFT (NFT.ID,NFT.NAME,NFT.AMOUNT,NFT.METADATA_ID) VALUES (4004,'ethereum',5656,1);

