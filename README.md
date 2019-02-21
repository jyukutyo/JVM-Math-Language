# JVM Math language

## What is this?

An AST interpreter with Truffle. This program can execute four arithmetic operations. You can use numbers, +, -, *, /, "()", and "->" for running in another thread.

* Lexer, Parser: ANTLR 4.7
* AST Interpreter: Truffle 1.0.0-rc12

## Usage

Compile and run `jvmmathlang.truffle.JvmMathLangMain`. Note that this application uses Annotation Processor.

## Details

In DevoxxUS 2017 I heard Oleg Šelajev's "How to Create a New JVM Language". He doesn't publish his code, so I wrote code and created a similar language.

## Publishing

* GraalVMで使われている、他言語をJVM上に実装する仕組みを学ぼう(Japanese, a session at JJUG Night Seminar on 27th Feb 2019)

* オレオレJVM言語を作ってみる (Japanese, a session at JJUG CCC 2017 Fall on 18th Nov 2017)
https://www.slideshare.net/jyukutyo/jjug-ccc-2017-fall-jvm