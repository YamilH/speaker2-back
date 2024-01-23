# Speaker2-Back

## Overview

This project is the back-end part of a fullstasck project.

The Java back-end most recent version is in this repository: https://github.com/YamilH/speaker2-back.


## Back Project Structure

The project follows a specific directory structure to organize the server-side code. Here's an overview of the directory structure:

```.
├─── speaker2
│       └──  src/main
│               ├─── java/ar/com/speaker2
│               │           ├─── controllers
│               │           │        ├─── AppBaseController.java
│               │           │        ├─── NewSpeakerController.java
│               │           │        └─── SpeakerRequest.java
│               │           ├─── entity
│               │           │        ├─── Speaker.java
│               │           │        └─── SpeakerMain.java
│               │           ├─── filters
│               │           │        └─── CorsFilter.java
│               │           └─── repository
│               │                    ├─── ConnectionsManager.java
│               │                    ├─── MainSpeakerRepository.java
│               │                    ├─── MySQLSpeakerRepository.java
│               │                    └─── SpeakerRepository.java
│               └─── webapp
│                      └─── index.html
├─── .gitignore
├─── README.md
└─── pom.xml

```


## Deployment

The deploy is currently not available at the moment, but here is a testing video of the fullstack project.

(video will be here soon)


## Conclusion

The idea behind Speaker was to create a simulated TED talk project, primarily focusing on building the backend with Java and establishing the necessary connections to make it a fullstack application where anybody can suscribe to give a talk and then an admin part where the people who have access can edit and track the susbcribers.
