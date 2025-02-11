# Exemplos de Funcionalidades do Java 17

## 1. Sealed Classes

### Antes do Java 17
As classes eram abertas por padrão, permitindo que qualquer outra classe as estendesse. Isso dificultava o controle sobre a hierarquia de classes.

```java
// Exemplo antes do Java 17
class Animal {}
class Cachorro extends Animal {}
class Gato extends Animal {}
```

### Depois do Java 17
Introdução das **Sealed Classes**, que permitem controlar quais classes podem estender uma classe base.

```java
// Exemplo no Java 17
sealed class Animal permits Cachorro, Gato {}

final class Cachorro extends Animal {}
final class Gato extends Animal {}
```

## 2. Non-Sealed Classes

### Introdução no Java 17
As **Non-Sealed Classes** permitem que subclasses de uma classe **sealed** sejam definidas como **non-sealed**, permitindo herança livre a partir dessas subclasses.

```java
// Exemplo no Java 17
sealed class Animal permits Cachorro, Gato {}

final class Cachorro extends Animal {}

non-sealed class Gato extends Animal { // Gato é uma classe non-sealed
}

class GatoPersa extends Gato { // GatoPersa pode estender Gato
    // Sem restrições adicionais
}
```

## 3. Pattern Matching para `instanceof`

### Antes do Java 17
A verificação de tipo com `instanceof` exigia um casting após a verificação, resultando em código mais verboso.

```java
// Exemplo antes do Java 17
Object obj = "Uma string";
if (obj instanceof String) {
    String str = (String) obj; // Necessário fazer o cast
    System.out.println(str.toUpperCase());
}
```

### Depois do Java 17
A funcionalidade de **Pattern Matching** para `instanceof` se tornou oficial, simplificando a verificação de tipo e o casting.

```java
// Exemplo no Java 17
Object obj = "Uma string";
if (obj instanceof String str) { // Casting automático
    System.out.println(str.toUpperCase());
}
```

## 4. JEP 411: Foreign Function & Memory API (Incubating)

### Antes do Java 17
Não havia uma maneira padronizada e segura para interagir com código nativo ou gerenciar memória fora do heap.

```java
// Não havia um código específico antes do Java 17
// O acesso a código nativo normalmente era feito via JNI (Java Native Interface)
```

### Depois do Java 17
Introdução do **Foreign Function & Memory API** (em incubação), que facilita a chamada de funções nativas e o gerenciamento de memória.

```java
// Exemplo de uso básico (ainda em incubação)
import jdk.incubator.foreign.*;

MemorySegment segment = MemorySegment.allocateNative(100);
```

## 5. Novidades em `String` e `Switch`

### Antes do Java 17
Em versões anteriores, os métodos da classe `String` eram limitados e a sintaxe do `switch` não permitia expressões de maneira tão ampla.

```java
// Exemplo antes do Java 17
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

### Depois do Java 17
Novos métodos foram adicionados à classe `String`, como `String::toUpperCase(Locale)`.

```java
// Exemplo no Java 17
String dia = "Sábado";
String tipoDia = switch (dia) {
    case "Sábado", "Domingo" -> "Fim de semana"; // Sintaxe simplificada
    default -> "Dia de semana";
};

System.out.println(tipoDia);

// Uso de métodos de String
String texto = "Java 17";
System.out.println(texto.toUpperCase()); // Converte para maiúsculas
```

## 6. NullPointerException com Mensagens Aprimoradas

### Antes do Java 17
Quando ocorria uma `NullPointerException`, a mensagem era genérica e muitas vezes não ajudava a identificar a causa do problema.

```java
// Exemplo antes do Java 17
String texto = null;
System.out.println(texto.length()); // Gera NullPointerException sem informações úteis
```

### Depois do Java 17
As mensagens de `NullPointerException` foram aprimoradas para fornecer informações mais úteis sobre a causa do erro.

```java
// Exemplo no Java 17
String texto = null;
try {
    System.out.println(texto.length());
} catch (NullPointerException e) {
    System.out.println("NPE: " + e.getMessage()); // Mensagem mais informativa sobre a origem do NPE
}
```