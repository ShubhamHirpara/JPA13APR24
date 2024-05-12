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


Exercise:
Need to write abstract method in Repo and use JPA to create sql from it: make atlist 2 arguments/ 2 where closes
use @query annotation and write the JPQL query to generate fetch some data: atlist 2-3 parameters
use @query annotation and write Native queries: to generate fetch some data: atlist 2-3 parameters

Exercise:
get the hands on for OneToOne mapping/ OneToMany mapping
use @query annotation to make more complex queries-> include multiple tables: use Joins 
same query write in JPQL and Native query
Take Home: @ManyToOne and @ManyToMany mapping

Exercise:
FetchType: LAZY
FetchType: EAGER
CASCADE: ALL,PERSIST,DETACH,REMOVE
ORPHAN REMOVAL: TRUE/FALSE

RestTemplate
WebClient
FeignClient
For all these three: > consume GIT Users

2) ApplicationB :-> B-> consume appA -> fetch ApplicationUser By Id

JUnit 4.0 / 5.0 
TestNG
Gradle tests
Maven tests
Mockito



Development strategy:
TDD - Test Driven Development (95) / 
BDD - Behaviour Driven Development (5) (Cucumber: )


Microservices:
API Gateway : Route request, Load Balancing
Discovery server, 

Response Entity: 
Exception Handling: Centrallized EH: 

Spring AOP: Aspect oriented programming : BeforeAdvice, AfterAdvice, Around Advice
to avoid cross cutting concerns // to avoind secondary logic
PJP: Proceeding Join Point / PC: Point Cut