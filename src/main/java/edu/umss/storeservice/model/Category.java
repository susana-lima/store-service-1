package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.CategoryDto;

import javax.persistence.Entity;

@Entity
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
