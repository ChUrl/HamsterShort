FROM gradle:7.3.3-jdk17-alpine AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN gradle bootJar --no-daemon -i --stacktrace

FROM openjdk:17.0.2-slim-buster AS deploy
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/hamstershort.jar
COPY --from=build /home/gradle/src/wait-for-it.sh /app/wait-for-it.sh
RUN chmod +x /app/wait-for-it.sh
