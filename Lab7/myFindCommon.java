/**
 * MyFindCommon class implements the IFindCommon interface and provides a method to find common food items
 * among specified countries based on the input TreeMap containing country-food mappings.
 *
 * @author Nikan Kadkhodazadeh
 * @version 1.0
 * @since Nov 6 2023
 * @see IFindCommon
 */
package Lab7;

import java.util.*;

/**
 * MyFindCommon class implements the IFindCommon interface and provides a method to find common food items
 * among specified countries based on the input TreeMap containing country-food mappings.
 */
class  MyFindCommon implements IFindCommon {

    /**
     * Retrieves a list of common food items among specified countries from the given TreeMap.
     *
     * @param countryFoods A TreeMap containing country-food mappings.
     * @param countries    A list of country names for which common food items need to be found.
     * @return A list of common food items among specified countries, or the food that is popular in the majority
     *         of countries if there is no common food. Returns an empty list if any specified country does not
     *         have food information.
     */
    @Override
    public List<String> getCommonFood(TreeMap<String, TreeSet<String>> countryFoods, List<String> countries) {
        // Create a copy of the first country's food set to perform intersection
        TreeSet<String> commonFoodSet = new TreeSet<>(countryFoods.get(countries.get(0)));

        // Perform intersection with the food sets of other specified countries
        for (String country : countries) {
            TreeSet<String> foods = countryFoods.get(country);
            if (foods != null) {
                commonFoodSet.retainAll(foods);
            } else {
                // If any specified country does not have food information, there can be no common food
                return Collections.emptyList();
            }
        }

        // If there is a common food among all countries, return it
        if (!commonFoodSet.isEmpty()) {
            return new ArrayList<>(commonFoodSet);
        } else {
            // If not, return the food that is popular in the majority of countries
            return new ArrayList<>(countryFoods.get(countries.get(0)));
        }
    }
}
