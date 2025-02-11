# Exemplos de Funcionalidades do Java 19

## 1. Pattern Matching para `switch` (Preview)

### Antes do Java 19
As expressões `switch` permitiam apenas a comparação de valores, mas não suportavam correspondência de padrões, resultando em código mais complexo quando se tratava de diferentes tipos.

```java
// Exemplo antes do Java 19
Object obj = "Sábado";
String tipoDia;

switch (obj.getClass().getSimpleName()) {
    case "String":
        String dia = (String) obj;
        tipoDia = (dia.equals("Sábado") || dia.equals("Domingo")) ? "Fim de semana" : "Dia de semana";
        break;
    default:
        tipoDia = "Não é um dia válido";
}

System.out.println(tipoDia);
```

### Depois do Java 19
Com a introdução do **Pattern Matching para `switch`**, agora é possível simplificar a correspondência de padrões diretamente nas expressões `switch`.
No trecho `case String dia when ...` , o when permite adicionar uma condição para a correspondência do padrão. Isso permite que você verifique se o dia é "Sábado" ou "Domingo".

```java
// Exemplo no Java 19
Object obj = "Sábado";
String tipoDia = switch (obj) {
    case String dia when dia.equals("Sábado") || dia.equals("Domingo") -> "Fim de semana";
    case String dia -> "Dia de semana";
    default -> "Não é um dia válido";
};

System.out.println(tipoDia);
```

## 2. Novos Métodos na API de Strings

### Antes do Java 19
A manipulação de strings era limitada a métodos básicos, sem suporte a operações mais complexas.

```java
// Exemplo antes do Java 19
String texto = "Java 19";
String resultado = texto.toUpperCase(); // Apenas converte para maiúsculas
System.out.println(resultado);
```

### Depois do Java 19
Novos métodos foram adicionados à classe `String`, incluindo a capacidade de transformar strings de forma mais funcional.

```java
// Exemplo no Java 19
String texto = "Java 19";
String resultado = texto.transform(String::toUpperCase); // Usando transform para conversão
System.out.println(resultado);
```

## 3. Aprimoramentos na API de `Foreign Function & Memory`

### Antes do Java 19
A interação com código nativo e gerenciamento de memória fora do heap era feita via JNI (Java Native Interface), que não era a maneira mais intuitiva.

```java
// Exemplo antes do Java 19
// A interação com código nativo era complexa e não tão segura
```

### Depois do Java 19
O **Foreign Function & Memory API** foi aprimorado, facilitando a chamada de funções nativas e o gerenciamento de memória.

```java
// Exemplo de uso básico (ainda em incubação)
import jdk.incubator.foreign.*;

MemorySegment segment = MemorySegment.allocateNative(100);
// Interagir com a memória nativa
```

## 4. Novo Comando `jpackage`

### Antes do Java 19
Empacotar aplicações Java em instaladores nativos era feito através de ferramentas externas ou scripts personalizados.

```bash
# Não havia um comando padrão para empacotamento antes do Java 19
```

### Depois do Java 19
O comando `jpackage` foi aprimorado, permitindo criar instaladores nativos de forma mais simples e direta.

```bash
# Exemplo de uso do jpackage (linha de comando)
jpackage --input diretorio-de-entrada --name MeuApp --main-jar meuapp.jar --type app-image
```

## 5. Novas Funcionalidades em `NullPointerException`

### Antes do Java 19
As mensagens de `NullPointerException` eram genéricas e não ajudavam a identificar a origem do problema.

```java
// Exemplo antes do Java 19
String texto = null;
System.out.println(texto.length()); // Gera NullPointerException sem informações úteis
```

### Depois do Java 19
As mensagens de `NullPointerException` foram aprimoradas para fornecer informações mais úteis sobre a causa do erro.

```java
// Exemplo no Java 19
String texto = null;
try {
    System.out.println(texto.length());
} catch (NullPointerException e) {
    System.out.println("NPE: " + e.getMessage()); // Mensagem mais informativa sobre a origem do NPE
}
```