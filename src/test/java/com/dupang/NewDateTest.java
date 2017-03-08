package com.dupang;

import junit.framework.TestCase;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Created by dupang on 16-6-21.
 */
public class NewDateTest extends TestCase{


    public void testNow(){
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);

        //LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
    }

    public void testOf(){
        LocalDate dateOfBirth = LocalDate.of(2014, 1, 14);
        System.out.println("Your Date of birth is : " + dateOfBirth);
    }

    public void testSameDate(){

        LocalDate today = LocalDate.now();
        LocalDate date1 = LocalDate.of(2017, 3, 7);
        if(date1.equals(today)){
            System.out.printf("Today %s and date1 %s are same date %n", today, date1);
        }
    }

    public void testMonthDay(){
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2017, 3, 7);

        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if(currentMonthDay.equals(birthday)){
            System.out.println("Many Many happy returns of the day !!");
        }else{
            System.out.println("Sorry, today is not your birthday");
        }
    }

    public void testLocalTime(){
        LocalTime time = LocalTime.now();
        System.out.println("local time now : " + time);

        LocalTime newTime = time.plusHours(2); // adding two hours
        System.out.println("Time after 2 hours : " + newTime);

        Date datanow = new Date();
        datanow.setYear(17);;
        System.out.println("====================="+datanow);
    }

    public void testNextWeek(){
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println("Today is : " + today);
        System.out.println("Date after 1 week : " + nextWeek);
    }

    public void testNextYear(){
        LocalDate today = LocalDate.now();
        LocalDate previousYear = today.minus(1, ChronoUnit.YEARS);
        System.out.println("Date before 1 year : " + previousYear);
        LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
        System.out.println("Date after 1 year : " + nextYear);
    }

    public void testClock(){
        // Returns the current time based on your system clock and set to UTC.
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);
                Clock.systemDefaultZone();
        System.out.println("Clock : " + clock);
    }

    public void testAfterAndBefore(){
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.of(2014, 1, 15);
        if(tomorrow.isAfter(today)){
            System.out.println("Tomorrow comes after today");
        }
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if(yesterday.isBefore(today)){
            System.out.println("Yesterday is day before today");
        }
    }


    public void testLocalDateTime(){
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, ZoneId.of("America/Los_Angeles"));
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
    }

    public void testYearMonth(){
        YearMonth currentYearMonth = YearMonth.now();
        System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
        YearMonth creditCardExpiry = YearMonth.of(2018, Month.FEBRUARY);
        System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
    }

    /**
     * 判断是否是闰年
     */
    public void testLeapYear(){
        LocalDate today = LocalDate.now();
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("2017 is not a Leap year");
        }
    }

    /**
     * 时间距离
     */
    public void testPeriod(){
        LocalDate today = LocalDate.now();

        LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
        Period periodToNextJavaRelease =
                Period.between(java8Release, today);
        System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getYears() );
    }

    public void testZoneOffset(){
        LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
        ZoneOffset offset = ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(datetime, offset);
        System.out.println("Date and Time with timezone offset in Java : " + date);
    }

    public void testInstant(){
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
    }

    public void testFormate(){
        String dayAfterTommorrow = "20140116";
        LocalDate formatted = LocalDate.parse(dayAfterTommorrow,
                DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
    }

    public void testParse(){
        String goodFriday = "12 18 2014";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }
    }

    public void testformat(){
        LocalDateTime arrivalDate = LocalDateTime.now();
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MM dd yyyy hh:mm a");
            String landing = arrivalDate.format(format);
            System.out.printf("Arriving at : %s %n", landing);
        } catch (DateTimeException ex) {
            System.out.printf("%s can't be formatted!%n", arrivalDate);
            ex.printStackTrace();
        }
    }

    public void testZooId(){
        ZoneId zoneId = ZoneId.systemDefault();

        System.out.printf(""+zoneId);
    }

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        Instant timestamp2 = Instant.now(clock);
        OffsetDateTime ddd = Instant.now().atOffset(ZoneOffset.ofHours(8));
        System.out.println("What is value of this instant " + timestamp2);

        System.out.println("What is value of this instant " + ddd);
    }
}
