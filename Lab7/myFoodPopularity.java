/**
 * @author Liban Dahir
 * @version 1.0
 * @since 11/06/2023
 */
import java.util.*;

public class myFoodPopularity implements IFoodPopularity{

	@Override
	public List<String> getFoodPopularity(TreeMap<String, TreeSet<String>> countryFoodSet, List<String> countries1,
			List<String> countries2) {
		List<String> popularFoods = new ArrayList<>();
		// Count the number of countries in countries1 and countries2 that have each food as popular
		TreeMap<String, Integer> foodCount = new TreeMap<>();
		for (String country : countryFoodSet.keySet()) {
			TreeSet<String> foods = countryFoodSet.get(country);
			for (String food : foods) {
				if (!foodCount.containsKey(food)) {
					foodCount.put(food, 0);
				}
				if (countries1.contains(country)) {
					foodCount.put(food, foodCount.get(food) + 1);
				} else if (countries2.contains(country)) {
					foodCount.put(food, foodCount.get(food) - 1);
				}
			}
		}
		// Add the foods that are popular in majority of the countries in countries1
		for (String food : foodCount.keySet()) {
			int count = foodCount.get(food);
			if(count>0 && count>= countries1.size()/2) {
				popularFoods.add(food);
			}
		}
		// Remove the foods that are popular in majority of the countries in countries2
		for (String food : foodCount.keySet())  {
			int count= foodCount.get(food);
			if (count <0 && count<=-countries2.size() /2) {
				popularFoods.remove(food);

			}

		}
		return popularFoods;

	}}
