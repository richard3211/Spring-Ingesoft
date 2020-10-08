## Aplication properties

Las siguientes propiedades son necesarias para correr. Pegar en src\main\resources\aplication.properties

```
server.port=8000

##Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)

spring.datasource.url = jdbc:mysql://database-1.cdocxzcech53.us-east-1.rds.amazonaws.com/loginapp?serverTimezone=UTC

spring.datasource.username = admin

spring.datasource.password = xxxxx

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
```
