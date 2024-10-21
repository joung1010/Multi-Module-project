## 메세지 다국화 오류 분석

1. LocaleContextHolder를 활용한 Locale 설정
   이전 설정에서 MessageSourceAccessor는 기본 로케일로 Locale.KOREA를 사용하도록 설정되어 있었습니다. 이는 프로퍼티 파일을 읽을 때 한국어 로케일을 기본값으로 설정해 두었기 때문에, 테스트 중 영어 로케일로 변경해도 MessageSourceAccessor가 항상 한국어 프로퍼티 파일을 참조하고 있었습니다.

새롭게 수정된 코드에서는 MessageSourceAccessor를 생성할 때 로케일을 LocaleContextHolder.getLocale()로 설정했습니다. LocaleContextHolder는 현재 요청 또는 스레드에 설정된 로케일을 참조하기 때문에, 이제 로케일을 동적으로 변경할 수 있게 되었습니다. 이렇게 하여 테스트 코드에서 로케일을 한국어(Locale.KOREA) 또는 영어(Locale.ENGLISH)로 변경한 후 MessageSourceAccessor가 이 변경된 로케일을 정확히 반영하게 되었습니다.

2. ReloadableResourceBundleMessageSource의 동적 로케일 지원 개선
   이전 코드에서 messageSource는 기본 로케일을 한국어(Locale.KOREA)로 설정하고 있었습니다. 이로 인해 로케일 변경이 제대로 반영되지 않는 문제가 발생할 수 있었습니다. 특히, 프로퍼티 파일에서 한국어와 영어의 두 가지 로케일을 지원하고 테스트 시 로케일을 변경하려고 할 때 문제가 되었죠.

수정된 설정에서는 messageSource의 DefaultLocale 설정이 동일하게 남아 있지만, MessageSourceAccessor가 LocaleContextHolder.getLocale()로부터 동적으로 로케일을 참조하므로 로케일에 대한 유연한 변경이 가능하게 되었습니다.

3. 테스트 성공 원인
   기존 코드에서는 MessageSourceAccessor가 기본적으로 고정된 로케일(Locale.KOREA)을 사용하므로, 테스트 중에 로케일을 변경해도 이 변경 사항이 반영되지 않았습니다. 따라서, 한국어 로케일로 기본 설정된 메시지를 참조하려고 하였고, 이로 인해 영어 메시지를 조회하는 테스트(testEnLocaleMessage)에서 실패했습니다.

수정된 코드에서는 테스트 실행 전에 LocaleContextHolder.setLocale(Locale.XXX)를 호출하여 동적으로 로케일을 설정하고, 이 설정된 로케일이 MessageSourceAccessor에 반영되도록 하였기 때문에 올바른 메시지를 가져올 수 있었습니다. 즉, 로케일을 동적으로 변경하고 그에 따라 해당 로케일의 메시지를 정확히 불러오게 된 것입니다.

요약
변경 전: MessageSourceAccessor에서 로케일이 항상 한국어로 고정되어 있었기 때문에 테스트 중 로케일 변경이 반영되지 않음.
변경 후: LocaleContextHolder의 로케일 설정을 기반으로 MessageSourceAccessor가 동적으로 로케일을 참조하게 하여, 테스트 코드에서 설정한 로케일에 따라 정확한 메시지를 반환할 수 있게 됨.
이러한 변경으로 인해 testKoLocaleMessage와 testEnLocaleMessage 테스트가 각각 올바른 프로퍼티 파일의 메시지를 참조하게 되었고, 테스트가 성공적으로 완료되었습니다.




