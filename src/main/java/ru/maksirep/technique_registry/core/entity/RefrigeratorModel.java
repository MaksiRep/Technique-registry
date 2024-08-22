package ru.maksirep.technique_registry.core.entity;

import javax.persistence.Entity;

@Entity
public class RefrigeratorModel extends Model {

    private int numberOfDoors;
    private String compressorType;

    public RefrigeratorModel() {
    }

    public RefrigeratorModel(int numberOfDoors, String compressorType) {
        this.numberOfDoors = numberOfDoors;
        this.compressorType = compressorType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getCompressorType() {
        return compressorType;
    }

    public void setCompressorType(String compressorType) {
        this.compressorType = compressorType;
    }
}
