package com.cb.testing.pages.cb.ts.TsVietnam;

import com.cb.testing.constant.TsVietnam.MappingTsOwnerPageConstant;
import com.cb.testing.test.cb.ts.TsVietnamModuleTest.MappingTsOwnerTest;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.FindBy;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Getter
public class MappingTsOwnerPage extends BaseMappingPage {

    private static final String MAPPING_PATH = "logs/domain-config";

    @FindBy(xpath = "//input[@name ='url_domain[]' and @value='']")
    private WebElementFacade ownerMappingDomainBox;

    @FindBy(xpath = "//input[@name ='owner_domain[]' and @value='']")
    private WebElementFacade ownerMappingNameBox;


    public void navigateToMappingPage(String filePath) {
        try {
            // Create a Workbook object from the Excel file
            FileInputStream file = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(file);
            List<String> ownerMappingId = new ArrayList<>();

            // Get the Sheet object
            Sheet sheet = workbook.getSheetAt(0);

            int countNumber = 0;

            for(int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++){
                Row row = sheet.getRow(rowIndex);
                Cell cell = row.getCell(0);
                String ownerMappingName = cell.getStringCellValue();
                ownerMappingId.add(ownerMappingName);
            }
            file.close();

            openUrl(MAPPING_PATH);
            ownerMappingId.forEach(
                    ownerMappingName ->{
                        ownerMappingDomainBox.sendKeys(ownerMappingName);
                        ownerMappingNameBox.sendKeys("ownerMappingDomain");

                        ;

//                        String apiUrl = String.format(API_SYNC, jobId);
//
//                        HttpRequest request = HttpRequest.newBuilder()
//                                .uri(URI.create(apiUrl))
//                                .build();
//
//                        //Send the HTTP Request and get the response
//                        HttpResponse<String> response = null;
//                        try {
//                            response = client.send(request, HttpResponse.BodyHandlers.ofString());
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                        System.out.println("Job ID: " + jobId);
//                        System.out.println(response.body());
                    }
            );

            countNumber++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
