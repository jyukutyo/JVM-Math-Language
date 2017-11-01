# JVM Math language

## usage

compile and run `jvmmathlang.truffle.JvmMathLangMain`. Note that this uses Annotation Processor.

## what is this?

This program can only execute four arithmetic operations. You can use numbers, +, -, *, /, and "->" for running in another thread.

## details

In DevoxxUS 2017 I heard Oleg Šelajev's "How to Create a New JVM Language". He doesn't publish his code, so I wrote code and created the language that he introduced in the session.

It uses ANTLR 4.7 and Truffle 0.29.