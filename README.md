# Hostname for logging is determined at build-time

Steps to reproduce:

1. Native build with `mvn clean install -Pnative`
2. Start the application in a docker container:
   ```shell
   docker run -h runtime-hostname -it --rm --entrypoint=/target/native-hostname-1.0.0-SNAPSHOT-runner -v $PWD/target:/target -p 8080:8080 quay.io/quarkus/quarkus-micro-image:2.0
   ```
3. Call the service with a GET at http://localhost:8080/hello
4. Observe in the logging:
   ```
   2024/06/27 14:16:12.086 buildtime-hostname Hello from host runtime-hostname
   ```
