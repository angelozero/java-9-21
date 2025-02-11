# Exemplos de Funcionalidades do Java 9

## 1. Módulos do Java (Project Jigsaw)

### Antes do Java 9
Não havia suporte a módulos. O código era organizado em pacotes, mas não havia encapsulamento em nível de módulo.

```java
// Exemplo de organização de pacotes antes do Java 9
package com.exemplo;

public class MinhaClasse {
    public void metodo() {
        System.out.println("Método da MinhaClasse");
    }
}
```

### Depois do Java 9
Com a introdução dos módulos, o código pode ser organizado em módulos, permitindo um melhor encapsulamento e gerenciamento de dependências.

```java
// Exemplo de definição de um módulo no Java 9
module com.exemplo {
    exports com.exemplo;
}
```

## 2. JShell

### Antes do Java 9
Não havia uma ferramenta interativa para execução de código Java. O desenvolvedor precisava compilar e executar via linha de comando ou IDE.

```bash
# Compilação e execução de um arquivo Java
javac MeuPrograma.java
java MeuPrograma
```

### Depois do Java 9
Introdução do JShell, uma ferramenta interativa para execução de código Java em tempo real.

```bash
# Iniciando o JShell
jshell
```

```java
// Executando código diretamente no JShell
jshell> System.out.println("Olá, JShell!");
Olá, JShell!
```

## 3. API de Fluxo Reativo

### Antes do Java 9
Não havia suporte nativo para programação reativa. Os desenvolvedores precisavam usar bibliotecas externas como RxJava.

```java
// Exemplo de programação imperativa
List<String> lista = Arrays.asList("A", "B", "C");
for (String s : lista) {
    System.out.println(s);
}
```

### Depois do Java 9
Introdução da API para programação reativa, facilitando a manipulação de fluxos de dados assíncronos.

```java
import java.util.List;
import java.util.stream.Stream;

// Usando a API reativa
Stream<String> stream = Stream.of("A", "B", "C");
stream.forEach(System.out::println);
```

## 4. Melhorias na API de Coleções

### Antes do Java 9
As coleções imutáveis eram criadas manualmente, o que demandava mais código e complexidade.

```java
// Criando uma lista imutável antes do Java 9
List<String> listaImutavel = Collections.unmodifiableList(new ArrayList<>(Arrays.asList("A", "B", "C")));
```

### Depois do Java 9
Novos métodos foram introduzidos para criação de coleções imutáveis de forma mais simples.

```java
// Criando uma lista imutável no Java 9
List<String> listaImutavel = List.of("A", "B", "C");
```

```java
// Criando um conjunto imutável no Java 9
Set<String> conjuntoImutavel = Set.of("A", "B", "C");

// Criando um mapa imutável no Java 9
Map<String, Integer> mapaImutavel = Map.of("A", 1, "B", 2, "C", 3);
```