package com.ibm.sba.service.impl;

import com.ibm.sba.domain.Payments;
import com.ibm.sba.repository.PaymentsRepository;
import com.ibm.sba.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentsServiceImpl implements PaymentsService {
    @Autowired
    private PaymentsRepository paymentsRepository;

    @Override
    public Payments getPaymentById(int payId) {
        Payments payments = this.paymentsRepository.findById(payId).orElse(null);
        return payments;
    }

    @Override
    public void addPayments(Payments payments) {
        this.paymentsRepository.save(payments);
    }

    @Override
    public void updatePayments(Payments payments) {
        this.paymentsRepository.save(payments);
    }

    @Override
    public void deletePayments(int payId) {
        this.paymentsRepository.deleteById(payId);
    }
}
