package com.hl.demo.localdate;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Hailin
 * @date 2020/3/19
 */
public class TimeTest {

    @Test
    public void localDateTest() {
        // 1、获取当前年月日
        LocalDate localDate = LocalDate.now();
        System.out.println("1、获取当前年月日：" + localDate.toString());

        // 2、构造指定的年月日
        LocalDate localDate2 = LocalDate.of(2019, 9, 10);
        System.out.println("2、构造指定的年月日：" + localDate2.toString());

        int year = localDate.getYear();
        System.out.println(year);
        int year1 = localDate.get(ChronoField.YEAR);
        System.out.println(year1);
        Month month = localDate.getMonth();
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        int day = localDate.getDayOfMonth();
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);

        // 获取当年第一天
        LocalDate firstDayOfYear = localDate.with(TemporalAdjusters.firstDayOfYear());

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime first = now.with(TemporalAdjusters.firstDayOfYear());
        LocalDateTime last = now.with(TemporalAdjusters.lastDayOfYear());
        LocalDateTime start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.out.println("first: " + start.toString());
        System.out.println("last: " + end.toString());
    }

    public void localTimeTest() {
        LocalTime localTime = LocalTime.of(13, 51, 10);
        LocalTime localTime1 = LocalTime.now();

        //获取小时
        int hour = localTime.getHour();
        int hour1 = localTime.get(ChronoField.HOUR_OF_DAY);
        //获取分
        int minute = localTime.getMinute();
        int minute1 = localTime.get(ChronoField.MINUTE_OF_HOUR);
        //获取秒
        int second = localTime.getSecond();
        int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE);
    }

    public void localDateTimeTest() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime3 = localDate.atTime(localTime);
        LocalDateTime localDateTime4 = localTime.atDate(localDate);

        // 获取LocalDate
        LocalDate localDate2 = localDateTime.toLocalDate();
        // 获取LocalTime
        LocalTime localTime2 = localDateTime.toLocalTime();

        LocalDateTime localDateTime6 = LocalDateTime.of(2019, Month.SEPTEMBER, 10,
                14, 46, 56);
        //增加一年
        localDateTime6 = localDateTime.plusYears(1);
        localDateTime6 = localDateTime.plus(1, ChronoUnit.YEARS);
        //减少一个月
        localDateTime6 = localDateTime.minusMonths(1);
        localDateTime6 = localDateTime.minus(1, ChronoUnit.MONTHS);
        //修改年为2019
        localDateTime6 = localDateTime.withYear(2020);
        //修改为2022
        localDateTime6 = localDateTime.with(ChronoField.YEAR, 2022);
        // 还可以修改月、日
    }

    @Test
    public void instantTest() {
        // 创建Instant对象
        Instant instant = Instant.now();
        // 获取秒数
        long currentSecond = instant.getEpochSecond();
        // 获取毫秒数
        long currentMilli = instant.toEpochMilli();
        long currentTimeMillis = System.currentTimeMillis();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(),
                0, 0);
        LocalDateTime end = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(),
                59, 59);
        System.out.println(start);
        System.out.println(end);
    }


}
