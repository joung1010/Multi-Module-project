package com.business.configuration.framework.utils;

import com.business.configuration.framework.exception.enums.BasicErrorMessageContents;
import com.business.configuration.framework.exception.handler.CoreExceptionHandler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.TimeZone;

/**
 * <b> DateTimeToolkits </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-09
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeToolkits {

    static {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Asia/Seoul")));
    }

    public static final DateTimeFormatter YMDHMS_SSS_FORMATTED = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final DateTimeFormatter YMD_DASHED_HMS_COLON_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter YMD_DASHED_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final DateTimeFormatter YMDHMS_SSS_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    public static final DateTimeFormatter YMDHMS_FORMAT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    public static final DateTimeFormatter YYYYMMDD_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static final DateTimeFormatter YYMMDD_FORMAT = DateTimeFormatter.ofPattern("yyMMdd");
    public static final DateTimeFormatter HMS_FORMAT = DateTimeFormatter.ofPattern("HHmmss");

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static LocalDate nowDate() {
        return LocalDate.now();
    }

    public static LocalTime nowTime() {
        return LocalTime.now();
    }

    public static String getStrCurrentTime() {
        return DateTimeToolkits.nowTime().format(HMS_FORMAT);
    }


    public static LocalDateTime utcNow() {
        return LocalDateTime.now(ZoneId.of("UTC"));
    }

    public static long getTimestamp() {
        return Instant.now().toEpochMilli();
    }


    public static String getCurrentStrYMD() {
        return DateTimeToolkits.nowDate().format(YYYYMMDD_FORMAT);
    }

    public static String getCurrentStrDashedYMD() {
        return DateTimeToolkits.nowDate().format(YMD_DASHED_FORMAT);
    }

    public static String getStrDashedYMD(LocalDate localDate) {
        if (ObjectToolkits.isEmpty(localDate)) {
            return Strings.EMPTY;
        }

        return localDate.format(YMD_DASHED_FORMAT);
    }

    public static String getStrYMD(LocalDate localDate) {
        if (ObjectToolkits.isEmpty(localDate)) {
            return Strings.EMPTY;
        }

        return localDate.format(YYYYMMDD_FORMAT);
    }

    public static LocalDate getDateFormatOfYMD(String ymd) {

        return Optional.ofNullable(ymd)
                .map(date -> LocalDate.parse(date, YYYYMMDD_FORMAT))
                .orElseThrow(() -> CoreExceptionHandler.handleApplicationException(new IllegalArgumentException(BasicErrorMessageContents.REQUIRED_PARAMETER_MISSING)));
    }

    public static String getCurrentStrYMDHMS() {
        return DateTimeToolkits.now().format(YMDHMS_FORMAT);
    }

    public static String getCurrentStrDashedYMDHMS() {
        return DateTimeToolkits.now().format(YMD_DASHED_HMS_COLON_FORMAT);
    }

    public static String getStrDashedYMDHMS(LocalDateTime localDateTime) {
        if (ObjectToolkits.isEmpty(localDateTime)) {
            return Strings.EMPTY;
        }

        return localDateTime.format(YMD_DASHED_HMS_COLON_FORMAT);
    }

    public static String getStrYMDHMS(LocalDateTime localDateTime) {
        if (ObjectToolkits.isEmpty(localDateTime)) {
            return Strings.EMPTY;
        }

        return localDateTime.format(YMDHMS_FORMAT);
    }


    public LocalDateTime getDateTimeFormatOfYMDHMS(String ymdhms) {

        return Optional.ofNullable(ymdhms)
                .map(dateTime -> LocalDateTime.parse(dateTime, YMDHMS_FORMAT))
                .orElseThrow(() -> CoreExceptionHandler.handleUnknownException(new IllegalArgumentException(BasicErrorMessageContents.REQUIRED_PARAMETER_MISSING)));
    }

    public LocalDateTime getDateTimeFormatOfYMDHMS(String ymd, String hms) {
        if (StringToolkits.isAnyBlank(ymd, hms)) {
            throw CoreExceptionHandler.handleUnknownException(new IllegalArgumentException(BasicErrorMessageContents.REQUIRED_PARAMETER_MISSING));
        }

        return LocalDateTime.parse(ymd + hms, YMDHMS_FORMAT);
    }

    public static String getCurrentStrYMDHMSssZ() {
        return DateTimeToolkits.now().format(YMDHMS_SSS_FORMAT);
    }

    public static String getCurrentStrDashedYMDHMSssZ() {
        return DateTimeToolkits.now().format(YMDHMS_SSS_FORMATTED);
    }


}
