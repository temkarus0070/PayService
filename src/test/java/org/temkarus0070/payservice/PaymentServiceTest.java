package org.temkarus0070.payservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.temkarus0070.payservice.models.Order;
import org.temkarus0070.payservice.models.Status;

@SpringBootTest
public class PaymentServiceTest {
    private PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Test
    public void testCheckPaymentFunction() {
        Order order = new Order();
        Order proceedOrder = paymentService.checkPayment(order);
        Assertions.assertTrue(proceedOrder.getStatus() == Status.PURCHASED || proceedOrder.getStatus() == Status.CANCELLED);
    }
}
