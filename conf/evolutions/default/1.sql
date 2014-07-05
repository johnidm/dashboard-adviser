# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table orientacoes (
  id                        bigint auto_increment not null,
  descricao                 varchar(80),
  observacao                varchar(1000),
  constraint pk_orientacoes primary key (id))
;

create table orientandos (
  id                        bigint auto_increment not null,
  nome                      varchar(60),
  email                     varchar(100),
  constraint pk_orientandos primary key (id))
;

create table usuario (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  email                     varchar(255),
  senha                     varchar(255),
  constraint pk_usuario primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table orientacoes;

drop table orientandos;

drop table usuario;

SET FOREIGN_KEY_CHECKS=1;

