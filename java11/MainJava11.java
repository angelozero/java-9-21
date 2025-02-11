package java11;

public class MainJava11 {
    public static void main(String[] args) {
        // Exemplo antes do Java 11
        String velhoTexto = "   Hello, World!   ";
        String resultado = velhoTexto.trim();

        // imprime sem espaços: "Hello, World!"
        System.out.println(resultado);

        // Exemplo no Java 11
        var novoTexto = "   Hello, World!   ";
        System.out.println(novoTexto.isBlank());
        // Remove espaços em branco no início e no fim
        System.out.println(novoTexto.strip());

        // imprime sem espaços: "Java Java Java"
        System.out.println("Java ".repeat(3));
    }
}
