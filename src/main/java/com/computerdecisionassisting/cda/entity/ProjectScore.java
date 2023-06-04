package com.computerdecisionassisting.cda.entity;

import java.math.BigDecimal;

import static com.computerdecisionassisting.cda.helpers.Constants.*;

public class ProjectScore {

    private String projectName;
    private BigDecimal projectEarnings;
    private BigDecimal numberOfEmployees;
    private BigDecimal clientScore;
    private BigDecimal slaValue;
    private BigDecimal innerScore;
    private BigDecimal teamCoverage;

    private Long totalProjectScore;

    public ProjectScore(String projectName, BigDecimal projectEarnings, BigDecimal numberOfEmployees, BigDecimal clientScore, BigDecimal slaValue, BigDecimal innerScore, BigDecimal teamCoverage) {
        this.projectName = projectName;
        this.projectEarnings = projectEarnings;
        this.numberOfEmployees = numberOfEmployees;
        this.clientScore = clientScore;
        this.slaValue = slaValue;
        this.innerScore = innerScore;
        this.teamCoverage = teamCoverage;
    }

    public ProjectScore() {
    }

    public String getProjectName() {
        return projectName;
    }

    public BigDecimal getProjectEarnings() {
        return projectEarnings;
    }

    public BigDecimal getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public BigDecimal getClientScore() {
        return clientScore;
    }

    public BigDecimal getSlaValue() {
        return slaValue;
    }

    public BigDecimal getInnerScore() {
        return innerScore;
    }

    public BigDecimal getTeamCoverage() {
        return teamCoverage;
    }

    public Long getTotalProjectScore() {
        return totalProjectScore;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectEarnings(BigDecimal projectEarnings) {
        this.projectEarnings = projectEarnings;
    }

    public void setNumberOfEmployees(BigDecimal numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setClientScore(BigDecimal clientScore) {
        this.clientScore = clientScore;
    }

    public void setSlaValue(BigDecimal slaValue) {
        this.slaValue = slaValue;
    }

    public void setInnerScore(BigDecimal innerScore) {
        this.innerScore = innerScore;
    }

    public void setTeamCoverage(BigDecimal teamCoverage) {
        this.teamCoverage = teamCoverage;
    }

    public void setTotalProjectScore(Long totalProjectScore) {
        this.totalProjectScore = totalProjectScore;
    }

    public Long scoreCalculation() {
        BigDecimal totalScore = calculateFirstGrade().add(calculateSecondGrade()).add(calculateThirdGrade()).add(calculateFourthGrade()).add(calculateFifthGrade());
        return totalScore.longValue();
    }

    private BigDecimal calculateFirstGrade() {
        BigDecimal earnings = getProjectEarnings().multiply(ONE_THOUSAND_BIG_DECIMAL);
        if(earnings.compareTo(MINUS_ONE_HUNDRED_THOUSANDS_BIG_DECIMAL) == -1) earnings = MINUS_ONE_HUNDRED_THOUSANDS_BIG_DECIMAL;
        if(earnings.compareTo(ONE_HUNDRED_THOUSANDS_BIG_DECIMAL) == -1) earnings = ONE_HUNDRED_THOUSANDS_BIG_DECIMAL;
        return earnings.divide(TWO_BIG_DECIMAL).add(FIFTY_BIG_DECIMAL);
    }

    private BigDecimal calculateSecondGrade() {
        return clientScore.multiply(TEN_BIG_DECIMAL);
    }

    private BigDecimal calculateThirdGrade() {
        return getSlaValue().multiply(ONE_HUNDRED_BIG_DECIMAL);
    }

    private BigDecimal calculateFourthGrade(){
        return getInnerScore().multiply(TEN_BIG_DECIMAL);
    }

    private BigDecimal calculateFifthGrade() {
        if(teamCoverage.compareTo(ONE_HUNDRED_BIG_DECIMAL) == 1) return teamCoverage.multiply(ONE_HUNDRED_BIG_DECIMAL).subtract(ONE_HUNDRED_BIG_DECIMAL);
        return BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return "ProjectScore{" +
                "projectName='" + projectName + '\'' +
                ", projectEarnings=" + projectEarnings +
                ", numberOfEmployees=" + numberOfEmployees +
                ", clientScore=" + clientScore +
                ", slaValue=" + slaValue +
                ", innerScore=" + innerScore +
                ", teamCoverage=" + teamCoverage +
                ", totalProjectScore=" + totalProjectScore +
                '}';
    }
}
