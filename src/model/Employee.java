package model;

import java.time.LocalDate;

public class Employee {
    private long id;
    private long projectId;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Employee(long id, long projectId, LocalDate dateFrom, LocalDate dateTo) {
        this.id = id;
        this.projectId = projectId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

}
