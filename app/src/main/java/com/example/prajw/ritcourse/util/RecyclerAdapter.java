package com.example.prajw.ritcourse.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.prajw.ritcourse.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ofaroque on 8/13/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.VideoInfoHolder> {

    //these ids are the unique id for each video
    String[] temp;
    Context ctx;
    String title;
    private String[] VideoID;
    private static String KEY = "AIzaSyDcmC_SBnnPkjicB-33Hd88EfZ1OIw0E5g";



    private static String TAG = "Recycler";
    //private int pos;
    public RecyclerAdapter(Context context,String[] lecname) {
        this.ctx = context;
        this.VideoID=new String[]{lecname[0],lecname[1],lecname[2]};
    }



    @Override
    public VideoInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewyt, parent, false);
        return new VideoInfoHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final VideoInfoHolder holder, final int position) {

        holder.youTubeThumbnailView.initialize(KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo(VideoID[position]);
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                        youTubeThumbnailLoader.release();
                        youTubeThumbnailView.setVisibility(View.VISIBLE);
                        holder.relativeLayoutOverYouTubeThumbnailView.setVisibility(View.VISIBLE);
                        List<String[]> addresses = new ArrayList<String[]>();
                        String[] addressesArr  = new String[3];
                        addressesArr[0] = "One";
                        addressesArr[1] = "Two";
                        addressesArr[2] = "Three";
                        addresses.add(addressesArr);
                        String item = addressesArr[position]; // For example YourList is an ArrayList of String
                        holder.videosTitleTextView.setText("Lesson "+item);
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return VideoID.length;
    }

    public class VideoInfoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected RelativeLayout relativeLayoutOverYouTubeThumbnailView;
        protected ImageView playButton;
        protected TextView videosTitleTextView;
        YouTubeThumbnailView youTubeThumbnailView;
        int i;

        public VideoInfoHolder(View itemView) {
            super(itemView);
            playButton = (ImageView) itemView.findViewById(R.id.btnYoutube_player);
            videosTitleTextView = (TextView) itemView.findViewById(R.id.videosTitle_tv);
            playButton.setOnClickListener(this);
             youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.youtube_thumbnail);
            // videosTitleTextView.setText("Lesson "+getItemCount());
            relativeLayoutOverYouTubeThumbnailView = (RelativeLayout) itemView.findViewById(R.id.relativeLayout_over_youtube_thumbnail);

        }

        @Override
        public void onClick(View v) {
            Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) ctx, KEY, VideoID[getLayoutPosition()]);
            ctx.startActivity(intent);
        }
    }


}