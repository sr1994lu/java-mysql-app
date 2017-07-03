package my.beans.sample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MyCalendar11 extends MyCalendar01 {

  public static int JI = 3;
  public static int FUN = 4;
  public static int BYO = 5;

  public MyCalendar11() {
    super();
  }

  public MyCalendar11(int year,
      int month,
      int date,
      int hourOfDay,
      int minute,
      int second) {
    this.year = year;
    this.month = month;
    this.date = date;
    this.hourOfDay = hourOfDay;
    this.minute = minute;
    this.second = second;

    this.cal.set(this.year,
        this.month - 1,
        this.date,
        this.hourOfDay,
        this.minute,
        this.second);
  }

  public MyCalendar11(String year,
      String month,
      String date,
      String hourOfDay,
      String minute,
      String second) {
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
    this.hourOfDay = Integer.parseInt(hourOfDay);
    this.minute = Integer.parseInt(minute);
    this.second = Integer.parseInt(second);

    this.cal.set(this.year,
        this.month - 1,
        this.date,
        this.hourOfDay,
        this.minute,
        this.second);
  }

  public MyCalendar11(int year, int month, int date) {
    super(year, month, date);
  }

  public MyCalendar11(String year, String month, String date) {
    super(year, month, date);
  }

  @Override
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

  @Override
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

  @Override
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

  @Override
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

  @Override
  public String getJapaneseFormat() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒", Locale.JAPANESE);
    return sdf.format(this.cal.getTime());
  }

  @Override
  public String getSimpleFormat() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.JAPANESE);
    return sdf.format(this.cal.getTime());
  }
}
