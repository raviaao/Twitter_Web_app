package clone.twitter.Service;

import java.util.List;

import clone.twitter.entity.Comment;
import clone.twitter.entity.Post;
import clone.twitter.entity.User;
import clone.twitter.paylouts.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId);
	
	CommentDto updateComment(CommentDto commentDto, Integer CommentId);
	
	void deleteComment(Integer CommmentId);
	
	CommentDto getCommentById(Integer CommentId);
	
	List<CommentDto> getCommentByPost(Integer PostId);
	
	List<CommentDto> getCommentByUser(Integer userId);

	

}
