package com.bruno.pandemiccombataidsystem.repository;

import com.bruno.pandemiccombataidsystem.model.Hospital;
import com.bruno.pandemiccombataidsystem.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecursosRepository extends JpaRepository<Recurso, Long> {

    Optional<Recurso> findByCnpj(Long cnpj);
}
