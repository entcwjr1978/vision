package ninja.codeavengers.mjolnir;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeIntents;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {

    String [] videoList = {"5LqOYYz5AIQ", ""};


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        List<VideoItem> videoList = new ArrayList<>();
        videoList.add(new VideoItem("Concert", "http://img.youtube.com/vi/wds0w0TxH14/hqdefault.jpg", "wds0w0TxH14"));
        videoList.add(new VideoItem("WSB Set", "http://img.youtube.com/vi/DQD3JhEv_Zs/hqdefault.jpg", "DQD3JhEv_Zs"));
        videoList.add(new VideoItem("Car", "http://img.youtube.com/vi/PR7wi0NUeWI/hqdefault.jpg", "PR7wi0NUeWI"));

        RecyclerView rvVideos = (RecyclerView) findViewById(R.id.videoList);
        // Create adapter passing in the sample user data
        VideosAdapter adapter = new VideosAdapter(videoList, this);
        // Attach the adapter to the recyclerview to populate items
        rvVideos.setAdapter(adapter);
        // Set layout manager to position the items
        rvVideos.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
    }
}
