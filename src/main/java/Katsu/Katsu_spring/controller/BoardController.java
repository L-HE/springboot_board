package Katsu.Katsu_spring.controller;

import Katsu.Katsu_spring.dto.BoardDTO;
import Katsu.Katsu_spring.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public void save(BoardDTO boardDTO) {
        boardService.save(boardDTO);
    }
}