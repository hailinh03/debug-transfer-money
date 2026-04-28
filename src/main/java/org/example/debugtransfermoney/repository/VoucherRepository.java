package org.example.debugtransfermoney.repository;

import org.example.debugtransfermoney.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {

//    @Modifying
//    @Query("UPDATE Voucher v SET v.remainingQuantity = v.remainingQuantity - 1 " +
//            "WHERE v.id = :id AND v.remainingQuantity > 0")
   // int decrementIfAvailable(@Param("id") Long id);
}
