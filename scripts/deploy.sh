#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=freelec-springboot2-webservice

echo "> Build 파일 복사"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> 현재구동중인 애플리케이션 pid 확인"

#CURRENT_PID=$(pgrep -f ${PROJECT_NAME}*.jar)
CURRENT_PID=$(pgrep -fl freelec-springboot2-webservice | grep jar | awk '{print $1}')

echo "현재 구동 중인 애플리케이션 pid : $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
        echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
        echo "> kill -15 $CURRENT_PID"
        kill -15 $CURRENT_PID
        sleep 5
fi

echo "> 디렉토리 이동"

cd $REPOSITORY/zip

echo "> 새 어플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/zip | grep *.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> 실행디렉토리 이동"

cd $REPOSITORY

echo "> $JAR_NAME 에 실행권한 추가"

chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

nohup java -jar -Dspring.config.location=classpath:/application.properties,classpath:/application-oauth.properties,/home/ec2-user/app/application-real-db.properties -Dspring.profiles.active=real $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
#nohup java -jar -Dspring.config.location=classpath:/application.properties,classpath:/application-oauth.properties,/home/ec2-user/app/application-real-db.properties -Dspring.profiles.active=real freelec-springboot2-webservice-1.0-SNAPSHOT.jar > /home/ec2-user/app/step2/nohup.out 2>&1 &
