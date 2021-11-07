package gap.com.car.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import gap.com.car.database.entity.CommentBean;

@Dao
public interface CommentDao {

    @Query("SELECT * FROM commentbean")
    List<CommentBean> getAllComment();

    @Insert
    void insertComment(CommentBean commentBean);

    @Query("SELECT * FROM commentbean WHERE id = :id")
    public CommentBean getCommentBeanById(int id);
}
