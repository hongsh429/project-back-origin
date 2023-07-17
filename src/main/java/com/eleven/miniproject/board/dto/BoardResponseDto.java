package com.eleven.miniproject.board.dto;


import com.eleven.miniproject.board.entity.Board;
import com.eleven.miniproject.board.entity.UploadImage;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private String username = null;
    private UploadImage uploadImage;
    private String fileDir;

    public BoardResponseDto(Board savedBoard, String fileDir) {
        this.id = savedBoard.getId();
        this.title = savedBoard.getTitle();
        this.content = savedBoard.getContent();
        this.uploadImage = savedBoard.getImage().getUploadImage();
        this.fileDir = fileDir;
    }
}