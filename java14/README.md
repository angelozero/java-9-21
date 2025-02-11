# Exemplos de Funcionalidades do Java 14

## 1. Records (Preview)

### Antes do Java 14
Classes simples que serviam como contêineres de dados precisavam ser escritas com muitos métodos boilerplate, como construtores, `getters`, `equals()`, `hashCode()` e `toString()`.

```java
// Exemplo antes do Java 14
public class Pessoa {
    private final String nome;
    private final int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome='" + nome + '\'' + ", idade=" + idade + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && nome.equals(pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }
}
```

### Depois do Java 14
Com a introdução de **Records**, é possível criar classes de dados de maneira muito mais concisa.

```java
// Exemplo no Java 14
public record Pessoa(String nome, int idade) {}

// Uso do Record
Pessoa pessoa = new Pessoa("João", 30);
System.out.println(pessoa); // Chama automaticamente toString()
```

## 2. Pattern Matching para `instanceof` (Preview)

### Antes do Java 14
A verificação de tipo com `instanceof` era feita de forma tradicional, exigindo um casting após a verificação.

```java
// Exemplo antes do Java 14
Object obj = "Uma string";
if (obj instanceof String) {
    String str = (String) obj; // Necessário fazer o cast
    System.out.println(str.toUpperCase());
}
```

### Depois do Java 14
Introdução do **Pattern Matching**, que simplifica a verificação de tipo e o casting.

```java
// Exemplo no Java 14
Object obj = "Uma string";
if (obj instanceof String str) { // Casting automático
    System.out.println(str.toUpperCase());
}
```

## 3. Melhorias na API de Strings

### Antes do Java 14
A API de strings tinha funcionalidades básicas, mas não incluía métodos para manipulação mais avançada.

```java
// Exemplo antes do Java 14
String texto = "  Java 14  ";
String resultado = texto.trim(); // Apenas remove espaços no início e no fim
System.out.println(resultado);
```

### Depois do Java 14
Novos métodos foram adicionados para melhorar a manipulação de strings, como `formatted()`.

```java
// Exemplo no Java 14
String nome = "João";
int idade = 30;
String resultado = "Nome: %s, Idade: %d".formatted(nome, idade); // Formatação de strings
System.out.println(resultado);
```

## 4. NPE (NullPointerException) com Melhores Mensagens

### Antes do Java 14
Quando ocorria uma `NullPointerException`, a mensagem era genérica e muitas vezes não ajudava a identificar a causa do problema.

```java
// Exemplo antes do Java 14
String texto = null;
System.out.println(texto.length()); // Gera NullPointerException sem informações úteis
```

### Depois do Java 14
Mensagens de `NullPointerException` foram aprimoradas para fornecer informações mais úteis sobre a causa do erro.

```java
// Exemplo no Java 14
String texto = null;
try {
    System.out.println(texto.length());
} catch (NullPointerException e) {
    e.printStackTrace(); // Mensagem mais informativa sobre a origem do NPE
}
```