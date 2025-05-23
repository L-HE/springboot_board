package com.galaxysurplus.springboot_board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
    private long postId;
    private int id;
    private String title;
    private String content;
    private int viewCnt;
    private int likes;
    private String createdAt;
}
