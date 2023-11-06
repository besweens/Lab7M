//By: Nikan Kadkhodazadeh


package Lab7;

import java.util.*;

class  MyFindCommon implements IFindCommon {
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
