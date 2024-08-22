package ru.maksirep.technique_registry.core.entity;

import javax.persistence.Entity;

@Entity
public class SmartphoneModel extends Model {

    private int memory;
    private int numberOfCameras;

    public SmartphoneModel() {
    }

    public SmartphoneModel(int memory, int numberOfCameras) {
        this.memory = memory;
        this.numberOfCameras = numberOfCameras;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getNumberOfCameras() {
        return numberOfCameras;
    }

    public void setNumberOfCameras(int numberOfCameras) {
        this.numberOfCameras = numberOfCameras;
    }
}
