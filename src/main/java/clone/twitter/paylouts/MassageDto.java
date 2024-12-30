package clone.twitter.paylouts;

import java.time.LocalDateTime;

import clone.twitter.entity.Chat;
import clone.twitter.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class MassageDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	private String Content;
	
	private String Imagename;
	
	private UserDto user;
	
	private ChatDto Chat;
	
	private LocalDateTime timesStamp;

}
