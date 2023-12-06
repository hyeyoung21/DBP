package model.service;

import java.sql.SQLException;

public class MainTest {

    public static void main(String[] args) throws SQLException, PostNotFoundException {
        // TODO Auto-generated method stub
        PostManager man = PostManager.getInstance();
        man.getPost(1);
    }

}
