package calanderconverteroop;

import java.time.LocalDate;

public class EthiopianDate {

    private int year, month, day;

    private LocalDate localDate;

    public EthiopianDate(int year, int month, int day) throws Exception {
        localDate = DateConverter.ToGregorianDate(year, month, day);
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public LocalDate ToGregorianDate() {
        return localDate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}