package lk.sritechcomputers.paymentservice.repository;

import jakarta.persistence.LockModeType;
import lk.sritechcomputers.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentRepo extends CrudRepository<Payment, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT p FROM payment p WHERE p.id = :id")
    Optional<Payment> findByIdForUpdate(@Param("id") Long id);

    List<Payment> getAllByBookingId(Long bookingId);
    List<Payment> getAllByUserId(Long userId);
}
