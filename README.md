# 👻 HorrorGame

A text-based horror adventure game where you explore different rooms, interact with objects and characters, collect items, and uncover the path forward.

The project was originally developed as part of a Software Engineering course and focuses on object-oriented programming, backend development, and interaction between a web frontend and REST API.

## 🎮 About the Game

In **HorrorGame**, you explore a mysterious environment by moving between rooms and interacting with the objects around you.

During the game you can:

* 🚪 Explore different rooms
* 🔎 Examine objects
* 🎒 Collect and use items
* 💬 Interact with characters
* 🧩 Discover clues and solve puzzles
* 🔓 Unlock new areas
* ⚠️ Make choices that affect your progress

Pay attention to your surroundings — not everything you interact with will necessarily help you.

## 🛠️ Tech Stack

### Backend

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge\&logo=springboot\&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge\&logo=apachemaven\&logoColor=white)

### Frontend

![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge\&logo=typescript\&logoColor=white)
![Node.js](https://img.shields.io/badge/Node.js-339933?style=for-the-badge\&logo=nodedotjs\&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge\&logo=html5\&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge\&logo=css3\&logoColor=white)

## 📁 Project Structure

```text
HorrorGame/
│
├── java/
│   └── api/              # Java / Spring Boot backend
│
├── typescript/
│   ├── api/              # Original TypeScript backend
│   └── web/              # Game frontend
│
├── docs/                 # Project documentation
│
└── README.md
```

The project contains two backend implementations:

* **Java / Spring Boot** — the Java implementation of the game API.
* **TypeScript** — the original backend implementation.

The frontend is located inside `typescript/web`.

> **Note:** Only one backend should be running at a time.

# 🚀 How to Play

To play the game locally, you'll need to start the backend and frontend separately.

## Prerequisites

Make sure you have installed:

* **Java JDK 21**
* **Node.js 20+**
* **npm**
* **Maven**

You can verify your installations with:

```bash
java --version
node --version
npm --version
mvn --version
```

## 1. Clone the repository

```bash
git clone https://github.com/Zasreaaz/HorrorGame.git
cd HorrorGame
```

## 2. Install the frontend dependencies

Navigate to the TypeScript directory:

```bash
cd typescript
npm install
```

## 3. Start the Java backend

Open another terminal from the project root and navigate to:

```bash
cd java/api
```

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

Alternatively, you can open the project in **IntelliJ IDEA** and run:

```text
java/api/src/main/java/game.engine.java.api/ApiApplication
```

Keep the backend running while playing.

## 4. Start the game frontend

Open another terminal and navigate to:

```bash
cd typescript/web
```

Then start the frontend:

```bash
npm run dev:web
```

The terminal will display the local address where the game is running.

Open that address in your browser to start playing.

# 🎯 How the Game Works

The game is based around exploring rooms and interacting with entities.

When entering a room, you'll be presented with information about your surroundings and possible interactions.

Your goal is to investigate the environment, collect useful items, interact with characters, and figure out how to progress through the game.

Some actions may unlock new possibilities later, so exploring everything can be important.

# 🧠 What I Learned

This project was primarily focused on improving my understanding of:

* Object-Oriented Programming in Java
* Spring Boot
* REST API development
* Migrating backend functionality from TypeScript to Java
* Inheritance and interfaces
* Game state management
* Frontend/backend communication
* Designing rooms, items, characters, and interactions
* Git and collaborative software development

## 👤 Author

**Rahmi Tas**

Software Engineering student in the Netherlands.

[![GitHub](https://img.shields.io/badge/GitHub-Zasreaaz-181717?style=for-the-badge\&logo=github)](https://github.com/Zasreaaz)

---

⭐ If you found the project interesting, feel free to star the repository!
