/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/7/25 16:44:05                           */
/*==============================================================*/

create database signinwithtwitter character set 'utf8' collate 'utf8_general_ci';

drop table if exists oauth;

drop table if exists users;

/*==============================================================*/
/* Table: oauth                                                 */
/*==============================================================*/
create table oauth
(
   id                   varchar(32) not null,
   oauth_provider       varchar(32),
   oauth_uid            varchar(128),
   oauth_token          varchar(128),
   oauth_secret         varchar(128),
   username             varchar(32),
   primary key (id)
) DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: users                                                 */
/*==============================================================*/
create table users
(
   id                   varchar(32) not null,
   userName             varchar(64),
   email                varchar(64),
   password             varchar(32),
   timeRegister         datetime,
   timeLastlogin        datetime,
   primary key (id)
);

