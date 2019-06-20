/**
 * @author: Susana Lima
 */
package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Photo;

import java.io.Serializable;

public class PhotoDto extends DtoBase<Photo> {
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