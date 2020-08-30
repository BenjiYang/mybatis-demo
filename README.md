# Create mysql in docker
> docker-compose src/main/java/com/atcn/mybatis/demo/dao/docker4mysql/mysql-docker-compose.yml

# Connects to mysql
> jdbc:mysql://localhost:3306/mysqlapp
> root/123456

## create table
> create table T_USERS(id int not null, name text, age int, primary key(id));
 
## insert record
> insert into T_USERS values (1, “Allen", “21");
> insert into T_USERS values (2, “Ben", "22");
> insert into T_USERS values (3, “Cathy", “23");
