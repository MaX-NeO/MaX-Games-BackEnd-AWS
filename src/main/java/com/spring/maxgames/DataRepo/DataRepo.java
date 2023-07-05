package com.spring.maxgames.DataRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.maxgames.DataModel.Data;

public interface DataRepo extends JpaRepository<Data, Long> {
	
	//Get Each Categories data
	List<Data> findByGametype(String gametype);
	
	//get Categories title
    @Query(value = "SELECT DISTINCT gametype FROM data", nativeQuery = true)
    List<String> findAllGameTypes();
    
    //get Each data coverurl1
    @Query(value = "SELECT coverurl1 FROM data", nativeQuery = true)
    List<String> findCoverUrl1();
}
