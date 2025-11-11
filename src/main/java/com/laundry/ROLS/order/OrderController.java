package com.laundry.ROLS.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/order")
public class OrderController {
    @GetMapping
    public String retrieveOrderList(Model model) {
        return "order/list";
    }

    @GetMapping("/new")
    public String createOrderForm(Model model) {
        return "order/createForm";
    }

    @PostMapping
    public String createOrder() {
        return "redirect:/order";
    }

    @GetMapping("/{id}")
    public String retrieveOrderDetail(@PathVariable Long id, Model model) {
        return "order/detail";
    }

    @GetMapping("/{id}/edit")
    public String modifyOrderForm(@PathVariable Long id, Model model) {
        return "order/editForm";
    }

    @PostMapping("/{id}")
    public String modifyOrder(@PathVariable Long id) {
        return "redirect:/order/{id}";
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return "redirect:/order";
    }
}
