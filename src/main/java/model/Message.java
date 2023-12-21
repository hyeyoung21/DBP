package model;

public class Message {
	 private int messageID;
	 private String revID;
	 private String senderID;
	 private String content;
	 private String messageDate;
	 
	 public Message() {
	        // Default constructor
	    }

	 public Message(int messageID, String revID, String senderID, String content, String messageDate) {
	     super();
	     this.messageID = messageID;
	   	 this.revID = revID;
	   	 this.senderID = senderID;
	   	 this.content = content;
	   	 this.messageDate = messageDate;
	 }

	 public int getMessageID() {
		 return messageID;
	 }
	 public void setMessageID(int messageID) {
		 this.messageID = messageID;
	 }
	 public String getRevID() {
		 return revID;
	 }
	 public void setRevID(String revID) {
		 this.revID = revID;
	 }
	 public String getSenderID() {
		 return senderID;
	 }
	 public void setSenderID(String senderID) {
		 this.senderID = senderID;
	 }
	 public String getContent() {
		 return content;
	 }
	 public void setContent(String content) {
		 this.content = content;
	 }
	 public String getMessageDate() {
		 return messageDate;
	 }
	 public void setMessageDate(String messageDate) {
		 this.messageDate = messageDate;
	 }
	 
	 @Override
	    public String toString() {
	        return "[messageID=" + messageID + ", revID=" + revID + ", senderID=" + senderID + ", content=" + content +
	        		", messageDate=" + messageDate  + "]";
	    }
}