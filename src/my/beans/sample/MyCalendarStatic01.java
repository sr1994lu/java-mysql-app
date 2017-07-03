package my.beans.sample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Class. MyCalendar BeansにてStaticメソッドとして使用する.
 */
public final class MyCalendarStatic01 {

  /**
   * getMonthString. 指定された月を文字列で返す.
   *
   * @param cal Calendar Object.
   * @return 指定された月.
   */
  static String getMonthString(Calendar cal) {
    SimpleDateFormat sdf = new SimpleDateFormat("M月", Locale.JAPANESE);
    return sdf.format(cal.getTime());
  }
}
