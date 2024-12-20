package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.String.valueOf;
import static org.testng.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        final Job job1 = new Job();
        final Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId(), "Jobs are not equal.");
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        final Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence") );


        assertTrue(job3 instanceof Job);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(valueOf(job3.getName()), "Product tester", "name.value generator test.");
        assertEquals(valueOf(job3.getEmployer()),"ACME","Employer.value generator test.");
        assertEquals(valueOf(job3.getLocation()), "Desert", "Location.value generator test.");
        assertEquals(valueOf(job3.getPositionType()), "Quality control", "PositionType.value generator test.");
        assertEquals(valueOf(job3.getCoreCompetency()), "Persistence", "CoreCompetency.value generator test.");
    }

    @Test
    public void testJobsForEquality() {
        final Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence") );
        final Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence") );
        assertFalse(job5.equals(job4));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String msg1 = "Blank new line precede return.";
        String msg2 = "Blank new line concludes return.";

        String n = System.lineSeparator();
        Job job6 = new Job();
        int finalIndex = job6.toString().length() - 1;

        String expected = n;
        String actual = valueOf(job6.toString().charAt(0));
        String actualLast = valueOf(job6.toString().charAt(finalIndex));

        assertEquals(expected, actual, msg1);
        assertEquals(expected, actualLast, msg2);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String msg = "Returns label and data.";
        final Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence") );

        String expected = "\n" +
                "ID: " + job7.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" +
                "\n";
        String actual = job7.toString();
        assertEquals(expected,actual,msg);
    }


    @Test
    public void testToStringHandlesEmptyField() {
        String msg = "Prints 'Data not available' when null";

        final Job job8 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence") );
        String expected = "\n" +
                "ID: " + job8.getId() + "\n" +
                "Name: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" +
                "\n";
        String actual = job8.toString();
        assertEquals(expected,actual,msg);

    }

}
