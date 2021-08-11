package com.board.service;

import java.util.List;

import com.board.domain.BoardDTO;

public interface BoardService {

	public boolean registerBoard(BoardDTO params);

	public BoardDTO getBoardDetail(Long notice_id);

	public boolean deleteBoard(Long notice_id);

	public List<BoardDTO> getBoardList(BoardDTO params);

}