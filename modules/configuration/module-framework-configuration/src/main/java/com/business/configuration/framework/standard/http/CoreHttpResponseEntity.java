package com.business.configuration.framework.standard.http;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.util.MultiValueMap;

/**
 * <b> CoreHttpResponseEntity </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-23
 */

@RequiredArgsConstructor
public class CoreHttpResponseEntity<T> extends HttpEntity<T> {
    // 상태 코드 필드
    private final HttpStatusCode status;

    // 생성자 (빌더 패턴 사용을 위해 외부에서는 사용 안됨)
    private CoreHttpResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(body, headers);
        this.status = status;
    }

    // 상태 코드를 반환하는 메서드
    public HttpStatusCode getStatusCode() {
        return this.status;
    }

    // 성공 여부 확인 (상태 코드가 200~299일 경우 성공)
    public boolean isSuccessful() {
        return (this.status.value() >= 200 && this.status.value() < 300);
    }

    // 빌더 클래스 정의
    public static class Builder<T> {
        private T body;
        private MultiValueMap<String, String> headers;
        private HttpStatusCode status;

        public Builder<T> body(T body) {
            this.body = body;
            return this;
        }

        public Builder<T> headers(MultiValueMap<String, String> headers) {
            this.headers = headers;
            return this;
        }

        public Builder<T> status(HttpStatusCode status) {
            this.status = status;
            return this;
        }

        // 빌더 메서드
        public CoreHttpResponseEntity<T> build() {
            return new CoreHttpResponseEntity<>(body, headers, status);
        }
    }

    // 빌더 패턴을 시작하는 정적 메서드
    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

}
