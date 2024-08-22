package ru.maksirep.technique_registry.core.entity;

import javax.persistence.Entity;

@Entity
public class TelevisionModel extends Model {

    private String tvCategory;
    private String technology;

    public TelevisionModel() {
    }

    public TelevisionModel(String tvCategory, String technology) {
        this.tvCategory = tvCategory;
        this.technology = technology;
    }

    public String getTvCategory() {
        return tvCategory;
    }

    public void setTvCategory(String tvCategory) {
        this.tvCategory = tvCategory;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }
}
