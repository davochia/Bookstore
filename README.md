# Use documentation

## Book Store Application

This is a simple full stack application for a bookstore. It includes the basic CRUD verbs, containerization and performance monitoring.

## Tools and Technology

1. Java 17 (Spring boot)
2. Swagger
3. Postgres DB
4. Angular 14.2.3 (Bootstrap and Angular Material)
5. Typescript 4.7.4
6. Docker and Docker CLI
7. Prometheus
8. Grafana

### Run application with a single command

Clone the application from GitHub and cd into the application. Run **_docker-compose up_**. Visit links below;

- Book Store Application UI: http://localhost:4200/
- Prometheus UI: http://localhost:9090/
- Grafana: http://localhost:3000/login
- Swagger UI: http://localhost:9000/swagger-ui/index.html#/
- Scraped data: http://localhost:9000/actuator/prometheus

**Note**: The imputed data are validated for correctness so make sure the data inserted are correct to enable the buttons. See the prometheus and grafana setup below.

## Create image

You can use my repo name already configured in the docker-compose file or you can build the application to your own repository at will. Cd into the book client or server to build, tag and push to the repository of your choice with the commands below.

1. Build image: **_docker build --tag=<app-name>:tag ._**
2. Tag for repository: **_docker tag <app-name>:tag <my-repository>/<app-name>:tag_**
3. Push to repository: **_docker push <my-repository>/<app-name>:tag_**

When complete, change the image repository to your own repository on docker-compose file e.g., **_<my-repository>/<app-name>:tag_**.

## Running single application with docker

### Book client

After you have the book client in your favorite repository, you can run the application with **_docker run -d -it -p 4200:80/tcp --name <app-name> <my-repository>/<app-name>:tag_**. Make sure you tag appropriately or change the port to your choosing and use your repository provider accurately. The example above is assumed to run with Docker CLI. Now when I visit localhost, the application will be displayed.

### Book server

After you have the book server in your favorite repository, you can run the application with **_docker run -name bookstore-server -p 9000:9000 bookstore-server:0.1 _** .
Alternatively, you can just run _docker-compose up_ to start the application including Postgres, prometheus and Grafana. Then visit the port on your browser to view the application i.e., http://localhost:9090

**Note**: If you are not running the application with docker-compose, make sure postgres database is running on your local machine before starting the application. You can run postgres Docker image with the command **_docker run --name myPostgresDb -p 5432:5432 -e POSTGRES_USER=book-postgres -e POSTGRES_PASSWORD=book-postgres -e POSTGRES_DB=book-postgres-db -d postgres_**

#### Some usefull links

- Swagger UI: http://host-system-ip:port/swagger-ui/index.html
- Prometheus: http://host-system-ip:9090
- Grafana: http://host -system-ip:3000

**Note**: This is assumed that you are using the docker CLI. If you are using other providers make sure you check their documentation for building, tagging and pushing images to their repository.

## Prometheus

To view scraped data by prometheus, visit the prometheus port 9090 on the host system ip e.g, http://localhost:9090. When open, you can use the execute to view search queries such as **_http_server_requests_seconds_max, process_cpu_usage, logback_events_total_** and so on. Also prometheus has a graph and other functionality that are useful.

## Grafana

To visualize the scraped data from prometheus on grafana, visit the grafana port (3000) of the host system IP e.g., http://localhost:3000. On the first visit you will be requested to login (username:admin, password: admin) then you will get an optional request to change the password or skip and go to the grafana dashboard.

First we need to set up the datasource at the point to grafana, to do this just click configuration from the setting, add datasource and choose **prometheus**. Set the URL to the host system IP and grafana port in my local system. I have used **http://host.docker.internal:9090**, leave everything default and click save. Create a custom dashboard or choose to import a dashboard created by another developer e.gFor Micrometer use the **JVM (Micrometer) 4701** as the ID and click load. Select prometheus datasource and click import. You can monitor the health of the application with the dashboard.
