package java10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MainJava10 {
    public static void main(String[] args) {
        // Exemplo antes do Java 10
        String velhoNome = "João";
        int velhaIdade = 30;
        List<String> velhaLista = new ArrayList<>();

        // Exemplo no Java 10
        var novoNome = "João";
        var novaIdade = 30;
        var novaLista = new ArrayList<String>();

        /*****/

        // Exemplo antes do Java 10
        Thread velhaThread = new Thread(() -> {
            System.out.println("Executando em uma nova thread");
        });
        velhaThread.start();

        // Exemplo no Java 10
        Thread novaThread = Thread.ofPlatform().start(() -> {
            System.out.println("Executando em uma nova thread com Java 10");
        });

        // Uso de novos métodos em ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        // Nova funcionalidade para fazer operações atômicas
        map.merge("A", 1, Integer::sum);
    }
}
