package com.mdt.ocp.chapter5.DatesAndTimes;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Test {
    public static void main(String[] args) {
        //
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());
        System.out.println("===");
        //
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);

        Month month = Month.MAY;
//        boolean b1 = month == 4;
        boolean b2 = month == Month.APRIL;
        System.out.println(b2);
        System.out.println(Month.JANUARY);
        System.out.println("===");

        //
        LocalTime time1 = LocalTime.of(6, 15); // hour and minute
        LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
        LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds

        // create LocalDate and LocalTime
        //objects separately first and then combine them to create a LocalDateTime object
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
        LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);

        //
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime zoned1 = ZonedDateTime.of(2015, 1, 20,
            6, 15, 30, 200, zone);
        ZonedDateTime zoned2 = ZonedDateTime.of(date1, time1, zone);
        ZonedDateTime zoned3 = ZonedDateTime.of(dateTime1, zone);
        // finding timezones
        ZoneId.getAvailableZoneIds().stream()
            .filter(z -> z.contains("Asia") || z.contains("America"))
            .sorted().forEach(System.out::println);

        //
//        LocalDate d = new LocalDate(); // DOES NOT COMPILE

        // Manipulating Dates and Times
        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
        System.out.println(date);
        date = date.plusDays(2); // date is reassigned
        System.out.println(date);
        date = date.plusWeeks(1);
        System.out.println(date);
        date = date.plusMonths(1);
        System.out.println(date);
        date = date.plusYears(2);
        System.out.println(date);
        System.out.println("===");

        //
        LocalDate date3 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime localDateTime = LocalDateTime.of(date3, time);
        localDateTime = localDateTime.minusDays(2);
        localDateTime = localDateTime.minusHours(2);
        localDateTime = localDateTime.minusSeconds(2);

        LocalDateTime dateTime = LocalDateTime.of(date, time)
            .minusDays(1).minusHours(10).minusSeconds(30); // chained
        // tricky one, immutable type ignored
        LocalDate date4 = LocalDate.of(2020, Month.JANUARY, 20);
        date4.plusDays(10);
        System.out.println(date);

        // Period
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
        performAnimalEnrichment(start, end);

        Period period = Period.ofMonths(1);
        performAnimalEnrichment(start, end, period);

        //
        Period annually = Period.ofYears(1); // every 1 year
        Period quarterly = Period.ofMonths(3); // every 3 months
        Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
        Period everyOtherDay = Period.ofDays(2); // every 2 days
        Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days

        // chaining static method doesn't work and only last method is called.
        Period wrong = Period.ofYears(1).ofWeeks(1); // every week
        System.out.println(wrong);

        Period wrong2 = Period.ofYears(1);
        wrong2 = Period.ofWeeks(1);
        System.out.println(wrong2);

        //
        System.out.println(Period.ofMonths(3));
        System.out.println(Period.of(0, 20, 47));
        System.out.println(Period.ofWeeks(3)); // convert to days, because week is not in the format

        // The last thing to know about Period is what objects it can be used with.
        LocalDate date5 = LocalDate.of(2015, 1, 20);
        LocalTime time5 = LocalTime.of(6, 15);
        LocalDateTime dateTime5 = LocalDateTime.of(date5, time5);
        Period period2 = Period.ofMonths(1);
        System.out.println(date5.plus(period2)); // 2015–02–20
        System.out.println(dateTime5.plus(period2)); // 2015–02–20T06:15
//        System.out.println(time5.plus(period2)); // UnsupportedTemporalTypeException

        // Duration
        Duration daily = Duration.ofDays(1); // PT24H
        Duration hourly = Duration.ofHours(1); // PT1H
        Duration everyMinute = Duration.ofMinutes(1); // PT1M
        Duration everyTenSeconds = Duration.ofSeconds(10); // PT10S
        Duration everyMilli = Duration.ofMillis(1); // PT0.001S
        Duration everyNano = Duration.ofNanos(1); // PT0.000000001S

        //
        Duration daily2 = Duration.of(1, ChronoUnit.DAYS);
        Duration hourly2 = Duration.of(1, ChronoUnit.HOURS);
        Duration everyMinute2 = Duration.of(1, ChronoUnit.MINUTES);
        Duration everyTenSeconds2 = Duration.of(10, ChronoUnit.SECONDS);
        Duration everyMilli2 = Duration.of(1, ChronoUnit.MILLIS);
        Duration everyNano2 = Duration.of(1, ChronoUnit.NANOS);

        // ChronoUnit for Differences
        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        LocalDate date6 = LocalDate.of(2016, 1, 20);
        System.out.println(ChronoUnit.HOURS.between(one, two)); // 1
        System.out.println(ChronoUnit.MINUTES.between(one, two)); // 75
//        System.out.println(ChronoUnit.MINUTES.between(one, date6)); // DateTimeException
        //
        LocalDate date7 = LocalDate.of(2015, 1, 20);
        LocalTime time7 = LocalTime.of(6, 15);
        LocalDateTime dateTime7 = LocalDateTime.of(date7, time7);
        Duration duration = Duration.ofHours(6);
        System.out.println(dateTime7.plus(duration)); // 2015–01–20T12:15
        System.out.println(time7.plus(duration)); // 12:15
//        System.out.println(date7.plus(duration)); // UnsupportedTemporalException

        // Period and Duration are not equivalent
        LocalDate date8 = LocalDate.of(2015, 5, 25);
        Period period8 = Period.ofDays(1);
        Duration days = Duration.ofDays(1);
        System.out.println(date8.plus(period8)); // 2015–05–26
//        System.out.println(date8.plus(days)); // Unsupported unit: Seconds
        System.out.println("===");
        // Instant
        Instant now = Instant.now();
        // do something time consuming
        System.out.println(5 * 9877);
        Instant later = Instant.now();
        Duration duration2 = Duration.between(now, later);
        System.out.println(duration2.toMillis());
        System.out.println("===");
        //
        LocalDate date9 = LocalDate.of(2015, 5, 25);
        LocalTime time9 = LocalTime.of(11, 55, 00);
        ZoneId zone9 = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date9, time9, zone9);
        Instant instant = zonedDateTime.toInstant(); // 2015–05–25T15:55:00Z
        System.out.println(zonedDateTime); // 2015–05–25T11:55–04:00[US/Eastern]
        System.out.println(instant); // 2015–05–25T15:55:00Z
        System.out.println("===");
        //
        Instant instant2 = Instant.ofEpochSecond(1991111111);
        System.out.println(instant2); // 2015–05–25T15:55:00Z

        Instant nextDay = instant2.plus(1, ChronoUnit.DAYS);
        System.out.println(nextDay); // 2015–05–26T15:55:00Z
        Instant nextHour = instant2.plus(1, ChronoUnit.HOURS);
        System.out.println(nextHour); // 2015–05–25T16:55:00Z
//        Instant nextWeek = instant2.plus(1, ChronoUnit.WEEKS); // exception

        //

    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) { // check if still before end
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plusMonths(1); // add a month
        }
    }

    private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) {
        LocalDate upTo = start;
        while (upTo.isBefore(end)) { // check if still before end
            System.out.println("give new toy: " + upTo);
            upTo = upTo.plus(period); // adds the period
        }
    }
}

