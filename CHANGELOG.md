# Changelog

## 0.1.0-beta.13 (2025-06-23)

Full Changelog: [v0.1.0-beta.12...v0.1.0-beta.13](https://github.com/turbopuffer/turbopuffer-java/compare/v0.1.0-beta.12...v0.1.0-beta.13)

### ⚠ BREAKING CHANGES

* **client:** change precision of some numeric types
* **client:** extract auto pagination to shared classes
* **client:** **Migration:** - If you were referencing the `AutoPager` class on a specific `*Page` or `*PageAsync` type, then you should instead reference the shared `AutoPager` and `AutoPagerAsync` types, under the `core` package
    - `AutoPagerAsync` now has different usage. You can call `.subscribe(...)` on the returned object instead to get called back each page item. You can also call `onCompleteFuture()` to get a future that completes when all items have been processed. Finally, you can call `.close()` on the returned object to stop auto-paginating early
    - If you were referencing `getNextPage` or `getNextPageParams`:
       - Swap to `nextPage()` and `nextPageParams()`
       - Note that these both now return non-optional types (use `hasNextPage()` before calling these, since they will throw if it's impossible to get another page)

### Features

* **api:** api update ([cd4b7a8](https://github.com/turbopuffer/turbopuffer-java/commit/cd4b7a89441ccb5f65bd1315c7a9780b24ce1a58))
* **api:** api update ([c5bc33e](https://github.com/turbopuffer/turbopuffer-java/commit/c5bc33ecbc09e1038266a733dc4ccb84bf6ec6b1))
* **api:** api update ([921a2c3](https://github.com/turbopuffer/turbopuffer-java/commit/921a2c3289830f583943110a49bc43c58d740882))
* **api:** api update ([7f8960a](https://github.com/turbopuffer/turbopuffer-java/commit/7f8960a36c1585abedfe3b22ffdd15e0457ec8b8))
* **api:** api update ([77c3d0d](https://github.com/turbopuffer/turbopuffer-java/commit/77c3d0d808fca4ba2d1264110fe0fe166c93fc72))
* **api:** api update ([3b19afc](https://github.com/turbopuffer/turbopuffer-java/commit/3b19afcaec61ccaa28d51ebbc4ee99c6c2817d2e))
* **api:** api update ([184551c](https://github.com/turbopuffer/turbopuffer-java/commit/184551c409556a6fed82274916c8fa33cdbdc34b))
* **api:** api update ([b6e2c8b](https://github.com/turbopuffer/turbopuffer-java/commit/b6e2c8bafb270de93c3eb86047ee4b3f8733efb3))
* **api:** api update ([c6fc6ee](https://github.com/turbopuffer/turbopuffer-java/commit/c6fc6ee14e1e9397b937fc6ecec4f89bf0a20b70))
* **api:** api update ([cc3f8c5](https://github.com/turbopuffer/turbopuffer-java/commit/cc3f8c5af0b02c4ad8700ab96b66a63af1045a19))
* **api:** api update ([c88b841](https://github.com/turbopuffer/turbopuffer-java/commit/c88b841bdf69561c58deba1ef86b945e2952e205))
* **api:** api update ([c68e0c0](https://github.com/turbopuffer/turbopuffer-java/commit/c68e0c0eaf36c3cc11d5d428b20fa6979394b6ac))
* **api:** api update ([a6c5062](https://github.com/turbopuffer/turbopuffer-java/commit/a6c506264a28d3e8201ab721d339a96a788de9e1))
* **api:** api update ([83faa64](https://github.com/turbopuffer/turbopuffer-java/commit/83faa6495cf1bd80fca932b737a5615eb01a121f))
* **api:** api update ([311c2bf](https://github.com/turbopuffer/turbopuffer-java/commit/311c2bf8ec9701519fac9591acefd74e3459e088))
* **api:** api update ([7db796a](https://github.com/turbopuffer/turbopuffer-java/commit/7db796a3adf089646346b8cc545962d9f050e1fe))
* **api:** api update ([32c0935](https://github.com/turbopuffer/turbopuffer-java/commit/32c0935850b362387f831f870bc74ef560d8621a))
* **api:** api update ([feee1ee](https://github.com/turbopuffer/turbopuffer-java/commit/feee1ee85043439180f11a16eec1891ac81ec68a))
* **api:** api update ([9e09cdd](https://github.com/turbopuffer/turbopuffer-java/commit/9e09cdd483e20d93720a67e9dc30918542534e66))
* **api:** api update ([2d738b7](https://github.com/turbopuffer/turbopuffer-java/commit/2d738b79158413f077315e63895b8f1d72c08e5f))
* **api:** api update ([c7e436e](https://github.com/turbopuffer/turbopuffer-java/commit/c7e436ecb21b5aa9d4281f850a3837322d1c917f))
* **api:** api update ([a0a55cf](https://github.com/turbopuffer/turbopuffer-java/commit/a0a55cf1c87f29bc9aff88af0b73d9371ef49e80))
* **api:** api update ([c08705d](https://github.com/turbopuffer/turbopuffer-java/commit/c08705db0081b5df447e67ff771424c3b2562d55))
* **api:** api update ([29c5a57](https://github.com/turbopuffer/turbopuffer-java/commit/29c5a57521126c5c65abc2c64375d572e33f4ba1))
* **api:** api update ([019e341](https://github.com/turbopuffer/turbopuffer-java/commit/019e341fb908c00e9860e8dc37cd7a2a89e73d51))
* **api:** api update ([d6447d2](https://github.com/turbopuffer/turbopuffer-java/commit/d6447d27777630299b4cdc547fb7a028c105bf6d))
* **api:** api update ([acf22e7](https://github.com/turbopuffer/turbopuffer-java/commit/acf22e7fc98505fd1f0e58cf13b3561733cc3051))
* **api:** api update ([1eaca9c](https://github.com/turbopuffer/turbopuffer-java/commit/1eaca9c50a00524bc494b62695b4bcc348636646))
* **api:** api update ([1ed6002](https://github.com/turbopuffer/turbopuffer-java/commit/1ed6002b3f4d807bc8b3b916dacd389cd7f63830))
* **api:** api update ([dc25edd](https://github.com/turbopuffer/turbopuffer-java/commit/dc25edd49f0f28dc2bdc8f3882ddf6cc3e33b273))
* **api:** api update ([5a73088](https://github.com/turbopuffer/turbopuffer-java/commit/5a73088ca3524b55e266aff31eafa9b2a7148717))
* **api:** api update ([2803470](https://github.com/turbopuffer/turbopuffer-java/commit/280347055aa349e58711f86accb164d293faa1fc))
* **api:** api update ([3b3449b](https://github.com/turbopuffer/turbopuffer-java/commit/3b3449bfcdea377019283f8288512c06ef9a5a3c))
* **api:** api update ([95e50d7](https://github.com/turbopuffer/turbopuffer-java/commit/95e50d769f90be01dfde36e3bec56e3ab3a23ceb))
* **api:** api update ([6161f2a](https://github.com/turbopuffer/turbopuffer-java/commit/6161f2a386ebf79d80fd0f2b87be99a6f065abc0))
* **api:** api update ([b214e02](https://github.com/turbopuffer/turbopuffer-java/commit/b214e020ebaed3418171d7736b0a043ce7553373))
* **api:** api update ([40af4ca](https://github.com/turbopuffer/turbopuffer-java/commit/40af4cab102351461f8ff887cc1d3a00df963421))
* **api:** api update ([f8c693b](https://github.com/turbopuffer/turbopuffer-java/commit/f8c693b14f50df7553d9685327409ea62529ce3d))
* **api:** api update ([dd6a816](https://github.com/turbopuffer/turbopuffer-java/commit/dd6a81606d64cab9428516bd1cecd86edffca54e))
* **api:** api update ([e596462](https://github.com/turbopuffer/turbopuffer-java/commit/e5964623afdd73a482ba52b21bc399c28833e709))
* **api:** api update ([60cd6d4](https://github.com/turbopuffer/turbopuffer-java/commit/60cd6d44093c2402b5653c24e2a82c065e593aea))
* **api:** api update ([ca7a424](https://github.com/turbopuffer/turbopuffer-java/commit/ca7a424d9e186461b63bd4e8657f53b078fc7e66))
* **api:** api update ([5f11241](https://github.com/turbopuffer/turbopuffer-java/commit/5f11241b9a815a6e81bd5babbe31d4bab3bf67b7))
* **api:** api update ([165ff48](https://github.com/turbopuffer/turbopuffer-java/commit/165ff482a5ed566a28e30f32ccc22e88c3171bb2))
* **api:** api update ([40dc0ba](https://github.com/turbopuffer/turbopuffer-java/commit/40dc0ba5fed6db78b791b5c201b7b6f6aea5770b))
* **api:** api update ([f7a8daa](https://github.com/turbopuffer/turbopuffer-java/commit/f7a8daad924ff85a45d46717f10fcd08df55ab9e))
* **api:** api update ([6ca8625](https://github.com/turbopuffer/turbopuffer-java/commit/6ca86253eb5bbc3886311faaa00c7ffb86368d6a))
* **api:** api update ([70beb87](https://github.com/turbopuffer/turbopuffer-java/commit/70beb8757202d70966977fdd30ba0ca2a11ce6d6))
* **api:** api update ([06cb5f2](https://github.com/turbopuffer/turbopuffer-java/commit/06cb5f2d93c5fa53386a7267cc280c1405f693b9))
* **api:** api update ([78600e8](https://github.com/turbopuffer/turbopuffer-java/commit/78600e8479eeab5610ed4dc541f9a68faa8e2635))
* **api:** api update ([8c3a194](https://github.com/turbopuffer/turbopuffer-java/commit/8c3a194b4ac6c659809b05092af9dcd27f2f0f53))
* **api:** api update ([e597284](https://github.com/turbopuffer/turbopuffer-java/commit/e59728422c33d4f95a2cb5720718fb27fb5029fe))
* **api:** api update ([74dd1c0](https://github.com/turbopuffer/turbopuffer-java/commit/74dd1c093019af80d2c38cd172d2d1fb184d41d3))
* **api:** api update ([927ae7a](https://github.com/turbopuffer/turbopuffer-java/commit/927ae7a106496008aa59a686c46e19dd312549cd))
* **api:** introduce dedicated Query model ([aa60aee](https://github.com/turbopuffer/turbopuffer-java/commit/aa60aeea6c8aab7d80ef87f2419b31fbf9c82a4d))
* **api:** manual updates ([009b3db](https://github.com/turbopuffer/turbopuffer-java/commit/009b3db19f07fcc9fc138d3beb482cfff9d81751))
* **client:** add a `withOptions` method ([d5a6f94](https://github.com/turbopuffer/turbopuffer-java/commit/d5a6f94339f0b4b970ccae8dab7a2146f582da8a))
* **client:** allow providing some params positionally ([344112f](https://github.com/turbopuffer/turbopuffer-java/commit/344112f596308ed5b736c5b6231039718f77fc42))
* **client:** extract auto pagination to shared classes ([0f550ff](https://github.com/turbopuffer/turbopuffer-java/commit/0f550ff0e1309f98590ddf1da5d1d11a287b8287))
* **client:** implement per-endpoint base URL support ([8823ae6](https://github.com/turbopuffer/turbopuffer-java/commit/8823ae681b692fa1e8bd17a026593279f4da0084))


### Bug Fixes

* **api:** api update ([a1d3a3d](https://github.com/turbopuffer/turbopuffer-java/commit/a1d3a3dbf72d39b1fbf3d22a418a61dc3a334f86))
* **api:** api update ([f5480e5](https://github.com/turbopuffer/turbopuffer-java/commit/f5480e5d98b1e659ec0269181ea9ae917c6e1654))
* **client:** bump max requests per host to max requests (5 -&gt; 64) ([8b26a48](https://github.com/turbopuffer/turbopuffer-java/commit/8b26a485e2decec21ffa6cdd734f3fcadc1be27b))
* **client:** remove `@MustBeClosed` for future returning methods ([238ece0](https://github.com/turbopuffer/turbopuffer-java/commit/238ece0adc7a151758ce0302647f7df257066026))


### Chores

* **ci:** enable for pull requests ([dd82f55](https://github.com/turbopuffer/turbopuffer-java/commit/dd82f55a3fd8da9dfb058fb3ad5551f8f4a48452))
* **docs:** grammar improvements ([1fac5b5](https://github.com/turbopuffer/turbopuffer-java/commit/1fac5b518b4503f9d8f11767fe40d4c6d6a1b584))
* **internal:** remove flaky `-Xbackend-threads=0` option ([d008bcc](https://github.com/turbopuffer/turbopuffer-java/commit/d008bcc805d59e3f51d77b654ecbf93f7f1a60c7))
* **internal:** update java toolchain ([a6cb810](https://github.com/turbopuffer/turbopuffer-java/commit/a6cb810487172e3d0b788c4530e68bcbb7f27eac))


### Refactors

* **client:** change precision of some numeric types ([3ec093a](https://github.com/turbopuffer/turbopuffer-java/commit/3ec093af6430e5a0f561806b367a55239e9184ac))

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
