package com.example.photomemo.addphoto;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.photomemo.R;

public class AddPhotoFragment extends Fragment implements AddPhotoContract.View{
       private  AddPhotoContract.Presenter mPresenter;
       ImageView mImageView;
       private EditText mEditText;
       private AddPhotoActivity mAddPhotoActivity;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.add_photo_frag, container, false);
        mImageView = root.findViewById(R.id.addPhotoImageView);
        mEditText = root.findViewById(R.id.addPhotoMemoEditText);
        FloatingActionButton fab = root.findViewById(R.id.addPhotoFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.savePhoto(mEditText.getText().toString());
                mPresenter.addPhotoToList(true);
            }});
           return root;
    }

    public void showPhoto(Uri photoImage) {
        mImageView.setImageURI(photoImage);
    }

    public void setPresenter(AddPhotoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

}