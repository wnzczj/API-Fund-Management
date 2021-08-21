# API-Fund-Management

Source code for Group 3's API Hackathon

## Containerization 

1. Use `mvn package` to generate a Jar file in the root directory.

2. Build sql image. Then run the image and map to port 3306.  

> `docker build -f Dockerfile-mysql -t fund/mysql .`  

> `docker run -dp 3306:3306 --name mysql fund/mysql`

3. Get into mysql container and create a new database named fundmgt.  

> `docker exec -it mysql bash`  

> `mysql -u root -p`

> `CREATE DATABASE fundmgt;`

4. Build springboot app image

> `docker build -f Dockerfile-app -t fund/app .`  

5. Run the app image and start link communication 

> `docker run --name app --link mysql:mysql fund/app`
