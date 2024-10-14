package com.business.configuration.framework.exception.enums;

import com.business.configuration.framework.standard.enums.BasicResponseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * <b> BasicErrorCode </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-02
 */

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public enum BasicErrorCode implements BasicResponseType {
    // 200 Success
    SUCCESS(HttpStatus.OK,"COMMON-000","성공"),

    // 400 BAD REQUEST
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "COMMON-001", "잘못된 입력입니다."),
    INVALID_TYPE_VALUE(HttpStatus.BAD_REQUEST, "COMMON-002", "잘못된 타입입니다."),
    MISSING_REQUEST_PARAMETER(HttpStatus.BAD_REQUEST, "COMMON-003", "필수 요청 파라미터가 누락되었습니다."),

    // 401 UNAUTHORIZED
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON-004", "인증이 필요합니다."),
    INVALID_AUTH_TOKEN(HttpStatus.UNAUTHORIZED, "COMMON-005", "유효하지 않은 인증 토큰입니다."),
    EXPIRED_AUTH_TOKEN(HttpStatus.UNAUTHORIZED, "COMMON-006", "만료된 인증 토큰입니다."),
    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, "COMMON-007", "인증에 실패했습니다."),

    // 403 FORBIDDEN
    ACCESS_DENIED(HttpStatus.FORBIDDEN, "COMMON-008", "접근이 거부되었습니다."),
    INSUFFICIENT_PERMISSIONS(HttpStatus.FORBIDDEN, "COMMON-009", "권한이 부족합니다."),
    ACCOUNT_LOCKED(HttpStatus.FORBIDDEN, "COMMON-010", "계정이 잠겼습니다."),
    ACCESS_REVOKED(HttpStatus.FORBIDDEN, "COMMON-011", "접근 권한이 취소되었습니다."),

    // 404 NOT FOUND
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON-012", "요청한 리소스를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER-001", "사용자를 찾을 수 없습니다."),

    // 409 CONFLICT
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "COMMON-013", "리소스가 중복되었습니다."),

    // 500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON-014", "서버에서 문제가 발생했습니다."),
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON-015", "데이터베이스 오류가 발생했습니다."),

    ;

    private HttpStatus httpStatus;
    private final String code;
    private final String description;
}
