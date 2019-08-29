CREATE TABLE company (
  id INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL
);

CREATE TABLE employee (
  employee_id INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL,
  company_id INTEGER NOT NULL,
  CONSTRAINT fk_company
    FOREIGN KEY (company_id)
    REFERENCES company(id)
);

insert into company values (1, 'c1');
insert into company values (2, 'c2');

insert into employee values (1, 'e1', 18, 2);
