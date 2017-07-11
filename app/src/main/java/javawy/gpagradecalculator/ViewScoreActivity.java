package javawy.gpagradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class ViewScoreActivity extends AppCompatActivity {
    private AdView mAdView;

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
        String rating = getRating(Double.valueOf(intent.getStringExtra("finalAverage")));
        ratingValue.setText(rating);

        TextView totalHoursValue = (TextView) findViewById(R.id.totalHoursValue);
        totalHoursValue.setText(intent.getStringExtra("finalHoursSum"));

        TextView totalGradeValue = (TextView) findViewById(R.id.totalGradeValue);
        totalGradeValue.setText(intent.getStringExtra("finalAverage"));

        final StringBuffer shareTextObj = new StringBuffer("");
        shareTextObj.append(getString(R.string.share_header)).append("\n");
        shareTextObj.append(getString(R.string.current_hours)).append(" : ").append(intent.getStringExtra("currentHoursSum")).append("\n");
        shareTextObj.append(getString(R.string.current_score)).append(" : ").append(intent.getStringExtra("currentAverage")).append("\n");
        shareTextObj.append(getString(R.string.total_hours)).append(" : ").append(intent.getStringExtra("finalHoursSum")).append("\n");
        shareTextObj.append(getString(R.string.total_grade)).append(" : ").append(intent.getStringExtra("finalAverage")).append("\n");
        shareTextObj.append(getString(R.string.rating)).append(" : ").append(rating).append("\n");

        Button shareResult = (Button)findViewById(R.id.shareResult);
        shareResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareResult(shareTextObj.toString());
            }
        });

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    /**
     * Get Rating
     *
     * @param value
     * @return Rating
     */
    private String getRating(Double value) {
        String rating = null;

        if(value >= 3.5) {
            rating = "ممتاز";
        } else if(value >= 3.0) {
            rating = "جيد جداً";
        } else if(value >= 2.5) {
            rating = "جيد";
        } else if(value >= 2.0) {
            rating = "مقبول";
        } else {
            rating = "انذار";
        }

        return rating;
    }

    /**
     * Calculate New Score
     *
     * @param view : View
     */
    public void calculateNewScore(View view) {
        Intent intent = new Intent(this, MarksActtivity.class);
        startActivity(intent);
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
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));

//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_TEXT, text);
//        shareActionProvider.setShareIntent(intent);
    }
}