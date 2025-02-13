# Turbopuffer Java API Library

[![Maven Central](https://img.shields.io/maven-central/v/com.turbopuffer.api/turbopuffer-java)](https://central.sonatype.com/artifact/com.turbopuffer.api/turbopuffer-java/0.0.1-alpha.0)

The Turbopuffer Java SDK provides convenient access to the Turbopuffer REST API from applications written in Java.

It is generated with [Stainless](https://www.stainlessapi.com/).

The REST API documentation can be found on [docs.turbopuffer.com](https://docs.turbopuffer.com).

## Installation

### Gradle

```kotlin
implementation("com.turbopuffer.api:turbopuffer-java:0.0.1-alpha.0")
```

### Maven

```xml
<dependency>
    <groupId>com.turbopuffer.api</groupId>
    <artifactId>turbopuffer-java</artifactId>
    <version>0.0.1-alpha.0</version>
</dependency>
```

## Requirements

This library requires Java 8 or later.

## Usage

### Configure the client

Use `TurbopufferOkHttpClient.builder()` to configure the client. At a minimum you need to set `.bearerToken()`:

```java
import com.turbopuffer.api.client.TurbopufferClient;
import com.turbopuffer.api.client.okhttp.TurbopufferOkHttpClient;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .bearerToken("My Bearer Token")
    .build();
```

Alternately, set the environment with `BEARER_TOKEN`, and use `TurbopufferOkHttpClient.fromEnv()` to read from the environment.

```java
import com.turbopuffer.api.client.TurbopufferClient;
import com.turbopuffer.api.client.okhttp.TurbopufferOkHttpClient;

TurbopufferClient client = TurbopufferOkHttpClient.fromEnv();

// Note: you can also call fromEnv() from the client builder, for example if you need to set additional properties
TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .fromEnv()
    // ... set properties on the builder
    .build();
```

| Property    | Environment variable | Required | Default value |
| ----------- | -------------------- | -------- | ------------- |
| bearerToken | `BEARER_TOKEN`       | true     | —             |

Read the documentation for more configuration options.

---

### Example: creating a resource

To create a new namespace, first use the `NamespaceListParams` builder to specify attributes, then pass that to the `list` method of the `namespaces` service.

```java
import com.turbopuffer.api.models;
import com.turbopuffer.api.models.NamespaceListParams;

NamespaceListParams params = NamespaceListParams.builder().build();
List<UnnamedSchemaWithArrayParent0> namespaces = client.namespaces().list(params);
```

---

## Requests

### Parameters and bodies

To make a request to the Turbopuffer API, you generally build an instance of the appropriate `Params` class.

See [Undocumented request params](#undocumented-request-params) for how to send arbitrary parameters.

## Responses

### Response validation

When receiving a response, the Turbopuffer Java SDK will deserialize it into instances of the typed model classes. In rare cases, the API may return a response property that doesn't match the expected Java type. If you directly access the mistaken property, the SDK will throw an unchecked `TurbopufferInvalidDataException` at runtime. If you would prefer to check in advance that that response is completely well-typed, call `.validate()` on the returned model.

```java
import com.turbopuffer.api.models;

List<UnnamedSchemaWithArrayParent0> namespaces = client.namespaces().list().validate();
```

### Response properties as JSON

In rare cases, you may want to access the underlying JSON value for a response property rather than using the typed version provided by this SDK. Each model property has a corresponding JSON version, with an underscore before the method name, which returns a `JsonField` value.

```java
import com.turbopuffer.api.core.JsonField;
import java.util.Optional;

JsonField field = responseObj._field();

if (field.isMissing()) {
  // Value was not specified in the JSON response
} else if (field.isNull()) {
  // Value was provided as a literal null
} else {
  // See if value was provided as a string
  Optional<String> jsonString = field.asString();

  // If the value given by the API did not match the shape that the SDK expects
  // you can deserialise into a custom type
  MyClass myObj = responseObj._field().asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Additional model properties

Sometimes, the server response may include additional properties that are not yet available in this library's types. You can access them using the model's `_additionalProperties` method:

```java
import com.turbopuffer.api.core.JsonValue;

JsonValue secret = namespaceRetrieveResponse._additionalProperties().get("secret_field");
```

---

---

## Error handling

This library throws exceptions in a single hierarchy for easy handling:

- **`TurbopufferException`** - Base exception for all exceptions

- **`TurbopufferServiceException`** - HTTP errors with a well-formed response body we were able to parse. The exception message and the `.debuggingRequestId()` will be set by the server.

  | 400    | BadRequestException           |
  | ------ | ----------------------------- |
  | 401    | AuthenticationException       |
  | 403    | PermissionDeniedException     |
  | 404    | NotFoundException             |
  | 422    | UnprocessableEntityException  |
  | 429    | RateLimitException            |
  | 5xx    | InternalServerException       |
  | others | UnexpectedStatusCodeException |

- **`TurbopufferIoException`** - I/O networking errors
- **`TurbopufferInvalidDataException`** - any other exceptions on the client side, e.g.:
  - We failed to serialize the request body
  - We failed to parse the response body (has access to response code and body)

## Network options

### Retries

Requests that experience certain errors are automatically retried 2 times by default, with a short exponential backoff. Connection errors (for example, due to a network connectivity problem), 408 Request Timeout, 409 Conflict, 429 Rate Limit, and >=500 Internal errors will all be retried by default. You can provide a `maxRetries` on the client builder to configure this:

```java
import com.turbopuffer.api.client.TurbopufferClient;
import com.turbopuffer.api.client.okhttp.TurbopufferOkHttpClient;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default. You can configure this on the client builder:

```java
import com.turbopuffer.api.client.TurbopufferClient;
import com.turbopuffer.api.client.okhttp.TurbopufferOkHttpClient;
import java.time.Duration;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

Requests can be routed through a proxy. You can configure this on the client builder:

```java
import com.turbopuffer.api.client.TurbopufferClient;
import com.turbopuffer.api.client.okhttp.TurbopufferOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("example.com", 8080)))
    .build();
```

## Making custom/undocumented requests

This library is typed for convenient access to the documented API. If you need to access undocumented params or response properties, the library can still be used.

### Undocumented request params

In [Example: creating a resource](#example-creating-a-resource) above, we used the `NamespaceListParams.builder()` to pass to the `list` method of the `namespaces` service.

Sometimes, the API may support other properties that are not yet supported in the Java SDK types. In that case, you can attach them using raw setters:

```java
import com.turbopuffer.api.core.JsonValue;
import com.turbopuffer.api.models.NamespaceListParams;

NamespaceListParams params = NamespaceListParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

You can also use the `putAdditionalProperty` method on nested headers, query params, or body objects.

### Undocumented response properties

To access undocumented response properties, you can use `res._additionalProperties()` on a response object to get a map of untyped fields of type `Map<String, JsonValue>`. You can then access fields like `res._additionalProperties().get("secret_prop").asString()` or use other helpers defined on the `JsonValue` class to extract it to a desired type.

## Logging

We use the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

You can enable logging by setting the environment variable `TURBOPUFFER_LOG` to `info`.

```sh
$ export TURBOPUFFER_LOG=info
```

Or to `debug` for more verbose logging.

```sh
$ export TURBOPUFFER_LOG=debug
```

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/stainless-sdks/turbopuffer-java/issues) with questions, bugs, or suggestions.
