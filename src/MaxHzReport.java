import java.util.LinkedList;

class MaxHzReport {
    double date;
    double maxReading;

    MaxHzReport(double date, double maxread) {
        this.date = date;
        this.maxReading = maxread;
    }

    // the equals method for use in testing

    /**
     * Compares an object with the given one to make sure
     * the two reports are equals
     *
     * @param Object other, typically a MaxHzReport
     * @return boolean indicating if the reports are equal
     */
    public boolean equals(Object other) {
        if (!(other instanceof MaxHzReport)) {
            return false;
        }

        MaxHzReport otherR = (MaxHzReport) other;

        return otherR.date == this.date &&
                otherR.maxReading == this.maxReading;
    }

    // the toString method so that reports display when tests fail
    public String toString() {
        return "Report[" + date + ", " + maxReading + "]";
    }



}