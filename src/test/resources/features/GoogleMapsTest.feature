	Feature: Google Map Test
	@runThis
	Scenario Outline: Data validation of Google Maps UI against API
	Given user goes to "<url>"
	Then user enters origin location "<origin>"
	And user enters destination "<destination>" in mode as driving
	Then user hits googleMapsAPI with "<origin>" and "<destination>"
	And user validates UI data to API data
	
	Examples:
	| 		url				 |   	 origin				|		destination		 |
	|http://maps.google.com/ |San Francisco, CA 94102	|San Francisco, CA 94104 |
	
	
	