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
        double dayStored = 0;
        double monthStored = 0;
        double yearStored = 0;
        double biggestRead = 0;
        double dateStored = 0;
        boolean dataMatters = false;
        int i = 0;
        for(i = 0; i < data.size(); ++i) {
            double currData = data.get(i);
            if (currData > 500) {
                if(yearStored > 0 && dataMatters == true) { //skips first cycle
                    dateStored = (yearStored * 10000) + (monthStored * 100) + (dayStored);
                    returnlist.add(new MaxHzReport(dateStored, biggestRead));
                }

                biggestRead = 0; //reset biggest read for new date;

                double copyData = currData;
                yearStored = Math.floor(copyData / 10000);
                monthStored = Math.floor((currData - (yearStored * 10000)) / 100);
                dayStored = Math.floor((currData - (yearStored * 10000) - (monthStored * 100)));


                if(monthStored == 11){
                    dataMatters = true;
                } else { dataMatters = false; }
            }
            if(dataMatters && currData <= 500){
                if(currData > biggestRead){
                    biggestRead = currData;
                }
            }
        }
        if(yearStored > 0 && dataMatters == true) { //skips first cycle
            dateStored = (yearStored * 10000) + (monthStored * 100) + (dayStored);
            returnlist.add(new MaxHzReport(dateStored, biggestRead));
        }
        return returnlist;
    }
}

