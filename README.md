# JVM Math language

## what is this?

An AST interpreter with Truffle. This program can execute four arithmetic operations. You can use numbers, +, -, *, /, "()", and "->" for running in another thread.

* Lexer, Parser: ANTLR
* AST Interpreter: Truffle

## usage

compile and run `jvmmathlang.truffle.JvmMathLangMain`. Note that this uses Annotation Processor.

## details

In DevoxxUS 2017 I heard Oleg Šelajev's "How to Create a New JVM Language". He doesn't publish his code, so I wrote code and created the language that he introduced in the session.

It uses ANTLR 4.7 and Truffle 0.29.

## Publishing

* オレオレJVM言語を作ってみる (Japanese, a session at JJUG CCC 2017 Fall on 18th Nov 2017)
https://www.slideshare.net/jyukutyo/jjug-ccc-2017-fall-jvm