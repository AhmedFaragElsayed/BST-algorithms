# Self-Balanced Binary Search Trees

## Overview
This project implements and compares two self-balanced binary search tree algorithms: AVL Trees and Red-Black Trees. The implementation provides a comprehensive analysis of their performance characteristics in terms of insertion, search, deletion operations, and tree height.

## Features
- **AVL Trees**: Self-balancing binary search trees where the height difference between left and right subtrees is at most one for every node
- **Red-Black Trees**: Binary search trees with additional color properties that ensure the tree remains balanced
- **Performance Analysis**: Comparison of time complexity for key operations
- **Visual Representation**: Console-based visualization of tree structures

## Implementation Details

The project is structured as follows:

- `BST.java`: Base interface for Binary Search Tree operations
- `AVLTree.java`: Implementation of AVL Tree with balancing operations
- `RedBlackTree.java`: Implementation of Red-Black Tree with color balancing
- `Main.java`: Driver class with demonstration and performance comparison
- `BSTTreesUnitTest.java` : JUnit tests file.

## Usage

The implementation supports the following operations:
- Insert elements
- Search for elements
- Delete elements
- Print tree structure
- Calculate tree height

## Project File Structure
```
BST-algorithms/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── bstalgorithms/
│   │   │       ├── algorithms/
│   │   │       │   ├── Tree.java
│   │   │       │   ├── AVLTree.java
│   │   │       │   └── RedBlackTree.java
│   │   │       ├── CLI/
│   │   │       │   └── DictionaryCLI.java
│   │   │       ├── dictionary/
│   │   │       │   └── BSTTreesDictionary.java
│   │   │       ├── utils/
│   │   │       │   ├── BSTTreesStatistics.java
│   │   │       │   └── ExcelFileHandler.java
│   │   │       └── Main.java
│   └── test/
│       └── java/
│           └── bstalgorithms/
│               └── BSTTreesUnitTest.java
├── pom.xml
├── README.md
└── report.pdf

```

## Performance Comparison

| Operation | AVL Tree | Red-Black Tree |
|-----------|----------|---------------|
| Insertion | O(log n) | O(log n)      |
| Deletion  | O(log n) | O(log n)      |
| Search    | O(log n) | O(log n)      |

While both data structures have the same asymptotic complexity, AVL trees maintain a more rigid balance, resulting in:
- Faster lookups in AVL trees
- Faster insertions and deletions in Red-Black trees
- AVL trees typically have smaller height than Red-Black trees

## Examples

### Using AVL Tree
```java
// Create an AVL tree
AVLTree<Integer> avlTree = new AVLTree<>();

// Insert elements
avlTree.insert(10);
avlTree.insert(5);
avlTree.insert(15);

// Search for an element
boolean exists = avlTree.search(5); // returns true

// Delete an element
avlTree.delete(5);

// Get tree properties
int size = avlTree.size();    // returns 2
int height = avlTree.height(); // returns 2
```

### Using Red-Black Tree
```java
// Create a Red-Black tree
RedBlackTree<String> rbTree = new RedBlackTree<>();

// Insert elements
rbTree.insert("apple");
rbTree.insert("banana");
rbTree.insert("cherry");

// Search for an element
boolean exists = rbTree.search("banana"); // returns true

// Delete an element
rbTree.delete("banana");
```