package ru.maksirep.technique_registry.core.service;

import org.springframework.stereotype.Service;
import ru.maksirep.technique_registry.api.dto.CreateModelRequest;
import ru.maksirep.technique_registry.api.dto.ModelDto;
import ru.maksirep.technique_registry.api.dto.enums.ProductTypeDto;
import ru.maksirep.technique_registry.api.dto.enums.SortFieldDto;
import ru.maksirep.technique_registry.api.dto.enums.SortRuleDto;
import ru.maksirep.technique_registry.core.error.ErrorCode;
import ru.maksirep.technique_registry.core.error.ServiceException;
import ru.maksirep.technique_registry.core.repository.ModelRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService {

    private final ModelRepository modelRepository;
    private final ProductService productService;

    public ModelService(ModelRepository modelRepository, ProductService productService) {
        this.modelRepository = modelRepository;
        this.productService = productService;
    }

    @Transactional
    public void createModel(int id, ProductTypeDto productTypeDto, CreateModelRequest createModelRequest) {
        if (!productService.isProductExistById(id)) {
            throw new ServiceException(
                    String.format("Техника с идентификатором \"%d\" не найдена", id),
                    ErrorCode.NOT_FOUND);
        }
        if (modelRepository.isSerialNumberNotUnique(createModelRequest.getSerialNumber())) {
            throw new ServiceException(
                    String.format("Модель с серийным номером \"%s\" уже существует", createModelRequest.getSerialNumber()),
                    ErrorCode.BAD_REQUEST);
        }
        int modelId = modelRepository.createModel(
                createModelRequest.getName(),
                createModelRequest.getSerialNumber(),
                createModelRequest.getColor(),
                createModelRequest.getSize(),
                createModelRequest.getPrice(),
                createModelRequest.isOnStock(),
                id
        );
        switch (productTypeDto) {
            case COMPUTER: {
                if (createModelRequest.getCategory() == null ||
                        createModelRequest.getProcessorType() == null ||
                        createModelRequest.getCategory().isEmpty() ||
                        createModelRequest.getProcessorType().isEmpty()) {
                    throw new ServiceException(
                            "Некорректные значения типа процессора и категории компьютера",
                            ErrorCode.BAD_REQUEST);
                }
                modelRepository.createComputer(modelId,
                        createModelRequest.getCategory(),
                        createModelRequest.getProcessorType());
                break;
            }
            case REFRIGERATOR: {
                if (createModelRequest.getNumberOfDoors() == null ||
                        createModelRequest.getCompressorType() == null ||
                        createModelRequest.getCompressorType().isEmpty()) {
                    throw new ServiceException(
                            "Некорректные значения количества дверей и типа компрессора холодильника",
                            ErrorCode.BAD_REQUEST);
                }
                modelRepository.createRefrigerator(modelId,
                        createModelRequest.getNumberOfDoors(),
                        createModelRequest.getCompressorType());
                break;
            }
            case SMARTPHONE: {
                if (createModelRequest.getMemory() == null ||
                        createModelRequest.getNumberOfCameras() == null) {
                    throw new ServiceException(
                            "Некорректные значения размера памяти и количества камер смартфона",
                            ErrorCode.BAD_REQUEST);
                }
                modelRepository.createSmartphone(modelId,
                        createModelRequest.getMemory(),
                        createModelRequest.getNumberOfCameras());
                break;
            }
            case TELEVISION: {
                if (createModelRequest.getTvCategory() == null ||
                        createModelRequest.getTechnology() == null ||
                        createModelRequest.getTvCategory().isEmpty() ||
                        createModelRequest.getTechnology().isEmpty()) {
                    throw new ServiceException(
                            "Некорректные значения категории и технологии телевизора",
                            ErrorCode.BAD_REQUEST);
                }
                modelRepository.createTelevision(modelId,
                        createModelRequest.getTvCategory(),
                        createModelRequest.getTechnology());
                break;
            }
            case VACUUM_CLEANER: {
                if (createModelRequest.getDustBagVolume() == null ||
                        createModelRequest.getNumberOfModes() == null) {
                    throw new ServiceException(
                            "Некорректные значения объема пылесборника и количества режимов пылесоса",
                            ErrorCode.BAD_REQUEST);
                }
                modelRepository.createVacuumCleaner(modelId,
                        createModelRequest.getDustBagVolume(),
                        createModelRequest.getNumberOfModes());
                break;
            }
        }
    }

    public List<ModelDto> sortModels(SortRuleDto sortRuleDto, SortFieldDto sortFieldDto) {
        return modelRepository.sortModel(sortRuleDto.name(), sortFieldDto.name()).stream()
                .map(tuple -> new ModelDto(
                        tuple.get(0, Integer.class),
                        tuple.get(1, String.class),
                        tuple.get(2, String.class),
                        tuple.get(3, String.class),
                        tuple.get(4, String.class),
                        tuple.get(5, Integer.class),
                        tuple.get(6, Boolean.class),
                        tuple.get(8, String.class),
                        tuple.get(9, String.class),
                        tuple.get(10, Integer.class),
                        tuple.get(11, String.class),
                        tuple.get(12, Integer.class),
                        tuple.get(13, Integer.class),
                        tuple.get(14, String.class),
                        tuple.get(15, String.class),
                        tuple.get(16, Integer.class),
                        tuple.get(17, Integer.class)
                ))
                .collect(Collectors.toList());
    }
}
