package com.bruno.pandemiccombataidsystem.repository;

import com.bruno.pandemiccombataidsystem.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    Optional<Hospital> findByCnpj(Long cnpj);
}
