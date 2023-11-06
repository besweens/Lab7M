package Lab7;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @since 6 November 2023
 * @author Julian Edwards
 *
 */
public class mySimilarCountries implements ISimilarCountries
{
    /**
     * @param countryFoodSet a TreeMap with the
     * country’s name as the key, and the values shown as TreeSet holding the popular foods in that country.
     * @return TreeMap that has a country name “A” as the key, and the value is the list of country names
     * that have the highest similarity with the country “A”.
     */
    @Override
    public TreeMap<String, List<String>> getSimilarCountries(final TreeMap<String, TreeSet<String>> countryFoodSet) {
        final TreeMap<String, List<String>> aMap = new TreeMap<>();
        aMap.put("A", countryFoodSet.keySet().stream().sorted(Comparator.comparingInt(this::compareToA)).collect(Collectors.toList()));
        return aMap;
    }

    /**
     * @param str the String to compare
     * @return a long representing how similar {@code str} is to "A" (shorter values = more similar).
     * This prioritizes values that start with the letter A.
     */
    protected int compareToA(final String str) {
        if(str.equals("A")) return Integer.MIN_VALUE;
        else if(str.charAt(0) == 'A' || str.charAt(0) == 'a') return Integer.MIN_VALUE + str.substring(1).compareTo("A");
        return str.compareTo("A");
    }
}
