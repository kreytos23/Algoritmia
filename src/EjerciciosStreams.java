import utils.Empleado;
import utils.Orden;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjerciciosStreams {
    // Ejercicio 1: Filtrar Números Pares.
    // Recibe una lista de enteros y regresa otra lista solo con los números pares.
    public static List<Integer> filtrarNumerosPares(List<Integer> numeros){
        return numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    // Ejercicio 2: Convertir Strings a Mayúsculas.
    // Recibe una lista de cadenas y regresa una nueva lista con todas en mayúsculas.
    public static List<String> convertirStringsAMayusculas(List<String> cadenas){
        return cadenas.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    // Ejercicio 3: Sumar Números Mayores a 10.
    // Recibe una lista de enteros y regresa la suma de aquellos que son mayores a 10.
    public static int sumarNumerosMayoresA10(List<Integer> numeros){
        return numeros.stream()
                .filter(n -> n > 10)
                .reduce(0, Integer::sum);
    }

    // Ejercicio 4: Ordenar Alfabéticamente.
    // Recibe una lista de cadenas y regresa una lista ordenada alfabéticamente (sin distinguir mayúsculas/minúsculas).
    public static List<String> ordenarAlfabeticamente(List<String> cadenas){
        //return cadenas.stream().map(String::toLowerCase).sorted().collect(Collectors.toList());
        return cadenas.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
    }

    // Ejercicio 5: Eliminar Duplicados.
    // Recibe una lista de enteros y regresa una lista sin valores duplicados.
    public static List<Integer> eliminarDuplicados(List<Integer> numeros){
        return numeros.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // Ejercicio 6: Contar Strings que Empiezan con una Letra.
    // Recibe una lista de cadenas y un carácter, y regresa el número de cadenas que comienzan con ese carácter.
    public static long contarStringsQueEmpiezanCon(List<String> cadenas, char letra){
        return cadenas.stream()
                .filter(n -> n.startsWith(String.valueOf(letra)))
                .count();
    }

    // Ejercicio 7: Encontrar el Valor Máximo.
    // Recibe una lista de enteros y regresa el valor máximo encontrado.
    public static Optional<Integer> encontrarValorMaximo(List<Integer> numeros){
        return numeros.stream()
                .max(Integer::compare);
        //return empleados.stream().max(Comparator.comparingDouble(Empleado::getSalario));
    }

    // Ejercicio 8: Omitir los Primeros N Elementos.
    // Recibe una lista de enteros y un entero n, y regresa la lista omitiendo los primeros n elementos.
    public static List<Integer> omitirPrimerosNElementos(List<Integer> numeros, int n){
        return numeros.stream()
                .skip(n)
                .collect(Collectors.toList());
    }

    // Ejercicio 9: Encontrar el Primer Elemento que Cumpla una Condición.
    // Recibe una lista de cadenas y regresa el primer elemento que tenga más de 5 letras.
    public static Optional<String> encontrarPrimerElementoConMasDe5Letras(List<String> palabras){
        return palabras.stream()
                .filter(n -> n.length() > 5)
                .findFirst();
    }

    // Ejercicio 10: Comprobar Si Existe un Número Divisible por 7.
    // Recibe una lista de enteros y regresa true si existe al menos uno divisible por 7.
    public static boolean existeNumeroDivisiblePor7(List<Integer> numeros){
        return numeros.stream()
                .anyMatch(n -> n % 7 == 0);
    }

    // Ejercicio 11: Verificar que Todas las Cadenas No Estén Vacías.
    // Recibe una lista de cadenas y regresa true si ninguna de ellas es vacía.
    public static boolean verificarTodasCadenasNoVacias(List<String> cadenas){
        return cadenas.stream()
                .noneMatch(String::isEmpty);
        //return cadenas.stream().allMatch(s -> !s.isEmpty());
    }

    // Ejercicio 12: Asegurarse de que Ningún Número Sea Negativo.
    // Recibe una lista de enteros y regresa true si ninguno es negativo.
    public static boolean ningunoNegativo(List<Integer> numeros){
        return numeros.stream()
                .allMatch(n -> n >= 0);
    }

    // Ejercicio 13: Aplanar una Lista de Listas.
    // Recibe una lista de listas de enteros y regresa una lista única con todos los enteros.
    public static List<Integer> aplanarListaDeListas(List<List<Integer>> listaDeListas){
        return listaDeListas.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    // Ejercicio 14: Agrupar Empleados por Departamento.
    // Recibe una lista de Empleado y regresa un mapa donde la clave es el departamento y el valor es la lista de empleados.
    public static Map<String, List<Empleado>> agruparEmpleadosPorDepartamento(List<Empleado> empleados){
        return empleados.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento));
    }

    // Ejercicio 15: Particionar Números en Pares e Impares.
    // Recibe una lista de enteros y regresa un mapa con dos grupos: true para pares y false para impares.
    public static Map<Boolean, List<Integer>> particionarParesEImpares(List<Integer> numeros){
        return numeros.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    // Ejercicio 16: Concatenar Cadenas con Reduce.
    // Recibe una lista de palabras y regresa una cadena resultante de concatenar todas, separadas por espacios.
    public static String concatenarCadenasConReduce(List<String> palabras){
        return palabras.stream()
                .reduce((a,b) -> a + " " + b)
                .orElse("");
        //palabras.stream().collect(Collectors.joining(" "));
    }

    // Ejercicio 17: Calcular la Longitud Promedio de Palabras.
    // Recibe una lista de palabras y regresa el promedio de sus longitudes.
    public static double calcularLongitudPromedioDePalabras(List<String> palabras){
        return palabras.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
    }

    // Ejercicio 18: Estadísticas de Números.
    // Recibe una lista de enteros y regresa un objeto IntSummaryStatistics con suma, promedio, mínimo y máximo.
    public static IntSummaryStatistics estadisticasDeNumeros(List<Integer> numeros){
        return numeros.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
    }

    // Ejercicio 19: Eliminar Palabras Duplicadas.
    // Recibe una lista de cadenas y regresa una lista sin palabras duplicadas.
    public static List<String> eliminarPalabrasDuplicadas(List<String> palabras){
        return palabras.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // Ejercicio 20: Filtrar y Ordenar Órdenes de Compra.
    // Recibe una lista de Orden y un umbral; regresa una lista de órdenes con monto mayor al umbral, ordenadas de forma descendente por monto.
    public static List<Orden> filtrarYOrdenarOrdenesDeCompra(List<Orden> ordenes, double umbral){
        return ordenes.stream()
                .filter(n -> n.getMonto() > umbral)
                .sorted(Comparator.comparingDouble(Orden::getMonto).reversed())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(2,3,4,5,6,7,8,9,12,15,16,20);
        //System.out.println(filtrarNumerosPares(numeros));

        List<String> palabras = Arrays.asList("Hola", "Mundo", "laura", "manzana", "UVA");
        //System.out.println(convertirStringsAMayusculas(palabras));

        List<Integer> numerosEj3 = Arrays.asList(2,3,4,5,6,7,8,9,12,15,16,20,40,50);
        //System.out.println(sumarNumerosMayoresA10(numerosEj3));

        List<String> palabrasEj4 = Arrays.asList("Hola", "Mundo", "laura", "manzana", "UVA");
        //System.out.println(ordenarAlfabeticamente(palabrasEj4));

        List<Integer> numerosEj5 = Arrays.asList(2,3,3,5,5,5,6,7,7,15,16,20,40,50);
        //System.out.println(eliminarDuplicados(numerosEj3));

        List<String> palabrasEj6 = Arrays.asList("Arriba", "Arandano", "Alexa", "manzana", "UVA");
        //System.out.println(contarStringsQueEmpiezanCon(palabrasEj6, 'A'));

        List<Integer> numerosEj7 = Arrays.asList(2,3,3,5,5,5,6,7,7,15,16,20,40,50);
        //System.out.println(encontrarValorMaximo(numerosEj7).get().intValue());

        List<Integer> numerosEj8 = Arrays.asList(2,3,3,5,5,5,6,7,7,15,16,20,40,50);
        //System.out.println(omitirPrimerosNElementos(numerosEj8,3));

        List<String> palabrasEj9 = Arrays.asList("Arr", "Ara", "Alexa", "manzana", "UVA");
        //System.out.println(encontrarPrimerElementoConMasDe5Letras(palabrasEj9).get());

        List<Integer> numerosEj10 = Arrays.asList(2,3,3,5,5,5,6,15,16,20,40,50,7);
        //System.out.println(existeNumeroDivisiblePor7(numerosEj10));

        List<Empleado> listaEmpleado = new ArrayList<>(Arrays.asList(
                new Empleado(1, "Lau", "IT"),
                new Empleado(2, "Alemon", "IT"),
                new Empleado(3, "Cris", "Ventas"),
                new Empleado(4, "Ana", "Ventas"),
                new Empleado(1, "Karla", "HR"),
                new Empleado(1, "Fora", "HR")
        ));
        Map<String, List<Empleado>> map = agruparEmpleadosPorDepartamento(listaEmpleado);
        for (Map.Entry<String, List<Empleado>> entry : map.entrySet()) {
            System.out.println("Departamento: " + entry.getKey());
            System.out.println("Empleados:");
            entry.getValue().forEach(System.out::println);
        }
    }
}