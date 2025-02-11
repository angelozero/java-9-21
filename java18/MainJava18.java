package java18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class MainJava18 {
    public static void main(String[] args) throws IOException {

        // Exemplo antes do Java 18
        var velhoConteudo = new String(Files.readAllBytes(Paths.get("java18/old-file.txt")), "ISO-8859-1");
        System.out.println(velhoConteudo);

        // Exemplo no Java 18
        var novoConteudo = Files.readString(Paths.get("java18/new-file.txt"), StandardCharsets.UTF_8);
        System.out.println(novoConteudo);

        /*****/

        // Exemplo antes do Java 18
        var velhoTexto = "Java 18";
        var velhoResultado = velhoTexto.toUpperCase();
        System.out.println(velhoResultado);

        // Exemplo no Java 18
        var novoTexto = "Java 18";
        // Usando transform para conversão
        var novoResultado = novoTexto.transform(String::toUpperCase);
        System.out.println(novoResultado);

    }
}
