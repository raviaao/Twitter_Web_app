package clone.twitter.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import clone.twitter.entity.Likes;
import clone.twitter.entity.Post;
import clone.twitter.entity.User;

public interface LikesRepo extends JpaRepository<Likes, Integer> {
	
	List<Likes> findByCreatedBy(Likes likes);
	
	List<Likes> findByPosts(Post posts);

}
