# piro360j
a java spring clean start

bare minimun REST api server.

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
