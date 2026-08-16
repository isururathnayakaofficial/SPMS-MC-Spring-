package lk.sritechcomputers.paymentservice.dto.res;

import lk.sritechcomputers.paymentservice.entity.PaymentMethod;
import lk.sritechcomputers.paymentservice.entity.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PaymentDetailsRes {
    private Long id;
    private Long bookingId;
    private Long userId;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private String cardLast4;
    private PaymentStatus status;
    private String receiptNumber;
    private LocalDateTime paidAt;
    private LocalDateTime updatedAt;
}
