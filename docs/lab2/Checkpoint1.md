# E-commerce

## The features I want to implement for lab2:

### 1. Long-running saga transactions
On payment request, I will:
1. Get current user from User Service
2. Get shopping cart list from Shopping Cart Service -> Change shopping cart to empty, global status- inProgress
3. Check in Products Service the availability of each product & get product payment information (price) -> Change products availability to UNAVAILABLE, global status- inProgress
4. Go to Payment Service implement payment -> if successful - then return 200, go back to all services and mark as finished,  if fail, go back to all previous services and change everything back in data base, status failed. 


### 2. Database redundancy/replication + failover.
For the Products Service for example, I will implement single leader replication using Redis.
At the base of Redis replication there is a very simple to use and configure leader follower (master-slave) replication: it allows replica Redis instances to be exact copies of master instances.

![Alt Text](https://miro.medium.com/max/664/1*LkgG8SiU3pbeslElStmY9w.png)

### 3. ELK stack or (Prometheus + Grafana for logging).

## The used programming languages:
Java (Spring Boot)
NodeJS

# A diagram reflecting the architecture of your system.
![Alt Text](https://github.com/MargaretaGalaju/E-Commerce-Service/blob/main/docs/images/architectureDiagramLab2.png)
