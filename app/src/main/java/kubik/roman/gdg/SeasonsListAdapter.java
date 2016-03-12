package kubik.roman.gdg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by roman on 3/5/2016.
 */
public class SeasonsListAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<SeasonListItem> mObjects;

    SeasonsListAdapter(Context context, ArrayList<SeasonListItem> objects) {
        mContext = context;
        mObjects = objects;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public Object getItem(int position) {
        return mObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        } else {}
        SeasonListItem seasonListItem = mObjects.get(position);
        ((TextView) view.findViewById(R.id.season)).setText(seasonListItem.mSeasonNumber);
        ((TextView) view.findViewById(R.id.title)).setText(seasonListItem.mSeasonTitle);
        ((ImageView) view.findViewById(R.id.poster)).setImageDrawable(seasonListItem.mSeasonDrawable);

        return view;
    }
}
