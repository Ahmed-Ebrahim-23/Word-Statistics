package WordStatistics;

import java.net.*;

public class File {
    // atributes
    private String name;
    private URL location;
    private int num_of_words;
    private int num_of_is;
    private int num_of_are;
    private int num_of_you;
    private String longest;
    private String shortest;

    // Constractors
    public File(String name,URL location){
        this.name = name;
        this.location = location;
    }

    // Setters & Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getLocation() {
        return location;
    }

    public void setLocation(URL location) {
        this.location = location;
    }

    public int getNum_of_words() {
        return num_of_words;
    }

    public void setNum_of_words(int num_of_words) {
        this.num_of_words = num_of_words;
    }

    public int getNum_of_is() {
        return num_of_is;
    }

    public void setNum_of_is(int num_of_is) {
        this.num_of_is = num_of_is;
    }

    public int getNum_of_are() {
        return num_of_are;
    }

    public void setNum_of_are(int num_of_are) {
        this.num_of_are = num_of_are;
    }

    public int getNum_of_you() {
        return num_of_you;
    }

    public void setNum_of_you(int num_of_you) {
        this.num_of_you = num_of_you;
    }

    public String getLongest() {
        return longest;
    }

    public void setLongest(String longest) {
        this.longest = longest;
    }

    public String getShortest() {
        return shortest;
    }

    public void setShortest(String shortest) {
        this.shortest = shortest;
    }
    
    // getfiles function
    // input (URL location -> the location of the dirctory , boolean IncludeSubdirctories -> 0: false 1: true)
    // output (array of File with location and name)
    public File[] getfiles(URL location , boolean IncludeSubdirctories){
        return null;
    }
    
}
