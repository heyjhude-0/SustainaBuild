# SustainaBuild — Sustainable City Console Simulator

---

## Description / Overview
**SustainaBuild** is a Java console-based city simulation game where you play as a _sustainable urban planner_.

Your goal: grow a thriving city while balancing:
- 👥 **Population**
- 😊 **Happiness**
- 🌫️ **Pollution**
- 🏙️ **Available Space**

Each building affects the city differently. For example:
- 🏭 **Factory** → +Population, +Pollution  
- 🌳 **Park / Tree** → +Happiness, –Pollution  
- 🏠 **House** → +Population, small space cost  
- 🎢 **ThemePark** → +Happiness, high space cost  

The game ends if the city **runs out of space** or **pollution hits 100%**.

---

## OOP Concepts Applied

### 🔹 **Abstraction**
`Building` is an abstract class defining shared attributes (name, pollutionImpact, etc.) and the abstract method `build()`.

### 🔹 **Encapsulation**
All fields in `Building` and `CityManager` are `private`.  
Only getters/setters expose data safely.

### 🔹 **Inheritance**
Concrete buildings such as `Factory`, `House`, `Park`, `Tree`, `Hospital`, and `Market` all extend `Building`.

### 🔹 **Polymorphism**
Each building overrides `build()`, and at runtime the correct implementation executes depending on the building type.

---

## Program Structure

### 📁 **Folder Layout**
```text
src/
 ├── Main.java
 ├── CityManager.java
 ├── Building.java
 └── buildings/
      ├── Factory.java
      ├── House.java
      ├── Park.java
      ├── Tree.java
      ├── Hospital.java
      ├── Market.java
      └── ThemePark.java

---
