package clone.twitter.paylouts;

import java.time.LocalDateTime;
import java.util.Date;

import clone.twitter.entity.Post;
import clone.twitter.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long CommentId;
	

	private String Content;
	

	private UserDto user;
	
	private PostDto post;

	private Date CreatAt;


}
	
