FROM nginx

RUN apt update

RUN apt -y install git

WORKDIR /usr/share/nginx

RUN rm -rf html

RUN git clone https://github.com/gabrielecirulli/2048.git /usr/share/nginx/html

EXPOSE 80