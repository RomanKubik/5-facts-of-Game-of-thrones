package kubik.roman.gdg;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by roman on 3/6/2016.
 */
public class SpoilerActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvTitle, tvInfo;
    Button btnPrev, btnNext;

    String[] info, title;
    int choose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spoiler);

        Intent intent = getIntent();
        choose = intent.getIntExtra("Season", 0);

        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        Resources resources = getResources();
        title = resources.getStringArray(R.array.seasons_title);
        info = resources.getStringArray(R.array.seasons_info);

        setInformation(choose);

    }

    private void setInformation(int i) {
        tvTitle.setText(title[i]);
        tvInfo.setText(info[i]);
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
                setInformation(--choose);
                break;
            case R.id.btnNext:
                setInformation(++choose);
                break;
        }
    }
}
