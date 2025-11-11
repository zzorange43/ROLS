package com.laundry.ROLS.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/payment")
public class PaymentController {
    @GetMapping
    public String retrievePaymentList(Model model) {
        return "payment/list";
    }

    @GetMapping("/new")
    public String createPaymentForm(Model model) {
        return "payment/createForm";
    }

    @PostMapping
    public String createPayment() {
        return "redirect:/payment";
    }

    @GetMapping("/{id}")
    public String retrievePaymentDetail(@PathVariable Long id, Model model) {
        return "payment/detail";
    }

    @DeleteMapping("/{id}")
    public String processPayment(@PathVariable Long id) {
        return "redirect:/payment";
    }
}
