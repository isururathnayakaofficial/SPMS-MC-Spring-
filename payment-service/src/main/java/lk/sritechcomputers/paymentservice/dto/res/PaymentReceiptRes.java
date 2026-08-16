package lk.sritechcomputers.paymentservice.dto.res;

import lk.sritechcomputers.paymentservice.entity.PaymentMethod;
import lk.sritechcomputers.paymentservice.entity.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentReceiptRes {
    private Long paymentId;
    private String receiptNumber;
    private Long bookingId;
    private Long userId;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private String cardLast4;
    private PaymentStatus status;
    private LocalDateTime paidAt;
}
