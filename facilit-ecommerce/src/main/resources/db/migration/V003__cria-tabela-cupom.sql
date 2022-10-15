create table cupom(
  id    integer auto_increment,
  nome  varchar(10),
  valor decimal(12,2),
  primary key (id),
  CONSTRAINT UC_nome UNIQUE (nome)
);