package javawy.gpagradecalculator.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AverageCalculator {

    public static void main(String[] args) {
        List<GradeBean> grades = new ArrayList<GradeBean>();

        grades.add(new GradeBean(3.0, 3));
        grades.add(new GradeBean(2.0, 3));
        grades.add(new GradeBean(3.25, 3));
        grades.add(new GradeBean(3.1, 3));
        grades.add(new GradeBean(2.5, 3));
        grades.add(new GradeBean(3.0, 3));
        grades.add(new GradeBean(4.0, 3));
        grades.add(new GradeBean(2.00, 3));

        List<GradeBean> oldGrades = new ArrayList<GradeBean>();
        oldGrades.add(new GradeBean(1.00, 3));

        Double oldAverage = 3.0;
        Integer oldHours = 87;

        // Caclulate Average.
        Map<String,Number> results = calculateAverage(grades,oldGrades,oldAverage,oldHours);

        Double finalAverageSum = (Double)results.get("finalAverageSum");
        Integer finalHoursSum = (Integer)results.get("finalHoursSum");
        Double finalAverage = (Double)results.get("finalAverage");
        Double currentAverage = (Double)results.get("currentAverage");
        Integer currentHoursSum = (Integer)results.get("currentHoursSum");

        NumberFormat formatter = new DecimalFormat("#0.00");

        System.out.println("ساعات الفصل : " + currentHoursSum);
        System.out.println("المعدل الفصلي المتوقع: " + currentAverage);
        System.out.println("الساعات الداخلة في حساب المعدل التراكمي : " + finalHoursSum);
        System.out.println("المعدل التراكمي المتوقع: " + formatter.format(finalAverage));
    }

    /**
     * Calculate Average
     *
     * @param grades : Grades
     * @param replacedGrades : Replaced Grades
     * @param oldAverage : Old Average
     * @param oldHours : Old Hours
     * @return Map contains new calculated grades
     */
    public static Map<String,Number> calculateAverage(List<GradeBean> grades, List<GradeBean> replacedGrades, Double oldAverage, Integer oldHours) {

        Double finalAverage = new Double(0);
        Double finalAverageSum = new Double(0);
        Integer finalHoursSum = new Integer(0);
        Double oldAverageSum = new Double(0);

        Double currentAverageSum = new Double(0);
        Integer currentHoursSum = new Integer(0);
        Double currentAverage = new Double(0);

        Double replacedAverageSum = new Double(0);
        Integer replacedHoursSum = new Integer(0);

        Double netAverageSum = new Double(0);
        Integer netHoursSum = new Integer(0);

        oldAverageSum = oldAverage * oldHours;

        for (GradeBean gradeBean : grades) {

            Double grade = gradeBean.getGrade();
            Integer hours = gradeBean.getNoOfHours();

            currentAverageSum += grade * hours;
            currentHoursSum += hours;
        }
        currentAverage = currentAverageSum / currentHoursSum;

        for (GradeBean replacedGradeBean : replacedGrades) {
            Double grade = replacedGradeBean.getGrade();
            Integer hours = replacedGradeBean.getNoOfHours();

            replacedAverageSum += grade * hours;
            replacedHoursSum += hours;
        }

        netAverageSum = oldAverageSum - replacedAverageSum;
        netHoursSum = oldHours - replacedHoursSum;

        finalAverageSum = netAverageSum + currentAverageSum;
        finalHoursSum = netHoursSum + currentHoursSum;
        finalAverage = finalAverageSum / finalHoursSum;

        Map<String,Number> result = new TreeMap();
        result.put("finalAverageSum",finalAverageSum);
        result.put("finalHoursSum",finalHoursSum);
        result.put("finalAverage",finalAverage);
        result.put("currentAverage",currentAverage);
        result.put("currentHoursSum",currentHoursSum);

        return result;
    }

    /**
     * Validate No Of Replaced Hours
     *
     * @param replacedGrades : Replaced Grades
     * @param numberOfHours : Number Of Hours
     * @return true if No Of Replaced Hours less than or equals original Number Of Hours
     */
    public static boolean validateNoOfReplacedHours(List<GradeBean> replacedGrades,Integer numberOfHours) {

        if(replacedGrades.isEmpty()) {
            return true;
        }

        Integer replacedHoursSum = 0;

        for (GradeBean replacedGradeBean : replacedGrades) {
            Integer hours = replacedGradeBean.getNoOfHours();
            replacedHoursSum += hours;
        }

        if(replacedHoursSum > numberOfHours) {
            return false;
        }
        return true;
    }
}