
# 🛡️ Prevenção de Injeção de SQL em Aplicações Web

A injeção de SQL é uma das vulnerabilidades mais perigosas e comuns em aplicações web. Para proteger sua aplicação, é essencial adotar práticas seguras no acesso ao banco de dados.

## 🔐 Técnicas para Prevenir Injeção de SQL

### 1. Utilização de Consultas Parametrizadas (Prepared Statements)
Essa é a técnica mais eficaz e recomendada para prevenir injeções de SQL.

**Exemplo com JDBC (Java):**
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {

    public Usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/meubanco", "user", "password");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
```

---

### 2. Uso de ORM (Object-Relational Mapping)
ORMs como **Hibernate**, **JPA**, e **Entity Framework** abstraem a manipulação direta de SQL, tornando o processo mais seguro.

**Exemplo com JPA e Hibernate (Java):**
```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UsuarioRepository {

    private final EntityManager entityManager;

    public UsuarioRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Usuario buscarPorEmail(String email) {
        String jpql = "SELECT u FROM Usuario u WHERE u.email = :email";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }
}
```

---

### 3. Validação de Dados na Entrada
Sempre valide e sanitize os dados fornecidos pelo usuário.

**Exemplo com validação usando Spring Boot (Java):**
```java
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "O e-mail é obrigatório")
    private String email;

    // Getters e Setters
}
```

---

### 4. Uso de Stored Procedures
Stored Procedures encapsulam a lógica SQL diretamente no banco de dados, reduzindo a superfície de ataque.

**Exemplo com Stored Procedure (MySQL):**
```sql
DELIMITER //

CREATE PROCEDURE BuscarUsuarioPorEmail(IN emailParam VARCHAR(255))
BEGIN
    SELECT * FROM usuarios WHERE email = emailParam;
END //

DELIMITER ;
```

**Exemplo de chamada via Java:**
```java
CallableStatement stmt = conn.prepareCall("{CALL BuscarUsuarioPorEmail(?)}");
stmt.setString(1, "usuario@exemplo.com");
ResultSet rs = stmt.executeQuery();
```

---

### 5. Privilégios Restritivos no Banco de Dados
Configure os privilégios de acesso de forma segura:

**Exemplo de criação de usuário seguro (MySQL):**
```sql
CREATE USER 'app_user'@'localhost' IDENTIFIED BY 'senhaSegura';
GRANT SELECT, INSERT, UPDATE ON meubanco.* TO 'app_user'@'localhost';
```

---

### 6. Uso de Firewalls e WAF (Web Application Firewall)
- Utilize um **WAF** para bloquear tentativas comuns de injeção de SQL.
- Configurações avançadas de segurança em servidores como **Nginx**, **Apache**, ou **AWS WAF** também ajudam a prevenir ataques.

---

### 7. Criptografia e Hashing de Dados Sensíveis
Embora não previna diretamente a injeção de SQL, armazenar dados sensíveis de forma segura reduz os danos em caso de invasão.

**Exemplo com Java usando `BCrypt`:**
```java
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SegurancaUtils {

    public static String criptografarSenha(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }
}
```

---

## ✅ Resumo das Boas Práticas
- ✔️ Use consultas parametrizadas sempre que possível.  
- ✔️ Adote ORMs como Hibernate ou JPA.  
- ✔️ Valide e sanitize todas as entradas.  
- ✔️ Implemente Stored Procedures para lógica complexa no banco de dados.  
- ✔️ Restrinja os privilégios dos usuários do banco de dados.  
- ✔️ Utilize firewalls e ferramentas de monitoramento de tráfego.  
- ✔️ Armazene dados sensíveis de forma segura (criptografia e hashing).

---

## 🚨 Exemplo de Código Inseguro (Evitar)
```java
String sql = "SELECT * FROM usuarios WHERE email = '" + email + "'";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(sql);
```

❌ **Risco:** Se `email` for `"usuario@exemplo.com' OR '1'='1"``, ele retornará todos os registros!

