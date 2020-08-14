package com.marido.video;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager2 Videoviewpage = findViewById(R.id.videoviewpage);

        List<VideoItem> videoItems = new ArrayList<>();

        VideoItem videoExample1 = new VideoItem();
        videoExample1.videoUl = "https://www.infinityandroid.com/videos/video1.mp4";
        videoExample1.videotitle = "GiHan";
        videoExample1.videodiscription = "Happy Khmer New Year";
        videoItems.add(videoExample1);

        VideoItem videoExample2 = new VideoItem();
        videoExample2.videoUl = "https://www.infinityandroid.com/videos/video2.mp4";
        videoExample2.videotitle = "MauLong";
        videoExample2.videodiscription = "Happyday on Holiday";
        videoItems.add(videoExample2);

        VideoItem videoExample3 = new VideoItem();
        videoExample3.videoUl = "https://www.infinityandroid.com/videos/video3.mp4";
        videoExample3.videotitle = "GrandBorn";
        videoExample3.videodiscription = "Miss That time.........";
        videoItems.add(videoExample3);

        VideoItem videoExample4 = new VideoItem();
        videoExample4.videoUl = "https://www.infinityandroid.com/videos/video4.mp4";
        videoExample4.videotitle =  "Logen";
        videoExample4.videodiscription = "Love everyone in my family";
        videoItems.add(videoExample4);

        VideoItem videoExample5 = new VideoItem();
        videoExample5.videoUl = "https://www.infinityandroid.com/videos/video5.mp4";
        videoExample5.videotitle =  "JonhNy";
        videoExample5.videodiscription = "Love Everything in the world";
        videoItems.add(videoExample5);

        VideoItem videoExample6 = new VideoItem();
        videoExample6.videoUl = "https://www.infinityandroid.com/videos/video6.mp4";
        videoExample6.videotitle =  "Chely";
        videoExample6.videodiscription = "Where are you now baby Miss....";
        videoItems.add(videoExample6);

        VideoItem videoExample7 = new VideoItem();
        videoExample7.videoUl = "https://www.infinityandroid.com/videos/video7.mp4";
        videoExample7.videotitle =  "ChhenLong";
        videoExample7.videodiscription = "Nice video poss #_#...";
        videoItems.add(videoExample7);

        Videoviewpage.setAdapter(new VideoAdapter(videoItems));

    }
}