# 

## Model
www.msaez.io/#/123912988/storming/schoolrental

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- space
- reserve
- center
- analysis


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- space
```
 http :8088/spaces schoolName="A대" placeName="체육관" headcount="50" price="100000" address="서울특별시 서대문구"
 http :8088/spaces schoolName="B대" placeName="대강의장" headcount="70" price="100000" address="서울특별시 서대문구"
 http :8088/spaces schoolName="C대" placeName="강의실" headcount="70" price="100000" address="서울특별시 서대문구"
```
- reserve
```
 http :8088/facilities id="id" spaceId="spaceId" schoolName="schoolName" placeName="placeName" headCount="headCount" price="price" userId="userId" address="address" reserveDate="reserveDate" isReserve="isReserve" 
```
- center
```
```
- analysis
```
 http :8088/analyses placeName="placeName" useCount="useCount" 
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

