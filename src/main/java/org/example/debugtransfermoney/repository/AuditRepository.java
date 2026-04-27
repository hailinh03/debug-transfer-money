package org.example.debugtransfermoney.repository;

import org.example.debugtransfermoney.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository  extends JpaRepository<AuditLog, Long> {
}
