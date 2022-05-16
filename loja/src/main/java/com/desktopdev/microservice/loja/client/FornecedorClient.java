package com.desktopdev.microservice.loja.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.desktopdev.microservice.loja.model.dto.InfoFornecedorDTO;
import com.desktopdev.microservice.loja.model.dto.InfoPedidoDTO;
import com.desktopdev.microservice.loja.model.dto.ItemDaCompraDTO;


@FeignClient("fornecedor")
public interface FornecedorClient {
	
	@RequestMapping("/info/{estado}")
	InfoFornecedorDTO getInfoPorEstado(@PathVariable("estado") String estado);
	
	@RequestMapping(method = RequestMethod.POST, value = "/pedido")
	InfoPedidoDTO realizaPedido(List<ItemDaCompraDTO> itens);
	
}
