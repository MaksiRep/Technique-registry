package ru.maksirep.technique_registry.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public final class FullProductDto {

    @Schema(description = "Идентификатор модели",
            example = "1")
    private final int id;
    
    @Schema(description = "Название техники",
            example = "PC")
    private final String name;

    @Schema(description = "Страна производитель",
            example = "USA")
    private final String country;

    @Schema(description = "Фирма производитель",
            example = "MSI")
    private final String manufacturer;

    @Schema(description = "Возможность заказа онлайн",
            example = "true")
    private final boolean isOnline;
    
    @Schema(description = "Возможность оформления рассрочки",
            example = "true")
    private final boolean isInstallment;
    
    @Schema(description = "Название модели",
            example = "MSI")
    private final String modelName;

    @Schema(description = "Серийный номер модели",
            example = "SN12345")
    private final String serialNumber;

    @Schema(description = "Цвет модели",
            example = "White")
    private final String color;

    @Schema(description = "Размер модели",
            example = "2x2x2")
    private final String size;

    @Schema(description = "Стоимость модели",
            example = "25000")
    private final int price;

    @Schema(description = "Наличие модели на складе",
            example = "true")
    private final boolean isOnStock;

    @Schema(description = "Категория компьютера," +
            "поле не null только для моделей компьютеров",
            example = "laptop")
    private final String category;

    @Schema(description = "Процессор компьютера," +
            "поле не null только для моделей компьютеров",
            example = "intel core i9")
    private final String processorType;

    @Schema(description = "Количество дверей холодильника," +
            "поле не null только для моделей холодильников",
            example = "2")
    private final Integer numberOfDoors;

    @Schema(description = "Тип компрессора холодильника," +
            "поле не null только для моделей холодильников",
            example = "injector")
    private final String compressorType;

    @Schema(description = "Размер памяти смартфона," +
            "поле не null только для моделей смартфонов",
            example = "128")
    private final Integer memory;

    @Schema(description = "Количество камер смартфона," +
            "поле не null только для моделей смартфонов",
            example = "2")
    private final Integer numberOfCameras;

    @Schema(description = "Категория телевизора," +
            "поле не null только для моделей телевизоров",
            example = "4K")
    private final String tvCategory;

    @Schema(description = "Технология телевизора," +
            "поле не null только для моделей телевизоров",
            example = "LED")
    private final String technology;

    @Schema(description = "Объем пылесборника пылесоса," +
            "поле не null только для моделей пылесосов",
            example = "2")
    private final Integer dustBagVolume;

    @Schema(description = "Количество режимов пылесоса," +
            "поле не null только для моделей пылесосов",
            example = "4")
    private final Integer numberOfModes;

    public FullProductDto(int id,
                          String name,
                          String country,
                          String manufacturer,
                          boolean isOnline,
                          boolean isInstallment,
                          String modelName,
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
                          Integer dustBagVolume,
                          Integer numberOfModes) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.manufacturer = manufacturer;
        this.isOnline = isOnline;
        this.isInstallment = isInstallment;
        this.modelName = modelName;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isInstallment() {
        return isInstallment;
    }

    public String getModelName() {
        return modelName;
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
