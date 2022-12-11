package engine;

import fileReader.Reader;
import services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    private final Reader reader;
    private final EmployeeService employeeService;

    public Engine() {
        this.reader = new Reader();
        this.employeeService = new EmployeeService();
    }

    public String run(String filepath) {
        List<String> result = new ArrayList<>();
        try {
            List<String> content = reader.read(filepath);
            this.employeeService.addEmployeeRecords(content);
        } catch (RuntimeException e) {
            return e.getMessage();
        }

        return this.employeeService.getPairOfEmployee();
    }
}
