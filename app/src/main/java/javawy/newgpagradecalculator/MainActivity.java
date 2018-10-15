package javawy.newgpagradecalculator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load Page Add..
        loadPageAdd();
    }

    /**
     * Load Page Add
     */
    private void loadPageAdd() {
        mAdView = (AdView) findViewById(R.id.adViewMain);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    /**
     * Open Grade Calculator..
     *
     * @param view
     */
    public void openGradeCalculator(View view) {
        Intent intent = new Intent(this, MarksActtivity.class);
        startActivity(intent);
    }

    /**
     * Open Grade Calculator..
     *
     * @param view
     */
    public void openGradeCalculator5(View view) {
        Intent intent = new Intent(this, Marks5Acttivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * On Options Item Selected
     *
     * @param item : Menu Item
     * @return boolean Return false to allow normal menu processing to
     *         proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_developer) {
            Intent intent = new Intent(this, DeveloperInfoActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_go_to_home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_rate_this_app) {
            String str ="https://play.google.com/store/apps/details?id=javawy.newgpagradecalculator";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));
            return true;

        } else if (id == R.id.action_close) {
            System.exit(0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}