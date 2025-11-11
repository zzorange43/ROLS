package com.laundry.ROLS.system.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@JsonFormat(shape = JsonFormat.Shape.OBJECT) //직렬화할때 어떤 값의 모습으로 직렬화될지
@RequiredArgsConstructor // 필수(final)변수 파라미터로 가지는 생성자 생성
@Getter
public enum ErrorCode {
    //Common -> http 요청시 발생할만한 예외
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "Common-001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "Common-002", " Invalid Http Method"),
    ENTITY_NOT_FOUND(HttpStatus.BAD_REQUEST,"Common-003", " Entity Not Found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Common-004", "Server Error"),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST,"Common-005", " Invalid Type Value"),
    HANDLE_ACCESS_DENIED(HttpStatus.FORBIDDEN, "Common-006", "Access is Denied"),

    //Member Validation
    MEMBER_EXIST(HttpStatus.BAD_REQUEST, "Member-001", "This member already existed"),
    LOGIN_INPUT_INVALID(HttpStatus.BAD_REQUEST, "Member-002", "Login input is invalid"),

    //room Validation


    //...등
    ;

    private final HttpStatus status; // http 상태코드
    private final String code;//에러코드
    private final String message;//에러메시지
}
