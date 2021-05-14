FROM postgres:13.2

ENV POSTGRES_VERSION 13

RUN apt-get update \
      && apt-cache showpkg postgresql-$POSTGRES_VERSION-postgis-3 \
      && apt-get install -y --no-install-recommends \
           postgresql-$POSTGRES_VERSION-postgis-3 \
      && rm -rf /var/lib/apt/lists/*
