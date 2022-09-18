create table assistances
(
    id bigint auto_increment primary key,
    description varchar(300) not null,
    name varchar(100) not null
);

INSERT INTO assistances (name,description) VALUES ('Troca peca interna', 'troca aparelho xpto');
INSERT INTO assistances (name,description) VALUES ('Troca de bateria', 'troca do componente de energia');
INSERT INTO assistances (name,description) VALUES ('Troca de tela', 'display esmirilhado');
INSERT INTO assistances (name,description) VALUES ('Limpeza', 'limpeza carcaca');
INSERT INTO assistances (name,description) VALUES ('Secagem', 'derramamento de liquido');