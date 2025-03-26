
## 📋 Caso de Uso: Gerenciamento de Plantas no Sistema de Vendas

### 🎯 **Título:** Gerenciamento de Plantas - CRUD com Controle de Acesso

### 📝 **Descrição:**
Este caso de uso descreve a implementação da funcionalidade de **criar**, **atualizar**, **excluir** e **pesquisar** plantas no sistema de vendas. A funcionalidade será desenvolvida para atender aos seguintes requisitos específicos:

### 📌 **Requisitos:**
1. **Criar Plantas:**
   - O sistema deve permitir que novas plantas sejam adicionadas com as seguintes regras:
     - **Código:** Obrigatório, apenas numérico e único.
     - **Descrição:** Opcional, com até 10 caracteres alfanuméricos.

2. **Atualizar Plantas:**
   - O sistema deve permitir a atualização dos campos `Código` e `Descrição` de uma planta existente.

3. **Excluir Plantas:**
   - Somente usuários com perfil de **administrador** podem excluir plantas.

4. **Pesquisar Plantas:**
   - O sistema deve permitir que todos os usuários pesquisem plantas utilizando o `Código` ou a `Descrição` como critério.

5. **Prevenção de Duplicação:**
   - O sistema deve rejeitar a inserção de plantas com códigos duplicados.

---

### ⚙️ **Regras de Negócio:**
- O `Código` deve ser tratado como **chave primária** e conter apenas números.
- Caso uma tentativa de exclusão ocorra por um usuário que não seja administrador, o sistema deve bloquear essa ação e exibir uma mensagem de erro.
- Para atualizações, se o `Código` for alterado para um valor que já existe, o sistema deve rejeitar a operação.

---

### 🛡️ **Validações e Medidas de Segurança:**
✅ Utilizar **anotações de validação** no back-end para verificar as regras de preenchimento de campos.
✅ Implementar **verificação de permissões** via autenticação para garantir que apenas administradores possam excluir plantas.
✅ Adotar **controle transacional** para evitar inconsistências em caso de falhas durante operações.
✅ Aplicar **bloqueio otimista (optimistic locking)** para evitar conflitos de atualização simultânea.

**Exemplo de Validações:**
- `Código`: Obrigatório, numérico e único.
- `Descrição`: Opcional, máximo de 10 caracteres.

---

### 🧪 **Plano de Testes:**

#### ✅ **Testes Funcionais:**
1. **Inserção de Nova Planta**
   - [ ] Criar uma planta com código válido e descrição opcional (deve funcionar).
   - [ ] Criar uma planta com código já existente (deve falhar).

2. **Atualização de Planta**
   - [ ] Atualizar a descrição de uma planta existente (deve funcionar).
   - [ ] Alterar o código de uma planta para um valor já existente (deve falhar).

3. **Exclusão de Planta**
   - [ ] Excluir uma planta como administrador (deve funcionar).
   - [ ] Tentar excluir uma planta como usuário comum (deve falhar).

4. **Pesquisa de Plantas**
   - [ ] Buscar uma planta existente pelo código.
   - [ ] Buscar uma planta inexistente (deve retornar vazio).

#### 🚨 **Testes de Casos Extremos:**
- [ ] Inserir uma planta com `Código` maior que o esperado (deve falhar).
- [ ] Inserir uma planta com `Descrição` com mais de 10 caracteres (deve falhar).
- [ ] Inserir uma planta sem `Código` (deve falhar).
- [ ] Testar comportamento simultâneo com múltiplos usuários alterando a mesma planta (conflito esperado).

---

### 🔎 **Funcionalidade: Cadastro de Usuário**

### 📌 **Tipos de Testes:**
- **Testes Unitários:** Para validar cada função individualmente, como:
  - Verificar se um usuário é salvo corretamente.
  - Garantir que não é possível criar dois usuários com o mesmo e-mail.

- **Testes de Integração:** Para validar a comunicação entre os componentes, como:
  - Testar se a API corretamente insere ou atualiza os dados na base.

- **Testes de Ponta a Ponta (E2E):** Para garantir que todo o fluxo funciona conforme esperado, como:
  - Criar, atualizar, excluir e listar usuários na interface.

### 🧪 **Cenários de Teste:**

1. **Inserção de Usuário:**
   - [ ] Inserir um usuário com nome e e-mail válidos (deve funcionar).
   - [ ] Tentar inserir um usuário com e-mail duplicado (deve falhar).

2. **Atualização de Usuário:**
   - [ ] Atualizar o telefone ou endereço de um usuário existente (deve funcionar).
   - [ ] Alterar o e-mail para um já existente (deve falhar).

3. **Exclusão de Usuário:**
   - [ ] Excluir um usuário como administrador (deve funcionar).
   - [ ] Tentar excluir um usuário como usuário comum (deve falhar).

4. **Validação de Campos:**
   - [ ] Tentar inserir um usuário sem nome ou e-mail (deve falhar).

### 🖥️ **Exemplo de Código para Teste Unitário (JUnit)**
```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UsuarioServiceTest {

    @Test
    void deveCriarUsuarioComSucesso() {
        Usuario usuario = new Usuario("João", "joao@email.com", "Rua X", "11999999999");
        assertTrue(usuarioService.salvar(usuario));
    }

    @Test
    void naoDeveCriarUsuarioComEmailDuplicado() {
        Usuario usuario1 = new Usuario("Maria", "maria@email.com", "Rua Y", "11988888888");
        Usuario usuario2 = new Usuario("Pedro", "maria@email.com", "Rua Z", "11977777777");
        usuarioService.salvar(usuario1);
        assertThrows(DuplicatedEmailException.class, () -> usuarioService.salvar(usuario2));
    }
}
```
