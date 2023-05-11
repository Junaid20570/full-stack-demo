package com.testfullstack.Fullstack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.testfullstack.Fullstack.model.Player;

@Service
public interface PlayerService {
	
	public List<Player> getPlayers();
	public Player savePlayer(Player player);
	public List<Player> getPlayerByStatus(String status);
	
	public String updatePlayer(String team, String email);
	
	public List<Player> findByTeam(String team);
	
	public String deletePlayer(String email);
}
