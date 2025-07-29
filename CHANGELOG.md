# Changelog

## 0.2.5 (2025-07-29)

Full Changelog: [v0.2.4...v0.2.5](https://github.com/turbopuffer/turbopuffer-java/compare/v0.2.4...v0.2.5)

### Features

* **client:** ensure compat with proguard ([ac622df](https://github.com/turbopuffer/turbopuffer-java/commit/ac622df72b33eb1f3b51d579506195b22d9b2f35))


### Bug Fixes

* add support for regex filter ([971d981](https://github.com/turbopuffer/turbopuffer-java/commit/971d981f213c9449c5de2165fe3c8a581c216f1c))
* **api:** api update ([7bebead](https://github.com/turbopuffer/turbopuffer-java/commit/7bebeadadda2ee5056497b5ed65c1175f5ff0f04))
* **api:** api update ([61aed7b](https://github.com/turbopuffer/turbopuffer-java/commit/61aed7b8ff5ba2a2043e01caf2e889e29a87f5ea))

## 0.2.4 (2025-07-28)

Full Changelog: [v0.2.3...v0.2.4](https://github.com/turbopuffer/turbopuffer-java/compare/v0.2.3...v0.2.4)

### Bug Fixes

* **client:** accidental mutability of some classes ([96665c1](https://github.com/turbopuffer/turbopuffer-java/commit/96665c1a4076b41d90f30950aeb4b19804cc8eef))
* more precise types for filters that take arrays ([40337f7](https://github.com/turbopuffer/turbopuffer-java/commit/40337f75cbf0a0b1a7fa6978051be9272c2fb420))


### Chores

* **internal:** remove unnecessary `[...]` in `[@see](https://github.com/see)` ([68add22](https://github.com/turbopuffer/turbopuffer-java/commit/68add22b9e2be2db73b74a4fd6a585fadc0e7cf1))


### Documentation

* fix missing readme comment ([cf55dcb](https://github.com/turbopuffer/turbopuffer-java/commit/cf55dcb5771d1dd1236b99583a6014a7ea4178c6))
* more code comments ([add7529](https://github.com/turbopuffer/turbopuffer-java/commit/add75291976c6e4191ae97ea16c0b934b46ef5a9))

## 0.2.3 (2025-07-23)

Full Changelog: [v0.2.2...v0.2.3](https://github.com/turbopuffer/turbopuffer-java/compare/v0.2.2...v0.2.3)

### ⚠ BREAKING CHANGES

* **client:** don't require setting constant fields

### Features

* **client:** add `{QueryParams,Headers}#put(String, JsonValue)` methods ([755849d](https://github.com/turbopuffer/turbopuffer-java/commit/755849d00c890272c124ee85b0c5d5dc9f8ab155))
* **client:** add https config options ([d2e1d1d](https://github.com/turbopuffer/turbopuffer-java/commit/d2e1d1da20bccfdad692c45bcc33cc566901ce69))
* **client:** add https config options ([7272cb6](https://github.com/turbopuffer/turbopuffer-java/commit/7272cb6d4f8021294bb9dbdb2ac34f1d5e8119a3))
* **client:** allow configuring env via system properties ([ade0125](https://github.com/turbopuffer/turbopuffer-java/commit/ade0125404f032256555f5d135f239758ab30900))
* **client:** don't require setting constant fields ([1dc1c0d](https://github.com/turbopuffer/turbopuffer-java/commit/1dc1c0d7ec11cf7df214278a47306af31c1b0587))


### Bug Fixes

* adjust dispatcher configuration for Stainless changes ([b853456](https://github.com/turbopuffer/turbopuffer-java/commit/b853456543b1a0afda486d7280b80412df8c5715))
* formatting ([1ea9e2b](https://github.com/turbopuffer/turbopuffer-java/commit/1ea9e2b9748ce0bf3c370b82e49c0d257c000870))
* formatting ([3602f2f](https://github.com/turbopuffer/turbopuffer-java/commit/3602f2f7e4badc403b75c32a49978a12227e1d21))


### Chores

* **internal:** refactor delegating from client to options ([c09140a](https://github.com/turbopuffer/turbopuffer-java/commit/c09140a5d8fd822987b2e7f2f34f0dbe0342ba08))

## 0.2.2 (2025-07-21)

Full Changelog: [v0.2.1...v0.2.2](https://github.com/turbopuffer/turbopuffer-java/compare/v0.2.1...v0.2.2)

### Bug Fixes

* **client:** ensure error handling always occurs ([bd078a2](https://github.com/turbopuffer/turbopuffer-java/commit/bd078a2bc4f680568938309697d17c374f2a2c35))


### Chores

* **ci:** bump `actions/setup-java` to v4 ([fbf153b](https://github.com/turbopuffer/turbopuffer-java/commit/fbf153b810408f2daec513f550c2f293b7724715))
* **internal:** allow running specific example from cli ([51cc413](https://github.com/turbopuffer/turbopuffer-java/commit/51cc41370c1c1ab576b696bba6a9abd49600f67a))

## 0.2.1 (2025-07-10)

Full Changelog: [v0.2.0...v0.2.1](https://github.com/turbopuffer/turbopuffer-java/compare/v0.2.0...v0.2.1)

### Bug Fixes

* **api:** api update ([186ce05](https://github.com/turbopuffer/turbopuffer-java/commit/186ce05bbd880a6b518b7bdbb6e431d968e53c88))
* **api:** api update ([31f8816](https://github.com/turbopuffer/turbopuffer-java/commit/31f8816648c2d260a558ca188522f3d0d8426d87))
* update tests for new metadata endpoint ([384bf29](https://github.com/turbopuffer/turbopuffer-java/commit/384bf298455d327ec1101d116c64dda52d1ec249))


### Chores

* **internal:** codegen related update ([ec6e57a](https://github.com/turbopuffer/turbopuffer-java/commit/ec6e57acb16318475d56c695c1cacdc6c4f74848))
* **internal:** version bump ([730f913](https://github.com/turbopuffer/turbopuffer-java/commit/730f913f04aa5fbdac74cfa5eece214ccd066fee))

## 0.2.0 (2025-07-09)

Full Changelog: [v0.1.2...v0.2.0](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.2...v0.2.0)

### Features

* convert Schema to a typed builder ([c844755](https://github.com/turbopuffer/turbopuffer-java/commit/c844755fad9a9550efd0e0ffcc517f74dd61f433))


### Bug Fixes

* **api:** api update ([9f9bcf0](https://github.com/turbopuffer/turbopuffer-java/commit/9f9bcf06bfc9ba318ab672b94fecb9d51de49a83))
* don't require region unless baseUrl contains {region} placeholder ([aa1425f](https://github.com/turbopuffer/turbopuffer-java/commit/aa1425fbaa9f9710ea05a1e15cdb2114fab3d163))


### Chores

* **ci:** ensure docs generation always succeeds ([2255e93](https://github.com/turbopuffer/turbopuffer-java/commit/2255e930c2c759dc3d44136fd79a006a8aa8c2f3))

## 0.1.2 (2025-07-08)

Full Changelog: [v0.1.1...v0.1.2](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.1...v0.1.2)

### Bug Fixes

* add toString() method to AggregateBy, Filter, and RankBy types ([#166](https://github.com/turbopuffer/turbopuffer-java/issues/166)) ([a19970d](https://github.com/turbopuffer/turbopuffer-java/commit/a19970de6897e58d6e9a6efae6fbd84951d74433))

## 0.1.1 (2025-07-07)

Full Changelog: [v0.1.0...v0.1.1](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0...v0.1.1)

### Bug Fixes

* **api:** add support for [Not]Contains[Any] operators ([#165](https://github.com/turbopuffer/turbopuffer-java/issues/165)) ([a2cb185](https://github.com/turbopuffer/turbopuffer-java/commit/a2cb185cd2678b14c99c88720de42dc00918c954))


### Chores

* **internal:** version bump ([0a742f1](https://github.com/turbopuffer/turbopuffer-java/commit/0a742f1abc4991c0c7db200f75486a8d1ff2f8f4))

## 0.1.0 (2025-07-01)

Full Changelog: [v0.1.0-beta.17...v0.1.0](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.17...v0.1.0)

### Bug Fixes

* add support for `$ref_new` expressions ([#162](https://github.com/turbopuffer/turbopuffer-java/issues/162)) ([f16db2b](https://github.com/turbopuffer/turbopuffer-java/commit/f16db2bb8bba174c8713e49fdbc8972a3c53180d))
* **api:** api update ([8573835](https://github.com/turbopuffer/turbopuffer-java/commit/857383531d3f4bca7ad5e3fe6b88d330dffd9f72))
* correct name of stainless bot ([#163](https://github.com/turbopuffer/turbopuffer-java/issues/163)) ([111e34b](https://github.com/turbopuffer/turbopuffer-java/commit/111e34bd97c83f573cb8cfbc3d10fc7a86afdb27))
* further strengthen conditional write types ([4263dcd](https://github.com/turbopuffer/turbopuffer-java/commit/4263dcdaa6df7d9826519543f0e7b1928a281a10))
* **README:** improve headline example ([3d1cfe7](https://github.com/turbopuffer/turbopuffer-java/commit/3d1cfe724fea1a27ec6296bf2371536aac9fce24))
* **README:** remove beta label ([de18072](https://github.com/turbopuffer/turbopuffer-java/commit/de180726039f4faa270eb55afd8ee5573f924065))


### Chores

* **internal:** codegen related update ([3dfa166](https://github.com/turbopuffer/turbopuffer-java/commit/3dfa1662b6009b7e7c8028f70ac3d01131bc4087))

## 0.1.0-beta.17 (2025-07-01)

Full Changelog: [v0.1.0-beta.16...v0.1.0-beta.17](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.16...v0.1.0-beta.17)

### Bug Fixes

* add shortcut construction methods for some API structs ([603459e](https://github.com/turbopuffer/turbopuffer-java/commit/603459e3a6e35fdf5ecc5d4e3964b9b14ed783d0))
* add strict type overloads to Query builder ([a835e4e](https://github.com/turbopuffer/turbopuffer-java/commit/a835e4eecefc70313f38aa60bcb42ea3a3d8ae65))
* **api:** api update ([a9bedfe](https://github.com/turbopuffer/turbopuffer-java/commit/a9bedfe7ad20760f87b310bd99d0b005b17c5b26))
* expose namespace IDs ([3a791fc](https://github.com/turbopuffer/turbopuffer-java/commit/3a791fc784d23553647d99ea6e44647f2e08ca42))
* further strengthen conditional write types ([7ffe09d](https://github.com/turbopuffer/turbopuffer-java/commit/7ffe09dfd057ef09861f621bdfca5bce96b6a4a2))
* strict types for conditional writes ([9ad50fb](https://github.com/turbopuffer/turbopuffer-java/commit/9ad50fb8cf30b081510b29143a0f2bb4bfc00124))
* use overloads in Filter and RankBy whenever possible ([3c8da00](https://github.com/turbopuffer/turbopuffer-java/commit/3c8da009f578b80cbcdc0c2423126ca3e268a7fe))
* use raw map for aggregations ([5f1ea31](https://github.com/turbopuffer/turbopuffer-java/commit/5f1ea31700aab3b2fa6756e3f9939288dd433170))


### Chores

* **internal:** version bump ([012e36c](https://github.com/turbopuffer/turbopuffer-java/commit/012e36c726fefe285c2634ddec370691225457a7))


### Refactors

* **internal:** minor `ClientOptionsTest` change ([dc9c347](https://github.com/turbopuffer/turbopuffer-java/commit/dc9c3471091656af8d34032391e5d7766b466ffd))

## 0.1.0-beta.16 (2025-06-30)

Full Changelog: [v0.1.0-beta.15...v0.1.0-beta.16](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.15...v0.1.0-beta.16)

### Bug Fixes

* **client:** don't close client on `withOptions` usage when original is gc'd ([f866e78](https://github.com/turbopuffer/turbopuffer-java/commit/f866e7861acfc16d7f484cef530ef5e604739944))
* improve ergonomics of filter, row, and column constructors ([18c96b1](https://github.com/turbopuffer/turbopuffer-java/commit/18c96b1e562e54d52f87e5845117da196fae5659))


### Chores

* **internal:** version bump ([f0bcab0](https://github.com/turbopuffer/turbopuffer-java/commit/f0bcab07dc5f72eb8f4554e28fe73024763ca0d8))
* **internal:** version bump ([81af70d](https://github.com/turbopuffer/turbopuffer-java/commit/81af70db857c8b6b3b6cc37da72e4b4bc507dffc))

## 0.1.0-beta.15 (2025-06-29)

Full Changelog: [v0.1.0-beta.14...v0.1.0-beta.15](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.14...v0.1.0-beta.15)

### Bug Fixes

* align delete_by_filter and ID types with other SDKs ([f8770e2](https://github.com/turbopuffer/turbopuffer-java/commit/f8770e20ff75f3d194151b1d480eeb9b6d121685))
* update tests for new deleteByFilter type ([f88c110](https://github.com/turbopuffer/turbopuffer-java/commit/f88c1104f9e9e5b68c6a28527cc3372f8cc8926f))

## 0.1.0-beta.14 (2025-06-29)

Full Changelog: [v0.1.0-beta.13...v0.1.0-beta.14](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.13...v0.1.0-beta.14)

### Bug Fixes

* avoid use-after-close bug with HTTP client ([7b7c06c](https://github.com/turbopuffer/turbopuffer-java/commit/7b7c06cf656ad8d0b0113b3b88b2a89932fbee35))
* **ci:** release-doctor — report correct token name ([e08362c](https://github.com/turbopuffer/turbopuffer-java/commit/e08362c21179bcb930874f20bd403b2b4e803322))
* introduce namespace resources and typed query parameters ([2b43f02](https://github.com/turbopuffer/turbopuffer-java/commit/2b43f022daaa6f5ec4a6d494a54b30b358e37927))
* **README:** adjust location of beta warning label ([23f92e9](https://github.com/turbopuffer/turbopuffer-java/commit/23f92e971a58db2abd2fe5e8f528d0c474bad6df))
* **README:** align formatting with other SDKs ([4a8ff86](https://github.com/turbopuffer/turbopuffer-java/commit/4a8ff867d8a69128c10d2a7928a78372c7e1bd54))
* run examples in CI ([4ad9f9a](https://github.com/turbopuffer/turbopuffer-java/commit/4ad9f9a9f62cf1e16f6ddd6ca580c5af5953b3cf))
* update code generator image version ([fe963a4](https://github.com/turbopuffer/turbopuffer-java/commit/fe963a4f54bbddc1097346012b645dd7d2ea553d))


### Chores

* **ci:** only run for pushes and fork pull requests ([c1b6176](https://github.com/turbopuffer/turbopuffer-java/commit/c1b6176307d007b994f0bb6a0932111bf5f1a0a0))
* **internal:** version bump ([0e45a6f](https://github.com/turbopuffer/turbopuffer-java/commit/0e45a6fefd32fd7643d8a4c508e18cf783b9836b))
* remove custom code ([6a01104](https://github.com/turbopuffer/turbopuffer-java/commit/6a011048b61fb5225e8daaa0405c1c3306b6eade))
* remove example files ([bdbdb3f](https://github.com/turbopuffer/turbopuffer-java/commit/bdbdb3feca3788137366dcc3fb41acf837b5301a))

## [0.1.0-beta.13](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.12...v0.1.0-beta.13) (2025-06-23)


### Features

* allow configuring maxRequests ([33bbd4d](https://github.com/turbopuffer/turbopuffer-java/commit/33bbd4d3d6c8244922837423ac8c5e6458e47ac1))


### Bug Fixes

* add example of concurrent perf and memory usage ([54121fa](https://github.com/turbopuffer/turbopuffer-java/commit/54121fab7f8542bbc44e17cfea588608b428c3ca))
* fix example running instructions for WriteAndQuery ([bbbe995](https://github.com/turbopuffer/turbopuffer-java/commit/bbbe9953c64a463eedfc02aef26072579368c2cb))

## 0.1.0-beta.12 (2025-05-01)

Full Changelog: [v0.1.0-beta.11...v0.1.0-beta.12](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.11...v0.1.0-beta.12)

### Features

* **api:** api update ([6c24648](https://github.com/turbopuffer/turbopuffer-java/commit/6c2464836f2c478e1fbd7770baff4eda7108c319))
* **api:** api update ([f733153](https://github.com/turbopuffer/turbopuffer-java/commit/f7331539d48ea50de8be9d9b815049d9e8a18b6e))
* **api:** api update ([5505285](https://github.com/turbopuffer/turbopuffer-java/commit/55052859706a483c23683d09d0a575eb6c366a97))
* **api:** api update ([4015e5b](https://github.com/turbopuffer/turbopuffer-java/commit/4015e5b316116ca42600e7c4908bc630130a3fb1))


### Chores

* remove custom code ([ebaa463](https://github.com/turbopuffer/turbopuffer-java/commit/ebaa463c36816dfd35706dd4efcb4f46321be0eb))
* remove custom code ([6b43f87](https://github.com/turbopuffer/turbopuffer-java/commit/6b43f87c9348b10940fd8166f0f56e602ba8ed6e))

## 0.1.0-beta.11 (2025-05-01)

Full Changelog: [v0.1.0-beta.10...v0.1.0-beta.11](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.10...v0.1.0-beta.11)

### Features

* **api:** api update ([#119](https://github.com/turbopuffer/turbopuffer-java/issues/119)) ([c2f47d3](https://github.com/turbopuffer/turbopuffer-java/commit/c2f47d3437c3c256c890a77129dfcf5ab197894c))
* **api:** api update ([#120](https://github.com/turbopuffer/turbopuffer-java/issues/120)) ([87000c5](https://github.com/turbopuffer/turbopuffer-java/commit/87000c5bd30c55393d98e331870fa621d7e29c19))
* **examples:** demonstrate basic filtering ([093516b](https://github.com/turbopuffer/turbopuffer-java/commit/093516b4d5c887d208862405aeb017e762a7f39b))


### Bug Fixes

* **examples:** update for new path structure ([40ab948](https://github.com/turbopuffer/turbopuffer-java/commit/40ab9486f7e0a14a291b7429784ab8eada096b73))


### Chores

* **internal:** add some tests for union classes ([#128](https://github.com/turbopuffer/turbopuffer-java/issues/128)) ([7693a4f](https://github.com/turbopuffer/turbopuffer-java/commit/7693a4f13821817440742ae2c5bf3432c97a6ecf))
* **internal:** codegen related update ([#123](https://github.com/turbopuffer/turbopuffer-java/issues/123)) ([89be895](https://github.com/turbopuffer/turbopuffer-java/commit/89be895aa1b30369135022290fac23e505d470dd))
* **internal:** delete duplicate tests ([cfbc54a](https://github.com/turbopuffer/turbopuffer-java/commit/cfbc54a184569b3762d4bda8d2e942b90a387bf8))
* **internal:** generate more tests ([7e960b9](https://github.com/turbopuffer/turbopuffer-java/commit/7e960b9d89aaa8cdad952741d07f2d5d6a742a0a))
* **internal:** refactor query param serialization impl and tests ([#125](https://github.com/turbopuffer/turbopuffer-java/issues/125)) ([8dc91f9](https://github.com/turbopuffer/turbopuffer-java/commit/8dc91f97799a2316af42056883b3e61702e510ba))
* **internal:** refactor some test assertions ([cfbc54a](https://github.com/turbopuffer/turbopuffer-java/commit/cfbc54a184569b3762d4bda8d2e942b90a387bf8))
* **internal:** reformat some tests ([#127](https://github.com/turbopuffer/turbopuffer-java/issues/127)) ([7e960b9](https://github.com/turbopuffer/turbopuffer-java/commit/7e960b9d89aaa8cdad952741d07f2d5d6a742a0a))
* **internal:** remove extra empty newlines ([#121](https://github.com/turbopuffer/turbopuffer-java/issues/121)) ([5ddb809](https://github.com/turbopuffer/turbopuffer-java/commit/5ddb80900537da70e88c21fa34acfbe23be3c3a8))
* **internal:** rename `getPathParam` ([#126](https://github.com/turbopuffer/turbopuffer-java/issues/126)) ([cfbc54a](https://github.com/turbopuffer/turbopuffer-java/commit/cfbc54a184569b3762d4bda8d2e942b90a387bf8))
* **internal:** reorder some params methodsc ([cfbc54a](https://github.com/turbopuffer/turbopuffer-java/commit/cfbc54a184569b3762d4bda8d2e942b90a387bf8))
* remove custom code ([dd02624](https://github.com/turbopuffer/turbopuffer-java/commit/dd026248266a675161f7ffd64525d85afbb9b531))
* remove custom code ([dadc99a](https://github.com/turbopuffer/turbopuffer-java/commit/dadc99ac2e4a923e74b1f8a790e0686302eed4ab))
* remove custom code ([961e51f](https://github.com/turbopuffer/turbopuffer-java/commit/961e51f12bd6ee6a4ca603920ba67bb2441e905b))


### Documentation

* add `build` method comments ([#124](https://github.com/turbopuffer/turbopuffer-java/issues/124)) ([ea4b834](https://github.com/turbopuffer/turbopuffer-java/commit/ea4b8346687075035c4dbd611e78f203a0dfded7))
* deduplicate and refine comments ([#122](https://github.com/turbopuffer/turbopuffer-java/issues/122)) ([7fc0b2e](https://github.com/turbopuffer/turbopuffer-java/commit/7fc0b2eeaaa04b705489b6e0704a5423096ecfb6))

## 0.1.0-beta.10 (2025-03-13)

Full Changelog: [v0.1.0-beta.9...v0.1.0-beta.10](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.9...v0.1.0-beta.10)

### ⚠ BREAKING CHANGES

* **client:** move classes into subpackages and shorten names ([#108](https://github.com/turbopuffer/turbopuffer-java/issues/108))
* **client:** refactor multipart formdata impl ([#96](https://github.com/turbopuffer/turbopuffer-java/issues/96))

### Features

* **api:** fix bug in query spec ([#115](https://github.com/turbopuffer/turbopuffer-java/issues/115)) ([b4583f7](https://github.com/turbopuffer/turbopuffer-java/commit/b4583f77ee332c2816016f6083891490794cf429))
* **client:** accept `InputStream` and `Path` for file params ([#99](https://github.com/turbopuffer/turbopuffer-java/issues/99)) ([887333e](https://github.com/turbopuffer/turbopuffer-java/commit/887333ee84f90c684572b32c2dde4b42b37d06eb))
* **client:** allow omitting params object when none required ([#88](https://github.com/turbopuffer/turbopuffer-java/issues/88)) ([a64f971](https://github.com/turbopuffer/turbopuffer-java/commit/a64f971ea96b30434e719b9d8ffbca2c689917d0))
* **client:** detect binary incompatible jackson versions ([#100](https://github.com/turbopuffer/turbopuffer-java/issues/100)) ([cf0a93d](https://github.com/turbopuffer/turbopuffer-java/commit/cf0a93d63fe92158a3be80ca4460ff7546bb0fda))
* **client:** get rid of annoying checked exceptions ([#83](https://github.com/turbopuffer/turbopuffer-java/issues/83)) ([08f8453](https://github.com/turbopuffer/turbopuffer-java/commit/08f8453a993c3e523a5105d5e6efe5abe5cedd46))
* various codegen changes ([0343f1c](https://github.com/turbopuffer/turbopuffer-java/commit/0343f1ca196252aa4816b177c67af77ea8d64bc8))


### Bug Fixes

* **client:** add missing `@JvmStatic` ([#89](https://github.com/turbopuffer/turbopuffer-java/issues/89)) ([0ba4c94](https://github.com/turbopuffer/turbopuffer-java/commit/0ba4c947407da82b09dce6da5b1e51b819181a39))
* **client:** mark some request bodies as optional ([#85](https://github.com/turbopuffer/turbopuffer-java/issues/85)) ([45f0d34](https://github.com/turbopuffer/turbopuffer-java/commit/45f0d34601e6ff5f6cc85be5514b1994640af49b))
* **README:** add beta warning label ([6dd5931](https://github.com/turbopuffer/turbopuffer-java/commit/6dd5931558fcf33c2a6c78e703a980aca28a5bef))
* **README:** adjust location of warning label ([d540695](https://github.com/turbopuffer/turbopuffer-java/commit/d5406952d76f0789934fb09725eeb6b08ef60e3c))
* **README:** adjust warning label wording ([887a32a](https://github.com/turbopuffer/turbopuffer-java/commit/887a32ae349bcf31e3ba9190f11017cabe7fc2c3))


### Chores

* **ci:** update gradle actions to v4 ([#82](https://github.com/turbopuffer/turbopuffer-java/issues/82)) ([7ecd61a](https://github.com/turbopuffer/turbopuffer-java/commit/7ecd61af748ced5fd447ff69153411e5a181f0d2))
* **client:** move classes into subpackages and shorten names ([#108](https://github.com/turbopuffer/turbopuffer-java/issues/108)) ([cc6d2b9](https://github.com/turbopuffer/turbopuffer-java/commit/cc6d2b98c9b9f672a3ed215103c5dc883d398888))
* **client:** refactor multipart formdata impl ([#96](https://github.com/turbopuffer/turbopuffer-java/issues/96)) ([304032e](https://github.com/turbopuffer/turbopuffer-java/commit/304032e75a53990290ff87a7fc608eae178a4fa7))
* **client:** use deep identity methods for primitive array types ([#91](https://github.com/turbopuffer/turbopuffer-java/issues/91)) ([e3e02cd](https://github.com/turbopuffer/turbopuffer-java/commit/e3e02cd1bac03a1009a05af5f62d8e5be89ed0e6))
* **docs:** add faq to readme ([#84](https://github.com/turbopuffer/turbopuffer-java/issues/84)) ([0040c7e](https://github.com/turbopuffer/turbopuffer-java/commit/0040c7e3f17ede8e63bf640985e1933de0a39d38))
* **internal:** add `.kotlin` to `.gitignore` ([#103](https://github.com/turbopuffer/turbopuffer-java/issues/103)) ([d91b258](https://github.com/turbopuffer/turbopuffer-java/commit/d91b2584b3bc2d76eccf6b5fd440e972e1672f85))
* **internal:** add async service tests ([#90](https://github.com/turbopuffer/turbopuffer-java/issues/90)) ([373ad64](https://github.com/turbopuffer/turbopuffer-java/commit/373ad64d2c43e7250e163d1541aed8d4a2bdbb9f))
* **internal:** codegen related update ([#109](https://github.com/turbopuffer/turbopuffer-java/issues/109)) ([cac951e](https://github.com/turbopuffer/turbopuffer-java/commit/cac951e288fd231ed5d71398a8db64fc96d0b6e2))
* **internal:** codegen related update ([#110](https://github.com/turbopuffer/turbopuffer-java/issues/110)) ([ffd4341](https://github.com/turbopuffer/turbopuffer-java/commit/ffd4341286bee3aa1ba9bb766ce0f01bba770cd1))
* **internal:** codegen related update ([#111](https://github.com/turbopuffer/turbopuffer-java/issues/111)) ([b467692](https://github.com/turbopuffer/turbopuffer-java/commit/b4676926defb0b8f757986ec9aeee249829df5cf))
* **internal:** codegen related update ([#112](https://github.com/turbopuffer/turbopuffer-java/issues/112)) ([1bd05a9](https://github.com/turbopuffer/turbopuffer-java/commit/1bd05a9fbce21ef9a29fa6366d7485b6a5a326a3))
* **internal:** codegen related update ([#113](https://github.com/turbopuffer/turbopuffer-java/issues/113)) ([5e6d5f8](https://github.com/turbopuffer/turbopuffer-java/commit/5e6d5f88537bf937a2ca7373afc517b5bed18d7e))
* **internal:** codegen related update ([#114](https://github.com/turbopuffer/turbopuffer-java/issues/114)) ([90e3968](https://github.com/turbopuffer/turbopuffer-java/commit/90e3968517709ec1fa70b210705ed937f469b4f9))
* **internal:** codegen related update ([#95](https://github.com/turbopuffer/turbopuffer-java/issues/95)) ([67455e1](https://github.com/turbopuffer/turbopuffer-java/commit/67455e14e60372f5ce4365960363c795098d7567))
* **internal:** don't use `JvmOverloads` in interfaces ([9edf6b3](https://github.com/turbopuffer/turbopuffer-java/commit/9edf6b326965b207d0fba2f22ed43831a2418e7c))
* **internal:** improve sync service tests ([373ad64](https://github.com/turbopuffer/turbopuffer-java/commit/373ad64d2c43e7250e163d1541aed8d4a2bdbb9f))
* **internal:** reenable warnings as errors ([#105](https://github.com/turbopuffer/turbopuffer-java/issues/105)) ([9edf6b3](https://github.com/turbopuffer/turbopuffer-java/commit/9edf6b326965b207d0fba2f22ed43831a2418e7c))
* **internal:** refactor `ErrorHandlingTest` ([#94](https://github.com/turbopuffer/turbopuffer-java/issues/94)) ([19a59a3](https://github.com/turbopuffer/turbopuffer-java/commit/19a59a35a99dbf75facaa2a4663cfd4154532985))
* **internal:** refactor `ServiceParamsTest` ([#92](https://github.com/turbopuffer/turbopuffer-java/issues/92)) ([512d29e](https://github.com/turbopuffer/turbopuffer-java/commit/512d29e8fda1898edd27f7f4934cee644b822a41))
* **internal:** remove unnecessary non-null asserts in tests ([45f0d34](https://github.com/turbopuffer/turbopuffer-java/commit/45f0d34601e6ff5f6cc85be5514b1994640af49b))
* **internal:** use `assertNotNull` in tests for type narrowing ([45f0d34](https://github.com/turbopuffer/turbopuffer-java/commit/45f0d34601e6ff5f6cc85be5514b1994640af49b))
* **internal:** use `getOrNull` instead of `orElse(null)` ([#104](https://github.com/turbopuffer/turbopuffer-java/issues/104)) ([82f1f3f](https://github.com/turbopuffer/turbopuffer-java/commit/82f1f3fa3ce7a7c0ad586fbcbaefb67910cfd042))


### Documentation

* add immutability explanation to readme ([#86](https://github.com/turbopuffer/turbopuffer-java/issues/86)) ([8e4facb](https://github.com/turbopuffer/turbopuffer-java/commit/8e4facbce751d5410561e512a781864a31a3748a))
* add raw response readme documentation ([#97](https://github.com/turbopuffer/turbopuffer-java/issues/97)) ([6a0e438](https://github.com/turbopuffer/turbopuffer-java/commit/6a0e438a4f6fd3ce0511f8a25bfd544f4c107a42))
* add source file links to readme ([#87](https://github.com/turbopuffer/turbopuffer-java/issues/87)) ([9628827](https://github.com/turbopuffer/turbopuffer-java/commit/96288272ae1d92e287bdf66fdec32f19004ab659))
* document `JsonValue` construction in readme ([#107](https://github.com/turbopuffer/turbopuffer-java/issues/107)) ([eb7a896](https://github.com/turbopuffer/turbopuffer-java/commit/eb7a8965e26ae5ef9db9f4f38a9447159de4b208))
* note required fields in `builder` javadoc ([#98](https://github.com/turbopuffer/turbopuffer-java/issues/98)) ([3f2dbad](https://github.com/turbopuffer/turbopuffer-java/commit/3f2dbadaaa44cd7f82ed7b0d11d466f7cb0e5a7f))
* readme parameter tweaks ([373ad64](https://github.com/turbopuffer/turbopuffer-java/commit/373ad64d2c43e7250e163d1541aed8d4a2bdbb9f))
* revise readme docs about nested params ([#106](https://github.com/turbopuffer/turbopuffer-java/issues/106)) ([de41d0b](https://github.com/turbopuffer/turbopuffer-java/commit/de41d0b98c48f9e9e63726d21092f5277a4a21da))
* update URLs from stainlessapi.com to stainless.com ([#93](https://github.com/turbopuffer/turbopuffer-java/issues/93)) ([8a59e82](https://github.com/turbopuffer/turbopuffer-java/commit/8a59e8269cba2310ce3751f472d3121cfcccc73f))

## 0.1.0-beta.9 (2025-02-19)

Full Changelog: [v0.1.0-beta.8...v0.1.0-beta.9](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.8...v0.1.0-beta.9)

### Features

* fix: try even harder to avoid merge conflicts with Stainless ([5c4be22](https://github.com/turbopuffer/turbopuffer-java/commit/5c4be22ea673f753b4f8b3215274eeeb2263a400))


### Chores

* **internal:** version bump ([#71](https://github.com/turbopuffer/turbopuffer-java/issues/71)) ([ac6872a](https://github.com/turbopuffer/turbopuffer-java/commit/ac6872a72ab86f0b102e8c8376b9069eb80ce28f))

## 0.1.0-beta.8 (2025-02-19)

Full Changelog: [v0.1.0-beta.7...v0.1.0-beta.8](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.7...v0.1.0-beta.8)

### Features

* **api:** api update ([#61](https://github.com/turbopuffer/turbopuffer-java/issues/61)) ([90fad10](https://github.com/turbopuffer/turbopuffer-java/commit/90fad108bc861833e3f7477e6e04be1a0e53238d))
* **api:** api update ([#63](https://github.com/turbopuffer/turbopuffer-java/issues/63)) ([bfef9e3](https://github.com/turbopuffer/turbopuffer-java/commit/bfef9e3f58613c21dc68a8a377903167b8b52216))


### Chores

* **internal:** version bump ([#50](https://github.com/turbopuffer/turbopuffer-java/issues/50)) ([da2ca00](https://github.com/turbopuffer/turbopuffer-java/commit/da2ca00f16ef129ee41edce8dddcfd80c1bfa4cb))
* **internal:** version bump ([#54](https://github.com/turbopuffer/turbopuffer-java/issues/54)) ([356e04c](https://github.com/turbopuffer/turbopuffer-java/commit/356e04c55452c667374eb6327eb479b1d50bb35d))
* **internal:** version bump ([#57](https://github.com/turbopuffer/turbopuffer-java/issues/57)) ([9521ad7](https://github.com/turbopuffer/turbopuffer-java/commit/9521ad719e7c5696878b2b07dbe579e677d096af))
* **internal:** version bump ([#60](https://github.com/turbopuffer/turbopuffer-java/issues/60)) ([d441d00](https://github.com/turbopuffer/turbopuffer-java/commit/d441d003eb2c157df7c24e817d72a59b7d852b20))
* **internal:** version bump ([#65](https://github.com/turbopuffer/turbopuffer-java/issues/65)) ([8026864](https://github.com/turbopuffer/turbopuffer-java/commit/802686476f05220cc8b5a2ed9e2c52c18fbe62bb))

## 0.1.0-beta.7 (2025-02-19)

Full Changelog: [v0.1.0-beta.6...v0.1.0-beta.7](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.6...v0.1.0-beta.7)

### Features

* **api:** api update ([#61](https://github.com/turbopuffer/turbopuffer-java/issues/61)) ([72f3a86](https://github.com/turbopuffer/turbopuffer-java/commit/72f3a86993021ba9847f09a92cea00df7733daa7))
* **api:** api update ([#63](https://github.com/turbopuffer/turbopuffer-java/issues/63)) ([687e1b6](https://github.com/turbopuffer/turbopuffer-java/commit/687e1b662f7c6557986315d9461a725e71eea684))

## 0.1.0-beta.6 (2025-02-19)

Full Changelog: [v0.1.0-beta.5...v0.1.0-beta.6](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.5...v0.1.0-beta.6)

### Features

* fix: try another way to avoid merge conflicts ([453dd5b](https://github.com/turbopuffer/turbopuffer-java/commit/453dd5b92e0c98194798a24a7de38e4682e656fe))

## 0.1.0-beta.5 (2025-02-19)

Full Changelog: [v0.1.0-beta.4...v0.1.0-beta.5](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.4...v0.1.0-beta.5)

### Features

* fix: avoid races in dokka ([c023cda](https://github.com/turbopuffer/turbopuffer-java/commit/c023cda5ee19c14c9e565efb3de8fffa7c5f8c78))

## 0.1.0-beta.4 (2025-02-19)

Full Changelog: [v0.1.0-beta.3...v0.1.0-beta.4](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.3...v0.1.0-beta.4)

### Features

* fix: avoid merge conflicts in build.gradle.kts ([58f1a36](https://github.com/turbopuffer/turbopuffer-java/commit/58f1a3603f772fa028ff46e9f1c0a0a62201820f))

## 0.1.0-beta.3 (2025-02-19)

Full Changelog: [v0.1.0-beta.2...v0.1.0-beta.3](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.2...v0.1.0-beta.3)

### Features

* **api:** api update ([#49](https://github.com/turbopuffer/turbopuffer-java/issues/49)) ([abb8e60](https://github.com/turbopuffer/turbopuffer-java/commit/abb8e60f295f0a46062a82f74cd979b7c249649c))
* fix: Javadoc publishing task ([845f26e](https://github.com/turbopuffer/turbopuffer-java/commit/845f26eb563ffc1b899c107af031f12418b017b7))


### Chores

* **internal:** version bump ([#46](https://github.com/turbopuffer/turbopuffer-java/issues/46)) ([1abe1af](https://github.com/turbopuffer/turbopuffer-java/commit/1abe1af65e2d639631625e26f1e31243d57c8fbf))

## 0.1.0-beta.2 (2025-02-19)

Full Changelog: [v0.1.0-beta.1...v0.1.0-beta.2](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.1...v0.1.0-beta.2)

### Features

* feat: add basic examples ([a9b3aa2](https://github.com/turbopuffer/turbopuffer-java/commit/a9b3aa2856bf4cde3e23db9323fd4224ec7aa08c))
* fix: disable configuration cache ([d33c141](https://github.com/turbopuffer/turbopuffer-java/commit/d33c141c8236e7eb16b6d88e24fa882d7cf7ea81))
* fix: generate Javadocs on publish ([9b01a93](https://github.com/turbopuffer/turbopuffer-java/commit/9b01a93b69edba322a86201dbf581329cde4fff7))

## 0.1.0-beta.1 (2025-02-19)

Full Changelog: [v0.1.0-beta.0...v0.1.0-beta.1](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.0...v0.1.0-beta.1)

### Features

* **api:** manual updates ([7f14832](https://github.com/turbopuffer/turbopuffer-java/commit/7f1483220da068067803918cc97f9470fec15e6f))
* **api:** manual updates ([#34](https://github.com/turbopuffer/turbopuffer-java/issues/34)) ([4201967](https://github.com/turbopuffer/turbopuffer-java/commit/42019678e9592fd042f43048c6e0e6fe24a3f5b9))
* **api:** manual updates ([#43](https://github.com/turbopuffer/turbopuffer-java/issues/43)) ([79b9dfb](https://github.com/turbopuffer/turbopuffer-java/commit/79b9dfbe2162d4d8ef84072eee6f8370e093e765))


### Bug Fixes

* dokkaJavadoc task name ([af73ce3](https://github.com/turbopuffer/turbopuffer-java/commit/af73ce3c25e85f661c34bb4912b7625f4824e79e))
* generate Javadocs on publish ([50fa88c](https://github.com/turbopuffer/turbopuffer-java/commit/50fa88c868c226f840ab568e22e3a4bb2d75ed1d))
* more representative batch size ([239a6b4](https://github.com/turbopuffer/turbopuffer-java/commit/239a6b493d61156450aeb98a021c0e96f59969d4))
* produce more specific timings in bulk upsert test ([70122fd](https://github.com/turbopuffer/turbopuffer-java/commit/70122fdbb8f98d73c230cb46187b26bf9523bfa5))
* **README:** add link to javadoc.io ([cf4d941](https://github.com/turbopuffer/turbopuffer-java/commit/cf4d9414b13c17319f9d00213e3fa0cc94125924))


### Chores

* remove custom code ([1c947a2](https://github.com/turbopuffer/turbopuffer-java/commit/1c947a2a67329ebf71296b9707b19c61c1869098))

## 0.1.0-beta.0 (2025-02-19)

Full Changelog: [v0.1.0-alpha.7...v0.1.0-beta.0](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-alpha.7...v0.1.0-beta.0)

### Features

* add basic examples ([97996bc](https://github.com/turbopuffer/turbopuffer-java/commit/97996bc5758ab8d7806762cb3ecc91015d42cbf7))


### Bug Fixes

* disable configuration cache ([47e035b](https://github.com/turbopuffer/turbopuffer-java/commit/47e035ba7ddbdbe815e8e5f77b1e9347596c91af))

## 0.1.0-alpha.7 (2025-02-19)

Full Changelog: [v0.1.0-alpha.6...v0.1.0-alpha.7](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-alpha.6...v0.1.0-alpha.7)

### Features

* **api:** manual updates ([#23](https://github.com/turbopuffer/turbopuffer-java/issues/23)) ([fb02ee5](https://github.com/turbopuffer/turbopuffer-java/commit/fb02ee580167157b69a9168cd653b5b80f73ed65))
* **api:** manual updates ([#25](https://github.com/turbopuffer/turbopuffer-java/issues/25)) ([9d6aced](https://github.com/turbopuffer/turbopuffer-java/commit/9d6acede697cf6db35d5a7e02ca71d74ab4928fb))
* **api:** manual updates ([#26](https://github.com/turbopuffer/turbopuffer-java/issues/26)) ([bba904f](https://github.com/turbopuffer/turbopuffer-java/commit/bba904f3a29bccadb9d46ef94e41c851ee1c8783))
* **api:** manual updates ([#27](https://github.com/turbopuffer/turbopuffer-java/issues/27)) ([b6d6066](https://github.com/turbopuffer/turbopuffer-java/commit/b6d6066e672f7a9fe0a223f21f900781edd9c318))

## 0.1.0-alpha.6 (2025-02-19)

Full Changelog: [v0.1.0-alpha.5...v0.1.0-alpha.6](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-alpha.5...v0.1.0-alpha.6)

### Features

* **api:** manual updates ([#18](https://github.com/turbopuffer/turbopuffer-java/issues/18)) ([094f313](https://github.com/turbopuffer/turbopuffer-java/commit/094f31306eb7fcaadc61dd0ba4b9de1d3d79affa))
* **api:** manual updates ([#20](https://github.com/turbopuffer/turbopuffer-java/issues/20)) ([ff70f49](https://github.com/turbopuffer/turbopuffer-java/commit/ff70f496e8e6310a1949bdbc3ffaa6d7fb2839a1))
* **api:** manual updates ([#21](https://github.com/turbopuffer/turbopuffer-java/issues/21)) ([a7a1afa](https://github.com/turbopuffer/turbopuffer-java/commit/a7a1afa5a4ffdb231382a03f3c452b95438b29da))

## 0.1.0-alpha.5 (2025-02-19)

Full Changelog: [v0.1.0-alpha.4...v0.1.0-alpha.5](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-alpha.4...v0.1.0-alpha.5)

### Features

* **api:** manual updates ([#15](https://github.com/turbopuffer/turbopuffer-java/issues/15)) ([cdbe40d](https://github.com/turbopuffer/turbopuffer-java/commit/cdbe40d06c35e0bcbe2bb992be81dff5739abe32))

## 0.1.0-alpha.4 (2025-02-19)

Full Changelog: [v0.1.0-alpha.3...v0.1.0-alpha.4](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-alpha.3...v0.1.0-alpha.4)

### Features

* **api:** manual updates ([#12](https://github.com/turbopuffer/turbopuffer-java/issues/12)) ([584d4e5](https://github.com/turbopuffer/turbopuffer-java/commit/584d4e57b27091c29ca8304861a057d42e9b3ab6))

## 0.1.0-alpha.3 (2025-02-19)

Full Changelog: [v0.1.0-alpha.2...v0.1.0-alpha.3](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-alpha.2...v0.1.0-alpha.3)

### Features

* **api:** manual updates ([#9](https://github.com/turbopuffer/turbopuffer-java/issues/9)) ([c28c430](https://github.com/turbopuffer/turbopuffer-java/commit/c28c4306ef72ae1d370b7b8ddca5875f2b6441ab))

## 0.1.0-alpha.2 (2025-02-19)

Full Changelog: [v0.1.0-alpha.1...v0.1.0-alpha.2](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-alpha.1...v0.1.0-alpha.2)

### Features

* **api:** manual updates ([#4](https://github.com/turbopuffer/turbopuffer-java/issues/4)) ([cf9336b](https://github.com/turbopuffer/turbopuffer-java/commit/cf9336baa697db1a72df64260c153ccaf7bb4c03))
* **api:** manual updates ([#6](https://github.com/turbopuffer/turbopuffer-java/issues/6)) ([41d4cdd](https://github.com/turbopuffer/turbopuffer-java/commit/41d4cdd066112a976aef896d564dbe1f8ed2754d))
* **api:** manual updates ([#7](https://github.com/turbopuffer/turbopuffer-java/issues/7)) ([ddad4cd](https://github.com/turbopuffer/turbopuffer-java/commit/ddad4cdfa99877a1d21ecc85d0c50a39eef786af))

## 0.1.0-alpha.1 (2025-02-18)

Full Changelog: [v0.0.1-alpha.0...v0.1.0-alpha.1](https://github.com/turbopuffer/turbopuffer-java/compare/v0.0.1-alpha.0...v0.1.0-alpha.1)

### Features

* **api:** api update ([4619846](https://github.com/turbopuffer/turbopuffer-java/commit/461984624d7d371a92ee487c3fc185e90f179b4d))
* **api:** api update ([ca25b85](https://github.com/turbopuffer/turbopuffer-java/commit/ca25b85cd954820f3aeb87431ade2c30fd200e14))
* **api:** api update ([f33cca4](https://github.com/turbopuffer/turbopuffer-java/commit/f33cca4f78781f652ebad69b3305b0fe4ee6e8a6))
* **api:** update via SDK Studio ([665bece](https://github.com/turbopuffer/turbopuffer-java/commit/665bece6dc865c791685e5e492002df4ca254c6c))
* **client:** support `JsonField#asX()` for known values ([281cebe](https://github.com/turbopuffer/turbopuffer-java/commit/281cebed86180be520a26cd102d43e349e5263b4))
* **client:** update enum `asX` methods ([10fa897](https://github.com/turbopuffer/turbopuffer-java/commit/10fa8970ace64814937ff4bbace7fe2b02f23bc3))


### Chores

* go live ([#1](https://github.com/turbopuffer/turbopuffer-java/issues/1)) ([063341f](https://github.com/turbopuffer/turbopuffer-java/commit/063341f96cf9df2ff68ad3a8fb61b4bf4d5fbf80))
* **internal:** codegen related update ([bca5b83](https://github.com/turbopuffer/turbopuffer-java/commit/bca5b8393b8a58151cac5a4faf8aedcec6221570))
* **internal:** optimize build and test perf ([e2b2c10](https://github.com/turbopuffer/turbopuffer-java/commit/e2b2c10403e41e8a0ee3b2576bde9730c1cc5e82))
* **internal:** update formatter ([e2b2c10](https://github.com/turbopuffer/turbopuffer-java/commit/e2b2c10403e41e8a0ee3b2576bde9730c1cc5e82))
* **internal:** update some formatting in `Values.kt` ([281cebe](https://github.com/turbopuffer/turbopuffer-java/commit/281cebed86180be520a26cd102d43e349e5263b4))
