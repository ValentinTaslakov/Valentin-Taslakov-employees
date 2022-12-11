package model;

public class Pair {
    private String pairId;
    private long daysWorkedTogether;
    private long firstEmployeeId;
    private long secondEmployeeId;
    private long projectId;

    public Pair(String pairId, long daysWorkedTogether, long firstEmployeeId, long secondEmployeeId, long projectId) {
        this.pairId = pairId;
        this.daysWorkedTogether = daysWorkedTogether;
        this.firstEmployeeId = firstEmployeeId;
        this.secondEmployeeId = secondEmployeeId;
        this.projectId = projectId;
    }


    public long getDaysWorkedTogether() {
        return daysWorkedTogether;
    }

    public long getFirstEmployeeId() {
        return firstEmployeeId;
    }

    public long getSecondEmployeeId() {
        return secondEmployeeId;
    }

    public long getProjectId() {
        return projectId;
    }

}
