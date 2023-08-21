package com.cb.testing.pages.cb.ts.TsVietnam;

import com.cb.testing.helper.DbHelper;
import com.cb.testing.pages.demo.BasePage;
import lombok.Getter;
import net.thucydides.core.annotations.Step;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Getter
public class SyncCandidatePage extends BasePage {

    public static final String API_SYNC = "https://careers.ttcsugar.com.vn/system/updateapply?job_id=%s";

    public void navigateSyncCandidatePage(String filePath) {
            try {
                // Create a Workbook object from the Excel file
                FileInputStream file = new FileInputStream(new File(filePath));
                Workbook workbook = WorkbookFactory.create(file);
                List<String> idList = new ArrayList<>();

                // Get the Sheet object
                Sheet sheet = workbook.getSheetAt(0);
                HttpClient client = HttpClient.newHttpClient();

                int countNumber = 0;

                for(int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++){
                    Row row = sheet.getRow(rowIndex);
                    Cell cell = row.getCell(0);
                    String jobID = cell.getStringCellValue();
                    idList.add(jobID);
                    //create an HTTP request
                }
                file.close();

                idList.forEach(
                        jobId ->{
                            String apiUrl = String.format(API_SYNC, jobId);

                            HttpRequest request = HttpRequest.newBuilder()
                                    .uri(URI.create(apiUrl))
                                    .build();

                            //Send the HTTP Request and get the response
                            HttpResponse<String> response = null;
                            try {
                                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Job ID: " + jobId);
                            System.out.println(response.body());
                        }
                );

                countNumber++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


//    public void navigateSyncCandidatePage(ResultSet jobIds) throws InterruptedException {
//        openUrl("google.com");
//
//    }
