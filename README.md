![image](https://github.com/dalssong/abcdelivery/assets/126850101/2896f1b1-7ff8-4801-b14f-eff10c111838)

# 1.Event Storming Model
![image](https://github.com/dalssong/abcdelivery/assets/126850101/cc065302-d4d6-431b-8825-62d72f4909cc)

# 2.Saga (Pub/Sub)
![image](https://github.com/dalssong/abcdelivery/assets/126850101/31878bb6-adfe-4295-80d2-1ad06bcd8813)

# 3.CQRS
```
gitpod /workspace/abcdelivery (main) $ http GET :8084/myPageCustomers/1
```
```
2023-05-11 08:04:54.353  INFO [front-user,,,] 19139 --- [pool-5-thread-1] o.a.k.c.c.internals.ConsumerCoordinator  : [Consumer clientId=consumer-front-user-3, groupId=front-user] Found no committed offset for partition abcdelivery-0
Hibernate: 
    select
        mypagecust0_.id as id1_0_0_,
        mypagecust0_.menu_name as menu_nam2_0_0_,
        mypagecust0_.menu_price as menu_pri3_0_0_,
        mypagecust0_.order_status as order_st4_0_0_,
        mypagecust0_.store_name as store_na5_0_0_,
        mypagecust0_.user_id as user_id6_0_0_ 
    from
        my_page_customer_table mypagecust0_ 
    where
        mypagecust0_.id=?
2023-05-11 08:05:15.216 TRACE [front-user,a1550ae6d97112a5,a1550ae6d97112a5,true] 19139 --- [nio-8084-exec-3] o.h.type.descriptor.sql.BasicBinder      : binding parameter [1] as [BIGINT] - [1]
```

# 4.Compensation/Correlation
POST
```
gitpod /workspace/abcdelivery (main) $  http :8088/orders userId=1234 storeName="K-Foods" menuName="menu1" orderStatus="orderStatus:paid" menuPrice=10000
HTTP/1.1 201 Created
Content-Type: application/json
Date: Thu, 11 May 2023 07:39:16 GMT
Location: http://localhost:8082/orders/1
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
transfer-encoding: chunked

{
    "_links": {
        "order": {
            "href": "http://localhost:8082/orders/1"
        },
        "self": {
            "href": "http://localhost:8082/orders/1"
        }
    },
    "menuName": "menu1",
    "menuPrice": 10000,
    "orderStatus": "orderStatus:paid",
    "storeName": "K-Foods",
    "userId": 1234
}
```

GET
```
gitpod /workspace/abcdelivery (main) $ http :8088/orders/1
HTTP/1.1 200 OK
Content-Type: application/hal+json
Date: Thu, 11 May 2023 07:40:06 GMT
Vary: Origin
Vary: Access-Control-Request-Method
Vary: Access-Control-Request-Headers
transfer-encoding: chunked

{
    "_links": {
        "order": {
            "href": "http://localhost:8082/orders/1"
        },
        "self": {
            "href": "http://localhost:8082/orders/1"
        }
    },
    "menuName": "menu1",
    "menuPrice": 10000,
    "orderStatus": "orderStatus:paid",
    "storeName": "K-Foods",
    "userId": 1234
}


gitpod /workspace/abcdelivery (main) $ 
```
---------------------

## Model
www.msaez.io/#/storming/abcdelivery-jsyang

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- store
- order
- delivery
- front-user
- front-rider
- front-store


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- store
```
 http :8088/cookings id="id" storeName="storeName" menuId="menuId" menuName="menuName" qty="qty" menuPrice="menuPrice" deliveryStatus="deliveryStatus" 
```
- order
```
 http :8088/orders id="id" userId="userId" storeName="storeName" menuName="menuName" orderStatus="orderStatus" menuPrice="menuPrice" 
```
- delivery
```
 http :8088/deliveries id="id" riderId="riderId" riderName="riderName" storeId="storeId" storeName="storeName" menuId="menuId" qty="qty" customerId="customerId" deliveryStatus="deliveryStatus" 
```
- front-user
```
```
- front-rider
```
```
- front-store
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

