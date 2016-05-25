package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Days;
import Model.Hours;
import Model.RoomImpl;

public class ExportToXls implements ExportToXlsxInterface {

	private Map<Integer, ArrayList<String>> data = new TreeMap<>();
	private ControllerWorkers contWork = new ControllerWorkers();
	// Blank workbook
	XSSFWorkbook workbook = new XSSFWorkbook();

	SaveController controller = new SaveController();
	// Create a sheet
	XSSFSheet sheet;

	private void write(XSSFWorkbook workbook) {
		try {
			// Write the workbook in file system

			FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.home")
					+ System.getProperty("file.separator") + "SiencesSchoolSchedul.xls"));
			workbook.write(out);
			out.close();
			System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
		} catch (Exception e) {
			System.out.println("chiudere il file prima di proseguire");
			e.printStackTrace();
		}

	}

	private XSSFWorkbook create(XSSFSheet sheet, XSSFWorkbook workbook) {

		// Iterate over data and write to sheet
		int rownum = 0;
		XSSFCellStyle style6 = workbook.createCellStyle();
		XSSFCellStyle style7 = workbook.createCellStyle();
		for (Integer key : this.data.keySet()) {
			// create a row of excelsheet
			Row row = sheet.createRow(rownum);

			// get object array of prerticuler key
			ArrayList<String> objArr = this.data.get(key);

			int cellnum = 0;
			for (String str : objArr) {
				Cell cell = row.createCell(cellnum);

				if (cellnum == 0 || rownum == 0
						|| (rownum % this.controller.getObjToSave().getListRoom().size() + 1) == 0) { // per
																										// colorare
																										// diversamente
																										// le
																										// ore
																										// e
																										// le
																										// aule
					style6.setFillBackgroundColor(HSSFColor.BLUE_GREY.index);
					style6.setFillPattern(XSSFCellStyle.VERTICAL_CENTER);
					style6.setAlignment(XSSFCellStyle.ALIGN_FILL);
					sheet.setColumnWidth(cellnum, str.length() * 400);
					cell.setCellValue(str);
					cell.setCellStyle(style6);
				} else {
					// style7.setFillBackgroundColor(HSSFColor.AQUA.index);
					style7.setFillBackgroundColor(HSSFColor.LIGHT_BLUE.index);
					style7.setFillPattern(XSSFCellStyle.LESS_DOTS); // senza non
																	// fa lo
																	// sfondo
					// style7.setAlignment(XSSFCellStyle.ALIGN_FILL); // scrive
					// tre volte
					sheet.setColumnWidth(cellnum, str.length() * 400);
					cell.setCellValue(str);
					cell.setCellStyle(style7);
				}
				cellnum++;
			}
			rownum++;
		}
		return workbook;

	}

	private Map<Integer, ArrayList<String>> makeMap() {
		Map<Integer, ArrayList<String>> temp = new HashMap<>();

		Integer i = 0;

		for (Days d : Days.values()) {
			ArrayList<String> hoursArray = new ArrayList<String>();

			hoursArray.add(d.getString());
			for (Hours col : Hours.values()) {// scorro le ore e creo una lista
												// come intestazione
				hoursArray.add(col.getValue());
			}
			temp.put(i++, hoursArray); // inserisco la prima riga della tabella

			for (RoomImpl room : controller.getObjToSave().getListRoom()) { // scorro
																			// la
																			// lista
																			// delle
																			// stanze

				ArrayList<String> array = new ArrayList<>();
				for (Hours h : Hours.values()) {
					array.add(" ");
				}
				array.add(0, room.getNameRoom());
				for (Reservation res : contWork.getByDay(d)) {
					if (res.getRoom().getNameRoom().equals(room.getNameRoom())) {
						array.set(hoursArray.indexOf(res.getHour().getValue()), res.getCourse().getName());
					}
				}
				temp.put(i++, array);
			}

		}

		return temp;
	}

	public void save(String period) {
		this.data = this.makeMap();

		this.sheet = workbook.createSheet(period);

		workbook = this.create(sheet, workbook);

		// make a xls file
		this.write(workbook);

	}
}
