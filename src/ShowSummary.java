import java.util.LinkedList;

class ShowSummary {

    LinkedList<Show> daytime;
    LinkedList<Show> primetime;
    LinkedList<Show> latenight;

    ShowSummary() {
        this.daytime = new LinkedList<Show>();
        this.primetime = new LinkedList<Show>();
        this.latenight = new LinkedList<Show>();
    }

    ShowSummary(LinkedList<Show> daytime, LinkedList<Show> primetime, LinkedList<Show> latenight) {
        this.daytime = daytime;
        this.primetime = primetime;
        this.latenight = latenight;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ShowSummary) {
            return this.equals((ShowSummary) obj);
        }
        return false;
    }

    /**
     * A method which checks to make sure a given report is not empty
     * and make a new ShowSummary reportPrime
     *
     *
     * @param report ShowSummary of shows given to check
     */
    public boolean equals(ShowSummary report) {
        if (report == null) {
            return false;
        }
        ShowSummary reportPrime = (ShowSummary) report;
        return this.reportPrime(this.daytime, reportPrime.daytime) &&
                this.reportPrime(this.primetime, reportPrime.primetime) &&
                this.reportPrime(this.latenight, reportPrime.latenight);
    }

    /**
     * A method to check if two different reports have shows with same title
     * and same broadcast time
     *
     *
     * @param reportOne A list of shows and times
     * @param reportTwo A list of shows to compare to first report
     * @return A boolean on if reports are same
     */
    private boolean reportPrime(LinkedList<Show> reportOne, LinkedList<Show> reportTwo) {
        if (reportOne.size() != reportTwo.size()) {
            return false;
        }
        for (int i = 0; i < reportOne.size(); i++) {
            Show ShowOne = reportOne.get(i);
            Show ShowTwo = reportTwo.get(i);
            if (!ShowOne.title.equals(ShowTwo.title)) {
                return false;
            } else if (ShowOne.broadcastTime != ShowTwo.broadcastTime) {
                return false;
            }
        }
        return true;
    }
}
