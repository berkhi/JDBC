package com.berkhayta._03_JDBC_ForumDB.repository;

import com.berkhayta._03_JDBC_ForumDB.entity.Users;
import com.berkhayta._03_JDBC_ForumDB.repository.ICrud;
import com.berkhayta._03_JDBC_ForumDB.entity.Forum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ForumRepository implements ICrud<Forum> {
    String sql;
    private DatabaseHalper databaseHelper;
    public ForumRepository() {
        this.databaseHelper = new DatabaseHalper();
    }

    @Override
    public void save(Forum forum) {
        sql = "INSERT INTO tblposts(posttitle,postcontent,postauthor,postdate) VALUES ('%s', '%s', '%s','%s')"
                .formatted(forum.getPostTitle(), forum.getPostContent(),forum.getPostAuthor(),forum.getPostDate());
        databaseHelper.executeUpdate(sql);
    }
    @Override
    public void update(Forum forum) {
        sql = "UPDATE tblposts SET posttitle = '%s' , postcontent = '%s', postauthor = '%s', postdate = '%s' WHERE id = '%d' "
                .formatted(forum.getPostTitle(), forum.getPostContent(),forum.getPostAuthor(), forum.getId());
        databaseHelper.executeUpdate(sql);
    }
    @Override
    public void delete(int id) {
        sql = "Delete from tblusers where id=%d"
                .formatted(id);
        databaseHelper.executeUpdate(sql);
    }
    @Override
    public List<Forum> findAll() {
        sql = "SELECT * FROM tblposts ORDER BY id";
        ResultSet resultSet = databaseHelper.executeQuery(sql);
        List<Forum> postList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String posttitle = resultSet.getString("posttitle");
                String postcontent = resultSet.getString("postcontent");
                String postauthor = resultSet.getString("postauthor");
//                LocalDate postdate = resultSet.getDate("postdate").toLocalDate();
                Integer state = resultSet.getInt("state");
                Long createat = resultSet.getLong("createat");
                Long updateat = resultSet.getLong("updateat");
                Forum m = new Forum(id, posttitle, postcontent, postauthor);
                m.setState(state);
                m.setCreateat(createat);
                m.setUpdateat(updateat);
                postList.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    @Override
    public Optional<Forum> findById(int id) {
        return Optional.empty();
    }


}
