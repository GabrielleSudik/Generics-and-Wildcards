import java.util.ArrayList;

//teacher says this is an advanced topic but useful

class Machine{
	
	//fyi, all classes implicitly extend built-in class Object.
	
	//right-click -- source -- generate toString.
	//hmm, i'm getting an error. so hand-typed:
	
	@Override
	public String toString() {
		return "I'm a machine.";
	}
	
	
}

class Camera extends Machine{
	
	@Override
	public String toString() {
		return "I'm a camera";
	}
}


public class Application {

	public static void main(String[] args) {
		
		//the "list" part of this example is pretty straightforward
		//just showing how you pass an arraylist to a method
		//then the method does its thing.
		ArrayList<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		showList(list);
		
		//this example is more advanced.
		//the type of arraylist is the class Mechine instead of String
		
		ArrayList<Machine> mech = new ArrayList<Machine>();
		mech.add(new Machine());
		mech.add(new Machine());
		showMech(mech);
		
		ArrayList<Camera> camera = new ArrayList<Camera>();
		camera.add(new Camera());
		camera.add(new Camera());
		showCamera(camera);
		
		//here's what WON'T work:
		//showMech(camera);
		//why? because even though Camera is a subclass of Machine,
		//the ArrayList of Camera is not a subclass of ArrayList of Machine.
		//but there IS a way of passing ArrayList<Camera> to Machine...
		//see below.
		
		showMechanism(camera);
		
	}
	
	//the method for "list"
	public static void showList(ArrayList<String> list) {
		
		for (String value: list) {
			System.out.println(value);
		}
	}
	
	//the method for "mech"
	public static void showMech(ArrayList<Machine> mech) {
		
		for (Machine value: mech) {
			System.out.println(value);
		}
	}
	
	//the method for "camera"
	public static void showCamera(ArrayList<Camera> camera) {
		
		for (Camera value: camera) {
			System.out.println(value);
		}
	}
	
	//here is how you pass A.R. Camera to another class's method:
	//you created a new method just to show how it's different from the others.
	//you could have used Machine stuff above if you rewrote it.
	
	//key points: <?> and use of Object as method.
	public static void showMechanism(ArrayList<?> mechanism) {
		
		for (Object value : mechanism) {
			System.out.println("This is the wildcard example.");
		}
	}
	
	//you can also put upper bounds on the parameter
	//the syntax: <? extends Machine>
	//this will limit use of methods to whatever is the parent class
	
	//and you can specify lower bounds too
	//syntax: <? super Camera>
	
	//teacher says this is pretty advanced stuff
	//and not vital info.
}
