package com.datastructure.fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ProbabilityOfCities {
/*

    You're given a list of city names and their corresponding populations. Write a program to output a random city name,
    subject to the following constraint: the probability of any given city to be in the output should be proportional
     to city population. Assume the program will be repeatedly called many times.

    Example:
            - London: 5 mln 0.5 <-- top probability
            - Berlin: 4 mln 0.4
            - Paris:  1 mln 0.1
*/

    public static void main(String[] args) {
        ProbabilityOfCities sol = new ProbabilityOfCities();

     /*   sol.addCities(new String[][] {
                { "London", "5" },
                { "Berlin", "4" },
                { "Paris", "1" }
        });*/
        sol.addCity("London", 5);
        sol.addCity("Berlin", 4);
        sol.addCity("Paris", 1);

        int n = 10;
        while (n-- > 0) {
            System.out.println(sol.poll());
        }

    }

    class City {
        String name;
        int population;
        int cumulativePopulation;

        City(final String name, final int population, final int totalPopulation) {
            this.name = name;
            this.population = population;
            this.cumulativePopulation = totalPopulation;
        }
    }

    private List<City> cities;
    private int totalPopulation;

    ProbabilityOfCities() {
        this.cities = new ArrayList<>();
        this.totalPopulation = 0;
    }

    private void addCity(final String name, final int population) {
        this.totalPopulation += population;
        this.cities.add(new City(name, population, totalPopulation));
    }

    private void addCities(String[][] cities) {
        int totalPopulation = 0;
        for (String[] city : cities) {
            int population = Integer.parseInt(city[1]);
            this.totalPopulation += population;
            this.cities.add(new City(city[0], population, totalPopulation));
        }
    }

    private String poll() {

        int rand = new Random().nextInt(totalPopulation);
        String city = binarySearch(rand + 1);
        return String.format("Number = %d, City %s", rand, city);
    }

    private String binarySearch(final int number) {
        int left = 0;
        int right = cities.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (cities.get(mid).cumulativePopulation < number) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return cities.get(left).name;

    }

}



