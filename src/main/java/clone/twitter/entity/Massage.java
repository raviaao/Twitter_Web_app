package clone.twitter.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Massage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	private String Content;
	
	private String Imagename;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Chat Chat;
	
	private LocalDateTime timesStamp;

}
