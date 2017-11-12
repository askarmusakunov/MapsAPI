package apiModels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CustomResponse {

	private List<GoogleMapData> routes;
	private String status;
	
	public List<GoogleMapData> getRoutes() {
		return routes;
	}
	public void setRoutes(List<GoogleMapData> routes) {
		this.routes = routes;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
