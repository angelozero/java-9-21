package java09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class MainJava9 {

    public static void main(String[] args) {

        // Exemplo de programação imperativa
        List<String> lista = Arrays.asList("A", "B", "C");
        for (String s : lista) {
            System.out.println(s);
        }

        // Usando a API reativa
        Stream<String> stream = Stream.of("A", "B", "C");
        stream.forEach(System.out::println);

        /*****/

        // Criando uma lista imutável antes do Java 9
        List<String> velhaListaImutavel = Collections.unmodifiableList(new ArrayList<>(Arrays.asList("A", "B", "C")));

        // Criando uma lista imutável no Java 9
        List<String> novalistaImutavel = List.of("A", "B", "C");

    }
}
