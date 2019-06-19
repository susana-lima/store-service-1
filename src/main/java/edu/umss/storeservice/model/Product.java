package edu.umss.storeservice.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Product {
    private Long id;
    private String shortNameProduct;
    private String nameProduct;
    private String codeProduct;
    private String description;
    private String offerTxt;
    private String linkProduct;
    private Boolean isFeatured;
    private Boolean isPublic;
    private Boolean inExistence;
    private Timestamp orderAt;
    private Double priceProduct;
    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;
    private Timestamp expirationDateProduct;
    private Timestamp startSaleDate;
    private Timestamp discontinuedDate;
    private Timestamp createdAt;
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
    @Column(name = "short_name_product", nullable = false, length = 20)
    public String getShortNameProduct() {
        return shortNameProduct;
    }

    public void setShortNameProduct(String shortNameProduct) {
        this.shortNameProduct = shortNameProduct;
    }

    @Basic
    @Column(name = "name_product", nullable = false, length = 200)
    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Basic
    @Column(name = "code_product", nullable = false, length = 200)
    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "offer_txt", nullable = true, length = 1000)
    public String getOfferTxt() {
        return offerTxt;
    }

    public void setOfferTxt(String offerTxt) {
        this.offerTxt = offerTxt;
    }

    @Basic
    @Column(name = "link_product", nullable = true, length = 255)
    public String getLinkProduct() {
        return linkProduct;
    }

    public void setLinkProduct(String linkProduct) {
        this.linkProduct = linkProduct;
    }

    @Basic
    @Column(name = "is_featured", nullable = true)
    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }

    @Basic
    @Column(name = "is_public", nullable = true)
    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    @Basic
    @Column(name = "in_existence", nullable = true)
    public Boolean getInExistence() {
        return inExistence;
    }

    public void setInExistence(Boolean inExistence) {
        this.inExistence = inExistence;
    }

    @Basic
    @Column(name = "order_at", nullable = false)
    public Timestamp getOrderAt() {
        return orderAt;
    }

    public void setOrderAt(Timestamp orderAt) {
        this.orderAt = orderAt;
    }

    @Basic
    @Column(name = "price_product", nullable = false, precision = 0)
    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Basic
    @Column(name = "meta_title", nullable = true, length = 100)
    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    @Basic
    @Column(name = "meta_description", nullable = true, length = 255)
    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    @Basic
    @Column(name = "meta_keywords", nullable = true, length = 100)
    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    @Basic
    @Column(name = "expiration_date_product", nullable = true)
    public Timestamp getExpirationDateProduct() {
        return expirationDateProduct;
    }

    public void setExpirationDateProduct(Timestamp expirationDateProduct) {
        this.expirationDateProduct = expirationDateProduct;
    }

    @Basic
    @Column(name = "start_sale_date", nullable = true)
    public Timestamp getStartSaleDate() {
        return startSaleDate;
    }

    public void setStartSaleDate(Timestamp startSaleDate) {
        this.startSaleDate = startSaleDate;
    }

    @Basic
    @Column(name = "discontinued_date", nullable = true)
    public Timestamp getDiscontinuedDate() {
        return discontinuedDate;
    }

    public void setDiscontinuedDate(Timestamp discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(shortNameProduct, product.shortNameProduct) &&
                Objects.equals(nameProduct, product.nameProduct) &&
                Objects.equals(codeProduct, product.codeProduct) &&
                Objects.equals(description, product.description) &&
                Objects.equals(offerTxt, product.offerTxt) &&
                Objects.equals(linkProduct, product.linkProduct) &&
                Objects.equals(isFeatured, product.isFeatured) &&
                Objects.equals(isPublic, product.isPublic) &&
                Objects.equals(inExistence, product.inExistence) &&
                Objects.equals(orderAt, product.orderAt) &&
                Objects.equals(priceProduct, product.priceProduct) &&
                Objects.equals(metaTitle, product.metaTitle) &&
                Objects.equals(metaDescription, product.metaDescription) &&
                Objects.equals(metaKeywords, product.metaKeywords) &&
                Objects.equals(expirationDateProduct, product.expirationDateProduct) &&
                Objects.equals(startSaleDate, product.startSaleDate) &&
                Objects.equals(discontinuedDate, product.discontinuedDate) &&
                Objects.equals(createdAt, product.createdAt) &&
                Objects.equals(updatedOn, product.updatedOn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, shortNameProduct, nameProduct, codeProduct, description, offerTxt, linkProduct, isFeatured, isPublic, inExistence, orderAt, priceProduct, metaTitle, metaDescription, metaKeywords, expirationDateProduct, startSaleDate, discontinuedDate, createdAt, updatedOn);
    }
}
