package com.testfullstack.Fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.testfullstack.Fullstack.model.Player;
import com.testfullstack.Fullstack.service.PlayerService;

@RequestMapping("player")
@RestController
@CrossOrigin
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@GetMapping
	public ResponseEntity<List<Player>> getPlayers(@RequestParam (required=false) String status,@RequestParam (required=false) String team ){
		if(status!=null) {
			List<Player> players=playerService.getPlayerByStatus(status);
			return new ResponseEntity<List<Player>>(players,HttpStatus.OK);
		}
		else if(team!=null) {
			List<Player> players=playerService.findByTeam(team) ;
			return new ResponseEntity<List<Player>>(players,HttpStatus.OK);
		}
		List<Player> players=playerService.getPlayers();
		return new ResponseEntity<List<Player>>(players,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Player> savePlayer(@RequestBody Player player){
		Player newPlayer=playerService.savePlayer(player);
		return new ResponseEntity<Player>(newPlayer,HttpStatus.OK);
		
	}

	@PutMapping
	public ResponseEntity<String> updatePlayer(@RequestBody Player player){
		String msg=playerService.updatePlayer(player.getTeam() , player.getEmail() );
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("{email}")
	public ResponseEntity<String> deletePlayer(@PathVariable String email){
		String msg=playerService.deletePlayer(email);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
}
