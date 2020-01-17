# Tema 06 - Deploy no Jetty com Docker

Para realizar o deploy da aplicação, será necessário instalar o Docker (```https://www.docker.com/```) e a imagem docker do Jetty (pode ser feito com o comando ```docker pull jetty```)

Primeiro é preciso buildar o projeto em um arquivo war. Isso pode ser feito entrando na raiz do projeto e executando o seguinte comando:
```
./gradlew clean build
```

A seguir é necessário buildar a imagem do docker. Isso pode ser feito entrando na raiz do projeto e executando o seguinte comando:
```
docker build -t calculator .
```

Por fim, é preciso rodar a imagem docker criado anteriormente. Isso pode ser feito com o comando:
```
docker run -p 8080:8080 -d calculator
```

A aplicação possui 5 operações disponíveis:
* sum
* sub
* div
* mul
* pow

A calculadora possui 3 parâmetros obrigatórios: num1, num2 e op (a operação realizada será num1 op num2).

Exemplo de url utilizada para calcular 8 * 3.2
```
localhost:8080/calculator?num1=8&num2=3.2&op=mul
```
