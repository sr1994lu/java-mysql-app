package my.beans.sample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * MyCalendar01 Class. 日付の管理と出力の機能を組み合わせた自作クラス.
 */
public class MyCalendar01 {

  protected Calendar cal = Calendar.getInstance();
  protected int year;
  protected int month;
  protected int date;
  protected int hourOfDay;
  protected int minute;
  protected int second;

  public static int NEN = 0;
  public static int TSUKI = 1;
  public static int HI = 2;

  /**
   * Constructor. 現在日時を取得する.
   */
  public MyCalendar01() {
    this.cal.clear(Calendar.YEAR);
    this.cal.clear(Calendar.MONTH);
    this.cal.clear(Calendar.DAY_OF_MONTH);
    this.cal.clear(Calendar.AM_PM);
    this.cal.set(Calendar.HOUR_OF_DAY, 0);
    this.cal.clear(Calendar.MINUTE);
    this.cal.clear(Calendar.SECOND);
    this.cal.clear(Calendar.MILLISECOND);
    this.cal = Calendar.getInstance();

    this.year = this.cal.get(Calendar.YEAR);
    this.month = this.cal.get(Calendar.MONTH) + 1;
    this.date = this.cal.get(Calendar.DAY_OF_MONTH);

    this.cal.set(this.year, this.month - 1, this.date);
  }

  /**
   * Constructor. 指定された年、月、日をセットする.
   *
   * @param year 年.
   * @param month 月.
   * @param date 日.
   */
  public MyCalendar01(int year, int month, int date) {
    this.cal.clear(Calendar.YEAR);
    this.cal.clear(Calendar.MONTH);
    this.cal.clear(Calendar.DAY_OF_MONTH);
    this.cal.clear(Calendar.AM_PM);
    this.cal.set(Calendar.HOUR_OF_DAY, 0);
    this.cal.clear(Calendar.MINUTE);
    this.cal.clear(Calendar.SECOND);
    this.cal.clear(Calendar.MILLISECOND);
    this.cal = Calendar.getInstance();

    this.year = year;
    this.month = month;
    this.date = date;

    this.cal.set(this.year, this.month - 1, this.date);
  }

  /**
   * Constructor. 指定された年、月、日をセットする.
   *
   * @param year 年.
   * @param month 月.
   * @param date 日.
   */
  public MyCalendar01(String year, String month, String date) {
    this.cal.clear(Calendar.YEAR);
    this.cal.clear(Calendar.MONTH);
    this.cal.clear(Calendar.DAY_OF_MONTH);
    this.cal.clear(Calendar.AM_PM);
    this.cal.set(Calendar.HOUR_OF_DAY, 0);
    this.cal.clear(Calendar.MINUTE);
    this.cal.clear(Calendar.SECOND);
    this.cal.clear(Calendar.MILLISECOND);
    this.cal = Calendar.getInstance();

    this.year = Integer.parseInt(year);
    this.month = Integer.parseInt(month);
    this.date = Integer.parseInt(date);

    this.cal.set(this.year, this.month - 1, this.date);
  }

  /**
   * setYear. 引数を年としてセットする.
   *
   * @param year 年.
   */
  public void setYear(int year) {
    this.year = year;
  }

  /**
   * setYear. 引数を年としてセットする.
   *
   * @param year 年.
   */
  public void setYear(String year) {
    this.year = Integer.parseInt(year);
  }

  /**
   * setMonth. 引数を月としてセットする.
   *
   * @param month 月.
   */
  public void setMonth(int month) {
    this.month = month;
  }

  /**
   * setMonth. 引数を月としてセットする.
   *
   * @param month 月.
   */
  public void setMonth(String month) {
    this.month = Integer.parseInt(month);
  }

  /**
   * setDay. 引数を日としてセットする.
   *
   * @param date 日.
   */
  public void setDay(int date) {
    this.date = date;
  }

  /**
   * setDay. 引数を日としてセットする.
   *
   * @param date 日.
   */
  public void setDay(String date) {
    this.date = Integer.parseInt(date);
  }

  /**
   * set. 年月日をセットする.
   *
   * @param year 年.
   * @param month 月.
   * @param date 日.
   */
  public void set(int year, int month, int date) {
    this.year = year;
    this.month = month;
    this.date = date;
  }

  /**
   * set. 年月日をセットする.
   *
   * @param year 年.
   * @param month 月.
   * @param date 日.
   */
  public void set(String year, String month, String date) {
    this.year = Integer.parseInt(year);
    this.month = Integer.parseInt(month);
    this.date = Integer.parseInt(date);
  }

  /**
   * set. 定数で指定された年月日に値をセット.
   *
   * @param CONST 定数.
   * @param param 値.
   */
  public void set(int CONST, int param) {
    switch (CONST) {
      case 0:
        this.year = param;
        break;
      case 1:
        this.month = param;
        break;
      case 2:
        this.date = param;
        break;
      default:
        break;
    }
  }

  /**
   * set. 定数で指定された年月日に値をセット.
   *
   * @param CONST 定数.
   * @param param 値.
   */
  public void set(int CONST, String param) {
    switch (CONST) {
      case 0:
        this.year = Integer.parseInt(param);
        break;
      case 1:
        this.month = Integer.parseInt(param);
        break;
      case 2:
        this.date = Integer.parseInt(param);
        break;
      default:
        break;
    }
  }

  /**
   * add. 引数の値を加算する.
   *
   * @param date 加算日.
   */
  public void add(int date) {
    this.date += date;
  }

  /**
   * add. 引数の値を加算する.
   *
   * @param date 加算日.
   */
  public void add(String date) {
    this.date += Integer.parseInt(date);
  }

  /**
   * add. 定数で指定された年月日に値を加算.
   *
   * @param CONST 定数.
   * @param param 値.
   */
  public void add(int CONST, int param) {
    switch (CONST) {
      case 0:
        this.year += param;
        break;
      case 1:
        this.month += param;
        break;
      case 2:
        this.date += param;
        break;
      default:
        break;
    }
  }

  /**
   * add. 定数で指定された年月日に値を加算.
   *
   * @param CONST 定数.
   * @param param 値.
   */
  public void add(int CONST, String param) {
    switch (CONST) {
      case 0:
        this.year += Integer.parseInt(param);
        break;
      case 1:
        this.month += Integer.parseInt(param);
        break;
      case 2:
        this.date += Integer.parseInt(param);
        break;
      default:
        break;
    }
  }

  /**
   * difference. 引数の年月日との日数差を返す.
   *
   * @param year 年.
   * @param month 月.
   * @param date 日.
   * @return 引数の年月日との日数差.
   */
  public int difference(int year, int month, int date) {
    Calendar differentCal = Calendar.getInstance();
    differentCal.set(year, month - 1, date);
    long timeInMillis = this.cal.getTimeInMillis() - differentCal.getTimeInMillis();
    timeInMillis = timeInMillis / 1000 / 60 / 60 / 24;
    String timeInMillisAbs = Long.toString(Math.abs(timeInMillis));
    return Integer.parseInt(timeInMillisAbs);
  }

  /**
   * difference. 引数の年月日との日数差を返す.
   *
   * @param year 年.
   * @param month 月.
   * @param date 日.
   * @return 引数の年月日との日数差.
   */
  public int difference(String year, String month, String date) {
    Calendar differentCal = Calendar.getInstance();
    differentCal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(date));
    long timeInMillis = this.cal.getTimeInMillis() - differentCal.getTimeInMillis();
    timeInMillis = timeInMillis / 1000 / 60 / 60 / 24;
    String timeInMillisAbs = Long.toString(Math.abs(timeInMillis));
    return Integer.parseInt(timeInMillisAbs);
  }

  /**
   * getYear. 年をStringで返す.
   *
   * @return 年.
   */
  public String getYear() {
    return Integer.toString(this.year);
  }

  /**
   * getMonth. 月をStringで返す.
   *
   * @return 月.
   */
  public String getMonth() {
    return Integer.toString(this.month);
  }

  /**
   * getDay. 日をStringで返す.
   *
   * @return 日.
   */
  public String getDay() {
    return Integer.toString(this.date);
  }

  /**
   * getJapaneseFormat. yyyy年MM月dd日を返す.
   *
   * @return yyyy年MM月dd日
   */
  public String getJapaneseFormat() {
    this.cal.clear(Calendar.YEAR);
    this.cal.clear(Calendar.MONTH);
    this.cal.clear(Calendar.DAY_OF_MONTH);
    this.cal.clear(Calendar.AM_PM);
    this.cal.set(Calendar.HOUR_OF_DAY, 0);
    this.cal.clear(Calendar.MINUTE);
    this.cal.clear(Calendar.SECOND);
    this.cal.clear(Calendar.MILLISECOND);
    this.cal.set(this.year, this.month - 1, this.date);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日", Locale.JAPANESE);
    return sdf.format(this.cal.getTime());
  }

  /**
   * getJapaneseWeek. 指定された日付の曜日を日〜土で返す.
   *
   * @return 指定された日付の曜日.
   */
  public String getJapaneseWeek() {
    this.cal.clear(Calendar.YEAR);
    this.cal.clear(Calendar.MONTH);
    this.cal.clear(Calendar.DAY_OF_MONTH);
    this.cal.clear(Calendar.AM_PM);
    this.cal.set(Calendar.HOUR_OF_DAY, 0);
    this.cal.clear(Calendar.MINUTE);
    this.cal.clear(Calendar.SECOND);
    this.cal.clear(Calendar.MILLISECOND);
    this.cal.set(this.year, this.month - 1, this.date);

    SimpleDateFormat sdf = new SimpleDateFormat("EEE曜日", Locale.JAPANESE);
    return sdf.format(this.cal.getTime());
  }

  /**
   * getSimpleFormat. yyyy/MM/ddを返す.
   *
   * @return yyyy/MM/dd
   */
  public String getSimpleFormat() {
    this.cal.clear(Calendar.YEAR);
    this.cal.clear(Calendar.MONTH);
    this.cal.clear(Calendar.DAY_OF_MONTH);
    this.cal.clear(Calendar.AM_PM);
    this.cal.set(Calendar.HOUR_OF_DAY, 0);
    this.cal.clear(Calendar.MINUTE);
    this.cal.clear(Calendar.SECOND);
    this.cal.clear(Calendar.MILLISECOND);
    this.cal.set(this.year, this.month - 1, this.date);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.JAPANESE);
    return sdf.format(this.cal.getTime());
  }

  /**
   * getEnglishWeek. 指定された曜日の英語表記(3文字)を返す.
   *
   * @param cal Calendar Object.
   * @return 指定された曜日の英語表記.
   */
  public String getEnglishWeek(Calendar cal) {
    this.cal.clear(Calendar.YEAR);
    this.cal.clear(Calendar.MONTH);
    this.cal.clear(Calendar.DAY_OF_MONTH);
    this.cal.clear(Calendar.AM_PM);
    this.cal.set(Calendar.HOUR_OF_DAY, 0);
    this.cal.clear(Calendar.MINUTE);
    this.cal.clear(Calendar.SECOND);
    this.cal.clear(Calendar.MILLISECOND);
    this.cal.set(this.year, this.month - 1, this.date);

    SimpleDateFormat sdf = new SimpleDateFormat("EEE", Locale.ENGLISH);
    return sdf.format(cal.getTime());
  }

  /**
   * getJapaneseMonth. 指定された月を(ex: 9月)の形で返す.
   *
   * @return 指定された月.
   */
  public String getJapaneseMonth() {
    return MyCalendarStatic01.getMonthString(this.cal);
  }
}
