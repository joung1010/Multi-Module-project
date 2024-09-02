package com.business.configuration.framework.utils;

import com.business.configuration.framework.exception.ApplicationException;
import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.standard.enums.CommonCodeType;
import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;

/**
 * <b> EnumsToolkits </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-02
 */
public class EnumsToolkits extends EnumUtils {

    /**
     * 열거형 이름으로 열거형 값을 찾는 메서드.
     *
     * @param <E>       열거형 타입으로, Enum을 상속받고 CommonCodeType 인터페이스를 구현한 타입이어야 합니다.
     * @param enumClass 검색할 열거형 클래스
     * @param enumName  검색할 열거형 이름
     * @return 주어진 열거형 이름에 해당하는 열거형 값
     */
    public static <E extends Enum<E> & CommonCodeType> E findEnumByEnumName(Class<E> enumClass
            , String enumName) {

        return EnumUtils.getEnum(enumClass, enumName);
    }

    /**
     * 코드로 열거형 값을 찾는 메서드.
     *
     * @param <E>       열거형 타입으로, Enum을 상속받고 CommonCodeType 인터페이스를 구현한 타입이어야 합니다.
     * @param enumClass 검색할 열거형 클래스
     * @param code      검색할 코드 값
     * @return 주어진 코드 값에 해당하는 열거형 값
     * @throws ApplicationException 해당 코드에 해당하는 열거형 값이 존재하지 않을 경우 예외를 발생시킵니다.
     */
    public static <E extends Enum<E> & CommonCodeType> E findEnumByCode(Class<E> enumClass
            , String code) {

        return Arrays.stream(enumClass.getEnumConstants())
                .filter(e -> StringToolkits.equals(e.getCode(), code))
                .findFirst()
                .orElseThrow(() -> new ApplicationException(BasicErrorCode.RESOURCE_NOT_FOUND));
    }

}
