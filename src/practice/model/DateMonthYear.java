package practice.model;

public class DateMonthYear {

    String date;
    String month;
    String year;

    public DateMonthYear(String date, String month, String year) {
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public DateMonthYear setDate(String date) {
        this.date = date;
        return this;
    }

    public String getMonth() {
        return month;
    }

    public DateMonthYear setMonth(String month) {
        this.month = month;
        return this;
    }

    public String getYear() {
        return year;
    }

    public DateMonthYear setYear(String year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        return "DateMonthYear{" +
                "date='" + date + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
