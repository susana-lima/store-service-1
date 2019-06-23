package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.CategoryDto;

import javax.persistence.*;

@Entity
@Table(name = "category")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_GetAll_Category",
                procedureName = "sp_get_all_category",
                resultClasses = Category.class
        ),
        @NamedStoredProcedureQuery(
                name = "sp_Delete_Category_ById",
                procedureName = "sp_delete_category_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_Get_Category_ById",
                procedureName = "sp_get_category_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class)
                },
                resultClasses = Category.class
        )
})
public class Category extends ModelBase<CategoryDto> {
    private String categoryName;
    private String categoryDescription;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}
