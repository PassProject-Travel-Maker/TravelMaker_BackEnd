package com.ssafy.backend.domain.map.controller;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.backend.domain.map.service.MapService;

import jakarta.servlet.http.HttpServlet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/map")
public class MapController extends HttpServlet {
	private final MapService mapService;

	public MapController(MapService mapService) {
		super();
		this.mapService = mapService;
	}
	
	@GetMapping("/sido")
	public ResponseEntity<Object> sido() {
		log.debug("/sido");
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity<Object>(mapService.sido(), headers, HttpStatus.OK);	
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/gugun/{sidoCode}")
	public ResponseEntity<Object> gugun(@PathVariable("sidoCode") String sidoCode) {
		log.debug("/gugun/" + sidoCode);
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity<Object>(mapService.gugun(sidoCode), headers, HttpStatus.OK);	
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/attractioninfo")
	public ResponseEntity<Object> attractionInfo(@RequestBody HashMap<String, Object> obj) {
		log.debug("/attractioninfo" + " keyword : " + obj.get("keyword").toString());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			

			return new ResponseEntity<Object>(
					mapService.attractionInfo(
							obj.get("sidoCode").toString(), 
							obj.get("gugunCode").toString(), 
							obj.get("attarctionId").toString(), 
							obj.get("keyword").toString()
					), 
					headers, 
					HttpStatus.OK);	
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/attractiondescription/{attractionId}")
	public ResponseEntity<Object> attractionDescription(@PathVariable("attractionId") String attractionId) {
		log.debug("/attractiondescription" + " attractionId : " + attractionId);
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity<Object>(
					mapService.attractionDescription(attractionId), 
					headers, 
					HttpStatus.OK);	
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	}
}
