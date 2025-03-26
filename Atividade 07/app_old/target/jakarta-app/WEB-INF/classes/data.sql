
-- Inserção de dados na tabela Vendedor
INSERT INTO Vendedor (id, nome, idade, salario) VALUES (1, 'Abe', 61, 140000);
INSERT INTO Vendedor (id, nome, idade, salario) VALUES (2, 'Bob', 34, 44000);
INSERT INTO Vendedor (id, nome, idade, salario) VALUES (5, 'Chris', 34, 40000);
INSERT INTO Vendedor (id, nome, idade, salario) VALUES (7, 'Dan', 41, 52000);
INSERT INTO Vendedor (id, nome, idade, salario) VALUES (8, 'Ken', 57, 115000);
INSERT INTO Vendedor (id, nome, idade, salario) VALUES (11, 'Joe', 38, 38000);

-- Inserção de dados na tabela Cliente
INSERT INTO Cliente (id, nome, cidade, tipo_industria) VALUES (4, 'Samsonic', 'Pleasant', 'J');
INSERT INTO Cliente (id, nome, cidade, tipo_industria) VALUES (6, 'Panasung', 'Oaktown', 'J');
INSERT INTO Cliente (id, nome, cidade, tipo_industria) VALUES (7, 'Samony', 'Jackson', 'B');
INSERT INTO Cliente (id, nome, cidade, tipo_industria) VALUES (9, 'Orange', 'Jackson', 'B');

-- Inserção de dados na tabela Pedido
INSERT INTO Pedido (id, data_pedido, cliente_id, vendedor_id, valor) VALUES (10, '1996-02-08', 4, 2, 540);
INSERT INTO Pedido (id, data_pedido, cliente_id, vendedor_id, valor) VALUES (20, '1999-01-30', 4, 8, 1800);
INSERT INTO Pedido (id, data_pedido, cliente_id, vendedor_id, valor) VALUES (30, '1995-07-14', 9, 1, 460);
INSERT INTO Pedido (id, data_pedido, cliente_id, vendedor_id, valor) VALUES (40, '1998-01-29', 7, 2, 2400);
INSERT INTO Pedido (id, data_pedido, cliente_id, vendedor_id, valor) VALUES (50, '1998-02-03', 6, 7, 600);
INSERT INTO Pedido (id, data_pedido, cliente_id, vendedor_id, valor) VALUES (60, '1998-03-02', 6, 7, 720);
INSERT INTO Pedido (id, data_pedido, cliente_id, vendedor_id, valor) VALUES (70, '1998-05-06', 9, 7, 150);
