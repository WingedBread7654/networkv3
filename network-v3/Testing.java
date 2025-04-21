import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class Testing.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Testing
{
    private String filename;  // the name of the image file
    private String caption;   // a one line image caption
    private String message;  // an arbitrarily long, multi-line message
    private String author; //author of post
    private MessagePost Message;
    private PhotoPost Photo;
    protected String username;  // username of the post's author
    protected long timestamp;
    protected int likes;
    protected ArrayList<String> comments;

    /**
     * Default constructor for test class Testing
     */
    public Testing()
    {

    }

    public void photoDisplay() //photo version
    {
        System.out.println(username);
        System.out.println(message);
        //System.out.println(username);
        System.out.print(timeString(timestamp));
        
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }

        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }
    public void messageDisplay() //message version
    {
        System.out.println(message);
        System.out.println(username);
        System.out.print(timeString(timestamp));
        
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        }
        else {
            System.out.println();
        }

        if(comments.isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }
    public void MessagePost(String author, String text)//message post version
    {
        this.author = text;
        message = author;
        messageDisplay();
    }
    public void PhotoPost(String author, String text) //photo post version
    {
        this.author = author;
        message = text;
        photoDisplay();
    }
    public void Post(String author) //post with author
    {
        username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }
    @Test
    public void testEverything() //tests everything
    {
        Post("Bob");
        MessagePost("Hello","Bob");
        Post("Larry");
        //MessagePost("Bob","Hello");
        PhotoPost("Larry", "I hate cheez-its");
        System.out.println("Success");
        
    }
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
    @BeforeEach
    public void like()
    {
        likes++;
    }
    @BeforeEach
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }
     public long getTimeStamp()
    {
        return timestamp;
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
