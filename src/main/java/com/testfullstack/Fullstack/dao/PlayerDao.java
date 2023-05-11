package com.testfullstack.Fullstack.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testfullstack.Fullstack.model.Player;

@Repository
public interface PlayerDao extends CrudRepository<Player, String> {
	
	@Query("from Player p where p.status= :status")
	public List<Player> getPlayerByStatus(String status);
	
	@Transactional
	@Modifying
	@Query("update Player p set p.team=:team , p.status='allotted' where p.email=:email")
	public void updatePlayer(String team, String email);
	
	public List<Player> findByTeam(String team);

}
