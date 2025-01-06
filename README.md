---

# School Bus Game

School Bus Game is a fun grid-based puzzle game developed using **Java** and **AWT**. Players control a school bus to complete tasks, interact with characters and objects, and challenge their strategic planning skills.

![image](https://github.com/user-attachments/assets/d495d4f0-7dd6-4b0f-9ae4-743de65196c6)

---

## Features

- **Pure Java Implementation**: Built using the **AWT** library to provide a simple yet efficient user interface.
- **Grid-Based Layout**: The game world is displayed in a classic grid format, making it intuitive to navigate.
- **Interactive Gameplay**: Players control the school bus using the keyboard to interact with map elements like characters and trains.
- **Real-Time Status Updates**: The top-left corner displays current game time and turn information.

---

## Project Structure

- **Core Code**
  - `Main.java`: Entry point of the game, responsible for initializing the program.
  - `GameUtils.java`: A utility class based on **AWT** for rendering the game interface and elements.
  - `GameWin.java`: Manages the core game logic, including movement rules, collision detection, and state updates.
- **Resources**
  - Image assets: Graphics for the school bus, characters, and other objects used in the game.

---

## Installation and Running

### 1. **Clone the Project**
Clone the repository locally:
```bash
git clone https://github.com/louis-VI/SchoolBusGame.git
cd SchoolBusGame
```

### 2. **Run the Game**
Ensure **Java 8** or a later version is installed.

#### Using Command Line
```bash
javac -d out src/*.java
java -cp out Main
```

#### Using an IDE
- Open the project in any Java-supporting IDE (e.g., IntelliJ IDEA, Eclipse).
- Import the project as a Java project.
- Run `Main.java`.

---

## Gameplay Instructions

1. After the game starts, use the **arrow keys** to move the school bus on the grid.
2. Complete the objective tasks, such as reaching a specific location or interacting with characters.
3. Press the **space bar** to proceed to the next round.
4. Avoid colliding with obstacles (e.g., trains), as it will result in game failure.

---

## Development Environment

- **Programming Language**: Java
- **Core Library**: AWT
- **Minimum Java Version**: Java 8

---

## Game Screenshot

As shown in the image above, the game interface consists of a grid where players control the school bus to interact with other elements. The real-time status display in the top-left corner helps players track their progress.

---

## Contribution

We welcome contributions! If you find issues or wish to add new features, feel free to submit an issue or create a pull request.

---

## License

This project is licensed under the **MIT License**.

---

### Notes

1. Ensure the image component files are placed in the project root directory to display the game screenshot.
2. The descriptions in this `README.md` reflect the development environment and characteristics of an **AWT**-based implementation.
3. If needed, more technical details (e.g., event listeners and drawing methods) can be added to the game logic section.

--- 
