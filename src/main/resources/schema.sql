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
