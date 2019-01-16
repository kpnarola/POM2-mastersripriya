package pageObjectModel;

import org.testng.annotations.Test;

public class TestSuite extends BaseTest {

   RegistrationPage reg = new RegistrationPage();
   BooksPage books = new BooksPage();
   ComputerPage com = new ComputerPage();
   JewelryPage jew = new JewelryPage();
   Electronics elec = new Electronics();
   HomePage home = new HomePage();
   CrossBrowser cross =new CrossBrowser();

   @Test (priority = 1)
    public void userShouldBeAbletoRegisterSuccessfully()

   {
        reg.userRegisteration();
   }

   @Test(priority = 2)
   public void sendEmailWithProductSuccessfully()
   {
      books.sendEmail();

   }
    @Test(priority = 3)
    public void userNeedToAcceptTermsAndConditions()
   {
      com.acceptTermsAndConditions();
   }

   @Test(priority = 4)
   public void unRegisteredUserShouldNotBeAbleToSendEmail()

   {
      jew.unRegisteredUser();
   }
   @Test(priority = 5)
   public void  userAbletoSortByPriceHightoLow()

   {
      books.sortByPriceHightoLow();
   }

   @Test(priority = 6)
   public void registeredUserBuyProductSuccessfully()
   {
      elec.registeredUserBuyProduct();
   }

   @Test(priority = 7)
   public void  verifyAddtoCartButtononHomePage()
   {
      home.verifyAddtoCartButton();

   }
   @Test(priority = 8)
   public void currencyConvertForAllProduct()
   {
       home.currencyConvertor();
   }



}








