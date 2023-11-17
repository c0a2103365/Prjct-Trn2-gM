FROM openjdk:11-slim

RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install sudo
WORKDIR /javac2
ADD  setup.sh  /
RUN  chmod +x /setup.sh
CMD  ["/setup.sh"]