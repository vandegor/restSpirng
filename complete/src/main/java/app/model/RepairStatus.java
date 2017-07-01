package app.model;

import java.util.List;

public class RepairStatus {

    private String currentStatus;
    private List<String> statusHistory;

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public List<String> getStatusHistory() {
        return statusHistory;
    }

    public void setStatusHistory(List<String> statusHistory) {
        this.statusHistory = statusHistory;
    }
}
