package app.model;

import app.helper.DateHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;

public class HistoryEntry {
    private int entryId;
    private String dateOfUsage;
    @JsonIgnore
    private LocalDate dateOfUsageLocalDate;
    private String usageReason;

    public int getEntryId() {
        return entryId;
    }


    public String getDateOfUsage() {
        return dateOfUsage;
    }

    public void setDateOfUsage(String dateOfUsage) {
        this.dateOfUsageLocalDate = DateHelper.fromString (this.dateOfUsage = dateOfUsage);
    }

    public LocalDate getDateOfUsageLocalDate() {
        return dateOfUsageLocalDate;
    }

    public void setDateOfUsageLocalDate(LocalDate dateOfUsageLocalDate) {
        this.dateOfUsage = DateHelper.fromLocalDate (this.dateOfUsageLocalDate = dateOfUsageLocalDate);
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }


    public String getUsageReason() {
        return usageReason;
    }

    public void setUsageReason(String usageReason) {
        this.usageReason = usageReason;
    }
}
