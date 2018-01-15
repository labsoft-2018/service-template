FROM java:8
MAINTAINER labsoft-2018

ADD target/{{name}}-0.0.1-SNAPSHOT-standalone.jar /srv/{{name}}.jar

EXPOSE {{http-port}}

CMD ["java", "-jar", "/srv/{{name}}.jar"]
