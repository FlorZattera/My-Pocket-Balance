package org.ada.mypocketbalance.controller;


import org.ada.mypocketbalance.dto.ProductoDTO;
import org.ada.mypocketbalance.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Producto")

public class ProductoController {

        private final ProductoService productoService;

        public ProductoController(ProductoService productoService) {
            this.productoService = productoService;
        }

    @GetMapping
    public ResponseEntity retrieve() {
        return new ResponseEntity(productoService.retrieveAll(), HttpStatus.OK);
    }


    @GetMapping("/{productoId}")
    public ResponseEntity retrieveById(@PathVariable Integer productoId) {
        try {
            ProductoDTO productoDTO = productoService.retrieveById(productoId);

            return new ResponseEntity(productoDTO, HttpStatus.OK);

        } catch (Exception e){

            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }


    }

    }
