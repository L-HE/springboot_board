package com.galaxysurplus.springboot_board.controller;

import com.galaxysurplus.springboot_board.dto.BoardDTO;
import com.galaxysurplus.springboot_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/save")
    public void save(BoardDTO boardDTO) {
        boardService.save(boardDTO);
    }
}
