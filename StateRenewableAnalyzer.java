import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Analyzer for U.S. state renewable electricity data using ArrayList + Scanner + File I/O.
 * CSV expected: Location,TotalGenTWh,PercentRenewable,RenewableGenTWh,PercentOfUSRenewable,CO2MtPerTWh
 */
public class StateRenewableAnalyzer {
    private ArrayList<StateRenewable> states;

    /**
     * Constructor initializes an empty ArrayList.
     */
    public StateRenewableAnalyzer() {
        states = new ArrayList<StateRenewable>();
    }

    /**
     * Reads state data from a CSV file and populates the ArrayList.
     * Assumes the first line is a header.
     * @param filename path to the CSV file
     * @throws IOException if the file is not found
     */
    public void readFromFile(String filename) throws IOException {
        Scanner s = new Scanner(new File(filename));
        s.nextLine();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] items = line.split(",");
            //System.out.println(items[2]);
            StateRenewable temp = new StateRenewable(items[0], Double.parseDouble(items[1]), Double.parseDouble(items[2]), 
                                Double.parseDouble(items[3]), Double.parseDouble(items[4]), Double.parseDouble(items[5]));
            states.add(temp);
        }
        System.out.println(states.size());
        s.close();
    }

    /**
     * Display all states in the list.
     */
    public void displayAllStates() {
        for (StateRenewable s: states) {
            System.out.println(s);
        }
    }

    /**
     * Display states at or above a renewable percent threshold.
     * @param threshold minimum percent renewable to include
     */
    public void displayAbovePercent(double threshold) {
        for (StateRenewable s: states) {
            if (s.isAboveRenewableThreshold(threshold)) System.out.println(s);
        }
    }

    /**
     * Find the state with the highest renewable percent.
     * @return StateRenewable with highest percent, or null if list is empty
     */
    public StateRenewable findHighestPercentRenewable() {
        double max = 0.0;
        StateRenewable state = states.get(0);
        for (StateRenewable s: states) {
            if (s.getPercentRenewable() >= max) {
                state = s;
                max = s.getPercentRenewable();
            }
        }
        return state;
    }

    /**
     * Find the state with the lowest renewable percent.
     * @return StateRenewable with lowest percent, or null if list is empty
     */
    public StateRenewable findLowestPercentRenewable() {
        double min = 0.0;
        StateRenewable state = states.get(0);
        for (StateRenewable s: states) {
            if (s.getPercentRenewable() <= min) {
                state = s;
                min = s.getPercentRenewable();
            }
        }
        return state;
    }

    /**
     * Calculate the average renewable percent across all states.
     * @return average percent, or 0 if list is empty
     */
    public double calculateAveragePercentRenewable() {
        double total = 0;
        if (states.size() == 0) return 0;
        for (StateRenewable s: states) {
            total += s.getPercentRenewable();
        }
        return total/states.size();
    }

    /**
     * Calculate total renewable generation (TWh) across all states.
     * @return sum of renewableGenTWh values
     */
    public double totalRenewableGenTWh() {
        double sum = 0;
        for (StateRenewable s: states) {
            sum += s.getRenewableGenTWh();
        }
        return sum;
    }

    /**
     * Find the state with the highest renewable generation (TWh).
     * @return StateRenewable with highest renewableGenTWh, or null if list is empty
     */
    public StateRenewable findHighestRenewableGen() {
        double max = 0.0;
        StateRenewable state = states.get(0);
        for (StateRenewable s: states) {
            if (s.getRenewableGenTWh() >= max) {
                state = s;
                max = s.getRenewableGenTWh();
            }
        }
        return state;
    }

    /**
     * Display summary statistics.
     */
    public void displayStatistics() {
        for (StateRenewable s: states) {
            System.out.println(s);
        }
    }
}
