/**
 * A class to hold details of each music
 *
 * @author Alireza Nejadipour
 * @version 2 (3/26/2021)
 */

public class Music
{
    private final String name;
    private final String genre;
    private final String artist;
    private final String address;
    private final int year;

    /**
     * create a new music by given parameters
     * @param name the name of music
     * @param genre the genre of the new music
     * @param artist the name of the artist of the music
     * @param address the file path of where music is located
     * @param year the year when music was released
     */
    public Music(String name, String genre, String artist, String address, int year)
    {
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.address = address;
        this.year = year;

    }


    /**
     * prints the data of music
     * like name, artist, genre and year
     */
    public void print()
    {
        System.out.println(getName() + " | " + getArtist() + " | " + getGenre() + " | " + getYear() + "\n");

    }


    /**
     * gets the year when the music was released
     * @return the year field is returned
     */
    public int getYear()
    {
        return year;
    }

    /**
     * the address of where music is located is returned
     * @return the address field
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * gets the name of the artist of the music
     * @return the field artist is returned
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * gets the music's genre's name
     * @return the genre field is returned
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * gets the name of the music
     * @return the name field
     */
    public String getName()
    {
        return name;
    }

}