import java.util.ArrayList;
import java.util.List;

public class GeradorDeAnagramas {

    // Método principal para gerar anagramas
    public static List<String> gerarAnagramas(String entrada) {
        List<String> resultado = new ArrayList<>();

        // Validação de entrada
        if (entrada == null || entrada.trim().isEmpty()) {
            throw new IllegalArgumentException("A entrada não pode estar vazia ou nula.");
        }

        if (!entrada.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("A entrada deve conter apenas letras.");
        }

        // Chama o método recursivo para gerar anagramas
        gerarAnagramasRecursivo("", entrada, resultado);
        return resultado;
    }

    // Método recursivo para gerar anagramas
    private static void gerarAnagramasRecursivo(String prefixo, String restante, List<String> resultado) {
        if (restante.isEmpty()) {
            resultado.add(prefixo);
        } else {
            for (int i = 0; i < restante.length(); i++) {
                char escolhido = restante.charAt(i);
                String novoPrefixo = prefixo + escolhido;
                String novoRestante = restante.substring(0, i) + restante.substring(i + 1);
                gerarAnagramasRecursivo(novoPrefixo, novoRestante, resultado);
            }
        }
    }

    // Método principal para testes
    public static void main(String[] args) {
        // Exemplo de uso
        String entrada = "abc";
        List<String> anagramas = gerarAnagramas(entrada);

        System.out.println("Anagramas de '" + entrada + "':");
        anagramas.forEach(System.out::println);
    }
}
