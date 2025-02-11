package java19;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainJava19 {
    public static void main(String[] args) throws IOException {
        // Exemplo antes do Java 19
        Object velhoObj = "Sábado";
        String velhoTipoDia;

        switch (velhoObj.getClass().getSimpleName()) {
            case "String":
                String dia = (String) velhoObj;
                velhoTipoDia = (dia.equals("Sábado") || dia.equals("Domingo")) ? "Fim de semana" : "Dia de semana";
                break;
            default:
                velhoTipoDia = "Não é um dia válido";
        }

        System.out.println(velhoTipoDia);

        // Exemplo no Java 19
        Object novoObj = "Sábado";
        String novoTipoDia = switch (novoObj) {
            case String dia when dia.equals("Sábado") || dia.equals("Domingo") -> "Fim de semana";
            case String dia -> "Dia de semana";
            default -> "Não é um dia válido";
        };

        System.out.println(novoTipoDia);

    }
}
