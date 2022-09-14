create table t_emp(
eid int not null AUTO_INCREMENT,
emp_name varchar(200),
age int,
sex char,
email varchar(200),
did int,
PRIMARY KEY (eid)
)ENGINE=InnoDB;

create table t_dept(
did int not null AUTO_INCREMENT,
dept_name varchar(200),
PRIMARY KEY (did)
)ENGINE=InnoDB;

insert into t_emp values
(null,'张三',23,'男','123@qq.com',1),
(null,'李四',32,'女','123@qq.com',2),
(null,'王五',12,'男','123@qq.com',3),
(null,'赵六',34,'女','123@qq.com',1),
(null,'田七',28,'男','123@qq.com',2);

insert into t_dept values
(null,'A'),
(null,'B'),
(null,'C');