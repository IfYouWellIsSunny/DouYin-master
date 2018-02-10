package com.liqy.douyin.search;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.liqy.douyin.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoPlayActivity extends AppCompatActivity {


    @BindView(R.id.vv)
    VideoView vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        vv.setVideoURI(Uri.parse(url));
        vv.start();

    }

}
