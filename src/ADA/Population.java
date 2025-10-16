package ADA;

public class Population {
    public static void main(String[] args) {
        int [] population = {20,10,9,30,20,19};
        String unit = "011011";

        System.out.println(maxPopulation(population, unit));
    }

    public static int maxPopulation(int [] population, String unit){
        //population = [10,5,8,9,6]
        //unit = "01101"
        int n = population.length;
        int maxPopulation = 0;
        char [] unitChar = unit.toCharArray();

        for (int i = 0; i < n ; i++) {
            if (unitChar[i] == '1')
                maxPopulation += population[i];
        }

        for (int i = 1; i < n; i++) {
            if ('0' == unitChar[i - 1] && '1' == unitChar[i]){
                if (population[i - 1] > population[i]){
                    maxPopulation += (long)population[i - 1] - population[i];
                    unitChar[i - 1] = '1';
                    unitChar[i] = '0';
                }
            }
        }
        return maxPopulation;
    }
}
