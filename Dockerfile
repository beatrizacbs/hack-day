FROM openjdk:8 AS BUILDER

ENV APP_DIR=/usr/app/

WORKDIR $APP_DIR
# copia Gradle bin
COPY build.gradle settings.gradle gradlew $APP_DIR
COPY gradle $APP_DIR/gradle

# App build
COPY . .
RUN echo "---- building application ----" && \
    ./gradlew build || return 0

# App entrypoint

FROM openjdk:8

ARG VERSION
ENV APP_ARTIFACT="hack.jar" \
    APP_NAME="hack-${VERSION}.jar"

LABEL maintainer="Justa" \
        version=$VERSION \
        description="Service responsible for seding boot informations to Justa`s POS."

COPY --from=BUILDER /usr/app/build/libs/$APP_NAME .
RUN mv $APP_NAME $APP_ARTIFACT
EXPOSE 7010
ENTRYPOINT ["java", "-Xmx128m", "-Duser.timezone=America/Sao_Paulo", "-jar", "/hack.jar"]