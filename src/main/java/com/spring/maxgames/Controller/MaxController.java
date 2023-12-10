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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.maxgames.AuthModel.Admin;
import com.spring.maxgames.AuthModel.User;
import com.spring.maxgames.DataModel.Data;
import com.spring.maxgames.EventModel.Events;
import com.spring.maxgames.Service.MaxService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MaxController {

	@Autowired
	private MaxService servicex;
	
	//Auth
	
	@Tag(name = "Admin Signin",description = "Admin Login Endpoint")
	@PostMapping("/admin/signin")
	private String Loginadmin(@RequestBody Map<String, String> Logina) {
	    String username = Logina.get("username");
	    String password = Logina.get("password");
	    String result = servicex.Loginadmin(username, password);
	    return result;
	}
	@Tag(name = "Add Admin",description = "Add Admin (Swagger Only !)")
	@PostMapping("/admin/add")
	private Admin AddAdmin(@RequestBody Admin admin) {
		return servicex.addAdmin(admin);
	}
	
	@Tag(name = "User Signin",description = "User Login Endpoint")
	@PostMapping("/auth/signin")
	private String Login(@RequestBody Map<String, String> Loginx) {
	    String username = Loginx.get("username");
	    String password = Loginx.get("password");
	    String result = servicex.Loginx(username, password);
	    return result;
	}
	@Tag(name = "Active Users", description = "Current Active Accounts")
	@GetMapping("/auth/users")
	private List<User> Users() {
		return servicex.Users();
	}
	@Tag(name = "User Signup",description = "User Signup Endpoint")
    @PostMapping("/auth/signup")
    public String Signup(@RequestBody User userx) {
        return servicex.SignUpx(userx);
    }

	@Tag(name = "Active Users", description = "Current Active Accounts")
	@GetMapping("/auth/user/{username}")
	private User FindUser(@PathVariable String username) {
		return servicex.FindUser(username);
	}	
	
	//Data
	@Tag(name = "All Games", description = "Both Active/Inactive  Games")
	@GetMapping("/games")
	private List<Data> Games(){
		return servicex.Games();
	}
	@Tag(name = "Active Games", description = "Current Active Games")
	@GetMapping("/game/active")
	private List<Data> GamesActive(){
		return servicex.GamesActive();
	}
	@Tag(name = "Sort Game by ID", description = "View indudual Game Data")
	@GetMapping("/game/{id}")
	private Optional<Data> viewGame(@PathVariable Long id) {
		return servicex.viewGame(id);
	}
	@Tag(name = "Admin Add Game", description = "Add New Game (User)")
	@PostMapping("/game")
	private Data addGame(@RequestBody Data gamex) {
		return servicex.addGame(gamex);
	}	
	
	@Tag(name = "User Active Games", description = "User's Current Active Games")
	@GetMapping("/game/get/{id}")
	private List<Data> ListGameUser(@PathVariable Long id){
		return servicex.ListGameUser(id);
	}
	
	@Tag(name = "User Add Game", description = "Add New Game (User)")
	@PostMapping("/game/{username}")
	private Data addGameUser(@RequestBody Data gamex, @PathVariable String username) {
		return servicex.addGameUser(gamex,username);
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
	private List<Data> sortGamesA(@PathVariable String field) {
		return servicex.sortGameA(field);
	}
	@Tag(name = "Sort Games By Field (Descending)", description = "Sort Games By Field(Any Field) [Descending Order]")
	@GetMapping("/game/x/d/{field}")
	private List<Data> sortGamesD(@PathVariable String field){
		return servicex.sortGameD(field);
	}
	@Tag(name = "Paggination Page,Size", description = "Paggination Using with [Page Number]/[Data Size]")
	@GetMapping("/game/x/{offset}/{size}")
	private List<Data> pageGames(@PathVariable int offset, @PathVariable int size){
		return servicex.pagingGames(offset, size);
	}
	@Tag(name = "Paggination Page,Size & Sorting by Field", description = "Paggination Using with [Page Number]/[Data Size] & Sorting with /[Field]")
	@GetMapping("/game/x/{offset}/{size}/{field}")
	private List<Data> sortpageGames(@PathVariable int offset,@PathVariable int size,@PathVariable String field ){
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
	
	
	@Tag(name="Get Events", description = "List all Events Data")
	@GetMapping("/events")
	public List<Events> AllEvents(){
		return servicex.allEvents();
	}

	@Tag(name="Add Event", description = "Add new Event")
	@PostMapping("/event/add")
	public Events addPost(@RequestBody Events eventx) {
		return servicex.addEvent(eventx);
	}

	@Tag(name="Edit Event", description = "Edit existing Event")
	@PutMapping("/event/edit/{id}")
	public Events editEvent(@RequestBody Events eventx, @PathVariable Long id) {
		return servicex.editEvent(eventx, id);
	}

	@Tag(name="Delete Event", description = "Delete existing Event")
	@DeleteMapping("/event/delete/{id}")
	public String deletePost(@PathVariable Long id) {
		return servicex.deleteEvent(id);
	}
	
	@Tag(name = "Enable or Disable User", description = "Enable or Disable User by Username")
	@PutMapping("/auth/user/status/{username}")
	private String toggleUserStatus(@PathVariable String username, @RequestParam boolean enable) {
	    return servicex.toggleUserStatus(username, enable);
	}
	@Tag(name = "Enable or Disable Game", description = "Enable or Disable Game by ID")
	@PutMapping("/game/status/{id}")
	private String toggleGameStatus(@PathVariable Long id, @RequestParam boolean enable) {
	    return servicex.toggleGameStatus(id, enable);
	}

	@Tag(name = "Enable or Disable Game Pin", description = "Enable or Disable Game Pin by ID")
	@PutMapping("/game/pin/{id}")
	private String toggleGamePin(@PathVariable Long id, @RequestParam boolean enable) {
	    return servicex.toggleGamePin(id, enable);
	}
}
