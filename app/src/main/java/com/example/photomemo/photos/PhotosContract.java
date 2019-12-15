package com.example.photomemo.photos;

import android.content.Intent;

import com.example.photomemo.data.PhotoData;

import java.util.List;

public interface PhotosContract {
    interface View {
        void setPresenter(Presenter presenter);
        void showPhotos(List<PhotoData> photos);
    }

    interface Presenter {
      //  void openPhotoDetails(int index);
        void removePhoto(int index);
        void showAddPhoto();
        void result();
    }

    interface Activity {
        void showAddPhoto();
        void onActivityResult(int requestCode, int resultCode, Intent data);
    }
}
