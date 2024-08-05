package com.business.configuration.data.p6spy.format;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class P6spyPrettySqlFormatter implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        sql = formatSql(category, sql);
        Date currentDate = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yy.MM.dd HH:mm:ss");

        return String.format("%s | OperationTime: %dms%n%s", format1.format(currentDate), elapsed, sql);
    }

    private String formatSql(String category, String sql) {
        if (sql == null || sql.trim().isEmpty()) return sql;

        if (Category.STATEMENT.getName().equals(category)) {
            String tmpsql = sql.trim().toLowerCase();
            if (tmpsql.startsWith("create") || tmpsql.startsWith("alter") || tmpsql.startsWith("comment")) {
                sql = FormatStyle.DDL.getFormatter().format(sql);
            } else {
                sql = FormatStyle.BASIC.getFormatter().format(sql);
            }
            sql = String.format("|%nFormatted SQL (P6Spy + Hibernate format):%n%s", sql);
        }

        return sql;
    }
}
