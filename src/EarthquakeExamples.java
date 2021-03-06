import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
    Earthquake1 E1 = new Earthquake1();
    LinkedList<Double> noData = new LinkedList<Double>();
    LinkedList<Double> threeDates = new LinkedList<Double>();
    LinkedList<Double> fourDates = new LinkedList<Double>();
    LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();
    LinkedList<MaxHzReport> Nov2Reports = new LinkedList<MaxHzReport>();

    public EarthquakeExamples() {
        threeDates.add(20151013.0);
        threeDates.add(10.0);
        threeDates.add(5.0);
        threeDates.add(20151020.0);
        threeDates.add(40.0);
        threeDates.add(50.0);
        threeDates.add(45.0);
        threeDates.add(20151101.0);
        threeDates.add(6.0);
        NovReports.add(new MaxHzReport(20151101.0,6.0));
        fourDates.add(20151101.0);
        fourDates.add(6.0);
        fourDates.add(20151013.0);
        fourDates.add(10.0);
        fourDates.add(5.0);
        fourDates.add(20151020.0);
        fourDates.add(40.0);
        fourDates.add(50.0);
        fourDates.add(45.0);
        fourDates.add(20151103.0);
        fourDates.add(2.0);
        fourDates.add(2.9);
        fourDates.add(0.1);
        Nov2Reports.add(new MaxHzReport(20151101.0, 6.0));
        Nov2Reports.add(new MaxHzReport(20151103.0, 2.9));

    }

    @Test
    public void instructorTestEQ() {
        assertEquals(NovReports,
                E1.dailyMaxForMonth(threeDates, 11));
    }

    @Test
    public void studentTestEQ() {
        assertEquals(Nov2Reports,
                E1.dailyMaxForMonth(fourDates, 11));
    }


}
/*Subtasks
-Identify 8-digit numbers (dates)
-Determine if the dates are in the correct month
-cycle through data until next date for highest reading
-Create a Report with the date and readings
 */