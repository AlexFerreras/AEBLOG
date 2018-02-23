
package Pojos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author alexf
 */
public class Comment {
    private int id;
    private int articles_id;
    private int user_Id;
    private String content;
    Date date= new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String creation_date; 

    public Comment() {
        this.creation_date= dateFormat.format(date);
    }

    public Comment(int id, int postId, int userId, String content) {
        this.id = id;
        this.articles_id = postId;
        this.user_Id = userId;
        this.content = content;
        this.creation_date = this.creation_date= dateFormat.format(date);
    }

    public Comment(int id, int postId, int userId, String content, String creation_date) {
        this.id = id;
        this.articles_id = postId;
        this.user_Id = userId;
        this.content = content;
        this.creation_date = creation_date;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return articles_id;
    }

    public void setPostId(int postId) {
        this.articles_id = postId;
    }

    public int getUserId() {
        return user_Id;
    }

    public void setUserId(int userId) {
        this.user_Id = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFecha() {
        return creation_date;
    }
    
    
    
}
