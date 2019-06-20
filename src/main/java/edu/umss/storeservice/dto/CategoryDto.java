/**
 * @author: Susana Lima
 */
package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Category;

public class CategoryDto extends DtoBase<Category> {
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