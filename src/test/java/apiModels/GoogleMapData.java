package apiModels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GoogleMapData {

	private String text;
	private GoogleMapData distance;
	private GoogleMapData duration;
	private List<GoogleMapData> legs;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public GoogleMapData getDistance() {
		return distance;
	}
	public void setDistance(GoogleMapData distance) {
		this.distance = distance;
	}
	public GoogleMapData getDuration() {
		return duration;
	}
	public void setDuration(GoogleMapData duration) {
		this.duration = duration;
	}
	public List<GoogleMapData> getLegs() {
		return legs;
	}
	public void setLegs(List<GoogleMapData> legs) {
		this.legs = legs;
	}

	
	
}

