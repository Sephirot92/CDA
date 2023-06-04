package com.computerdecisionassisting.cda.controller;

import com.computerdecisionassisting.cda.entity.ProjectScore;
import com.computerdecisionassisting.cda.utils.XLSDataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/xlsLoader")
public class XlsController {

    Logger log = LoggerFactory.getLogger(XLSDataLoader.class);

    @PostMapping(path="/v1/uploadCompanyDataFile", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public List<ProjectScore> uploadCompanyDataFile(@RequestPart MultipartFile document) throws IOException {
        InputStream fileInputStream = document.getInputStream();
        File currentDirectory = new File(".");
        String path = currentDirectory.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + document.getOriginalFilename();
        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        int ch = 0;
        while ((ch = fileInputStream.read()) != -1) outputStream.write(ch);
        outputStream.flush();
        outputStream.close();

        List<ProjectScore> bestScores = XLSDataLoader.loadDataToDB(fileLocation);
        log.info("Loading successfull");
        return bestScores;
    }
}
