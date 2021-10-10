# E-Commerce-Service

## A list of services;

### User

Stores the information about the user, favorite products (related to product by productId), payment info, shopping history.
User can add comments in review.

### Catalog

The Catalog consists of categorized products. Products can be in one ore more categories, and category can contain one ore more products.

### Reviews 

Review is entity(document) related to product by productId and to customer(user) by userName. 

### Shopping Cart

Stores the items in the user's shopping cart and retrieves it.

### Payment

Charges the given credit card info (mock) with the given amount and returns a transaction ID.

### API Gateway

Implementation of an API gateway that is the single entry point for all clients. The API gateway handles requests in one of two ways. Some requests are simply proxied/routed to the appropriate service. It handles other requests by fanning out to multiple services.

### Eureka 
Netflix Eureka is a service registry. It provides a REST API for service instance registration management and for querying available instances. Netflix Ribbon is an IPC client that works with Eureka to load balance requests across the available service instances.

When using client-side discovery, the client is responsible for determining the network locations of available service instances and load balancing requests across them. The client queries a service registry, which is a database of available service instances. The client then uses a load balancing algorithm to select one of the available service instances and makes a request.

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

# A diagram reflecting the architecture of your system.

![Alt Text](https://github.com/MargaretaGalaju/E-Commerce-Service/blob/main/docs/images/architectureDiagram.png)