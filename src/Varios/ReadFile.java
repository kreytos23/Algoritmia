package Varios;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    public static void main(String[] args) {
        Path path = Path.of("src/resources/error.log");
        List<String> listOfErrors = new ArrayList<>();
        /*
        try(Stream<String> lines = Files.lines(path)){
            listOfErrors = lines.filter(n -> n.contains("ERROR")).collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }
         */
        /*
        try{
            List<String> lines = Files.readAllLines(path);
            lines.forEach(n -> {
                if (n.contains("ERROR")) {
                    listOfErrors.add(n);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
        */

        try{
            List<String> lines = Files.readAllLines(path);
            listOfErrors = lines.stream().filter(n -> n.contains("ERROR")).collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }

        Path rutaSalida = Path.of("src/resources/salida.txt");
        try{
            Files.write(rutaSalida, listOfErrors);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
