#!/bin/bash
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[0;33m'
NOCOLOR='\033[0m'

imagePort="8001"
imageName="formacion-server"
imageDockerName="formacion-server:v1.0"

imageID=`docker ps -a --format "{{.ID}}" --filter status=running  --filter "name=$imageName"`
if [ -z $imageID ]; then
  statusCommand=`docker run -p $imagePort:$imagePort --name $imageName --restart always -d $imageDockerName` > /dev/null 2>&1
  if [ `echo $statusCommand | wc -c` -eq "65" ]; then
    firstTwelveCharacter=`printf '%s' "$statusCommand" | awk '{print substr ($0, 0, 12)}'`
    echo "The docker image ${GREEN}[$imageName]${NOCOLOR} is already running with ID: ${YELLOW}$firstTwelveCharacter${NOCOLOR}"
    exit 0
  else
    echo "Could not run docker image: ${RED}[$imageName]${NOCOLOR}"
    exit 1
  fi
else
  echo "The docker image ${GREEN}[$imageName]${NOCOLOR} is already running with ID: ${YELLOW}$imageID${NOCOLOR}"
  exit 0
fi