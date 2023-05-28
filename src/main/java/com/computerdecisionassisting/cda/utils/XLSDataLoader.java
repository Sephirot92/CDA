package com.computerdecisionassisting.cda.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class XLSDataLoader {

    static Logger logger = LoggerFactory.getLogger(XLSDataLoader.class);

    private static List<String> forbiddenValues = new ArrayList<>(Arrays.asList("Nazwa projektu", "Dochody", "Liczba Pracowników", "Ocena Klientów", "SLA", "Ocena wewnętrzna", "Obciążenie zespołu"));

    public static void loadDataToDB() {
        FileInputStream input = null;
        XSSFWorkbook wb = null;
        XSSFSheet sheet = null;
        Iterator<Row> rowIterator = null;
        try {
            input = new FileInputStream("C:\\Users\\lczap\\IdeaProjects\\cda\\src\\main\\resources\\xsl\\3dane.xlsx");
            wb = new XSSFWorkbook(input);
            sheet = wb.getSheetAt(0);
            rowIterator = sheet.iterator();
        } catch (FileNotFoundException fnfe) {
            logger.error(fnfe.getMessage());
        } catch (IOException ioe) {
            logger.error(ioe.getMessage());
        }

        if (!rowIterator.hasNext()) {
            logger.error("File not found");
            return;
        }

        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.setCellType(CellType.STRING);
                if (!forbiddenValues.contains(cell.getStringCellValue()))
                    if (Objects.requireNonNull(cell.getCellType()) == CellType.STRING) {
                        System.out.println(cell.getStringCellValue());
                    } else {
                        logger.warn("Unable to proceed with this type of cell.");
                    }
            }
        }
    }

    public static void main(String[] args) {
        loadDataToDB();
    }

}
