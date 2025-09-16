//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Singer1 object - no argument constructor
        Singer singer1 = new Singer();

        System.out.println("Default values of singer1:");
        System.out.println("Singer ID: " + singer1.getId());
        System.out.println("Name: " + singer1.getName());
        System.out.println("Address: " + singer1.getAddress());
        System.out.println("Date of Birth: " + singer1.getDateOfBirth());
        System.out.println("Number of Albums: " + singer1.getNumberOfAlbums());
        System.out.println("-----------------------------");

        //set values using setAllDetails method
        singer1.setAllDetails(1, "Adele", "New York, US", "1988-05-05", 12);
        System.out.println("Values after using setAllDetails:");
        System.out.println("Singer ID: " + singer1.getId());
        System.out.println("Name: " + singer1.getName());
        System.out.println("Address: " + singer1.getAddress());
        System.out.println("Date of Birth: " + singer1.getDateOfBirth());
        System.out.println("Number of Albums: " + singer1.getNumberOfAlbums());
        System.out.println("-----------------------------");

        //change value individually using setters
        singer1.setId(2);
        singer1.setName("Ed Sheeran");
        singer1.setAddress("California, US");
        singer1.setDateOfBirth("1991-02-17");
        singer1.setNumberOfAlbums(8);

        System.out.println("Values after changing individually:");
        System.out.println("Singer ID: " + singer1.getId());
        System.out.println("Name: " + singer1.getName());
        System.out.println("Address: " + singer1.getAddress());
        System.out.println("Date of Birth: " + singer1.getDateOfBirth());
        System.out.println("Number of Albums: " + singer1.getNumberOfAlbums());
    }
}