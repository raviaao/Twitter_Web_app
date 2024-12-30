package clone.twitter.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.ravitiwari.PostResponse.PostResponse;

import clone.twitter.Exceptions.ResourceNotFoundException;
import clone.twitter.Repository.CommentRepo;
import clone.twitter.Repository.LikesRepo;
import clone.twitter.Repository.PostRepo;
import clone.twitter.Repository.UserRepo;
import clone.twitter.entity.Comment;
import clone.twitter.entity.Likes;
import clone.twitter.entity.Post;
import clone.twitter.entity.User;
import clone.twitter.paylouts.PostDto;

public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postrepo;
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private LikesRepo likesRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CommentRepo commentRepo;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer LikesId, Integer CommentId) {
		
		User user = userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId", userId));
		Likes like = likesRepo.findById(LikesId).orElseThrow(()-> new ResourceNotFoundException("LIkes", "Id", LikesId));
		Comment comment = commentRepo.findById(CommentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "Id", CommentId));
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("Defult.Png");
		post.setCreatAt(new Date());
		post.setUser(user);
		
		Post newPost = postrepo.save(post);
		
		
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer PostId) {
		Post post = this.postrepo.findById(PostId).orElseThrow(()-> new ResourceNotFoundException("Post", "Id", PostId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setVideo(postDto.getVideo());
		post.setImageName(postDto.getImageName());
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public void deleted(Integer PostId) {
		Post deleted = postrepo.findById(PostId).orElseThrow(()-> new ResourceNotFoundException("Post", "Id" , PostId));
		postrepo.delete(deleted);
		
	}

	@Override
	public PostResponse getAllPost(Integer PageNumber, Integer PageSize) {
		PageRequest p = PageRequest.of(PageNumber, PageSize);
		Page<Post> AllPost = postrepo.findAll(p);
		List<Post> all = postrepo.findAll();
		List<PostDto> list = all.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse post=new PostResponse();
		post.setContent(list);
		post.setPageNumber(AllPost.getNumber());
		post.setPageSize(AllPost.getSize());
		post.setTotalElememts(AllPost.getTotalElements());
		post.setTotalpages(AllPost.getTotalPages());
		post.setLastpages(AllPost.isLast());
		
		return post;
	}

	@Override
	public PostDto getPostById(Integer PostId) {
		Post post = postrepo.findById(PostId).orElseThrow(()-> new ResourceNotFoundException("PostId" , "Id", PostId));
		
		return new ModelMapper().map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id",userId));
		List<Post> newUser = postrepo.findByUser(user);
		List<PostDto> list = newUser.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return list;
	}

	@Override
	public List<PostDto> getPostByLikes(Integer LikesId) {
		Likes likes = likesRepo.findById(LikesId).orElseThrow(()-> new ResourceNotFoundException("Likes", "Id",LikesId));
		List<Post> list = postrepo.findByLikes(likes);
		List<PostDto> collect = list.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public List<PostDto> getPostByComment(Integer CommentId) {
		Comment comment = commentRepo.findById(CommentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "Id", CommentId));
		List<Post> list = postrepo.findByComment(comment);
		List<PostDto> collect = list.stream().map((post)-> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
		
		return collect;
	}

}
