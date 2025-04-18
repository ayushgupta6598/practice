package org.example.lld.upi;

public class Application {
    public static void main(String[] args) {
        /** Here’s a potential interview question based on the UPI Transaction System design:

        ---

### **Interview Question:**
**Question:**

*In a financial system, we need to design a transaction processing service for UPI (Unified Payments Interface) transactions. The system should support transaction creation, status updates, and auditing of each transaction for traceability. Please design the low-level architecture for such a system, including the following components:*

        1. **Transaction Model**: What fields would you include in a UPI transaction, and why? How would you handle the status of the transaction, and what different statuses would you have?

        2. **Transaction Status Updates**: How would you design the logic for handling status updates in a UPI transaction? What would happen if the transaction status needs to be updated multiple times?

                3. **Auditing**: How would you implement auditing for transaction operations? What information should be captured in the audit log, and how would you ensure that the auditing is accurate and efficient?

                4. **Concurrency**: If two processes try to update the status of the same transaction concurrently, how would you ensure data consistency and avoid conflicts?

        5. **Database Design**: What would your database schema look like for storing transaction records? What indexes or optimizations would you consider to improve query performance, especially when searching for transactions by status or user?

                6. **Extensibility**: How would you design this system so it can easily be extended to support new features like fraud detection, transaction retries, or transaction history?

        7. **Error Handling and Notifications**: How would you handle errors during transaction processing? How would you notify users if their transaction fails or is reversed?

        ---

                **Follow-up Questions:**

        - How would you handle situations where the transaction system goes down, and transactions need to be retried?
                - If the system experiences a performance bottleneck when processing high volumes of transactions, what approaches would you consider to optimize it?

                ---

### **Purpose of the Question:**

        This question assesses the candidate's ability to design a robust transaction processing system with a focus on:
        1. **System Architecture**: How they break down the problem into entities (like transactions, statuses, and audit logs) and components.
        2. **Concurrency Handling**: Understanding of race conditions and how to ensure data consistency.
        3. **Database Design**: Knowledge of designing efficient storage solutions and indexing strategies.
        4. **Auditing and Transparency**: How they handle tracking changes for compliance or debugging.
        5. **Error Handling**: Their approach to handling system failures and ensuring smooth user experience.

                ---

                Would you like me to provide an example answer for this question?*/

        UpiTransactionService transactionService = new UpiTransactionService();

        // Initiate a transaction
        UpiTransaction txn = transactionService.initiateTransaction("user1@upi", "merchant@upi", 200.00, "Payment for product");

        // Update the transaction status
        transactionService.updateTransactionStatus(txn.getTransactionId(), TransactionStatus.SUCCESS, "REF12345", "system");
    }
}
