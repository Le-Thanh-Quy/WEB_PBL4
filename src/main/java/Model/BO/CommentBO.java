package Model.BO;

import Model.BEAN.Chat;
import Model.BEAN.Comment;
import Model.BEAN.User;
import Model.DAO.Connect;

import java.util.ArrayList;
import java.util.List;

public class CommentBO {
    private static CommentBO instance;

    public static CommentBO getInstance() {
        if (instance == null) {
            instance = new CommentBO();
        }
        return instance;
    }

    private CommentBO() {
    }

    public String FormatTime(String time) {
        String dateTime;
        String[] strings1 = time.split(" ");
        String[] stringDate = strings1[0].split("-");
        String[] stringTime = strings1[1].split(":");
        dateTime = stringDate[2] + "-" + stringDate[1] + "-" + stringDate[0] + " lúc " + stringTime[0] + ":" + stringTime[1];
        return dateTime;
    }

    public List<Comment> getListComment(int PostID) {
        List<Comment> comments = new ArrayList<Comment>();
        for (Comment i : Connect.getInstance().getListComment(PostID)) {
            String time = FormatTime(i.getTime());
            i.setTime(time);
            User user = Connect.getInstance().GetUser("-1", i.getUserID());
            i.setUser(user);
            comments.add(i);
        }
        return comments;
    }
    public User getUserByID(int ID){
        return Connect.getInstance().GetUser("-1" , ID);
    }
    public int addComment(Comment comment) {
        int ID = Connect.getInstance().getCommentID();
        if (ID == -1) {
            return -1;
        }
        comment.setID(ID);
        if (Connect.getInstance().addComment(comment)) {
            return ID;
        } else {
            return -1;
        }
    }
}
