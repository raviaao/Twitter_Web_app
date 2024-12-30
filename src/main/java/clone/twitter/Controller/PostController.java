package clone.twitter.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravitiwari.PostResponse.ApiResponse;
import com.ravitiwari.PostResponse.PostResponse;

import clone.twitter.Service.PostService;
import clone.twitter.paylouts.PostDto;

@RestController
@RequestMapping("api/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/LikesId/{LikessId}/CommentId/{CommentId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer LikesId,@PathVariable Integer CommentId){
		PostDto createPost = this.postService.createPost(postDto, userId, LikesId, CommentId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
	
	}
	

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto> postByUser = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(postByUser,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/Likes/{LikesId}/posts")
	public ResponseEntity<List<PostDto>> getPostByLikes(@PathVariable Integer LikesId){
		List<PostDto> postByUser = this.postService.getPostByLikes(LikesId);
		return new ResponseEntity<List<PostDto>>(postByUser,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/Likes/{LikesId}/posts")
	public ResponseEntity<List<PostDto>> getPostByComment(@PathVariable Integer CommentId){
		List<PostDto> postByUser = this.postService.getPostByComment(CommentId);
		return new ResponseEntity<List<PostDto>>(postByUser,HttpStatus.OK);
		
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = "0",required = false)Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10",required = false) Integer pageSize
					)
	{
		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize);
		
		return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
		
		
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		
		PostDto postById = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postById,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deleted(postId);
		return new ApiResponse("Post delete seccessfully deleted !!",true);
	}
	
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
	
}

