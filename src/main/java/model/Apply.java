package model;
//import java.util.List;
public class Apply {
    private int applyID;
    private int postID;
    private String userID;
    private String status;
    private String description;
    
    public Apply(int applyID, int postID, String userID, String status, String description) {
        super();
        this.applyID = applyID;
        this.postID = postID;
        this.userID = userID;
        this.status = status;
        this.description = description;
    }
    public int getApplyID() {
        return applyID;
    }
    public void setApplyID(int applyID) {
        this.applyID = applyID;
    }
    public int getPostID() {
        return postID;
    }
    public void setPostID(int postID) {
        this.postID = postID;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
