package ru.maksirep.technique_registry.core.entity;

import javax.persistence.Entity;

@Entity
public class VacuumCleanerModel extends Model {

    private int dustBagVolume;
    private int numberOfModes;

    public VacuumCleanerModel() {
    }

    public VacuumCleanerModel(int dustBagVolume, int numberOfModes) {
        this.dustBagVolume = dustBagVolume;
        this.numberOfModes = numberOfModes;
    }

    public int getDustBagVolume() {
        return dustBagVolume;
    }

    public void setDustBagVolume(int dustBagVolume) {
        this.dustBagVolume = dustBagVolume;
    }

    public int getNumberOfModes() {
        return numberOfModes;
    }

    public void setNumberOfModes(int numberOfModes) {
        this.numberOfModes = numberOfModes;
    }
}
