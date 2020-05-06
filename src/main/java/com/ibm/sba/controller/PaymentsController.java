package com.ibm.sba.controller;

import com.ibm.sba.domain.Payments;
import com.ibm.sba.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
    @Autowired
    private PaymentsService paymentsService;

    @GetMapping("/getPaymentById")
    public ResponseEntity<Payments> getPaymentById(@PathVariable int payId){
        Payments payments = this.paymentsService.getPaymentById(payId);
        return new ResponseEntity(payments, HttpStatus.OK);
    }

    @PostMapping("/addPayments")
    public ResponseEntity<HttpStatus> addPayments(@RequestBody Payments payments) {
        this.paymentsService.addPayments(payments);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/updatePayments")
    public ResponseEntity<HttpStatus> updatePayments(@RequestBody Payments payments) {
        this.paymentsService.updatePayments(payments);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/deletePayments")
    public ResponseEntity<HttpStatus> deletePayments(@PathVariable int payId) {
        this.paymentsService.deletePayments(payId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
