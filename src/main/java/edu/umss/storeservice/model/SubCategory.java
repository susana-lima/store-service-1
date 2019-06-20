package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.SubCategoryDto;

import javax.persistence.*;

@Entity
public class SubCategory extends ModelBase<SubCategoryDto> {
    private String subCategoryName;
    private String subCategoryDescription;
    private Category categoryByCategoryId;


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

    @ManyToOne
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
