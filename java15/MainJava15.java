package java15;

import java.util.Optional;

public class MainJava15 {
    public static void main(String[] args) {
        // Exemplo antes do Java 15
        String velhoTexto = """
                Linha 1
                Linha 2
                """;

        // Exemplo no Java 15
        String novoTexto = """
                Linha 1
                Linha 2
                """;

        // Agora você pode usar stripIndent() para remover a indentação
        System.out.println(novoTexto.stripIndent());

        /*****/

        // Exemplo antes do Java 15
        Optional<String> velhoOptional = Optional.ofNullable("Texto");
        String velhoValor = velhoOptional.orElse("Valor padrão");
        System.out.println(velhoValor);

        // Exemplo no Java 15
        Optional<String> novoOptional = Optional.ofNullable("Texto");

        // Usando ifPresentOrElse
        novoOptional.ifPresentOrElse(
                novoValor -> System.out.println("Valor presente: " + novoValor),
                () -> System.out.println("Valor não presente")
        );

        // Usando stream()
        novoOptional.stream().forEach(System.out::println);

    }
}
