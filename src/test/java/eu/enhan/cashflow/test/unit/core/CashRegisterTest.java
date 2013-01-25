package eu.enhan.cashflow.test.unit.core;

import eu.enhan.cashflow.core.CashRegister;
import eu.enhan.cashflow.core.CashRegisterBuilder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static eu.enhan.cashflow.core.CashRegisterBuilder.EuroValues.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: ENHAN
 * Date: 25/01/13
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class CashRegisterTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    /*
     * BUILDER TEST
     */

    @Test
    public void createWithoutANameShouldThrowIllegalStateException(){
        // Given
        CashRegisterBuilder registerBuilder = new CashRegisterBuilder();

        // Then
        exception.expect(IllegalStateException.class);

        // When
        registerBuilder.build();


    }

    @Test
    public void createWithNameReturnsNotNullInstance(){
        // Given
        CashRegisterBuilder registerBuilder = new CashRegisterBuilder();

        // When
        CashRegister register = registerBuilder.withName("Test").build() ;

        // Then
        assertNotNull(register);
    }

    @Test
    public void totalCountTest20(){
        // Given
        CashRegisterBuilder registerBuilder = new CashRegisterBuilder();
        CashRegister register = registerBuilder.withName("Test").withValueForItem(NOTE20,1).build();

        // When
        BigDecimal count = register.getTotalValue();

        // Then
        assertEquals(0, BigDecimal.valueOf(20).compareTo( count));
    }

    @Test
    public void totalCountTestCents(){
        // Given
        CashRegisterBuilder registerBuilder = new CashRegisterBuilder();
        CashRegister register = registerBuilder.withName("Test").withValueForItem(COIN001,3).withValueForItem(COIN005,1).build();

        // When
        BigDecimal count = register.getTotalValue();

        // Then
        assertEquals(0, BigDecimal.valueOf(0.08).compareTo( count));

    }



    /*
     *
     */

}
