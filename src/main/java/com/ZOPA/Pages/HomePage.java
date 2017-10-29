package com.ZOPA.Pages;

import com.ZOPA.Support.ElementUtils;
import org.openqa.selenium.By;

/**
 * Created by RajeshG on 28/10/2017.
 */
public class HomePage {

  ElementUtils utils=new ElementUtils();


     private final String LOAD_LOANS_PAGE="//h1[text()='Simple loans. Smart investments.']/following-sibling::div//a[text()='Get a Zopa loan']";

   public void assertHomePage() {
       utils.assertURL("https://www.zopa.com/");
   }

    public void navigateToLoansPage()  {
        utils.clickBtn(By.xpath(LOAD_LOANS_PAGE));



    }
}
