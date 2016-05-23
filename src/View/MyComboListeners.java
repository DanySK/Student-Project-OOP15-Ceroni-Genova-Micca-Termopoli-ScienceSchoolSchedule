package View;
import ViewBy.*;

public class MyComboListeners {
	
	private MyListenerDays listenerDays = new MyListenerDays();
	private MyListenerRoom listenerRoom = new MyListenerRoom();
	private MyListenerHour listenerHour = new MyListenerHour();
	private MyListenerProf listenerProf = new MyListenerProf();
	private MyListenerCourse listenerCourse = new MyListenerCourse();
	
	public MyListenerRoom getListenerRoom() {
		return listenerRoom;
	}

	public MyListenerHour getListenerHour() {
		return listenerHour;
	}

	public MyListenerProf getListenerProf() {
		return listenerProf;
	}

	public MyListenerCourse getListenerCourse() {
		return listenerCourse;
	}

	public MyListenerDays getListenerDays(){
		return this.listenerDays;
	}

}
