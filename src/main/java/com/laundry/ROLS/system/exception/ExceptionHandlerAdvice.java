package com.laundry.ROLS.system.exception;

import com.laundry.ROLS.system.exception.customException.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {
    @ExceptionHandler(BusinessException.class)
    public String handleBusinessException(BusinessException e, Model model, HttpServletRequest request) {

        log.error("[BusinessException] {}", e.getMessage());


        // JSP/Thymeleaf 쪽에 에러 메시지를 전달
        model.addAttribute("errorMessage", e.getMessage());

        // 요청한 URL(즉, 사용자가 입력하던 폼 화면)로 포워드
        String referer = request.getHeader("referer");

        // referer가 없는 경우 안전장치
        if (referer == null || referer.isBlank()) {
            return "redirect:/error"; // fallback 페이지
        }
        // ⚠️ redirect 하면 메시지가 날아가니까 forward 사용
        // 하지만 단순히 "forward:" + referer 하면 URL 형태가 깨질 수 있음 → 이건 requestMapping으로 연결
        return "forward:/error/alert";

    }
}
