# second-hand-market-platform
We found out that there are plenty of things that can’t move with us after leaving campus. In this case, we need a platform facing all BU students that could help students to sell their second hand books, furniture or other household items in a more convenient way. Our online second-hand market platform allows BU students to publish used things and also buy cheap things. This platform includes features that sellers could have their shops with shop information and products list and buyers could view the whole shop list and view the products in detail. 
## Website Location:
Market End: http://121.199.8.217/o2o_war_exploded/frontend/index

Seller Management End: http://121.199.8.217/o2o_war_exploded/local/login
- Account: 
Username: testusername Password: *****
 
## User Story:
- Seller:<br>
 As a seller, I can have multiple shops<br>
 As a seller, I can edit my shop information<br> 
 As a seller, I can add products of each shop<br>
 As a seller, I can view a product detail page<br>
 As a seller, I can update products information according to each shop<br>
 As a seller, I can choose products to be on shelf or off shelf<br>

- Buyer:<br>
As a buyer, I can view the product list according to shop list<br>
As a buyer, I can view the contact information of each shop<br>
As a buyer, I can product detail of each shop<br>
As a buyer, I can search shop by shop name<br>
As a buyer, I can search product in each shop by product name<br>


## Feature Module:
We have two parts: 
- Seller End
  1. Seller Management
  2. Shop Management
  3. Product Management
  4. Product List Management

- Buyer End (Market End)
  1. Shop List 
  2. Product List
  2. Product Detail 

  
## Tech Architect:

1. Front-end: jQuery
2. Back-end: SSM (Spring, Spring MVC, MyBatis), Tomcat
3. Database: MySQL
4. Cloud: Alibaba Cloud

## Software Architecture
![Image text](https://github.com/Bonniesty/second-hand-market-platform/raw/master//sw%20architecture.png)

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


Apr 17
- Add Shop/ Display Shop Module
  1. Junit Test on Dao, Service layer
  2. Implement frontend, controller
  
Apr 18  
- User Login Module
  1. MD5 Hash on password
  2. all page rediret to login page when first access using Session
 
  
Apr 19  
- Shop Management Backend Module
  1. Shop Mangement controller 
  2. add image Thumbnail framework to support image upload
 
Apr 20  
- Shop Management Frontend Module
  1. Shop Mangement Frontend （add shop, manage shop)
  2. test with Database
  
Apr 22  
- Product Management Frontend Module
  1. Product Mangement Frontend （add product, on/off shelf, edit)
    
Apr 23  
- Product Management Backend Module
  1. Product Mangement controller
  2. Product Mangement service layer
  
Apr 24  
- Market End Module
  1. Market End frontend(index main page, shop list, pruducte detail)
  2. Market End service and controller layer
  
Apr 25  
- Fix bug on Image on website not shown problem
  
Apr 26  
- Ali Cloud
  1. Migration database from local to Cloud.
  2. Configure Tomcate, MySql, JDK on Cloud.
 
  
