package ArraysAndStrings;

public class ClosestToZero {
    public static void main(String[] args) {
        int[] nums = {-4,-2,1,4,8};
        System.out.println(findClosestNumber(nums));
    }

    public static int findClosestNumber(int[] nums) {
        int closest = nums[0]; // Inicializa 'closest' con el primer elemento del array
        for (int i : nums) {
            // Caso 1: Si ambos, 'closest' y 'i' son negativos, y 'i' es mayor (más cercano a cero)
            if (closest <= 0 && i <= 0 && i > closest) {
                closest = i;
            }
            // Caso 2: Si 'closest' es negativo y 'i' es positivo, y el valor absoluto de 'closest' es mayor o igual a 'i'
            else if (closest <= 0 && i >= 0 && -closest >= i) {
                closest = i;
            }
            // Caso 3: Si 'closest' es positivo y 'i' es negativo, y el valor absoluto de 'i' es menor que 'closest'
            else if (closest >= 0 && i <= 0 && closest > -i) {
                closest = i;
            }
            // Caso 4: Si ambos, 'closest' y 'i' son positivos, y 'i' es menor que 'closest'
            else if (closest >= 0 && i >= 0 && closest > i) {
                closest = i;
            }
        }
        return closest; // Devuelve el número más cercano a cero
    }
}
