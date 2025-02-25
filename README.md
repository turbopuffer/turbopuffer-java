# Turbopuffer Java API Library

<!-- x-release-please-start-version -->

[![Maven Central](https://img.shields.io/maven-central/v/com.turbopuffer/turbopuffer-java)](https://central.sonatype.com/artifact/com.turbopuffer/turbopuffer-java/0.1.0-beta.9)

<!-- x-release-please-end -->

The Turbopuffer Java SDK provides convenient access to the Turbopuffer REST API from applications written in Java.

It is generated with [Stainless](https://www.stainlessapi.com/).

The REST API documentation can be found on [turbopuffer.com](https://turbopuffer.com/docs).

## Installation

<!-- x-release-please-start-version -->

### Gradle

```kotlin
implementation("com.turbopuffer:turbopuffer-java:0.1.0-beta.9")
```

### Maven

```xml
<dependency>
    <groupId>com.turbopuffer</groupId>
    <artifactId>turbopuffer-java</artifactId>
    <version>0.1.0-beta.9</version>
</dependency>
```

<!-- x-release-please-end -->

## Requirements

This library requires Java 8 or later.

## Usage

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
import com.turbopuffer.models.DistanceMetric;
import com.turbopuffer.models.NamespaceUpsertParams;
import com.turbopuffer.models.NamespaceUpsertResponse;

// Configures using the `TURBOPUFFER_API_KEY` environment variable
TurbopufferClient client = TurbopufferOkHttpClient.fromEnv();

NamespaceUpsertParams params = NamespaceUpsertParams.builder()
    .namespace("products")
    .documents(NamespaceUpsertParams.Documents.UpsertColumnar.builder()
        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
        .build())
    .build();
NamespaceUpsertResponse response = client.namespaces().upsert(params);
```

## Client configuration

Configure the client using environment variables:

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;

// Configures using the `TURBOPUFFER_API_KEY` environment variable
TurbopufferClient client = TurbopufferOkHttpClient.fromEnv();
```

Or manually:

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .apiKey("My API Key")
    .build();
```

Or using a combination of the two approaches:

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    // Configures using the `TURBOPUFFER_API_KEY` environment variable
    .fromEnv()
    .apiKey("My API Key")
    .build();
```

See this table for the available options:

| Setter   | Environment variable  | Required | Default value |
| -------- | --------------------- | -------- | ------------- |
| `apiKey` | `TURBOPUFFER_API_KEY` | true     | -             |

> [!TIP]
> Don't create more than one client in the same application. Each client has a connection pool and
> thread pools, which are more efficient to share between requests.

## Requests and responses

To send a request to the Turbopuffer API, build an instance of some `Params` class and pass it to the corresponding client method. When the response is received, it will be deserialized into an instance of a Java class.

For example, `client.namespaces().upsert(...)` should be called with an instance of `NamespaceUpsertParams`, and it will return an instance of `NamespaceUpsertResponse`.

## Immutability

Each class in the SDK has an associated [builder](https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java) or factory method for constructing it.

Each class is [immutable](https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html) once constructed. If the class has an associated builder, then it has a `toBuilder()` method, which can be used to convert it back to a builder for making a modified copy.

Because each class is immutable, builder modification will _never_ affect already built class instances.

## Asynchronous execution

The default client is synchronous. To switch to asynchronous execution, call the `async()` method:

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
import com.turbopuffer.models.DistanceMetric;
import com.turbopuffer.models.NamespaceUpsertParams;
import com.turbopuffer.models.NamespaceUpsertResponse;
import java.util.concurrent.CompletableFuture;

// Configures using the `TURBOPUFFER_API_KEY` environment variable
TurbopufferClient client = TurbopufferOkHttpClient.fromEnv();

NamespaceUpsertParams params = NamespaceUpsertParams.builder()
    .namespace("products")
    .documents(NamespaceUpsertParams.Documents.UpsertColumnar.builder()
        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
        .build())
    .build();
CompletableFuture<NamespaceUpsertResponse> response = client.async().namespaces().upsert(params);
```

Or create an asynchronous client from the beginning:

```java
import com.turbopuffer.client.TurbopufferClientAsync;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClientAsync;
import com.turbopuffer.models.DistanceMetric;
import com.turbopuffer.models.NamespaceUpsertParams;
import com.turbopuffer.models.NamespaceUpsertResponse;
import java.util.concurrent.CompletableFuture;

// Configures using the `TURBOPUFFER_API_KEY` environment variable
TurbopufferClientAsync client = TurbopufferOkHttpClientAsync.fromEnv();

NamespaceUpsertParams params = NamespaceUpsertParams.builder()
    .namespace("products")
    .documents(NamespaceUpsertParams.Documents.UpsertColumnar.builder()
        .distanceMetric(DistanceMetric.COSINE_DISTANCE)
        .build())
    .build();
CompletableFuture<NamespaceUpsertResponse> response = client.namespaces().upsert(params);
```

The asynchronous client supports the same options as the synchronous one, except most methods return `CompletableFuture`s.

## Error handling

The SDK throws custom unchecked exception types:

- [`TurbopufferServiceException`](turbopuffer-java-core/src/main/kotlin/com/turbopuffer/errors/TurbopufferServiceException.kt): Base class for HTTP errors. See this table for which exception subclass is thrown for each HTTP status code:

  | Status | Exception                       |
  | ------ | ------------------------------- |
  | 400    | `BadRequestException`           |
  | 401    | `AuthenticationException`       |
  | 403    | `PermissionDeniedException`     |
  | 404    | `NotFoundException`             |
  | 422    | `UnprocessableEntityException`  |
  | 429    | `RateLimitException`            |
  | 5xx    | `InternalServerException`       |
  | others | `UnexpectedStatusCodeException` |

- [`TurbopufferIoException`](turbopuffer-java-core/src/main/kotlin/com/turbopuffer/errors/TurbopufferIoException.kt): I/O networking errors.

- [`TurbopufferInvalidDataException`](turbopuffer-java-core/src/main/kotlin/com/turbopuffer/errors/TurbopufferInvalidDataException.kt): Failure to interpret successfully parsed data. For example, when accessing a property that's supposed to be required, but the API unexpectedly omitted it from the response.

- [`TurbopufferException`](turbopuffer-java-core/src/main/kotlin/com/turbopuffer/errors/TurbopufferException.kt): Base class for all exceptions. Most errors will result in one of the previously mentioned ones, but completely generic errors may be thrown using the base class.

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

## Logging

The SDK uses the standard [OkHttp logging interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor).

Enable logging by setting the `TURBOPUFFER_LOG` environment variable to `info`:

```sh
$ export TURBOPUFFER_LOG=info
```

Or to `debug` for more verbose logging:

```sh
$ export TURBOPUFFER_LOG=debug
```

## Network options

### Retries

The SDK automatically retries 2 times by default, with a short exponential backoff.

Only the following error types are retried:

- Connection errors (for example, due to a network connectivity problem)
- 408 Request Timeout
- 409 Conflict
- 429 Rate Limit
- 5xx Internal

The API may also explicitly instruct the SDK to retry or not retry a response.

To set a custom number of retries, configure the client using the `maxRetries` method:

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 1 minute by default.

To set a custom timeout, configure the method call using the `timeout` method:

```java
import com.turbopuffer.models.DistanceMetric;
import com.turbopuffer.models.NamespaceUpsertParams;
import com.turbopuffer.models.NamespaceUpsertResponse;

NamespaceUpsertResponse response = client.namespaces().upsert(
  params, RequestOptions.builder().timeout(Duration.ofSeconds(30)).build()
);
```

Or configure the default for all method calls at the client level:

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

To route requests through a proxy, configure the client using the `proxy` method:

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
      Proxy.Type.HTTP, new InetSocketAddress(
        "https://example.com", 8080
      )
    ))
    .build();
```

## Undocumented API functionality

The SDK is typed for convenient usage of the documented API. However, it also supports working with undocumented or not yet supported parts of the API.

### Parameters

To set undocumented parameters, call the `putAdditionalHeader`, `putAdditionalQueryParam`, or `putAdditionalBodyProperty` methods on any `Params` class:

```java
import com.turbopuffer.core.JsonValue;
import com.turbopuffer.models.NamespaceUpsertParams;

NamespaceUpsertParams params = NamespaceUpsertParams.builder()
    .putAdditionalHeader("Secret-Header", "42")
    .putAdditionalQueryParam("secret_query_param", "42")
    .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
    .build();
```

These can be accessed on the built object later using the `_additionalHeaders()`, `_additionalQueryParams()`, and `_additionalBodyProperties()` methods. You can also set undocumented parameters on nested headers, query params, or body classes using the `putAdditionalProperty` method. These properties can be accessed on the built object later using the `_additionalProperties()` method.

To set a documented parameter or property to an undocumented or not yet supported _value_, pass a [`JsonValue`](turbopuffer-java-core/src/main/kotlin/com/turbopuffer/core/JsonValue.kt) object to its setter:

```java
import com.turbopuffer.core.JsonValue;
import com.turbopuffer.models.NamespaceUpsertParams;

NamespaceUpsertParams params = NamespaceUpsertParams.builder()
    .namespace("products")
    .documents(JsonValue.from(42))
    .build();
```

### Response properties

To access undocumented response properties, call the `_additionalProperties()` method:

```java
import com.turbopuffer.core.JsonValue;
import java.util.Map;

Map<String, JsonValue> additionalProperties = client.namespaces().upsert(params)._additionalProperties();
JsonValue secretPropertyValue = additionalProperties.get("secretProperty");

String result = secretPropertyValue.accept(new JsonValue.Visitor<>() {
    @Override
    public String visitNull() {
        return "It's null!";
    }

    @Override
    public String visitBoolean(boolean value) {
        return "It's a boolean!";
    }

    @Override
    public String visitNumber(Number value) {
        return "It's a number!";
    }

    // Other methods include `visitMissing`, `visitString`, `visitArray`, and `visitObject`
    // The default implementation of each unimplemented method delegates to `visitDefault`, which throws by default, but can also be overridden
});
```

To access a property's raw JSON value, which may be undocumented, call its `_` prefixed method:

```java
import com.turbopuffer.core.JsonField;
import java.util.Optional;

JsonField<Object> field = client.namespaces().upsert(params)._field();

if (field.isMissing()) {
  // The property is absent from the JSON response
} else if (field.isNull()) {
  // The property was set to literal null
} else {
  // Check if value was provided as a string
  // Other methods include `asNumber()`, `asBoolean()`, etc.
  Optional<String> jsonString = field.asString();

  // Try to deserialize into a custom type
  MyClass myObject = field.asUnknown().orElseThrow().convert(MyClass.class);
}
```

### Response validation

In rare cases, the API may return a response that doesn't match the expected type. For example, the SDK may expect a property to contain a `String`, but the API could return something else.

By default, the SDK will not throw an exception in this case. It will throw [`TurbopufferInvalidDataException`](turbopuffer-java-core/src/main/kotlin/com/turbopuffer/errors/TurbopufferInvalidDataException.kt) only if you directly access the property.

If you would prefer to check that the response is completely well-typed upfront, then either call `validate()`:

```java
import com.turbopuffer.models.NamespaceUpsertResponse;

NamespaceUpsertResponse response = client.namespaces().upsert(params).validate();
```

Or configure the method call to validate the response using the `responseValidation` method:

```java
import com.turbopuffer.models.DistanceMetric;
import com.turbopuffer.models.NamespaceUpsertParams;
import com.turbopuffer.models.NamespaceUpsertResponse;

NamespaceUpsertResponse response = client.namespaces().upsert(
  params, RequestOptions.builder().responseValidation(true).build()
);
```

Or configure the default for all method calls at the client level:

```java
import com.turbopuffer.client.TurbopufferClient;
import com.turbopuffer.client.okhttp.TurbopufferOkHttpClient;

TurbopufferClient client = TurbopufferOkHttpClient.builder()
    .fromEnv()
    .responseValidation(true)
    .build();
```

## FAQ

### Why don't you use plain `enum` classes?

Java `enum` classes are not trivially [forwards compatible](https://www.stainless.com/blog/making-java-enums-forwards-compatible). Using them in the SDK could cause runtime exceptions if the API is updated to respond with a new enum value.

### Why do you represent fields using `JsonField<T>` instead of just plain `T`?

Using `JsonField<T>` enables a few features:

- Allowing usage of [undocumented API functionality](#undocumented-api-functionality)
- Lazily [validating the API response against the expected shape](#response-validation)
- Representing absent vs explicitly null values

### Why don't you use [`data` classes](https://kotlinlang.org/docs/data-classes.html)?

It is not [backwards compatible to add new fields to a data class](https://kotlinlang.org/docs/api-guidelines-backward-compatibility.html#avoid-using-data-classes-in-your-api) and we don't want to introduce a breaking change every time we add a field to a class.

### Why don't you use checked exceptions?

Checked exceptions are widely considered a mistake in the Java programming language. In fact, they were omitted from Kotlin for this reason.

Checked exceptions:

- Are verbose to handle
- Encourage error handling at the wrong level of abstraction, where nothing can be done about the error
- Are tedious to propagate due to the [function coloring problem](https://journal.stuffwithstuff.com/2015/02/01/what-color-is-your-function)
- Don't play well with lambdas (also due to the function coloring problem)

## Semantic versioning

This package generally follows [SemVer](https://semver.org/spec/v2.0.0.html) conventions, though certain backwards-incompatible changes may be released as minor versions:

1. Changes to library internals which are technically public but not intended or documented for external use. _(Please open a GitHub issue to let us know if you are relying on such internals.)_
2. Changes that we do not expect to impact the vast majority of users in practice.

We take backwards-compatibility seriously and work hard to ensure you can rely on a smooth upgrade experience.

We are keen for your feedback; please open an [issue](https://www.github.com/turbopuffer/turbopuffer-java/issues) with questions, bugs, or suggestions.
