/**
 * @author: Susana Lima
 */
package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Photo;
import edu.umss.storeservice.model.Product;
import edu.umss.storeservice.model.ProductPhoto;

public class ProductPhotoDto extends DtoBase<ProductPhoto> {
    private Product productByProductId;
    private Photo photoByPhotoId;

    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

    public Photo getPhotoByPhotoId() {
        return photoByPhotoId;
    }

    public void setPhotoByPhotoId(Photo photoByPhotoId) {
        this.photoByPhotoId = photoByPhotoId;
    }
}