# npm-reagent

A Leiningen template for creating useful and productive [Reagent](https://reagent-project.github.io/) apps in Clojure.

## Release 0.0.1

Leiningen Clojars dependency

```clojure
[org.clojars.nickbauman/npm-reagent "0.1.0"]  
```

## Installation 

To install it into your library cache - ~/.m2/repository/. 

From the root of the template project, run the following command:

```shell
lein install
````

## Local

To merely use this template locally, clone the repo and cd into it and just run

    lein new npm-reagent <project name>
    
This is the preferred way to hack away at the template itself and see the resulting project output.

## Usage

    lein new npm-reagent <project name>

Creates a new reagent project on disk under dir <project name> with a more 
traditional npm project layout.

## License

Copyright © 2019 Nick Bauman & Cirrus Machina

Distributed under the Eclipse Public License either version 1.0 or (at your 
option) any later version.
