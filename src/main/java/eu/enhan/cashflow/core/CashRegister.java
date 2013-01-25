package eu.enhan.cashflow.core;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import org.joda.time.DateMidnight;

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
    private final DateMidnight date;


    public CashRegister(String name, ImmutableMap<BigDecimal, Integer> register, DateMidnight date) {
        this.name = Preconditions.checkNotNull(name);
        this.register = Preconditions.checkNotNull(register);
        this.date = Preconditions.checkNotNull(date);

    }

    public BigDecimal getTotalValue() {
        BigDecimal result = BigDecimal.ZERO;
        for(Map.Entry<BigDecimal, Integer> entry : register.entrySet()){
            result = result.add(entry.getKey().multiply(BigDecimal.valueOf(entry.getValue().longValue())));
        }
        return result ;
    }


    public DateMidnight getDate() {
        return date;
    }

}
