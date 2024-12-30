package clone.twitter.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ManyToMany;

public class Chat {
	
	private Integer Id;
	
	private String Chat_name;
	
	private String chat_image;
	
	@ManyToMany
	private List<User> users=new ArrayList<>();
	
	private LocalDateTime timestamp;
	
	

}
