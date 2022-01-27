#!/bin/sh

cd /home/christoph/HamsterShort
git pull

docker-compose pull
docker-compose up -d --remove-orphans
docker image prune -f
