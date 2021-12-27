package projectJavaIO;
import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.Assert;

public class ReadCSVFile {

	public static void main(String[] args) throws FileNotFoundException {
		try {

			String csvfilepath = "C:\\Users\\Regime Cary\\git\\QuintrixTraining\\Automation\\src\\test\\resources\\basses.csv";
			BufferedReader lineRead = new BufferedReader(new FileReader(csvfilepath));
			CSVParser records = CSVParser.parse(lineRead,CSVFormat.EXCEL);
			Map<String,ReadCSVFileBasses> MakeModelMap = new HashMap<String,ReadCSVFileBasses>();

			for(CSVRecord record:records) {
				ReadCSVFileBasses csvbasses = new ReadCSVFileBasses();

				csvbasses.setMake(record.get(0));
				csvbasses.setModel(record.get(1));

				MakeModelMap.put(record.get(0),csvbasses);
			}

			Collection collection=MakeModelMap.values();
			Iterator iterator=collection.iterator();
			while(iterator.hasNext()!=false) {
				ReadCSVFileBasses csvfile = (ReadCSVFileBasses) iterator.next();
				System.out.println(csvfile.getMake()+" "+csvfile.getModel());
			}

			Assert.assertTrue(MakeModelMap != null);

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}  
}

