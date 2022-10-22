FROM maven:latest
RUN mkdir /test
WORKDIR /test
COPY . .
EXPOSE 8080
CMD ["mvn", "spring-boot:run"]