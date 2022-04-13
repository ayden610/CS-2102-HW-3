import java.util.LinkedList;

class Earthquake2 {
    Earthquake2(){}

    // checks whether a datum is a date
    boolean isDate(double anum) { return (int)anum > 10000000; }
    // extracts the month from an 8-digit date
    int extractMonth(double dateNum) { return ((int)dateNum % 10000) / 100; }


    /**
     * Cycles through all the readings, finding the highest reading for each date,
     * and makes a report of each day in a month
     *
     * @param LinkedList<data> a list of dates and readings
     * @param month in question
     * @return LinkedList of Reports with the max
     * reading for each day in the month
     */
    public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                    int month) {
        int i = 0;
        int state = 0;
        double date = 0;
        boolean rightMonth = false;
        double maxRead = 0;
        boolean RepeatLap = false;
        LinkedList<MaxHzReport> returnReport = new LinkedList<>();

        for(i = 0; i < data.size(); ++i){
            if(data.get(i) > 500){
                state = 1;
            }
            if(0 <= data.get(i) && data.get(i) <= 500){
                state = 2;
            }
            switch(state){
                case(1):
                {
                    if(RepeatLap){
                        returnReport.add(new MaxHzReport(date, maxRead));
                    }
                    maxRead = 0;
                    int yearmonth = (int) (data.get(i) / 100);
                    int year = (int) (data.get(i) / 10000);
                    if(yearmonth == (month + (year * 100))){
                        rightMonth = true;
                        date = data.get(i);
                    }else{
                        rightMonth = false;
                    }
                    break;
                }
                case(2):
                {
                    double thisData = data.get(i);
                    if(thisData > maxRead && rightMonth){
                        maxRead = thisData;
                    }
                    break;
                }

            }
        }
        returnReport.add(new MaxHzReport(date, maxRead));
        return returnReport;
    }
}