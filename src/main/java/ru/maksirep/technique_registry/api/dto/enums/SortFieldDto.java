package ru.maksirep.technique_registry.api.dto.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Фильтр на получение моделей" +
        "NAME - Получение списка по имени" +
        "PRICE - Получение списка по стоимости")
public enum SortFieldDto {
    NAME,
    PRICE
}
