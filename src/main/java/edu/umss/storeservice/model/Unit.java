package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.UnitDto;

import javax.persistence.Entity;

@Entity
public class Unit extends ModelBase<UnitDto> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
