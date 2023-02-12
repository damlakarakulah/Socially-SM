package com.app4a.sm.db;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String Name;
    private String username;
    private String ProfilePicture;
    private List<Post> Posts;
    private boolean Following;
    private boolean Follower;

    public String getName() {
        return Name;
    }

    public String getUsername() {
        return username;
    }

    public String getProfilePicture() {
        return ProfilePicture;
    }

    public boolean getFollowing() {
        return Following;
    }

    public boolean getFollower() {
        return Follower;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProfilePicture(String ProfilePicture) {
        this.ProfilePicture = ProfilePicture;
    }

    public void setFollowing(boolean Following) {
        this.Following = Following;
    }

    public void setFollower(boolean Follower) {
        this.Follower = Follower;
    }

    public void setPosts(List<Post> posts) {
        Posts = posts;
    }

    public List<Post> getPosts() {
        return Posts;
    }
}
