create table carrinho(
  id    			bigint auto_increment not null,
  cupom_id 			bigint null,
  total_bruto 		decimal(12,2) not null,
  total_desconto 	decimal(12,2) not null,
  total_liquido 	decimal(12,2) not null,    
  primary key (id),
  CONSTRAINT FK_Cupom FOREIGN KEY (cupom_id) REFERENCES cupom (id)   
) engine=InnoDB charset=utf8;

create table item_carrinho(
  id    			bigint not null auto_increment,   
  quantidade 		decimal(12,2) not null,
  valor_unitario 	decimal(10,2) not null,
  valor_total 		decimal(10,2) not null,  
  produto_id 		bigint not null,  
  carrinho_id 		bigint not null,
  primary key(id),  
  foreign key fk_item_carrinho_produto (produto_id) references produto(id),
  foreign key fk_item_carrinho_carrinho (carrinho_id) references carrinho(id)

) engine=InnoDB charset=utf8;