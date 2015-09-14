package com.realdolmen.course.persistence;

import com.realdolmen.course.domain.CreditCard;
import com.realdolmen.course.domain.CreditCardType;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

/**
 * Created by OCPAX79 on 14/09/2015.
 */
@Stateless
@Asynchronous
public class PaymentEJB {
    public Future<String> payByCreditCard(CreditCard creditCard) {
        String status = "Payment is being processed";
        //make a payment
        String number = creditCard.getNumber();
        CreditCardType type = creditCard.getType();
        //
        status = "Payment was successful";
        return new AsyncResult<>(status);
    }
}
