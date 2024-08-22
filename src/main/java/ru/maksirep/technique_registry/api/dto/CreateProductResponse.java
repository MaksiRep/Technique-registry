package ru.maksirep.technique_registry.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public final class CreateProductResponse {

    @Schema(description = "Идентификатор создаваемой техники",
            example = "1")
    private final int productId;

    public CreateProductResponse(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }
}