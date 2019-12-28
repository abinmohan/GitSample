package Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getdata(String testcasename) throws IOException
	{
		ArrayList<String> arr= new ArrayList<String>();
		FileInputStream file = new FileInputStream("F:\\Aby\\DemoData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) 
		{
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> row = sheet.iterator();

				Row FirstRow = row.next();

				Iterator<Cell> cell = FirstRow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) 
					{
						coloumn = k;
					}
					
					k++;
				}

				System.out.println(coloumn);
				 
				System.out.println("branch");

				while (row.hasNext())
				{
					Row r = row.next();
					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcasename)) {
						Iterator<Cell> CV = r.cellIterator();
						while (CV.hasNext()) {
							//System.out.println(CV.next().getStringCellValue());
							//arr.add(CV.next().getStringCellValue());
							Cell c=CV.next();
							if(c.getCellTypeEnum()==CellType.STRING)
							{
							//System.out.println(cv.next().getStringCellValue());
								arr.add(c.getStringCellValue()); //adding value to array
							}
							else
							{
								arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								
							}
						}
					}

				}
			}
		}
		return arr;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	}

}
