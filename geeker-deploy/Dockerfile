FROM java:8  
EXPOSE 8585 
VOLUME /tmp 
ADD love-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar' 
ENTRYPOINT ["java", "-jar", "/app.jar"]