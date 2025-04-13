# Test Aventurier

---

## Description

This project is a simple Java application where a player moves on a map by following moves from a file. The map is made of different cells: some are passable, some are not.

---

## Project Structure

- `app/`
  - `App`: the main entry point of the program

- `exceptions/`
  - `InvalidMapException`: custom exceptions for invalid maps
  - `InvalidStartPositionException`: custom exceptions for invalid inputs

- `model/`
  - `Player`: the character that moves
  - `Map`: the map with cells
  - `Cell`, `EmptyCell`, `WoodCell`: types of cells

- `utils/`
  - `FileUtils`: reads files from resources
  - `InputHandler`: gets the starting position and moves from a file

---

## How It Works

1. The map is loaded from a file in `resources/maps/`
2. The player's starting position and list of moves are read from a file in `resources/input/`
3. The program checks each move and updates the player's position if possible
4. At the end, it prints the final position of the player

---

## How to Use

### With Maven (recommended)

1. Open a terminal in the project folder
2. Make sure your files are in the 'resources/maps' and 'resources/inputs' folder
3. Compile and run the app with:

```bash
mvn compile
mvn exec:java -Dexec.args="yourMap.txt yourInput.txt"
```

### Without Maven

1. Open a terminal in the project folder
2. Make sure your files are in the 'resources/maps' and 'resources/inputs' folder
3. Run the app with:

```bash
java -jar target/testAventurier-1.0-SNAPSHOT.jar yourMap.txt yourInput.txt
```

---