/**
 * @author: Susana Lima
 */
package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Category;
import edu.umss.storeservice.model.SubCategory;

public class SubCategoryDto extends DtoBase<SubCategory> {
    private String subCategoryName;
    private String subCategoryDescription;
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