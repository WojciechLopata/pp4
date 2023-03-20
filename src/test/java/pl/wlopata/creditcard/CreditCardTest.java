package pl.wlopata.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    void itAllowsToAssignCreditLimit(){

        CreditCard card1 = new CreditCard("1234-5678");
        card1.assignLimit(BigDecimal.valueOf(1000));
        assert  card1.getBalance().equals(BigDecimal.valueOf(1000));

    }
    @Test
    void itAllowsToAssignDifferentCreditLimit(){

        CreditCard card1 = new CreditCard("1234-5678");
        card1.assignLimit(BigDecimal.valueOf(1000));
        assert  card1.getBalance().equals(BigDecimal.valueOf(1000));

        CreditCard card2 = new CreditCard("1234-5678");
        card2.assignLimit(BigDecimal.valueOf(1000));
        assert  card2.getBalance().equals(BigDecimal.valueOf(1000));
    }
    @Test
    void testDoubleAndFLoats(){
        double  x1=0.03;
        double  x2=0.01;
        double result=x1-x2;
        System.out.println(result);
    }
    @Test
    void itCantAssignimitBelow100v1(){
        CreditCard card=new CreditCard("1234-5678");
        try { card.assignLimit(BigDecimal.valueOf(50));
            fail("Should throw exception");

        }
        catch (CreditBelowThresholdException e){
            assertTrue(true);
        }

}
    @Test
    void itCantAssignimitBelow100v2(){
        CreditCard card1=new CreditCard("1234-5678");
        CreditCard card2=new CreditCard("1234-5678");
        CreditCard card3=new CreditCard("1234-5678");

        assertThrows(
                CreditBelowThresholdException.class,() -> card1.assignLimit(BigDecimal.valueOf(10)));

        assertThrows(
                CreditBelowThresholdException.class,() -> card2.assignLimit(BigDecimal.valueOf(99)));

    assertDoesNotThrow(
           () -> card3.assignLimit(BigDecimal.valueOf(100)));

    }
    @Test
    void itAllowsMultipleAssignments(){
        CreditCard card1=new CreditCard("1234-5678");
        assertDoesNotThrow(
                () -> card1.assignLimit(BigDecimal.valueOf(120)));
        assertThrows(LimitAssignedMultipleTimesException.class,()->card1.assignLimit(BigDecimal.valueOf(150)));



    }

    @Test
    void itAllowsToWithdraw(){
        CreditCard card1 = new CreditCard("1234-5678");
        card1.assignLimit(1000);
        card1.withdraw(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(900), card1.getBalance());
    }
}

