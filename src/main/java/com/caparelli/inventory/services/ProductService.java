package com.caparelli.inventory.services;

import com.caparelli.inventory.entities.Product;
import com.caparelli.inventory.entities.RecalledProduct;
import com.caparelli.inventory.helpers.ProductFilter;
import com.caparelli.inventory.repositories.InventoryRepository;
import com.caparelli.inventory.repositories.RecalledProductRepository;
import com.caparelli.inventory.utils.ValidatorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final InventoryRepository inventoryRepository;
    private final RecalledProductRepository recalledProductRepository;

    @Transactional
    public Product save(Product product) {
        return inventoryRepository.save(product);
    }

    public Collection<Product> getAllProduct() {
        final Set<String> productNames = recalledProductRepository
                .findAll()
                .stream()
                .filter(ProductService::isExpired) // excluding expired products
                .map(RecalledProduct::getName)
                .collect(Collectors.toSet());
        return new ProductFilter(productNames)
                .removeRecalledFrom(inventoryRepository.findAll());
    }

    private static boolean isExpired(RecalledProduct recalledProduct) {
        return ValidatorUtils.isTrue(recalledProduct.getExpired());
    }

    public Optional<Product> findById(Integer id) {
        return inventoryRepository.findById(id);
    }
}
