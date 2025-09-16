public class Singer {

    private int id;
    private String sName;
    private String sAddress;
    private String dateOfBirth;
    private int numberOfAlbums;

    //constructor no argument
    public Singer() {
        this.id = 0;
        this.sName = "default";
        this.sAddress = "default";
        this.dateOfBirth = "default";
        this.numberOfAlbums = 0;
    }

    //constructor with arguments
    public Singer(int id, String sName, String sAddress, String dateOfBirth, int numberOfAlbums) {
        this.id = id;
        this.sName = sName;
        this.sAddress = sAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;
    }

    //setters
    public void setId(int id) {this.id = id;}
    public void setName(String sName) {this.sName = sName;}
    public void setAddress(String sAddress) {this.sAddress = sAddress;}
    public void setDateOfBirth(String dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public void setNumberOfAlbums(int numberOfAlbums) {this.numberOfAlbums = numberOfAlbums;}

    //getters
    public int getId() {return id; }
    public String getName() {return sName;}
    public String getAddress() {return sAddress;}
    public String getDateOfBirth() {return dateOfBirth;}
    public int getNumberOfAlbums() {return numberOfAlbums;}

    //setter for all values at once
    public void setAllDetails(int id, String sName, String sAddress, String dateOfBirth, int numberOfAlbums) {
        this.id = id;
        this.sName = sName;
        this.sAddress = sAddress;
        this.dateOfBirth = dateOfBirth;
        this.numberOfAlbums = numberOfAlbums;
    }
}

