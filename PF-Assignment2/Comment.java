package PF.Assignment2;

import java.util.ArrayList;

public class Comment {
    protected User usr;
    protected String usrComment;
    protected ArrayList<Comment> childNode;

    public Comment(User usr, String usrComment) {
        this.childNode = new ArrayList<>();
        this.usr = usr;
        this.usrComment = usrComment;
    }

    public void addReply(Comment newCmt) {
        this.childNode.add(newCmt);
        System.out.println(newCmt.usr.usrName + " added reply " + '"' + newCmt.usrComment + '"' + " to " + this.usr.usrName);
    }

    public String getUsrComment() {
        return usrComment;
    }

    public String getUserNameID() {
        return usr.usrName + "(" + usr.getUsrID() + ")";
    }
}