package com.caparelli.inventory.controllers;

import com.caparelli.inventory.dto.RecalledProductDTO;
import com.caparelli.inventory.entities.RecalledProduct;
import com.caparelli.inventory.mapper.RecalledProductMapper;
import com.caparelli.inventory.services.RecalledProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/inventory/recalled")
public class RecalledProductController {

    private final RecalledProductService recalledProductService;

    @GetMapping
    ResponseEntity<Collection<RecalledProductDTO>> findRecallProducts() {
        return ResponseEntity.ok(
                recalledProductService.getAllRecalledProducts()
                        .stream()
                        .map(RecalledProductMapper::mapToDto)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<RecalledProduct> createProduct(@RequestBody RecalledProductDTO recalledProduct) {
        return ResponseEntity.ok(recalledProductService.save(RecalledProductMapper.mapToVo(recalledProduct)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecalledProductDTO> updateProduct(@PathVariable Integer id, @RequestBody RecalledProductDTO recalledProduct) {
        Optional<RecalledProduct> byId = recalledProductService.findById(id);

        if (byId.isPresent()) {
            RecalledProduct toUpdate = byId.get();
            toUpdate.setExpired(recalledProduct.getExpired());
            return ResponseEntity.ok(RecalledProductMapper.mapToDto(recalledProductService.save(toUpdate)));
        }
        return ResponseEntity.notFound().build();
    }
}
