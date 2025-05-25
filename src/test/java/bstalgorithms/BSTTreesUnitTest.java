package bstalgorithms;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import bstalgorithms.algorithms.AVLTree;
import bstalgorithms.algorithms.RedBlackTree;

public class BSTTreesUnitTest {

    private static final double NANO_TO_MILLI = 1_000_000.0;

    private static Double measureExecutionTime(Runnable function) {
        long startTime = System.nanoTime();
        function.run();
        return (System.nanoTime() - startTime)/NANO_TO_MILLI;
    }

    private static boolean checkAVLTreeHeightValidity(int height , int size)
    {
        return height <= 1.44*(Math.log(size + 2) / Math.log(2)) - 1.328;
    }
    private static boolean checkRedBlackTreeHeightValidity(int height , int size)
    {
        return height <= 2 * Math.log(size + 1) / Math.log(2);
    }


    @Test
    public void testInsertAlternatingKeys()
    {
        int[] keys = { 5 , 3, 7, 2, 4, 6, 8, 1, 9 };

        AVLTree<Integer> avlTree = new AVLTree<>();
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (int key : keys) {
                avlTree.insert(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (int key : keys) {
                rbTree.insert(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + keys.length + "\n");

        System.out.println("AVL Tree : ");
        System.out.println("Insertion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));


        System.out.println("\nRed-Black Tree :");
        System.out.println("Insertion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());

        System.out.println("--------------------------------------------------\n");


        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));

        for (int key : keys)
        {
            assertTrue(avlTree.search(key));
            assertTrue(rbTree.search(key));
        }
    }

    @Test
    public void testInsertDescendingKeys()
    {
        int[] keys = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        AVLTree<Integer> avlTree = new AVLTree<>();
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (int key : keys) {
                avlTree.insert(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (int key : keys) {
                rbTree.insert(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + keys.length + "\n");

        System.out.println("AVL Tree : ");
        System.out.println("Insertion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));


        System.out.println("\nRed-Black Tree :");
        System.out.println("Insertion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());

        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));

        for (int key : keys)
        {
            assertTrue(avlTree.search(key));
            assertTrue(rbTree.search(key));
        }
    }

    @Test
    public void testInsertAscendingKeys()
    {
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        AVLTree<Integer> avlTree = new AVLTree<>();
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (int key : keys) {
                avlTree.insert(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (int key : keys) {
                rbTree.insert(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + keys.length + "\n");

        System.out.println("AVL Tree : ");
        System.out.println("Insertion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));


        System.out.println("\nRed-Black Tree :");
        System.out.println("Insertion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());

        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));

        for (int key : keys)
        {
            assertTrue(avlTree.search(key));
            assertTrue(rbTree.search(key));
        }
    }


    @Test
    public void testInsertDuplicateStrings()
    {
        String[] keys = { "apple" , "apple" ,"apple" , "apple" , "apple" , "apple", "apple" , "apple" , "apple", "apple" , "apple" , "apple" , "apple" , "apple" , "apple" };

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (String key : keys) {
                avlTree.insert(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (String key : keys) {
                rbTree.insert(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + keys.length + "\n");

        System.out.println("AVL Tree : ");
        System.out.println("Insertion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));


        System.out.println("\nRed-Black Tree :");
        System.out.println("Insertion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());

        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));

        for (String key : keys)
        {
            assertTrue(avlTree.search(key));
            assertTrue(rbTree.search(key));
        }
    }


    @Test
    public void testSearchOnEmptyTree() {

        String keys [] =
        {
            "apple", "banana", "cherry", "date", "elderberry"
        };

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (String key : keys) {
                avlTree.search(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (String key : keys) {
                rbTree.search(key);
            }
        });



        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys Searched for: " + keys.length + "\n");

        System.out.println("AVL Tree : ");
        System.out.println("Searching Time : " + avlTime + "ms");
        System.out.println("Height: " + (avlTree.height()-1));


        System.out.println("\nRed-Black Tree :");
        System.out.println("Searching Time : " + rbTime + "ms");
        System.out.println("Height: " + rbTree.height());

        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));


        for (String key : keys)
        {
            assertFalse(avlTree.search(key));
            assertFalse(rbTree.search(key));
        }

    }


    @Test
    public void testBigDataInsertion()
    {
        final int size = 10000;
        String [] keys = new String[size];
        for (int i = 0; i < size; i++)
        {
            keys[i] = "key" + i;
        }
        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (String key : keys) {
                avlTree.insert(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (String key : keys) {
                rbTree.insert(key);
            }
        });
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + size + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Insertion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Insertion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());

        System.out.println("--------------------------------------------------\n");


        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));

        for (String key : keys)
        {
            assertTrue(avlTree.search(key));
            assertTrue(rbTree.search(key));
        }
    }


    @Test
    public void testDeleteFromEmptyTree() {
        String[] keys =
        {
            "apple", "banana", "cherry", "date", "elderberry"
        };

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (String key : keys) {
                avlTree.delete(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (String key : keys) {
                rbTree.delete(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys Deleted: " + keys.length + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Deletion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Deletion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");


        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));

        for (String key : keys)
        {
            assertFalse(avlTree.delete(key));
            assertFalse(rbTree.delete(key));
        }
    }

    @Test
    public void testDeleteNonExistentElements() {
        String[] keys = { "apple", "banana", "cherry", "date", "elderberry" , "lemon" , "mango" , "pear" , "peach", "plum" , "pomegranete" };

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        // Insert some elements
        for (String key : keys) {
            avlTree.insert(key);
            rbTree.insert(key);
        }

        // Attempt to delete non-existent elements
        String[] nonExistentKeys = { "fig", "grape", "kiwi"  , "nectarine", "orange", "papaya", "quince", "raspberry" };

        Double avlTime = measureExecutionTime(() -> {
            for (String key : nonExistentKeys) {
                avlTree.delete(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (String key : nonExistentKeys) {
                rbTree.delete(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Non-Existent Keys Deleted: " + nonExistentKeys.length + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Deletion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Deletion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));

        for (String key : nonExistentKeys)
        {
            assertFalse(avlTree.delete(key));
            assertFalse(rbTree.delete(key));
        }
    }

    // ...existing code...

    @Test
    public void testMixedInsertAndDelete() {
        String[] keys = { "apple", "banana", "cherry", "date", "elderberry", "fig", "grape" };
        String[] keysToDelete = { "banana", "elderberry", "grape" };

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        // Insert all keys first
        for (String key : keys) {
            avlTree.insert(key);
            rbTree.insert(key);
        }

        Double avlTime = measureExecutionTime(() -> {
            for (String key : keysToDelete) {
                avlTree.delete(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (String key : keysToDelete) {
                rbTree.delete(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + keys.length + ", Keys Deleted: " + keysToDelete.length + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Deletion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Deletion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length - keysToDelete.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length - keysToDelete.length));

        // Verify deleted keys are gone
        for (String key : keysToDelete) {
            assertFalse(avlTree.search(key));
            assertFalse(rbTree.search(key));
        }

        // Verify remaining keys exist
        for (String key : keys) {
            if (!contains(keysToDelete, key)) {
                assertTrue(avlTree.search(key));
                assertTrue(rbTree.search(key));
            }
        }
    }

    private boolean contains(String[] array, String target) {
        for (String item : array) {
            if (item.equals(target)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testSearchExistingKeys() {
        String[] keys = { "apple", "banana", "cherry", "date", "elderberry", "fig", "grape" };

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        // Insert all keys first
        for (String key : keys) {
            avlTree.insert(key);
            rbTree.insert(key);
        }

        Double avlTime = measureExecutionTime(() -> {
            for (String key : keys) {
                avlTree.search(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (String key : keys) {
                rbTree.search(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys Searched: " + keys.length + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Search Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Search Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));

        for (String key : keys) {
            assertTrue(avlTree.search(key));
            assertTrue(rbTree.search(key));
        }
    }

    @Test
    public void testLongStringKeys() {
        String[] keys = {
            "ThisIsAVeryLongStringKeyToTestThePerformanceOfBothTrees_1",
            "ThisIsAVeryLongStringKeyToTestThePerformanceOfBothTrees_2",
            "ThisIsAVeryLongStringKeyToTestThePerformanceOfBothTrees_3",
            "ThisIsAVeryLongStringKeyToTestThePerformanceOfBothTrees_4",
            "ThisIsAVeryLongStringKeyToTestThePerformanceOfBothTrees_5"
        };

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (String key : keys) {
                avlTree.insert(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (String key : keys) {
                rbTree.insert(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + keys.length + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Insertion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Insertion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));

        for (String key : keys) {
            assertTrue(avlTree.search(key));
            assertTrue(rbTree.search(key));
        }
    }

    @Test
    public void testDoubleKeys() {
        Double[] keys = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9 };

        AVLTree<Double> avlTree = new AVLTree<>();
        RedBlackTree<Double> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (Double key : keys) {
                avlTree.insert(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (Double key : keys) {
                rbTree.insert(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + keys.length + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Insertion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Insertion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keys.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keys.length));

        for (Double key : keys) {
            assertTrue(avlTree.search(key));
            assertTrue(rbTree.search(key));
        }
    }

    @Test
    public void testDeleteAllElementsSequentially() {
        String[] keys = { "apple", "banana", "cherry", "date", "elderberry", "fig", "grape" };

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        // Insert all keys first
        for (String key : keys) {
            avlTree.insert(key);
            rbTree.insert(key);
        }

        Double avlTime = measureExecutionTime(() -> {
            for (String key : keys) {
                avlTree.delete(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (String key : keys) {
                rbTree.delete(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys Deleted: " + keys.length + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Deletion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Deletion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, 0));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), 0));

        // Verify all keys are gone
        for (String key : keys) {
            assertFalse(avlTree.search(key));
            assertFalse(rbTree.search(key));
        }
    }

    @Test
    public void testDeleteAllElementsReverse() {
        String[] keys = { "apple", "banana", "cherry", "date", "elderberry", "fig", "grape" };

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        // Insert all keys first
        for (String key : keys) {
            avlTree.insert(key);
            rbTree.insert(key);
        }

        // Delete in reverse order
        Double avlTime = measureExecutionTime(() -> {
            for (int i = keys.length - 1; i >= 0; i--) {
                avlTree.delete(keys[i]);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (int i = keys.length - 1; i >= 0; i--) {
                rbTree.delete(keys[i]);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys Deleted: " + keys.length + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Deletion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Deletion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, 0));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), 0));

        // Verify all keys are gone
        for (String key : keys) {
            assertFalse(avlTree.search(key));
            assertFalse(rbTree.search(key));
        }
    }

    @Test
    public void testRepeatedInsertionsAndDeletions() {
        String[] keys = { "apple", "banana", "cherry", "date", "elderberry" };
        int repetitions = 10;

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (int i = 0; i < repetitions; i++) {
                // Insert all keys
                for (String key : keys) {
                    avlTree.insert(key);
                }
                // Delete all keys
                for (String key : keys) {
                    avlTree.delete(key);
                }
            }
        });

        Double rbTime = measureExecutionTime(() -> {
            for (int i = 0; i < repetitions; i++) {
                // Insert all keys
                for (String key : keys) {
                    rbTree.insert(key);
                }
                // Delete all keys
                for (String key : keys) {
                    rbTree.delete(key);
                }
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + keys.length + ", Repetitions: " + repetitions + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Operation Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Operation Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, 0));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), 0));

        // Verify all keys are gone
        for (String key : keys) {
            assertFalse(avlTree.search(key));
            assertFalse(rbTree.search(key));
        }
    }

    @Test
    public void testVeryLargeDataSet() {
        final int size = 100000;
        Integer[] keys = new Integer[size];
        for (int i = 0; i < size; i++) {
            keys[i] = i;
        }

        AVLTree<Integer> avlTree = new AVLTree<>();
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (int i = 0; i < size; i += 100) { // Insert only 1000 elements to avoid long test time
                avlTree.insert(keys[i]);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (int i = 0; i < size; i += 100) { // Insert only 1000 elements to avoid long test time
                rbTree.insert(keys[i]);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + (size/100) + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Insertion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Insertion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, size/100));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), size/100));
    }

    @Test
    public void testRandomizedInsertionOrder() {
        int size = 100;
        Integer[] keys = new Integer[size];
        for (int i = 0; i < size; i++) {
            keys[i] = i;
        }

        // Shuffle the array to get random insertion order
        java.util.Random random = new java.util.Random(42); // Fixed seed for reproducibility
        for (int i = size-1; i > 0; i--) {
            int j = random.nextInt(i+1);
            // Swap keys[i] and keys[j]
            Integer temp = keys[i];
            keys[i] = keys[j];
            keys[j] = temp;
        }

        AVLTree<Integer> avlTree = new AVLTree<>();
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();

        Double avlTime = measureExecutionTime(() -> {
            for (Integer key : keys) {
                avlTree.insert(key);
            }
        });
        Double rbTime = measureExecutionTime(() -> {
            for (Integer key : keys) {
                rbTree.insert(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + size + "\n");
        System.out.println("AVL Tree : ");
        System.out.println("Insertion Time: " + avlTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));
        System.out.println("\nRed-Black Tree :");
        System.out.println("Insertion Time: " + rbTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, size));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), size));

        for (Integer key : keys) {
            assertTrue(avlTree.search(key));
            assertTrue(rbTree.search(key));
        }
    }

    @Test
    public void testInsertDeleteSearch() {
        String[] keysToInsert = { "apple", "banana", "cherry", "date", "elderberry", "fig", "grape" };
        String[] keysToDelete = { "banana", "elderberry" };
        String[] keysToSearch = { "apple", "banana", "cherry", "date", "elderberry", "fig", "grape" };

        AVLTree<String> avlTree = new AVLTree<>();
        RedBlackTree<String> rbTree = new RedBlackTree<>();

        // Insert phase
        Double avlInsertTime = measureExecutionTime(() -> {
            for (String key : keysToInsert) {
                avlTree.insert(key);
            }
        });
        Double rbInsertTime = measureExecutionTime(() -> {
            for (String key : keysToInsert) {
                rbTree.insert(key);
            }
        });

        // Delete phase
        Double avlDeleteTime = measureExecutionTime(() -> {
            for (String key : keysToDelete) {
                avlTree.delete(key);
            }
        });
        Double rbDeleteTime = measureExecutionTime(() -> {
            for (String key : keysToDelete) {
                rbTree.delete(key);
            }
        });

        // Search phase
        Double avlSearchTime = measureExecutionTime(() -> {
            for (String key : keysToSearch) {
                avlTree.search(key);
            }
        });
        Double rbSearchTime = measureExecutionTime(() -> {
            for (String key : keysToSearch) {
                rbTree.search(key);
            }
        });

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Total Keys: " + keysToInsert.length +
                           ", Deleted: " + keysToDelete.length +
                           ", Searched: " + keysToSearch.length + "\n");

        System.out.println("AVL Tree : ");
        System.out.println("Insertion Time: " + avlInsertTime + " ms");
        System.out.println("Deletion Time: " + avlDeleteTime + " ms");
        System.out.println("Search Time: " + avlSearchTime + " ms");
        System.out.println("Height: " + (avlTree.height()-1));

        System.out.println("\nRed-Black Tree :");
        System.out.println("Insertion Time: " + rbInsertTime + " ms");
        System.out.println("Deletion Time: " + rbDeleteTime + " ms");
        System.out.println("Search Time: " + rbSearchTime + " ms");
        System.out.println("Height: " + rbTree.height());
        System.out.println("--------------------------------------------------\n");

        assertTrue(avlTree.height()-1 <= rbTree.height());
        assertTrue(checkAVLTreeHeightValidity(avlTree.height()-1, keysToInsert.length - keysToDelete.length));
        assertTrue(checkRedBlackTreeHeightValidity(rbTree.height(), keysToInsert.length - keysToDelete.length));

        // Verify deleted keys are gone
        for (String key : keysToDelete) {
            assertFalse(avlTree.search(key));
            assertFalse(rbTree.search(key));
        }

        // Verify remaining keys exist
        for (String key : keysToInsert) {
            if (!contains(keysToDelete, key)) {
                assertTrue(avlTree.search(key));
                assertTrue(rbTree.search(key));
            }
        }
    }
}

















