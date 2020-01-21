import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Record> listaRekordow = new ArrayList<>();
        File plik = new File("/home/mateusz/ITCamp-Kraków/2020.01.19-pliki/plik.txt");
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(
                                     plik))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String regex = "^[a-zA-Z0-9]+,[0-9]+,[a-zA-Z]{4,5},[0-9]+\\.[0-9]+,[0-9]+$";
                if(line.matches(regex)){
                    listaRekordow.add(new Record(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd czytania pliku");
            e.printStackTrace();
        }

        System.out.println(listaRekordow);

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("/home/mateusz/ITCamp-Kraków/2020.01.19-pliki/plik2.txt", true))) {

            for(Record record : listaRekordow) {
                bw.write(record.fileToString());
            }

        } catch (IOException e) {
            System.out.println("Błąd pisania pliku");
            e.printStackTrace();
        }

    }
}
