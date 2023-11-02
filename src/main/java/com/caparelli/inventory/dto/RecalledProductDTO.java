package com.caparelli.inventory.dto;


import lombok.Data;

@Data
public final class RecalledProductDTO {
    private final Integer id;
    private final String name;
    private final Boolean expired;

    public RecalledProductDTO(Integer id, String name, Boolean expired) {
        this.id = id;
        this.name = name;
        this.expired = expired;
    }
}
