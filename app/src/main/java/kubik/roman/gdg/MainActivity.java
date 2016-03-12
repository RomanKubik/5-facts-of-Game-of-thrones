package kubik.roman.gdg;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvSeasons;
    CheckBox chbLinks;

    ArrayList<SeasonListItem> seasonArrayList = new ArrayList<SeasonListItem>();
    SeasonsListAdapter seasonsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillData();
        seasonsAdapter = new SeasonsListAdapter(this, seasonArrayList);

        lvSeasons = (ListView) findViewById(R.id.list_of_seasons);
        lvSeasons.setAdapter(seasonsAdapter);
        chbLinks = (CheckBox) findViewById(R.id.chbLinks);

        lvSeasons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SpoilerActivity.class);
                intent.putExtra("Season", position);
                if (chbLinks.isChecked()) {
                    intent.putExtra("Links", true);
                } else {
                    intent.putExtra("Links", false);
                }
                startActivity(intent);
            }
        });

    }

    private void fillData() {
        Resources resources = getResources();
        String[] seasons = resources.getStringArray(R.array.seasons);
        String[] titles = resources.getStringArray(R.array.seasons_title);
        Drawable[] drawables = new Drawable[seasons.length];
        drawables[0] = getDrawable(R.drawable.season_poster_1);
        drawables[1] = getDrawable(R.drawable.season_poster_2);
        drawables[2] = getDrawable(R.drawable.season_poster_3);
        drawables[3] = getDrawable(R.drawable.season_poster_4);
        drawables[4] = getDrawable(R.drawable.season_poster_5);
        for (int i = 0; i < seasons.length; i++) {
            seasonArrayList.add(new SeasonListItem(seasons[i], titles[i], drawables[i]));
        }
    }
}
