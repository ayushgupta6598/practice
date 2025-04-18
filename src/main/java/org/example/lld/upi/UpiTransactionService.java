package org.example.lld.upi;

import java.time.LocalDateTime;
import java.util.UUID;

public class UpiTransactionService {

    private TransactionAuditService auditService;

    public UpiTransactionService() {
        this.auditService = new TransactionAuditService();
    }

    public UpiTransaction initiateTransaction(String senderUpiId, String receiverUpiId, double amount, String remarks) {
        String txnId = UUID.randomUUID().toString();
        UpiTransaction txn = new UpiTransaction(txnId, senderUpiId, receiverUpiId, amount, TransactionStatus.PENDING, 
                                                 null, LocalDateTime.now(), null, remarks);

        // Save to DB (for now, print to console)
        System.out.println("Transaction initiated: " + txn);
        
        return txn;
    }

    public void updateTransactionStatus(String transactionId, TransactionStatus status, String referenceId, String changedBy) {
        // Fetch from DB (simulation)
        UpiTransaction txn = findTransactionById(transactionId);

        // If the status changes, log the change
        if (txn.getStatus() != status) {
            auditService.logChange(
                    txn.getTransactionId(),
                    changedBy,
                    "status",
                    txn.getStatus().name(),
                    status.name(),
                    OperationType.STATUS_CHANGE
            );
        }

        txn.setStatus(status);
        txn.setCompletedAt(LocalDateTime.now());
        txn.setReferenceId(referenceId);

        // Update DB (for now, print to console)
        System.out.println("Transaction updated: " + txn);
    }

    public UpiTransaction findTransactionById(String transactionId) {
        // Mocking a transaction for the example
        return new UpiTransaction(transactionId, "user1@upi", "merchant@upi", 100.00, TransactionStatus.PENDING, 
                                  null, LocalDateTime.now(), null, "Transaction initiation");
    }
}
