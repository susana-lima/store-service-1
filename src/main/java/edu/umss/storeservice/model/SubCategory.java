package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.SubCategoryDto;

import javax.persistence.*;

@Entity
@Table(name = "sub_category")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_GetAll_SubCategory",
                procedureName = "sp_get_all_sub_category",
                resultClasses = SubCategory.class
        ),
        @NamedStoredProcedureQuery(
                name = "sp_Delete_SubCategory_ById",
                procedureName = "sp_delete_sub_category_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "result", type = Boolean.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_Get_SubCategory_ById",
                procedureName = "sp_get_sub_category_by_id",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Long.class)
                },
                resultClasses = SubCategory.class
        )
})
public class SubCategory extends ModelBase<SubCategoryDto> {
    private String subCategoryName;
    private String subCategoryDescription;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category category;


    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getSubCategoryDescription() {
        return subCategoryDescription;
    }

    public void setSubCategoryDescription(String subCategoryDescription) {
        this.subCategoryDescription = subCategoryDescription;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
