package controller;
import java.util.*;
import model.*;


public class Controller {
    public ArrayList<User> users= new ArrayList<User>(){
        {
            add(new User("user1", "Jamal", "password1", "bio1",new ArrayList<Post>(){
                {
                    add(new Reels("post1", ContentState.SHOWED, new Date("23-08-2023"), ContentType.VIDEO,72,72));
                    add(new Feed("post2", ContentState.PINNED, new Date("29-11-2022"), ContentType.PICTURE, "caption1", 108));
                    add(new Story("post3", ContentState.ARCHIVED, new Date("02-10-2023"), ContentType.VIDEO, 15, 66));
                }
            }));
            add(new User("user2", "Tyrone", "password2", "bio2",new ArrayList<Post>(){
                {
                    add(new Reels("post1", ContentState.SHOWED, new Date("12-12-2022"), ContentType.VIDEO,60,280));
                    add(new Feed("post2", ContentState.DELETED, new Date("09-01-2023"), ContentType.PICTURE, "caption2", 350));
                    add(new Story("post3", ContentState.SHOWED, new Date("30-06-2023"), ContentType.PICTURE, 15, 289));
                }
            }));
            add(new User("user3", "Johnson", "password3", "bio3",new ArrayList<Post>(){
                {
                    add(new Reels("post1", ContentState.ARCHIVED, new Date("02-07-2023"), ContentType.VIDEO,30,20));
                    add(new Feed("post2", ContentState.DELETED, new Date("15-02-2023"), ContentType.PICTURE, "caption3", 45));
                    add(new Story("post3", ContentState.SHOWED, new Date("28-05-2023"), ContentType.PICTURE, 30, 127));
                }
            }));
        }
    };

    //menu1
    public String showUserPosts(String username, ArrayList<User> users) {
        String result = "";
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                for (Post post : user.getUserPosts()) {
                    if (post.getContentType().equals(ContentType.VIDEO)) {
                        result += "Post ID: " + post.getPostId() + " | Post Type: " + post.getContentType() + " | Post Status: " + post.getStatus() + " | Time Upload: " + post.getTimeUpload() + " | Duration: " + ((Reels) post).getDuration() + " | Played Count: " + ((Reels) post).getPlayedCount() + "\n";
                    }
                    if (post.getContentType().equals(ContentType.PICTURE)) {
                        result += "Post ID: " + post.getPostId() + " | Post Type: " + post.getContentType() + " | Post Status: " + post.getStatus() + " | Time Upload: " + post.getTimeUpload() + " | Caption: " + ((Feed) post).getCaption() + " | Likes: " + ((Feed) post).getLikes() + "\n";
                    }
                    if (post.getContentType().equals(ContentType.VIDEO)) {
                        result += "Post ID: " + post.getPostId() + " | Post Type: " + post.getContentType() + " | Post Status: " + post.getStatus() + " | Time Upload: " + post.getTimeUpload() + " | Duration: " + ((Story) post).getDuration() + " | Views: " + ((Story) post).getViews() + "\n";
                    }
                }
            }
        }
        return result;
    }

    //menu2
    public String showPost(String postId, ArrayList<User> users) {
        String result = "";
        for (User user : users) {
            for (Post post : user.getUserPosts()) {
                if (post.getPostId().equals(postId)) {
                    if (post.getContentType().equals(ContentType.VIDEO)) {
                        result += "Post ID: " + post.getPostId() + " | Post Type: " + post.getContentType() + " | Post Status: " + post.getStatus() + " | Time Upload: " + post.getTimeUpload() + " | Duration: " + ((Reels) post).getDuration() + " | Played Count: " + ((Reels) post).getPlayedCount() + "\n";
                    }
                    if (post.getContentType().equals(ContentType.PICTURE)) {
                        result += "Post ID: " + post.getPostId() + " | Post Type: " + post.getContentType() + " | Post Status: " + post.getStatus() + " | Time Upload: " + post.getTimeUpload() + " | Caption: " + ((Feed) post).getCaption() + " | Likes: " + ((Feed) post).getLikes() + "\n";
                    }
                    if (post.getContentType().equals(ContentType.VIDEO)) {
                        result += "Post ID: " + post.getPostId() + " | Post Type: " + post.getContentType() + " | Post Status: " + post.getStatus() + " | Time Upload: " + post.getTimeUpload() + " | Duration: " + ((Story) post).getDuration() + " | Views: " + ((Story) post).getViews() + "\n";
                    }
                }
            }
        }
        return result;
    }
    //menu 3
    public void changeChatState(int choice, Post posts){
        if (choice == 1){
            if(posts.getStatus().contains(ContentState.PINNED)) {
                posts.getStatus().set(posts.getStatus().indexOf(ContentState.PINNED), ContentState.SHOWED);
            }
            else{
                posts.getStatus().set(posts.getContentType().indexOf(ContentState.SHOWED), ContentState.PINNED);
            }
        }
        else if (choice == 2){
            if(posts.getStatus().contains(ContentState.ARCHIVED)) {
                posts.getStatus().set(posts.getStatus().indexOf(ContentState.ARCHIVED), ContentState.SHOWED);
            }
            else{
                posts.getStatus().set(posts.getContentType().indexOf(ContentState.SHOWED), ContentState.ARCHIVED);
            }
        }
        else{
            if(posts.getStatus().contains(ContentState.ARCHIVED)|| posts.getStatus().contains(ContentState.DELETED)) {
                posts.setContentStatus(new ArrayList<ContentState>(){
                    { add(ContentState.PINNED);
                        add(ContentState.SHOWED);
                    }
                });
            }
            else{
                posts.SetContentStatus(new ArrayList<ContentState>(){
                    { add(ContentState.ARCHIVED);
                    }
                });
            }
        }
    }
}
