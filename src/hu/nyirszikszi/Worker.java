package hu.nyirszikszi;

public class Worker {
	private String name;
	private int year;
	private String job;
	
	Worker(String name, int year, String job) {
		this.name = name;
		this.year = year;
		this.job = job;
	}
	
	String getName() {
		return name;
	}
	
	int getYear() {
		return year;
	}
	
	String getJob() {
		return job;
	}
	
	@Override
	public String toString() {
		return "Worker{name='" + name + "', year=" + year + ", job='" + job + "'}";
	}
}