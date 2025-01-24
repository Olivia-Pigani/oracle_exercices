# Commands

1. run Docker Desktop to get Docker deamon

2. build an image with Dockerfile, put these lines : 

```
FROM nginx

RUN apt update

RUN apt -y install git

WORKDIR /usr/share/nginx

RUN rm -rf html

RUN git clone https://github.com/gabrielecirulli/2048.git /usr/share/nginx/html

EXPOSE 80

```

3. run : "docker build -t 2048_game:v1 ." to build the image

4. run "docker images" to see your image

5. launch the game with a container running : "docker run -p 3000:80 2048_game:v1"

6. now you can go to : http://localhost:3000/ and even run "docker ps" to see your container

7. to make a second container, run "docker run --name mysecondgame -p 3001:80 2048_game:v1", notice that the port is different in the machine side, you can go to http://localhost:3001/ for the second game

8. to see both containers run : docker ps

9. run "docker stop $(docker ps -a -q)" to stop all containers

10. run "docker ps -a" to see all containers, so even containers that are exited but still there

11. run "docker start mysecondgame" to restart the second game

12. "docker stop mysecondgame" to stop this one to remove the game image. Then "docker rm $(docker ps -a -q)"

13. remove the game image with running : "docker rmi 2048_game:v1"

14. run "docker images" to see that there is no images anymore.




