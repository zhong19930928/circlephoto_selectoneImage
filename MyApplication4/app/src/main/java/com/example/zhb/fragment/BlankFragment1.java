package com.example.zhb.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zhb.myapplication.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.permissions.RxPermissions;

import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

public class BlankFragment1 extends Fragment implements View.OnClickListener{
    private CircleImageView photoUser;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank2, null);
        photoUser = (CircleImageView) view.findViewById(R.id.photo_user);
        Glide.with(getActivity()).load("http://pic39.nipic.com/20140226/18071023_164300608000_2.jpg")
                .into(photoUser);
        photoUser.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick(R.id.photo_user)
    public void onViewClicked() {
    }

    @Override
    public void onClick(View v) {
        {
            RxPermissions permissions;
            permissions = new RxPermissions(getActivity());
            permissions.request(Manifest.permission.CAMERA).subscribe(new Observer<Boolean>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(Boolean aBoolean) {
                    if (aBoolean){
                        PictureSelector.create(getActivity())
                                .openGallery(PictureMimeType.ofImage())
                                .maxSelectNum(1)
                                .enableCrop(true)
                                .compress(true)
                                .withAspectRatio(1,1)
                                .compressMode(PictureConfig.LUBAN_COMPRESS_MODE)
                                .circleDimmedLayer(true)
                                .showCropFrame(false)
                                .forResult(PictureConfig.CHOOSE_REQUEST);
                    }else{
                        Toast.makeText(getActivity(),"读取内存卡权限被拒绝",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {

                }
            });
        }
    }

//    @Subscribe(threadMode =ThreadMode.MAIN)
//    public void activityResult(Intent data){
//
//    }
}
