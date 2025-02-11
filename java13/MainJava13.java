package java13;

import java.util.Optional;

public class MainJava13 {
    public static void main(String[] args) {
        // Exemplo antes do Java 13
        var velhoTexto = "Esta é uma string\n" +
                "que ocupa várias linhas\n" +
                "e precisa de caracteres de escape.";
        System.out.println(velhoTexto);

        // Exemplo no Java 13
        var novoTexto = """
                Esta é uma string
                que ocupa várias linhas
                e não precisa de caracteres de escape.
                """;
        System.out.println(novoTexto);

        /*****/

        // Exemplo antes do Java 13
        var velhoDia = "Sábado";
        var velhoTipoDia = "";

        switch (velhoDia) {
            case "Sábado":
            case "Domingo":
                velhoTipoDia = "Fim de semana";
                break;
            default:
                velhoTipoDia = "Dia de semana";
        }

        System.out.println(velhoTipoDia);

        // Exemplo no Java 13
        var novoDia = "Sábado";
        var novoTtipoDia = switch (novoDia) {
            case "Sábado", "Domingo" -> "Fim de semana";
            default -> "Dia de semana";
        };

        System.out.println(novoTtipoDia);

        /*****/

        // Exemplo antes do Java 13
        String velhaPalavra = " Java 13 ";
        String resultado = velhaPalavra.trim();
        System.out.println(resultado);

        // Exemplo no Java 13
        String novaPalavra = " Java 13 ";
        System.out.println(novaPalavra.strip());
        System.out.println(novaPalavra.isBlank());

        /*****/

        // Exemplo antes do Java 13
        Optional<String> velhoOptional = Optional.ofNullable(null);
        String valor = velhoOptional.orElse("Valor padrão");
        System.out.println(valor);

        // Exemplo no Java 13
        Optional<String> novoOptional = Optional.ofNullable("Texto");
        novoOptional.stream().forEach(System.out::println);

    }
}
