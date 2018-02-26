package DAO;

import DAO.Interfaces.IDAOComment;
import Model.Comment;
import Model.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOComment extends DAO implements IDAOComment{

    public Comment getCommentById(int id) {
        Comment comment = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM comments WHERE comment_id = ?");
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                comment = new Comment();
                comment.setComment_id(result.getInt("comment_id"));
                comment.setComment_text(result.getString("comment_text"));
                comment.setComment_date(result.getDate("comment_time"));
                comment.setComment_user_id(result.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comment;
    }

    public boolean addComment(Comment comment) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO comments ('comment_text', 'comment_time', 'user_id') VALUES(?, ?, ?)");

            statement.setString(1, comment.getComment_text());
            statement.setDate(1, comment.getComment_date());
            statement.setInt(1, comment.getComment_user_id());
            result = statement.executeUpdate() != 0;
            comment.setComment_id(statement.getGeneratedKeys().getInt(1)); // андрей не знает работает ли это
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delComment(Comment comment) {
        boolean result = false;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE * FROM comments WHERE comment_id = ?");
            statement.setInt(1, comment.getComment_id());
            result = statement.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Comment> getAllComments() {
        List<Comment> commentsList = new ArrayList<Comment>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM comments");
            ResultSet result = statement.executeQuery();
            while (result.next()){
                Comment comment = new Comment();
                comment.setComment_text(result.getString("comment_text"));
                comment.setComment_date(result.getDate("comment_time"));
                comment.setComment_user_id(result.getInt("comment_user_id"));
                commentsList.add((comment));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return commentsList;
    }
}
