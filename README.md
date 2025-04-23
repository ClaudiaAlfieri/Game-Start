# Game Start 🎮

This project was developed as the final assignment for the **Java** course in the Front-End program at CESAE Digital. "Game Start" is a console application for sales management of a gaming company, designed to showcase programming fundamentals and algorithmic thinking in Java.

## 📋 Project Overview

Game Start is a console-based application that allows users to manage sales data for a gaming company with multiple permission levels. The system reads and processes data from a CSV file and provides various analysis and management features.

### 🔐 User Authentication System
- Login system with password protection for administrative access
- Different menu options based on user roles (Admin or Client)
- Secure administrative functions

### 🎮 Game Management
- Display available games from the database
- Remove duplicate game entries when displaying
- Categorize games by publisher

### 💼 Sales Management
- Calculate total sales and accumulated value
- Calculate profits (20% of total sales)
- Identify the most expensive game sold and its buyer
- Identify the best customer and their purchase history

### 👥 Access Levels
- **Administrator**: Full access to sales data and analysis
- **Client**: Access to registration, game listings, and basic queries

## ✨ Features
- ASCII art welcome screen
- Intuitive menu-driven interface
- File I/O operations with CSV data processing
- Customer registration system
- Publisher-based game search
- Available parking spaces calculator using triangular numbers

## 🛠️ Technologies Used
- **Java**: Programming language
- **File I/O**: For reading data from CSV files
- **Scanner**: For user input and file reading
- **Arrays & Matrices**: For data storage and manipulation
- **Functions**: Modular code organization

## 🚀 Requirements
- Java Development Kit (JDK) 8 or higher
- CSV file with proper formatting (GameStart_V2.csv)
- Command-line interface

## 🔄 Installation
1. Clone the repository:
   ```
   git clone https://github.com/your-username/game-start.git
   cd game-start
   ```
2. Compile the Java code:
   ```
   javac TrabalhoPCE_Claudia_Alfieri.java
   ```
3. Run the application:
   ```
   java TrabalhoPCE_Claudia_Alfieri
   ```
4. Ensure the CSV file "GameStart_V2.csv" is in the same directory as the application


## ⚙️ Main Functions
- **menuPrincipal**: Main menu navigation
- **menuAdmin**: Administrative functions menu
- **menuCliente**: Client functions menu
- **imprimirAll**: Display all sales data
- **totalVendas**: Calculate total sales
- **lucroTotal**: Calculate total profit
- **mostrarCliente**: Display client information
- **jogoMaisCaro**: Find most expensive game sold
- **melhorCliente**: Identify best customer
- **registro**: Register new client
- **estacionamento**: Calculate available parking spaces
- **jogos**: List available games
- **mostrarEditora**: Search games by publisher

## 👨‍💻 Author
This project was developed by Claudia Alfieri for educational purposes.

## 📝 Contribution
Contributions are welcome through pull requests.
