package edu.umss.storeservice.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Photo {
    private Long id;
    private Serializable thumbnailPhoto;
    private String thumbnailPhotoName;
    private Serializable largePhoto;
    private String largePhotoName;
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
    @Column(name = "thumbnail_photo", nullable = true)
    public Serializable getThumbnailPhoto() {
        return thumbnailPhoto;
    }

    public void setThumbnailPhoto(Serializable thumbnailPhoto) {
        this.thumbnailPhoto = thumbnailPhoto;
    }

    @Basic
    @Column(name = "thumbnail_photo_name", nullable = false, length = 250)
    public String getThumbnailPhotoName() {
        return thumbnailPhotoName;
    }

    public void setThumbnailPhotoName(String thumbnailPhotoName) {
        this.thumbnailPhotoName = thumbnailPhotoName;
    }

    @Basic
    @Column(name = "large_photo", nullable = true)
    public Serializable getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(Serializable largePhoto) {
        this.largePhoto = largePhoto;
    }

    @Basic
    @Column(name = "large_photo_name", nullable = false, length = 250)
    public String getLargePhotoName() {
        return largePhotoName;
    }

    public void setLargePhotoName(String largePhotoName) {
        this.largePhotoName = largePhotoName;
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
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id) &&
                Objects.equals(thumbnailPhoto, photo.thumbnailPhoto) &&
                Objects.equals(thumbnailPhotoName, photo.thumbnailPhotoName) &&
                Objects.equals(largePhoto, photo.largePhoto) &&
                Objects.equals(largePhotoName, photo.largePhotoName) &&
                Objects.equals(createdOn, photo.createdOn) &&
                Objects.equals(updatedOn, photo.updatedOn);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, thumbnailPhoto, thumbnailPhotoName, largePhoto, largePhotoName, createdOn, updatedOn);
    }
}
