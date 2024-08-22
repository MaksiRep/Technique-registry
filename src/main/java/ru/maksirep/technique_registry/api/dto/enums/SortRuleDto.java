package ru.maksirep.technique_registry.api.dto.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Фильтр на получение моделей" +
        "ASC - Получение списка в порядке возрастания" +
        "DESC - Получение списка в порядке убывания")
public enum SortRuleDto {
    ASC,
    DESC
}
