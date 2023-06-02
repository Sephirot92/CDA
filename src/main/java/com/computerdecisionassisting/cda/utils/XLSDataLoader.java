package com.computerdecisionassisting.cda.utils;

import com.computerdecisionassisting.cda.entity.ProjectScore;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class XLSDataLoader {

    static Logger logger = LoggerFactory.getLogger(XLSDataLoader.class);

    private static List<String> forbiddenValues = new ArrayList<>(Arrays.asList("Nazwa Projektu", "Dochody", "Liczba Pracowników", "Ocena Klientów", "SLA", "Ocena Wewnętrzna", "Obciążenie zespołu"));

    public static List<ProjectScore> loadDataToDB(String pathToFile) {
        FileInputStream input = null;
        XSSFWorkbook wb = null;
        XSSFSheet sheet = null;
        Iterator<Row> rowIterator = null;
        try {
            input = new FileInputStream(pathToFile);
            wb = new XSSFWorkbook(input);
            sheet = wb.getSheetAt(0);
            rowIterator = sheet.iterator();
        } catch (IOException ioe) {
            logger.error(ioe.getMessage());
        }

        if (!Objects.requireNonNull(rowIterator).hasNext()) {
            logger.error("File not found");
            return null;
        }

        Integer counter = 1;
        List<ProjectScore> projectScores = new ArrayList<>();
        ProjectScore projectScore = new ProjectScore();

        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                cell.setCellType(CellType.STRING);
                if (!forbiddenValues.contains(cell.getStringCellValue()))
                    if (Objects.requireNonNull(cell.getCellType()) == CellType.STRING) {
                        if (counter < 8) {
                            //TODO Refactor this part - 1-7 is to small to cover all posibilities - we won;t be able to get out of the 1st project from xls!!
                            switch (counter) {
                                case 1:
                                    projectScore.setProjectName(cell.getStringCellValue());
                                    break;
                                case 2:
                                    projectScore.setProjectEarnings(new BigDecimal(cell.getStringCellValue()));
                                    break;
                                case 3:
                                    projectScore.setNumberOfEmployees(new BigDecimal(cell.getStringCellValue()));
                                    break;
                                case 4:
                                    projectScore.setClientScore(new BigDecimal(cell.getStringCellValue()));
                                    break;
                                case 5:
                                    projectScore.setSlaValue(new BigDecimal(cell.getStringCellValue()));
                                    break;
                                case 6:
                                    projectScore.setInnerScore(new BigDecimal(cell.getStringCellValue()));
                                    break;
                                case 7:
                                    projectScore.setTeamCoverage(new BigDecimal(cell.getStringCellValue()));
                                    break;
                            }
                            counter++;
                            if (counter == 8) {

                                //calculations
                                projectScore.setTotalProjectScore(projectScore.scoreCalculation());

                                projectScores.add(projectScore);
                                projectScore = new ProjectScore();
                            }
                        }
                    } else {
                        logger.warn("Unable to proceed with this type of cell.");
                    }
            }
            counter = 1;
        }

        Comparator<ProjectScore> projectScoreComparator = Comparator.comparing(ProjectScore::getTotalProjectScore);
        Collections.sort(projectScores, projectScoreComparator);
        Collections.reverse(projectScores);
        List<ProjectScore> bestThreeScores = new ArrayList<>();
        for (int i = 0; i < 3; i++) bestThreeScores.add(projectScores.get(i));


        return bestThreeScores;
    }
}
