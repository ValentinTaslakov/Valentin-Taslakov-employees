package services;

import model.Employee;
import model.Pair;
import repositories.PairRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class PairService {
    private final PairRepository pairRepository;

    public PairService() {
        this.pairRepository = new PairRepository();
    }

    public Map<String, ArrayList<Pair>> savePair(Map<Long, List<Employee>> data) {

        for (Map.Entry<Long, List<Employee>> entry : data.entrySet()) {

            List<Employee> employees = entry.getValue();
            findAllPairWithOverlap(employees);

        }
        return this.pairRepository.getDatabase();
    }


    private long calculateOverlap(Employee first, Employee second) {
        LocalDate periodStartDate =
                first.getDateFrom().isBefore(second.getDateFrom()) ?
                        second.getDateFrom() : first.getDateFrom();

        LocalDate periodEndDate =
                first.getDateTo().isBefore(second.getDateTo()) ?
                        first.getDateTo() : second.getDateTo();


        return Math.abs(ChronoUnit.DAYS.between(periodStartDate, periodEndDate));
    }

    public void findAllPairWithOverlap(List<Employee> employees) {
        for (int i = 0; i < employees.size() - 1; i++) {
            for (int j = i + 1; j < employees.size(); j++) {
                Employee first = employees.get(i);
                Employee second = employees.get(j);

                if (first.getDateFrom().isBefore(second.getDateTo())
                        || first.getDateFrom().isEqual(second.getDateTo()) && (first.getDateTo().isAfter(second.getDateFrom())
                        || first.getDateTo().isEqual(second.getDateFrom()))) {

                    long overlapDays = calculateOverlap(first, second);
                    String pairId = String.valueOf(first.getId()) + String.valueOf(second.getId());
                    Pair pair = new Pair(pairId, overlapDays, first.getId(), second.getId(), first.getProjectId());
                    this.pairRepository.setDatabase(pairId, pair);
                }
            }
        }
    }

}
