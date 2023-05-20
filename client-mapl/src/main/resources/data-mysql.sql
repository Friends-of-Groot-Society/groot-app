-- INSERT userS

Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (nextval('ID_MAKER'), 'Tom1@gmail.com', 'password', 'Smith', 'Tom1', 3,  '5055087707',        'Tom1@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a1.jpg', 'photoPath', 0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (nextval('ID_MAKER'), 'Tom2@gmail.com', 'password', 'Maestas', 'Tom2', 3, '5055087707',        'Tom2@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a2.jpg','photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (nextval('ID_MAKER'),'Tom3@gmail.com', 'password', 'Smith', 'Tom3', 3,  '5055087707', 'Tom3@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a3.jpg', 'photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (nextval('ID_MAKER'),'Tom4@gmail.com', 'password', 'Smith', 'Tom4', 0, '5055087707', 'Tom4@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a4.jpg', 'photoPath',  0, 0);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (nextval('ID_MAKER'), 'Tom5@gmail.com', 'password', 'Smith', 'Tom5', 3, '5055087707','Tom5@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a6.jpg', 'photoPath',  0,    1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (nextval('ID_MAKER'), 'Tom6@gmail.com', 'password', 'Smith', 'Tom6', 3, '5055087707','Tom6@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a7.jpg', 'photoPath',  0,    1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (nextval('ID_MAKER'),'tom7@gmail.com', 'password', 'maestas', 'tom7', 4, '999-999-9999','tom7@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (nextval('ID_MAKER'),'Tom8@gmail.com', 'password', 'Smith', 'Tom8', 3,  '5055087707','Tom8@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath', 0,     1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (nextval('ID_MAKER'), 'thomas.maestas@hotmail.com', 'password', 'Maestas', 'thomas', 0, '5055087707','thomas.maestas@hotmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 0);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (nextval('ID_MAKER'), 'thomasm1.maestas@gmail.com', 'password', 'Maestas', 'thomasm1', 3, '5055087707','thomasm1.maestas@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 1);


-- INSERT CHAIN
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (nextval('chain_seq'), 'polygon', 'MATIC_2', 'matic  Chain', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/polygon.jpg', 'Mainnet', null, 'https://api.matic.network/ext/bc/C/rpc', 2402, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (nextval('chain_seq'), 'avalanche', 'avax', 'avalanche C-Chain', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/avax.png', 'Mainnet', null, 'https://api.avax.network/ext/bc/C/rpc', 3,        null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (nextval('chain_seq'), 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT   0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png', 'https://rpc.pulsechain.io', 4, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (nextval('chain_seq'), 'solana', 'sol', 'solana Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/solana.jpg', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png','https://api.mainnet-beta.solana.com', 3, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (nextval('chain_seq'), 'polygon', 'matic', 'polygon Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/polygon.jpg', 'Mainnet', null, ' https://rpc-mainnet.maticvigil.com/', 3,null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (nextval('chain_seq'), 'pulsechain', 'TPLS', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet', null, 'https://rpc.testnet.pulsechain.com',240, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (nextval('chain_seq'), 'ethereum', 'ETH23', 'ethereum Mainnet 23', 'NFT  0x1',        'https://s3.amazonaws.com/tmm.net/img/ether.png', 'ethereum', null, 'ETH RPC23', 3, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (nextval('chain_seq'), 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 4, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (nextval('chain_seq'), 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',  'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 434, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (nextval('chain_seq'), 'pulsechain7', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',        'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 23, null);
--
-- INSERT PROJECT_user_RELATION
insert into chain_users (userid, chain_id)
values (1, 101);
insert into chain_users (userid, chain_id)
values (51, 151);
insert into chain_users (userid, chain_id)
values (101, 201);
insert into chain_users (userid, chain_id)
values (151, 251);
insert into chain_users (userid, chain_id)
values (201, 301);
insert into chain_users (userid, chain_id)
values (251, 351);
insert into chain_users (userid, chain_id)
values (301, 401);
insert into chain_users (userid, chain_id)
values (351, 451);
insert into chain_users (userid, chain_id)
values (401, 501);
insert into chain_users (userid, chain_id)
values (451, 551);


Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'ethereum', 'ETH', 12000.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'polygon', 'MATIC', 9.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'binance', 'BNB', 19.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'avalanche', 'AVAX', 119.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'pulsechain', 'SAA', 123.33, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'Hex', 'HEX', 0.03, 1);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'ethereum', 'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'binance', 'bsc', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
values (nextval('cointable_seq'), 'binance', 'bnb', 45000, 0);


INSERT INTO ROLES (id, name) VALUES (2,'ROLE_ADMIN');
INSERT INTO ROLES (id, name) VALUES (1,'ROLE_USER');

insert into USERS_ROLES(id, userid, role_id)values (1, 211, 2);
insert into USERS_ROLES(id, userid, role_id)values (2, 212, 1);
insert into USERS_ROLES(id, userid, role_id)values (3, 213, 1);
insert into USERS_ROLES(id, userid, role_id)values (4, 214, 1);
insert into USERS_ROLES(id, userid, role_id)values (5, 215, 1);
insert into USERS_ROLES(id, userid, role_id)values (6, 215, 1);
insert into USERS_ROLES(id, userid, role_id)values (7, 216, 1);
insert into USERS_ROLES(id, userid, role_id)values (8, 217, 1);
insert into USERS_ROLES(id, userid, role_id)values (9, 218, 2);
insert into USERS_ROLES(id, userid, role_id)values (10,219,2);

