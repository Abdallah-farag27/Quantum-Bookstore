# 🏬 Quantum Bookstore


## 📁 Project Structure
```
Quantum-Bookstore/
├── .idea/
├── out/
├── src/
│ ├── Book.java
│ ├── Bookstore.java
│ ├── Bookstore.png
│ ├── EBook.java
│ ├── MailService.java
│ ├── Main.java
│ ├── PaperBook.java
│ ├── ShippingService.java
│ └── ShowcaseBook.java
├── .gitignore
├── fawry-intern-2.iml
```

## Running the Demo

Use the `Main.java` class to run test cases that demonstrate the system's functionality.

![image](https://github.com/user-attachments/assets/5db670e9-810d-427e-b2d3-9c52e0241642)
![image](https://github.com/user-attachments/assets/f33a2615-49b7-417f-98b9-71a2682a750e)

### Test Case 1 – Remove Outdated Books
**Description:** Add 3 books, remove those older than 10 years  
**Expected:** PaperBook and EBook removed, ShowcaseBook remains

### Test Case 2 – Purchase Books
**Description:** Buy 2 PaperBooks and 2 EBooks, then attempt to buy a ShowcaseBook  
**Expected:**  
- PaperBook: 2 x 200 = 400  
- EBook: 2 x 150 = 300  
- ShowcaseBook: Exception thrown

### Test Case 3 – Insufficient Stock
**Description:** Try to buy more PaperBooks than available  
**Expected:** Exception thrown for not enough stock

### Test Case 4 – Duplicate ISBN
**Description:** Try to add a book with an already existing ISBN  
**Expected:** Exception thrown for duplicate ISBN

### Test Case 5 – Non-existent ISBN
**Description:** Try to buy a book that doesn’t exist in inventory  
**Expected:** Exception thrown for invalid ISBN

