package com.codetogether.openstudio.repository;

import com.codetogether.openstudio.domain.Pool;
import com.codetogether.openstudio.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r FROM Reservation r " +
            "JOIN FETCH r.pool p " +
            "JOIN FETCH p.subject s " +
            "JOIN FETCH r.member m " +
            "WHERE p.closedAt > :#{#currentTime} " +
            "AND " +
            "p.createdAt < :#{#currentTime}")
    List<Reservation> findByDateBetween(@Param("currentTime") LocalDateTime date);

    @Query("SELECT r FROM Reservation r " +
            "JOIN FETCH r.pool p " +
            "JOIN FETCH r.member m " +
            "ORDER BY r.id DESC")
    List<Reservation> findAllDesc();
}
