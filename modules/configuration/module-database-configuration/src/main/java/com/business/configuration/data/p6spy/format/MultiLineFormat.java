package com.business.configuration.data.p6spy.format;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

public class MultiLineFormat implements MessageFormattingStrategy {

  @Override
  public String formatMessage(final int connectionId, final String now, final long elapsed, final String category, final String prepared, final String sql, final String url) {
    return "#" + now + " | took " + elapsed + "ms | " + category + " | connection " + connectionId + "| url " + url + "\n" + prepared + "\n" + sql +";";
  }

}