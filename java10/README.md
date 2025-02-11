# Exemplos de Funcionalidades do Java 10

## 1. Inferência de Tipo Local

### Antes do Java 10
Era necessário declarar explicitamente o tipo de cada variável, o que poderia resultar em código mais verboso.

```java
// Exemplo antes do Java 10
String nome = "João";
int idade = 30;
List<String> lista = new ArrayList<>();
```

### Depois do Java 10
Com a introdução da palavra-chave `var`, é possível inferir o tipo da variável a partir do valor atribuído, tornando o código mais conciso.

```java
// Exemplo no Java 10
var nome = "João"; // tipo inferido como String
var idade = 30;    // tipo inferido como int
var lista = new ArrayList<String>(); // tipo inferido como List<String>
```

## 2. Aprimoramentos de Performance

### Antes do Java 10
O coletor de lixo G1 (Garbage First) existia, mas não tinha as otimizações que foram introduzidas na versão 10. Em termos de código, não havia mudanças visíveis para o desenvolvedor.

```java
// Não há um código específico antes do Java 10 para coletor de lixo
// O desenvolvedor apenas confiava no comportamento padrão do GC
```

### Depois do Java 10
Com as melhorias no G1 Garbage Collector, o desempenho de aplicações que utilizam este coletor foi otimizado, especialmente para grandes aplicações.

```java
// O desenvolvedor pode ativar o G1 GC com opções na linha de comando
// Não há alteração direta no código, mas é possível notar melhorias de desempenho
java -XX:+UseG1GC -jar MeuApp.jar
```

## 3. API de Concurrency

### Antes do Java 10
A API de `Thread` e `ConcurrentHashMap` tinha funcionalidades básicas, mas sem os novos métodos que foram introduzidos no Java 10.

```java
// Exemplo antes do Java 10
Thread thread = new Thread(() -> {
    System.out.println("Executando em uma nova thread");
});
thread.start();
```

### Depois do Java 10
Novos métodos foram adicionados à API de `Thread`, como `Thread.ofPlatform()` para criar threads de maneira mais flexível.

```java
// Exemplo no Java 10
Thread thread = Thread.ofPlatform().start(() -> {
    System.out.println("Executando em uma nova thread com Java 10");
});

// Uso de novos métodos em ConcurrentHashMap
ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
map.put("A", 1);
map.put("B", 2);

// Nova funcionalidade para fazer operações atômicas
map.merge("A", 1, Integer::sum); // Soma 1 ao valor existente para a chave "A"
```
