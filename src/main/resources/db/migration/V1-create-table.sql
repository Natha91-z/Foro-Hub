create table(
id bigint not null auto_increment,
autor varchar() not null,
mensaje varchar() not null unique,
curso varchar() not null,
titulo varchar() not null unique,
status varchar() not null,
fecha_creacion datelime not null,

primary key(id)
);