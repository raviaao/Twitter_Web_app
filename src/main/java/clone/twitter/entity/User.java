package clone.twitter.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;	
	private String fullname;
	private String lastname;
	private String email;
	private String mobail;
	private String password;
	private String DOB;
	private String Bio;
	private String Gender;
	private String ProfileImgUrl;
	private LocalDateTime CreatAt;
	private List<Integer> Followers;
	private List<Integer> Following;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade =  CascadeType.ALL)
	private List<Comment>comments=new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Likes> likes=new ArrayList<>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Post> posts=new ArrayList<>();

}
