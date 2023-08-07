alter table USERS
    add column date_created timestamp default CURDATE();
alter table USERS
    add column created_date timestamp default CURDATE();
alter table USERS
    add column updated_date timestamp default  CURDATE();
alter table USERS
    add column updated_at timestamp default current_timestamp;
