# Commands

## Nginx

1. pull nginx image with running : " docker pull nginx "

2. docker run -p 3000:80 --name  nginx-web nginx 

3. docker images + docker ps

4. go to http://localhost:3000/

5. docker exec -it nginx-web sh

6. cd /usr/share/nginx/html/

6. (bis) to install nano do :  apt update + apt install -y nano + nano --version

7. nano index.html to overwrite html

 change title and put your name : <title>Olivia</title>

you can type exit to quit the exec mode, restart server and  go to http://localhost:3000/ again

## Apache httpd server

8. same thing with apache server

9. docker pull httpd

10. docker run -p 8080:80 --name  apache_server httpd 

11. go to http://localhost:8080/

12. docker exec -it apache_server sh

13. cd htdocs

14. nano index.html after running : apt update + apt install -y nano + nano --version

15. mae updates : <html><body><h1>Je suis heureuse et je m'appelle Olivia</h1></body></html>

16. restart server and see the result in http://localhost:8080/ ! 