package Katsu.Katsu_spring.repository;

import Katsu.Katsu_spring.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;

    public void save(BoardDTO boardDTO) {
        sql.insert("Board.save", boardDTO);
    }

    public List<BoardDTO> findAll(){
        System.out.println("findAll");
        return sql.selectList("Board.findAll");
    }

    public void updateView(Long postId){
        sql.update("Board.updateView", postId);
    }

    public BoardDTO findBypostId(Long postId){
        return sql.selectOne("Board.findBypostId", postId);
    }
}
