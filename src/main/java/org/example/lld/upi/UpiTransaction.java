package org.example.lld.upi;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpiTransaction {
    private String transactionId;         // Unique identifier
    private String senderUpiId;           // e.g. user1@upi
    private String receiverUpiId;         // e.g. merchant@upi
    private double amount;
    private TransactionStatus status;
    private String referenceId;           // Reference from bank
    private LocalDateTime initiatedAt;
    private LocalDateTime completedAt;
    private String remarks;               // Optional note or description

    // Constructors, Getters, Setters
    public UpiTransaction(String transactionId, String senderUpiId, String receiverUpiId, double amount, 
                          TransactionStatus status, String referenceId, LocalDateTime initiatedAt, 
                          LocalDateTime completedAt, String remarks) {
        this.transactionId = transactionId;
        this.senderUpiId = senderUpiId;
        this.receiverUpiId = receiverUpiId;
        this.amount = amount;
        this.status = status;
        this.referenceId = referenceId;
        this.initiatedAt = initiatedAt;
        this.completedAt = completedAt;
        this.remarks = remarks;
    }

    // Getters and setters omitted for brevity
}
