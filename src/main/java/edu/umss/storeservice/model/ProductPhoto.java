package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.ProductPhotoDto;

import javax.persistence.*;

@Entity
public class ProductPhoto extends ModelBase<ProductPhotoDto> {

    @ManyToOne(optional = false)
    private Product product;
    @ManyToOne(optional = false)
    private Photo photo;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
