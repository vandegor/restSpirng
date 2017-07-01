package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Car {
    private String plateNumber;
    private String manufacturer;
    private String model;
    @JsonIgnore
    private Insurence insurence;
    @JsonIgnore
    private Repair repair;

    public String getPlateNumber() {
        return plateNumber;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Insurence getInsurence() {
        return insurence;
    }

    public void setInsurence(Insurence insurence) {
        this.insurence = insurence;
    }
}
