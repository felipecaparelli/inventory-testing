package com.caparelli.inventory.services;

import com.caparelli.inventory.entities.RecalledProduct;
import com.caparelli.inventory.repositories.RecalledProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecalledProductService {

    private final RecalledProductRepository recalledProductRepository;

    public RecalledProduct save(RecalledProduct recalledProduct) {
        return recalledProductRepository.save(recalledProduct);
    }

    public Collection<RecalledProduct> getAllRecalledProducts() {
        return recalledProductRepository.findAll();
    }

    public Optional<RecalledProduct> findById(Integer id) {
        return recalledProductRepository.findById(id);
    }
}
