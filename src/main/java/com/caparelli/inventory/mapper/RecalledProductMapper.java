package com.caparelli.inventory.mapper;

import com.caparelli.inventory.dto.RecalledProductDTO;
import com.caparelli.inventory.entities.RecalledProduct;

public class RecalledProductMapper {
    private RecalledProductMapper() {
        // no content
    }
    public static RecalledProductDTO mapToDto(RecalledProduct vo) {
        return new RecalledProductDTO(vo.getId(), vo.getName(), vo.getExpired());
    }

    public static RecalledProduct mapToVo(RecalledProductDTO vo) {
        return new RecalledProduct(vo.getId(), vo.getName(), vo.getExpired());
    }
}
