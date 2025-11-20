# SustainaBuild — Sustainable City Console Simulator

---

## 1. Project Title
**SustainaBuild — Sustainable City Console Simulator**

---

## 2. Description / Overview
**SustainaBuild** is a Java console-based simulation game where the player acts as a city planner (imagine Batangas City). The goal is to build and expand the city while balancing **population**, **happiness**, **pollution**, and **available space**. Each building has trade-offs (e.g., a Factory increases population but raises pollution; a Park reduces pollution but uses space). The player continues building until the city runs out of space or pollution reaches a critical level (100%).

---

## 3. OOP Concepts Applied

### Abstraction
The project uses an abstract base class `Building` that defines the core attributes all buildings share: `name`, `populationImpact`, `happinessImpact`, `pollutionImpact`, and `spaceRequired`. This class also declares an abstract method `build()` that every concrete building must implement.

### Encapsulation
All building attributes are declared `private` and accessed via **getters** and **setters**. This prevents direct modification of internal fields and allows controlled access from other classes (for example, `CityManager` reads effects using getters).

### Inheritance
Concrete building types such as `Factory`, `House`, `Hospital`, `Market`, `ThemePark`, `Park`, and `Tree` **extend** the `Building` class. They inherit attributes and behavior from the base class and only specify their unique values and messages.

### Polymorphism
Each subclass **overrides** the `build()` method to provide a different behavior/message when constructed. The rest of the program treats all building objects as type `Building`, but at runtime each one executes its own `build()` implementation.

---

## 4. Program Structure

### Main classes and responsibilities
- **`Building.java`**  
  Abstract base class. Defines attributes and the abstract `build()` method. Implements getters and setters. Concrete building subclasses (Factory, House, Tree, Hospital, Market, ThemePark, Park) provide specific effects and override `build()`.

- **`CityManager.java`**  
  Handles game logic and holds city status: `totalPopulation`, `totalHappiness`, `totalPollution`, `availableSpace`, and optionally `ecoScore`. Implements `addBuilding(Building b)`, `showCityStatus()`, and `isGameOver()` or `updateEcoScore()`. Performs checks (space limit, pollution limit) and throws or returns errors when an action is invalid.

- **`Main.java`**  
  Game loop and user interface (console). Displays intro and menu, reads user input, creates building objects based on user choice, calls `build()` for immediate feedback, and forwards the building to `CityManager` to update totals. Handles input errors with try-catch and ends the game on exit or failure conditions.
