package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.ProductPhotoDto;

import javax.persistence.*;

@Entity
public class ProductPhoto extends ModelBase<ProductPhotoDto> {

    private Product productByProductId;
    private Photo photoByPhotoId;


    @ManyToOne
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    public Photo getPhotoByPhotoId() {
        return photoByPhotoId;
    }

    public void setPhotoByPhotoId(Photo photoByPhotoId) {
        this.photoByPhotoId = photoByPhotoId;
    }
}
