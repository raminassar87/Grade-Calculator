package javawy.gpagradecalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import javawy.gpagradecalculator.utils.AverageCalculator;
import javawy.gpagradecalculator.utils.GradeBean;
import javawy.gpagradecalculator.utils.Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Marks Acttivity
 *
 * @author Rami Nassar
 */
public class MarksActtivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks_acttivity);

        // Disable Old Marks..
        disableMarks();

        // Disable Old Marks..
        disableOldMarks();

        // Add Listeners..
        addListeners();

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    /**
     * Add Listeners
     */
    private void addListeners() {

        // Marks Listener
        marksListener();

        // Old Marks Listeners
        oldMarksListeners();
    }

    /**
     * Old Marks Listeners
     */
    private void oldMarksListeners() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.oldMarkExists1);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableOldScore(1);
            }
        });
        checkBox = (CheckBox) findViewById(R.id.oldMarkExists2);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableOldScore(2);
            }
        });
        checkBox = (CheckBox) findViewById(R.id.oldMarkExists3);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableOldScore(3);
            }
        });
        checkBox = (CheckBox) findViewById(R.id.oldMarkExists4);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableOldScore(4);
            }
        });
        checkBox = (CheckBox) findViewById(R.id.oldMarkExists5);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableOldScore(5);
            }
        });
        checkBox = (CheckBox) findViewById(R.id.oldMarkExists6);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableOldScore(6);
            }
        });
        checkBox = (CheckBox) findViewById(R.id.oldMarkExists7);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableOldScore(7);
            }
        });
        checkBox = (CheckBox) findViewById(R.id.oldMarkExists8);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableOldScore(8);
            }
        });
        checkBox = (CheckBox) findViewById(R.id.oldMarkExists9);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableOldScore(9);
            }
        });
        checkBox = (CheckBox) findViewById(R.id.oldMarkExists10);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableOldScore(10);
            }
        });
    }

    /**
     * Disable Old Marks
     */
    private void disableOldMarks() {

        for(int index = 1; index<=10 ;index++) {
            enableOldScore(index);
        }
    }

    /**
     * Disable Marks..
     */
    private void disableMarks() {

        Spinner spinner = (Spinner) findViewById(R.id.newMark1);
        spinner.setEnabled(false);

        spinner = (Spinner) findViewById(R.id.newMark2);
        spinner.setEnabled(false);

        spinner = (Spinner) findViewById(R.id.newMark3);
        spinner.setEnabled(false);

        spinner = (Spinner) findViewById(R.id.newMark4);
        spinner.setEnabled(false);

        spinner = (Spinner) findViewById(R.id.newMark5);
        spinner.setEnabled(false);

        spinner = (Spinner) findViewById(R.id.newMark6);
        spinner.setEnabled(false);

        spinner = (Spinner) findViewById(R.id.newMark7);
        spinner.setEnabled(false);

        spinner = (Spinner) findViewById(R.id.newMark8);
        spinner.setEnabled(false);

        spinner = (Spinner) findViewById(R.id.newMark9);
        spinner.setEnabled(false);

        spinner = (Spinner) findViewById(R.id.newMark10);
        spinner.setEnabled(false);
    }

    /**
     * Disable Marks
     */
    private void marksListener() {
        Spinner noOfHours = (Spinner) findViewById(R.id.noOfHours1);
        noOfHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                enableScore(position,1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                enableScore(0,1);
            }
        });

        noOfHours = (Spinner) findViewById(R.id.noOfHours2);
        noOfHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                enableScore(position,2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                enableScore(0,2);
            }
        });

        noOfHours = (Spinner) findViewById(R.id.noOfHours3);
        noOfHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                enableScore(position,3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                enableScore(0,3);
            }
        });

        noOfHours = (Spinner) findViewById(R.id.noOfHours4);
        noOfHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                enableScore(position,4);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                enableScore(0,4);
            }
        });

        noOfHours = (Spinner) findViewById(R.id.noOfHours5);
        noOfHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                enableScore(position,5);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                enableScore(0,5);
            }
        });

        noOfHours = (Spinner) findViewById(R.id.noOfHours6);
        noOfHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                enableScore(position,6);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                enableScore(0,6);
            }
        });

        noOfHours = (Spinner) findViewById(R.id.noOfHours7);
        noOfHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                enableScore(position,7);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                enableScore(0,7);
            }
        });

        noOfHours = (Spinner) findViewById(R.id.noOfHours8);
        noOfHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                enableScore(position,8);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                enableScore(0,8);
            }
        });

        noOfHours = (Spinner) findViewById(R.id.noOfHours9);
        noOfHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                enableScore(position,9);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                enableScore(0,9);
            }
        });

        noOfHours = (Spinner) findViewById(R.id.noOfHours10);
        noOfHours.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                enableScore(position,10);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                enableScore(0,10);
            }
        });
    }

    /**
     * Enable Score
     *
     * @param index : CheckBox Index
     */
    public void enableScore(int position,int index) {
        Spinner newMark = null;

        switch (index) {
            case 1:
                newMark = (Spinner) findViewById(R.id.newMark1);
                break;
            case 2:
                newMark = (Spinner) findViewById(R.id.newMark2);
                break;
            case 3:
                newMark = (Spinner) findViewById(R.id.newMark3);
                break;
            case 4:
                newMark = (Spinner) findViewById(R.id.newMark4);
                break;
            case 5:
                newMark = (Spinner) findViewById(R.id.newMark5);
                break;
            case 6:
                newMark = (Spinner) findViewById(R.id.newMark6);
                break;
            case 7:
                newMark = (Spinner) findViewById(R.id.newMark7);
                break;
            case 8:
                newMark = (Spinner) findViewById(R.id.newMark8);
                break;
            case 9:
                newMark = (Spinner) findViewById(R.id.newMark9);
                break;
            case 10:
                newMark = (Spinner) findViewById(R.id.newMark10);
                break;
        }

        if(position == 0) {
            newMark.setEnabled(false);
        } else {
            newMark.setEnabled(true);
        }
    }

    /**
     * Enable Old Score
     * @param index : CheckBox Index
     */
    public void enableOldScore(int index) {
        CheckBox checkBox = null;
        Spinner spinner = null;

        switch (index) {
            case 1:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists1);
                spinner = (Spinner) findViewById(R.id.oldMark1);
                break;
            case 2:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists2);
                spinner = (Spinner) findViewById(R.id.oldMark2);
                break;
            case 3:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists3);
                spinner = (Spinner) findViewById(R.id.oldMark3);
                break;
            case 4:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists4);
                spinner = (Spinner) findViewById(R.id.oldMark4);
                break;
            case 5:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists5);
                spinner = (Spinner) findViewById(R.id.oldMark5);
                break;
            case 6:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists6);
                spinner = (Spinner) findViewById(R.id.oldMark6);
                break;
            case 7:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists7);
                spinner = (Spinner) findViewById(R.id.oldMark7);
                break;
            case 8:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists8);
                spinner = (Spinner) findViewById(R.id.oldMark8);
                break;
            case 9:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists9);
                spinner = (Spinner) findViewById(R.id.oldMark9);
                break;
            case 10:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists10);
                spinner = (Spinner) findViewById(R.id.oldMark10);
                break;
        }

        if(checkBox.isChecked()) {
            spinner.setEnabled(true);
        } else {
            spinner.setEnabled(false);
        }
    }

    /**
     * Populate Grades
     *
     * @return Tree Map contains Grades
     */
    private List<GradeBean> populateGrades() {

        List<GradeBean> grades = new ArrayList<GradeBean>();

        Spinner mark = null;

        Spinner noOfHours = (Spinner) findViewById(R.id.noOfHours1);

        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            mark = (Spinner) findViewById(R.id.newMark1);
            grades.add(new GradeBean(Double.valueOf(mark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        noOfHours = (Spinner) findViewById(R.id.noOfHours2);

        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            mark = (Spinner) findViewById(R.id.newMark2);
            grades.add(new GradeBean(Double.valueOf(mark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        noOfHours = (Spinner) findViewById(R.id.noOfHours3);
        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            mark = (Spinner) findViewById(R.id.newMark3);
            grades.add(new GradeBean(Double.valueOf(mark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        noOfHours = (Spinner) findViewById(R.id.noOfHours4);
        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            mark = (Spinner) findViewById(R.id.newMark4);
            grades.add(new GradeBean(Double.valueOf(mark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        noOfHours = (Spinner) findViewById(R.id.noOfHours5);
        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            mark = (Spinner) findViewById(R.id.newMark5);
            grades.add(new GradeBean(Double.valueOf(mark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        noOfHours = (Spinner) findViewById(R.id.noOfHours6);
        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            mark = (Spinner) findViewById(R.id.newMark6);
            grades.add(new GradeBean(Double.valueOf(mark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        noOfHours = (Spinner) findViewById(R.id.noOfHours7);
        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            mark = (Spinner) findViewById(R.id.newMark7);
            grades.add(new GradeBean(Double.valueOf(mark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        noOfHours = (Spinner) findViewById(R.id.noOfHours8);
        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            mark = (Spinner) findViewById(R.id.newMark8);
            grades.add(new GradeBean(Double.valueOf(mark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        noOfHours = (Spinner) findViewById(R.id.noOfHours9);
        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            mark = (Spinner) findViewById(R.id.newMark9);
            grades.add(new GradeBean(Double.valueOf(mark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        noOfHours = (Spinner) findViewById(R.id.noOfHours10);
        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            mark = (Spinner) findViewById(R.id.newMark10);
            grades.add(new GradeBean(Double.valueOf(mark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        return grades;
    }

    /**
     * populate Replaced Grades..
     *
     * @return Tree Map contains all replaced grades
     */
    private List<GradeBean> populateReplacedGrades() {

        List<GradeBean> oldGrades = new ArrayList<GradeBean>();

        CheckBox checkBox = null;
        Spinner oldMark = null;
        Spinner noOfHours = null;

        checkBox = (CheckBox) findViewById(R.id.oldMarkExists1);
        oldMark = (Spinner) findViewById(R.id.oldMark1);
        noOfHours = (Spinner) findViewById(R.id.noOfHours1);

        if(checkBox.isChecked()) {
            oldGrades.add(new GradeBean(Double.valueOf(oldMark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        checkBox = (CheckBox) findViewById(R.id.oldMarkExists2);
        oldMark = (Spinner) findViewById(R.id.oldMark2);
        noOfHours = (Spinner) findViewById(R.id.noOfHours2);

        if(checkBox.isChecked()) {
            oldGrades.add(new GradeBean(Double.valueOf(oldMark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        checkBox = (CheckBox) findViewById(R.id.oldMarkExists3);
        oldMark = (Spinner) findViewById(R.id.oldMark3);
        noOfHours = (Spinner) findViewById(R.id.noOfHours3);

        if(checkBox.isChecked()) {
            oldGrades.add(new GradeBean(Double.valueOf(oldMark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        checkBox = (CheckBox) findViewById(R.id.oldMarkExists4);
        oldMark = (Spinner) findViewById(R.id.oldMark4);
        noOfHours = (Spinner) findViewById(R.id.noOfHours4);

        if(checkBox.isChecked()) {
            oldGrades.add(new GradeBean(Double.valueOf(oldMark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        checkBox = (CheckBox) findViewById(R.id.oldMarkExists5);
        oldMark = (Spinner) findViewById(R.id.oldMark5);
        noOfHours = (Spinner) findViewById(R.id.noOfHours5);

        if(checkBox.isChecked()) {
            oldGrades.add(new GradeBean(Double.valueOf(oldMark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        checkBox = (CheckBox) findViewById(R.id.oldMarkExists6);
        oldMark = (Spinner) findViewById(R.id.oldMark6);
        noOfHours = (Spinner) findViewById(R.id.noOfHours6);

        if(checkBox.isChecked()) {
            oldGrades.add(new GradeBean(Double.valueOf(oldMark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        checkBox = (CheckBox) findViewById(R.id.oldMarkExists7);
        oldMark = (Spinner) findViewById(R.id.oldMark7);
        noOfHours = (Spinner) findViewById(R.id.noOfHours7);

        if(checkBox.isChecked()) {
            oldGrades.add(new GradeBean(Double.valueOf(oldMark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        checkBox = (CheckBox) findViewById(R.id.oldMarkExists8);
        oldMark = (Spinner) findViewById(R.id.oldMark8);
        noOfHours = (Spinner) findViewById(R.id.noOfHours8);

        if(checkBox.isChecked()) {
            oldGrades.add(new GradeBean(Double.valueOf(oldMark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        checkBox = (CheckBox) findViewById(R.id.oldMarkExists9);
        oldMark = (Spinner) findViewById(R.id.oldMark9);
        noOfHours = (Spinner) findViewById(R.id.noOfHours9);

        if(checkBox.isChecked()) {
            oldGrades.add(new GradeBean(Double.valueOf(oldMark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        checkBox = (CheckBox) findViewById(R.id.oldMarkExists10);
        oldMark = (Spinner) findViewById(R.id.oldMark10);
        noOfHours = (Spinner) findViewById(R.id.noOfHours10);

        if(checkBox.isChecked()) {
            oldGrades.add(new GradeBean(Double.valueOf(oldMark.getSelectedItem().toString()),Integer.valueOf(noOfHours.getSelectedItem().toString())));
        }

        return oldGrades;
    }

    /**
     * Validate Values
     *
     * @return
     */
    private boolean validateValues() {

        EditText oldTotalScoreValue = (EditText) findViewById(R.id.oldTotalScoreValue);
        String oldTotalScoreStr = oldTotalScoreValue.getText().toString();

        EditText oldTotalNoOfHoursValue = (EditText) findViewById(R.id.oldTotalNoOfHoursValue);
        String oldTotalNoOfHoursStr = oldTotalNoOfHoursValue.getText().toString();

        if(Utils.isBlankOrNull(oldTotalScoreStr)) {
            alert(getString(R.string.generalErrorTitleMsg),getString(R.string.oldTotalScoreMandatoryErrorMsg));
            return false;
        } else {
            Double oldTotalScore = Double.valueOf(oldTotalScoreStr);
            if(oldTotalScore > 4) {
                alert(getString(R.string.generalErrorTitleMsg), getString(R.string.oldTotalScoreErrorMsg));
                return false;
            }
        }

        if(Utils.isBlankOrNull(oldTotalNoOfHoursStr)) {
            alert(getString(R.string.generalErrorTitleMsg),getString(R.string.oldTotalNoOfHoursMandatoryErrorMsg));
            return false;
        } else {
            Integer oldTotalScore = Integer.valueOf(oldTotalNoOfHoursStr);
            if(oldTotalScore > 250) {
                alert(getString(R.string.generalErrorTitleMsg), getString(R.string.oldTotalNoOfHoursErrorMsg));
                return false;
            }
        }

        boolean isNewMarkValid = validateMarks();
        if(!isNewMarkValid) {
            return false;
        }

        boolean isOldMarkValid = validateOldMarks();
        if(!isOldMarkValid) {
            return false;
        }

        return true;
    }

    /**
     * Validate Marks
     *
     * @return true if Marks is valid
     */
    private boolean validateMarks() {
        boolean isValid = false;
        for(int index = 1; index<=10 ;index++) {
            isValid = validateMarks(index);
            if(!isValid) {
                return false;
            }
        }
        return true;
    }

    /**
     * Validate Marks
     *
     * @param index : mark index (1-10)
     * @return true if Marks is valid
     */
    private boolean validateMarks(int index) {

        Spinner mark = null;
        Spinner noOfHours = null;

        switch (index) {
            case 1:
                noOfHours = (Spinner) findViewById(R.id.noOfHours1);
                mark = (Spinner) findViewById(R.id.newMark1);
                break;
            case 2:
                noOfHours = (Spinner) findViewById(R.id.noOfHours2);
                mark = (Spinner) findViewById(R.id.newMark2);
                break;
            case 3:
                noOfHours = (Spinner) findViewById(R.id.noOfHours3);
                mark = (Spinner) findViewById(R.id.newMark3);
                break;
            case 4:
                noOfHours = (Spinner) findViewById(R.id.noOfHours4);
                mark = (Spinner) findViewById(R.id.newMark4);
                break;
            case 5:
                noOfHours = (Spinner) findViewById(R.id.noOfHours5);
                mark = (Spinner) findViewById(R.id.newMark5);
                break;
            case 6:
                noOfHours = (Spinner) findViewById(R.id.noOfHours6);
                mark = (Spinner) findViewById(R.id.newMark6);
                break;
            case 7:
                noOfHours = (Spinner) findViewById(R.id.noOfHours7);
                mark = (Spinner) findViewById(R.id.newMark7);
                break;
            case 8:
                noOfHours = (Spinner) findViewById(R.id.noOfHours8);
                mark = (Spinner) findViewById(R.id.newMark8);
                break;
            case 9:
                noOfHours = (Spinner) findViewById(R.id.noOfHours9);
                mark = (Spinner) findViewById(R.id.newMark9);
                break;
            case 10:
                noOfHours = (Spinner) findViewById(R.id.noOfHours10);
                mark = (Spinner) findViewById(R.id.newMark10);
                break;
        }

        if(!noOfHours.getSelectedItem().toString().equals(getString(R.string.noOfHours))) {
            if(mark.getSelectedItem().toString().equals(getString(R.string.mark))) {
                alert(getString(R.string.generalErrorTitleMsg),getString(R.string.markMandatoryErrorMsg));
                return false;
            }
        }

        return true;
    }

    /**
     * Validate Old Marks
     *
     * @return true if Old Marks is valid
     */
    private boolean validateOldMarks() {
        boolean isValid = false;
        for(int index = 1; index<=10 ;index++) {
            isValid = validateOldMarks(index);
            if(!isValid) {
                return false;
            }
        }
        return true;
    }

    /**
     * Validate Old Marks
     *
     * @param index : mark index (1-10)
     * @return true if Old Marks is valid
     */
    private boolean validateOldMarks(int index) {

        CheckBox checkBox = null;
        Spinner spinner = null;

        switch (index) {
            case 1:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists1);
                spinner = (Spinner) findViewById(R.id.oldMark1);
                break;
            case 2:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists2);
                spinner = (Spinner) findViewById(R.id.oldMark2);
                break;
            case 3:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists3);
                spinner = (Spinner) findViewById(R.id.oldMark3);
                break;
            case 4:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists4);
                spinner = (Spinner) findViewById(R.id.oldMark4);
                break;
            case 5:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists5);
                spinner = (Spinner) findViewById(R.id.oldMark5);
                break;
            case 6:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists6);
                spinner = (Spinner) findViewById(R.id.oldMark6);
                break;
            case 7:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists7);
                spinner = (Spinner) findViewById(R.id.oldMark7);
                break;
            case 8:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists8);
                spinner = (Spinner) findViewById(R.id.oldMark8);
                break;
            case 9:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists9);
                spinner = (Spinner) findViewById(R.id.oldMark9);
                break;
            case 10:
                checkBox = (CheckBox) findViewById(R.id.oldMarkExists10);
                spinner = (Spinner) findViewById(R.id.oldMark10);
                break;
        }

        if(checkBox.isChecked()) {
            if(spinner.getSelectedItem().toString().equals(getString(R.string.mark))) {
                alert(getString(R.string.generalErrorTitleMsg),getString(R.string.oldMarkMandatoryErrorMsg));
                return false;
            }
        }

        return true;
    }

    /**
     * Alert Message
     *
     * @param title : Alert title
     * @param message : Alert message
     */
    private void alert(String title,String message) {

        AlertDialog alertDialog = new AlertDialog.Builder(MarksActtivity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "موافق",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    /**
     * Calculate Score
     *
     * @param view : Action Source View
     */
    public void calculateScore(View view) {

        try {
            if (!validateValues()) {
                return;
            }

            List<GradeBean> grades = populateGrades();
            List<GradeBean> oldGrades = populateReplacedGrades();

            EditText oldTotalScoreValue = (EditText) findViewById(R.id.oldTotalScoreValue);
            EditText oldTotalNoOfHoursValue = (EditText) findViewById(R.id.oldTotalNoOfHoursValue);

            Double oldAverage = Double.valueOf(oldTotalScoreValue.getText().toString());
            Integer oldHours = Integer.valueOf(oldTotalNoOfHoursValue.getText().toString());

            if (grades.isEmpty()) {
                alert(getString(R.string.generalErrorTitleMsg), getString(R.string.marksNotExistsErrorMsg));
                return;
            }

            if (!AverageCalculator.validateNoOfReplacedHours(oldGrades, oldHours)) {
                alert(getString(R.string.generalErrorTitleMsg), getString(R.string.oldMarkMoreThanExistsErrorMsg));
                return;
            }

            // Caclulate Average...
            Map<String, Number> results = AverageCalculator.calculateAverage(grades, oldGrades, oldAverage, oldHours);

            NumberFormat formatter = new DecimalFormat("#0.00");

            Double finalAverageSum = (Double) results.get("finalAverageSum");
            Integer finalHoursSum = (Integer) results.get("finalHoursSum");
            Double finalAverage = (Double) results.get("finalAverage");
            Double currentAverage = (Double) results.get("currentAverage");
            Integer currentHoursSum = (Integer) results.get("currentHoursSum");

            Intent intent = new Intent(this, ViewScoreActivity.class);

            intent.putExtra("currentHoursSum", currentHoursSum.toString());
            intent.putExtra("currentAverage", formatter.format(currentAverage));
            intent.putExtra("finalHoursSum", finalHoursSum.toString());
            intent.putExtra("finalAverageSum", finalAverageSum.toString());
            intent.putExtra("finalAverage", formatter.format(finalAverage));

            startActivity(intent);

        } catch(Exception e) {
            alert(getString(R.string.generalErrorTitleMsg), getString(R.string.errorMsg));
        }
    }
}