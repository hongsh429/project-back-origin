package com.eleven.miniproject.board.createBoard.controller;


import com.eleven.miniproject.board.createBoard.service.BoardCreateService;
import com.eleven.miniproject.board.dto.BoardRequestDto;
import com.eleven.miniproject.board.dto.BoardResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardCreateController {

    private final BoardCreateService boardCreateService;

    /**
     * 게시글을 저장하는 로직
     * 1. 제목과 내용을 받고, multi-part Form data 를 별도로 받는다.
     */
    @PostMapping(value = "/boards")
    public BoardResponseDto createBoard(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam(value = "image",required = false) MultipartFile image,
            HttpServletRequest request
    ) throws IOException {
        BoardRequestDto requestDto = new BoardRequestDto(title, content, image);
        return boardCreateService.createBoard(requestDto, request);
    }

}
