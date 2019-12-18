package co.simplon.events.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.events.model.Evenement;

@RestController
public class EventController {

	List<Evenement> eventList;
	
	public EventController() {
		
	eventList = new ArrayList<Evenement>(Arrays.asList(
			new Evenement("13/12/2019", "Les Millevaches", "Meymac", "Concentration hivernale sous la neige.", "https://www.andre-harley.com/medias/images/affiche-20millevaches-202019.jpg"),
			new Evenement("11/01/2020", "Les Ardéchouilles", "Lalouvesc", "Concentration hivernale organisée par des jeunes.","https://i.servimg.com/u/f83/17/72/22/87/tm/ardech11.jpg"),
			new Evenement("31/01/2020", "Liberty Riders", "Rochefort", "Concentration hivernale : bonne humeur assurée !", "https://i1.wp.com/papymoto.fr/wp-content/uploads/2019/12/5e-Hivernale-Liberty-Rider-Genouill%C3%A9-17.jpg?fit=679%2C960&ssl=1?v=1575855919")
			));
	}
	//endpoint pour afficher un message sur la page web
	@RequestMapping("/evenement")
	public String partagerEvenement() {
		return "Partager un évènement !";
	}
	
	//endpoint pour afficher la liste d'objet sur la page web
	@RequestMapping("/events")
	public List<Evenement> getEvenementList() {

		return eventList;
	}
	
	//endpoint pour faire une recherche par id
	@RequestMapping("/search")
	public ResponseEntity<Evenement> getEvenement(@RequestParam(value = "id") int id) {
		for (Evenement evenement : eventList) {
			if(evenement.getId() == id)
				return ResponseEntity.ok(evenement);
		}
		return ResponseEntity.notFound().build();
	}
	
	//endpoint pour ajouter un élément dans la liste
	@RequestMapping("/ajout")
	public List<Evenement> addEvent(
			@RequestParam(value = "date") String date, 
			@RequestParam(value = "titre") String titre, 
			@RequestParam(value = "ville") String ville, 
			@RequestParam(value = "details") String details, 
			@RequestParam(defaultValue = "image/evenement.jpg",
			value = "image") String image){
		eventList.add(new Evenement(date, titre, ville, details, image));
		
		return eventList;
	}
	 
	//endpoint pour renvoyer vers le template 404.html
    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        return "404";
    }
}
