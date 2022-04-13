import java.util.LinkedList;

class ShowManager1 {

    ShowManager1() {
    }

    /**
     * Organizes a list of shows based on its broadcast time and
     * special status
     *
     *
     * @param LinkedList<Show> List of shows to organize
     * @return ShowSummary An object with the organized list of shows
     */
    public ShowSummary organizeShows(LinkedList<Show> shows) {
        LinkedList<Show> notSpecial = new LinkedList<>();
        ShowSummary returnSummary = new ShowSummary();

        for (Show ShowOne : shows) {
            if (!ShowOne.isSpecial) {
                notSpecial.add(ShowOne);
            }
        }
        for (Show thisShow : notSpecial) {
            if (600 <= thisShow.broadcastTime && thisShow.broadcastTime < 1700) {
                returnSummary.daytime.add(thisShow);
            } else if (1700 <= thisShow.broadcastTime && thisShow.broadcastTime < 2200) {
                returnSummary.primetime.add(thisShow);
            } else if (2200 <= thisShow.broadcastTime || thisShow.broadcastTime < 100) {
                returnSummary.latenight.add(thisShow);
            }
        }
        return returnSummary;
    }

}
