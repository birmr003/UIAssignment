package Helpers;


public final class Time
{
	int seconds=0;
    int minutes=0;
    int hours=0;
    String seconds_text = String.format("%02d", seconds);
    String minutes_text = String.format("%02d", minutes);
    String hours_text = String.format("%02d", hours);
	String s = "";

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
