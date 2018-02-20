
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
    private int postId;
    private int userId;
    private String content;
    Date date= new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String fecha; 

    public Comment() {
        this.fecha= dateFormat.format(date);
    }

    public Comment(int id, int postId, int userId, String content) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.fecha = this.fecha= dateFormat.format(date);
    }

    public Comment(int id, int postId, int userId, String content, String fecha) {
        this.id = id;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.fecha = fecha;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    
}
