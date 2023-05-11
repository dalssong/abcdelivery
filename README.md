
# 1.Event Storming Model
![image](https://github.com/dalssong/abcdelivery/assets/126850101/cc065302-d4d6-431b-8825-62d72f4909cc)

# 2.Saga (Pub/Sub)
![image](https://github.com/dalssong/abcdelivery/assets/126850101/76c7328c-deb3-4d1b-87bd-c8355d7e648e)

# 3.CQRS

# 4.Compensation/Correlation

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

