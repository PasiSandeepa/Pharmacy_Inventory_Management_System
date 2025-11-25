# AetherMed Pharmacy

## Project Overview
Pharmacy Management System is a JavaFX-based desktop application for managing a pharmacy's operations, including managing medicines, suppliers, sales, and generating reports. This project helps pharmacists keep track of stock, sales, and supplier information efficiently.

---

## Features

### Medicine Management
- Add, update, and delete medicines.
- Track medicine quantity in stock.
- Update stock when medicines are purchased from suppliers.
- Search medicines by name.

### Supplier Management
- Add, update, and delete suppliers.
- Keep track of supplier contact information.
- Increase medicine stock when receiving from a supplier.

### Sales Management
- Add items to a cart for a customer purchase.
- Update stock automatically after sales.
- Generate sales invoices.

### Reporting
- Generate reports for:
  - Medicines in stock
  - Suppliers
  - Sales invoices

---

## Technology Stack
- Java 17
- JavaFX for UI
- Maven for project management
- JDBC for database connectivity
- MySQL / H2 for database
- JasperReports for reporting

---
## Project Structure
src/

 ├─ controller/ 
 # JavaFX controllers
 ├─ model/dto/  
 # Data Transfer Objects
 ├─ repository/ 
 # Database repositories
 │   └─ impl/  
 # Repository implementations
 ├─ service/   
 # Business logic services
 │   └─ impl/  
 # Service implementations
 ├─ view/   
 # FXML UI files
 ├─ main/   
 # Main launcher class
 





 



