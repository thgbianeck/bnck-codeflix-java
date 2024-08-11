FROM gradle:jdk21-jammy

RUN apt-get update && \
    apt-get install -y wget unzip zsh git curl

# Instalar o Oh My Zsh e plugins
RUN sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)" "" --unattended && \
    git clone https://github.com/zsh-users/zsh-syntax-highlighting.git ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-syntax-highlighting && \
    git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions

# Adicionar os plugins ao .zshrc
RUN echo "plugins=(git zsh-syntax-highlighting zsh-autosuggestions)" >> ~/.zshrc

# Definir o diretório de trabalho
WORKDIR /app

# Copiar os arquivos como root
COPY . /app

# Manter o contêiner em execução
CMD ["tail", "-f", "/dev/null"]
