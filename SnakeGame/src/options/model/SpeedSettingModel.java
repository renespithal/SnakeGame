package options.model;

import javafx.util.Duration;

public class SpeedSettingModel {
	
	private Duration slow = Duration.seconds(0.2);
	private Duration medium = Duration.seconds(0.1);
	private Duration fast = Duration.seconds(0.1);
	
	private Duration speed;
	
	public Duration getSpeed() {
		return speed;
	}

	public void setSpeed(Duration speed) {
		this.speed = speed;
	}
	
	public Duration getFast() {
		return fast;
	}
	
	public Duration getMedium() {
		return medium;
	}
	
	public Duration getSlow() {
		return slow;
	}
	
	

}
