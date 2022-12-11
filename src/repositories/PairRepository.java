package repositories;

import model.Pair;

import java.util.*;

public class PairRepository {

    private Map<String, ArrayList<Pair>> database;

    public PairRepository() {
        this.database = new HashMap<>();
    }

    public Map<String, ArrayList<Pair>> getDatabase() {
        return Collections.unmodifiableMap(database);
    }

    public void setDatabase(String pairId, Pair pair) {
        this.database.putIfAbsent(pairId, new ArrayList<>());
        this.database.get(pairId).add(pair);

    }
}
