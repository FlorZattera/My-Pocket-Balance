package org.ada.mypocketbalance.service;

import org.ada.mypocketbalance.repository.VendedorRepository;

public class VendedorService {

    private final VendedorRepository vendedorRepository;


    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }
}
