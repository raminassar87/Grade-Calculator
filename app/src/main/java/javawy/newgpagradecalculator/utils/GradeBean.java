package javawy.newgpagradecalculator.utils;

/**
 * Created by Rami Nassar on 7/5/2017.
 */

public class GradeBean {

    private Integer sequence;
    private Integer noOfHours;
    private Double grade;
    private boolean isReplaced;

    public GradeBean(Double grade,Integer noOfHours) {
        this.grade = grade;
        this.noOfHours = noOfHours;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(Integer noOfHours) {
        this.noOfHours = noOfHours;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public boolean isReplaced() {
        return isReplaced;
    }

    public void setReplaced(boolean replaced) {
        isReplaced = replaced;
    }
}
