package bstalgorithms.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.DoubleStream;

import bstalgorithms.algorithms.AVLTree;
import bstalgorithms.algorithms.RedBlackTree;


public class BSTTreesStatistics {
    private static final int DATA_POINTS = 200;
    private static final int MIN_KEYS = 10;
    private static final int MAX_KEYS = 16000;
    private static final double NANO_TO_MILLI = 1e6;
    private static final int MAX_KEY_LENGTH = 32;
    private static final double AVG_RUNS = 1e2;

    private static AVLTree<String> avlTree;
    private static RedBlackTree<String> redBlackTree;




    public static Double measureExecutionTime(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        return (System.nanoTime() - startTime)/NANO_TO_MILLI;
    }


    private static List<String> generateRandomStrings(int count) {
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            StringBuilder keyBuilder = new StringBuilder();
            while (keyBuilder.length() < MAX_KEY_LENGTH) {
                keyBuilder.append(UUID.randomUUID().toString().replace("-", ""));
            }
            String key = keyBuilder.substring(0, MAX_KEY_LENGTH);
            keys.add(key);
        }
        return keys;
    }



    public static void runStatistics(){
        Set<Integer> uniquePoints = new LinkedHashSet<>();
        DoubleStream.iterate(MIN_KEYS,
                n -> n * Math.pow((double) MAX_KEYS / MIN_KEYS, 1.0 / (DATA_POINTS - 1)))
            .limit(DATA_POINTS)
            .mapToInt(n -> (int) Math.round(n))
            .forEach(uniquePoints::add);

        int[] points = uniquePoints.stream().mapToInt(Integer::intValue).toArray();

        ExcelFileHandler insertionStatistics = new ExcelFileHandler("InsertionStatistics");
        insertionStatistics.setRow(new String[]{"Key Count", "AVL Tree Time", "Red Black Tree Time"});

        ExcelFileHandler searchStatistics = new ExcelFileHandler("SearchStatistics");
        searchStatistics.setRow(new String[]{"Key Count", "AVL Tree Time", "Red Black Tree Time"});

        ExcelFileHandler deletionStatistics = new ExcelFileHandler("DeletionStatistics");
        deletionStatistics.setRow(new String[]{"Key Count", "AVL Tree Time", "Red Black Tree Time"});

        ExcelFileHandler heightStatistics = new ExcelFileHandler("HeightStatistics");
        heightStatistics.setRow(new String[]{"Key Count", "AVL Tree Time", "Red Black Tree Time"});



        for(int i = 0; i < points.length; ++i) {
            List<String> keys = generateRandomStrings(points[i]);

            // Run operations multiple times and calculate averages
            double avgAVLInsertionTime = 0;
            double avgRBInsertionTime = 0;
            double avgAVLSearchTime = 0;
            double avgRBSearchTime = 0;
            double avgAVLDeleteTime = 0;
            double avgRBDeleteTime = 0;
            int avgAVLHeight = 0;
            int avgRBHeight = 0;


            for(int j = 0; j < AVG_RUNS; ++j) {

                // AVL TREE operations
                avlTree = new AVLTree<>();
                avgAVLInsertionTime += measureExecutionTime(() -> {
                    for (String key : keys) {
                        avlTree.insert(key);
                    }
                });

                avgAVLHeight += avlTree.height();

                avgAVLSearchTime += measureExecutionTime(() -> {
                    for (String key : keys) {
                        avlTree.search(key);
                    }
                });

                avgAVLDeleteTime += measureExecutionTime(() -> {
                    for (String key : keys) {
                        avlTree.delete(key);
                    }
                });



                // RED BLACK TREE operations
                redBlackTree = new RedBlackTree<>();
                avgRBInsertionTime += measureExecutionTime(() -> {
                    for (String key : keys) {
                        redBlackTree.insert(key);
                    }
                });

                avgRBHeight += redBlackTree.height();

                avgRBSearchTime += measureExecutionTime(() -> {
                    for (String key : keys) {
                        redBlackTree.search(key);
                    }
                });

                avgRBDeleteTime += measureExecutionTime(() -> {
                    for (String key : keys) {
                        redBlackTree.delete(key);
                    }
                });


            }

            // Calculate averages
            avgAVLInsertionTime /= AVG_RUNS;
            avgRBInsertionTime /= AVG_RUNS;
            avgAVLSearchTime /= AVG_RUNS;
            avgRBSearchTime /= AVG_RUNS;
            avgAVLDeleteTime /= AVG_RUNS;
            avgRBDeleteTime /= AVG_RUNS;
            avgAVLHeight = (int)Math.ceil( avgAVLHeight/AVG_RUNS);
            avgRBHeight = (int)Math.ceil( avgRBHeight/AVG_RUNS);


            // Insert data into sheets
            Object[] rowDataInsertion = {(double)points[i], avgAVLInsertionTime, avgRBInsertionTime};
            Object[] rowDataSearch = {(double)points[i], avgAVLSearchTime, avgRBSearchTime};
            Object[] rowDataDeletion = {(double)points[i], avgAVLDeleteTime, avgRBDeleteTime};
            Object[] rowDataHeight = {(double)points[i], avgAVLHeight, avgRBHeight};

            insertionStatistics.setRow(rowDataInsertion);
            searchStatistics.setRow(rowDataSearch);
            deletionStatistics.setRow(rowDataDeletion);
            heightStatistics.setRow(rowDataHeight);
        }

        insertionStatistics.saveToFile();
        searchStatistics.saveToFile();
        deletionStatistics.saveToFile();
        heightStatistics.saveToFile();

        System.out.println("Statistics generated and saved to Excel files.");
    }


}