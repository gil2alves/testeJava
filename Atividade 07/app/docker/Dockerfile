# Usa a imagem do WildFly com Java 17
FROM quay.io/wildfly/wildfly:27.0.1.Final-jdk17

# Copia o .war diretamente para o diretório de deployments
COPY target/jakarta-app.war /opt/jboss/wildfly/standalone/deployments/
