import java.util.Objects;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;

    public Cliente(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null || getClass() != obj.getClass()) return false;

        Cliente cliente = (Cliente) obj;
        return Objects.equals(cpf, cliente.cpf); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Ana Souza", "ana@gmail.com", "123.456.789-00");
        Cliente cliente2 = new Cliente("Ana Souza", "ana.souza@gmail.com", "123.456.789-00");
        Cliente cliente3 = new Cliente("Carlos Silva", "carlos@gmail.com", "987.654.321-00");

        System.out.println("cliente1 é igual a cliente2? " + cliente1.equals(cliente2)); 
        System.out.println("cliente1 é igual a cliente3? " + cliente1.equals(cliente3)); 
    }
}
