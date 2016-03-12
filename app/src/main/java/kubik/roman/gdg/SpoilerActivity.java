package kubik.roman.gdg;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by roman on 3/6/2016.
 */
public class SpoilerActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvTitle, tvInfo, tvLinks;
    Button btnPrev, btnNext;
    ImageView imgView;

    int choose;
    boolean links;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spoiler);

        Intent intent = getIntent();
        choose = intent.getIntExtra("Season", 0);
        links = intent.getBooleanExtra("Links", false);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvInfo = (TextView) findViewById(R.id.tvInfo);
        tvLinks = (TextView) findViewById(R.id.tvLinks);
        tvLinks.setMovementMethod(LinkMovementMethod.getInstance());

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);

        imgView = (ImageView) findViewById(R.id.img);

        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        setInformation(choose);

    }

    private void setInformation(int i) {
        Resources resources = getResources();

        String[] title = resources.getStringArray(R.array.seasons_title);
        String[] info = resources.getStringArray(R.array.seasons_info);
        String[] season = resources.getStringArray(R.array.seasons);


        if (links) {
            String[] youtubeLinks = resources.getStringArray(R.array.seasons_links);
            tvLinks.setText(Html.fromHtml("<a href =" + youtubeLinks[i] + "> Click here to watch this epic scene"));
        }

        getSupportActionBar().setTitle(season[i]);

        tvTitle.setText(title[i]);
        tvInfo.setText(info[i] + "\n");


        switch (i) {
            case 0:
                imgView.setImageDrawable(getResources().getDrawable(R.drawable.season1));
            break;
            case 1:
                imgView.setImageDrawable(getResources().getDrawable(R.drawable.season2));
                break;
            case 2:
                imgView.setImageDrawable(getResources().getDrawable(R.drawable.season3));
                break;
            case 3:
                imgView.setImageDrawable(getResources().getDrawable(R.drawable.season4));
                break;
            case 4:
                imgView.setImageDrawable(getResources().getDrawable(R.drawable.season5));
                break;
            default:
                break;
        }

        if (i != 0) {
            if (btnPrev.getVisibility() == View.INVISIBLE) {
                btnPrev.setVisibility(View.VISIBLE);
            }
            btnPrev.setText("Season " + String.valueOf(i));
        } else {
            btnPrev.setVisibility(View.INVISIBLE);
        }
        if (i != title.length - 1) {
            if (btnNext.getVisibility() == View.INVISIBLE) {
                btnNext.setVisibility(View.VISIBLE);
            }
            btnNext.setText("Season " + String.valueOf(i + 2));
        } else {
            btnNext.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPrev:
                if (choose != 0)
                    setInformation(--choose);
                break;
            case R.id.btnNext:
                if (choose != 4)
                setInformation(++choose);
                break;
            default:
                break;
        }
    }
}
