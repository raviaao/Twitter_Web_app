package clone.twitter.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import clone.twitter.entity.Comment;
import clone.twitter.entity.Likes;
import clone.twitter.entity.Post;
import clone.twitter.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	
	List<Post> findByLikes(Likes likes);
	
	List<Post> findByComment(Comment comment);
	
	

}
