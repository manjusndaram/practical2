import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PracticalTwo {
	public static void main(String[] args) {
		try {
			String path = "src/data.txt";
			doesFileExists(path);// If the path is not found then will throw FileNotFoundException
			File file  = new File(path);
			Scanner scanner = new Scanner(file);
			int word  = 1;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] wordAndMeaningArray = getWordAndMeanings(line);
                String[] meanings = getMeanings(wordAndMeaningArray[1]); 				
				System.out.println("Word "+ word +": "+ wordAndMeaningArray[0]);
				for (int i = 0, j = 1; i < meanings.length; i++, j++) {					
					System.out.println("Meaning "+ j +":" + meanings[i]);					
				}
				word++;
				System.out.println();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	private static File doesFileExists(String path) throws FileNotFoundException {
		return new File(path);
	}
	
	private static String[] getWordAndMeanings(String line){
		return line.split("--");
	}
	
	private static String[] getMeanings(String line) {
		return line.split(",");
	}
	

}
