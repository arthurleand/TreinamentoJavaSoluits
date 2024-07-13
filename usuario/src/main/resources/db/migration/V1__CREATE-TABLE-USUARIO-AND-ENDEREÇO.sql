create table usuario(

    id bigint not null auto_increment,
    login varchar(100) not null,
    senha varchar(10) not null,
    cpf varchar(14) not null,

    primary key (id)
);

create table endereco_usuario(

    id bigint not null,
    rua varchar(100) not null,
    bairro varchar(50) not null,
    numero varchar(10),
    cidade varchar(50) not null,
    uf varchar(2) not null,
    cep varchar(9) not null,

    primary key (id),
    FOREIGN KEY (id) REFERENCES usuario(id)
);