

FROM  gradle:latest as builder


WORKDIR /app
COPY . .
RUN ./gradlew installDist


FROM openjdk:latest


WORKDIR /app

COPY --from=builder /app/build/install/serverlessktktor ./
CMD ["./bin/serverlessktktor"]