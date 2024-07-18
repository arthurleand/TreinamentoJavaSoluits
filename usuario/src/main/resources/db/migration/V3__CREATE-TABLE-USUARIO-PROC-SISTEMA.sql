create table usuario_processo_sistema(

    id_usuario bigint not null,
    id_sistema bigint not null,
    numero_processo varchar(25) not null,

    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_sistema) REFERENCES sistema(id)
);