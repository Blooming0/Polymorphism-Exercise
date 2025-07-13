# 🚗 Vehicle Rental System – Java OOP Project

## 📋 Overview
This Java project is a **console-based Vehicle Rental System** that allows users to rent **Cars**, **Bikes**, or **Trucks**, and view rented vehicles. It demonstrates key OOP principles including:

- Inheritance  
- Interfaces  
- Polymorphism  
- Method overriding  
- File handling (reading and writing `.txt` files)

## 📁 Project Structure

```
src/
└── vehicles/
    ├── available-vehiles/
    │   ├── cars.txt
    │   ├── bikes.txt
    │   └── trucks.txt
    └── rented-vehicles/
        └── rented.txt
```

## 🧠 Key Classes

### ✅ `Vehicle` (interface)
Defines common behavior for all vehicle types:
```java
double calculateRentalCost();
void displayDetails();
```

### ✅ `Car`, `Bike`, `Truck`
Each implements `Vehicle`, with:
- Custom fields (`model`, `brand`, `type`)
- Rental duration: days for Car, hours for Bike, weeks for Truck
- Overridden `displayDetails()` and `calculateRentalCost()`

### ✅ `Main`
The controller class that handles:
- Menu interaction with the user
- Renting process based on user choice
- Reading/writing to `.txt` files
- Updating available/rented vehicles

## 🖥️ How It Works

### 📌 Menu Options:
```
1. Rent a Car
2. Rent a Bike
3. Rent a Truck
4. View Rented Vehicles
5. Exit
```

### 🚘 Renting Flow:
1. User selects a vehicle type and rental duration.
2. The system reads available models from file.
3. User selects a model to rent.
4. The selected vehicle is:
   - Displayed with full rental cost
   - Added to `rented.txt`
   - Removed from the available vehicles file

### 📄 View Rented Vehicles:
- Reads all lines from `rented.txt` and prints them to console.

## 📚 OOP Concepts Demonstrated

| Concept           | How it's used                          |
|------------------|-----------------------------------------|
| Inheritance       | `Car`, `Bike`, and `Truck` implement `Vehicle` |
| Polymorphism      | All vehicle types used via `Vehicle` reference |
| Method Overriding | Each class customizes `displayDetails()` |
| Encapsulation     | Private fields with getters/setters     |
| File Handling     | Reads/writes vehicle data from `.txt` files |

## 🛠️ Future Improvements (Optional)
- Add "return vehicle" feature.
- Calculate total income from rentals.
- Add user authentication or admin dashboard.
- Use JavaFX or Swing for a GUI.

## 👤 Author
Hassan Yousef — Computer Science graduate from Taibah University, focused on backend development and OOP concepts.
[Downlode the Project Https URL](https://github.com/Blooming0/Polymorphism-Exercise.git)
