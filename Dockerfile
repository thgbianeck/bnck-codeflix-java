# Use uma imagem base de Java 17 baseada no Debian
FROM openjdk:17-jdk-slim

# Instale o Gradle e outras dependências
RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget https://services.gradle.org/distributions/gradle-7.5-bin.zip -P /tmp && \
    unzip -d /opt/gradle /tmp/gradle-*.zip && \
    rm /tmp/gradle-*.zip

# Configure o PATH para incluir o Gradle
ENV GRADLE_HOME=/opt/gradle/gradle-7.5
ENV PATH=${GRADLE_HOME}/bin:${PATH}

# Instale o zsh e outras ferramentas úteis
RUN apt-get install -y zsh git curl && \
    chsh -s $(which zsh)

# Instale o Oh My Zsh
RUN sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)" "" --unattended && \
    git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting && \
    git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions

# Configure o zsh
RUN echo "plugins=(git zsh-syntax-highlighting zsh-autosuggestions)" >> ~/.zshrc

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie os arquivos do projeto para o contêiner
COPY . /app

# Mantenha o contêiner em execução
CMD ["tail", "-f", "/dev/null"]
