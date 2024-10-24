package com.cibertec.repository;

import com.cibertec.model.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtencionRepository extends JpaRepository<Atencion, Long> {
}