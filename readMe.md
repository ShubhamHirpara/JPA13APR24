Database connectivity: 
Database
Driver
JDBC / Hibernate - ORM(tool) (Object-relational mapping) / MyBatis 
-> beanpropertyrowmapper

SPring Data JPA -> Jakarta persistance API
-> Interfaces

H2: Database -> In memory database

DDL part of hibernate:

User table:
userId: Integer
firstName: Varchar(25)
lastName: Varchar(25)
email: varchar(255)

userId | firstName | lastName | email
  1        "John"       "Smith"  "djsad@cjsc.com"
  2         "Sam"       "Scott"  "cnsdc@dsc.com"   

Hibernate: create table user (user_id integer not null, email varchar(255), first_name varchar(255),
last_name varchar(255), primary key (user_id))

Repository / DAO
