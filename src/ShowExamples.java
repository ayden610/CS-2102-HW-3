import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ShowExamples {
    ShowManager1 sm1 = new ShowManager1();
    ShowManager2 sm2 = new ShowManager2();
    LinkedList<Show> shows = new LinkedList<Show>();
    ShowSummary report1 = new ShowSummary();

    Show startrek = new Show("Star Trek", 1800, 45.0, false);
    Show futurama = new Show("Futurama", 1900, 23.0, false);
    Show animaniacs = new Show("Animaniacs", 1630, 7.0, false);
    Show sesamestreet = new Show("Sesame Street", 900, 60.0, false);

    public ShowExamples() {
        shows.add(startrek);
        report1.primetime.add(startrek);

        shows.add(futurama);
        report1.primetime.add(futurama);

        shows.add(animaniacs);
        report1.daytime.add(animaniacs);

        shows.add(sesamestreet);
        report1.daytime.add(sesamestreet);
    }

    @Test
    public void instructorTestShowSummary_EmptyReport() {
        ShowSummary report2 = new ShowSummary();
        assertFalse(report1.equals(report2));
    }


    @Test
    public void instructorTestShowSummary_WrongOrder() {
        ShowSummary report2 = new ShowSummary();

        report2.primetime.add(futurama);
        report2.primetime.add(startrek);
        report2.daytime.add(animaniacs);
        report2.daytime.add(sesamestreet);

        assertFalse(report1.equals(report2));
    }

    @Test
    public void instructorTestShowSummary_DifferentInstances() {
        ShowSummary report2 = new ShowSummary();

        Show startrek2 = new Show("Star Trek", 1800, 60.0, true);
        Show futurama2 = new Show("Futurama", 1900, 20.0, false);
        Show animaniacs2 = new Show("Animaniacs", 1630, 9.0, true);
        Show sesamestreet2 = new Show("Sesame Street", 900, 55.0, false);

        report2.primetime.add(startrek2);
        report2.primetime.add(futurama2);
        report2.daytime.add(animaniacs2);
        report2.daytime.add(sesamestreet2);

        assertTrue(report1.equals(report2));
    }

    @Test
    public void instructorTestShowSummary_DifferentInstances2() {
        ShowSummary report3 = new ShowSummary();

        Show startrek3 = new Show("Star Trek", 1700, 60.0, true);
        Show futurama3 = new Show("Futurama", 1900, 20.0, false);
        Show animaniacs3 = new Show("Animaniacs", 1630, 9.0, true);
        Show sesamestreet3 = new Show("Sesame Street", 900, 55.0, false);

        report3.primetime.add(startrek3);
        report3.primetime.add(futurama3);
        report3.daytime.add(animaniacs3);
        report3.daytime.add(sesamestreet3);

        assertFalse(report1.equals(report3));
    }

    @Test
    public void instructorTestShowSummary_DifferentInstances3() {
        ShowSummary report4 = new ShowSummary();

        Show startrek4 = new Show("StarTrek", 1700, 60.0, true);
        Show futurama4 = new Show("Futurama", 1900, 20.0, false);
        Show animaniacs4 = new Show("Animaniacs", 1630, 9.0, true);
        Show sesamestreet4 = new Show("Sesame Street", 900, 55.0, false);

        report4.primetime.add(startrek4);
        report4.primetime.add(futurama4);
        report4.daytime.add(animaniacs4);
        report4.daytime.add(sesamestreet4);

        assertFalse(report1.equals(report4));
    }

    @Test
    public void instructorTestShowSummary_DifferentInstances4() {
        ShowSummary report5 = new ShowSummary();

        Show futurama5 = new Show("Futurama", 1900, 20.0, false);
        Show animaniacs5 = new Show("Animaniacs", 1630, 9.0, true);
        Show startrek5 = new Show("Star Trek", 1800, 60.0, true);
        Show sesamestreet5 = new Show("Sesame Street", 900, 55.0, false);


        report5.primetime.add(futurama5);
        report5.daytime.add(animaniacs5);
        report5.primetime.add(startrek5);
        report5.daytime.add(sesamestreet5);

        assertFalse(report1.equals(report5));
    }

    @Test
    public void instructorTestShowSummary_SameInstances() {
        ShowSummary report2 = report1;
        assertTrue(report1.equals(report2));
    }


    @Test
    public void instructorTestOrganizeShows() {
        ShowSummary report2 = sm1.organizeShows(shows);
        assertEquals(report1, report2);
    }

    @Test
    public void instructorTestOrganizeShows2() {
        ShowSummary report2 = sm2.organizeShows(shows);
        assertEquals(report1, report2);
    }


}

/*
Subtasks Show Manager 1
Create LinkedList NotSpecial,
make new ShowSummary returnSummary,
Putting shows that are not special in NotSpecial,
Organizing by broadcast time,
Returning ShowSummary,
 */
/*
Subtasks Show Manager 2
Create LinkedList's daytime primetime and latenight,
Checking if shows are special,
Organizing not special shows into Linkedlist's
daytime primetime and latenight,
Creating new ShowSummary returnSummary2,
putting daytime primetime and latenight into new
ShowSummary,
Returning ShowSummary2
 */