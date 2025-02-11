package java14;

import java.util.Optional;

public class MainJava14 {
    public static void main(String[] args) {

        //Exemplo antes do Java 14
        PessoaClass pessoaClass = new PessoaClass("Angelo", 35);

        //Exemplo no Java 14
        var pessoaRecord = new PessoaRecord("Angelo", 35);


        /*****/
        // Exemplo antes do Java 14
        Object velhoObj = "Uma string";
        if (velhoObj instanceof String) {
            // Necessário fazer o cast
            String str = (String) velhoObj;
            System.out.println(str.toUpperCase());
        }

        // Exemplo no Java 14
        Object novoObj = "Uma string";
        // Casting automático
        if (novoObj instanceof String str) {
            System.out.println(str.toUpperCase());
        }

        /*****/

        // Exemplo antes do Java 14
        String texto = "  Java 14  ";
        String velhoResultado = texto.trim();
        System.out.println(velhoResultado);

        // Exemplo no Java 14
        var nome = "Angelo";
        int idade = 35;
        var novoResultado = "Nome: %s, Idade: %d".formatted(nome, idade);
        System.out.println(novoResultado);

        /*****/

        // Exemplo antes do Java 14
        String palavraVelha = null;
        // Gera NullPointerException sem informações úteis
        //System.out.println(palavraVelha.length());

        // Exemplo no Java 14
        String palavraNova = null;
        try {
            System.out.println(palavraNova.length());
        } catch (NullPointerException e) {
            // Mensagem mais informativa sobre a origem do NPE
            System.out.println(e.getMessage());
        }
    }
}
