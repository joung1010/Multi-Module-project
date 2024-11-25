# Resilience4j

Resilience4j는 **Java 기반 애플리케이션에서 서비스의 회복력을 높이기 위한 라이브러리**입니다. 마이크로서비스 환경에서 외부 서비스 호출 실패나 과부하로 인해 발생하는 문제를 방지하거나 완화할 수 있도록 설계되었습니다.

Netflix의 **Hystrix**와 유사한 역할을 하지만, 더 가벼운 설계와 최신 Java 8 이상에서의 함수형 프로그래밍을 지원하는 것이 특징입니다.

---

## 주요 기능

Resilience4j는 다음과 같은 회복성 패턴을 제공합니다:

### 1. **Circuit Breaker (회로 차단기)**

- 외부 서비스 호출 실패율이 높을 경우 호출을 차단하여 시스템을 보호.
- 실패율이 안정적으로 낮아지면 호출을 재개.
- 상태 변화: **Closed** → **Open** → **Half-Open** → **Closed**.

---

### 2. **Retry (재시도)**

- 외부 호출 실패 시, 설정된 횟수만큼 재시도.
- 재시도 간 간격과 전략을 설정 가능.

---

### 3. **Rate Limiter (속도 제한)**

- 단위 시간 내 호출 가능한 횟수를 제한하여 과도한 호출을 방지.

---

### 4. **Bulkhead (격벽)**

- 동시 호출 수를 제한하여 특정 서비스나 리소스의 과부하 방지.

---

### 5. **Time Limiter (시간 제한)**

- 호출 시간이 초과될 경우, 예외를 발생시켜 서비스의 과도한 대기 방지.

---

### 6. **Metrics 및 모니터링**

- 호출 횟수, 성공/실패 비율, Circuit Breaker 상태 등을 모니터링 가능.
- Micrometer와 통합하여 Prometheus, Grafana 등으로 지표를 시각화.

---

## 설치 및 의존성 추가


### Gradle

```groovy
implementation 'io.github.resilience4j:resilience4j-spring-boot3:2.0.2'

```

---

## 주요 기능별 상세 설명

### 1. Circuit Breaker

### 동작 원리

- 실패율이 설정된 임계값 이상일 경우, **Open 상태**로 변경하고 모든 호출을 차단.
- 일정 시간이 지나면 **Half-Open 상태**로 변경하여 일부 호출 허용.
- 호출이 성공적으로 처리되면 **Closed 상태**로 복귀.

### 설정 예시 (application.yml)

```yaml
resilience4j:
  circuitbreaker:
    configs:
      default:
        failure-rate-threshold: 50 # 실패율 임계값 (%)
        wait-duration-in-open-state: 10s # Open 상태 유지 시간
        sliding-window-type: COUNT_BASED # 윈도우 타입 (COUNT 또는 TIME)
        sliding-window-size: 20 # 윈도우 크기
        minimum-number-of-calls: 10 # Circuit 활성화 최소 호출 수
    instances:
      myService:
        base-config: default

```

### 사용 예시

```java
@CircuitBreaker(name = "myService", fallbackMethod = "fallback")
public String callExternalService() {
    // 외부 서비스 호출
    throw new RuntimeException("Service failure");
}

public String fallback(Throwable t) {
    return "Fallback response: " + t.getMessage();
}

```

---

### 2. Retry

### 동작 원리

- 외부 서비스 호출 실패 시, 설정된 횟수만큼 재시도.
- 재시도 간격과 전략(고정, 지수 백오프 등)을 설정 가능.

### 설정 예시 (application.yml)

```yaml
resilience4j:
  retry:
    instances:
      myService:
        max-attempts: 3 # 최대 재시도 횟수
        wait-duration: 500ms # 대기 시간

```

### 사용 예시

```java
@Retry(name = "myService", fallbackMethod = "retryFallback")
public String retryService() {
    throw new RuntimeException("Temporary failure");
}

public String retryFallback(Throwable t) {
    return "Fallback response after retry: " + t.getMessage();
}

```

---

### 3. Rate Limiter

### 동작 원리

- 단위 시간 동안 호출 가능한 횟수를 제한하여 과도한 호출 방지.

### 설정 예시 (application.yml)

```yaml
resilience4j:
  ratelimiter:
    instances:
      myService:
        limit-for-period: 10 # 주기당 허용 호출 수
        limit-refresh-period: 1s # 호출 제한 주기

```

### 사용 예시

```java
@RateLimiter(name = "myService", fallbackMethod = "rateLimiterFallback")
public String rateLimitedService() {
    return "Rate Limited Response";
}

public String rateLimiterFallback(Throwable t) {
    return "Fallback response: Rate limit exceeded";
}

```

---

### 4. Bulkhead

### 동작 원리

- 동시 호출 수를 제한하여 시스템 과부하 방지.
- **ThreadPool Bulkhead**: 작업을 스레드 풀로 처리하여 병렬 처리.

### 설정 예시 (application.yml)

```yaml
resilience4j:
  bulkhead:
    instances:
      myService:
        max-concurrent-calls: 5 # 동시 호출 제한
        max-wait-duration: 1s # 대기 시간

```

### 사용 예시

```java
@Bulkhead(name = "myService", fallbackMethod = "bulkheadFallback")
public String bulkheadService() {
    return "Bulkhead Response";
}

public String bulkheadFallback(Throwable t) {
    return "Fallback response: Bulkhead limit exceeded";
}

```

---

### 5. Time Limiter

### 동작 원리

- 호출 시간이 초과될 경우, 타임아웃 처리.

### 설정 예시 (application.yml)

```yaml
resilience4j:
  timelimiter:
    instances:
      myService:
        timeout-duration: 1s # 타임아웃 시간

```

### 사용 예시

```java
@TimeLimiter(name = "myService", fallbackMethod = "timeLimiterFallback")
public CompletableFuture<String> timeLimitedService() {
    return CompletableFuture.supplyAsync(() -> {
        try {
            Thread.sleep(2000); // 지연 시뮬레이션
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Response";
    });
}

public CompletableFuture<String> timeLimiterFallback(Throwable t) {
    return CompletableFuture.completedFuture("Fallback response: Timeout occurred");
}

```

---

## 모니터링 및 Metrics

### Actuator와 통합

Spring Boot Actuator와 통합하여 Resilience4j 상태를 모니터링할 수 있습니다.

### 설정 예시

```yaml
management:
  endpoints:
    web:
      exposure:
        include: resilience4j.circuitbreaker, resilience4j.ratelimiter

```

### Micrometer와 통합

Micrometer와 통합하여 Prometheus, Grafana 등으로 데이터를 시각화할 수 있습니다.

---

## 참고 자료

- Resilience4j 공식 문서
- [Spring Boot Resilience4j Integration](https://github.com/resilience4j/resilience4j-spring-boot)