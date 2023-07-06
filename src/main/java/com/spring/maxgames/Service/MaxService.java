package com.spring.maxgames.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.maxgames.AuthModel.Admin;
import com.spring.maxgames.AuthModel.User;
import com.spring.maxgames.AuthRepo.AdminRepo;
import com.spring.maxgames.AuthRepo.UserRepo;
import com.spring.maxgames.DataModel.Data;
import com.spring.maxgames.DataRepo.DataRepo;
import com.spring.maxgames.PostModel.Post;
import com.spring.maxgames.PostRepo.PostRepo;

@Service
public class MaxService {
	@Autowired
	private UserRepo uRepo;
	@Autowired
	private DataRepo dRepo;
	@Autowired
	private AdminRepo aRepo;
	@Autowired
	private PostRepo pRepo;

// Admin Login
	public String Loginadmin(String username, String password) {
		Admin adminx = aRepo.findByUsername(username);
		if (adminx == null) {
			return "Invalid User !";
		} else {
			if (adminx.getPassword().equals(password)) {
				return "Login Successful !";
			} else {
				return "Invalid Password";
			}
		}
	}
// Add Admin
	public Admin addAdmin(Admin admin) {
		return aRepo.save(admin);
	}
	

//User Login
	public String Loginx(String username, String password) {
		User userx = uRepo.findByUsername(username);
		if (userx == null) {
			return "Invalid User !";
		} else {
			if (userx.getPassword().equals(password)) {
				return "Login Successful !";
			} else {
				return "Invalid Password";
			}
		}
	}

//User SignUp
	public String SignUpx(User userx) {
		String username = userx.getUsername();
		User userxAuth = uRepo.findByUsername(username);
		if (userxAuth == null) {
			uRepo.save(userx);
			return "Signup Successful !";
		} else {
			if (userxAuth.getUsername().equals(username)) {
				return "Username Already Exists";
			} else {
				return "Invalid Username";
			}
		}
	}

//Users List
	public List<User> Users() {
		return uRepo.findAll();
	}

// User Data
	public User FindUser(String user) {
		return uRepo.findByUsername(user);

	}

//List Games
	public List<Data> Games() {
		return dRepo.findAll();
	}

//View Game
	public Optional<Data> viewGame(Long id) {
		return dRepo.findById(id);
	}

//List Game User
	public List<Data> ListGameUser(Long id) {
		List<Data> data = dRepo.findByAuthId(id);
		if (!data.isEmpty()) {
			return data;
		} else {
			return null;
		}
	}

//Add Game
	public Data addGame(Data gamex) {
		return dRepo.save(gamex);
	}

// Add Game User
	public Data addGameUser(Data gamex, String username) {
		User user = uRepo.findByUsername(username);
		if (user != null) {
			gamex.setAuth(user);
			return dRepo.save(gamex);
		}
		return null;
	}

//Edit Game
	public Data editGame(Data gamex, Long id) {
		Data gamez = dRepo.findById(id).orElse(null);
		if (gamez != null) {
			gamez.setGamename(gamex.getGamename());
			gamez.setGamedeveloper(gamex.getGamedeveloper());
			gamez.setGameratings(gamex.getGameratings());
			gamez.setGameprice(gamex.getGameprice());
			gamez.setGametype(gamex.getGametype());
			gamez.setReleaseyear(gamex.getReleaseyear());
			gamez.setGamecover(gamex.getGamecover());
			gamez.setGamedesc(gamex.getGamedesc());
			gamez.setCoverurl1(gamex.getCoverurl1());
			gamez.setCoverurl2(gamex.getCoverurl2());
			gamez.setCoverurl3(gamex.getCoverurl3());

			return dRepo.saveAndFlush(gamez);
		} else {
			return null;
		}
	}

//Delete Game
	public String deleteGame(Long id) {
		dRepo.deleteById(id);
		return "deleted";
	}

//Sort Games (Ascending)
	public List<Data> sortGameA(String field) {
		return dRepo.findAll(Sort.by(field).ascending());
	}

// Sort Games (Descending)
	public List<Data> sortGameD(String field) {
		return dRepo.findAll(Sort.by(field).descending());
	}

// Pagination for Games
	public List<Data> pagingGames(int offset, int size) {
		Page<Data> xPage = dRepo.findAll(PageRequest.of(offset, size));
		return xPage.getContent();
	}

//	Pagination & Sorting Combined
	public List<Data> pagingsortingGames(int offset, int size, String field) {
		Page<Data> xPage = dRepo.findAll(PageRequest.of(offset, size, Sort.by(field).ascending()));
		return xPage.getContent();
	}

// Find by Game type
	public List<Data> findGamebyType(String field_data) {
		return dRepo.findByGametype(field_data);
	}

// List Game types
	public List<String> getallGameTypes() {
		return dRepo.findAllGameTypes();
	}

// List Each Game's 1st cover url
	public List<String> getAllCoverUrl1() {
		return dRepo.findCoverUrl1();
	}

// List Posts
	public List<Post> posts() {
		return pRepo.findAll();
	}

// Add Post
	public Post addPost(Post postx) {
		return pRepo.save(postx);
	}

// Edit Post    
	public Post editPost(Post postx, Long id) {
		Post postz = pRepo.findById(id).orElse(postx);
		if (postz != null) {
			postz.setPosttitle(postx.getPosttitle());
			postz.setPostcontent(postx.getPostcontent());
			postz.setPostauthorid(postx.getPostauthorid());
			postz.setPostsource(postx.getPostsource());
			postx.setPosttitle(postx.getPosttitle());
			return pRepo.saveAndFlush(postz);
		} else {
			return null;
		}

	}

// Delete Post
	public String deletePost(Long id) {
		dRepo.deleteById(id);
		return "Post Deleted";
	}
}