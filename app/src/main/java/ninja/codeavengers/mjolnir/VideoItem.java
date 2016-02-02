package ninja.codeavengers.mjolnir;

public class VideoItem {
    public String getVideoName() {
        return mVideoName;
    }

    public void setVideoName(String videoName) {
        this.mVideoName = videoName;
    }

    public String getYoutubeId() {
        return mYoutubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.mYoutubeId = youtubeId;
    }

    private String mVideoName;
    private String mYoutubeId;

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.mThumbnailUrl = thumbnailUrl;
    }

    private String mThumbnailUrl;

    public VideoItem(String videoName, String thumbnailUrl, String youtubeId) {
        mThumbnailUrl = thumbnailUrl;
        mVideoName = videoName;
        mYoutubeId = youtubeId;
    }
}
