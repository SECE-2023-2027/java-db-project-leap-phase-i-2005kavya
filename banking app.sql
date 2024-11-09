create database bank_app;
use bank_app;
create table Account(
account_id int auto_increment primary key,
account_holder varchar(50) not null,
account_type varchar(50) not null,
balance decimal(15,2) not null,
address varchar(255),
contact_number varchar(15),
created_At timestamp default current_timestamp);
create table SavingsAccount(
account_id int primary key,
interest_rate decimal(5,2) not  null,foreign key(account_id) references Account(account_id));
create table CurrentAccount(
account_id int primary key,
overdraft_limit decimal(15,2) not null,
foreign key(account_id) references Account(account_id));
select * from Account;
select * from SavingsAccount;
select * from CurrentAccount;
create table Transaction(
transaction_id int auto_increment primary key,
account_id int not null,
transaction_type varchar(50) not null,
amount decimal(15,2) not null,
transaction_date timestamp default current_timestamp,
foreign key(account_id) references Account(account_id));
