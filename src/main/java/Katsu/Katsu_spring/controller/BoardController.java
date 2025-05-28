package Katsu.Katsu_spring.controller;

import Katsu.Katsu_spring.dto.BoardDTO;
import Katsu.Katsu_spring.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String save(){
        return "save";
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDTO) {
        boardService.save(boardDTO);
        return "redirect:/list"; //글을 작성하면 리다이렉션이 되지 않았었다. 반환타입을 String으로 바꾸고 /list url로 리다이렉션을 해준다.
        //글작성이 성공하면 localhost:8080/list로 페이지가 넘어간다.
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = (List<BoardDTO>) boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    @GetMapping("/board/{postId}")
    public String findById(@PathVariable Long postId, Model model){
        //조회수 처리
        boardService.updateView(postId);
        //상세 내용 가져오기
        BoardDTO boardDTO = boardService.findById(postId);
        model.addAttribute("board", boardDTO);
        return "detail";
    }

}