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


Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )
values (nextval('address_seq'), 'description', 'Tom1@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',
        'ropstein', 'ICON_URL', 'BLOCK_EXPLORER_URL', 1, 101);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )
values (nextval('address_seq'), 'description', 'Tom2@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  51, 151);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )
values (nextval('address_seq'), 'description', 'Tom3@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',  101,201);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )
values (nextval('address_seq'), 'description', 'Tom4@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'polygon', 'ICON_URL', 'BLOCK_EXPLORER_URL',  151, 251);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )
values (nextval('address_seq'), 'description', 'Tom5@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  201, 301);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )
values (nextval('address_seq'), 'description', 'Tom6@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'ropstein', 'ICON_URL', 'BLOCK_EXPLORER_URL', 251, 351);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )
values (nextval('address_seq'), 'description', 'Tom7@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',
        'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL', 301, 401);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )
values (nextval('address_seq'), 'description', 'Tom8@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',
        'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',  351, 451);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )
values (nextval('address_seq'), 'description', 'thomas.maestas@hotmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',
        'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL',  401, 501);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )
values (nextval('address_seq'), 'description', 'thomasm1.maestas@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',
        'goerli', 'ICON_URL', 'BLOCK_EXPLORER_URL', 451, 551);


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



INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (nextval('nft_seq'),'ethereum',5656,1);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (nextval('nft_seq'),'polygon',454,  2);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (nextval('nft_seq'),'avalanche',75757,3);

