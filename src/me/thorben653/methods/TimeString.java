package me.thorben653.methods;

public class TimeString {
	
	public static String fromSecsTominsecsString(int t){
		int minutes = (t % 3600) / 60;
		int seconds = t % 60;

		return String.format("%02d:%02d", minutes, seconds);
	}

}
