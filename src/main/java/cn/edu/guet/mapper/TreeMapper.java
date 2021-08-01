package cn.edu.guet.mapper;

import cn.edu.guet.bean.Board;
import cn.edu.guet.bean.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
@Component
public interface TreeMapper {
    List<Tree> getAllTree(String roId);
    Board seeBoard();
}
