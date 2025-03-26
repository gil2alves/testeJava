
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

### 🔎 **Conclusão:**
Este caso de uso cobre todos os requisitos fornecidos, implementando as melhores práticas de segurança e validação para garantir a integridade dos dados e o cumprimento das regras de negócio. Essa abordagem proporciona maior confiabilidade e segurança para a funcionalidade de gerenciamento de plantas no sistema de vendas.
