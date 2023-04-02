# krotoDC

krotoDC is a protoc plugin for generating Kotlin data classes and gRPC service/stub from a .proto input. This library makes it easy to work with Protocol Buffers and gRPC in your Kotlin projects.

## Features

- Generates Kotlin data classes from .proto files
- Generates Converter extension methods between generated classes and GeneratedMessageV3 classes
- Generates gRPC service/stub based on the service definition in .proto files
- Supports Kotlin specific features like nullable fields and sealed oneof classes: 

  see the generated code spec [here](https://github.com/mscheong01/krotoDC/blob/main/generator/README.md)

## Installation

In your project's `build.gradle.kts` file, add the following dependencies:

```kotlin
dependencies {
    implementation("com.google.protobuf:protobuf-java:3.22.2")
    implementation("io.grpc:grpc-stub:1.54.0")
    implementation("io.grpc:grpc-kotlin-stub:1.3.0")
    implementation("io.github.mscheong01:krotoDC-core:1.0.0
}
```

## Usage

1. Configure the protobuf plugin in your `build.gradle.kts` file:

```kotlin
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.22.0"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.54.0"
        }
        id("krotoDC") {
            artifact = "io.github.mscheong01:protoc-gen-krotoDC:1.0.0:jdk8@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("krotoDC")
            }
        }
    }
}
```

2. Create your `.proto` files with your message and service definitions.

3. Build your project, and the plugin will generate Kotlin data classes and gRPC service/stub based on the `.proto` files.

## Snapshot Versions
krotoDC provides snapshot versions that are automatically released when changes are pushed to the main branch. 
The current snapshot version is the next minor version of the current release version with a -SNAPSHOT suffix. 
For example, if the current release is 1.2.3, the snapshot version will be 1.3.0-SNAPSHOT.

## Contributing

Contributions are welcome! Please see our [contributing guidelines](https://github.com/mscheong01/krotoDC/blob/main/CONTRIBUTING.md) for more information.

## License

This project is licensed under the [Apache 2.0 License](https://github.com/mscheong01/krotoDC/blob/main/LICENSE).
