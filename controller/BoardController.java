package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.BoardDTO;
import com.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping(value = "/board/write.do")
	public String openBoardWrite(@RequestParam(value = "notice_id", required = false) Long notice_id, Model model) {
		if (notice_id == null) {
			model.addAttribute("board", new BoardDTO(notice_id, null, null, null, null, null, null, null));
		} else {
			BoardDTO board = boardService.getBoardDetail(notice_id);
			if (board == null) {
				return "redirect:/board/list.do";
			}
			model.addAttribute("board", board);
		}

		return "board/write";
	}
	@PostMapping(value = "/board/register.do")
	public String registerBoard(final BoardDTO params) {
		try {
			boolean isRegistered = boardService.registerBoard(params);
			if (isRegistered == false) {
				
			}
		} catch (DataAccessException e) {
		} catch (Exception e) {
		}
		return "redirect:/board/list.do";
	}
	@GetMapping(value = "/board/list.do")
	public String openBoardList(@ModelAttribute("params") BoardDTO params, Model model) {
		List<BoardDTO> boardList = boardService.getBoardList(params);
		model.addAttribute("boardList", boardList);

		return "board/list";
	}
	
	@GetMapping(value = "/board/view.do")
	public String openBoardDetail(@RequestParam(value = "notice_id", required = false) Long notice_id, Model model) {
		if (notice_id == null) {
			return "redirect:/board/list.do";
		}

		BoardDTO board = boardService.getBoardDetail(notice_id);
		if (board == null || "Y".equals(board.getDelete_yn())) {
			return "redirect:/board/list.do";
		}
		model.addAttribute("board", board);

		return "board/view";
	}
	@PostMapping(value = "/board/delete.do")
	public String deleteBoard(@RequestParam(value = "notice_id", required = false) Long notice_id) {
		if (notice_id == null) {
			return "redirect:/board/list.do";
		}
		try {
			boolean isDeleted = boardService.deleteBoard(notice_id);
			if (isDeleted == false) {
			}
		} catch (DataAccessException e) {

		} catch (Exception e) {
		}

		return "redirect:/board/list.do";
	}
}