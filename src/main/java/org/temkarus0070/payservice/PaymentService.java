package org.temkarus0070.payservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.temkarus0070.payservice.models.Order;
import org.temkarus0070.payservice.models.Status;

import java.util.Date;
import java.util.Random;

@Service
public class PaymentService {
    final Random random;

    public PaymentService() {
        this.random = new Random(new Date().getTime());
    }

    @Value("${payService.successProbability}")
    private double probability;

    public Order checkPayment(Order order) {

        double number = random.nextDouble();
        if (number < probability || Math.abs(probability - number) < 1e-10) {
            order.setStatus(Status.PURCHASED);
        } else {
            order.setStatus(Status.CANCELLED);
        }
        return order;
    }
}
