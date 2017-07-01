package app.model;

import app.helper.DateHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class Repair {
    private int repairId;
    @JsonIgnore
    private LocalDate repairStartDateLocalDate;
    @JsonIgnore
    private LocalDate repairEndDateLocalDate;
    private String repairStartDate;
    private String repairEndDate;
    private int insurenceNumber;
    private Car car;
    private String description;
    private RepairStatus repairStatus;

    public int getRepairId() {
        return repairId;
    }

    public void setRepairId(int repairId) {
        this.repairId = repairId;
    }

    public int getInsurenceNumber() {
        return insurenceNumber;
    }

    public void setInsurenceNumber(int insurenceNumber) {
        this.insurenceNumber = insurenceNumber;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(RepairStatus repairStatus) {
        this.repairStatus = repairStatus;
    }


    public LocalDate getRepairStartDateLocalDate() {
        return repairStartDateLocalDate;
    }

    public void setRepairStartDateLocalDate(LocalDate repairStartDateLocalDate) {
        this.repairStartDate = DateHelper.fromLocalDate (this.repairStartDateLocalDate = repairStartDateLocalDate);
    }

    public LocalDate getRepairEndDateLocalDate() {
        return repairEndDateLocalDate;
    }

    public void setRepairEndDateLocalDate(LocalDate repairEndDateLocalDate) {
        this.repairEndDate = DateHelper.fromLocalDate (this.repairEndDateLocalDate = repairEndDateLocalDate);
    }

    public String getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(String repairStartDate) {
        this.repairStartDateLocalDate = DateHelper.fromString (this.repairStartDate = repairStartDate);
    }

    public String getRepairEndDate() {
        return repairEndDate;
    }

    public void setRepairEndDate(String repairEndDate) {
        this.repairEndDateLocalDate = DateHelper.fromString (this.repairEndDate = repairEndDate);
    }
}
