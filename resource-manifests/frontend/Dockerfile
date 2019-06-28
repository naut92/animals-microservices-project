#создать изображение:
        #custom_nginx:
#2. docker build -t frontend/animals-app-client-custom-nginx .

FROM busybox:latest
COPY ./build /html
CMD "tail" "-f" "/dev/null"

# files inside image:
#docker run -it frontend/animals-app-client-custom-nginx sh
#/ # ls