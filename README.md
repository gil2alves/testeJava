# Teste Java Developer - Resolução das Atividades

Este repositório contém a resolução das 9 atividades propostas no teste para desenvolvedor Java. Cada atividade está documentada e implementada em sua respectiva pasta.

## 📁 Atividades

### [Atividade 01](./Atividade%2001)
**Geração de Anagramas**  
Escreva um programa em Java que gere todos os anagramas possíveis a partir de um grupo de letras distintas. Inclua validações, testes unitários e documentação do código.

---

### [Atividade 02](./Atividade%2002)
**Sobrescrever `equals()` em Java**  
Forneça um exemplo onde é necessário sobrescrever `equals()` em Java, explicando a relação com `hashCode()` e fornecendo exemplos de código.

---

### [Atividade 03](./Atividade%2003)
**Desacoplamento com Padrões de Projeto**  
Explique como usar um padrão de projeto para desacoplar seu código de uma biblioteca de terceiros, incluindo vantagens, limitações e um trecho de código.

---

### [Atividade 04](./Atividade%2004)
**Experiência com Angular**  
Descreva sua experiência com Angular, funcionalidades principais e forneça um exemplo de uso prático com código demonstrando comunicação entre componentes, data binding ou integração com serviços.

---

### [Atividade 05](./Atividade%2005)
**Prevenção de SQL Injection**  
Explique técnicas para prevenir injeções de SQL, com exemplos de queries parametrizadas, uso de ORM e outras medidas de segurança na camada de banco de dados.

---

### [Atividade 06](./Atividade%2006)
**Otimização de Processos Batch com Banco e FTP**  
Descreva como diagnosticar e melhorar o desempenho de um processo em lote que interage com banco de dados e servidor FTP, com ferramentas e técnicas utilizadas.

---

### [Atividade 07](./Atividade%2007)
**Consultas SQL**  
Com base nas tabelas fornecidas:
- a) Vendedores que não têm pedidos com a empresa *Samsonic*  
- b) Atualizar nomes dos vendedores com 2 ou mais pedidos (adicionar ‘*’)  
- c) Excluir vendedores que fizeram pedidos para a cidade *Jackson*  
- d) Mostrar total de vendas por vendedor, exibindo zero quando aplicável

Além das consultas SQL, foi desenvolvida uma API REST em Jakarta EE com endpoints que executam essas funcionalidades. O projeto está empacotado como um `.war` e executado em um container Docker com WildFly.

O projeto da API está localizado em `./Atividade 07/app`.

#### 🚀 Executando o container WildFly
Para rodar a aplicação via Docker:

1. Certifique-se de que o `.war` já existe na pasta `target/` (ex: após clonar ou baixar o projeto):
```bash
ls target/jakarta-app.war
```

2. Suba o container com Docker Compose:
```bash
docker-compose up --build
```

> 💡 Não é necessário compilar novamente com `mvn clean package` se o arquivo `.war` já estiver presente em `target/`.

3. A aplicação estará disponível em: [http://localhost:8080/jakarta-app](http://localhost:8080/jakarta-app)

4. Acesse o endpoint de teste para verificar se está rodando:
```http
GET http://localhost:8080/jakarta-app/api/vendedores/teste
```

#### 📬 Importando os Endpoints no Postman
Na pasta `Atividade 07`, foi disponibilizado o arquivo `vendedor-service-collection.json` que contém todos os endpoints REST em formato de *collection Postman*.

Para importar:
1. Abra o Postman
2. Clique em **Import** > **Upload File**
3. Selecione o arquivo `vendedor-service-collection.json`
4. A coleção aparecerá com os seguintes endpoints:
   - `/teste`
   - `/semPedidos/{cliente}`
   - `/adicionarAsterisco`
   - `/excluirPorCidade/{cidade}`
   - `/totalVendas`

---

### [Atividade 08](./Atividade%2008)
**Caso de Uso - Sistema XYZ - Gestão de Plantas**  
Escreva uma user story/caso de uso para criação, atualização, exclusão e pesquisa de plantas, com regras de negócio, validações, segurança e estratégia de testes com casos de borda.

---

### [Atividade 09](./Atividade%2009)
**Cadastro de Usuários - Tipos de Testes**  
Descreva os testes (unitário, integração, ponta a ponta) para o cadastro de usuários. Inclua cenários, casos de borda e um exemplo de caso de teste em pseudocódigo ou código.

---

