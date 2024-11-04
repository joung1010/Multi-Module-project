# RESTful API 설계 가이드

RESTful API 설계에서 URL(또는 엔드포인트)은 리소스를 나타내는 경로로 사용되며, 이 경로는 명확하고 일관되며 의미를 잘 전달해야 합니다. 아래는 RESTful API의 URL 설계를 위한 몇 가지 원칙과 예시입니다.

## 제약 요소 (Constraints)

REST 적용시에는 6가지 제약 요소가 있으며, 아래 제약 조건을 준수하는 한 개별 컴포넌트는 자유롭게 구현할 수 있다.

| **제약 요소** | **내용** |
| --- | --- |
| Client-Server | 일관된 인터페이스로 분리되어야 한다. (Separation of Concerns) |
| Stateless | 각 요청에 따른 클라이언트의 Context가 서버에 저장되어서는 안된다.
• 요청 메시지는 프로세스에 필요한 모든 정보를 가지고 있어야 함
• 모든 세션의 특정 상태는 반드시 클라이언트에 저장되어야 함 |
| Cacheable | 클라이언트는 응답을 Caching하고 있어야 한다. |
| Layered | 계층화 Component를 사용해 확장성을 향상시킨다. (중재자(intermediary)를 통해 Load Balancing이나 공유 Cache 기능을 제공) |
| Code on Demand (Optional) | 자바 Applet이나 자바스크립트같이 클라이언트가 실행할 수 있는 로직을 사용하여 기능을 확장한다. |
| Uniform Interface | 모든 Component는 같은 방식으로 접근하여야 한다. 아키텍처를 단순화하여 Client-server 각 파트가 독립적으로 개선될 수 있도록 한다. |

REST는 CRUD(Create, Retrieve, Update, Delete)에 대한 Request를 HTTP Method를 통해 실행한다.

| **HTTP**
**Method** | **역할** | **URI** | **Idempotent (멱등성)** |
| --- | --- | --- | --- |
| GET | URI를 통해 Resource 조회 | GET /{resources} 
GET /{resources}/{key} | YES |
| POST | URI를 통해 Resource 생성 | POST /{resources}/{key} | NO |
| PUT | URI를 통행 Resource 생성 및 수정: Resource의 전체 Data를 대체함 (Replace) | PUT /{resources}/{key} | YES |
| PATCH | URI를 통해 Resource 생성 및 수정: Resource의 특정 Field를 수정함 (Modified) | PATCH /{resources}/{key} | YES |
| DELETE | URI를 통해 Resource 삭제 | DELETE /{resources}/{key} | YES |

Idempotent(멱등성) 속성

- 멱등성 속성은 동일한 URI에 반복적으로 요청을 보냈을 때, 해당 결과가 같은지를 나타내는 속성이다.
- 특정 Resource를 추가하기 위해 POST를 사용할 경우, 매 요청에 대해 Resource가 생성되기 때문에 멱등성 속성은 NO이며, GET은 동일한 Data를 조회하는 것이기 때문에 YES라 할 수 있다.
- 해당 속성은 Transaction 복구를 위해 활용 가능하다.

## 1. 리소스 기반 URL

URL은 리소스를 나타내야 하며, 리소스는 일반적으로 명사로 표현됩니다. 동사보다는 리소스(데이터)에 집중하고, 그 리소스에 대해 수행되는 동작은 HTTP 메서드로 표현합니다.

**예시:**

- `GET /users` — 사용자 목록 조회
- `GET /users/{id}` — 특정 사용자 조회
- `POST /users` — 사용자 생성
- `PUT /users/{id}` — 특정 사용자 전체 업데이트
- `PATCH /users/{id}` — 특정 사용자 부분 업데이트
- `DELETE /users/{id}` — 특정 사용자 삭제

## 2. URL에서 명사는 복수형으로 사용

리소스는 일반적으로 복수형 명사를 사용하여 표현합니다. 이는 일관성과 가독성을 높여줍니다.

**예시:**

- `GET /books` — 도서 목록 조회
- `GET /books/{id}` — 특정 도서 조회

## 3. 계층적 관계 표현

리소스 간의 계층적 관계를 표현할 때, URL 경로를 사용하여 부모-자식 관계를 나타낼 수 있습니다.

**예시:**

- `GET /users/{userId}/orders` — 특정 사용자의 주문 목록 조회
- `GET /users/{userId}/orders/{orderId}` — 특정 사용자의 특정 주문 조회

## 4. 필터링, 정렬, 페이징

필터링, 정렬, 페이징 등의 기능은 URL 쿼리 파라미터를 통해 처리합니다.

**예시:**

- `GET /products?category=electronics&sort=price&order=asc` — 카테고리가 전자제품인 상품을 가격순으로 오름차순 정렬
- `GET /products?page=2&size=50` — 2번째 페이지의 50개의 상품 조회

## 5. 상태 변경은 HTTP 메서드 사용

데이터 변경 작업은 HTTP 메서드를 통해 명시적으로 처리합니다. `POST`, `PUT`, `PATCH`, `DELETE` 등을 사용하여 리소스의 상태를 변경합니다.

**예시:**

- `POST /users` — 새로운 사용자 생성
- `PUT /users/{id}` — 사용자 정보 전체 업데이트
- `PATCH /users/{id}` — 사용자 정보 부분 업데이트
- `DELETE /users/{id}` — 사용자 삭제

## 6. URI에 동사 사용 피하기

RESTful 설계에서는 URI에 동사를 사용하지 않는 것이 좋습니다. 동작은 HTTP 메서드로 나타내고, URI는 리소스를 나타내는 명사로 유지합니다.

**잘못된 예시:**

- `POST /createUser`
- `GET /getUserInfo`

**올바른 예시:**

- `POST /users`
- `GET /users/{id}`

## 7. 버전 관리

API의 버전 관리는 일반적으로 URL 경로에서 관리합니다. 이는 새로운 버전을 출시할 때 기존 클라이언트와의 호환성을 유지하는 데 도움이 됩니다.

**예시:**

- `GET /v1/users` — API v1의 사용자 목록 조회
- `GET /v2/users` — API v2의 사용자 목록 조회

## 8. 복합 리소스 처리

여러 리소스를 동시에 처리해야 하는 경우, 복합 리소스 형태로 표현할 수 있습니다.

**예시:**

- `POST /users/{userId}/orders` — 특정 사용자에게 새로운 주문 생성
- `GET /users/{userId}/orders/{orderId}` — 특정 사용자의 특정 주문 조회

## 9. 기타

- URI에서 슬래시 구분자("/")는 계층 관계를 나타낸다.
- URI의 마지막 문자에 슬래시를 포함하지 않는다.
- 하이픈('-')은 URI의 가독성을 높이기 위해 사용한다.
- URI는 소문자로 작성한다.
- URI에 Underline(_) 은 사용하지 않는다.
- 파일의 확장자는 URI에 포함시키지 않는다.

---

## 요약

- **리소스 기반**: URL은 리소스를 나타내야 하며, HTTP 메서드를 사용해 동작을 표현합니다.
- **복수형 사용**: 리소스 명은 일반적으로 복수형 명사를 사용합니다.
- **계층 구조**: 리소스 간의 관계는 URL 경로를 통해 표현합니다.
- **쿼리 파라미터**: 필터링, 정렬, 페이징 등의 기능은 쿼리 파라미터를 사용합니다.
- **명확성 및 일관성**: URI는 명확하고 일관되게 설계하여 사용자가 쉽게 이해할 수 있도록 합니다.
- **버전 관리**: URL 경로에서 API 버전을 관리하여 호환성을 유지합니다.

이러한 원칙을 따르면, 사용자가 쉽게 이해하고 사용하기 쉬운 RESTful API를 설계할 수 있습니다.

## 추가사항

### Content-Type

- **Content-Type 헤더**는 요청과 응답의 데이터 형식을 정의합니다.
- 일반적인 RESTful API에서 사용하는 `Content-Type` 예시는 다음과 같습니다:
    - `application/json`: JSON 형식으로 데이터가 전송될 때 사용합니다. 대부분의 RESTful API에서는 JSON을 기본 형식으로 사용합니다.
    - `application/xml`: XML 형식으로 데이터를 전송할 때 사용합니다. XML은 현재 잘 사용되지 않으므로 필요할 때에만 지정합니다.
    - `application/x-www-form-urlencoded`: HTML 폼 데이터를 인코딩하여 전송할 때 사용합니다. 예를 들어, 로그인 폼 데이터를 전송할 때 자주 사용됩니다.
    - `multipart/form-data`: 파일 업로드 시 사용됩니다. 이미지나 문서 파일과 같은 멀티파트 데이터를 전송할 때 활용합니다.

### Header

HTTP 헤더는 요청과 응답에 대한 메타데이터를 포함하며, 몇 가지 주요 헤더 필드는 다음과 같습니다:

- **Content-Type**: 요청이나 응답 본문의 데이터 형식을 지정합니다.
- **Accept**: 클라이언트가 수락할 수 있는 응답의 데이터 형식을 지정합니다. 예를 들어 `Accept: application/json`는 JSON 형식의 응답을 요청할 때 사용합니다.
- **Authorization**: API에 대한 인증 정보를 제공할 때 사용합니다. 일반적으로 `Bearer` 토큰이나 기본 인증을 위한 `Basic` 값을 설정합니다.
- **Cache-Control**: 클라이언트 또는 중간 서버가 응답을 캐시할 수 있는 방식을 정의합니다.
- **Accept-Language**: 클라이언트가 요청하는 응답의 언어를 지정합니다. 예를 들어 `Accept-Language: ko`는 한국어 응답을 요청하는 데 사용됩니다.

### HTTP 상태 코드

HTTP 상태 코드는 API 요청의 성공 또는 실패 여부를 나타내며, RESTful API에서 자주 사용하는 상태 코드는 다음과 같습니다:

- **2xx 성공**:
    - **200 OK**: 요청이 성공적으로 처리되었습니다.
    - **201 Created**: 새로운 자원이 성공적으로 생성되었습니다. POST 요청에서 사용됩니다.
    - **204 No Content**: 요청이 성공했으나 반환할 데이터가 없습니다. DELETE 요청에 자주 사용됩니다.
- **3xx 리다이렉션**:
    - **301 Moved Permanently**: 요청한 자원의 URI가 영구적으로 변경되었습니다.
    - **302 Found**: 요청한 자원의 URI가 일시적으로 변경되었습니다.
- **4xx 클라이언트 오류**:
    - **400 Bad Request**: 잘못된 요청으로 서버가 요청을 처리할 수 없습니다. 일반적으로 파라미터나 요청 형식 오류입니다.
    - **401 Unauthorized**: 인증이 필요하며, 인증되지 않은 사용자에게 사용됩니다.
    - **403 Forbidden**: 인증은 되었지만 권한이 없어 접근할 수 없습니다.
    - **404 Not Found**: 요청한 자원을 찾을 수 없습니다. 잘못된 URI로 접근한 경우 사용됩니다.
    - **405 Method Not Allowed**: 지원되지 않는 HTTP 메서드를 사용했을 때 반환됩니다.
- **5xx 서버 오류**:
    - **500 Internal Server Error**: 서버에서 발생한 일반적인 오류입니다.
    - **502 Bad Gateway**: 서버가 잘못된 응답을 수신했을 때 발생합니다.
    - **503 Service Unavailable**: 서버가 현재 요청을 처리할 수 없을 때 사용합니다. 예를 들어, 서버가 과부하 상태일 때 발생할 수 있습니다.