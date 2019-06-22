package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.PhotoDto;

import javax.persistence.Entity;

@Entity
public class Photo extends ModelBase<PhotoDto> {
    private Byte[] thumbnailPhoto;
    private String thumbnailPhotoName;
    private Byte[] largePhoto;
    private String largePhotoName;

    public Byte[] getThumbnailPhoto() {
        return thumbnailPhoto;
    }

    public void setThumbnailPhoto(Byte[] thumbnailPhoto) {
        this.thumbnailPhoto = thumbnailPhoto;
    }

    public String getThumbnailPhotoName() {
        return thumbnailPhotoName;
    }

    public void setThumbnailPhotoName(String thumbnailPhotoName) {
        this.thumbnailPhotoName = thumbnailPhotoName;
    }

    public Byte[] getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(Byte[] largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getLargePhotoName() {
        return largePhotoName;
    }

    public void setLargePhotoName(String largePhotoName) {
        this.largePhotoName = largePhotoName;
    }

}
