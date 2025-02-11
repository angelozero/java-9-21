# Exemplos de Funcionalidades do Java 16

## 1. Records

### Antes do Java 16
Classes que serviam como contêineres de dados exigiam a implementação de muitos métodos boilerplate, como construtores, `getters`, `equals()`, `hashCode()` e `toString()`.

```java
// Exemplo antes do Java 16
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

### Depois do Java 16
Com a introdução de **Records**, é possível criar classes de dados de maneira muito mais concisa.

```java
// Exemplo no Java 16
public record Pessoa(String nome, int idade) {}

// Uso do Record
Pessoa pessoa = new Pessoa("João", 30);
System.out.println(pessoa); // Chama automaticamente toString()
```

## 2. Pattern Matching para `instanceof`

### Antes do Java 16
A verificação de tipo com `instanceof` era feita de forma tradicional, exigindo um casting após a verificação.

```java
// Exemplo antes do Java 16
Object obj = "Uma string";
if (obj instanceof String) {
    String str = (String) obj; // Necessário fazer o cast
    System.out.println(str.toUpperCase());
}
```

### Depois do Java 16
Introdução do **Pattern Matching**, que simplifica a verificação de tipo e o casting.

```java
// Exemplo no Java 16
Object obj = "Uma string";
if (obj instanceof String str) { // Casting automático
    System.out.println(str.toUpperCase());
}
```

## 3. JEP 338: JPackage

### Antes do Java 16
Não havia uma maneira padronizada para empacotar aplicações Java em formatos específicos de sistema operacional.

```java
// Não havia um código específico antes do Java 16
// O empacotamento normalmente envolvia ferramentas de terceiros ou scripts
```

### Depois do Java 16
Introdução do **JPackage**, que permite criar instaladores nativos para aplicações Java.

```bash
# Exemplo de uso do JPackage (linha de comando)
jpackage --input diretorio-de-entrada --name MeuApp --main-jar meuapp.jar
```

## 4. Melhorias na API de Strings

### Antes do Java 16
A manipulação de strings era básica e não incluía alguns métodos para manipulação mais avançada.

```java
// Exemplo antes do Java 16
String texto = "Java 16";
String resultado = texto.toUpperCase(); // Convertendo para maiúsculas
System.out.println(resultado);
```

### Depois do Java 16
Novos métodos foram adicionados, como `String::toList()`, que converte uma string em uma lista de caracteres.

```java
// Exemplo no Java 16
String texto = "Java 16";
List<Character> lista = texto.chars()
    .mapToObj(c -> (char) c)
    .collect(Collectors.toList());

System.out.println(lista); // Imprime a lista de caracteres
```

## 5. NPE (NullPointerException) com Mensagens Aprimoradas

### Antes do Java 16
Quando ocorria uma `NullPointerException`, a mensagem era genérica e muitas vezes não ajudava a identificar a causa do problema.

```java
// Exemplo antes do Java 16
String texto = null;
System.out.println(texto.length()); // Gera NullPointerException sem informações úteis
```

### Depois do Java 16
As mensagens de `NullPointerException` foram aprimoradas para fornecer informações mais úteis sobre a causa do erro.

```java
// Exemplo no Java 16
String texto = null;
try {
    System.out.println(texto.length());
} catch (NullPointerException e) {
    e.printStackTrace(); // Mensagem mais informativa sobre a origem do NPE
}
```