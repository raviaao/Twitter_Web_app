package clone.twitter.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import clone.twitter.Exceptions.ResourceNotFoundException;
import clone.twitter.Repository.CommentRepo;
import clone.twitter.Repository.PostRepo;
import clone.twitter.Repository.UserRepo;
import clone.twitter.entity.Comment;
import clone.twitter.entity.Post;
import clone.twitter.entity.User;
import clone.twitter.paylouts.CommentDto;

public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepo commentsRepo;
	
	@Autowired
	private UserRepo userepo;
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer userId, Integer postId) {
	User user = userepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));
	Post post = postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","PostId", postId));
		Comment comment = this.modelmapper.map(commentDto, Comment.class);
		comment.setCreatAt(new Date());
		comment.setUser(user);
		comment.setPost(post);
		Comment newComment = this.commentsRepo.save(comment);
		return this.modelmapper.map(newComment, CommentDto.class);
	}

	@Override
	public CommentDto updateComment(CommentDto commentDto, Integer CommentId) {
		Comment updateComment = this.commentsRepo.findById(CommentId).orElseThrow(()-> new ResourceNotFoundException("User", "Id" , CommentId));
		updateComment.setContent(commentDto.getContent());
		Comment update = this.commentsRepo.save(updateComment);
		return this.modelmapper.map(update, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer CommentId) {
		Comment deleteComment = commentsRepo.findById(CommentId).orElseThrow(()-> new ResourceNotFoundException("User", "id", CommentId));
		commentsRepo.delete(deleteComment);
	}

	@Override
	public CommentDto getCommentById(Integer CommentId) {
		Comment comment = commentsRepo.findById(CommentId).orElseThrow(()-> new ResourceNotFoundException("User", "id", CommentId));
		return new ModelMapper().map(comment, CommentDto.class);
	}

	@Override
	public List<CommentDto> getCommentByPost(Integer PostId) {
		Post posts = postRepo.findById(PostId).orElseThrow(()-> new ResourceNotFoundException("User", "id", PostId));
		List<Comment> list = commentsRepo.findByPost(posts);
		List<CommentDto> Comment = list.stream().map((comment)->this.modelmapper.map(comment, CommentDto.class)).collect(Collectors.toList());
		return Comment;
	}

	@Override
	public List<CommentDto> getCommentByUser(Integer userId) {
		User user = userepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		List<Comment> UserAll = commentsRepo.findByUser(user);
		List<CommentDto> collect = UserAll.stream().map((User)-> this.modelmapper.map(User, CommentDto.class)).collect(Collectors.toList());
		
		return collect;
	}

	

}
