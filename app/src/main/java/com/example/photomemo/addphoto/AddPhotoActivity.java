package com.example.photomemo.addphoto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.photomemo.R;
import com.example.photomemo.data.PhotoRepository;

public class AddPhotoActivity extends AppCompatActivity implements AddPhotoContract.Activity {
    private AddPhotoPresenter mPresenter;
    private final int REQUEST_PICK_PHOTO = 2;
    public static final int REQUEST_ADD_PHOTO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_photo_act);
        AddPhotoFragment fragment = (AddPhotoFragment) getSupportFragmentManager().findFragmentById(R.id.add_photo_frag);
        mPresenter = new AddPhotoPresenter(PhotoRepository.getInstance(),
                fragment, this);
    }

    public void showPicker() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        //intentの種類はドキュメントプロバイダによるものですよ
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        //ちゃんと開けるものをくわえるカテゴリをくわえる
        intent.setType("image/jpeg");
        //imageディレクトリ内のjpeg
        startActivityForResult(intent, REQUEST_PICK_PHOTO);
        //intentはクラス感を飛ぶ意図でREQUEST_PICK_PHOTOはintentの報酬の返す場所のコード、つまりAddPhotoActivity
    }

    /* 結果を受け取るためのcallback 関数*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_PICK_PHOTO)
            return;
        if (resultCode != RESULT_OK)
            return;
        Uri uri = data.getData();
        mPresenter.result(resultCode == RESULT_OK, uri);

    }

    public void finishWithResult(boolean result) {
        Intent intent = new Intent();
        setResult((result) ? RESULT_OK : RESULT_CANCELED, intent);
        finish();
    }
}
