# Spustenie aplikácie OOTS evidence finder

Jar aplikácie a docker súbory sú v samostatnom [priečinku](https://github.com/slovak-egov/oots-poc/tree/main/docker/evidence-finder)

### Konfigurácia 
V docker-compose.yml je definovaná premenná prostredia COMMON_SERVICES_URL kde je url na common services, defaultne ide o common services z projectathon.
Pre preťaženie konfigurácie je nutné upraviť dev.yml, test.yml alebo prod.yml.

### Build kontajnera
    docker-compose build

### Spustenie kontajnera
    docker-compose up -d

### Spustenie kontajnera s preťaženou konfiguráciou pre dev prostredie
    docker-compose -f docker-compose.yml -f dev.yml up -d

### Vypnutie kontajnera
    docker-compose down
