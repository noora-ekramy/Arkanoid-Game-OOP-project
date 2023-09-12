# Arkanoid Game - Object-Oriented Programming Project

This is the readme file for the **Arkanoid-Game-OOP-project** repository, a Java-based Arkanoid game developed using object-oriented programming principles.

## Overview

Arkanoid is a classic brick-breaking game where the player controls a paddle to bounce a ball and break bricks. This project implements the Arkanoid game using Java and object-oriented programming (OOP) concepts.

## Table of Contents

- [Gameplay File](#gameplay-file)
- [Game Controls](#game-controls)
- [Gameplay Instructions](#gameplay-instructions)
- [Project Structure](#project-structure)
- [License](#license)

## Gameplay File

The core of the Arkanoid game is implemented in the `gameplay.java` file. This file contains the main game logic, including player control, ball movement, collision detection, and drawing elements on the screen.

## Game Controls

- Use the left arrow key to move the paddle to the left.
- Use the right arrow key to move the paddle to the right.
- Press P to pause and resume the game.
- Press Space to shoot a laser (if available).
- Press Enter to start the game or proceed to the next level.
- Press R to resume the game if it's paused.
- Press M to return to the main menu if the game is paused.
- Press Escape to save your high score (only available at the end of a game).

## Gameplay Instructions

- The objective is to break all the bricks on the screen by bouncing the ball off the paddle.
- Collect power-ups to enhance your gameplay, including a laser to shoot bricks.
- Avoid letting the ball fall below the paddle, or you'll lose a life.
- Complete levels, accumulate points, and try to achieve the highest score possible.
- You can save your high score by pressing Escape at the end of a game.

## Project Structure

The project is organized into packages and consists of multiple Java files. Key components include:

- `gameplay.java`: The main game logic and GUI implementation.
- `mapgenerator.java`: Generates the brick layout for each level.
- `laser.java` and `laser_bullet.java`: Implement the laser power-up functionality.
- `enemy.java`: Represents the enemy character for specific levels.
- `HighscoreFile.java`: Manages high score records.

## License

This project is licensed under the [MIT License](LICENSE).
