package calanderconverteroop;

import java.time.LocalDate;

public class DateConverter {

    private static int JdOffset = 1723856;


    public static LocalDate ToGregorianDate(int year, int month, int day) throws Exception {

        validate(year, month, day);
        int jdn = fromEthiopianDateToGc(year, month, day);
        return toGregorianDate(jdn);
    }

    public static LocalDate ToGregorianDate(EthiopianDate localDate) throws Exception {
        int year = localDate.getYear();
        int month = localDate.getMonth();
        int day = localDate.getDay();
        validate(year, month, day);
        int jdn = fromEthiopianDateToGc(year, month, day);
        return toGregorianDate(jdn);
    }

    private static LocalDate toGregorianDate(int jdn)
    {
        int year, month, day;

        //Algorithm courtesy of Dr. Berhanu Beyene and Manfred Kudlek

        int r = jdn + 68569;
        int n = 4*r/146097;

        r = r - (146097*n + 3)/4;
        year = 4000*(r + 1)/1461001;
        r = r - 1461*year/4 + 31;
        month = 80*r/2447;
        day = r - 2447*month/80;
        r = month/11;
        month = month + 2 - 12*r;
        year = 100*(n - 49) + year + r;

        return LocalDate.of(year, month, day);
    }

    private static void validate(int year, int month, int day) throws Exception {
        if (month < 1 || month > 13 || (month == 13 && year % 4 == 3 && day > 6) || (month == 13 && year % 4 != 3 && day > 5) || day < 1 || day > 30)
        {
            throw new Exception("Year, Month, and Day parameters describe an un-representable EthiopianDateTime.");
        }
    }

    private static int fromEthiopianDateToGc(int year, int month, int day)
    {
        return (JdOffset + 365) + 365 * (year - 1) + year / 4 + 30 * month + day - 31;
    }
}