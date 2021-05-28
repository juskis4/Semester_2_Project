package server.model.domain;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A class that represents date.
 */

public class Date implements Serializable
{
  private int day;
  private int month;
  private int year;

  /**
   * A constructor for date class with integers.
   * @param day the day as an integer.
   * @param month the month as an integer.
   * @param year the year as an integer.
   */
  public Date(int day, int month, int year)
  {
    set(day, month, year);
  }

  /**
   * A constructor for date class with month name as a string.
   * @param day the day as an integer.
   * @param monthName the month as a string.
   * @param year the year as an integer.
   */
  public Date(int day, String monthName, int year)
  {
    this.day = day;
    this.month = convertToMonthNumber(monthName);
    this.year = year;
  }

  /**
   * A constructor for date that sets todays date.
   */
  public Date()
  {
    LocalDate today = LocalDate.now();
    this.day = today.getDayOfMonth();
    this.month = today.getMonthValue();
    this.year = today.getYear();
  }

  /**
   * Setter for date.
   * @param day the day as an integer.
   * @param month the month as an integer.
   * @param year the year as an integer.
   */
  public void set(int day, int month, int year)
  {
    if(year < 0)
    {
      year = -year;
    }
    if(month < 1)
    {
      month = 1;
    }
    else if(month > 12)
    {
      month = 12;
    }
    this.year = year;
    this.month = month;
    if(day < 1)
    {
      day = 1;
    }
    else if(day > numberOfDaysInMonth())
    {
      day = numberOfDaysInMonth();
    }
    this.day = day;
  }
  public int getDay()
  {
    return day;
  }
  public int getMonth()
  {
    return month;
  }
  public int getYear()
  {
    return year;
  }

  /**
   * A method that calculates if the year is Leap year.
   * @return true if Leap year, false if not.
   */
  public boolean isLeapYear()
  {
    if(year % 4 == 0 && ((year % 100 != 0) || year % 400 == 0))
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  /**
   * A method to move the date.
   * @param days the number of days that you want to move.
   */
  public void stepForward(int days)
  {
    for(int i = 0; i < days; i++)
    {
      stepForwardOneDay();
    }
  }

  /**
   * A method that calculates months name.
   * @return months name.
   */
  public String getMonthName()
  {
    if(month == 1)
    {
      return "January";
    }
    else if(month == 2)
    {
      return "February";
    }
    else if(month == 3)
    {
      return "March";
    }
    else if (month == 4)
    {
      return "April";
    }
    else if (month == 5)
    {
      return "May";
    }
    else if(month == 6)
    {
      return "June";
    }
    else if(month == 7)
    {
      return "July";
    }
    else if(month == 8)
    {
      return "August";
    }
    else if(month == 9)
    {
      return "September";
    }
    else if(month == 10)
    {
      return "October";
    }
    else if(month == 11)
    {
      return "November";
    }
    else if(month == 12)
    {
      return "December";
    }
    return "Error";
  }

  /**
   * A method to move the date by one day.
   */
  public void stepForwardOneDay()
  {
    day++;
    if(day>numberOfDaysInMonth())
    {
      month++;
      day=1;
    }
    if (month > 12)
    {
      month=1;
      year++;
    }
  }

  /**
   * A method that calculates how many days the month has.
   * @return number of days in a month.
   */
  public int numberOfDaysInMonth()
  {
    if(month == 2 && isLeapYear() == true)
    {
      return 29;
    }
    if(month == 2 && isLeapYear() == false)
    {
      return 28;
    }
    if(month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
    {
      return 31;
    }
    return 0;
  }

  /**
   * A method that checks if one date is before another.
   * @param other Date that is suppose to be or not suppose be be after another date.
   * @return true if date is before "other", false if otherwise.
   */
  public boolean isBefore(Date other)
  {
    int dummyDaysOfThis = year * 400 + month * 31 + day;
    int dummyDaysOfOther = other.year * 400 + other.month * 31 + other.day;
    return dummyDaysOfThis<dummyDaysOfOther;
  }

  /**
   * A method that calculates the years between 2 dates.
   * @param other the date that the years between is calculated.
   * @return the number of years between 2 dates.
   */
  public int yearsBetween(Date other)
  {
    int years = 0;
    if (isBefore(other))
    {
      years = other.year - this.year;
      if (this.month > other.month || (this.month == other.month && this.day > other.day))
      {
        years--;
      }
    }
    else
    {
      years = this.year - other.year;
      if(other.month > this.month || (other.month == this.month && other.day > this.day))
      {
        years--;
      }
    }
    return years;
  }

  /**
   * A method that calculates the day of the week.
   * @return the day of the week.
   */
  public String dayOfWeek()
  {
    double answer1;
    answer1 = ((13 *(month +1)) / 5);
    answer1 = answer1 + day;
    answer1 = answer1 + (year%100);
    answer1 = answer1 + ((year % 100)/4);
    answer1 = answer1 + ((year/100)/4);
    answer1 = answer1 + (5*(year/100));
    answer1 = answer1 % 7;
    switch ((int) answer1)
    {
      case 0: return "Saturday";
      case 1: return "Sunday";
      case 2: return "Monday";
      case 3: return "Tuesday";
      case 4: return "Wednesday";
      case 5: return "Thursday";
      case 6: return "Friday";
      default: return "Error";
    }
  }

  /**
   * A method that puts date in specific format.
   * @return return a string with date in a specific format.
   */
  @Override public String toString()
  {
    if (day < 10 && month >= 10)
    {
      return "0" + day + "/" + month + "/" + year;
    }
    if (day < 10 && month < 10)
    {
      return "0" + day + "/" + "0" + month + "/" + year;
    }
    if (day > 10 && month < 10)
    {
      return day + "/" + "0" + month + "/" + year;
    }
    else
    {
      return day + "/" + month + "/" + year;
    }
  }

  /**
   * A method that coverts month name to an integer.
   * @param monthName month name.
   * @return Monhth as and integer.
   */
  public static int convertToMonthNumber(String monthName)
  {
    switch (monthName)
    {
      case "January": return 1;
      case "February": return  2;
      case "March":  return 3;
      case "April": return  4;
      case "May": return 5;
      case "June": return 6;
      case "July": return 7;
      case "August": return 8;
      case "September": return 9;
      case "October": return 10;
      case "November": return 11;
      case "December": return 12;
    }
    return 0;
  }

  /**
   * A method to copy date.
   * @return the copy of the date.
   */
  public Date copy()
  {
    Date other = new Date(day, month, year);
    return other;
  }

  /**
   * A method that checks if date and another object are equal.
   * @param obj An object that is checked with date.
   * @return true if date and object are equal, false if otherwise.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Date))
    {
      return false;
    }
    Date other = (Date)obj;
    return this.day == other.day && this.month == other.month && this.year == other.year;
  }
}
