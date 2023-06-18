package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.dto.CreateBoardDto;
import com.example.demo.dto.UpdateBoardDto;
import com.example.demo.service.BoardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BoardController {
    private BoardService service;

    @GetMapping("/api/board")
    public List<Board> getAllBoards() {
        return service.getAllBoards();
    }

    @PostMapping("/api/board")
    public Board createBoard(@RequestBody @Valid CreateBoardDto createBoardDto) {
        return service.createBoard(createBoardDto);
    }

    @PatchMapping("/api/board")
    public Board updateBoard(@RequestBody UpdateBoardDto updateBoardDto){
        return service.updateBoard(updateBoardDto);
    }

    @DeleteMapping("/api/board/{id}")
    public void deleteBoard(@PathVariable("id") Long id){
        service.deleteBoard(id);
    }
}
