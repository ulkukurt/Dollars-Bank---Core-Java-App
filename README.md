# Dollars Bank-Core Java App#

##Project Overview

**<br>Objective**
<br>Create a Java console application to enable Dollars Bank customers to manage their accounts securely and efficiently.

**Stakeholders**
<br>Bank customers
<br>Development team
<br>Project manager

**Timeline**
<br>Two-week sprint, ending in a deliverable MVP.

**MVP Features**
1. **User Authentication**
**Login**: Authenticate existing customers with username and password.
**Account Creation**: Allow new customers to create an account with a username and password.

2. **Account Management**
**Deposit Money**: Customers can add funds to their account.
**Withdraw Money**: Customers can withdraw funds from their account.
**Transfer Funds**: Customers can transfer funds between accounts.

3. **Transaction History**
**Recent Transactions**: Customers can view the 5 most recent transactions.

4. **User Information**
**Display Information**: Show relevant customer and account information.
5. **Sign Out**
**Logout**: Customers can securely log out of their accounts.

**<br>Non-Functional Requirements**
<br>Error Handling: Basic error messages for login and deposit/withdrawal actions.
<br>Colored Text: Use simple colored text in the console for better readability.
<br>Data Storage: Store customer data within a simple text file.

**Technical Architecture**
<br>DollarsBankApplication: Main entry point.
<br>DollarsBankController: Handles the main business logic.
<br>Account: Model for bank accounts.
<br>Customer: Model for customers.
<br>ColorsUtility: Helper for colored text.
<br>ConsolePrinterUtility: Helper for text formatting.
<br>FileStorageUtility: Helper for file operations.


**Future Enhancements**
<br>Implement two-factor authentication.
<br>Add joint accounts functionality.
<br>Provide an option for account statements to be emailed.












