import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeveloperController {
	
	private DeveloperDAO developerDAO;
	
	public DeveloperController() {
		developerDAO = new DeveloperDAO();
	}
	
	public String developerById(int id) throws IOException {
		if (developerDAO.getById(id) == null)
			return null;
		return developerDAO.getById(id).toString();
	}
	
	public void newDeveloper() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Developer developer = new Developer();
		System.out.print("Enter firstName:  ");
		developer.setFirstName(reader.readLine());
		System.out.print("Enter lastName:  ");
		developer.setLastName(reader.readLine());
		System.out.print("Enter specialty:  ");
		developer.setSpecialty(reader.readLine());
		System.out.print("Enter experience:  ");
		developer.setExperience(Integer.parseInt(reader.readLine()));
		System.out.print("Enter salary:  ");
		developer.setSalary(Integer.parseInt(reader.readLine()));
		System.out.println();
		
		developerDAO.saveDeveloper(developer);
	}
	
	public void newDeveloper(String firstName, String lastName, String specialty, int experience, int salary) throws IOException {
		Developer developer = new Developer (firstName, lastName, specialty, experience, salary);
		developerDAO.saveDeveloper(developer);
	}
	
	public void editDeveloper(int id) throws IOException {
		Developer developer = developerDAO.getById(id);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("What do you want to edit?");
		System.out.println("1. First name \n"
				+ "2. Last name \n" 
				+ "3. Specialty \n"
				+ "4. Experience \n"
				+ "5. Salary \n"
				+ "6. Stop editing & save");
		String com = reader.readLine();
		try {
		switch (com) {
		case "1":
			System.out.println("Enter new first name");
			developer.setFirstName(reader.readLine());
			developerDAO.saveDeveloper(developer);	
			editDeveloper(id);
			break;
		case "2":
			System.out.println("Enter new last name");
			developer.setLastName(reader.readLine());
			developerDAO.saveDeveloper(developer);	
			editDeveloper(id);
			break;
		case "3":
			System.out.println("Enter new specialty");
			developer.setSpecialty(reader.readLine());
			developerDAO.saveDeveloper(developer);	
			editDeveloper(id);
			break;
		case "4":
			System.out.println("Enter new experience");
			developer.setExperience(Integer.parseInt(reader.readLine()));
			developerDAO.saveDeveloper(developer);	
			editDeveloper(id);
			break;
		case "5":
			System.out.println("Enter new salary");
			developer.setSalary(Integer.parseInt(reader.readLine()));
			developerDAO.saveDeveloper(developer);	
			editDeveloper(id);
			break;
		case "6":
			break;
		default:
			System.err.println("ENTER NUMBER FROM 1 TO 5!!!\n");
			editDeveloper(id);
			break;
		}
		}
		catch (NumberFormatException e) {
            System.err.println("VALUE IS NOT INTEGER!!!");
            editDeveloper(id);
        }
	}
	
	public boolean deleteDeveloper(int id) throws IOException {
		return developerDAO.delete(id);
	}
	
	public String printDevs() {
		return developerDAO.toString();
	}
}
