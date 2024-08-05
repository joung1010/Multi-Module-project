# JPA
## JPA란?

- 자바 ORM 기술에 대한 표준 명세로, JAVA에서 제공하는 API이다. 스프링에서 제공하는것이 아니다.
- 자바 어플리케이션에서 관계형 데이터베이스를 사용하는 방식을 정의한 인터페이스다.
- 여기서 중요한건 JPA는 말 그대로 인터페이스이다.JPA는 특정 기능을 하는 라이브러리가 아니다. 스프잉의 PSA에 의해서(POJO를 사용하면서 특정 기술을 사용하기 위해서)표준 인터페이스를 정해두었는데, 그중 ORM을 사용하기 위해 만든 인터페이스가 바로 JPA이다.
- 기존 EJB에서 제공되던 엔티티 빈을 대체하는 기술이다.
- **ORM이기 때문에 자바 클래스와 DB테이블을 매핑한다.(SQL을 매핑하지않는다)**
- ORM을 사용하기 위한 인터페이스를 모아둔 것이며, JPA를 사용하기 위해서는 JPA를 구현한 Hibernate, EclipseLink, DataNucleus같은 ORM 프레임워크를 사용해야 합니다.

## 그러면 ORM이란?

ORM (Object-Relational Mapping)은 객체 지향 프로그래밍 언어를 사용하여 호환되지 않는 유형의 시스템 간에 데이터를 변환하는 프로그래밍 기술입니다. 즉, **ORM은 데이터베이스의 데이터를 객체로 변환하여, 프로그래머가 객체 지향 언어로 데이터베이스를 더 쉽게 다룰 수 있게 해 줍니다.** 이를 통해 개발자는 데이터베이스의 데이터를 마치 자신의 언어 내의 일반 객체처럼 조작할 수 있어, 데이터베이스와의 상호 작용을 추상화하여 복잡성을 감소시킵니다.

JPA (Java Persistence API)는 Java EE 플랫폼에서 제공하는 ORM 구현체의 표준 인터페이스를 제공합니다. JPA를 사용하면 개발자는 데이터베이스 테이블을 Java 클래스로 매핑하고, 데이터베이스 연산을 Java 객체의 CRUD (생성, 조회, 업데이트, 삭제) 연산으로 처리할 수 있습니다.


## Hibernate 는 뭔데?

Hibernate는 ORM (Object-Relational Mapping)의 구현체 중 하나이며, Java 언어에서 가장 널리 사용되는 ORM 프레임워크 중 하나입니다. ORM 프레임워크는 객체 지향 모델과 관계형 데이터베이스를 연결하는 역할을 하며, Hibernate는 이러한 작업을 용이하게 해줍니다.

### **Hibernate의 주요 기능**

1. **데이터베이스 독립성**:
    - Hibernate는 다양한 데이터베이스를 지원합니다. 이를 통해 개발자는 특정 데이터베이스에 종속되지 않고 데이터 액세스 로직을 구현할 수 있습니다.
2. **자동 테이블 생성**:
    - Hibernate는 엔티티 클래스에 기반한 데이터베이스 테이블을 자동으로 생성할 수 있는 기능을 제공합니다. 이를 통해 데이터베이스 스키마 관리가 간소화됩니다.
3. **캐싱**:
    - 성능 최적화를 위해 내부적으로 캐싱 메커니즘을 제공합니다. 이는 자주 사용되는 데이터의 빠른 접근을 가능하게 하여 성능을 향상시킵니다.
4. **트랜잭션 관리**:
    - Hibernate는 선언적 트랜잭션 관리를 지원하며, JPA와 함께 사용될 때 Java EE 표준의 트랜잭션 관리와도 잘 통합됩니다.
5. **HQL (Hibernate Query Language)**:
    - Hibernate는 SQL을 추상화한 자체 쿼리 언어인 HQL을 제공합니다. HQL은 데이터베이스 테이블이 아닌 엔티티 객체를 대상으로 쿼리를 작성할 수 있게 해 줍니다.
6. **Criteria API**:
    - 프로그래밍 방식으로 쿼리를 구성할 수 있는 Criteria API를 제공합니다. 이는 복잡한 검색 기능을 구현할 때 유용합니다.

### **Hibernate와 JPA**

Hibernate는 JPA의 구현체 중 하나로, JPA가 정의한 표준을 따르는 라이브러리입니다. JPA 인터페이스를 구현함으로써, Hibernate는 Java 개발자가 데이터베이스와 상호 작용하는 표준 방식을 제공합니다. 따라서 개발자는 Hibernate를 사용하여 JPA 표준에 따른 데이터 접근과 관리를 할 수 있으며, 필요에 따라 다른 JPA 구현체로 쉽게 전환할 수 있습니다.

이런 특징들 덕분에 Hibernate는 대규모 엔터프라이즈 애플리케이션에서 매우 인기 있는 선택지가 되고 있습니다.

## 스프링 데이터 JPA

**스프링 데이터 JPA**는 Spring Framework의 일부로서, Java Persistence API (JPA)를 사용하는 데이터 액세스 계층을 더욱 쉽게 구현할 수 있도록 지원하는 모듈입니다. 이 모듈은 개발자가 데이터베이스 작업을 보다 효율적이고 간단하게 처리할 수 있도록 다양한 편의 기능을 제공합니다. 스프링 데이터 JPA를 사용하면, JPA를 기반으로 하는 저장소를 손쉽게 설정하고, 데이터 접근을 위한 반복 코드를 대폭 줄일 수 있습니다.

### **스프링 데이터 JPA의 주요 기능**

1. **레포지토리 추상화**:
    - 스프링 데이터 JPA는 인터페이스 기반의 프로그래밍 모델을 제공하여, 기본적인 CRUD 연산을 위한 메소드를 자동으로 구현합니다. 개발자는 간단히 인터페이스를 정의하면, 스프링 데이터 JPA가 실행 시점에 이를 구현체로 변환하여 사용할 수 있게 해 줍니다.
2. **쿼리 메소드**:
    - 메소드 이름만으로 쿼리를 자동으로 생성하는 기능을 제공합니다. 예를 들어, **`findByName`** 메소드를 정의하면, 이 메소드는 자동으로 해당 이름을 가진 엔티티를 검색하는 쿼리를 생성하고 실행합니다.
3. **쿼리 어노테이션**:
    - **`@Query`** 어노테이션을 사용하여 JPQL 또는 SQL 쿼리를 직접 정의할 수 있습니다. 이를 통해 복잡한 쿼리도 쉽게 처리할 수 있습니다.
4. **페이징과 정렬**:
    - 스프링 데이터 JPA는 페이징과 정렬을 지원하는 간단한 방법을 제공합니다. **`Pageable`** 인터페이스와 **`Sort`** 클래스를 사용하여, 데이터를 페이징하고 정렬하는 작업을 쉽게 구현할 수 있습니다.
5. **트랜잭션 관리**:
    - 스프링 프레임워크의 선언적 트랜잭션 관리를 지원합니다. **`@Transactional`** 어노테이션을 메소드나 클래스에 적용함으로써, 해당 영역의 코드를 트랜잭션 범위 내에서 실행할 수 있습니다.
6. **감사(Auditing)**:
    - 엔티티의 생성 시간, 수정 시간, 생성자, 수정자 등을 자동으로 관리할 수 있는 기능을 제공합니다. 이를 위해 **`@CreatedDate`**, **`@LastModifiedDate`**, **`@CreatedBy`**, **`@LastModifiedBy`** 등의 어노테이션을 사용할 수 있습니다.

- **JPQL(Java Persistence Query Language)**
   - JPA(Java Persistence API)에서 사용되는 쿼리 언어로, 관계형 데이터베이스에서 데이터를 조회하고 조작하기 위해 사용됩니다. JPQL은 SQL과 유사하지만, 데이터베이스 테이블 대신 JPA 엔티티 객체를 대상으로 쿼리를 작성합니다.  

### **JPA 작동 흐름도**

JPA의 주요 작동 흐름은 다음과 같습니다:

```
+-------------------+
| 1. 엔티티 클래스 정의 |
+-------------------+
        |
        | 데이터베이스 테이블을 Java 클래스로 매핑
        V
+---------------------+
| 2. EntityManager 설정 |
+---------------------+
        |
        | EntityManagerFactory 생성 후 EntityManager 인스턴스 생성
        V
+-------------------+
| 3. 트랜잭션 관리   |
+-------------------+
        |
        | 트랜잭션 시작, 커밋, 롤백
        V
+-------------------+
| 4. CRUD 연산 수행  |
+-------------------+
        |
        | 생성, 조회, 업데이트, 삭제
        V
+---------+
| 5. 캐싱  |
+---------+
        |
        | 성능 최적화를 위해 일차 캐시 사용
        V
+------------------------+
| 6. 동기화 및 커밋       |
+------------------------+
        |
        | 트랜잭션 커밋 시 변경된 내용 데이터베이스에 동기화

```

1. **엔티티 클래스 정의**:
    - 데이터베이스 테이블을 반영하는 Java 클래스를 정의합니다. 이 클래스를 엔티티라고 하며, 각 인스턴스는 테이블의 한 행(row)에 해당합니다.
2. **EntityManager 설정**:
    - `EntityManagerFactory`를 생성하고 이를 사용하여 **`EntityManager`** 인스턴스를 생성합니다. `EntityManager`는 엔티티를 관리하고, 데이터베이스 연산을 수행하는 주된 객체입니다.
3. **트랜잭션 관리**:
    - 데이터베이스 연산을 수행할 때, 이러한 연산들을 트랜잭션 단위로 그룹화합니다. `EntityManager`를 사용하여 트랜잭션을 시작하고, 종료(커밋)하거나 실패 시 롤백합니다.
4. **CRUD 연산 수행**:
    - **`EntityManager`**를 통해 엔티티 객체를 생성, 조회, 업데이트, 삭제하는 등의 데이터베이스 연산을 수행합니다.
    - 조회는 JPQL (Java Persistence Query Language) 또는 Criteria API를 사용하여 수행될 수 있습니다.
5. **캐싱**:
    - JPA는 성능 최적화를 위해 일차 캐시를 사용하여, 한 트랜잭션 내에서의 엔티티 반복 접근을 최적화합니다.
6. **동기화 및 커밋**:
    - 트랜잭션이 커밋되면 변경된 내용이 데이터베이스에 동기화됩니다. 엔티티의 변경 사항이 자동으로 데이터베이스에 반영됩니다.


## 주요 용어

### **1. 엔티티 (Entity)**

엔티티는 데이터베이스 테이블의 행을 객체 지향 방식으로 표현한 것입니다. 엔티티 클래스라고도 하며, **`@Entity`** 어노테이션을 사용하여 클래스를 엔티티로 지정합니다. 각 엔티티 인스턴스는 데이터베이스의 행에 대응되며, 이들은 보통 키값을 가지는데, 이는 **`@Id`** 어노테이션으로 표시됩니다.

### **2. 영속성 (Persistence)**

영속성이란 데이터가 프로그램이 종료된 후에도 사라지지 않고 지속되는 성질을 말합니다. JPA에서는 이러한 영속성을 관리하여 애플리케이션이 데이터베이스의 데이터를 사용하고 관리할 수 있도록 합니다.

영속성을 갖지 않으면 데이터는 메모리에서만 존재하게 되고 프로그램이 종료되면 해당 데이터는 모두 사라지게 된다.

그래서 우리는 데이터를 파일이나 DB에 영구 저장함으로써 데이터에 영속성을 부여한다.

### **3. 영속성 컨텍스트 (Persistence Context)**
```
┌────────────────────────────────────────────────────────────────┐
│                          영속성 컨텍스트                       │
│                                                                │
│  ┌──────────────┐   ┌──────────────┐   ┌──────────────┐        │
│  │  비영속      │   │   영속       │   │  준영속      │        │
│  │ (Transient)  │──▶│ (Persistent) │──▶│ (Detached)  │        │
│  └──────────────┘   └──────────────┘   └──────────────┘        │
│         │                   │                   │              │
│         │                   │                   │              │
│         ▼                   │                   │              │
│  ┌──────────────┐           │                   │              │
│  │    삭제       │           │                   │              │
│  │ (Removed)    │           │                   │              │
│  └──────────────┘           │                   │              │
│         ▲                   │                   │              │
│         └───────────────────┴───────────────────┘              │
│                                                                │
└────────────────────────────────────────────────────────────────┘

설명:
1. 비영속 (Transient): 영속성 컨텍스트에 의해 관리되지 않는 상태.
   - 예시: new Entity()

2. 영속 (Persistent): 영속성 컨텍스트에 의해 관리되는 상태.
   - 예시: entityManager.persist(entity)

3. 준영속 (Detached): 영속성 컨텍스트에 의해 더 이상 관리되지 않는 상태.
   - 예시: entityManager.detach(entity)

4. 삭제 (Removed): 영속성 컨텍스트에서 삭제된 상태.
   - 예시: entityManager.remove(entity)

```
영속성 컨텍스트는 엔티티를 영구 저장하는 환경입니다. `EntityManager`를 통해 엔티티가 관리되며, 이 컨텍스트 내에서 엔티티의 생명주기가 관리됩니다. 영속성 컨텍스트는 엔티티의 인스턴스를 유일하게 식별하고, 일차 캐시, 변경 감지, 지연 로딩 등의 장점을 제공합니다.

**영속성 컨텍스트와 관련한 엔티티의 4가지 상태**

1. 비영속(new/transient) - 엔티티 객체가 만들어져서 아직 저장되지 않은 상태로, 영속성 컨텍스트와 전혀 관계가 없는 상태

2. 영속(managed) - 엔티티가 영속성 컨텍스트에 저장되어, 영속성 컨텍스트가 관리할 수 있 는 상태

3. 준영속(detached) - 엔티티가 영속성 컨텍스트에 저장되어 있다가 분리된 상태로, 영속성 컨텍스트가 더 이상 관리하지 않는 상태

4. 삭제(removed) - 엔티티를 영속성 컨텍스트와 데이터베이스에서 삭제

### **영속성 컨텍스트의 특징**

1. 영속성 컨텍스트는 엔티티를 식별자 값(@Id로 테이블의 기본키와 매핑한 필드 값)으로 구분 한다. 그렇기 때문에 영속 상태는 식별자 값이 반드시 있어야 한다.

2. 영속성 컨텍스트에 엔티티를 저장하면 바로 데이터베이스에 저장되는 것이 아니라, 1차 캐시 에 엔티티를 생성하고, 쓰기 지연 SQL 저장소에 쿼리문을 생성해서 저장한다. 이렇게 쌓인 쿼리문은 flush( )가 실행될 때 데이터베이스에 반영된다.

### **4. 영속성 레이어 (Persistence Layer)**

영속성 레이어는 데이터베이스와 상호작용하는 애플리케이션의 계층으로, 데이터를 영구 저장하는 책임을 집니다. JPA는 이 계층을 구현하기 위한 표준 방식을 제공합니다.

### **5. 엔티티 매니저 (EntityManager)**

`EntityManager`는 JPA의 핵심 클래스로, **엔티티에 대한 데이터베이스 연산을 수행**합니다. 엔티티 매니저는 영속성 컨텍스트를 통해 엔티티의 생명주기를 관리합니다.

### **6. 엔티티 매니저 팩토리 (EntityManagerFactory)**

`EntityManagerFactory`는 **`EntityManager`** 인스턴스를 생성합니다. 이는 일반적으로 애플리케이션 전체에서 단 하나만 존재하며, 비용이 많이 드는 객체입니다.

### **7. 트랜잭션 (Transaction)**

데이터베이스의 상태를 변경하는 작업을 안전하게 수행하기 위해, 이 작업들을 트랜잭션 단위로 그룹화합니다. JPA에서는 **`EntityTransaction`** 인터페이스를 통해 트랜잭션을 관리합니다.

### **8. JPQL (Java Persistence Query Language)**

JPQL은 데이터베이스 테이블이 아닌 엔티티 객체를 대상으로 하는 쿼리 언어입니다. SQL과 유사하지만, 데이터베이스 테이블 대신 엔티티 클래스와 그 속성을 사용하여 쿼리를 작성합니다.
  
## JPA에서의 영속성  
```
┌───────────────────────────┐        ┌──────────────────────┐        ┌──────────────┐
│      응용 프로그램       │        │      영속 컨텍스트     │        │     DB       │
│                           │        │                      │        │              │
│  ┌──────────────┐         │        │  ┌──────────────┐    │        │  ┌──────────┐ │
│  │ 엔티티 객체  │         │ ─────▶ │  │ 영속 객체    │    │ ─────▶ │  │ 레코드   │ │
│  └──────────────┘         │        │  └──────────────┘    │        │  └──────────┘ │
│  ┌──────────────┐         │ ◀───── │  ┌──────────────┐    │ ◀───── │  ┌──────────┐ │
│  │ 엔티티 객체  │         │        │  │ 영속 객체    │    │        │  │ 레코드   │ │
│  └──────────────┘         │        │  └──────────────┘    │        │  └──────────┘ │
└───────────────────────────┘        └──────────────────────┘        └──────────────┘

```
JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐로 갈린다.

JPA의 엔티티 매니저가 활성화된 상태로 트랜잭션(@Transactional) 안에서 DB에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태이다. 이 상태에서 해당 데이터 값을 변경하면 트랜잭션이 끝나는 시적에 해당 테이블에 변경 내용을 반영하게 된다. 따라서 우리는 앤티티 객체의 필드 값만 변경해주면 별도로 update()쿼리를 날릴 필요가 없게 된다! 이 개념을 더티 체킹이라고 한다

## JPA 엔티티 어노테이션

### **1. `@Entity`**

- **`@Entity`** 어노테이션은 클래스가 JPA 엔티티임을 나타냅니다. 이 어노테이션을 사용한 클래스는 데이터베이스 테이블에 매핑되며, 클래스의 인스턴스는 해당 테이블의 행에 해당합니다.

### **2. `@Table`**

- **`@Table`** 어노테이션은 엔티티 클래스와 매핑할 데이터베이스 테이블의 정보를 제공합니다. 예를 들어, 테이블의 이름, 카탈로그, 스키마 등을 지정할 수 있습니다.
- 예: **`@Table(name = "users")`**

### **3. `@Id`**

- **`@Id`** 어노테이션은 엔티티의 기본 키(primary key) 필드를 지정합니다. 각 엔티티는 반드시 하나 이상의 @Id를 가지고 있어야 합니다.

### **4. `@GeneratedValue`**

- **`@GeneratedValue`** 어노테이션은 기본 키의 값을 자동으로 생성할 방법을 지정합니다. 예를 들어, 데이터베이스의 auto-increment 기능을 사용할 수 있습니다.

### **5. `@Column`**

- **`@Column`** 어노테이션은 엔티티의 필드가 데이터베이스 테이블의 어떤 칼럼과 매핑될지를 정의합니다. 이를 통해 칼럼명, 길이, 널 허용 여부 등을 세밀하게 지정할 수 있습니다.

### **6. `@Transient`**

- **`@Transient`** 어노테이션은 해당 필드가 데이터베이스 테이블의 칼럼과 매핑되지 않음을 나타냅니다. 즉, 이 필드는 데이터베이스에 저장되거나 검색되지 않습니다.

### **7. `@ManyToOne` 및 `@OneToMany`**

- 이 어노테이션들은 엔티티 간의 관계를 정의합니다. **`@ManyToOne`**은 많은 엔티티가 하나의 엔티티와 관련될 때 사용되며, **`@OneToMany`**는 하나의 엔티티가 여러 엔티티와 관련될 때 사용됩니다.

### **8. `@JoinColumn`**

- **`@JoinColumn`** 어노테이션은 두 엔티티를 연결하는 외래 키(foreign key) 칼럼을 지정할 때 사용됩니다.
1. **name**:
   - **설명**: 데이터베이스 테이블에서 현재 엔티티의 외래 키 컬럼 이름을 지정합니다.
   - **예시**: `@JoinColumn(name = "member_id")`
   - **사용 사례**: 만약 현재 엔티티(`TMemberEntity`)의 테이블에 외래 키로 사용할 컬럼이 `member_id`라면, `name` 속성을 사용하여 이를 지정합니다.
2. **referencedColumnName**:
   - **설명**: 외래 키가 참조하는 대상 엔티티의 컬럼 이름을 지정합니다.
   - **예시**: `@JoinColumn(name = "member_id", referencedColumnName = "id")`
   - **사용 사례**: 외래 키가 참조하는 대상 엔티티(`TMemberDetailsEntity`)의 기본 키가 `id`라면, `referencedColumnName` 속성을 사용하여 이를 지정합니다.
3. **table**:
   - **설명**: 외래 키 컬럼이 있는 테이블의 이름을 지정합니다. 이 속성은 기본적으로 지정된 엔티티의 테이블로 가정됩니다.
   - **예시**: `@JoinColumn(name = "member_id", table = "T_MEMBER_DETAILS")`
   - **사용 사례**: 복잡한 경우에만 사용되며, 대부분의 경우 생략 가능합니다.
4. **unique**:
   - **설명**: 외래 키 컬럼에 대해 유니크 제약 조건을 설정할지 여부를 지정합니다.
   - **예시**: `@JoinColumn(name = "member_id", unique = true)`
   - **사용 사례**: 외래 키 컬럼이 유일해야 하는 경우에 사용됩니다.
5. **nullable**:
   - **설명**: 외래 키 컬럼이 null을 허용할지 여부를 지정합니다.
   - **예시**: `@JoinColumn(name = "member_id", nullable = false)`
   - **사용 사례**: 외래 키 컬럼이 null을 허용하지 않도록 할 경우에 사용됩니다.
6. **insertable**:
   - **설명**: 삽입 작업 시 외래 키 컬럼에 값을 삽입할 수 있는지 여부를 지정합니다.
   - **예시**: `@JoinColumn(name = "member_id", insertable = false)`
   - **사용 사례**: 삽입 작업 시 이 컬럼에 값을 삽입하지 않도록 할 경우에 사용됩니다.
7. **updatable**:
   - **설명**: 업데이트 작업 시 외래 키 컬럼을 수정할 수 있는지 여부를 지정합니다.
   - **예시**: `@JoinColumn(name = "member_id", updatable = false)`
   - **사용 사례**: 업데이트 작업 시 이 컬럼을 수정하지 않도록 할 경우에 사용됩니다.
8. **columnDefinition**:
   - **설명**: 외래 키 컬럼의 SQL 타입 정의를 지정합니다.
   - **예시**: `@JoinColumn(name = "member_id", columnDefinition = "BIGINT UNSIGNED")`
   - **사용 사례**: 데이터베이스의 특정 컬럼 타입을 명시적으로 지정해야 하는 경우에 사용됩니다.
9. **foreignKey**:
   - **설명**: JPA 2.1부터 추가된 속성으로, 외래 키 제약 조건을 정의할 수 있습니다.
   - **예시**: `@JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "FK_MEMBER_DETAILS"))`
   - **사용 사례**: 외래 키 제약 조건의 이름이나 기타 세부 사항을 지정할 경우에 사용됩니다.
### **9. `@ManyToMany`**

- **`@ManyToMany`** 어노테이션은 엔티티 간의 다대다 관계를 정의할 때 사용됩니다. 이 경우, 관계를 관리하기 위한 연결 테이블이 필요합니다.

### **10. `@Version`**

- **`@Version`** 어노테이션은 엔티티의 버전 관리를 위해 사용됩니다. 이는 동시성 제어에 유용하며, 데이터베이스에 엔티티를 저장할 때 충돌을 방지하는 데 도움이 됩니다.
  
## 엔티티 관계
예제 테이블:
```sql
-- 회원 테이블
CREATE TABLE T_MEMBER (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP
);

-- 회원 상세 정보 테이블
CREATE TABLE T_MEMBER_DETAILS (
    member_id INT NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(20) NULL,
    address VARCHAR(255) NULL,
    birthdate DATE NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (member_id),
    CONSTRAINT fk_member_details_member
        FOREIGN KEY (member_id) REFERENCES T_MEMBER (id)
        ON DELETE CASCADE
);

-- 회원 주소 테이블
CREATE TABLE T_MEMBER_ADDRESS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    zipcode VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_member_address_member
        FOREIGN KEY (member_id) REFERENCES T_MEMBER (id)
        ON DELETE CASCADE
);

-- 배송 주소 테이블 (회원 주소의 하위 테이블)
CREATE TABLE T_SHIPPING_ADDRESS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    address_id INT NOT NULL,
    shipping_address VARCHAR(255) NOT NULL,
    shipping_city VARCHAR(100) NOT NULL,
    shipping_state VARCHAR(100) NOT NULL,
    shipping_zipcode VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_shipping_address_member_address
        FOREIGN KEY (address_id) REFERENCES T_MEMBER_ADDRESS (id)
        ON DELETE CASCADE
);

-- 회원 역할 테이블
CREATE TABLE T_MEMBER_ROLE (
    id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NULL ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_member_role_member
        FOREIGN KEY (member_id) REFERENCES T_MEMBER (id)
        ON DELETE CASCADE
);

```
### **JPA에서 가장 중요한 것**

JPA에서 가장 중요한 것은 "객체와 관계형 데이터베이스 테이블이 어떻게 매핑되는지를 이해하는 것"이라고 생각합니다. 이는 JPA의 목적인 "객체 지향 프로그래밍과 데이터베이스 사이의 패러다임 불일치를 해결"과 가장 직접적으로 연관되어 있기 때문입니다.

Hibernate 문서(2. Domain Model)에서도 객체와 테이블 매핑이 전체 내용 중 상당 부분을 차지하는 것을 보면, 객체와 테이블 매핑의 중요성을 짐작할 수 있습니다.

객체와 테이블 매핑에 대한 내용을 조금 더 구체적으로 나누면 컬럼, 타입, 테이블 등에 대한 1차원적인 매핑과 테이블 간의 연관 관계 매핑으로 나눌 수 있습니다.

1차원적인 매핑의 경우에는 @Entity, @Column, @Id, @GeneratedValue, @Enumerated 등 객체와 데이터베이스 사이의 일대일 대응으로 기본적인 Annotation을 숙지하고 필요한 경우에 찾아보는 게 효율적이기 때문에 생략합니다.

연관 관계 매핑은 그때그때 찾아보기보다는 비즈니스 로직, 비즈니스 요구사항에 따라 개발자가 더 적절한 관계 설정 방법을 선택해야 하는 주제이기 때문에 학습하기 위하여 아래에 정리했습니다.

### **연관 관계 정의 규칙**

연관 관계를 매핑할 때, 고려해야 할 것은 크게 3가지가 있습니다.

- 방향: 단방향, 양방향 (객체 참조)
- 연관 관계의 주인: 양방향일 때, 연관 관계에서 관리 주체
- 다중성: 다대일(N:1), 일대다(1:N), 일대일(1:1), 다대다(N)

하나씩 생각해보겠습니다.

### **단방향, 양방향**

데이터베이스 테이블은 외래 키 하나로 양쪽 테이블 조인이 가능합니다. 따라서 데이터베이스는 단방향이나 양방향으로 나눌 필요가 없습니다.

그러나 객체는 참조용 필드가 있는 객체만 다른 객체를 참조할 수 있습니다. 그렇기 때문에 두 객체 사이에 하나의 객체만 참조용 필드를 갖고 참조하면 단방향 관계, 두 객체 모두가 각각 참조용 필드를 갖고 참조하면 양방향 관계라고 합니다.

엄밀히 말하면 양방향 관계는 없고 두 객체가 단방향 참조를 각각 가져서 양방향 관계처럼 사용하는 것입니다. JPA를 사용하여 데이터베이스와 패러다임을 맞추기 위해 객체는 단방향 연관 관계를 가질지, 양방향 연관 관계를 가질지 선택해야 합니다.

선택은 비즈니스 로직에서 두 객체 간 참조가 필요한지 여부를 고민해보면 됩니다.

- Member.getMemberDetails()처럼 참조가 필요하면 Member→MemberDetails 단방향 참조
   - 참조가 필요 없으면 참조하지 않으면 됩니다.
- MemberDetails.getMember()처럼 참조가 필요하면 MemberDetails→Member 단방향 참조
   - 참조가 필요 없으면 참조하지 않으면 됩니다.

이렇게 비즈니스 로직에 맞게 선택했는데 두 객체가 서로 단방향 참조를 했다면 양방향 연관 관계가 되는 것입니다. 단방향 연관 관계와 양방향 연관 관계를 구분하는 방법은 이렇게 이해하면 됩니다.

### **무조건 양방향 관계로 하면 쉬울까요?**

객체 입장에서 양방향 매핑을 하면 오히려 복잡해질 수 있습니다. 예를 들어 일반적인 비즈니스 애플리케이션에서 회원(Member) 엔티티는 많은 엔티티와 연관 관계를 가집니다.

모든 엔티티를 양방향 관계로 설정하면 회원(Member) 엔티티는 많은 테이블과 연관 관계를 맺게 되고, Member 클래스를 보면 복잡해집니다.

다른 엔티티들도 불필요한 연관 관계 매핑으로 인해 복잡성이 증가할 수 있습니다. 그래서 양방향으로 할지 단방향으로 할지 필히 구분해야 합니다. 구분하기 좋은 기준은 기본적으로 단방향 매핑으로 하고 나중에 역방향 객체 탐색이 필요할 때 추가하는 것으로 하면 됩니다.

참조만 추가한다고 되는 것이 아니고 자세한 내용은 아래에서 설명합니다.

### **연관 관계의 주인**

두 객체(A, B)가 양방향 관계, 다시 말해 단방향 관계 두 개(A→B, B→A)를 맺을 때, 연관 관계의 주인을 지정해야 합니다. 연관 관계의 주인을 지정하는 것은 두 단방향 관계(A→B, B→A) 중 제어의 권한(외래 키를 비롯한 테이블 레코드 저장, 수정, 삭제 처리)을 갖는 실질적인 관계가 어떤 것인지 JPA에게 알려주는 것입니다.

연관 관계의 주인은 연관 관계를 갖는 두 객체 사이에서 조회, 저장, 수정, 삭제를 할 수 있지만, 연관 관계의 주인이 아닌 경우 조회만 가능합니다. 연관 관계의 주인이 아닌 객체에서 mappedBy 속성을 사용해서 주인을 지정해줘야 합니다.

팁: 외래 키가 있는 곳을 연관 관계의 주인으로 정하면 됩니다. 무조건.

### **왜 연관 관계의 주인을 지정해야 하는가?**

두 객체(Member, MemberDetails)가 있고 양방향 연관 관계를 갖는다고 생각해봅니다. 이 상황에서 회원 상세 정보(MemberDetails)를 다른 회원(Member)으로 수정하려고 할 때, MemberDetails 객체에서 setMember(...) 같은 메서드를 이용해서 수정하는 것이 맞는지, Member 객체에서 getMemberDetails() 같은 메서드를 이용해서 List의 회원 상세 정보를 수정하는 것이 맞는지 헷갈릴 수 있습니다.

두 객체 입장에서는 두 방법 다 맞는 방법이긴 합니다. 그러나 객체에서 양방향 연관 관계 관리 포인트가 두 개일 때는 테이블과 매핑을 담당하는 JPA 입장에서 혼란을 줍니다. 즉, MemberDetails에서 Member를 수정할 때 FK(Foreign Key)를 수정할지, Member에서 MemberDetails를 수정할 때 FK(Foreign Key)를 수정할지를 결정하기 어려운 것입니다.

그래서 두 객체 사이의 연관 관계의 주인을 정해서 명확하게 MemberDetails에서 Member를 수정할 때만 FK를 수정하겠다고 정하는 것입니다.

### **연관 관계의 주인만 제어하면 되나요?**

데이터베이스에 외래 키가 있는 테이블을 수정하려면 연관 관계의 주인만 변경하는 것이 맞나요? 맞습니다. 하지만, 그것은 데이터베이스만 생각했을 때이고, 객체를 생각해보면 사실 둘 다 변경해주는 것이 좋습니다. (연관 관계의 주인이 아닌 곳에서도 변경!)

왜냐하면 두 참조를 사용하는 순수한 두 객체는 데이터 동기화를 해줘야 하기 때문입니다.

### **다중성**

데이터베이스를 기준으로 다중성을 결정합니다.
(JPA는 JPQL도 그렇고 보통 객체를 기준으로 하는 것이 일반적인데 다중성을 정하는 기준은 데이터베이스 기준인 것이 신기합니다.)

연관 관계는 대칭성을 갖습니다.

- 일대다 ↔ 다대일
- 일대일 ↔ 일대일
- 다대다 ↔ 다대다

### **다대일(N:1)**

회원(Member)과 회원 주소(MemberAddress)의 관계로 예를 들어보겠습니다.

요구 사항:

- 하나의 회원(1)에는 여러 주소(N)를 가질 수 있습니다.
- 하나의 주소는 하나의 회원에만 속할 수 있습니다.
- 회원과 주소는 다대일 관계를 갖습니다.

데이터베이스를 기준으로 다중성(주소 N : 회원 1)을 결정했습니다.
즉, 외래 키를 주소(N)가 관리하는 일반적인 형태입니다. (참고로 데이터베이스는 무조건 다(N) 쪽이 외래 키를 갖습니다.)

- **다대일(N:1) 단방향**

```java
@Entity
public class MemberAddress {
    @Id @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    //... getter, setter
}

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;
    //... getter, setter
}

```

다대일 단방향에서는 다 쪽인 MemberAddress에서 @ManyToOne만 추가해준 것을 확인할 수 있습니다.
반대로 Member에서는 참조하지 않습니다. (단방향이기 때문)

- **다대일(N:1) 양방향**

```java
@Entity
public class MemberAddress {
    @Id @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    //... getter, setter
}

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "member")
    List<MemberAddress> addresses = new ArrayList<>();
    //... getter, setter
}

```

다대일 양방향으로 만드려면 일(1) 쪽에 @OneToMany를 추가하고 양방향 매핑을 사용했으니 연관 관계의 주인을 mappedBy로 지정해줍니다. mappedBy로 지정할 때 값은 대상이 되는 변수명을 따라 지정하면 됩니다. 여기서는 MemberAddress 객체(대상)의 member라는 이름의 변수이기 때문에 member로 지정했습니다.

### **일대다(1:N)**

일대다는 다대일의 반대 입장인데 정리할 필요가 있나? 생각할 수 있지만 앞서 다대일의 기준은 연관 관계의 주인을 다(N) 쪽에 둔 것이고, 이번에 언급할 일대다의 기준은 연관 관계의 주인을 일(1) 쪽에 둔 것입니다.

※ 참고로 실무에서는 일대다(1:N) 단방향은 거의 쓰지 않도록 합니다.

- **일대다(1:N) 단방향**

데이터베이스 입장에서는 무조건 다(N) 쪽에서 외래 키를 관리합니다.
하지만 일(1) 쪽 객체에서 다(N) 쪽 객체를 조작(생성, 수정, 삭제)하는 방법입니다.

```java
@Entity
public class MemberAddress {
    @Id @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Column(name = "ADDRESS")
    private String address;
  //... getter, setter
}

@Entity
public class Member {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;

    @OneToMany
    @JoinColumn(name = "ADDRESS_ID") // 일대다 단방향에서 @JoinColumn 필수
    List<MemberAddress> addresses = new ArrayList<>();
    //... getter, setter
}

```

@OneToMany에 mappedBy가 없어집니다. 양방향이 아니기 때문입니다.
대신 @JoinColumn을 이용해서 조인을 합니다.

실제 사용은 아래와 같이 합니다:

```java
//...
MemberAddress address = new MemberAddress();
address.setAddress("123 Main St");

entityManager.persist(address); // address 저장

Member member = new Member();
member.setUsername("john_doe");
member.setPassword("password123");
member.setEmail("john.doe@example.com");
member.getAddresses().add(address);

entityManager.persist(member); // member 저장
//...

```

위와 같은 시나리오로 동작을 살펴보면, address를 저장할 때는 멀쩡하게 insert 쿼리가 나갑니다.

그 다음이 문제입니다.
member를 저장할 때는 Member를 insert하는 쿼리가 나간 후에 address를 update하는 쿼리가 나갑니다.
왜냐하면 member.getAddresses().add(address); 부분 때문인데요. Member 엔티티는 Member 테이블에 매핑되기 때문에 Member 테이블에 직접 지정할 수 있으나, MemberAddress 테이블의 FK(MEMBER_ID)를 저장할 방법이 없기 때문에 조인 및 업데이트 쿼리를 날려야 하는 문제가 있습니다.

### **치명적인 단점**

- 일만 수정한 것 같은데 다른 수정이 생겨 쿼리가 발생하는 것.
   - Member를 저장했는데 왜 MemberAddress가 수정이 되지? 이런 생각을 하게 만듦.
   - 업데이트 쿼리 때문에 성능상 이슈는 그렇게 크지 않음.

그렇기 때문에 TIP으로 일대다(1

) 단방향 연관 관계 매핑이 필요한 경우는 그냥 다대일(N:1) 양방향 연관 관계를 매핑해버리는 것이 유지보수에 훨씬 수월하기 때문에 이 방식을 추천합니다.

### **일대일(1:1)**

주 테이블에 외래 키를 넣을 수도 있고, 대상 테이블에 외래 키를 넣을 수도 있습니다.
※ 일대일(1:1)이기 때문에 테이블 A, B가 있을 때, A가 주 테이블이면 B가 대상 테이블이고, B가 주 테이블이면 A가 대상 테이블입니다.

- **일대일(1:1) 단방향**

외래 키를 주 테이블이 갖고 있다는 의미로 해석하겠습니다. (Member 테이블(주 테이블)에서 외래 키(FK)인 MemberDetails 테이블(대상 테이블)의 PK를 갖고 있도록)
회원(Member)에 대한 상세 정보(MemberDetails)를 반드시 1개만 갖는다고 가정합니다.

```java
@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne
    @JoinColumn(name = "DETAILS_ID")
    private MemberDetails memberDetails;
    //... getter, setter
}

@Entity
public class MemberDetails {
    @Id @GeneratedValue
    @Column(name = "DETAILS_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;
    //... getter, setter
}

```

특별할 게 없습니다.

- **일대일(1:1) 양방향**

단순하게 똑같이 @OneToOne 설정하고 mappedBy 설정만 해서 읽기 전용으로 만들어주면 양방향도 간단하게 됩니다.

```java
java코드 복사
@Entity
public class MemberDetails {
    @Id @GeneratedValue
    @Column(name = "DETAILS_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @OneToOne(mappedBy = "memberDetails")
    private Member member;
    //... getter, setter
}

```

### **일대일(1:1) 단방향 지원 안함**

이번에는 Member 테이블(주 테이블)이 아닌 MemberDetails 테이블(대상 테이블)에 외래 키(FK)를 갖고 있을 때를 생각해보려고 합니다.
그러나 이는 JPA에서 지원하지 않습니다.

- **일대일(1:1) 양방향**

이럴 때는 양쪽이 일대일이기 때문에 위에서 정의한 대로 처리하면 됩니다.
그러나 논란의 여지가 있습니다.

외래 키를 Member에서 관리하는 게 좋을지, MemberDetails에서 관리하는 게 좋을지 생각해봐야 합니다.

테이블은 한 번 생성되면 보통 굳어집니다. 변경이 어렵다는 얘기입니다.
그러나 비즈니스는 언제든 바뀔 수 있습니다.
회원이 여러 개의 상세 정보를 가질 수 있도록 비즈니스가 변경되면 어떻게 할까요?
그러면 다(N) 쪽인 MemberDetails 테이블에 외래 키가 있는 것이 변경에 유연합니다.

그러면 다(N)가 될 확률이 높은 테이블에 외래 키를 놓는 것이 무조건 좋을까요?
그건 또 아닙니다.
객체 입장에서 Member 쪽(1)에서 외래 키를 갖게 되면 Member를 조회할 때마다 이미 MemberDetails의 참조를 갖고 있기 때문에 성능상 이득이 있습니다.

### **결론**

종합적으로 판단하고 결정해야 하는데 단순화해서, 보통 일대일이라고 정할 때도 아주 신중하게 정했다고 가정한다면 주 테이블(Member)에 외래 키를 두는 것이 더 낫습니다. 다시 말씀드리지만 논쟁이 있고 의견일 뿐입니다.

### **다대다(N)**

- 실무 사용 금지
- 중간 테이블이 숨겨져 있기 때문에 자기도 모르는 복잡한 조인의 쿼리가 발생할 수 있기 때문입니다.
- 다대다로 자동 생성된 중간 테이블은 두 객체의 테이블의 외래 키만 저장되기 때문에 문제가 될 확률이 높습니다. JPA를 사용해보면 중간 테이블에 외래 키 외에 다른 정보가 들어가는 경우가 많기 때문에 다대다를 일대다, 다대일로 풀어서 만드는 것(중간 테이블을 엔티티로 만드는 것)이 추후 변경에도 유연하게 대처할 수 있습니다.

### 기타 
### CascadeType 옵션들
1. **CascadeType.PERSIST**: 부모 엔티티를 저장할 때 연관된 자식 엔티티도 함께 저장됩니다.
2. **CascadeType.MERGE**: 부모 엔티티를 병합할 때 연관된 자식 엔티티도 함께 병합됩니다.
3. **CascadeType.REMOVE**: 부모 엔티티를 삭제할 때 연관된 자식 엔티티도 함께 삭제됩니다.
4. **CascadeType.REFRESH**: 부모 엔티티를 새로고침할 때 연관된 자식 엔티티도 함께 새로고침됩니다.
5. **CascadeType.DETACH**: 부모 엔티티를 분리할 때 연관된 자식 엔티티도 함께 분리됩니다.
6. **CascadeType.ALL**: 위의 모든 CascadeType 옵션들을 포함합니다.

#### 엔티티 상관관계에서 `fetch` 옵션

JPA에서 엔티티 간의 관계를 정의할 때, 로딩 전략을 지정할 수 있는 `fetch` 옵션이 있습니다. 이 옵션은 두 가지 유형으로 나뉩니다:

1. **즉시 로딩(EAGER Loading)**:
    - `FetchType.EAGER`: 관련 엔티티를 즉시 로드합니다. 주 엔티티가 로드될 때 관련 엔티티도 함께 로드됩니다.
    - 예를 들어, `@OneToOne(fetch = FetchType.EAGER)` 또는 `@ManyToOne(fetch = FetchType.EAGER)`와 같이 사용합니다.
2. **지연 로딩(LAZY Loading)**:
    - `FetchType.LAZY`: 관련 엔티티를 실제로 필요할 때 로드합니다. 주 엔티티가 로드될 때 관련 엔티티는 프록시 객체로 남아 있다가 접근할 때 로드됩니다.
    - 예를 들어, `@OneToOne(fetch = FetchType.LAZY)` 또는 `@ManyToOne(fetch = FetchType.LAZY)`와 같이 사용합니다.
  
> JOIN FETCH  
> JPA에서 페치 전략을 명시적으로 지정하여 관련 엔티티를 한 번의 쿼리로 로드하는 데 사용되는 방법입니다. 이를 통해 N+1 쿼리 문제를 해결하고 성능을 최적화할 수 있습니다.
  

### QueryDSL
QueryDSL은 타입 안전한 쿼리 언어를 제공하는 자바 기반의 ORM 툴입니다. 이 툴은 SQL, JPA, MongoDB 등의 다양한 데이터베이스와 함께 사용할 수 있으며, 코드 기반으로 작성된 쿼리를 통해 컴파일 타임에 쿼리 오류를 검출할 수 있게 해줍니다.

주요 기능 및 장점
타입 안전성: 쿼리를 작성할 때 컴파일 타임에 타입 체크를 할 수 있어 런타임 오류를 줄입니다.
자동 완성 지원: IDE에서 쿼리를 작성할 때 자동 완성을 지원하여 개발 생산성을 높입니다.
유연한 쿼리 작성: 복잡한 쿼리를 간단하고 직관적으로 작성할 수 있습니다.