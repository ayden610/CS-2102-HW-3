import java.util.LinkedList;

class Earthquake1 {
    Earthquake1(){}

    // checks whether a datum is a date
    boolean isDate(double anum) { return (int)anum > 10000000; }
    // extracts the month from an 8-digit date
    int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }

    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                    int month) {

        LinkedList<MaxHzReport> returnlist = new LinkedList<>();
        for(Double value : data) {
            if (value / 1000 >= 1) { //checks if the value is over 1000
                //it is assumed that only dates are more than 1000 as readings go to 500
                Double valuecopy = new Double(value);
                int valueint = valuecopy.intValue();
                String value_str = Integer.toString(valueint);
                int newvalue = Integer.parseInt(value_str.substring(4));
                //takes a date and gets rid of the year
                int Dday = Integer.parseInt(value_str.substring(6));
                //parses to the 7th digit on (day in the date)
                int Dmonth = (newvalue - Dday) / 100;
                if(Dmonth == month){
                    //write day, search through data
                } //else skip this step
            }
        }
        return null;
    }
}

