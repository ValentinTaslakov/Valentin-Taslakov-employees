package services;

import factories.EmployeeFactory;
import model.Employee;
import model.Pair;
import repositories.EmployeeRepository;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PairService pairService;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
        this.pairService = new PairService();
    }

    public void addEmployeeRecords(List<String> content) {
        try {
            for (String line : content) {
                Employee employee = EmployeeFactory.createEmployee(line);
                long projectId = employee.getProjectId();

                this.employeeRepository.setDatabase(projectId, employee);
            }
        } catch (DateTimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String getPairOfEmployee() {
        Map<Long, List<Employee>> data = this.employeeRepository.getDatabase();
        Map<String, ArrayList<Pair>> savePair = pairService.savePair(data);

        return getPairForLongestPeriod(savePair);
    }

    private String getPairForLongestPeriod(Map<String, ArrayList<Pair>> pairsData) {
        StringBuilder builder = new StringBuilder();

        int sumOfDays = 0;
        List<Pair> pairForLongestPeriod = null;

        for (Map.Entry<String, ArrayList<Pair>> entry : pairsData.entrySet()) {
            List<Pair> pairs = entry.getValue();

            int currentSum = pairs.stream()
                    .map(Pair::getDaysWorkedTogether)
                    .mapToInt(d -> Integer.parseInt(String.valueOf(d)))
                    .sum();
            if (currentSum > sumOfDays) {
                sumOfDays = currentSum;
                pairForLongestPeriod = pairs;
            }
        }
        builder.append(String.format("Days worked together : %d%n", sumOfDays));

        pairForLongestPeriod
                .forEach(pair -> {
                    builder.append(String.format("First employee Id : %d - Second employee Id: %d - Project Id: %s - Days worked: %d %n"
                            , pair.getFirstEmployeeId(), pair.getSecondEmployeeId(),
                            pair.getProjectId(), pair.getDaysWorkedTogether()));
                });


        return builder.toString();
    }
}
