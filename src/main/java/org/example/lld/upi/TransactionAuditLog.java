package org.example.lld.upi;

import java.time.LocalDateTime;

public class TransactionAuditLog {
    private String auditId;                    // UUID
    private String transactionId;              // Reference to UpiTransaction
    private String changedBy;                  // System or user ID
    private String fieldName;                  // e.g., "status"
    private String oldValue;
    private String newValue;
    private String operationType;              // CREATE, UPDATE, DELETE
    private LocalDateTime changedAt;

    public TransactionAuditLog(String auditId, String transactionId, String changedBy, String fieldName,
                               String oldValue, String newValue, String operationType, LocalDateTime changedAt) {
        this.auditId = auditId;
        this.transactionId = transactionId;
        this.changedBy = changedBy;
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.operationType = operationType;
        this.changedAt = changedAt;
    }

    // Getters and setters omitted for brevity
}
