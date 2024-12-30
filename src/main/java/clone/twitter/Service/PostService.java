package clone.twitter.Service;

import java.util.List;

import com.ravitiwari.PostResponse.PostResponse;

import clone.twitter.paylouts.PostDto;

public interface PostService {
	
	PostDto createPost(PostDto postDto, Integer userId, Integer LikesId, Integer CommentId);

	PostDto updatePost(PostDto postDto, Integer PostId);
	
	void deleted(Integer PostId);
	
	PostResponse getAllPost(Integer PageNumber, Integer PageSize);
	
	PostDto getPostById(Integer PostId);
	
	List<PostDto> getPostByUser(Integer userId);
	
	List<PostDto> getPostByLikes(Integer LikesId);
	
	List<PostDto> getPostByComment(Integer CommentId);
}
