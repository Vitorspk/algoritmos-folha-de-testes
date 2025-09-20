# Algorithmic Problems in Java

This repository contains a collection of algorithmic problems solved in Java. Each problem is implemented in its own class, from `QuestionA` to `QuestionH`.

## Problems

*   **QuestionA:** Given a 2D bitmap representing an X-ray, count the number of cavities. A cavity is a contiguous region of dark pixels (represented by 1s). This is a variation of the "number of islands" problem.
*   **QuestionB:** Find the longest common prefix among a collection of strings.
*   **QuestionC:** Given an array of integers, find three indices `x`, `y`, and `z` such that `x < y < z` and `A[x] < A[y] < A[z]`.
*   **QuestionD:** Determine if a ransom note can be constructed from the letters available in a magazine.
*   **QuestionE:** Given an office floor plan with engineers, coffee machines, and walls, find the shortest distance from each engineer to the nearest coffee machine. This is a shortest path problem on a grid, solvable with Breadth-First Search (BFS).
*   **QuestionF:** In a cyclic route with `n` gas stations, find a starting station from which a car with an empty tank can complete the entire circuit. The total amount of gas is exactly enough for one round trip.
*   **QuestionG:** This problem has three parts related to balanced parentheses:
    1.  Check if a string of parentheses is balanced.
    2.  Check if a string with multiple types of brackets (`()`, `{}`, `<>`) is balanced and properly nested.
    3.  Print all possible sequences of balanced parentheses for a given size.
*   **QuestionH:** Given a total number of courses and a list of prerequisites, determine if it is possible to complete all courses. This is a topological sort problem to detect cycles in a directed graph.

## How to Compile and Run

You can compile and run these problems using either a Java IDE like Eclipse or from the command line.

### From the Command Line

1.  **Compile:**
    Open a terminal, navigate to the project's `src` directory, and run the following command to compile all the Java files and place the `.class` files in the `bin` directory:
    ```sh
    javac -d ../bin com/ll/studies/questions/*.java
    ```

2.  **Run:**
    From the project's `bin` directory, you can run any of the `Question` classes. For example, to run `QuestionA`:
    ```sh
    java com.ll.studies.questions.QuestionA
    ```
    *Note: Some classes may have a `main` method for direct execution, while others have a `question` method that you might need to call from a separate runner class.*

### In Eclipse

1.  **Import the project:**
    *   Go to `File > Import`.
    *   Select `General > Existing Projects into Workspace`.
    *   Browse to the root directory of this repository and click `Finish`.

2.  **Run a specific problem:**
    *   Open the Java file you want to run (e.g., `QuestionA.java`).
    *   If the file has a `main` method, you can right-click on the file in the Package Explorer and select `Run As > Java Application`.
    *   If the class does not have a `main` method, you will need to create one or call the `question` method from another class that does have a `main` method.

