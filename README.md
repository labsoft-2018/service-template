# labsoft-service

A Leiningen template for building micro-services using common-labsoft.

## Creating a project

```sh
$ lein new labsoft-service web-service
```

The generated project includes both a
`project.cl` (for [Leiningen](http://leiningen.org/)).

### Tasks

| Task                   |   Leiningen    |
|------------------------|----------------|
| Launch a REPL          | `lein repl`    |
| Run Tests              | `lein test`    |
| Launch a server        | `lein run`     |
| Build a deployable JAR | `lein uberjar` |

## Building a Docker container

```sh
# With Leiningen
$ lein uberjar

$ sudo docker build .
```
