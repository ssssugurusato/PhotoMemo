package com.example.photomemo.data;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

public class PhotoRepository {
    private static PhotoRepository mInstance = null;
    private final List<PhotoData> mPhotos;

    private PhotoRepository() {
        mPhotos = new ArrayList<>();
    }

    static public PhotoRepository getInstance() {
        if (mInstance == null)
            mInstance = new PhotoRepository();
        return mInstance;
    }

    private Uri mTemporaryPhotoUri;

    public void savePhoto(String memo) {
        mPhotos.add(new PhotoData(mTemporaryPhotoUri, memo));
        //mTemporaryPhotoUri = null;
    }
    public void setTemporaryPhoto(Uri uri) {
        mTemporaryPhotoUri = uri;
    }

    public List<PhotoData> getPhotos() {
        return mPhotos;
    }

    public void removePhoto(int index) {
        mTemporaryPhotoUri = null;
    }
}
