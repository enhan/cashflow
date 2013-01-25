package eu.enhan.cashflow.core;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ENHAN
 * Date: 25/01/13
 * Time: 11:30
 * To change this template use File | Settings | File Templates.
 */
public class CashRegister {

    private final String name ;
    private final ImmutableMap<BigDecimal, Integer> register;


    public CashRegister(String name, ImmutableMap<BigDecimal, Integer> register) {
        this.name = Preconditions.checkNotNull(name);
        this.register = register;

    }

    public BigDecimal getTotalValue() {
        BigDecimal result = BigDecimal.ZERO;
        for(Map.Entry<BigDecimal, Integer> entry : register.entrySet()){
            result = result.add(entry.getKey().multiply(BigDecimal.valueOf(entry.getValue().longValue())));
        }
        return result ;
    }
}
