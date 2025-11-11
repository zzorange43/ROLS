package com.laundry.ROLS.system.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorController {
    @RequestMapping(value = "/alert", method = {RequestMethod.GET, RequestMethod.POST})
    public String handleErrorAlert(HttpServletRequest request, Model model) {
        String message = (String) request.getAttribute("errorMessage");
        model.addAttribute("errorMessage", message);
        return "common/errorAlert";
    }
}
