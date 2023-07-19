
# YEMEK SEPETI SIMULATION

A simple to use library to create YEMEK SEPETI APP in Java

# Contributions
This project has been prepared with the aim of using some technologies and methods to develop spring boot capabilities.
# Technology Stack

| Tech     | Url |
| -------- | ------- |
| Spring Boot Data Jpa  | implementation 'org.springframework.boot:spring-boot-starter-data-jpa'    |
| Spring Boot Web | implementation 'org.springframework.boot:spring-boot-starter-web'     |
| Lombok    |compileOnly 'org.projectlombok:lombok'-----annotationProcessor 'org.projectlombok:lombok'    |
| MySql  | implementation 'mysql:mysql-connector-java:8.0.33'    |
| Swagger Ui | implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0'     |
| Mapstruct    | implementation 'org.mapstruct:mapstruct:1.5.5.Final'   |
| Spring Boot Starter Mail  | implementation 'org.springframework.boot:spring-boot-starter-mail:3.1.1'   |
| Validator | 	implementation  'org.hibernate.validator:hibernate-validator:8.0.0.Final'    |


# How to Run ?
✔Clone Repository

✔Before using the application, you must configure the database and mail configuration in the application.yml file.

✔Run the SpringYemekSepetiUygulamasiExApplication.java

✔Run [Swagger UI](http://localhost:9090/swagger-ui/index.html#/)

✔You can send requests to endpoints




# Conditions in the project

→If the customer is not registered in the system, customer must first register

→After entering the activation code sent to the mail, the status will be active.

→Registered users can be listed.

→The customer can order. Orders can be listed.

→The restaurant can list all its own orders.

→all orders can be listed

→Email and password must be entered in accordance with the rules.

→Some information of the customer cannot be empty

→Product name and product price cannot be empty

→Mysql is used in the project
# EndPoints
### Customer
∙ [REGISTER CUSTOMER](http://localhost:9090/api/v1/customer/save)

∙ [AUTHENTICATION CUSTOMER](http://localhost:9090/api/v1/customer/authentication)

∙ [FIND ALL CUSTOMERS](http://localhost:9090/api/v1/customer/findall)

∙ [FIND ALl ORDERS](http://localhost:9090/api/v1/customer/findallorders)

∙ [ORDER](http://localhost:9090/api/v1/customer/api/v1/order)

∙ [DEPOSIT BALANCE](http://localhost:9090/api/v1/customer/addbalance)

∙ [ADD CARD DETAILS](http://localhost:9090/api/v1/customer/addcarddetails)

### Order
∙ [FIND ALL](http://localhost:9090/api/v1/order/findall)

### PRODUCT
∙ [SAVE](http://localhost:9090/api/v1/product/save)

### RESTAURANT
∙ [SAVE](http://localhost:9090/api/v1/restaurant/save)

∙ [FIND ALL ORDERS](http://localhost:9090/api/v1/restaurant/findallorders)

∙ [FIND ALL PRODUCT](http://localhost:9090/api/v1/restaurant/findallproduct)



## What Did I Try To Do
I tried to use Spring Boot build in a simple way. I created End Points using @RestController. I've done a lot of checking in dtos using @Valid. I used Http Request Methods such as @PostMapping, @GetMapping. I made the relationships between my entities via id. I made a class that generates auth code for registration and sent this code to the user by mail. (This was the first for me). I tried to use layered architecture. I presented my entities from database as dto and I converted the dtos to customer via mapper. I learned how to configure mysql. I created my own exception class to catch errors. I checked many conditions. I tried for clean code. I strived to fulfill the solid principles. If there is something missing or need improvement, please give feedback.

## Work Flow
![Spring Boot Flow](https://www.linkpicture.com/q/1_161.png)

![Spring Boot](https://www.linkpicture.com/q/2_1398.png)

![Spring Boot](https://www.linkpicture.com/q/3_224.png)
