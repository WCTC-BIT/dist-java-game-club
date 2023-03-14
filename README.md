# Game Club Calendar
Many local businesses want to host events and allow their customers to register to attend. However, most of these
businesses don't have the money or technical skill to maintain a complete event-registration application on their website.

A local tech company provides a service to those small businesses. The small business can upload a simple HTML/JavaScript
calendar page to their existing website. This calendar page will call the API hosted by the tech company to retrieve the
list of available events. It also displays a form that allows users to register to attend events of interest, also via
API call.

## Server module
This module contains a Spring Boot API that serves events being held at a local game store. It exposes endpoints to GET
all events and POST a new event registration for an existing game club member.

The format of the data served by the API is determined by special *data transfer objects*, or DTOs, that decouple the
API messages from the actual database structure (represented by the *entity* classes).

The module also serves a regular Spring MVC application using Thymeleaf templates. This part of the application could
be expanded into a full-featured event management dashboard, with which the tech company could modify events, users, and
registrations on behalf of small businesses. However, it currently only displays the event and member information in
readonly format at http://localhost:8080.

## Client module
This module contains a standalone HTML/JavaScript client that consumes the API. The client constructs JSON messages 
that conform to the API's expected structure and uses JavaScript to perform *fetch* requests.

The client application is not part of Spring Boot, but for simplicity's sake it is contained in the same IntelliJ project.
To launch the client, open `client/htdocs/index.html` and click on the icon in the top right corner for your browser
of choice. This will launch IntelliJ's built-in preview server, which runs on port 63342 by default.

![IntelliJ next to Chrome](./client-launch.png)

## CORS
Because the client and the server are running on different ports (8080 versus 63342), they have different *origins*.
Browsers will not allow JavaScript to make requests for resources at different origins without special permission from
the server, so we must enable *cross-origin resource sharing* (or [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS)) within Spring Boot.