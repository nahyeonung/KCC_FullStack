package ch15.sec02.exam02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Board {
	private String subject;
	private String content;
	private String writer;
}
