/**
 * @author: Susana Lima
 */
package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Unit;

public class UnitDto extends DtoBase<Unit> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}