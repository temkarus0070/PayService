package org.temkarus0070.payservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.temkarus0070.payservice.models.Order;

@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }


    @PostMapping
    public Order getPay(@RequestBody() Order order) {
        return paymentService.checkPayment(order);
    }
}
