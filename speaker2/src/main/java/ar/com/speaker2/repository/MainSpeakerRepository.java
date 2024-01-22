package ar.com.speaker2.repository;

import ar.com.speaker2.entity.Speaker;


public class MainSpeakerRepository {

	public static void main(String[] args) {
		SpeakerRepository repository = new MySQLSpeakerRepository();
		
		Speaker speaker = repository.getById(3L);
		
		System.out.println(speaker);
	}

}
