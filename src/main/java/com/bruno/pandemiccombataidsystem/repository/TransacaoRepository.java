package com.bruno.pandemiccombataidsystem.repository;

import com.bruno.pandemiccombataidsystem.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
