package co.simplon.events.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Evenement {
	
	private static final AtomicInteger ID_FACTORY = new AtomicInteger(0);

	private String date;
	private String titre;
	private String ville;
	private String details;
	private String image;
	private int id;
	

	public Evenement(String date, String titre, String ville, String details, String image) {
	
		this.date = date;
		this.titre = titre;
		this.ville = ville;
		this.details = details;
		this.image = image;
		this.id = ID_FACTORY.getAndIncrement();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public final int getId() {
	      return id;
	   }

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
}
