# JVM Math language

## What is this?

This is a language implementation of simple arithmetic operations for GraalVM. You can install this language into your GraalVM.

Of course this is implemented with Truffle API. This program can execute four arithmetic operations. You can use numbers, +, -, *, /, "()". Additionally "->" for running in another thread.

* Lexer, Parser: ANTLR 4.7
* AST Interpreter: Truffle in GraalVM 20.3.0

## Usage

### Install

#### Local Install

Just run `mvn package` & `gu install -L target/jvmmathlang-0.1.0-component.jar`.
With `gu list`, you can see the JVM Math Lang component as follows.

```
$ gu list
ComponentId              Version             Component name      Origin
--------------------------------------------------------------------------------
js                       20.3.0              Graal.js
jvmmathlang              1.0.0               JVM Math Lang       github.com
graalvm                  20.3.0              GraalVM Core
```

#### From Component Catalog

I also provide the component catalog for this language. Just run `gu install -C https://raw.githubusercontent.com/jyukutyo/JVM-Math-Language/master/jvmmathlang-catalog-java11.properties jvmmathlang`. Currently it is only for GraalVM 20.3.0 and 20.2.0.

### Run Sample Code

```
$ cd example
$ javac Sample.java
$ java Sample
inputed String: (1+2)*3
add(long, long)
9
```

## Details

In DevoxxUS 2017 I heard Oleg Šelajev's "How to Create a New JVM Language". He doesn't publish his code, so I wrote code and created a similar language.

## Publishing

* GraalVMで使われている、他言語をJVM上に実装する仕組みを学ぼう (Japanese, a session at JJUG Night Seminar on 27th Feb 2019)
https://www.slideshare.net/jyukutyo/graalvmjvm

* オレオレJVM言語を作ってみる (Japanese, a session at JJUG CCC 2017 Fall on 18th Nov 2017)
https://www.slideshare.net/jyukutyo/jjug-ccc-2017-fall-jvm