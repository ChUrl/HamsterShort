#!/bin/sh

git -C HamsterShort pull

docker-compose pull
docker-compose up -d --remove-orphans
docker image prune -f
