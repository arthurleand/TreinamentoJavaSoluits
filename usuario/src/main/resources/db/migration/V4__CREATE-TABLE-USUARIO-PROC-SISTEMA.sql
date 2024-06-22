create table usuario_processo_sistema(

    id_usuario bigint not null,
    id_sistema bigint not null,
    numeroProcesso varchar(25) not null,

    primary key (id_usuario)
);