package Pojos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
     private int id;
     private int userId;
     private String topic;
     private String content;
     Date date= new Date();
     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
     private String fecha; 

    public Post() {
        this.fecha= dateFormat.format(date);
    }

    public Post(int id, int userId, String topic, String content) {
        this.id = id;
        this.userId = userId;
        this.topic = topic;
        this.content = content;
        this.fecha = dateFormat.format(date);
    }

    public Post(int id, int userId, String topic, String content, String fecha) {
        this.id = id;
        this.userId = userId;
        this.topic = topic;
        this.content = content;
        this.fecha = fecha;
    }

    

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
 
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    } 
}
 