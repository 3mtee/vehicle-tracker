# vehicle-tracker

## Task
There is a large amount of vehicles (millions). Each vehicle is equipped with a GPS tracker. The tracker periodically
sends vehicle geolocation to server (about every ten seconds).

The task is to create a RESTful web service that will:

- Receive current coordinates from vehicle GPS trackers
- On request return the list of vehicles that are located within a given rectangle on the map. The rectangle coordinates
  are provided as the request params
  
## Running the app
1. Start a pg in docker `docker compose -f docker/docker-compose.yml up`
1. Run VehicleTrackerApplication in your IDE or `./gradlew bootRun` in the terminal

## Swagger UI
Available at http://localhost:8080/swagger-ui/
  
## Things to consider:
1. Set your servers to use the UTC timezone

## TODO
1. address n+1
1. add integration tests
1. Introduce `liquibase`
1. Make possible changing spring profiles using JVM args
