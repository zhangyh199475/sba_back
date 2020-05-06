package com.ibm.sba.service;

import com.ibm.sba.domain.Payments;

public interface PaymentsService {
    Payments getPaymentById(int payId);

    void addPayments(Payments payments);

    void updatePayments(Payments payments);

    void deletePayments(int payId);
}
