package nodes.literal;

import java.math.BigDecimal;

import com.oracle.truffle.api.interop.ForeignAccess;
import com.oracle.truffle.api.interop.TruffleObject;

public class BigDecimalTruffleObject implements TruffleObject {
    private final BigDecimal value;

    public BigDecimalTruffleObject(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public ForeignAccess getForeignAccess() {
        return null;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}
