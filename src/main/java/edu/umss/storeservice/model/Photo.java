package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.PhotoDto;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Photo extends ModelBase<PhotoDto> {
    private Serializable thumbnailPhoto;
    private String thumbnailPhotoName;
    private Serializable largePhoto;
    private String largePhotoName;

    public Serializable getThumbnailPhoto() {
        return thumbnailPhoto;
    }

    public void setThumbnailPhoto(Serializable thumbnailPhoto) {
        this.thumbnailPhoto = thumbnailPhoto;
    }

    public String getThumbnailPhotoName() {
        return thumbnailPhotoName;
    }

    public void setThumbnailPhotoName(String thumbnailPhotoName) {
        this.thumbnailPhotoName = thumbnailPhotoName;
    }

    public Serializable getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(Serializable largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getLargePhotoName() {
        return largePhotoName;
    }

    public void setLargePhotoName(String largePhotoName) {
        this.largePhotoName = largePhotoName;
    }

}
