package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.UnitDto;

import javax.persistence.*;

@Entity
@Table(name = "unit")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_GetAll_Unit",
                procedureName = "sp_get_all_unit",
                resultClasses = Unit.class),
        @NamedStoredProcedureQuery(
                name = "sp_create_unit",
                procedureName = "sp_create_unit",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "unit_name", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_Delete_Unit_ById",
                procedureName = "sp_delete_unit_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_Get_Unit_ById",
                procedureName = "sp_get_unit_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class)
                        },
                resultClasses = Unit.class
        )
})
public class Unit extends ModelBase<UnitDto> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
