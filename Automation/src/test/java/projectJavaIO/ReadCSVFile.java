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

			String csvfilepath = System.getProperty("user.dir")+"\\src\\test\\resources\\basses.csv";
			BufferedReader lineRead = new BufferedReader(new FileReader(csvfilepath));
			CSVParser records = CSVParser.parse(lineRead,CSVFormat.EXCEL);
			Map<String,Bass> MakeModelMap = new HashMap<String,Bass>();

			for(CSVRecord record:records) {
				Bass csvbasses = new Bass();

				csvbasses.setMake(record.get(0));
				csvbasses.setModel(record.get(1));

				MakeModelMap.put(record.get(0),csvbasses);
			}

			Collection collection=MakeModelMap.values();
			Iterator iterator=collection.iterator();
			while(iterator.hasNext()!=false) {
				Bass csvfile = (Bass) iterator.next();
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

