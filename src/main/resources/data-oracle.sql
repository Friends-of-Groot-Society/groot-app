-- Test data for USERS
INSERT INTO USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
VALUES (ID_MAKER.NEXTVAL, 'user4@cryptomaven.xyz', 'password', 'Smith', 'Tom', 3, 1, '5055087707',
        'user1@cryptomaven.xyz', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a1.jpg',
        'photoPath', 'userGroup', 0, 1, '1');

INSERT INTO USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
VALUES (ID_MAKER.NEXTVAL, 'thomasm1.maestas@gmail.com', 'password', 'Maestas', 'Tom', 3, 1, '5055087707',
        'user2@cryptomaven.xyz', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a2.jpg',
        'photoPath', 'userGroup', 0, 1, '1');

INSERT INTO USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, GROUPS, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH,
                   USERGROUP, ISACTIVE, CONTACTTYPE, ID)
VALUES (ID_MAKER.NEXTVAL, 'testtest648', 'passwordX', 'Smith', 'Tom', 3, 1, '5055087707', 'user3@cryptomaven.xyz',
        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a3.jpg', 'photoPath', 'userGroup', 0, 1,
        '1');

-- Test data for roles
INSERT INTO roles (id, name)
VALUES (roles_seq.nextval, 'ROLE_USER');



-- INSERT CHAIN
INSERT INTO CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
VALUES (CHAIN_SEQ.NEXTVAL, 'polygon', 'MATIC_2', 'matic  Chain', 'NFT - 0x1',
        'https://s3.amazonaws.com/tmm.net/img/polygon.jpg', 'Mainnet', NULL, 'https://api.matic.network/ext/bc/C/rpc',
        2402, NULL);

INSERT INTO CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
VALUES (CHAIN_SEQ.NEXTVAL, 'avalanche', 'avax', 'Avalanche C-Chain', 'NFT - 0x1',
        'https://s3.amazonaws.com/tmm.net/img/avax.png', 'Mainnet', NULL, 'https://api.avax.network/ext/bc/C/rpc', 3,
        NULL);

INSERT INTO CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,
                   ID, BLOCK_EXPLORER_URL)
VALUES (CHAIN_SEQ.NEXTVAL, 'pulsechain', 'pls', 'Pulsechain Mainnet', 'NFT   0x1',
        'https://s3.amazonaws.com/tmm.net/img/pulsechain.png', 'Mainnet',
        'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',
        'https://rpc.pulsechain.io', 4, NULL);

-- INSERT CHAIN_USERS
INSERT INTO CHAIN_USERS (USERID, CHAIN_ID)
VALUES (1, 101);
INSERT INTO CHAIN_USERS (USERID, CHAIN_ID)
VALUES (51, 151);
INSERT INTO CHAIN_USERS (USERID, CHAIN_ID)
VALUES (101, 201);
INSERT INTO CHAIN_USERS (USERID, CHAIN_ID)
VALUES (151, 251);
INSERT INTO CHAIN_USERS (USERID, CHAIN_ID)
VALUES (201, 301);

-- INSERT ADDRESS
INSERT INTO ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, CHAIN_ID)
VALUES (ADDRESS_SEQ.NEXTVAL, NULL, 'thomasm1.maestas@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',
        'ropstein', NULL, NULL, 101);

-- other INSERT ADDRESS statements ...

-- INSERT COINTABLE
INSERT INTO COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)
VALUES (COINTABLE_SEQ.NEXTVAL, 'Ethereum', 'ETH', 12000.22, 0);
