import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * this class is used to play music from the file path
 * u can pause and resume it
 * @author Alireza Nejadipour
 * @version 3 (3/25/2021)
 */
public class Player
{
    // to store current position
    long currentFrame;
    Clip clip;
    private final String playerMenu;
    private final Scanner scanner;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;

    /**
     * create a new player with given parameters
     * @param filePath the music path
     */
    public Player(String filePath)
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        playerMenu =
                """
                        1.pause
                        2.resume
                        3.stop
                        """;

        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);

        scanner = new Scanner(System.in).useDelimiter("\n");

    }


    /**
     * starts playing music from the file path
     * @param filePath the address of the music
     * @return if the file is opened successfully returns true
     */
    public static boolean startPlay(String filePath)
    {
        try
        {
            Player audioPlayer = new Player(filePath);

            audioPlayer.play();

            while (true)
            {
                audioPlayer.printPlayerMenu();

                if (audioPlayer.userChoice())
                {
                    return true;
                }

            }

        }

        catch (Exception ex)
        {
            return false;

        }

    }


    /**
     * while playing music options are placed by this method
     */
    private void printPlayerMenu()
    {
        System.out.println(playerMenu);

    }


    /**
     * user's choice is scanned in this method
     * the method calls related methods based on user's choice
     * @return if the request is stop it returns true
     */
    private boolean userChoice()
            throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
        int choice;
        System.out.print("Your choice : ");
        choice = scanner.nextInt();

        switch (choice)
        {
            case 1 -> pause();
            case 2 -> resumeAudio();
            case 3 ->
                    {
                        pause();
                        return true; //means music is finished
                    }
            default ->
                    {
                        System.out.println("Invalid input.");
                        userChoice();

                    }

        }

        return false;

    }


    /**
     * method to play music
     */
    public void play()
    {
        //start the clip
        clip.start();

        status = "play";
    }


    /**
     * method to pause the music
     */
    public void pause()
    {
        if (status.equals("paused"))
        {
            System.out.println("audio is already paused");
            return;
        }

        this.currentFrame = clip.getMicrosecondPosition();
        this.clip.setMicrosecondPosition(clip.getMicrosecondPosition());

        clip.stop();
        status = "paused";

    }


    /**
     * method to resume the music
     */
    public void resumeAudio()
    {
        if (status.equals("play"))
        {
            System.out.println("Audio is already being played");
            return;

        }

        this.play();

    }

}