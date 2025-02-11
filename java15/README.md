# Exemplos de Funcionalidades do Java 15

## 1. Sealed Classes (Preview)

### Antes do Java 15
As classes eram abertas por padrão, permitindo que qualquer outra classe as estendesse. Isso dificultava o controle sobre a hierarquia de classes.

```java
// Exemplo antes do Java 15
class Animal {}
class Cachorro extends Animal {}
class Gato extends Animal {}
```

### Depois do Java 15
Introdução das **Sealed Classes**, que permitem controlar quais classes podem estender uma classe base.

```java
// Exemplo no Java 15
sealed class Animal permits Cachorro, Gato {}

final class Cachorro extends Animal {}
final class Gato extends Animal {}
```

## 2. Text Blocks

### Antes do Java 15
Os **Text Blocks** foram introduzidos como um recurso de preview no Java 13 e se tornaram oficiais no Java 14, mas sua utilização continuou a ser aprimorada.

```java
// Exemplo antes do Java 15
String texto = """
                Linha 1
                Linha 2
                """;
```

### Depois do Java 15
Text Blocks se tornaram uma funcionalidade estável e com melhorias nas regras de formatação.

```java
// Exemplo no Java 15
String texto = """
                Linha 1
                Linha 2
                """;

System.out.println(texto.stripIndent()); // Agora você pode usar stripIndent() para remover a indentação
```

## 3. Melhorias na API de `Optional`

### Antes do Java 15
A classe `Optional` tinha métodos básicos, mas não incluía algumas funcionalidades úteis para manipulação de valores.

```java
// Exemplo antes do Java 15
Optional<String> optional = Optional.ofNullable("Texto");
String valor = optional.orElse("Valor padrão");
System.out.println(valor);
```

### Depois do Java 15
Novos métodos foram adicionados, como `stream()` e `ifPresentOrElse()`.

```java
// Exemplo no Java 15
Optional<String> optional = Optional.ofNullable("Texto");

// Usando ifPresentOrElse
optional.ifPresentOrElse(
    valor -> System.out.println("Valor presente: " + valor),
    () -> System.out.println("Valor não presente")
);

// Usando stream()
optional.stream().forEach(System.out::println);
```

## 4. Novas Funcionalidades em `Switch`

### Antes do Java 15
O **Switch** foi aprimorado no Java 12 e 13, mas ainda estava em fase de preview.

```java
// Exemplo antes do Java 15
String dia = "Sábado";
String tipoDia = switch (dia) {
    case "Sábado", "Domingo" -> "Fim de semana";
    default -> "Dia de semana";
};

System.out.println(tipoDia);
```

### Depois do Java 15
As melhorias no `switch` foram consolidadas, tornando-se uma funcionalidade estável e com melhor suporte para expressões.

```java
// Exemplo no Java 15
String dia = "Sábado";
String tipoDia = switch (dia) {
    case "Sábado", "Domingo" -> "Fim de semana";
    default -> "Dia de semana";
};

System.out.println(tipoDia);
```

## 5. `NullPointerException` com Mensagens Aprimoradas

### Antes do Java 15
Quando ocorria uma `NullPointerException`, a mensagem era genérica e muitas vezes não ajudava a identificar a causa do problema.

```java
// Exemplo antes do Java 15
String texto = null;
System.out.println(texto.length()); // Gera NullPointerException sem informações úteis
```

### Depois do Java 15
As mensagens de `NullPointerException` foram aprimoradas para fornecer informações mais úteis sobre a causa do erro.

```java
// Exemplo no Java 15
String texto = null;
try {
    System.out.println(texto.length());
} catch (NullPointerException e) {
    e.printStackTrace(); // Mensagem mais informativa sobre a origem do NPE
}
```