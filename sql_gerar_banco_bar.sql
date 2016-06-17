-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Produto (
id_produto serial PRIMARY KEY,
quantidade integer,
nome varchar(100),
categoria varchar(10),
preco_venda real,
status varchar(10)
);

--status: ativo/inativo

CREATE TABLE Mesa (
id_mesa integer PRIMARY KEY
);

CREATE TABLE Consumo (
id_mesa integer,
id_produto serial,
quantidade integer,
PRIMARY KEY(id_mesa,id_produto),
FOREIGN KEY(id_mesa) REFERENCES Mesa (id_mesa),
FOREIGN KEY(id_produto) REFERENCES Produto (id_produto)
);

