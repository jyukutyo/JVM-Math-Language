package jvmmathlang.truffle;

import java.math.BigInteger;

import com.oracle.truffle.api.dsl.TypeSystem;
import nodes.JvmMathLangFunction;

@TypeSystem({long.class, BigInteger.class, JvmMathLangFunction.class})
public abstract class JvmMathLangTypes {
}
