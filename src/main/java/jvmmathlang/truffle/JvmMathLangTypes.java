package jvmmathlang.truffle;

import com.oracle.truffle.api.dsl.TypeSystem;

/**
 * Type definition.
 *
 * <p>
 *     define only long so others are treated as general type.
 * </p>
 */
@TypeSystem(long.class)
public abstract class JvmMathLangTypes {
}
