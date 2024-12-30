package clone.twitter.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Likes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer LikesId;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	private User user;
	
	private LocalDateTime CreatAt;
	
	@JsonIgnore
	@ManyToOne()
	private List<Post> posts=new ArrayList<>();
	
	

}
