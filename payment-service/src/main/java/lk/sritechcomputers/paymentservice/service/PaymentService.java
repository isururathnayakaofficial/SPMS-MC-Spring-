package lk.sritechcomputers.paymentservice.service;

import lk.sritechcomputers.paymentservice.dto.req.PaymentSaveReq;
import lk.sritechcomputers.paymentservice.dto.req.PaymentUpdateReq;
import lk.sritechcomputers.paymentservice.dto.res.PaymentDetailRes;
import lk.sritechcomputers.paymentservice.dto.res.PaymentReceiptRes;
import lk.sritechcomputers.paymentservice.dto.res.PaymentSummaryRes;

import java.util.List;

public interface PaymentService {
    List<PaymentSummaryRes> getAll();

    PaymentDetailRes getById(Long id);

    List<PaymentSummaryRes> getPaymentsByBookingId(Long bookingId);

    List<PaymentSummaryRes> getPaymentsByUserId(Long userId);

    PaymentDetailRes save(PaymentSaveReq req);

    PaymentDetailRes update(Long id, PaymentUpdateReq req);

    PaymentDetailRes update(Long id, PaymentUpdateReq req);

    void delete(Long id);

    PaymentReceiptRes pay(Long id);

    PaymentReceiptRes refund(Long id);

    PaymentReceiptRes getReceipt(Long id);
}
