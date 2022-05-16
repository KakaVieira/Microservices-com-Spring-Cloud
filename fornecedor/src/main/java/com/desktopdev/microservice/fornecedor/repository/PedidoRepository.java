package com.desktopdev.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import com.desktopdev.microservice.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
