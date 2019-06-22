package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.SubCategoryDto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
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
