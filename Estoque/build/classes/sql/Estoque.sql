CREATE TABLE produto(
    id int IDENTITY(1, 1) PRIMARY KEY,
    nome varchar(100) NOT NULL,
    descricao varchar(255) NOT NULL,
    preco decimal(7, 2) NOT NULL
);

CREATE TABLE cliente(
    id int IDENTITY(1, 1) PRIMARY KEY,
    nome varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    telefone decimal(25) NOT NULL
);
    
CREATE TABLE pedido(
    id_produto int NOT NULL FOREIGN KEY REFERENCES produto(id),
    id_cliente int NOT NULL FOREIGN KEY REFERENCES cliente(id),
    CONSTRAINT produto_cliente UNIQUE (id_produto, id_cliente)
);
    