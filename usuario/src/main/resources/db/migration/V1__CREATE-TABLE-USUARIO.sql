create table usuario(

    id bigint not null auto_increment,
    login varchar(100) not null,
    senha varchar(10) not null,
    cpf varchar(14) not null,

    primary key (id)

);