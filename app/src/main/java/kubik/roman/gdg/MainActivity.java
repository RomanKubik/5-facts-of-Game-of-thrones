package kubik.roman.gdg;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvSeasons;

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

        lvSeasons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SpoilerActivity.class);
                intent.putExtra("Season", position);
                startActivity(intent);
            }
        });

    }

    private void fillData() {
        Resources resources = getResources();
        String[] seasons = resources.getStringArray(R.array.seasons);
        String[] titles = resources.getStringArray(R.array.seasons_title);
        for (int i = 0; i < seasons.length; i++) {
            seasonArrayList.add(new SeasonListItem(seasons[i], titles[i]));
        }
    }
}
