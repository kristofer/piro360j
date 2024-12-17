# piro360j
a java spring clean start

bare minimum REST api server.


a test url target:
`curl -X GET http://localhost:8080/api/piros`

for creation
```
curl -X POST http://localhost:8080/api/piros -H "Content-Type: application/json" -d '{
  "title": "Sample Title",
  "description": "Sample Description",
  "s3urltovideo": "http://example.com/video",
  "imagename": "sample.jpg",
  "location": "Sample Location",
  "created": "2024-12-17T21:01:37.685"
}'
```

and to delete one by Id: `curl -X DELETE http://localhost:8080/api/piros/1`

piro360 data model...


a copy of the Piro360 simple data model. Last 2024.

```
entity Piro {
  title String required
  description String
  s3urltovideo String
  imagename String
  location String
  created String
}

entity Tag {
  title String
  description String
}

entity User {
  email String
  firstname String
	lastname String
}

relationship ManyToOne {
  Tags{owner} to User with builtInEntity
  Piros{owner} to User with builtInEntity
}

relationship ManyToMany {
  Tag{Piros} to Piro{Tags}
}
```


This is the Spring initializr URL I used to make the Spring Boot Start commit.

https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.4.0&packaging=jar&jvmVersion=17&groupId=rocks.zipcode&artifactId=piro360j&name=piro360j&description=Piro360j%20project%20for%20Spring%20Boot&packageName=rocks.zipcode.piro360j&dependencies=web,devtools,docker-compose,session,data-jpa,h2