FROM gradle:8.8-jdk17-alpine

WORKDIR /usr/app/

COPY . .

# Atualiza os repositórios do Alpine e instala Node.js e npm
RUN apk add --no-cache nodejs npm

# Cria os diretórios necessários e configura as permissões
RUN mkdir -p /root/.gradle /usr/app/.gradle

# Defina o comando padrão
CMD ["tail", "-f", "/dev/null"]
