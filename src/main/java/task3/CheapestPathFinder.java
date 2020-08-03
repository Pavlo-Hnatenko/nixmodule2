package task3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheapestPathFinder {

    private static List<String> cities;
    private static int citiesCount;
    private static int[][] citiesPaths;
    private static String[][] cheapestPaths;
    private static int[] receivedPaths;

    public static void main(String[] args) {
        getCheapestPath();
    }

    public static void getCheapestPath() {

        try {
            readInputFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        findAllPaths();

        try {
            writeOutputFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void findAllPaths() {

        for (int i = 0; i < cheapestPaths.length; i++) {
            String[] path = cheapestPaths[i];
            receivedPaths[i] = findPathByDijkstra(
                    cities.indexOf(path[0]),
                    cities.indexOf(path[1]));
        }

    }

    private static int findPathByDijkstra(int start, int end) {

        boolean[] settled = new boolean[citiesCount];
        int[] distances = new int[citiesCount];
        int priceLimit = 200000;
        Arrays.fill(distances, priceLimit);
        distances[start] = 0;

        for (int i = 0; i < citiesCount; ++i) {
            int intermediate = -1;
            int intermediateDistance = priceLimit;

            for (int j = 0; j < citiesCount; ++j) {
                if (settled[i]) {
                    continue;
                }
                if (intermediateDistance < distances[i]) {
                    continue;
                }
                intermediate = i;
                intermediateDistance = distances[i];
            }

            if (intermediate == -1) break;
            for (int k = 0; k < citiesCount; ++k) {
                int weight = citiesPaths[intermediate][k];
                if (citiesPaths[intermediate][k] != 0 && distances[intermediate] + weight < distances[k]) {
                    distances[k] = distances[intermediate] + weight;
                }
            }
            settled[intermediate] = true;
        }

        return distances[end];
    }


    private static void readInputFile() throws IOException {

        File inputFile = new File("input.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            citiesCount = Integer.parseInt(reader.readLine());
            cities = new ArrayList<>();
            citiesPaths = new int[citiesCount][citiesCount];

            for (int i = 0; i < citiesCount; i++) {
                cities.add(reader.readLine());
                int neighborCount = Integer.parseInt(reader.readLine());

                for (int j = 0; j < neighborCount; j++) {
                    String[] neighbor = reader.readLine().split(" ");
                    int neighborIndex = Integer.parseInt(neighbor[0]);
                    int pathCost = Integer.parseInt(neighbor[1]);
                    citiesPaths[i][neighborIndex - 1] = pathCost;
                }

            }

            int countPathThatNeedToFind = Integer.parseInt(reader.readLine());
            receivedPaths = new int[countPathThatNeedToFind];
            cheapestPaths = new String[countPathThatNeedToFind][2];

            for (int i = 0; i < countPathThatNeedToFind; i++) {
                String[] citiesInPath = reader.readLine().split(" ");
                cheapestPaths[i][0] = citiesInPath[0];
                cheapestPaths[i][1] = citiesInPath[1];
            }

        }
    }

    static void writeOutputFile() throws IOException {

        File outputFile = new File("output.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (int foundPath : receivedPaths) {
                writer.write(foundPath + "\n");
            }
        }
    }

}