package lk.sritechcomputers.paymentservice.dto.req;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lk.sritechcomputers.paymentservice.entity.PaymentMethod;
import lk.sritechcomputers.paymentservice.entity.PaymentStatus;

import java.math.BigDecimal;

public class PaymentUpdateReq {
    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotNull(message = "Payment method is required")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Status is required")
    private PaymentStatus status;
}
