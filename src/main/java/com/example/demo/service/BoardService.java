package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.domain.BoardRepository;
import com.example.demo.dto.CreateBoardDto;
import com.example.demo.dto.UpdateBoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board createBoard(CreateBoardDto createBoardDto) {
        Board board = Board.builder()
            .name(createBoardDto.getName())
            .description(createBoardDto.getDescription())
            .build();

        return boardRepository.save(board);
    }


    public Board updateBoard(UpdateBoardDto updateBoardDto) {
        Board board = boardRepository.findById(updateBoardDto.getId()).get();

        board.setName(updateBoardDto.getName());
        board.setDescription(updateBoardDto.getDescription());

        return boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        Board board = boardRepository.findById(id).get();

        boardRepository.delete(board);
    }
}
