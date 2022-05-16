package com.desktopdev.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desktopdev.microservice.loja.client.FornecedorClient;
import com.desktopdev.microservice.loja.model.Compra;
import com.desktopdev.microservice.loja.model.dto.CompraDTO;
import com.desktopdev.microservice.loja.model.dto.InfoFornecedorDTO;
import com.desktopdev.microservice.loja.model.dto.InfoPedidoDTO;

@Service
public class CompraService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompraService.class);

	@Autowired
	private FornecedorClient fornecedorClient;
	
    public Compra realizaCompra(CompraDTO compra) {
    	
    	final String estado = compra.getEndereco().getEstado();
    	
    	
    	LOG.info("Buscando informações do fornecedor de {}", estado);
    	InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
    	
    	LOG.info("Realizando um pedido ...");
    	InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
      

        System.out.println(info.getEndereco());
        
        Compra compraSalva = new Compra();
        compraSalva.setPedidoId(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());
        
        return compraSalva;
    }
}
