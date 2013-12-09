package net.njay.njaypi.Counters;

public class Time {
	private int seconds, minutes, hours = 0;
	
	public Time() {
		
	}
	
	public Time(int s, int m, int h) {
		this.seconds = s;
		this.minutes = m;
		this.hours = h;
	}
	
	public boolean at0() {
		if (seconds <= 0 && minutes <= 0 && hours <= 0) {
			return true;
		} else {
			return false;
		}
		 
	}
	
	public boolean greaterThanOrEqualTo(Time t) {
		if (this.hours > t.getHours()) {
			return true;
		} else if (this.minutes > t.getMinutes()) {
			return true;
		} else if (this.minutes >= t.getSeconds()) {
			return true;
		}
		return false;
	}
	
	public void add(int s, int m, int h) {
		this.seconds += s;
		this.minutes += m;
		this.hours += h;
	}
	public void subtract (int s, int m, int h) {
		this.seconds -= s;
		this.minutes -= m;
		this.hours -= h;
	}
	public boolean tickDown() {
		if (seconds >= 1){
			seconds--;
		}else{
			if (minutes >= 1){
				minutes--;
				seconds = 59;
			}else{
				if (hours >= 1){
					hours--;
					minutes = 59;
					seconds = 59;
				} else {
					return true;
				}
			}
		}
		return false;
	}
	public void tickUp() {
		seconds++;
		if (seconds >= 60) {
			minutes++;
			seconds = 0;
		} else if (minutes >= 60) {
			hours++;
			minutes = 0;
		}
	}
	public int getSeconds() {
		return this.seconds;
	}
	public int getMinutes() {
		return this.minutes;
	}
	public int getHours() {
		return this.hours;
	}
	public void setSeconds(int s) {
		this.seconds = s;
	}
	public void setMinutes(int m) {
		this.minutes = m;
	}
	public void setHours(int h) {
		this.hours = h;
	}
	public String getTime(String format) {
		return format.replaceAll("&s", String.valueOf(seconds)).replaceAll("&h", String.valueOf(hours)).replaceAll("&m", String.valueOf(minutes));
	}
	public String getTime() {
		if (hours == 0) {
			return minutes + " Minutes " + seconds + " Seconds";
		} else {
			return hours + " Hours " + minutes + " Minutes " + seconds + " Seconds"; 
		}
	}
}
