package clone.twitter.paylouts;

import java.time.LocalDateTime;
import java.util.List;

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
public class UserDto {
	

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
	private String ProfileImgUrl;
	private LocalDateTime CreatAt;
	
	private List<Integer> Followers;
	
	private List<Integer> following;
	
	

}
