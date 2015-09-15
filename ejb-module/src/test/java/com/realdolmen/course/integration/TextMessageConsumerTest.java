package com.realdolmen.course.integration;

import org.junit.Test;

public class TextMessageConsumerTest extends RemoteJmsTest {
    @Test
    public void produceTextMessage() throws Exception {
        //producer.send(session.createTextMessage("Hello World!"));
        producer.send(session.createTextMessage(String.format(
                "%d,%f\n%d,%f\nnull,%f,%d,%d\nnull,%f,%d,%d\nnull,%f,%d,%d\nnull,%f,%d,%d\n",
                1000l, 30.0,
                2000l, 40.0,
                30.0, 1000l, 1000l,
                40.0, 2000l, 2000l,
                40.0, 1000l, 2000l,
                35.0, 2000l, 1000l)));
    }
}
