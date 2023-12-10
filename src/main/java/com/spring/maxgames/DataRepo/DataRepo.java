package com.spring.maxgames.DataRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.maxgames.DataModel.Data;

public interface DataRepo extends JpaRepository<Data, Long> {
	
	List<Data> findByAuthId(Long authId);
	
	//Get Each Categories data
	List<Data> findByGametype(String gametype);
	
	//get Categories title
    @Query(value = "SELECT DISTINCT gametype FROM data ORDER BY gametype ASC", nativeQuery = true)
    List<String> findAllGameTypes();
   //get Active games list

    @Query(value = "SELECT * FROM data WHERE gameisenabled = true", nativeQuery = true)
    List<Data> findActiveGame();
    //get Each data coverurl1
    @Query(value = "SELECT coverurl1 FROM data WHERE gameispinned = true", nativeQuery = true)
    List<String> findCoverUrl1();

}
