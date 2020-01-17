FROM openjdk:8
WORKDIR /
ADD build/libs/calc.jar calc.jar
CMD ["java","-jar","calc.jar"]