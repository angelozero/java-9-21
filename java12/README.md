# Exemplos de Funcionalidades do Java 12

## 1. Switch Expressions (Preview)

### Antes do Java 12
A declaração `switch` era usada apenas para controlar o fluxo de execução e não permitia retornar valores diretamente. Cada caso precisava ser finalizado com `break`.

```java
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
```

### Depois do Java 12
As expressões `switch` foram introduzidas, permitindo retornar valores diretamente e melhorando a legibilidade do código.

```java
// Exemplo no Java 12
String dia = "Sábado";
String tipoDia = switch (dia) {
    case "Sábado":
    case "Domingo":
        yield "Fim de semana"; // 'yield' foi introduzido para retornar um valor
    default:
        yield "Dia de semana";
};

System.out.println(tipoDia);
```

## 2. Aprimoramento do Garbage Collector

### Antes do Java 12
O coletor de lixo G1 estava disponível, mas não tinha a configuração de desempenho que foi introduzida na versão 12.

```java
// Não há um código específico antes do Java 12
// O desenvolvedor confiava nas configurações padrão do G1 GC
```

### Depois do Java 12
Novas opções de configuração foram introduzidas para oferecer melhor desempenho, como a modificação da pausa de coleta.

```bash
# Usando opções do G1 GC na linha de comando
java -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -jar MeuApp.jar
```

## 3. API de String

### Antes do Java 12
A manipulação de strings era limitada e exigia mais código para realizar operações como substring e formatação.

```java
// Exemplo antes do Java 12
String texto = "Exemplo de String";
String parte = texto.substring(0, 7);
System.out.println(parte);
```

### Depois do Java 12
Novos métodos foram adicionados à classe `String`, como `stripIndent()` e `transform()`.

```java
// Exemplo no Java 12
String texto = "   Exemplo de String   ";
String parte = texto.strip(); // Remove espaços em branco no início e no fim
System.out.println(parte); // "Exemplo de String"

String multiline = """
                    Linha 1
                    Linha 2
                    """.stripIndent(); // Remove a indentação
System.out.println(multiline);
```

## 4. Native Memory Tracking

### Antes do Java 12
Não havia uma maneira fácil de rastrear o uso de memória nativa em aplicações Java, dificultando a identificação de problemas de memória.

```java
// Não havia recursos nativos para rastreamento de memória nativa antes do Java 12
```

### Depois do Java 12
Introdução do Native Memory Tracking (NMT), permitindo que os desenvolvedores monitorem o uso de memória nativa.

```bash
# Ativando o Native Memory Tracking
java -XX:NativeMemoryTracking=summary -jar MeuApp.jar
```

```java
// Exemplos de saída do rastreamento de memória nativa
// As informações podem ser obtidas com o comando jcmd
jcmd <pid> VM.native_memory summary
```