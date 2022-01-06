# E-commerce

# A diagram reflecting the architecture of your system.
![Alt Text](https://github.com/MargaretaGalaju/E-Commerce-Service/blob/main/docs/images/architectureDiagramLab2.png)

# A description of the API endpoints;
	
### User

#### Outbound:
Get - User info (userId)
Post - create new user 

#### Inbound:
Get - favorite products list from Catalog by given productIds
Post/Delete - favorite product
Get - payment info from PAYMENT service by userId
Get - personal published product list

### Catalog

#### Outbound:
Get - all categories
Get - all products (filtering included by category/user/review etc)
Get - product by productId
Post - add new product / edit existing product by productId

#### Inbound:
Get - reviews from Review service by productId

### Reviews 

#### Outbound:
POST - new review
DELETE - review 
 
#### Inbound:
GET - all reviews by productId

### Shopping Cart

#### Outbound:
POST/DELETE - productId
GET - All products from shopping cart by userId

#### Inbound:
Get PRODUCTS INFO by productIds from Catalog service (name, price, photo)

### Payment

Charges the given credit card info (mock) with the given amount and returns a transaction ID.

#### Outbound:
POST - charge the money from card
GET/POST - wallet status

#### Inbound:
GET - wallet info by userId

# A list of technologies to be used;
Java 8
Spring Boot 
Maven
Netflix Eureka Client/Server
SQL Database engine : Microsoft SQL 2016
NOSQL Database engine : Redis 3.2.100
