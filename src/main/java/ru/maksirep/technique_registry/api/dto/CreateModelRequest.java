package ru.maksirep.technique_registry.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public final class CreateModelRequest {

    @NotNull
    @Schema(description = "Название модели",
            example = "MSI")
    private final String name;

    @NotNull
    @Schema(description = "Серийный номер модели",
            example = "SN12345")
    private final String serialNumber;

    @NotNull
    @Schema(description = "Цвет модели",
            example = "White")
    private final String color;

    @NotNull
    @Schema(description = "Размер модели",
            example = "2x2x2")
    private final String size;

    @NotNull
    @Schema(description = "Стоимость модели",
            example = "25000")
    private final int price;

    @NotNull
    @Schema(description = "Наличие модели на складе",
            example = "true")
    private final boolean isOnStock;

    @Schema(description = "Категория компьютера," +
            "поле необходимо только при создании модели компьютера, в иных случаях" +
            "наличие или отсутствие поля не повлияет на данные",
            example = "laptop")
    private final String category;

    @Schema(description = "Процессор компьютера," +
            "поле необходимо только при создании модели компьютера, в иных случаях" +
            "наличие или отсутствие поля не повлияет на данные",
            example = "intel core i9")
    private final String processorType;

    @Schema(description = "Количество дверей холодильника," +
            "поле необходимо только при создании модели холодильника, в иных случаях" +
            "наличие или отсутствие поля не повлияет на данные",
            example = "2")
    private final Integer numberOfDoors;

    @Schema(description = "Тип компрессора холодильника," +
            "поле необходимо только при создании модели холодильника, в иных случаях" +
            "наличие или отсутствие поля не повлияет на данные",
            example = "injector")
    private final String compressorType;

    @Schema(description = "Размер памяти смартфона," +
            "поле необходимо только при создании модели смартфона, в иных случаях" +
            "наличие или отсутствие поля не повлияет на данные",
            example = "128")
    private final Integer memory;

    @Schema(description = "Количество камер смартфона," +
            "поле необходимо только при создании модели смартфона, в иных случаях" +
            "наличие или отсутствие поля не повлияет на данные",
            example = "2")
    private final Integer numberOfCameras;

    @Schema(description = "Категория телевизора," +
            "поле необходимо только при создании модели телевизора, в иных случаях" +
            "наличие или отсутствие поля не повлияет на данные",
            example = "4K")
    private final String tvCategory;

    @Schema(description = "Технология телевизора," +
            "поле необходимо только при создании модели телевизора, в иных случаях" +
            "наличие или отсутствие поля не повлияет на данные",
            example = "LED")
    private final String technology;

    @Schema(description = "Объем пылесборника пылесоса," +
            "поле необходимо только при создании модели пылесоса, в иных случаях" +
            "наличие или отсутствие поля не повлияет на данные",
            example = "2")
    private final Integer dustBagVolume;

    @Schema(description = "Количество режимов пылесоса," +
            "поле необходимо только при создании модели пылесоса, в иных случаях" +
            "наличие или отсутствие поля не повлияет на данные",
            example = "4")
    private final Integer numberOfModes;

    public CreateModelRequest(String name,
                              String serialNumber,
                              String color,
                              String size,
                              int price,
                              boolean isOnStock,
                              String category,
                              String processorType,
                              Integer numberOfDoors,
                              String compressorType,
                              Integer memory,
                              Integer numberOfCameras,
                              String tvCategory,
                              String technology,
                              int dustBagVolume,
                              int numberOfModes) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.color = color;
        this.size = size;
        this.price = price;
        this.isOnStock = isOnStock;
        this.category = category;
        this.processorType = processorType;
        this.numberOfDoors = numberOfDoors;
        this.compressorType = compressorType;
        this.memory = memory;
        this.numberOfCameras = numberOfCameras;
        this.tvCategory = tvCategory;
        this.technology = technology;
        this.dustBagVolume = dustBagVolume;
        this.numberOfModes = numberOfModes;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public boolean isOnStock() {
        return isOnStock;
    }

    public String getCategory() {
        return category;
    }

    public String getProcessorType() {
        return processorType;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public Integer getMemory() {
        return memory;
    }

    public Integer getNumberOfCameras() {
        return numberOfCameras;
    }

    public String getTvCategory() {
        return tvCategory;
    }

    public String getTechnology() {
        return technology;
    }

    public Integer getDustBagVolume() {
        return dustBagVolume;
    }

    public Integer getNumberOfModes() {
        return numberOfModes;
    }
}