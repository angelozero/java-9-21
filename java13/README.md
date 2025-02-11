# Exemplos de Funcionalidades do Java 13

## 1. Text Blocks (Preview)

### Antes do Java 13
As strings multilinha eram criadas usando concatenação ou caracteres de escape, o que tornava o código difícil de ler.

```java
// Exemplo antes do Java 13
String texto = "Esta é uma string\n" +
               "que ocupa várias linhas\n" +
               "e precisa de caracteres de escape.";
System.out.println(texto);
```

### Depois do Java 13
Introdução dos **Text Blocks**, que permitem definir strings multilinha de forma mais simples e legível.

```java
// Exemplo no Java 13
String texto = """
                Esta é uma string
                que ocupa várias linhas
                e não precisa de caracteres de escape.
                """;
System.out.println(texto);
```

## 2. Aprimoramentos no Switch

### Antes do Java 13
As expressões `switch` eram limitadas e não suportavam a nova sintaxe que foi introduzida na versão 12.

```java
// Exemplo antes do Java 13
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

### Depois do Java 13
A sintaxe do `switch` foi aprimorada, permitindo a combinação de casos de uma forma mais limpa, mas ainda como um recurso de preview.

```java
// Exemplo no Java 13
String dia = "Sábado";
String tipoDia = switch (dia) {
    case "Sábado", "Domingo" -> "Fim de semana";
    default -> "Dia de semana";
};

System.out.println(tipoDia);
```

## 3. Melhorias na API de Strings

### Antes do Java 13
A manipulação de strings era básica e não incluía alguns métodos úteis que foram adicionados em versões posteriores.

```java
// Exemplo antes do Java 13
String texto = " Java 13 ";
String resultado = texto.trim(); // Apenas remove espaços no início e no fim
System.out.println(resultado);
```

### Depois do Java 13
Novos métodos foram adicionados à classe `String`, como `strip()` (que também remove espaços em branco) e `isBlank()`.

```java
// Exemplo no Java 13
String texto = " Java 13 ";
System.out.println(texto.strip()); // Remove espaços em branco no início e no fim
System.out.println(texto.isBlank()); // Verifica se a string está vazia ou em branco
```

## 4. Novos Métodos em `Optional`

### Antes do Java 13
A classe `Optional` tinha métodos básicos, mas não incluía algumas funcionalidades que foram introduzidas nas versões mais recentes.

```java
// Exemplo antes do Java 13
Optional<String> optional = Optional.ofNullable(null);
String valor = optional.orElse("Valor padrão");
System.out.println(valor);
```

### Depois do Java 13
Novos métodos foram adicionados à classe `Optional`, como `stream()`.

```java
// Exemplo no Java 13
Optional<String> optional = Optional.ofNullable("Texto");
optional.stream().forEach(System.out::println); // Agora é possível transformar um Optional em um Stream.
```