package me._0o0.common;
//pzhang
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Builder
public class Message {

	private int id;
	private String content;

}
