import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

public class DeveloperDAO {
	
	private String sep = System.getProperty("file.separator");
	private File file = new File("E:" + sep + "jv" + sep + "Devel" + sep + "Developers.dat");
	private TreeSet<Developer> developers;
	
	public DeveloperDAO() {
		developers = new TreeSet<>();
		try {
		if (file.exists())
			getAllDevelopers();
		}
		catch (NumberFormatException a) {
		}
		catch (IOException b) {
		}
	}
	
	public Developer getById(int id) throws IOException{
		if (developers.isEmpty())
			getAllDevelopers();
		for (Developer dev : developers){
			if(dev.getId() == id)
			return dev;
		}
		return null;
	}
	
	public void getAllDevelopers() throws NumberFormatException, IOException {
		Developer developer;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		if (file.length() == 0)
			return;
		String developerStr = "";
		while ((developerStr = reader.readLine()) != null) {		
			String[] developerDim = developerStr.split(", ");
	//		System.out.println(Arrays.toString(developerDim));
			developer = new Developer();
			developer.setId(Integer.parseInt(developerDim[0]));
			developer.setFirstName(developerDim[1]);
			developer.setLastName(developerDim[2]);
			developer.setSpecialty(developerDim[3]);
			developer.setExperience(Integer.parseInt(developerDim[4]));
			developer.setSalary(Integer.parseInt(developerDim[5].trim()));
			developers.add(developer);
			developerStr = "";
		}
		reader.close();
//		System.out.println(this.toString());
	}
	
	public void addAllDevelopers() throws IOException {
		FileWriter writer = new FileWriter(file);
		String tet = this.toString();
			writer.write(tet);
			writer.flush();
			writer.close();
	}
	
	public void saveDeveloper (Developer developer) throws IOException {
		if (file.exists())
			getAllDevelopers();
//		System.out.println("Method started");
		if (developers.isEmpty()){
//			System.out.println("Method work here1");
			developer.setId(1);
			developers.add(developer);
			addAllDevelopers();
			System.out.println(this.toString());
		}
		else {
			if (developers.contains(developer)) {
//				System.out.println("Method work here2");
				developers.remove(developer);
				developers.add(developer);
				addAllDevelopers();
		}
			else {
//				System.out.println("Method work here3");
				FileWriter writer = new FileWriter(file, true);
				developer.setId(developers.last().getId() + 1);
				developers.add(developer);
				writer.write(developer.toString());
				writer.flush();
				writer.close();
			}
		}
//		System.out.println("Method finished " + System.getProperty("user.dir"));
	}
	
	public boolean delete (int id) throws IOException {
		for (Developer dev : developers){
			if (dev.getId() == id){
				developers.remove(dev);
				addAllDevelopers();
				return true;
				}
		}
		return false;
	}
	
	public String toString() {
		if(!file.exists())
			System.err.println("File is not exist!!");
		String devsStr = "";
		for (Developer dev : developers)
				devsStr += dev.toString();
		return devsStr;
	}
}
