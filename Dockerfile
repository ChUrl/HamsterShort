FROM gradle:jdk15 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar --no-daemon

FROM openjdk:15-slim
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/hamstershort.jar
COPY --from=build /home/gradle/src/wait-for-it.sh /app/wait-for-it.sh
RUN chmod +x /app/wait-for-it.sh
