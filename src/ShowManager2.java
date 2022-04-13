import java.util.LinkedList;

class ShowManager2 {

    ShowManager2() {
    }

    LinkedList<Show> daytime = new LinkedList<Show>();
    LinkedList<Show> primetime = new LinkedList<Show>();
    LinkedList<Show> latenight = new LinkedList<Show>();

    /**
     * Organizes a list of shows based on its broadcast time and
     * special status
     *
     *
     * @param LinkedList<Show> List of shows to organize
     * @return ShowSummary An object with the organized list of shows
     */
    public ShowSummary organizeShows(LinkedList<Show> shows) {
        for (Show Show1 : shows) {
            if (!Show1.isSpecial) {
                if (600 <= Show1.broadcastTime && Show1.broadcastTime < 1700) {
                    daytime.add(Show1);
                } else if (1700 <= Show1.broadcastTime && Show1.broadcastTime < 2200) {
                    primetime.add(Show1);
                } else if (2200 <= Show1.broadcastTime || Show1.broadcastTime < 100) {
                    latenight.add(Show1);
                }
            }
        }
        ShowSummary returnSummary2 = new ShowSummary(daytime, primetime, latenight);
        return returnSummary2;
    }

}
