package bstalgorithms.dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import bstalgorithms.algorithms.*;



public class BSTTreesDictionary {
    private Tree<String> backend;
    private String type;

    public BSTTreesDictionary(String type) {
        this.type = type;
        build();
    }

    private void build() {
        if (type.equalsIgnoreCase("avl")) {
            backend = new AVLTree<>();
        } else if (type.equalsIgnoreCase("redblack")) {
            backend = new RedBlackTree<>();
        } else {
            // Default to AVL if type is not recognized
            backend = new AVLTree<>();
            System.out.println("Unknown tree type: " + type + ". Defaulting to AVL Tree.");
        }
    }



    public boolean search(String key) {
        return backend.search(key);
    }

    public boolean delete(String key) {
        return backend.delete(key);
    }

    public boolean insert(String key) {
        return backend.insert(key);
    }
    public int size() {
        return backend.size();
    }
    public int height() {
        return backend.height();
    }

    public int[] batchInsert(final String filePath) {
        String modifiedFilePath = filePath.replaceAll("\"","");
        try (BufferedReader reader = new BufferedReader(new FileReader(modifiedFilePath))) {
            String line;
            int newlyAdded = 0;
            int alreadyExisting = 0;

            while ((line = reader.readLine()) != null) {
                String key = line.trim();
                if (!key.isEmpty()) {
                    if (insert(key)) {
                        newlyAdded++;
                    } else {
                        alreadyExisting++;
                    }
                }

                if(newlyAdded % 1 == 0) {
                    System.out.println("Inserted " + newlyAdded + " keys so far...");
                }
            }

            return new int[] { newlyAdded, alreadyExisting };
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return null;
        }
    }

    public int[] batchDelete(final String filePath) {
        String modifiedFilePath = filePath.replaceAll("\"","");
        try (BufferedReader reader = new BufferedReader(new FileReader(modifiedFilePath))) {
            String line;
            int deleted = 0;
            int nonExisting = 0;

            while ((line = reader.readLine()) != null) {
                String key = line.trim();
                if (!key.isEmpty()) {
                    if (delete(key)) {
                        deleted++;
                    } else {
                        nonExisting++;
                    }
                }
            }

            return new int[] { deleted, nonExisting };
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return null;
        }
    }
}
