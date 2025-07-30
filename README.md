# Snap 🃏

**Snap** is a terminal-based simulation of the classic card game *Snap*, written in Java using object-oriented programming (OOP) principles. This project was built as a learning exercise to gain hands-on experience with Java OOP concepts like classes, inheritance, enums, and encapsulation.

## 🎯 Project Objectives

- Practice core OOP techniques in Java
- Model a real-world card game using class hierarchies and interfaces
- Explore interactivity in a console application

## 🧱 Structure Overview

- `Card` — represents a playing card with a `Suit` and `Rank`
- `Suit` & `Rank` — enums representing card characteristics (with symbols and values)
- `CardGame` — a generic card game class, responsible for deck management (shuffle, sort, deal)
- `Player` — represents a human player
- `Snap` — extends `CardGame`, implements logic for single-player and two-player Snap

## ▶️ Gameplay

There are two modes of play:

1. **Single-player** — Press Enter to flip through cards; the game ends automatically when two cards of the same value appear consecutively.
2. **Two-player** — Players take turns; when a Snap occurs, the player must type "snap" quickly, within 2 seconds, to win the game.

## 🛠️ How to Run

### Prerequisites

- Java 8 or later
- IDE like IntelliJ or command-line setup

### Compile and Run

```bash
javac -d out src/org/example/SnapProject/*.java
java -cp out org.example.SnapProject.Main
