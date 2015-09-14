package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.Passenger;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by OCPAX79 on 14/09/2015.
 */
public class PaymentEJBTest extends DataSetPersistenceTest {
    @Test
    public void payByCreditCardCanBePersisted() throws ExecutionException, InterruptedException {
        Passenger passenger = entityManager().find(Passenger.class, 1000l);
        assertNotNull(passenger.getCreditCards());
        PaymentEJB paymentEJB = new PaymentEJB();
        Future<String> status = paymentEJB.payByCreditCard(passenger.getCreditCards().get(0));
        assertEquals("Payment was successful", status.get());
    }
}
