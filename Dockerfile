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
ENV APP_ARTIFACT="hack-api-backend-${VERSION}.jar"

LABEL maintainer="Justa" \
        version=$VERSION \
        description=""

COPY --from=BUILDER /usr/app/build/libs/$APP_ARTIFACT .
ADD startup.sh //
EXPOSE 7010
# ENTRYPOINT ["/bin/bash", "/startup.sh"]

ENTRYPOINT ["/bin/bash", "startup.sh"]