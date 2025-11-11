package com.laundry.ROLS.process;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/processing")
public class ProcessController {
    @GetMapping
    public String retrieveProcessingList(Model model) {
        return "processing/list";
    }

    @GetMapping("/new")
    public String createProcessingForm(Model model) {
        return "processing/createForm";
    }

    @PostMapping
    public String createProcessing() {
        return "redirect:/processing";
    }

    @GetMapping("/{id}")
    public String retrieveProcessingDetail(@PathVariable Long id, Model model) {
        return "processing/detail";
    }

    @PostMapping("/{id}")
    public String modifyProcessing(@PathVariable Long id) {
        return "redirect:/processing/{id}";
    }
}
