package com.app4a.sm.db;

public class Post {
    private String ImageUrl;
    private String Likes;
    private String Comments;
    private String Saves;
    private String Date;
    private boolean isSaved;
    private User user;


    // Getter Methods

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getLikes() {
        return Likes;
    }

    public String getComments() {
        return Comments;
    }

    public String getSaves() {
        return Saves;
    }

    public String getDate() {
        return Date;
    }

    public boolean setSaved() {
        return isSaved;
    }

    // Setter Methods

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public void setLikes(String Likes) {
        this.Likes = Likes;
    }

    public void setComments(String Comments) {
        this.Comments = Comments;
    }

    public void setSaves(String Saves) {
        this.Saves = Saves;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void isSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
