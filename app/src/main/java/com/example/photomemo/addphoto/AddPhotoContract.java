package com.example.photomemo.addphoto;

import android.net.Uri;

public interface AddPhotoContract {
    interface View {
        void setPresenter(Presenter presenter);
        void showPhoto(Uri photoImage);
    }

    interface Presenter {
        void start();
        void savePhoto(String memo);
        void addPhotoToList(boolean result);
    }

    interface Activity {
        void showPicker();
       void finishWithResult(boolean result);
    }
}
