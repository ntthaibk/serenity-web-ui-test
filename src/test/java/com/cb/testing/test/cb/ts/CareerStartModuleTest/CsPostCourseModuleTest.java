package com.cb.testing.test.cb.ts.CareerStartModuleTest;
import com.cb.testing.pages.cb.ts.CareerStart.CsEmployerPostCourse;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@ExtendWith(SerenityJUnit5Extension.class)
public class CsPostCourseModuleTest {

    @Managed()
    WebDriver webDriver;

    CsEmployerPostCourse csEmployerPostCourse;

    @Test
    public void loginWithEmployerAccount() throws InterruptedException{
        csEmployerPostCourse.navigateEmployerLoginPage();
        csEmployerPostCourse.loginWithUsernameAndPassword("ngan7@yopmail.com","Vkook123");
    }

    @Test
    public void postOnlineCourse() throws InterruptedException{
        csEmployerPostCourse.navigateEmployerLoginPage();
        csEmployerPostCourse.loginWithUsernameAndPassword("ngan7@yopmail.com","Vkook123");
        csEmployerPostCourse.clickOnCourseButtonOnMenu();
        csEmployerPostCourse.selectTopicForNewCourse("2");
        csEmployerPostCourse.setInputCourseName("Khóa học tiếng Anh giao tiếp cho người đi làm");
        csEmployerPostCourse.setInputCourseDescription("Đây là khóa học tiếng anh trực tiếp hỗ trợ cho các bạn các lớp tiếng anh giao tiếp bổ sung từ vựng và ngữ pháp, giúp cho các bạn hệ thống hóa các hiện tượng ngữ pháp cơ bản trong tiếng anh như thì, thời, câu bị động, chủ động, các loại câu điều kiện, mệnh đề quan hệ, mạo từ, giới từ…. Bên cạnh đó, các bạn cũng sẽ được học từ vựng theo các chủ đề phục vụ trực tiếp công việc, học tập hay giao tiếp hàng ngày như friends, family, home, housework, shopping, study, jobs…");
        csEmployerPostCourse.setInputCourseIntroduction("Khóa học tiếng Anh giao tiếp tại RES phù hợp cho mọi đối tượng muốn cải thiện kỹ năng speaking English. Với đa dạng các lớp từ căn bản đến nâng cao.\n" +
                "\n" +
                "Nhân viên văn phòng muốn nâng cao khả năng giao tiếp Tiếng Anh.\n" +
                "Người muốn cải thiện sự tự tin khi giao tiếp với đối tác nước ngoài.\n" +
                "Đã từng học các lớp tiếng Anh giao tiếp khác nhưng không hiệu quả.\n" +
                "Người bận rộn có ít thời gian nhưng thích học tiếng Anh");
        csEmployerPostCourse.setInputLessonName("Khóa học nghe nói và phát âm cơ bản");
        csEmployerPostCourse.setInputLessonDescription("Khóa học nghe nói & phát âm chuẩn ngay từ đầu (English Background) tại RES – đây là khóa học được thiết kế phù hợp cho:\n" +
                "\n" +
                "Các bạn mất gốc tiếng Anh hoàn toàn, các bạn chưa biết gì về tiếng Anh.\n" +
                "Các bạn muốn học lại tiếng Anh ngay từ đầu và muốn nâng cao trình độ tiếng Anh.\n" +
                "Các bạn học chuyên ngoại ngữ tiếng Nga, Pháp, Trung… và các bạn học sinh chuyên ban A, các bạn sinh viên chuyên ngành kỹ thuật, xã hội chưa nắm vững tiếng Anh cơ bản.");
        csEmployerPostCourse.setInputNumberOfStudent("100");
        csEmployerPostCourse.setInputCoursePrice("16000000");
        csEmployerPostCourse.setSelectTeacher("31");
        csEmployerPostCourse.setInputDateFrom("12-07-2023");
        csEmployerPostCourse.setInputDateTo("15-08-2023");
//        webDriver.findElement(By.id("date-to")).sendKeys("12-07-2023");
//        webDriver.findElement(By.id("date-from")).sendKeys("15-08-2023");
        csEmployerPostCourse.setUploadCoursePhoto("D:\\pigeon-hole-test\\Image\\image300x300.png");
//        webDriver.findElement(By.id("filephoto")).sendKeys("D:\\pigeon-hole-test\\Image\\image300x300.png");

//        csEmployerPostCourse.setUploadCoursePhoto("D:\\pigeon-hole-test\\Image\\image300x300.png");
        Thread.sleep(1000);
        webDriver.findElement(By.id("filebanner")).sendKeys("D:\\pigeon-hole-test\\Image\\image300x300.png");
        Thread.sleep(1000);
        //csEmployerPostCourse.setUploadCourseBanner("C:\\Users\\hannlb\\Pictures\\CB landingpage_careerstart_banner_Ket noi sinh vien voi he sinh thai_2_389 x 273");
        csEmployerPostCourse.clickOnAddCourseButton();
    }
}

