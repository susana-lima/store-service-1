package edu.umss.storeservice.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Category {
    private Long id;
    private String categoryName;
    private String categoryDescription;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category_name", nullable = false, length = 100)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "category_description", nullable = false, length = 2147483647)
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Basic
    @Column(name = "created_on", nullable = false)
    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "updated_on", nullable = true)
    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(categoryName, category.categoryName) &&
                Objects.equals(categoryDescription, category.categoryDescription) &&
                Objects.equals(createdOn, category.createdOn) &&
                Objects.equals(updatedOn, category.updatedOn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, categoryName, categoryDescription, createdOn, updatedOn);
    }
}
