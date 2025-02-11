# Exemplos de Funcionalidades do Java 11

## 1. LTS (Long Term Support)

### Antes do Java 11
As versões anteriores do Java não tinham um suporte de longo prazo garantido, levando os desenvolvedores a atualizarem frequentemente para versões mais recentes.

```java
// Não havia um código específico antes do Java 11
// O foco estava em usar versões que não garantiam suporte prolongado
```

### Depois do Java 11
Java 11 é uma versão LTS, oferecendo suporte prolongado e estabilidade, o que facilita a adoção em ambientes de produção.

```java
// Desenvolvedores podem optar por usar Java 11 por ser uma versão LTS
```

## 2. Remoção de Módulos Obsoletos

### Antes do Java 11
Módulos como Java EE e CORBA estavam presentes, mas eram considerados obsoletos e não eram mais recomendados para uso.

```java
// Exemplo de importação de módulos obsoletos
import javax.xml.bind.JAXBContext; // Usado antes do Java 11, mas obsoleto
```

### Depois do Java 11
Esses módulos foram removidos, incentivando o uso de bibliotecas modernas e alternativas.

```java
// Após o Java 11, a importação de módulos obsoletos não é mais possível
// Preferir bibliotecas externas como o Jakarta EE para funcionalidades semelhantes
```

## 3. Novas APIs de String

### Antes do Java 11
As operações de manipulação de strings eram limitadas e exigiam mais código para realizar tarefas comuns.

```java
// Exemplo antes do Java 11
String texto = "   Hello, World!   ";
String resultado = texto.trim(); // Remover espaços em branco
System.out.println(resultado);
```

### Depois do Java 11
Novos métodos foram adicionados à classe `String`, como `isBlank()`, `lines()`, `strip()`, e `repeat()`.

```java
// Exemplo no Java 11
String texto = "   Hello, World!   ";
System.out.println(texto.isBlank()); // Verifica se a string está em branco
System.out.println(texto.strip()); // Remove espaços em branco no início e no fim
System.out.println("Java ".repeat(3)); // Repete a string 3 vezes
```

## 4. HttpClient

### Antes do Java 11
Não havia uma API padrão para realizar requisições HTTP, levando os desenvolvedores a dependerem de bibliotecas externas como Apache HttpClient ou OkHttp.

```java
// Exemplo antes do Java 11 usando Apache HttpClient
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
    HttpGet request = new HttpGet("http://example.com");
    try (CloseableHttpResponse response = httpClient.execute(request)) {
        // Processar resposta
    }
}
```

### Depois do Java 11
Introdução do `HttpClient`, uma API padrão para realizar requisições HTTP.

```java
// Exemplo no Java 11 usando a nova API HttpClient
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("http://example.com"))
        .build();

client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
      .thenApply(HttpResponse::body)
      .thenAccept(System.out::println);
```