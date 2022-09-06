use db_arcos_teste;

insert into tb_estoques(tb_produtos_pcodigo, pquantidade )
values
('1', '50');

SELECT T1.pcodigo,
T1.pdescricao,
T2.pquantidade
FROM tb_produtos AS T1
INNER JOIN tb_estoques AS T2
ON(T1.pcodigo=t2.tb_produtos_pcodigo); 

SELECT T1.pcodigo,
T1.pdescricao,
T2.qtde_vendas
FROM tb_produtos AS T1 
INNER JOIN tb_vendas AS T2 
ON(T1.pcodigo=t2.tb_produtos_pcodigo) Where T2.pdata Between '04/09/2021' and '05/09/2021';


insert into tb_vendas(tb_produtos_pcodigo, pdata, pcpf, preco_unitario, qtde_vendas )
values
('1', '04/09/2021', '2658672781', '22.50', '15');

SELECT T1.pcodigo,
T1.pdescricao,
sum(T2.qtde_vendas) as qtd_vendida
FROM tb_produtos AS T1 
INNER JOIN tb_vendas AS T2 
ON(T1.pcodigo=t2.tb_produtos_pcodigo) Where T2.pdata Between '04/09/2021' and '05/09/2021'
group by
T1.pcodigo,
T1.pdescricao;

insert into tb_produtos(pdescricao, ppreco)
values
('Máscara covid', '22.00');


select pcodigo, pdescricao, ppreco
from tb_produtos;



insert into tb_vendas(tb_produtos_pcodigo, pdata, pcpf, preco_unitario, qtde_vendas )
values
('1', '05/09/2021', '2308672781', '15.00', '4');

insert into tb_vendas(tb_produtos_pcodigo, pdata, pcpf, preco_unitario, qtde_vendas )
values
('1', '04/09/2021', '2658672781', '22.50', '15');