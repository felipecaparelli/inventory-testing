package com.caparelli.inventory.helpers;

import com.caparelli.inventory.entities.Product;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductFilter {

    private final Set<String> recalledProducts;

    public ProductFilter(Set<String> recalledProducts) {
        this.recalledProducts = recalledProducts;
    }

    public List<Product> removeRecalledFrom(Collection<Product> allProduct) {
        return allProduct
                .stream()
                .filter(it -> ProductFilter.filterByName(it, recalledProducts))
                .collect(Collectors.toList());
    }

    private static boolean filterByName(Product product, Set<String> recalledProducts) {
        return !recalledProducts.contains(product.getName());
    }
}
