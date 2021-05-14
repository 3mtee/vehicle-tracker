# vehicle-tracker

There is a large amount of vehicles (millions). Each vehicle is equipped with a GPS tracker. The tracker periodically
sends vehicle geolocation to server (about every ten seconds).

The task is to create a RESTful web service that will:

- Receive current coordinates from vehicle GPS trackers
- On request return the list of vehicles that are located within a given rectangle on the map. The rectangle coordinates
  are provided as the request params
