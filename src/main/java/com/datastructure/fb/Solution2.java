package com.datastructure.fb;

public class Solution2 {
/*

    You're given a list of city names and their corresponding populations. Write a program to output a random city name, subject to the following constraint: the probability of any given city to be in the output should be proportinal to city population. Assume the program will be repeatedly called many times.

    Example:
            - London: 5 mln 0.5 <-- top probability
- Berlin: 4 mln 0.4
            - Paris:  1 mln 0.1

    rnd(LBP) ~33%
    rnd(LLLLLBBBBP)

    Solution sol = new Solution();
sol.addCity("CityName", Population)

    class Solution {

        class City implements Comparble<City> {
            private String name;
            private int population;
            private prob;
        };

        List<City> cites = new Arraylist<>();
        int totalPopulation;

        Solution() {
            totalPopulation = 0;
        }

        public void addCity(String cityName, int population) {
            this.totalPopulation += population;
            cites.add(new City(cityName, population));
            Arrays.sort(cites, (a,b) -> b.population - a.population);
        }

        public String poll() {
            // Randommized O/p. Probablity max of pop
            int random = Random.nextInt(totalPopulation) % cites.size();
            return cites.get(random).name;
        }
*/
}
