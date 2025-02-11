# Exemplos de Funcionalidades do Java 21

## 1. Pattern Matching para `switch` (Funcionalidade Estável)

### Antes do Java 21
O **Pattern Matching para `switch`** foi introduzido como uma funcionalidade preview no Java 19 e refinado no Java 20. Contudo, ainda estava em fase de testes e não era uma funcionalidade estável.

```java
// Exemplo antes do Java 21 (Java 20)
Object obj = "Sábado";
String tipoDia = switch (obj) {
    case String dia && (dia.equals("Sábado") || dia.equals("Domingo")) -> "Fim de semana";
    case String dia -> "Dia de semana";
    default -> "Não é um dia válido";
};

System.out.println(tipoDia);
```

### Depois do Java 21
O **Pattern Matching para `switch`** se tornou uma funcionalidade estável, permitindo uma sintaxe clara e a combinação de padrões.

```java
// Exemplo no Java 21
Object obj = "Sábado";
String tipoDia = switch (obj) {
    case String dia && (dia.equals("Sábado") || dia.equals("Domingo")) -> "Fim de semana";
    case String dia -> "Dia de semana";
    default -> "Não é um dia válido";
};

System.out.println(tipoDia);
```

## 2. Aprimoramentos na API de Strings

### Antes do Java 21
A manipulação de strings já tinha recebido algumas melhorias, mas ainda havia espaço para novos métodos e funcionalidades.

```java
// Exemplo antes do Java 21
String texto = "Java 21";
String resultado = texto.toUpperCase(); // Apenas converte para maiúsculas
System.out.println(resultado);
```

### Depois do Java 21
Novos métodos e melhorias foram introduzidos na classe `String`, como `String::toFormat()` ou outros métodos úteis que tornam a manipulação de strings mais intuitiva.

```java
// Exemplo no Java 21
String texto = "Java 21";
// Usando um novo método de formatação
String resultado = String.format("A versão é: %s", texto);
System.out.println(resultado);
```

## 3. Novas Funcionalidades em `Foreign Function & Memory`

### Antes do Java 21
O **Foreign Function & Memory API** estava em incubação e apresentava funcionalidades básicas para interação com código nativo.

```java
// Exemplo antes do Java 21
import jdk.incubator.foreign.*;

MemorySegment segment = MemorySegment.allocateNative(100);
```

### Depois do Java 21
O API foi aprimorado e se tornou mais robusto, facilitando a interação com código nativo e o gerenciamento de memória.

```java
// Exemplo no Java 21
import jdk.incubator.foreign.*;

MemorySegment segment = MemorySegment.allocateNative(100);
// Mais melhorias na API para manipulação de memória
```

## 4. Melhorias em `NullPointerException`

### Antes do Java 21
As mensagens de `NullPointerException` eram informativas, mas ainda havia espaço para melhorias.

```java
// Exemplo antes do Java 21
String texto = null;
try {
    System.out.println(texto.length());
} catch (NullPointerException e) {
    System.out.println("NPE: " + e.getMessage()); // Mensagem informativa
}
```

### Depois do Java 21
As mensagens de `NullPointerException` foram aprimoradas para fornecer informações ainda mais específicas sobre a causa do erro.

```java
// Exemplo no Java 21
String texto = null;
try {
    System.out.println(texto.length());
} catch (NullPointerException e) {
    System.out.println("NullPointerException: " + e.getLocalizedMessage());
}
```

## 5. Novas Funcionalidades em `JEP 426: "Consolidate the ZGC" (Garbage Collector)`

### Antes do Java 21
O Z Garbage Collector (ZGC) estava disponível, mas sua configuração e uso eram limitados.

```bash
# Exemplo antes do Java 21
java -XX:+UseZGC -jar MeuApp.jar
```

### Depois do Java 21
O ZGC foi aprimorado e agora é mais fácil de usar, com melhorias significativas em desempenho e eficiência.

```bash
# Exemplo no Java 21
java -XX:+UseZGC -XX:MaxGCPauseMillis=50 -jar MeuApp.jar
```

## 6. `jpackage` Melhorado

### Antes do Java 21
O comando `jpackage` já estava disponível, mas suas funcionalidades estavam em desenvolvimento.

```bash
# Exemplo antes do Java 21
jpackage --input diretorio-de-entrada --name MeuApp --main-jar meuapp.jar
```

### Depois do Java 21
O comando `jpackage` foi aprimorado, oferecendo mais opções e flexibilidade na criação de instaladores nativos.

```bash
# Exemplo no Java 21
jpackage --input diretorio-de-entrada --name MeuApp --main-jar meuapp.jar --type app-image --icon meuapp.ico
```