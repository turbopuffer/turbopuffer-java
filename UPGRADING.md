# Upgrade guide

This document describes the notable breaking changes, if any, in each version
of the Java client. See [CHANGELOG.md](./CHANGELOG.md) for a comprehensive list
of changes.

## v2.0

- The `RankBy.vector` factory has been renamed to `RankBy.ann`.

  Old:

  ```java
  ns.query(
    NamespaceQueryParams.builder()
      .rankBy(RankBy.vector("vector", List.of(0.1f, 0.2f)))
      .build()
  );
  ```

  New:

  ```java
  ns.query(
    NamespaceQueryParams.builder()
      .rankBy(RankBy.ann("vector", List.of(0.1f, 0.2f)))
      .build()
  );
  ```

- `NamespaceQueryParams.builder().groupBy()` now takes `List<GroupBy>` instead
  of `List<String>`. Wrap plain attribute names with `GroupBy.attr`.

  Old:

  ```java
  ns.query(
    NamespaceQueryParams.builder()
      .groupBy(List.of("color", "size"))
      .build()
  );
  ```

  New:

  ```java
  ns.query(
    NamespaceQueryParams.builder()
      .groupBy(List.of(GroupBy.attr("color"), GroupBy.attr("size")))
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

  A new `default` variant lets you migrate a namespace from CMEK to default
  encryption.

- The `copyFromNamespace` parameter on `NamespaceWriteParams` has been removed
  in favor of a dedicated `copyFrom` method.

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
