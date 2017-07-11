package javawy.gpagradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadPageAdd();
    }

    private void loadPageAdd() {
        mAdView = (AdView) findViewById(R.id.adViewMain);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void openGradeCalculater(View view) {

        Intent intent = new Intent(this, MarksActtivity.class);
        startActivity(intent);

        /*
        Spinner gradeMode = (Spinner) findViewById(R.id.gradeMode);

        int position = gradeMode.getSelectedItemPosition();
        if (position == 0) {
            String text = getString(R.string.percent_not_done);
            Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
            toast.show();
            return;
        } else if (position == 1) {
            Intent intent = new Intent(this, AddMobActivity.class);
            startActivity(intent);
            Intent intent = new Intent(this, AddMarksActtivity.class);
            startActivity(intent);
        }

        String text = gradeMode.getSelectedItem() + " / " + gradeMode.getSelectedItemId() + " / " + gradeMode.getSelectedItemPosition();
        */
    }
}