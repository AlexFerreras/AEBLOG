
package Pojos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubComment {
    private int id;
    private int userId;
    private int commentId;
    private String content;
    Date date= new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String fecha; 

    public SubComment() {
        this.fecha= dateFormat.format(date);
    }

    public SubComment(int id, int userId, int comentId, String content, String fecha) {
        this.id = id;
        this.userId = userId;
        this.commentId = comentId;
        this.content = content;
        this.fecha= dateFormat.format(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getComentId() {
        return commentId;
    }

    public void setComentId(int comentId) {
        this.commentId = comentId;
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
