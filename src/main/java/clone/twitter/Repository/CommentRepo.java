package clone.twitter.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import clone.twitter.entity.Comment;
import clone.twitter.entity.Post;
import clone.twitter.entity.User;

public interface CommentRepo extends JpaRepository<Comment, Integer>{
	
	List<Comment> findByUser(User user);
	
	List<Comment> findByPost(Post posts);

    @Query("SELECT c FROM Comment c WHERE c.content LIKE %:keyword%")
    List<Comment> findByContentContaining(@Param("keyword") String keyword);
	
	

}
