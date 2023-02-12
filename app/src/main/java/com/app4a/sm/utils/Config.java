package com.app4a.sm.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

import com.app4a.sm.MainActivity;
import com.app4a.sm.db.Post;
import com.app4a.sm.db.User;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Config {
    public static Gson gson = new Gson();
    public static SPreferences sPreferences;


    public static final SPreferences getSPreferences(Context context){
        if(sPreferences == null){
            sPreferences = new SPreferences(context);
        }
        return sPreferences;
    }

    public static String readFile(Context context, String pathname){
        String result = "";
        try {
            InputStream inputStream = context.getAssets().open(pathname);
            Scanner s = new Scanner(inputStream).useDelimiter("\\A");
            result = s.hasNext() ? s.next() : "";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T> List<T> getObjectList(Context context, String filepath, Class<T[]> classOfT){
        return Arrays.asList(gson.fromJson(Config.readFile(context,filepath), classOfT));
    }

    public static <T> ArrayList<T> getObjectList(String strObject, Class<T[]> classOfT){
        ArrayList<T> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(gson.fromJson(strObject, classOfT)));
        return arrayList;
    }

    public static <T> T getObject(Context context, String filepath, Class<T> classOfT) {
        return gson.fromJson(Config.readFile(context,filepath),classOfT);
    }

    public static User getMainUser(Context context){
        String newsStr = Config.getSPreferences(context).getUsers();
        return getObjectList(newsStr, User[].class).get(0);
    }

    public static List<User> getUsers(Context context){
        String newsStr = getSPreferences(context).getUsers();
        return getObjectList(newsStr, User[].class);
    }

    public static Drawable imageSrcToDrawable(Context context, String imageSrc){
        byte[] decodedString = Base64.decode(imageSrc, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return new BitmapDrawable(context.getResources(), decodedByte);

    }

    public static int getFollowings(Context context){
        List<User> users = getUsers(context);
        int count = 0;
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getFollowing()){
                count++;
            }
        }
        return count;
    }

    public static int getFollowers(Context context){
        List<User> users = getUsers(context);
        int count = 0;
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getFollower()){
                count++;
            }
        }
        return count;
    }

    public static List<Post> getAllPosts(Context context){
        List<User> users = getUsers(context);
        List<Post> posts = new ArrayList<>();

        for(int i=0; i<users.size(); i++){
            User user = users.get(i);
            for(int j=0; j<user.getPosts().size(); j++){
                Post post = user.getPosts().get(j);
                post.setUser(user);
                posts.add(post);
            }
        }
        return posts;
    }

}
