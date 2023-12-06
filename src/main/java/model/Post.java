package model;

import java.util.List;

public class Post {
    private int id;
    private String title;
    private String content;
    private String location;
    private String dateTime;
    private String gender;
    private String age;
    private int maxParticipants;
    private User creator;
    private List<User> participants;
    private String meetingType;

    // Constructors, getters, and setters

    public Post() {
        // Default constructor
    }

    public Post(int id, String title, String description, String location, String dateTime, String gender,
            String ageRange, int maxParticipants, User creator, List<User> participants, String meetingType) {
        super();
        this.id = id;
        this.title = title;
        this.content = description;
        this.location = location;
        this.dateTime = dateTime;
        this.gender = gender;
        this.age = ageRange;
        this.maxParticipants = maxParticipants;
        this.creator = creator;
        this.participants = participants;
        this.meetingType = meetingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String description) {
        this.content = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String ageRange) {
        this.age = ageRange;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", content=" + content + ", location=" + location
                + ", dateTime=" + dateTime + ", gender=" + gender + ", age=" + age + ", maxParticipants="
                + maxParticipants + ", meetingType=" + meetingType + "] \n";
    }

    
}
