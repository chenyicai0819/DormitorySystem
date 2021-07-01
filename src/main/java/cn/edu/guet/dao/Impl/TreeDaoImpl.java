package cn.edu.guet.dao.Impl;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.dao.ITreeDao;
import cn.edu.guet.filter.ConnectionFilter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liwei
 * @Date 2021-06-24 21:41
 * @Version 1.0
 */
public class TreeDaoImpl implements ITreeDao {
    @Override
    public List<Tree> getAllTree() {
        /*
        具体的JDBC代码，连接数据库，获取数据
         */
        List<Tree> treeList = new ArrayList<Tree>();

        Connection conn= ConnectionFilter.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "";
        try {
            sql = "SELECT * FROM tree";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Tree tree = new Tree();
                tree.setTreeId(rs.getString(1));
                tree.setParentId(rs.getString(2));
                tree.setTreeName(rs.getString(3));
                tree.setTreeUrl(rs.getString(4));
                tree.setIsParent(rs.getString(5));
                treeList.add(tree);
                System.out.println(tree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return treeList;
    }
}

