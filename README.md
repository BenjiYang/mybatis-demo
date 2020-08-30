# Create mysql in docker

> docker-compose src/main/java/com/atcn/mybatis/demo/dao/docker4mysql/mysql-docker-compose.yml

# Connects to mysql

``` proper
jdbc:mysql://localhost:3306/mysqlapp
root/123456
```

## create table

``` sql
create table T_USER(id int not null, name text, age int, hobby varchar(100), primary key(id));
insert into T_USER(id, name, age, hobby) values (1, "Allen", "21", "basketball;football");
insert into T_USER(id, name, age, hobby) values (2, "Ben", "22", "badminton;golf");
insert into T_USER(id, name, age, hobby) values (3, "Cathy", "23", "swimming; bowling");                       
```

