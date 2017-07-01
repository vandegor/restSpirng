package app.model;

import app.helper.DateHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.List;

public class Insurence {
    private int insurenceNumber;
    @JsonIgnore
    private LocalDate dateOfSigningLocalDate;
    @JsonIgnore
    private LocalDate insurenceEndDateLocalDate;
    private String dateOfSigning;
    private String insurenceEndDate;
    private Car car;
    private List<HistoryEntry> history;

    public int getInsurenceNumber() {
        return insurenceNumber;
    }

    public void setInsurenceNumber(int insurenceNumber) {
        this.insurenceNumber = insurenceNumber;
    }

    public LocalDate getDateOfSigningLocalDate() {
        return dateOfSigningLocalDate;
    }

    public void setDateOfSigningLocalDate(LocalDate dateOfSigningLocalDate) {
        this.dateOfSigning = DateHelper.fromLocalDate (this.dateOfSigningLocalDate = dateOfSigningLocalDate);
    }

    public LocalDate getInsurenceEndDateLocalDate() {
        return insurenceEndDateLocalDate;
    }

    public void setInsurenceEndDateLocalDate(LocalDate insurenceEndDateLocalDate) {
        this.insurenceEndDate = DateHelper.fromLocalDate (this.insurenceEndDateLocalDate = insurenceEndDateLocalDate);
    }

    public String getDateOfSigning() {
        return dateOfSigning;
    }

    public void setDateOfSigning(String dateOfSigning) {
        this.dateOfSigningLocalDate = DateHelper.fromString (this.dateOfSigning = dateOfSigning);
    }

    public String getInsurenceEndDate() {
        return insurenceEndDate;
    }

    public void setInsurenceEndDate(String insurenceEndDate) {
        this.insurenceEndDateLocalDate = DateHelper.fromString (this.insurenceEndDate = insurenceEndDate);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<HistoryEntry> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryEntry> history) {
        this.history = history;
    }
}
