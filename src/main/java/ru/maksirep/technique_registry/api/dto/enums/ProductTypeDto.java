package ru.maksirep.technique_registry.api.dto.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущности техники" +
        "COMPUTER - компьютеры" +
        "REFRIGERATOR - холодильники" +
        "SMARTPHONE - смартфоны" +
        "TELEVISION - телевизоры" +
        "VACUUM_CLEANER - пылесосы")
public enum ProductTypeDto {
    COMPUTER,
    REFRIGERATOR,
    SMARTPHONE,
    TELEVISION,
    VACUUM_CLEANER
}
