Jasypt (Java Simplified Encryption) 라이브러리를 사용하면 Spring Boot 애플리케이션의 **`application.yml`** 파일에 있는 민감한 정보를 암호화할 수 있습니다. 이를 위해 Jasypt의 **`StringEncryptor`**를 설정하고, 암호화된 프로퍼티를 자동으로 복호화하도록 Spring Boot를 구성해야 합니다.

Jasypt는 Spring boot 2.X 버전과 3.X 버전과 통합을 지원한다.

문서: https://github.com/ulisesbocchio/jasypt-spring-boot

### **1. Jasypt 의존성 추가**

이미 **`com.github.ulisesbocchio:jasypt-spring-boot-starter`** 의존성이 포함되어 있습니다. 추가 설정은 필요하지 않습니다.

1. @SpringbootApplication 혹은 @EnableAutoConfiguration 어노테이션을 지정하는 경우 jasypt-spring-boot-starter 디펜던시만 추가(spring environment에서 암호화 가능한 속성을 활성화 할 수 있다.)
2. jasypt-spring-boot(jasypt-spring-boot-starter 아님) 디펜던시를 추가하고 @Configuration 클래스에 @EnableEncryptableProperties 어노테이션을 추가하여 전체 spring environment에서 암호화 가능한 속성을 활성화 할 수 있음
3. jasypt-spring-boot 디펜던시를 추가하고 개별 암호화 가능한 프로퍼티 소스를 @EncryptablePropertySource에 지정하여 특정 설정파일에 대해서 암호화 가능한 속성을 활성화 할 수 있음

jasypt-spring-boot-starter 디펜던시를 추가하면 자동으로 jasypt-spring-boot 디펜던시가 추가된다.

### **2. 암호화된 프로퍼티 사용**

먼저, 암호화할 값을 생성해야 합니다. Jasypt CLI 도구를 사용하여 값을 암호화할 수 있습니다.

```

# Jasypt CLI를 사용하여 암호화 예시
encrypt input="my_secret_password" password="encryption_key"

```

위 명령어는 `my_secret_password`를 `encryption_key`를 사용하여 암호화합니다. 결과는 암호화된 텍스트로 반환됩니다.

Jasypt에서 사용할 수 있는 알고리즘은 다양한 표준 암호화 알고리즘으로, 각 알고리즘은 보안 강도와 성능에 차이가 있습니다. Jasypt는 JCE (Java Cryptography Extension) API를 사용하여 암호화를 수행하므로, 사용 가능한 알고리즘은 JCE에서 지원하는 알고리즘과 일치합니다.

### **사용 가능한 알고리즘 예시**

- **PBEWithMD5AndDES**
- **PBEWithMD5AndTripleDES**
- **PBEWithSHA1AndDESede**
- **PBEWithSHA1AndRC2_40**
- **AES** (Advanced Encryption Standard)
- **DES** (Data Encryption Standard)
- **TripleDES** (Triple Data Encryption Standard)
- **Blowfish**

이 알고리즘들은 다양한 해시 함수와 암호화 방법을 조합하여 사용합니다.

### **알고리즘에 따른 차이점**

1. **보안 강도**
    - **AES**: 가장 널리 사용되는 강력한 암호화 알고리즘 중 하나입니다. 다양한 키 길이(128, 192, 256비트)를 지원하며, 매우 높은 보안성을 제공합니다.
    - **DES**: 더 이상 권장되지 않는 알고리즘입니다. 56비트 키 길이를 사용하며, 보안성이 낮습니다.
    - **TripleDES**: DES를 세 번 반복하여 사용하는 알고리즘으로, DES보다 보안성이 높지만 성능이 떨어집니다.
    - **Blowfish**: 보안성과 성능의 균형이 좋습니다. 최대 448비트 키 길이를 지원합니다.
2. **성능**
    - **AES**: 보안성이 높음에도 불구하고 상대적으로 빠른 성능을 제공합니다.
    - **DES**: 보안성이 낮은 대신 성능은 빠릅니다.
    - **TripleDES**: 보안성은 높지만 성능이 떨어집니다.
    - **Blowfish**: 성능과 보안성의 균형이 좋습니다.
3. **적용 용도**
    - **AES**: 금융, 정부, 군사 등 높은 보안이 요구되는 곳에서 사용됩니다.
    - **DES**: 더 이상 사용되지 않으며, 오래된 시스템에서만 사용됩니다.
    - **TripleDES**: DES의 대안으로 사용되지만, 현재는 AES로 대체되는 추세입니다.
    - **Blowfish**: 다양한 일반적인 용도로 사용됩니다.

### **Jasypt 설정 예시**

```java
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setPassword(System.getenv("ENCRYPTION_PASSWORD")); // 환경 변수에서 암호화 키를 가져옵니다.
        config.setAlgorithm("PBEWithMD5AndTripleDES"); // 사용할 알고리즘을 설정합니다.
        config.setPoolSize(1);
        // 기본설정
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}

```

### **각 알고리즘의 설정과 차이점 요약**

- **AES**:
    - 설정: **`config.setAlgorithm("PBEWithHmacSHA256AndAES_256");`**
    - 보안 강도: 매우 높음
    - 성능: 우수
    - 사용 사례: 높은 보안이 요구되는 환경
- **TripleDES**:
    - 설정: **`config.setAlgorithm("PBEWithSHA1AndTripleDES");`**
    - 보안 강도: 중간
    - 성능: 느림
    - 사용 사례: 레거시 시스템, 높은 보안이 필요하지 않은 환경
- **Blowfish**:
    - 설정: **`config.setAlgorithm("Blowfish");`**
    - 보안 강도: 중간에서 높음
    - 성능: 우수
    - 사용 사례: 일반적인 암호화 용도

### **결론**

암호화 알고리즘을 선택할 때는 보안 요구 사항과 성능 요구 사항을 고려해야 합니다. AES는 일반적으로 가장 안전하고 효율적인 선택이며, DES와 TripleDES는 더 이상 권장되지 않습니다. Blowfish는 성능과 보안의 균형이 잘 맞는 알고리즘으로 다양한 용도에 적합합니다.