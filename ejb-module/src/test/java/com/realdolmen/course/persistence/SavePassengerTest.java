package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.CreditCardType;
import com.realdolmen.course.domain.Passenger;
import com.realdolmen.course.persistence.DataSetPersistenceTest;
import com.realdolmen.course.persistence.SavePassenger;
import org.junit.Test;

/**
 * Created by OCPAX79 on 14/09/2015.
 */
public class SavePassengerTest extends DataSetPersistenceTest {
    @Test
    public void savePassengerCanBePersisted() {
        SavePassenger savePassenger = new SavePassenger();
        //omdat er hier new Passenger wordt gedaan, werkt entitymanager niet zomaar in savepassenger,
        //om dat te laten werken, moet je via lookup savePassenger aanroepen
        savePassenger.createPassenger("500-40", "olivier", "cappelle");
        savePassenger.addAddress("de burletlaan", "", "wilrijk", "2610", "belgie");
        savePassenger.addCreditCard("900-800-400", "05/18", 450, CreditCardType.MASTER);
        savePassenger.addTicket(20.50);
        Passenger passenger = savePassenger.checkOut();
        //entityManager().persist(passenger);
        entityManager().flush();
        assertNotNull(passenger);
        assertEquals(1, passenger.getCreditCards().size());
        assertEquals(1, passenger.getTickets().size());
        assertNotNull(passenger.getAddress());
    }
}
