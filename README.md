# Springboot Microservices
This sample application demonstrates starting steps of building Springboot microservices Level1  - Communication and discovery.
Introduced few microservices and had them communicate with each other, it is attempted to understand how inter-service communciation work. 

## Tech Stack 

Springboot  
Spring Cloud Bootstrap  
Spring Cloud Discovery (Eureka Discovery Client, Eureka Server)  
Spring REST   

## Microservice

1. MOVIE-INFO-SERVICE, API accesses movie information from 'The Movie DB'. TMDB has a free API to programmatically access information about movies.
2. RATINGS-DATA-SERVICE, API provides user ratings for a list of movies
3. MOVIE-CATALOG-SERVICE, API consolidates information from MOVIE-INFO-SERVICE and RATINGS-DATA-SERVICE

## Generate API-KEY

In order for MOVIE-INFO-SERVICE to work, we will need to request an API key from The Movie DB (TMDB). 
In order to request an API key from TMDB:
- Create a free account, at [themoviedb](https://www.themoviedb.org).
- Visit the API Settings page in your Account Settings and request an API key.
- Update application.properties file with the value for property 'api-key'.

## Launch

As the first step clone the repository.

1. Start Application [EurekaServer](/discovery-server) 
```
java -Dserver.port=8761 -jar discovery-server-local-SNAPSHOT.jar 
```
2. Start Application [MOVIE-CATALOG-SERVICE](/movie-catalog-service) 
```
java -Dserver.port=8081 -jar movie-catalog-service-local-SNAPSHOT.jar 
```
3. Start Application [MOVIE-INFO-SERVICE](/movie-info-microservice)
```
java -Dserver.port=8082 -jar movie-info-microservice-local-SNAPSHOT.jar 
```
4. Start Application [RATINGS-DATA-SERVICE](/ratings-data-microservice)
```
java -Dserver.port=8083 -jar ratings-data-microservice-local-SNAPSHOT.jar 
```

## Verify registered client instances

Eureka server runs on the default port 8761.   
Launch discovery server at http://localhost:8761/  

You will find the following :   
![Registered instances](/images/EurekaServer_registeredInstances.png)

## Test application

http://localhost:8081/catalog/<userId>

```
[
    {
        "name": "Lock, Stock and Two Smoking Barrels",
        "desc": "A card shark and his unwillingly-enlisted friends need to make a lot of cash quick after losing a sketchy poker match. To do this they decide to pull a heist on a small-time gang who happen to be operating out of the flat next door.",
        "rating": 3,
        "tagline": "A Disgrace to Criminals Everywhere."
    },
    {
        "name": "Star Trek: Insurrection",
        "desc": "When an alien race and factions within Starfleet attempt to take over a planet that has \"regenerative\" properties, it falls upon Captain Picard and the crew of the Enterprise to defend the planet's people as well as the very ideals upon which the Federation itself was founded.",
        "rating": 4,
        "tagline": "The battle for paradise has begun."
    },
    {
        "name": "Reservoir Dogs",
        "desc": "A botched robbery indicates a police informant, and the pressure mounts in the aftermath at a warehouse. Crime begets violence as the survivors -- veteran Mr. White, newcomer Mr. Orange, psychopathic parolee Mr. Blonde, bickering weasel Mr. Pink and Nice Guy Eddie -- unravel.",
        "rating": 4,
        "tagline": "Every dog has his day."
    }
]
```

[References](https://www.youtube.com/watch?v=y8IQb4ofjDo&list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas&ab_channel=JavaBrains)

