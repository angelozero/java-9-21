package java16;

import java.util.List;
import java.util.stream.Collectors;

public class MainJava16 {
    public static void main(String[] args) {
        // Exemplo antes do Java 16
        var velhoTexto = "Java 16";
        // Convertendo para maiúsculas
        var velhoResultado = velhoTexto.toUpperCase();
        System.out.println(velhoResultado);

        // Exemplo no Java 16
        String novoTexto = "Java 16";
        List<Character> lista = novoTexto.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        // Imprime a lista de caracteres
        System.out.println(lista);

    }
}
