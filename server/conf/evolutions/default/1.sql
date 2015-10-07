# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table favourites_list (
  id                        bigint not null,
  name                      varchar(255),
  user_id                   bigint,
  default                   boolean,
  constraint pk_favourites_list primary key (id))
;

create table movie (
  id                        bigint not null,
  name                      varchar(255) not null,
  thumbnail                 varchar(255),
  overview                  varchar(65535),
  constraint uq_movie_name unique (name),
  constraint pk_movie primary key (id))
;

create table user (
  id                        bigint not null,
  email                     varchar(255) not null,
  sha_password              varbinary(64) not null,
  constraint uq_user_email unique (email),
  constraint pk_user primary key (id))
;


create table favourites_list_movie (
  favourites_list_id             bigint not null,
  movie_id                       bigint not null,
  constraint pk_favourites_list_movie primary key (favourites_list_id, movie_id))
;

create table movie_favourites_list (
  movie_id                       bigint not null,
  favourites_list_id             bigint not null,
  constraint pk_movie_favourites_list primary key (movie_id, favourites_list_id))
;
create sequence favourites_list_seq;

create sequence movie_seq;

create sequence user_seq;

alter table favourites_list add constraint fk_favourites_list_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_favourites_list_user_1 on favourites_list (user_id);



alter table favourites_list_movie add constraint fk_favourites_list_movie_favo_01 foreign key (favourites_list_id) references favourites_list (id) on delete restrict on update restrict;

alter table favourites_list_movie add constraint fk_favourites_list_movie_movi_02 foreign key (movie_id) references movie (id) on delete restrict on update restrict;

alter table movie_favourites_list add constraint fk_movie_favourites_list_movi_01 foreign key (movie_id) references movie (id) on delete restrict on update restrict;

alter table movie_favourites_list add constraint fk_movie_favourites_list_favo_02 foreign key (favourites_list_id) references favourites_list (id) on delete restrict on update restrict;

# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists favourites_list;

drop table if exists favourites_list_movie;

drop table if exists movie;

drop table if exists movie_favourites_list;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists favourites_list_seq;

drop sequence if exists movie_seq;

drop sequence if exists user_seq;

