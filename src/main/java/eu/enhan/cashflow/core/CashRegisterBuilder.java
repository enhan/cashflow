package eu.enhan.cashflow.core;

import com.google.common.collect.ImmutableMap;
import org.joda.time.DateMidnight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.*;

/**
 * Created with IntelliJ IDEA.
 * User: ENHAN
 * Date: 25/01/13
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
public class CashRegisterBuilder {



    public enum EuroValues {
        NOTE500(BigDecimal.valueOf(500)),
        NOTE200(BigDecimal.valueOf(200)),
        NOTE100(BigDecimal.valueOf(100)),
        NOTE50(BigDecimal.valueOf(50)),
        NOTE20(BigDecimal.valueOf(20)),
        NOTE10(BigDecimal.valueOf(10)),
        NOTE5(BigDecimal.valueOf(5)),
        COIN2(BigDecimal.valueOf(2)),
        COIN1(BigDecimal.valueOf(1)),
        COIN050(BigDecimal.valueOf(5,1)),
        COIN020(BigDecimal.valueOf(2,1)),
        COIN010(BigDecimal.valueOf(1,1)),
        COIN005(BigDecimal.valueOf(5,2)),
        COIN002(BigDecimal.valueOf(2,2)),
        COIN001(BigDecimal.valueOf(1,2));


        private final BigDecimal value;

        private EuroValues(BigDecimal value) {
            this.value = value;
        }

        public BigDecimal getValue() {
            return value;
        }
    }

    private String name;
    private DateMidnight date;

    private final Map<BigDecimal, Integer> cashMap;

    public CashRegisterBuilder() {
        cashMap = new HashMap<BigDecimal, Integer>();

        for(EuroValues v : EuroValues.values()){
            cashMap.put(v.getValue(), 0);
        }

        date = new DateMidnight();
    }

    public CashRegister build() {
        checkState(name != null);
        return new CashRegister(name, ImmutableMap.<BigDecimal, Integer>copyOf(cashMap), date);
    }

    public CashRegisterBuilder withName(String name) {
        this.name = checkNotNull(name);
        return this;
    }

   public CashRegisterBuilder withValueForItem(EuroValues item, int amount){
       this.cashMap.put(item.getValue(), amount);
       return this;
   }

    public CashRegisterBuilder withDate(DateMidnight dateMidnight) {
        this.date = checkNotNull(dateMidnight);
        return this;
    }

}
