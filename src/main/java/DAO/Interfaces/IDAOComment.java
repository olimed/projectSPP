package DAO.Interfaces;

import Model.Comment;

import java.util.List;

public interface IDAOComment {
    Comment getCommentById(int id);
    boolean addComment(Comment comment);
    boolean delComment(Comment comment);
    List<Comment> getAllComments();
}
