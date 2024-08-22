package ru.maksirep.technique_registry.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public final class CreateProductRequest {

    @NotNull
    @Schema(description = "Название техники",
            example = "SUPER PC")
    private final String name;

    @NotNull
    @Schema(description = "Страна производитель",
            example = "USA")
    private final String country;

    @NotNull
    @Schema(description = "Фирма производитель",
            example = "MSI")
    private final String manufacturer;

    @NotNull
    @Schema(description = "Возможность заказа онлайн",
            example = "true")
    private final boolean isOnline;

    @NotNull
    @Schema(description = "Возможность оформления рассрочки",
            example = "true")
    private final boolean isInstallment;

    public CreateProductRequest(String name,
                                String country,
                                String manufacturer,
                                boolean isOnline,
                                boolean isInstallment) {
        this.name = name;
        this.country = country;
        this.manufacturer = manufacturer;
        this.isOnline = isOnline;
        this.isInstallment = isInstallment;
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
}
