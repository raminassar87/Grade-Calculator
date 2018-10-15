package javawy.newgpagradecalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
/**
 * View Score Activity
 *
 * @author : Rami Nassar
 */
public class ViewScoreActivity extends AppCompatActivity {

    /*
     * Fields
     */

    /** Ad View */
    private AdView mAdView;

    /** Interstitial Ad */
    private InterstitialAd mInterstitialAd;

    /*
     * Methods
     */

    /**
     * On Create
     *
     * @param savedInstanceState : Saved Instance State
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);
        Intent intent = getIntent();

        TextView currentHoursValue = (TextView) findViewById(R.id.currentHoursValue);
        currentHoursValue.setText(intent.getStringExtra("currentHoursSum"));

        TextView currentScoreValue = (TextView) findViewById(R.id.currentScoreValue);
        currentScoreValue.setText(intent.getStringExtra("currentAverage"));

        TextView ratingValue = (TextView) findViewById(R.id.ratingValue);

        String rating = getRating(intent.getStringExtra("finalAverage"));
        ratingValue.setText(rating);

        TextView totalHoursValue = (TextView) findViewById(R.id.totalHoursValue);
        totalHoursValue.setText(intent.getStringExtra("finalHoursSum"));

        TextView totalGradeValue = (TextView) findViewById(R.id.totalGradeValue);
        totalGradeValue.setText(intent.getStringExtra("finalAverage"));

        final String calculationMode = intent.getStringExtra("calculationMode");

        final StringBuffer shareTextObj = new StringBuffer("");
        shareTextObj.append(getString(R.string.share_header)).append("\n");
        shareTextObj.append(getString(R.string.current_hours)).append(" ").append(intent.getStringExtra("currentHoursSum")).append("\n");
        shareTextObj.append(getString(R.string.current_score)).append(" ").append(intent.getStringExtra("currentAverage")).append("\n");
        shareTextObj.append(getString(R.string.total_hours)).append(" ").append(intent.getStringExtra("finalHoursSum")).append("\n");
        shareTextObj.append(getString(R.string.total_grade)).append(" ").append(intent.getStringExtra("finalAverage")).append("\n");
        shareTextObj.append(getString(R.string.rating)).append(" ").append(rating).append("\n");

        Button shareResult = (Button)findViewById(R.id.shareResult);
        shareResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareResult(shareTextObj.toString());
            }
        });

        Button calculateNewScoreButton = (Button)findViewById(R.id.calculateNewScoreButton);
        calculateNewScoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = null;
                if(calculationMode.equals("5")) {
                    intent = new Intent(ViewScoreActivity.this, Marks5Acttivity.class);
                } else {
                    intent = new Intent(ViewScoreActivity.this, MarksActtivity.class);
                }
                startActivity(intent);
            }
        });

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // load Interstitial Ad
        loadInterstitialAd();

        // Show Interstitial Ad
        showInterstitialAd();
    }

    /**
     * Show Interstitial Ad
     */
    private void showInterstitialAd() {
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                }
            }, 2000);
        } catch(Exception e) {
            // Nothing..
        }
    }

    /**
     * Get Rating
     *
     * @param value
     * @return Rating
     */
    private String getRating(String value) {
        String rating = null;
        try {
            Double ratingDouble = Double.valueOf(value);

            if (ratingDouble >= 3.5) {
                rating = "ممتاز";
            } else if (ratingDouble >= 3.0) {
                rating = "جيد جداً";
            } else if (ratingDouble >= 2.5) {
                rating = "جيد";
            } else if (ratingDouble >= 2.0) {
                rating = "مقبول";
            } else {
                rating = "انذار";
            }
        } catch (Exception ex) {
            rating = "";
        }
        return rating;
    }

    /**
     * Calculate New Score
     *
     * @param view : View
     */
    public void calculateNewScore(View view) {
        /*
        Intent intent = new Intent(this, MarksActtivity.class);
        startActivity(intent);
        */
    }

    /**
     * Back Button
     *
     * @param view : View
     */
    public void backButton(View view) {
        super.onBackPressed();
    }

    /**
     * Share Result Intent
     *
     * @param shareBody : Share Body
     */
    private void shareResult(String shareBody) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "معدلي التراكمي");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "معدلي التراكمي"));
    }

    /**
     * load Interstitial Ad
     *
     * @return Interstitial Ad
     */
    private void loadInterstitialAd() {
        try {
            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {}

                @Override
                public void onAdClosed() {}
            });
            AdRequest adRequest = new AdRequest.Builder()
                    .setRequestAgent("android_studio:ad_template").build();
            mInterstitialAd.loadAd(adRequest);

        } catch(Exception e) {
            // Nothing..
        }
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