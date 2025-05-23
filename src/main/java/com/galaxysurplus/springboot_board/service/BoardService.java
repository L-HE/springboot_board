package com.galaxysurplus.springboot_board.service;

import com.galaxysurplus.springboot_board.dto.BoardDTO;
import com.galaxysurplus.springboot_board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        boardRepository.save(boardDTO);
    }
}
