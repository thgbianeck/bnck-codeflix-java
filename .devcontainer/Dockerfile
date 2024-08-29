# Use Alpine como imagem base
FROM alpine:3.18

# Instale as dependências básicas
RUN apk add --no-cache \
    bash \
    curl \
    git \
    zsh \
    openjdk17 \
    gradle \
    nodejs \
    npm \
    libc6-compat \
    shadow \
    && npm install -g prettier

# Instale o VSCode Server
RUN curl -L https://aka.ms/vscode-server-linux-alpine-x64 -o vscode-server.tar.gz \
    && mkdir -p ~/.vscode-server/bin/$(sha256sum vscode-server.tar.gz | cut -d ' ' -f 1) \
    && tar -xzf vscode-server.tar.gz -C ~/.vscode-server/bin/$(sha256sum vscode-server.tar.gz | cut -d ' ' -f 1) --strip-components=1 \
    && rm vscode-server.tar.gz

# Instale as extensões do VSCode
RUN ~/.vscode-server/bin/$(sha256sum vscode-server.tar.gz | cut -d ' ' -f 1)/bin/code-server \
    --install-extension tabnine.tabnine-vscode \
    --install-extension ms-azuretools.vscode-docker \
    --install-extension eamodio.gitlens \
    --install-extension mhutchie.git-graph \
    --install-extension usernamehw.errorlens \
    --install-extension george-alisson.html-preview-vscode \
    --install-extension esbenp.prettier-vscode \
    --install-extension donjayamanne.githistory \
    --install-extension GitHub.github-vscode-theme \
    --install-extension GitHub.vscode-github-actions \
    --install-extension intellsmi.comment-translate \
    --install-extension aaron-bond.better-comments \
    --install-extension Postman.postman-for-vscode \
    --install-extension vscjava.vscode-java-pack \
    --install-extension vmware.vscode-boot-dev-pack \
    --install-extension GitHub.vscode-pull-request-github \
    --install-extension ms-edgedevtools.vscode-edge-devtools

# Configurar Zsh com Oh My Zsh e plugins
RUN sh -c "$(curl -fsSL https://raw.githubusercontent.com/ohmyzsh/ohmyzsh/master/tools/install.sh)" "" --unattended \
    && git clone https://github.com/zsh-users/zsh-autosuggestions ${ZSH_CUSTOM:-~/.oh-my-zsh/custom}/plugins/zsh-autosuggestions \
    && sed -i 's/plugins=(git)/plugins=(git ssh-agent npm zsh-autosuggestions)/' ~/.zshrc

# Configurar o usuário root para usar o Zsh como shell padrão
RUN chsh -s /bin/zsh root

# Defina o diretório de trabalho
WORKDIR /usr/app

# Comando padrão
CMD ["sleep", "infinity"]
