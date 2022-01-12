package org.temkarus0070.payservice;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.temkarus0070.payservice.models.Order;

@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping(produces = "application/json", consumes = "application/json")
    public Order processPayment(@RequestBody(description = "order for payment", required = true, content = @Content(
            schema = @Schema(implementation = Order.class))) Order order) {
        return paymentService.checkPayment(order);
    }
}
