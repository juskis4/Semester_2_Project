package server.model.domain;

import java.io.Serializable;

/**
 * A class that represent the time.
 */
public class Time implements Serializable
{
  private int hour;
  private int minute;
  private int second;

  /**
   * A constructor for time.
   * @param h hour.
   * @param m minute.
   * @param s second.
   */
  public Time(int h, int m, int s)
  {
    this.hour = h;
    this.minute = m;
    this.second = s;
  }

  /**
   * A constructor for time with only hour and minute.
   * @param h hour.
   * @param m minute.
   */
  public Time(int h, int m)
  {
    this.hour = h;
    this.minute = m;
  }

  /**
   * A constructor with only seconds.
   * @param totalTimeInSeconds seconds.
   */
  public Time(int totalTimeInSeconds)
  {
    if (totalTimeInSeconds < 0)
    {
      totalTimeInSeconds = 0;
    }
    this.hour = totalTimeInSeconds / 3600;
    this.minute = (totalTimeInSeconds % 3600) / 60;
    this.second = (totalTimeInSeconds % 3600) % 60;
  }

  /**
   * A method that moves time by 1 second.
   */
  public void tic()
  {
    int a = convertToSeconds();
    a++;
    this.hour = a / 3600;
    this.minute = (a % 3600) / 60;
    this.second = (a % 3600) % 60;
  }

  /**
   * A method that moves time by wanted seconds.
   * @param seconds second that time will be moved by.
   */
  public void tic(int seconds)
  {
    int a = convertToSeconds();
    a +=seconds;
    this.hour = a / 3600;
    this.minute = (a % 3600) / 60;
    this.second = (a % 3600) % 60;
  }

  /**
   * A method that converts time to seconds.
   * @return time in seconds.
   */
  public int convertToSeconds()
  {
    return (hour*60*60) + (minute*60) + second;
  }

  /**
   * A method that checks if one time is before other.
   * @param time2 time that is supposed to be after another time.
   * @return true if time2 is after another time, false if otherwise.
   */
  public boolean isBefore(Time time2)
  {
    return convertToSeconds()<time2.convertToSeconds();
  }

  /**
   * A method that calculates the time between 2 time objects.
   * @param time2 second time.
   * @return the time between time 1 and time2.
   */
  public Time timeTo(Time time2)
  {
    int timeInSeconds = time2.convertToSeconds() - ((hour*3600) + (minute * 60) + second);
    Time time = new Time(timeInSeconds);
    return time;
  }

  /**
   * A method that copies a time object.
   * @return time object.
   */
  public Time copy()
  {
    Time time = new Time(hour, minute, second);
    return time;
  }

  /**
   * A method that checks if object is equal with time.
   * @param obj object that is going to be compared with time.
   * @return true if object is equals to object, false if otherwise.
   */
  public boolean equals(Object obj)
  {
    if(!(obj instanceof Time))
    {
      return false;
    }
    Time other = (Time)obj;
    return this.hour == other.hour && this.minute == other.minute && this.second == other.second;
  }

  /**
   * A method that puts time in a specific format.
   * @return A string with time in a specific format.
   */
  @Override public String toString()
  {
    return this.hour + ":" + this.minute;
  }
}
