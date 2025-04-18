package org.example.lld.upi;

import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionAuditService {

    public void logChange(String txnId, String changedBy, String field, String oldValue, String newValue, OperationType opType) {
        TransactionAuditLog log = new TransactionAuditLog(
                UUID.randomUUID().toString(),
                txnId,
                changedBy,
                field,
                oldValue,
                newValue,
                opType.name(),
                LocalDateTime.now()
        );

        // Save log to DB (for now, print to console)
        System.out.println(log);
    }
}
