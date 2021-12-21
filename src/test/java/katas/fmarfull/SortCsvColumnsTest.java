package katas.fmarfull;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class SortCsvColumnsTest {
    @Test
    public void basicTests() {
        String preSorting = "myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n"
                + "17945;10091;10088;3907;10132\n"
                + "2;12;13;48;11";
        String postSorting = "Dentzil;myjinxin2015;raulbc777;smile67;SteffenVogel_79\n"
                + "3907;17945;10091;10088;10132\n"
                + "48;2;12;13;11";
        assertEquals(postSorting, SortCsvColumns.sortCsvColumns(preSorting));

        preSorting = "IronMan;Thor;Captain America;Hulk\n"
                + "arrogant;divine;honorably;angry\n"
                + "armor;hammer;shield;greenhorn\n"
                + "Tony;Thor;Steven;Bruce";
        postSorting = "Captain America;Hulk;IronMan;Thor\n"
                + "honorably;angry;arrogant;divine\n"
                + "shield;greenhorn;armor;hammer\n"
                + "Steven;Bruce;Tony;Thor";
        assertEquals(postSorting, SortCsvColumns.sortCsvColumns(preSorting));
    }
}