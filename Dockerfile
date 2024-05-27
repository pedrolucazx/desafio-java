# Usar a imagem base do Maven 3.8.1 e OpenJDK 17 para construção
FROM maven:3.8.1-openjdk-17 AS build

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o script Maven Wrapper e o pom.xml
COPY mvnw .
COPY .mvn .mvn

# Copiar o código fonte para o diretório de trabalho
COPY pom.xml .
COPY src ./src

# Garantir que o script mvnw tenha permissões de execução
RUN chmod +x ./mvnw

# Executar o comando de construção da aplicação
RUN ./mvnw clean package

# Usar a imagem base do OpenJDK 17 para a aplicação
FROM openjdk:17-jdk-slim AS final

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o JAR da imagem de construção para a imagem final
COPY --from=build /app/target/desafio-0.0.1-SNAPSHOT.jar app.jar

# Instalar o utilitário netcat para aguardar o banco de dados
RUN apt-get update && apt-get install -y netcat

# Aguardar até que o MySQL esteja disponível antes de iniciar a aplicação
CMD ["sh", "-c", "while ! nc -z mysql 3306; do sleep 1; done; java -jar app.jar"]