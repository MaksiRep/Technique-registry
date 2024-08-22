package ru.maksirep.technique_registry.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import ru.maksirep.technique_registry.api.ApiPaths;
import ru.maksirep.technique_registry.api.dto.CreateProductRequest;
import ru.maksirep.technique_registry.api.dto.CreateProductResponse;
import ru.maksirep.technique_registry.api.dto.FullProductDto;
import ru.maksirep.technique_registry.api.dto.enums.ProductTypeDto;
import ru.maksirep.technique_registry.core.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Создание техники")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Создает элемент техники и возвращает идентификатор")})
    @PostMapping(ApiPaths.PRODUCT)
    public CreateProductResponse createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        return new CreateProductResponse(productService.createProduct(createProductRequest));
    }

    @Operation(summary = "Получение списка всех моделей техники с фильтрацией. " +
            "Если поле null - то оно не принимает участия в фильтрации. " +
            "Если все поля null - произойдет вывод всех сущностей без фильтрации")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Возвращает список моделей")})
    @GetMapping(ApiPaths.PRODUCT)
    public List<FullProductDto> filterModels(
            @Parameter(
                    name = "productTypeDto",
                    description = "Указывает, с каким видом техники будет происходить работа: с конкретным или всеми")
            @RequestParam(required = false) ProductTypeDto productTypeDto,
            @Parameter(
                    name = "name",
                    description = "Фильтр по названию техники")
            @RequestParam(required = false) String name,
            @Parameter(
                    name = "country",
                    description = "Фильтр по стране производителе техники")
            @RequestParam(required = false) String country,
            @Parameter(
                    name = "manufacturer",
                    description = "Фильтр по фирме производителе техники")
            @RequestParam(required = false) String manufacturer,
            @Parameter(
                    name = "isOnline",
                    description = "Фильтр на возможность онлайн заказа техники")
            @RequestParam(required = false) Boolean isOnline,
            @Parameter(
                    name = "isInstallment",
                    description = "Фильтр на возможность рассрочки техники")
            @RequestParam(required = false) Boolean isInstallment,
            @Parameter(
                    name = "color",
                    description = "Фильтр по цвету модели")
            @RequestParam(required = false) String color,
            @Parameter(
                    name = "priceFrom",
                    description = "Фильтр по минимальной цене модели")
            @RequestParam(required = false) Integer priceFrom,
            @Parameter(
                    name = "priceTo",
                    description = "Фильтр по максимальной цене модели")
            @RequestParam(required = false) Integer priceTo,
            @Parameter(
                    name = "modelName",
                    description = "Фильтр по названию модели")
            @RequestParam(required = false) String modelName,
            @Parameter(
                    name = "serialNumber",
                    description = "Фильтр по серийному номеру модели")
            @RequestParam(required = false) String serialNumber,
            @Parameter(
                    name = "size",
                    description = "Фильтр по размеру модели")
            @RequestParam(required = false) String size,
            @Parameter(
                    name = "isOnStock",
                    description = "Фильтр на наличию модели на складе")
            @RequestParam(required = false) Boolean isOnStock,
            @Parameter(
                    name = "category",
                    description = "Фильтр по категории компьютера. " +
                            "Фильтр сработает только при указанном productTypeDto = \"COMPUTER\"")
            @RequestParam(required = false) String category,
            @Parameter(
                    name = "processorType",
                    description = "Фильтр по типу процессора компьютера. " +
                            "Фильтр сработает только при указанном productTypeDto = \"COMPUTER\"")
            @RequestParam(required = false) String processorType,
            @Parameter(
                    name = "numberOfDoors",
                    description = "Фильтр по количеству дверей холодильника. " +
                            "Фильтр сработает только при указанном productTypeDto = \"REFRIGERATOR\"")
            @RequestParam(required = false) Integer numberOfDoors,
            @Parameter(
                    name = "compressorType",
                    description = "Фильтр по типу компрессора холодильника. " +
                            "Фильтр сработает только при указанном productTypeDto = \"REFRIGERATOR\"")
            @RequestParam(required = false) String compressorType,
            @Parameter(
                    name = "memory",
                    description = "Фильтр по количеству памяти смартфона. " +
                            "Фильтр сработает только при указанном productTypeDto = \"SMARTPHONE\"")
            @RequestParam(required = false) Integer memory,
            @Parameter(
                    name = "numberOfCameras",
                    description = "Фильтр по количеству камер смартфона. " +
                            "Фильтр сработает только при указанном productTypeDto = \"SMARTPHONE\"")
            @RequestParam(required = false) Integer numberOfCameras,
            @Parameter(
                    name = "tvCategory",
                    description = "Фильтр по категории телевизора. " +
                            "Фильтр сработает только при указанном productTypeDto = \"TELEVISION\"")
            @RequestParam(required = false) String tvCategory,
            @Parameter(
                    name = "technology",
                    description = "Фильтр по технологии телевизора. " +
                            "Фильтр сработает только при указанном productTypeDto = \"TELEVISION\"")
            @RequestParam(required = false) String technology,
            @Parameter(
                    name = "technology",
                    description = "Фильтр по объему пылесборника пылесоса. " +
                            "Фильтр сработает только при указанном productTypeDto = \"VACUUM_CLEANER\"")
            @RequestParam(required = false) Integer dustBagVolume,
            @Parameter(
                    name = "technology",
                    description = "Фильтр по количеству режимов пылесоса. " +
                            "Фильтр сработает только при указанном productTypeDto = \"VACUUM_CLEANER\"")
            @RequestParam(required = false) Integer numberOfModes
    ) {
        return productService.filterProducts(name, country, manufacturer, isOnline, isInstallment,
                productTypeDto, color, priceFrom, priceTo, modelName, serialNumber, size,
                isOnStock, category, processorType, numberOfDoors, compressorType, memory,
                numberOfCameras, tvCategory, technology, dustBagVolume, numberOfModes);
    }
}
