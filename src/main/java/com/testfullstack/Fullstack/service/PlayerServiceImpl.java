package com.testfullstack.Fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testfullstack.Fullstack.dao.PlayerDao;
import com.testfullstack.Fullstack.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerDao playerDao;
	
	@Override
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return (List<Player>) playerDao.findAll();
	}

	@Override
	public Player savePlayer(Player player) {
		// TODO Auto-generated method stub
		player.setStatus("pending");
		player.setTeam("");
		return playerDao.save(player);
	}

	@Override
	public List<Player> getPlayerByStatus(String status) {
		// TODO Auto-generated method stub
		
		return playerDao.getPlayerByStatus(status) ;
	}

	@Override
	public String updatePlayer(String team, String email) {
		// TODO Auto-generated method stub
		playerDao.updatePlayer(team, email);
		return "player updated";
	}

	@Override
	public List<Player> findByTeam(String team) {
		// TODO Auto-generated method stub
		return playerDao.findByTeam(team);
	}

	@Override
	public String deletePlayer(String email) {
		// TODO Auto-generated method stub
		playerDao.deleteById(email);
		return "Player Deleted";
	}

	
}
