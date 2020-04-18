# second-hand-market-platform
project doc: https://docs.google.com/document/d/1d19W_cKxg8ztTj249h2xGiS63v9msbhlOnLBqVDof2w/edit?usp=sharing

## Tech Architect:

1. Front-end: jQuery
2. Back-end: SSM (Spring, Spring MVC, MyBatis)
3. Database: MySQL, Redis
4. Cloud: Not defined
 
## Feature Module:
Seller Management
Shop Management
Pruduct Management
Pruduct List Management

## Current Work Update :

Before Apr 16:

- Database: 
  1. Has built MySql database
  3. Has designed database table

- Backend:
  MVC model
  1. Has configured MAVEN, Apache Tomcat
  2. Has configured JDBC
  3. Has configured DAO layer and test it with database
  4. Has configured Service layer and test it with Unit

- Features:
  Now we are working on Shop Management module, which allow user to upload their product. We think it is the key feature. So we start working on the most important one.


Apr 18
- Add Shop/ Display Shop Module
  1. Junit Test on Dao, Service layer
  2. Implement frontend, controller
- User Login Module
  1. MD5 Hash on password
  2. all page rediret to login page when first access
