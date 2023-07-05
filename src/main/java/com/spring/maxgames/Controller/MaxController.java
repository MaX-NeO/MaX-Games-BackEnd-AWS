package com.spring.maxgames.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.maxgames.AuthModel.Auth;
import com.spring.maxgames.DataModel.Data;
import com.spring.maxgames.PostModel.Post;
import com.spring.maxgames.Service.MaxService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
// @CrossOrigin("https://max-games.netlify.app/")
@CrossOrigin(origins = "*")
public class MaxController {

	@Autowired
	private MaxService servicex;
	
	//Auth
	@Tag(name = "Signin",description = "Login Endpoint")
	@PostMapping("/auth/signin")
	private String Login(@RequestBody Map<String, String> Loginx) {
	    String username = Loginx.get("username");
	    String password = Loginx.get("password");
	    String result = servicex.Loginx(username, password);
	    return result;
	}
	@Tag(name = "Active Users", description = "Current Active Accounts")
	@GetMapping("/auth/users")
	private List<Auth> Users() {
		return servicex.Users();
	}
	@Tag(name = "Signup",description = "Signup Endpoint")
    @PostMapping("/auth/signup")
    public String Signup(@RequestBody Auth userx) {
        return servicex.SignUpx(userx);
    }
	
	//Data
	@Tag(name = "Active Games", description = "Current Active Games")
	@GetMapping("/games")
	private List<Data> Games(){
		return servicex.Games();
	}
	@Tag(name = "Sort Game by ID", description = "View indudual Game Data")
	@GetMapping("/game/{id}")
	private Optional<Data> viewGame(@PathVariable Long id) {
		return servicex.viewGame(id);
	}
	@Tag(name = "Add Game", description = "Add New Game")
	@PostMapping("/game")
	private Data addGame(@RequestBody Data gamex) {
		return servicex.addGame(gamex);
	}
	@Tag(name = "Edit Game", description = "Edit Exsisting Game")
	@PutMapping("/game/{id}")
	private Data editGame(@PathVariable Long id, @RequestBody Data gamex) {
		return servicex.editGame(gamex, id);
	}
	@Tag(name = "Delete Game", description = "Delete The Existing Game")
	@DeleteMapping("/game/{id}")
	private String deleteGame(@PathVariable Long id) {
		return servicex.deleteGame(id);
	}
	@Tag(name = "Sort Games By Field (Ascending)", description = "Sort Games By Field(Any Field) [Ascending Order]")
	@GetMapping("/game/x/a/{field}")
	private List<Data> sortGamesA(@PathVariable("field") String field) {
		return servicex.sortGameA(field);
	}
	@Tag(name = "Sort Games By Field (Descending)", description = "Sort Games By Field(Any Field) [Descending Order]")
	@GetMapping("/game/x/d/{field}")
	private List<Data> sortGamesD(@PathVariable("field") String field){
		return servicex.sortGameD(field);
	}
	@Tag(name = "Paggination Page,Size", description = "Paggination Using with [Page Number]/[Data Size]")
	@GetMapping("/game/x/{offset}/{size}")
	private List<Data> pageGames(@PathVariable("offset") int offset, @PathVariable("size") int size){
		return servicex.pagingGames(offset, size);
	}
	@Tag(name = "Paggination Page,Size & Sorting by Field", description = "Paggination Using with [Page Number]/[Data Size] & Sorting with /[Field]")
	@GetMapping("/game/x/{offset}/{size}/{field}")
	private List<Data> sortpageGames(@PathVariable("offset") int offset,@PathVariable("size") int size,@PathVariable("field") String field ){
		return servicex.pagingsortingGames(offset, size, field);
	}
	@Tag(name="Find Game by Category", description = "Find a Games by Categories")
	@GetMapping("/game/categories/{gametype}")
	public List<Data> findGametype(@PathVariable String gametype){
		return servicex.findGamebyType(gametype);
	}
	@Tag(name="Get Game Categories", description = "List all Gametypes only")
    @GetMapping("/gametypes")
    public List<String> getAllGameTypes() {
        return servicex.getallGameTypes();
    }
	@Tag(name="Get Game Cover URL", description = "List all Game's 1'st Cover URL only")
    @GetMapping("/game/coverurl1data")
    public List<String> getAllCoverUrl1() {
        return servicex.getAllCoverUrl1();
    }
	
	
	
	@GetMapping("/posts")
	public List<Post> Posts(){
		return servicex.posts();
	}
	@PostMapping("/post")
	public Post addPost(@RequestBody Post postx) {
		return servicex.addPost(postx);
	}
	@PutMapping("/post/{id}")
	public Post editPost(@RequestBody Post postx, @PathVariable Long id) {
		return servicex.editPost(postx, id);
	}
	@DeleteMapping("/post/{id}")
	public String deletePost(@PathVariable Long id) {
		return servicex.deletePost(id);
	}
	
}
