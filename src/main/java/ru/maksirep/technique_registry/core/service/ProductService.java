package ru.maksirep.technique_registry.core.service;

import org.springframework.stereotype.Service;
import ru.maksirep.technique_registry.api.dto.CreateProductRequest;
import ru.maksirep.technique_registry.api.dto.FullProductDto;
import ru.maksirep.technique_registry.api.dto.enums.ProductTypeDto;
import ru.maksirep.technique_registry.core.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public int createProduct(CreateProductRequest createProductRequest) {
        return productRepository.createProduct(
                createProductRequest.getName(),
                createProductRequest.getCountry(),
                createProductRequest.getManufacturer(),
                createProductRequest.isOnline(),
                createProductRequest.isInstallment()
        );
    }

    public boolean isProductExistById(int id) {
        return productRepository.isProductExistById(id);
    }

    public List<FullProductDto> filterProducts(String name, String country, String manufacturer, Boolean isOnline,
                                               Boolean isInstallment, ProductTypeDto productTypeDto, String color,
                                               Integer priceFrom, Integer priceTo, String modelName, String serialNumber,
                                               String size, Boolean isOnStock, String category, String processorType,
                                               Integer numberOfDoors, String compressorType, Integer memory, Integer numberOfCameras,
                                               String tvCategory, String technology, Integer dustBagVolume, Integer numberOfModes) {
        return productRepository.filterProducts(name, country, manufacturer, isOnline, isInstallment,
                        productTypeDto == null ? null : productTypeDto.name(), color, priceFrom, priceTo, modelName, serialNumber,
                        size, isOnStock, category, processorType, numberOfDoors, compressorType,
                        memory, numberOfCameras, tvCategory, technology, dustBagVolume, numberOfModes).stream()
                .map(tuple -> new FullProductDto(
                        tuple.get(0, Integer.class),
                        tuple.get(1, String.class),
                        tuple.get(2, String.class),
                        tuple.get(3, String.class),
                        tuple.get(4, Boolean.class),
                        tuple.get(5, Boolean.class),
                        tuple.get(6, String.class),
                        tuple.get(7, String.class),
                        tuple.get(8, String.class),
                        tuple.get(9, String.class),
                        tuple.get(10, Integer.class),
                        tuple.get(11, Boolean.class),
                        tuple.get(12, String.class),
                        tuple.get(13, String.class),
                        tuple.get(14, Integer.class),
                        tuple.get(15, String.class),
                        tuple.get(16, Integer.class),
                        tuple.get(17, Integer.class),
                        tuple.get(18, String.class),
                        tuple.get(19, String.class),
                        tuple.get(20, Integer.class),
                        tuple.get(21, Integer.class)
                ))
                .collect(Collectors.toList());
    }
}
