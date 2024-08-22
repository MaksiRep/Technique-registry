package ru.maksirep.technique_registry.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.technique_registry.api.ApiPaths;
import ru.maksirep.technique_registry.api.dto.CreateModelRequest;
import ru.maksirep.technique_registry.api.dto.ModelDto;
import ru.maksirep.technique_registry.api.dto.enums.ProductTypeDto;
import ru.maksirep.technique_registry.api.dto.enums.SortFieldDto;
import ru.maksirep.technique_registry.api.dto.enums.SortRuleDto;
import ru.maksirep.technique_registry.core.service.ModelService;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Модели")
@Validated
@RestController
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @Operation(summary = "Создание модели для определенной техники")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ничего не возвращает, создает модель"),
            @ApiResponse(responseCode = "404", description = "Не найдено техники с указанным идентификатором"),
            @ApiResponse(responseCode = "500", description = "Некорректный серийный номер",
                    content = @Content(schema = @Schema(hidden = true)))})
    @PostMapping(ApiPaths.MODEL_BY_PRODUCT)
    public void createModel(
            @Parameter(
                    name = "id",
                    description = "Идентификатор техники, для которой создается модель")
            @RequestParam int id,
            @Parameter(
                    name = "productTypeDto",
                    description = "Тип техники, для которого будет создана модель")
            @Valid @RequestParam ProductTypeDto productTypeDto,
            @Valid @RequestBody CreateModelRequest createModelRequest) {
        modelService.createModel(
                id,
                productTypeDto,
                createModelRequest);
    }

    @Operation(summary = "Получение списка всех моделей техники с фильтрацией по имени или стоимости в указанном порядке")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Возвращает список моделей")})
    @GetMapping(ApiPaths.MODEL)
    public List<ModelDto> sortModels(
            @Parameter(
                    name = "sortRuleDto",
                    description = "Указывает в порядке убывания или возрастания будет предоставлен список")
            @RequestParam SortRuleDto sortRuleDto,
            @Parameter(
                    name = "sortFieldDto",
                    description = "Указывает по какому полю будет происходить фильтрация: по названию или стоимости")
            @RequestParam SortFieldDto sortFieldDto) {
        return modelService.sortModels(sortRuleDto, sortFieldDto);
    }
}