Spring Data JPA에서 **커스텀 JPA 리포지토리**를 구현하는 방법은 기본적인 CRUD 기능을 확장하거나, 보다 복잡한 쿼리나 비즈니스 로직을 처리하기 위해 필요할 때 사용됩니다. 커스텀 JPA 리포지토리는 일반적인 리포지토리 인터페이스와 함께 사용되며, 이를 구현하기 위해서는 `@NoRepositoryBean`과 `@PersistenceContext` 어노테이션을 이해하고 적절하게 사용해야 합니다.

### 1. 커스텀 리포지토리 구성 요소

### (1) `@NoRepositoryBean`

`@NoRepositoryBean` 어노테이션은 리포지토리 인터페이스에서 사용되며, **해당 인터페이스가 리포지토리 빈으로 직접적으로 등록되지 않도록 설정**합니다. Spring Data JPA는 리포지토리 인터페이스를 자동으로 빈으로 등록하지만, 커스텀 리포지토리 인터페이스는 이 빈으로 등록되는 것을 방지하기 위해 `@NoRepositoryBean`을 적용합니다.

**예시**:

```java

@NoRepositoryBean
public interface CustomMemberRepository {
    void customSaveMethod(Member member);
}

```

이렇게 하면 `CustomMemberRepository`는 빈으로 등록되지 않고, 이를 상속한 리포지토리에서 사용됩니다.

### (2) `@PersistenceContext`

`@PersistenceContext`는 **엔티티 매니저(EntityManager)**를 주입하기 위한 어노테이션입니다. 커스텀 리포지토리를 구현할 때는 `EntityManager`를 사용하여 직접적인 쿼리를 실행하거나 JPA의 고급 기능을 사용할 수 있습니다.

**예시**:

```java

public class CustomMemberRepositoryImpl implements CustomMemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void customSaveMethod(Member member) {
        entityManager.persist(member);  // 엔티티를 직접 저장하는 로직
    }
}

```

위의 코드에서 `@PersistenceContext`는 `EntityManager`를 주입하여 JPA의 표준 기능을 활용할 수 있게 합니다.

### 2. 커스텀 JPA 리포지토리 구현 단계

커스텀 리포지토리를 구현하는 기본적인 단계는 다음과 같습니다.

### (1) 커스텀 리포지토리 인터페이스 작성

이 인터페이스는 추가로 구현하고 싶은 메서드를 정의합니다.

```java

@NoRepositoryBean
public interface CustomMemberRepository {
    void customSaveMethod(Member member);
}

```

### (2) 커스텀 리포지토리 구현 클래스 작성

인터페이스를 구현하는 클래스에서 `@PersistenceContext`로 `EntityManager`를 주입받고, 해당 메서드에서 이를 사용해 JPA 작업을 수행합니다. 구현 클래스의 이름은 기본적으로 `CustomMemberRepositoryImpl`과 같이, `Impl` 접미사를 붙여야 합니다. Spring Data JPA가 이 규칙에 따라 커스텀 리포지토리를 연결합니다.

```java

public class CustomMemberRepositoryImpl implements CustomMemberRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void customSaveMethod(Member member) {
        entityManager.persist(member);  // 커스텀 저장 로직
    }
}

```

### (3) 기본 리포지토리와 연결

기본 리포지토리에 커스텀 리포지토리를 상속시켜서 기능을 확장합니다.

```java
java
코드 복사
public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {
    // JpaRepository와 커스텀 리포지토리 모두의 기능을 사용할 수 있음
}

```

### 3. 주요 개념 설명

- `@NoRepositoryBean`: 해당 인터페이스가 리포지토리 빈으로 등록되지 않도록 설정.
- `@PersistenceContext`: JPA의 `EntityManager`를 주입받아 직접적인 JPA 작업을 가능하게 함.

### 4. 예시 프로젝트 구조

1. **CustomMemberRepository.java**:

    ```java
    
    @NoRepositoryBean
    public interface CustomMemberRepository {
        void customSaveMethod(Member member);
    }
    
    ```

2. **CustomMemberRepositoryImpl.java**:

    ```java
    
    public class CustomMemberRepositoryImpl implements CustomMemberRepository {
    
        @PersistenceContext
        private EntityManager entityManager;
    
        @Override
        public void customSaveMethod(Member member) {
            entityManager.persist(member);
        }
    }
    
    ```

3. **MemberRepository.java**:

    ```java
    
    public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {
        // JpaRepository의 기본 CRUD 기능 + CustomMemberRepository의 커스텀 기능
    }
    
    ```


이와 같은 방식으로 커스텀 리포지토리를 사용하면 JPA 기본 기능 외에도 복잡한 로직을 처리할 수 있는 확장된 기능을 제공할 수 있습니다.
  
### 참고
[spring-data-base-repository](https://vladmihalcea.com/spring-data-base-repository/)