package ar.com.speaker2.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ar.com.speaker2.entity.Speaker;
import ar.com.speaker2.repository.MySQLSpeakerRepository;
import ar.com.speaker2.repository.SpeakerRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/speaker")
public class NewSpeakerController extends AppBaseController{
	
	private SpeakerRepository repository = new MySQLSpeakerRepository();
	
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response) 
		throws ServletException, IOException	{
		
		String json = super.toJson(request);
		
		SpeakerRequest speakerRequest = super.mapper.readValue(json, SpeakerRequest.class);
		
		if(speakerRequest.getName() == null || speakerRequest.getSurname() == null || speakerRequest.getTopic() == null || speakerRequest.getEmail() == null) {
			
		}
		
		SpeakerRepository repository = new MySQLSpeakerRepository();
		Speaker speaker = new Speaker(speakerRequest.getName(), speakerRequest.getSurname(), speakerRequest.getTopic(), speakerRequest.getEmail(), LocalDate.now());	
		
		repository.save(speaker);
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		
		response.getWriter().print(mapper.writeValueAsString(speaker));
		
		System.out.println("ok");
	}
	
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
			
			List<Speaker> speakers = this.repository.findAll();
			
			String jsonToSendToFrontend = super.mapper.writeValueAsString(speakers);

			response.setStatus(HttpServletResponse.SC_OK);
			
			response.getWriter().print(jsonToSendToFrontend);
			
			
	}

	protected void doDelete(
			HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
			String id = req.getParameter("id");
		
			this.repository.delete(Long.parseLong(id));
		
			resp.setStatus(HttpServletResponse.SC_OK);
	
	}
	
	protected void doPut(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
			String id = request.getParameter("id");
			
			String json = super.toJson(request);

			SpeakerRequest speakerRequest = super.mapper.readValue(json, SpeakerRequest.class);			
			
			Speaker speaker = repository.getById(Long.parseLong(id));
				
			speaker.setName(speakerRequest.getName());
			speaker.setSurname(speakerRequest.getSurname()); 
			speaker.setTopic(speakerRequest.getTopic()); 
			speaker.setEmail(speakerRequest.getEmail()); 

			repository.update(speaker);
			
			response.setStatus(HttpServletResponse.SC_OK);	
	}
}