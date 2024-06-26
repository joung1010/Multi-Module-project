# Multi-Module-project

## 모듈간 연결설정
루트 프로젝트와 하위 모듈 간의 연결은 Gradle의 settings.gradle 파일과 루트 build.gradle 파일을 통해 이루어집니다. 루트 프로젝트의 build.gradle 파일에서는 공통 플러그인, 의존성, 그리고 설정을 정의하고, 이를 하위 모듈에 적용할 수 있도록 설정한다.  
  
하위 모듈의 build.gradle 파일은 모듈 특화 설정을 추가합니다.  

프로젝트 구성 설명
1. settings.gradle 파일
   settings.gradle 파일은 Gradle 멀티 프로젝트의 루트에서 사용되며, 어떤 하위 프로젝트들이 포함될지를 정의합니다.

settings.gradle:
```gradle
rootProject.name = 'multi-module'
include 'modules:endpoint:module-core-api'
```
이 파일은 include 'modules:endpoint:module-core-api' 모듈을 멀티 프로젝트 빌드의 일부로 포함시킵니다.  

2. 루트 build.gradle 파일
   루트 build.gradle 파일은 공통 설정을 포함하며, 모든 하위 모듈에 적용될 기본 설정을 정의합니다.

루트 build.gradle:
```gradle

plugins {
    id 'java'
    id 'org.springframework.boot' version '3.2.5' apply false
    id 'io.spring.dependency-management' version '1.1.4' apply false
}

group = 'com.business'
version = '0.0.1-SNAPSHOT'

java {
    sourceCompatibility = '17'
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

subprojects {
    apply plugin: 'java'
    apply plugin: 'org.springframework.boot'
    apply plugin: 'io.spring.dependency-management'

    java {
        sourceCompatibility = '17'
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
    }

    tasks.named('test') {
        useJUnitPlatform()
    }
}


```
설명:
- plugins: 루트 프로젝트와 모든 하위 모듈에 적용할 플러그인을 정의합니다. apply false는 루트 프로젝트에서는 플러그인을 적용하지 않고, 하위 모듈에서 적용할 수 있도록 설정합니다.
- group, version: 프로젝트의 그룹과 버전을 정의합니다.
- java { sourceCompatibility = '17' }: Java 17을 소스 호환성으로 설정합니다.
- repositories: Maven Central 및 Gradle Plugin Portal을 사용하여 의존성을 가져옵니다.
- allprojects: 모든 프로젝트(루트 및 하위 모듈)에 공통으로 적용될 설정을 정의합니다.
- subprojects: 모든 하위 모듈에 적용될 설정을 정의합니다. 여기서 apply plugin 구문을 통해 하위 모듈에 플러그인을 적용하고, 공통 의존성을 정의합니다.
  
### 추가
루트 그레이들은 mainClass 가 존재 하지않기 때문에
``` gradle
    bootJar {
        enabled = false
    }

// 기본적으로 모든 서브프로젝트에서 jar 활성화
    jar {
        enabled = true
    }

```  
해당 옵션을 추가해준다.  

3. 하위 모듈 build.gradle 파일
   하위 모듈의 build.gradle 파일은 해당 모듈에 특화된 설정을 추가합니다. 루트 build.gradle 파일에서 정의한 공통 설정과 의존성을 상속받습니다.
  
modules/endpoint/module-core-api/build.gradle:
```gradle
plugins {
    id 'org.springframework.boot'
    id 'io.spring.dependency-management'
    id 'org.jetbrains.kotlin.jvm' version '1.8.0'
    id 'org.jetbrains.kotlin.plugin.spring' version '1.8.0'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'

    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.junit.jupiter:junit-jupiter-api'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine'
}

tasks.named('test') {
    useJUnitPlatform()
}

bootJar {
    archiveFileName = 'module-core-api.jar'
}


```
설명:

- plugins: 루트 build.gradle 파일에서 apply false로 설정한 플러그인을 실제로 적용합니다.
- dependencies: 하위 모듈에 특화된 의존성을 추가합니다.
- tasks.named('test') { useJUnitPlatform() }: JUnit Platform을 사용하여 테스트를 실행합니다.
- bootJar { archiveFileName = 'module-end-point.jar' }: 빌드 시 생성될 jar 파일의 이름을 설정합니다.

연결 및 상속
루트 build.gradle 파일에서 subprojects 블록을 통해 정의된 설정과 의존성은 모든 하위 모듈에 자동으로 적용됩니다. 하위 모듈은 추가적인 플러그인과 의존성을 정의하여 모듈 특화 설정을 할 수 있습니다.

이를 통해, 루트 프로젝트에서 공통된 설정과 의존성을 관리하고, 각 하위 모듈에서는 해당 모듈에 특화된 설정을 추가하여 사용할 수 있습니다.