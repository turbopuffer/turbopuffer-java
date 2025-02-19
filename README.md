# Turbopuffer Java API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.turbopuffer/turbopuffer-java)](https://central.sonatype.com/artifact/com.turbopuffer/turbopuffer-java/0.1.0-beta.6)

<!-- x-release-please-end -->

The Turbopuffer Java SDK provides convenient access to the Turbopuffer REST API from applications written in Java.

It is generated with [Stainless](https://www.stainlessapi.com/).

The REST API documentation can be found on [turbopuffer.com](https://turbopuffer.com/docs).

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.turbopuffer:turbopuffer-java:0.1.0-beta.6")
```

### Maven

```xml
<dependency>
    <groupId>com.turbopuffer</groupId>
    <artifactId>turbopuffer-java</artifactId>
    <version>0.1.0-beta.6</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

### Configure the client

Use `TurbopufferOkHttpClient.builder()` to configure the client. At a minimum you need to set `.apiKey()`:

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Alternately, set the environment with `TURBOPUFFER_API_KEY`, and use `TurbopufferOkHttpClient.fromEnv()` to read from the environment.

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;

TurbopufferClient client = TurbopufferOkHttpClient.fromEnv();

// Note: you can also call fromEnv() from the client builder, for example if you need to set additional properties
TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .fromEnv()
    // ... set properties on the builder
    .build();
```

| Property | Environment variable  | Required | Default value |
| -------- | --------------------- | -------- | ------------- |
| apiKey   | `TURBOPUFFER_API_KEY` | true     | —             |

Read the documentation for more configuration options.

---

### Example: creating a resource

To create a new namespace, first use the `NamespaceUpsertParams` builder to specify attributes, then pass that to the `upsert` method of the `namespaces` service.

```java
import com.turbopuffer.models.DistanceMetric;
import com.turbopuffer.models.NamespaceUpsertParams;
import com.turbopuffer.models.NamespaceUpsertResponse;

NamespaceUpsertParams params = NamespaceUpsertParams.builder()
    .namespace("products")
    .documents(NamespaceUpsertParams.Documents.UpsertColumnar.builder()
        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
        .build())
    .build();
NamespaceUpsertResponse response = client.namespaces().upsert(params);
```

### Example: listing resources

The Turbopuffer API provides a `list` method to get a paginated list of namespaces. You can retrieve the first page by:

```java
import com.turbopuffer.models.NamespaceListPage;
import com.turbopuffer.models.NamespaceSummary;

NamespaceListPage page = client.namespaces().list();
for (NamespaceSummary namespace : page.namespaces()) {
    System.out.println(namespace);
}
```

Use the `NamespaceListParams` builder to set parameters:

```java
import com.turbopuffer.models.NamespaceListPage;
import com.turbopuffer.models.NamespaceListParams;

NamespaceListParams params = NamespaceListParams.builder()
    .cursor("cursor")
    .pageSize(1L)
    .prefix("products")
    .build();
NamespaceListPage page1 = client.namespaces().list(params);

// Using the `from` method of the builder you can reuse previous params values:
NamespaceListPage page2 = client.namespaces().list(NamespaceListParams.builder()
    .from(params)
    .nextCursor("abc123...")
    .build());

// Or easily get params for the next page by using the helper `getNextPageParams`:
NamespaceListPage page3 = client.namespaces().list(params.getNextPageParams(page2));
```

See [Pagination](#pagination) below for more information on transparently working with lists of objects without worrying about fetching each page.

---

## Requests

### Parameters and bodies

To make a request to the Turbopuffer API, you generally build an instance of the appropriate `Params` class.

See [Undocumented request params](#undocumented-request-params) for how to send arbitrary parameters.

## Responses

### Response validation

When receiving a response, the Turbopuffer Java SDK will deserialize it into instances of the typed model classes. In rare cases, the API may return a response property that doesn't match the expected Java type. If you directly access the mistaken property, the SDK will throw an unchecked `TurbopufferInvalidDataException` at runtime. If you would prefer to check in advance that that response is completely well-typed, call `.validate()` on the returned model.

```java
import com.turbopuffer.models.DocumentRowWithScore;

List<DocumentRowWithScore> documentRowWithScores = client.namespaces().query().validate();
```

### Response properties as JSON

In rare cases, you may want to access the underlying JSON value for a response property rather than using the typed version provided by this SDK. Each model property has a corresponding JSON version, with an underscore before the method name, which returns a `JsonField` value.

```java
import com.turbopuffer.core.JsonField;
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
import com.turbopuffer.core.JsonValue;

JsonValue secret = attributeSchema._additionalProperties().get("secret_field");
```

---

## Pagination

For methods that return a paginated list of results, this library provides convenient ways access the results either one page at a time, or item-by-item across all pages.

### Auto-pagination

To iterate through all results across all pages, you can use `autoPager`, which automatically handles fetching more pages for you:

### Synchronous

```java
import com.turbopuffer.models.NamespaceListPage;
import com.turbopuffer.models.NamespaceSummary;

// As an Iterable:
NamespaceListPage page = client.namespaces().list(params);
for (NamespaceSummary namespace : page.autoPager()) {
    System.out.println(namespace);
};

// As a Stream:
client.namespaces().list(params).autoPager().stream()
    .limit(50)
    .forEach(namespace -> System.out.println(namespace));
```

### Asynchronous

```java
// Using forEach, which returns CompletableFuture<Void>:
asyncClient.namespaces().list(params).autoPager()
    .forEach(namespace -> System.out.println(namespace), executor);
```

### Manual pagination

If none of the above helpers meet your needs, you can also manually request pages one-by-one. A page of results has a `data()` method to fetch the list of objects, as well as top-level `response` and other methods to fetch top-level data about the page. It also has methods `hasNextPage`, `getNextPage`, and `getNextPageParams` methods to help with pagination.

```java
import com.turbopuffer.models.NamespaceListPage;
import com.turbopuffer.models.NamespaceSummary;

NamespaceListPage page = client.namespaces().list(params);
while (page != null) {
    for (NamespaceSummary namespace : page.namespaces()) {
        System.out.println(namespace);
    }

    page = page.getNextPage().orElse(null);
}
```

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
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default. You can configure this on the client builder:

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
import java.time.Duration;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

Requests can be routed through a proxy. You can configure this on the client builder:

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
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

In [Example: creating a resource](#example-creating-a-resource) above, we used the `NamespaceQueryParams.builder()` to pass to the `query` method of the `namespaces` service.

Sometimes, the API may support other properties that are not yet supported in the Java SDK types. In that case, you can attach them using raw setters:

```java
import com.turbopuffer.core.JsonValue;
import com.turbopuffer.models.NamespaceQueryParams;

NamespaceQueryParams params = NamespaceQueryParams.builder()
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

We are keen for your feedback; please open an [issue](https://www.github.com/turbopuffer/turbopuffer-java/issues) with questions, bugs, or suggestions.
