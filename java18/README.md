# Exemplos de Funcionalidades do Java 18

## 1. API de UTF-8

### Antes do Java 18
Não havia suporte nativo para codificação UTF-8 nas APIs de entrada e saída, e os desenvolvedores frequentemente precisavam especificar a codificação manualmente ao ler ou escrever arquivos.

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

// Exemplo antes do Java 18
String conteúdo = new String(Files.readAllBytes(Paths.get("arquivo.txt")), "ISO-8859-1");
System.out.println(conteúdo);
```

### Depois do Java 18
O Java 18 introduziu uma API que permite que os desenvolvedores especifiquem diretamente a codificação UTF-8 sem a necessidade de conversões manuais.

```java
import java.nio.file.Files;
import java.nio.file.Paths;

// Exemplo no Java 18
String conteúdo = Files.readString(Paths.get("arquivo.txt"), StandardCharsets.UTF_8);
System.out.println(conteúdo);
```

## 2. Novos Métodos na API de Strings

### Antes do Java 18
A manipulação de strings era limitada e não incluía algumas funcionalidades úteis que foram introduzidas nas versões mais recentes.

```java
// Exemplo antes do Java 18
String texto = "Java 18";
String resultado = texto.toUpperCase(); // Apenas converte para maiúsculas
System.out.println(resultado);
```

### Depois do Java 18
Novos métodos foram adicionados à classe `String`, como `String::toPattern()` para conversão de strings em padrões.

```java
// Exemplo no Java 18
String texto = "Java 18";
String resultado = texto.transform(String::toUpperCase); // Usando transform para conversão
System.out.println(resultado);
```

## 3. `Switch` Aprimorado

### Antes do Java 18
As expressões `switch` já tinham recebido melhorias nas versões anteriores, mas a capacidade de misturar expressões e comandos ainda era limitada.

```java
// Exemplo antes do Java 18
String dia = "Sábado";
String tipoDia;

switch (dia) {
    case "Sábado", "Domingo":
        tipoDia = "Fim de semana";
        break;
    default:
        tipoDia = "Dia de semana";
}

System.out.println(tipoDia);
```

### Depois do Java 18
A sintaxe do `switch` foi aprimorada, permitindo uma melhor combinação de expressões e comandos.

```java
// Exemplo no Java 18
String dia = "Sábado";
String tipoDia = switch (dia) {
    case "Sábado", "Domingo" -> "Fim de semana"; // Sintaxe simplificada
    default -> "Dia de semana";
};

System.out.println(tipoDia);
```

## 4. Aprimoramentos na API de `Pattern Matching`

### Antes do Java 18
O **Pattern Matching** para `instanceof` foi introduzido no Java 17, mas as funcionalidades eram limitadas.

```java
// Exemplo antes do Java 18
Object obj = "Uma string";
if (obj instanceof String) {
    String str = (String) obj; // Necessário fazer o cast
    System.out.println(str.toUpperCase());
}
```

### Depois do Java 18
O **Pattern Matching** foi aprimorado, possibilitando uma verificação mais robusta e fácil.

```java
// Exemplo no Java 18
Object obj = "Uma string";
if (obj instanceof String str) { // Casting automático
    System.out.println(str.toUpperCase());
}
```

## 5. `NullPointerException` com Mensagens Aprimoradas

### Antes do Java 18
Quando ocorria uma `NullPointerException`, a mensagem era genérica e muitas vezes não ajudava a identificar a causa do problema.

```java
// Exemplo antes do Java 18
String texto = null;
System.out.println(texto.length()); // Gera NullPointerException sem informações úteis
```

### Depois do Java 18
As mensagens de `NullPointerException` foram aprimoradas para fornecer informações mais úteis sobre a causa do erro.

```java
// Exemplo no Java 18
String texto = null;
try {
    System.out.println(texto.length());
} catch (NullPointerException e) {
    System.out.println("NPE: " + e.getMessage()); // Mensagem mais informativa sobre a origem do NPE
}
```