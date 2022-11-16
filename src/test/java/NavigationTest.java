import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.DetailsPage;
import pageobjects.HomePage;
import pageobjects.ResultModel;
import pageobjects.ResultsPage;


public class NavigationTest extends BaseWebTest {


    @Test
    @Description("Description test 1")
    public void getElementsTest() {

        HomePage homePage = new HomePage(driver);
        homePage.searchFor("guitarra electrica");

        ResultsPage resultsPage = new ResultsPage(driver);
        ResultModel expectedResultModel = resultsPage.clickOnRandomItem();

        DetailsPage detailsPage = new DetailsPage(driver);
        ResultModel actualResultModel =  detailsPage.getDetailInformation();

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedResultModel.getPrice(),
                        actualResultModel.getPrice(), "prices don't match."),
                () -> Assertions.assertEquals(expectedResultModel.getName(),
                        actualResultModel.getName(), "product names don't match.")
        );
    }

    @Test
    @Description("Description test 2")
    public void getElementsTest2() {

        HomePage homePage = new HomePage(driver);
        homePage.searchFor("iphone");

        ResultsPage resultsPage = new ResultsPage(driver);
        ResultModel expectedResultModel = resultsPage.clickOnRandomItem();

        DetailsPage detailsPage = new DetailsPage(driver);
        ResultModel actualResultModel =  detailsPage.getDetailInformation();

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedResultModel.getPrice(),
                        actualResultModel.getPrice(), "prices don't match."),
                () -> Assertions.assertEquals(expectedResultModel.getName(),
                        actualResultModel.getName(), "product names don't match.")
        );
    }

    @Test
    @Description("Description test 3")
    public void getElementsTest3() {

      Assertions.assertTrue(false);
    }
}
