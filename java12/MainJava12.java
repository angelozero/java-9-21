package java12;

public class MainJava12 {
    public static void main(String[] args) {
        // Exemplo antes do Java 12
        String dia = "Sábado";
        String tipoDia;

        switch (dia) {
            case "Sábado":
            case "Domingo":
                tipoDia = "Fim de semana";
                break;
            default:
                tipoDia = "Dia de semana";
        }
        System.out.println(tipoDia);


        // Exemplo no Java 12
        var novoDia = "Sábado";

        var novoTipoDia = switch (novoDia) {
            case "Sábado":
            case "Domingo":
                // 'yield' foi introduzido para retornar um valor
                yield "Fim de semana";
            default:
                yield "Dia de semana";
        };
        System.out.println(novoTipoDia);
    }
}
