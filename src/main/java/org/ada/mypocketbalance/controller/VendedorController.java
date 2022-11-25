package org.ada.mypocketbalance.controller;
import org.ada.mypocketbalance.dto.VendedorDTO;
import org.ada.mypocketbalance.service.VendedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/vendedores")

public class VendedorController{

    private final VendedorService vendedorService;


    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @PostMapping
    public ResponseEntity create (@PathVariable Integer vendedorId,
                                  @RequestBody VendedorDTO vendedorDTO) {

      vendedorService.create(vendedorDTO,vendedorId);

        return new ResponseEntity(vendedorDTO.getId(), HttpStatus.CREATED);

    }
    @DeleteMapping("/{vendedorId}")
    public ResponseEntity delete(@PathVariable Integer vendedorId) {
        vendedorService.delete(vendedorId);
        return new ResponseEntity(HttpStatus.OK);

    }
}
