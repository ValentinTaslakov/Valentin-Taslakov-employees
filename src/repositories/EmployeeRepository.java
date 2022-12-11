package repositories;

import model.Employee;

import java.util.*;

public class EmployeeRepository {
    private Map<Long, List<Employee>> database;

    public EmployeeRepository() {
        this.database = new HashMap<>();
    }

    public Map<Long, List<Employee>> getDatabase() {
        return Collections.unmodifiableMap(database);
    }

    public void setDatabase(Long projectId, Employee employee) {
        this.database.putIfAbsent(projectId, new ArrayList<>());
        this.database.get(projectId).add(employee);
    }
}
