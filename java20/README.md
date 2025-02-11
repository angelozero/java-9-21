# Exemplos de Funcionalidades do Java 20

## 1. Pattern Matching para `switch` (Preview)

### Antes do Java 20
No Java 19, o **Pattern Matching para `switch`** foi introduzido como preview, mas não estava completamente refinado. O uso de condições dentro do `switch` não era suportado de forma clara.

```java
// Exemplo antes do Java 20 (Java 19)
Object obj = "Sábado";
String tipoDia = switch (obj) {
    case String dia when dia.equals("Sábado") || dia.equals("Domingo") -> "Fim de semana";
    case String dia -> "Dia de semana";
    default -> "Não é um dia válido";
};

System.out.println(tipoDia);
```

### Depois do Java 20
Com o Java 20, o **Pattern Matching para `switch`** foi aprimorado, permitindo uma sintaxe mais clara e a combinação de padrões.

```java
// Exemplo no Java 20
Object obj = "Sábado";
String tipoDia = switch (obj) {
    case String dia when dia.equals("Sábado") || dia.equals("Domingo") -> "Fim de semana";
    case String dia -> "Dia de semana";
    default -> "Não é um dia válido";
};

System.out.println(tipoDia);
```

## 2. Aprimoramentos na API de Strings

### Antes do Java 20
A manipulação de strings tinha métodos úteis, mas não incluía algumas novas funcionalidades que foram adicionadas.

```java
// Exemplo antes do Java 20
String texto = "Java 20";
String resultado = texto.toUpperCase(); // Apenas converte para maiúsculas
System.out.println(resultado);
```

### Depois do Java 20
Novos métodos foram adicionados à classe `String`, como `String::toFormat()`.

```java
// Exemplo no Java 20
String texto = "Java 20";
// Usando um novo método de formatação
String resultado = String.format("A versão é: %s", texto);
System.out.println(resultado);
```

## 3. Aprimoramentos na API de `Foreign Function & Memory`

### Antes do Java 20
O **Foreign Function & Memory API** estava em incubação e apresentava funcionalidades básicas.

```java
// Exemplo antes do Java 20
import jdk.incubator.foreign.*;

MemorySegment segment = MemorySegment.allocateNative(100);
```

### Depois do Java 20
O API foi aprimorado, facilitando a interação com código nativo e o gerenciamento de memória.

```java
// Exemplo no Java 20
import jdk.incubator.foreign.*;

MemorySegment segment = MemorySegment.allocateNative(100);
// Mais melhorias na API para manipulação de memória
```

## 4. Novos Recursos em `NullPointerException`

### Antes do Java 20
As mensagens de `NullPointerException` eram melhores, mas ainda podiam ser melhoradas.

```java
// Exemplo antes do Java 20
String texto = null;
try {
    System.out.println(texto.length());
} catch (NullPointerException e) {
    System.out.println("NPE: " + e.getMessage()); // Mensagem informativa
}
```

### Depois do Java 20
As mensagens de `NullPointerException` foram ainda mais aprimoradas para fornecer informações mais específicas sobre a causa do erro.

```java
// Exemplo no Java 20
String texto = null;
try {
    System.out.println(texto.length());
} catch (NullPointerException e) {
    System.out.println("NullPointerException: " + e.getLocalizedMessage());
}
```

## 5. Novo Comando `jpackage`

### Antes do Java 20
O comando `jpackage` foi introduzido no Java 14, mas estava em constante aprimoramento.

```bash
# Exemplo antes do Java 20
jpackage --input diretorio-de-entrada --name MeuApp --main-jar meuapp.jar
```

### Depois do Java 20
O comando foi aprimorado, permitindo mais opções e flexibilidade na criação de instaladores nativos.

```bash
# Exemplo no Java 20
jpackage --input diretorio-de-entrada --name MeuApp --main-jar meuapp.jar --type app-image --icon meuapp.ico
```