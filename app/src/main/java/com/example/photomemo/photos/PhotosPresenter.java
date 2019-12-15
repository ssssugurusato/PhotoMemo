package com.example.photomemo.photos;

import com.example.photomemo.data.PhotoData;
import com.example.photomemo.data.PhotoRepository;

import java.util.List;

public class PhotosPresenter implements PhotosContract.Presenter{
    private final PhotoRepository mPhotosRepository;
    private final PhotosContract.View mPhotosView;
    private final PhotosContract.Activity mPhotosActivity;

    public PhotosPresenter(PhotoRepository photosRepository,
                           PhotosContract.View PhotosView,
                           PhotosContract.Activity PhotosActivity) {
        mPhotosRepository = photosRepository;
        mPhotosView = PhotosView;
        mPhotosActivity = PhotosActivity;
        mPhotosView.setPresenter(this);
    }

    public void removePhoto(int index) {
        mPhotosRepository.removePhoto(index);
    }

    public void showAddPhoto() {
        mPhotosActivity.showAddPhoto();
    }

    public void result(){
        List<PhotoData> photos=
                mPhotosRepository.getPhotos();
        mPhotosView.showPhotos(photos);
    }

}

