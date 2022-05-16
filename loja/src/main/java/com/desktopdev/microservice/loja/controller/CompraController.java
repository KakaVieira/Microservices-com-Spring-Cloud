package com.desktopdev.microservice.loja.controller;

import com.desktopdev.microservice.loja.model.Compra;
import com.desktopdev.microservice.loja.model.dto.CompraDTO;
import com.desktopdev.microservice.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDTO compra){
        return compraService.realizaCompra(compra);

    }

}
