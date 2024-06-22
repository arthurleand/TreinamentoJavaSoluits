create table endereco_usuario(

    id bigint not null auto_increment,
    rua varchar(100) not null,
    bairro varchar(50) not null,
    numero varchar(10),
    cidade varchar(50) not null,
    uf varchar(2) not null,
    cep varchar(9) not null,

    primary key (id)
);