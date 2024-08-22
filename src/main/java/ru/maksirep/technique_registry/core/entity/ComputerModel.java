package ru.maksirep.technique_registry.core.entity;

import javax.persistence.Entity;

@Entity
public class ComputerModel extends Model {

    private String category;
    private String processorType;

    public ComputerModel() {
    }

    public ComputerModel(String category, String processorType) {
        this.category = category;
        this.processorType = processorType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }
}