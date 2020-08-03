import task1.DateFormatter;
import task2.UniqueNameFinder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /* TASK1 -------------------------------- */

        List<LocalDate> localDates = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        localDates.add(LocalDate.parse("2020/04/05", formatter));

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        localDates.add(LocalDate.parse("05/04/2020", formatter1));

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        localDates.add(LocalDate.parse("04-05-2020", formatter2));

        System.out.println("Task1 \n");
        System.out.println("Dates before formatting: " + localDates);

        List<String> formattedDates = DateFormatter.formatDate(localDates);

        System.out.println("Dates after formatting: " + formattedDates);

        /* TASK2-----------------------------------*/

        ArrayList<String> strings1 = new ArrayList<>();

        for(int i = 0; i < 1_000; i++){
            strings1.add("a");
        }
        strings1.add("x");
        for(int i = 0; i < 1_000; i++){
            strings1.add("c");
        }

        long before1 = System.nanoTime();
        System.out.println("Unique element is: " + UniqueNameFinder.findUniqueName(strings1));
        long after1 = System.nanoTime() - before1;
        System.out.println("Time of the search: " + after1);

        ArrayList<String> strings2 = new ArrayList<>();

        for(int i = 0; i < 10_000; i++){
            strings2.add("a");
        }
        strings2.add("y");
        for(int i = 0; i < 10_000; i++){
            strings2.add("c");
        }

        long before2 = System.nanoTime();
        System.out.println("Unique element is: " + UniqueNameFinder.findUniqueName(strings2));
        long after2 = System.nanoTime() - before2;
        double difference21 = (double) after2 / after1;
        System.out.println("Time of the search: " + after2);
        System.out.println("After increasing size of the list in 10 times time of the search increases in " + difference21);


        ArrayList<String> strings3 = new ArrayList<>();

        for(int i = 0; i < 100_000; i++){
            strings3.add("a");
        }
        strings3.add("z");
        for(int i = 0; i < 100_000; i++){
            strings3.add("c");
        }

        long before3 = System.nanoTime();
        System.out.println("Unique element is: " + UniqueNameFinder.findUniqueName(strings3));
        long after3 = System.nanoTime() - before3;
        double difference32 = (double) after3 / after2;
        System.out.println("Time of the search: " + after3);
        System.out.println("After increasing size of the list in 10 times time of the search increases in " + difference32);

        ArrayList<String> strings4 = new ArrayList<>();

        for(int i = 0; i < 1_000_000; i++){
            strings4.add("a");
        }
        strings4.add("q");
        for(int i = 0; i < 1_000_000; i++){
            strings4.add("c");
        }

        long before4 = System.nanoTime();
        System.out.println("Unique element is: " + UniqueNameFinder.findUniqueName(strings4));
        long after4 = System.nanoTime() - before4;
        double difference43 = (double) after4 / after3;
        System.out.println("Time of the search: " + after3);
        System.out.println("After increasing size of the list in 10 times time of the search increases in " + difference43);

        /*TASK3-----------------------------------*/

    }
}
