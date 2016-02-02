package ninja.codeavengers.mjolnir;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class VideosAdapter extends
        RecyclerView.Adapter<VideosAdapter.ViewHolder> {

    // Store a member variable for the contacts
    private List<VideoItem> mVideos;
    private Context mContext;

    // Pass in the contact array into the constructor
    public VideosAdapter(List<VideoItem> videos, Context context) {
        mVideos = videos;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View videoView = inflater.inflate(R.layout.video_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(videoView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        VideoItem videoItem = mVideos.get(position);

        // Set item views based on the data model
        TextView textView = holder.nameTextView;
        ImageView thumbnailImage = holder.thumbnailImage;

        textView.setText(videoItem.getVideoName());
        Picasso.with(mContext)
                .load(videoItem.getThumbnailUrl())
                .into(thumbnailImage);
    }

    @Override
    public int getItemCount() {
        return mVideos.size();
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public ImageView thumbnailImage;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.video_name);
            thumbnailImage = (ImageView) itemView.findViewById(R.id.thumbnail);
            thumbnailImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition(); // gets item position
            VideoItem video = mVideos.get(position);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://" + video.getYoutubeId()));
            mContext.startActivity(intent);
        }
    }
}