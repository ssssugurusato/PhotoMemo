package com.example.photomemo.addphoto;

import android.net.Uri;

import com.example.photomemo.data.PhotoRepository;

public class AddPhotoPresenter implements AddPhotoContract.Presenter {
    private final PhotoRepository mPhotosRepository;
    private final AddPhotoContract.View mAddPhotoView;
    private final AddPhotoContract.Activity mAddPhotoActivity;

    public AddPhotoPresenter(PhotoRepository photosRepository,
                             AddPhotoContract.View addPhotoView,
                             AddPhotoContract.Activity addPhotoActivity) {
        mPhotosRepository = photosRepository;
        mAddPhotoView = addPhotoView;
        mAddPhotoActivity = addPhotoActivity;
        mAddPhotoView.setPresenter(this);
    }

    private boolean mIsStarted = false;

    public void start() {
        if (!mIsStarted) {
            mAddPhotoActivity.showPicker();
            mIsStarted = true;
        }
    }
    public void savePhoto(String memo) {
        mPhotosRepository.savePhoto(memo);
    }


    public void result(boolean result, Uri uri) {
        if (!result)
            return;
        mPhotosRepository.setTemporaryPhoto(uri);
        mAddPhotoView.showPhoto(uri);
    }

    public void addPhotoToList(boolean result) {
        if (!result)
            return;
        mAddPhotoActivity.finishWithResult(result);
    }


}
