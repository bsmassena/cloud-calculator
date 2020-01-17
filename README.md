# Calculadora com RxNetty

Antes de realizar o deploy da aplicação, é preciso certificar-se de:
* Ter o docker instalado (```https://www.docker.com/```)
* Nenhuma aplicação estar rodando na porta 8080

Para realizar o deploy, basta executar o seguinte comando:
```
bash deploy.sh
```

Este script deve:
1. Compilar o projeto utilizando gradle
2. Construir a imagem docker para o microserviço
3. Rodar um container docker para a imagem criada

Alguns segundos após executar o script, o microserviço deve estar rodando e poderá ser utilizados da seguinte forma:
```
http://localhost:8080/sum/4/8
```
