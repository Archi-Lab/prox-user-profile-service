# prox-user-profile-service

Using spring-boot connected to a mongo-db instance running in a docker container mapped on port 27017

After pulling this repository, install a mongo-db instance in a docker container and start it with the command

(sudo) docker run -d -p 27017:27017 -v ~/data:/data/db mongo
Notice: sudo is only needed if you are running a Linux or Apple OS, on Windows "start cmd as admin" should follow its purpose

This will make the container available on localhost:27017

After that, you need to install a mongo-db shell client to connect to your instance via terminal

If you got that finished, you can simply type "mongo" into your terminal and it will connect to the instance laying in the container. The next step is to create a user. To do so, you only need to run the following command in the terminal: 
db.createUser( { user: "root",
                 pwd: "root",
                 roles: [ { role: "readWrite", db: "db_test" }],
                   } );
                   
This is also the user the spring-boot project is configured for to login at this time.
