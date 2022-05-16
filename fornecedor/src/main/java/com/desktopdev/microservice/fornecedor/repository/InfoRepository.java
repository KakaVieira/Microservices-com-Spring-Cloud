package com.desktopdev.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desktopdev.microservice.fornecedor.model.InfoFornecedor;

@Repository
public interface InfoRepository extends CrudRepository<InfoFornecedor, Long>{

	InfoFornecedor findByEstado(String estado);
}
