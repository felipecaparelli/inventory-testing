package com.caparelli.inventory.repositories;

import com.caparelli.inventory.entities.RecalledProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecalledProductRepository extends JpaRepository<RecalledProduct, Integer> {
}
