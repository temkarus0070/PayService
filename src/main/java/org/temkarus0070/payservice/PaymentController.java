package org.temkarus0070.payservice;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.temkarus0070.payservice.models.Order;

@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "order for payment", required = true, content = @Content(
            schema = @Schema(implementation = Order.class))))
    @PostMapping(produces = "application/json", consumes = "application/json")
    public Order processPayment(@RequestBody Order order) {
        return paymentService.checkPayment(order);
    }
}
