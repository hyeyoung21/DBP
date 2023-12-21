package model;

public class Comment {
    private int commentID;
    private String userID;
    private int postID;
    private String commentDate;
    private String content;
    
    public int getCommentID() {
        return commentID;
    }
    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public int getPostID() {
        return postID;
    }
    public void setPostID(int postID) {
        this.postID = postID;
    }
    public String getCommentDate() {
        return commentDate;
    }
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "[commentID=" + commentID + ", userID=" + userID + ", postID=" + postID + ", commentDate="
                + commentDate + ", content=" + content + "]";
    }
    
    

}
