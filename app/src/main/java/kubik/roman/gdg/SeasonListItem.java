package kubik.roman.gdg;

import android.graphics.drawable.Drawable;

/**
 * Created by roman on 3/5/2016.
 */
public class SeasonListItem {
    public String mSeasonNumber = "";
    public String mSeasonTitle = "";
    public Drawable mSeasonDrawable;

    public SeasonListItem(String seasonNumber, String seasonTitle, Drawable seasonDrawable) {
        mSeasonNumber = seasonNumber;
        mSeasonTitle = seasonTitle;
        mSeasonDrawable = seasonDrawable;
    }
}
