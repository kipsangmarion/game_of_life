# Conway's Game of Life

This is a Java implementation of Conway's Game of Life, a cellular automaton devised by John Horton Conway. The code simulates the game in a terminal, representing live cells as 1 and dead cells as 0. It applies the game's rules to update the state of the cells in each generation.

This was done as an assignment project for Object Oriented Programming.

## Prerequisites

- Java Development Kit (JDK) installed on your system
- Command-line interface (CLI) or terminal to run the Java program

## Getting Started

1. Clone or download the repository to your local machine.
2. Navigate to the project directory.

## Usage

1. Open a terminal or command prompt.
2. Compile the Java code by running the following command:
   ```
   javac GameOfLife.java
   ```
3. Run the compiled code with the following command:
   ```
   java GameOfLife
   ```
4. The program will start and display the grid with the initial state of cells.
5. Each generation will be printed in the terminal, showing the updated state of cells according to the rules.
6. The program will continue to simulate the specified number of generations and display them in the terminal.
7. Observe the evolution of the Game of Life based on the initial configuration.

## Customization

- You can modify the code to adjust the size of the grid, initial live cells, and number of iterations.
- To change the grid size, modify the `rows` and `cols` variables in the `main` method.
- To set the initial live cells, update the `grid` array in the `main` method.
- Adjust the `iterations` variable to control the number of generations simulated.

## Notes

- The code includes a `printGrid` method to display the grid after each generation, providing a visual representation of the cells' state.
- The `getNextGeneration` method applies the rules of the Game of Life to compute the state of the next generation.
- The `countLiveNeighbors` method calculates the number of live neighbors for a given cell.
- A 500-millisecond delay is added between generations to make the changes visible in the terminal. You can adjust this delay as needed.

## Acknowledgments

- John Horton Conway for inventing the Game of Life.

