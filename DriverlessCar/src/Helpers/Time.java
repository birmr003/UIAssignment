package Helpers;


public final class Time
{
	private int seconds=0;
	private int minutes=0;
	private int hours=0;
	private String seconds_text = String.format("%02d", seconds);
	private String minutes_text = String.format("%02d", minutes);
	private String hours_text = String.format("%02d", hours);
	private String s = "";

    public Time(){
	   	 setTime();
    }
    
    private void add(){
	   	 seconds++;
	   	 if(seconds == 60){
	   		 seconds = 0;
	   		 minutes++;
	   		 if(minutes ==60){
	   			 minutes = 0;
	   			 hours++;
	   		 }
	   	 }
	   	 setTime();
    }
    
    private void setTime(){
	     seconds_text = String.format("%02d", seconds);
	     minutes_text = String.format("%02d", minutes);
	     hours_text = String.format("%02d", hours);
	     s = hours_text + ":" +minutes_text + ":" + seconds_text;
    }
    
    public String time(){
	   	 add();
	   	 return s;
    }
    
}
