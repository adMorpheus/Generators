import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateGenerator {
    private static final Date MIN_DATE = new Date(Long.MIN_VALUE);
    private static final Date MAX_DATE = new Date(Long.MAX_VALUE);
    private static final int MIN_YEAR = -292269055;
    private static final int MAX_YEAR = 292278994;


    public static void main(String[] args) throws InterruptedException, DateOutOfRangeExetion {
//        Date start = new Date();
//        Thread.sleep(10000);
//        Date stop = new Date();

        SimpleDateFormat formater = new SimpleDateFormat("yyyy:MM:dd - G");
        for (int i = 0; i < 100; i++) {
            System.out.println(formater.format(newDateInPast()));
        }


    }

    public static Date newDate(Date from, Date to) throws DateOutOfRangeExetion {
if (from.after(to)) throw new DateOutOfRangeExetion("Wrong values: Correct then from<to");
        long range = to.getTime() - from.getTime();
        return new Date(from.getTime() + (long) (Math.random() * range + 1));
    }

    public static Date newDate(int startYear, int endYear) throws ParseException, DateOutOfRangeExetion {
        Date from = new SimpleDateFormat("yyyy").parse(String.valueOf(startYear));
        Date to = new SimpleDateFormat("yyyy").parse(String.valueOf(endYear));
        return newDate(from, to);
    }

    private static Date  newDateInPast(int year) throws DateOutOfRangeExetion {
        Calendar startDate = Calendar.getInstance();
        int dateRange = startDate.get(Calendar.YEAR) - MIN_YEAR;
        if (year>dateRange) throw new DateOutOfRangeExetion("Value is so small");
        startDate.add(Calendar.YEAR, -1 * year);
        Date from = (startDate.getTime());
        Date to = new Date();
        return newDate(from, to);
    }


    public static Date newDateInPast() throws DateOutOfRangeExetion {

        return  newDateInPast(getCurrenYear()-MIN_YEAR);
    }


    static class DateOutOfRangeExetion extends Exception {
        public DateOutOfRangeExetion() {
            super();
        }

        public DateOutOfRangeExetion(String message) {
            super(message);
        }
    }
    private static int getCurrenYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
}


