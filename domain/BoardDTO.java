package com.board.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO extends CommonDTO{

	private Long notice_id;			//글번호(PK)
	private String n_title;		//제목
	private String n_content;		//내용
	private String n_writer;
	private LocalDateTime reg_dt;
	private String ref1;
	private String n_file;
	private String delete_yn;	//삭제 여부

	public BoardDTO(Long notice_id, String n_title, String n_content, String n_writer, LocalDateTime reg_dt,
			String ref1, String n_file, String delete_yn) {
		super();
		this.notice_id = notice_id;
		this.n_title = n_title;
		this.n_content = n_content;
		this.n_writer = n_writer;
		this.reg_dt = reg_dt;
		this.ref1 = ref1;
		this.n_file = n_file;
		this.delete_yn = delete_yn;
	}


}