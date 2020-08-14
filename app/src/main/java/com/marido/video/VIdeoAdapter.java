package com.marido.video;

import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.ContentValues.TAG;

class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoviewHolder>{
    private List<VideoItem> videoItems;
    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public VideoviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoviewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_contaner_video,
                        parent,
                        false

                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoviewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));

    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    static class VideoviewHolder extends RecyclerView.ViewHolder{
        VideoView videoView;
        TextView textvideotitle, textvideodiscription;
        ProgressBar videoprogressBar;
        public VideoviewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoview);
            textvideotitle = itemView.findViewById(R.id.textvideotitle);
            textvideodiscription = itemView.findViewById(R.id.textvideodiscription);
            videoprogressBar = itemView.findViewById(R.id.videoprogressbar);
        }
        void setVideoData(VideoItem videoItem){
            textvideotitle.setText(videoItem.videotitle);
            textvideodiscription.setText(videoItem.videodiscription);
            videoView.setVideoPath(videoItem.videoUl);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    videoprogressBar.setVisibility(View.GONE);
                    mediaPlayer.start();
                    float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();
                    float scale = videoRatio / screenRatio;
                    if(scale >= 1f){
                        videoprogressBar.setVisibility(View.GONE);
                        videoView.setScaleX(scale);
                    }else {
                        videoView.setScaleY(1f / scale);
                    }
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

        }
    }
}
