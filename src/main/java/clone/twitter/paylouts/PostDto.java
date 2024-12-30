package clone.twitter.paylouts;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import clone.twitter.entity.Comment;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer PostId;
	
	private UserDto user;
	
	private String title;
	
	private String content;
	
	private String Video;
	
	private String imageName;
	
	private LocalDateTime CreatAt;

	private Set<Comment> comments=new HashSet<>();

}
