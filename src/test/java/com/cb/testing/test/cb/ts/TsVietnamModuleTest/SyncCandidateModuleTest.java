package com.cb.testing.test.cb.ts.TsVietnamModuleTest;

import com.cb.testing.pages.cb.ts.TsVietnam.SyncCandidatePage;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;


@ExtendWith(SerenityJUnit5Extension.class)
public class SyncCandidateModuleTest {

    @Managed()
    WebDriver webDriver;

    @Steps
    SyncCandidatePage syncCandidate;

    @Test
    public void syncCandidateByJobID() throws InterruptedException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\test-data\\180823-ttcsugar.xlsx";

        syncCandidate.navigateSyncCandidatePage(filePath);
    }
}