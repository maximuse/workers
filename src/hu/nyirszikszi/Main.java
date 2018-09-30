package hu.nyirszikszi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Worker> workers = new ArrayList<>();
		
		try {
			Scanner s = new Scanner(new File("lists.txt"));
			
			while (s.hasNext()) {
				String line = s.nextLine();
				
				String[] array = line.split(";");
				Worker w = new Worker(array[0], Integer.parseInt(array[1]), array[2]);
				workers.add(w);
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		listing(workers);
		System.out.println();
		theYoungestWorker(workers);
		System.out.println();
		getWorkerName("designer", workers);
		getWorkerName("titkárnó", workers);
	}
	
	private static void theYoungestWorker (ArrayList<Worker> workers) {
		int year = workers.get(0).getYear();
		Integer index = null;
		
		for (int i = 0; i < workers.size(); i++) {
			if (year < workers.get(i).getYear()) {
				year = workers.get(i).getYear();
				index = i;
			}
		}
		
		System.out.println(workers.get(index).getName() + " (" + workers.get(index).getYear() + ") - " + workers.get(index).getJob());
	}
	
	private static void getWorkerName (String job, ArrayList<Worker> workers) {
		Integer index = null;
		
		for (int i = 0; i < workers.size(); i++) {
			if (job.equals(workers.get(i).getJob())) {
				index = i;
			}
		}
		
		if (index == null) {
			System.out.println("Nincs találat a(z) \"" + job + "\" kifejezésre.");
		}
		else {
			System.out.println(workers.get(index).getName() + " (" + job + ")");
		}
	}
	
	private static void listing (ArrayList<Worker> workers) {
		for (Object worker : workers) {
			System.out.println(worker);
		}
	}
}