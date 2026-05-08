# Upgrade guide

This document describes the notable breaking changes, if any, in each version of
the Java client. See [CHANGELOG.md](./CHANGELOG.md) for a comprehensive list of
changes.

## v2.0

- The `copyFromNamespace` parameter on `NamespaceWriteParams` has been removed
  in favor of a dedicated `copyFrom` method. The nested
  `CopyFromNamespaceConfig` builder has been replaced by a flat
  `NamespaceCopyFromParams` builder.

  Old:

  ```java
  ns.write(
    NamespaceWriteParams.builder()
      .copyFromNamespace(
        CopyFromNamespaceParams.CopyFromNamespaceConfig.builder()
          .sourceNamespace("src")
          .sourceRegion("gcp-us-central1")
          .build()
      )
      .build()
  );
  ```

  New:

  ```java
  ns.copyFrom(
    NamespaceCopyFromParams.builder()
      .sourceNamespace("src")
      .sourceRegion("gcp-us-central1")
      .build()
  );
  ```

- The `branchFromNamespace` parameter on `NamespaceWriteParams` has been removed
  in favor of a dedicated `branchFrom` method.

  Old:

  ```java
  ns.write(
    NamespaceWriteParams.builder()
      .branchFromNamespace("src")
      .build()
  );
  ```

  New:

  ```java
  ns.branchFrom(
    NamespaceBranchFromParams.builder()
      .sourceNamespace("src")
      .build()
  );
  ```

- The top-level `Query` builder used by `multiQuery` has been moved to
  `NamespaceMultiQueryParams.Query`.

  Old:

  ```java
  ns.multiQuery(
    NamespaceMultiQueryParams.builder()
      .addQuery(Query.builder().rankBy(/* ... */).build())
      .build()
  );
  ```

  New:

  ```java
  ns.multiQuery(
    NamespaceMultiQueryParams.builder()
      .addQuery(NamespaceMultiQueryParams.Query.builder().rankBy(/* ... */).build())
      .build()
  );
  ```

- The `encryption` parameter has been restructured.

  Old:

  ```java
  ns.write(
    NamespaceWriteParams.builder()
      .addUpsertRow(/* ... */)
      .encryption(
        NamespaceWriteParams.Encryption.builder()
          .cmek(NamespaceWriteParams.Encryption.Cmek.builder().keyName("...").build())
          .build()
      )
      .build()
  );
  ```

  New:

  ```java
  ns.write(
    NamespaceWriteParams.builder()
      .addUpsertRow(/* ... */)
      .encryption(Encryption.CustomerManaged.builder().keyName("...").build())
      .build()
  );
  ```

  A new `default` variant lets you explicitly opt out of CMEK on writes to a
  CMEK-enabled namespace.
