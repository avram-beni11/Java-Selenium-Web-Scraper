package org.comparison.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SAQ {

    /*
     * List<WebElement> itemList =
     * driver.findElements(By.xpath(
     * "/html/body/div[2]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div")
     * );
     * 
     * 
     * for (WebElement item : itemList) {
     * try {
     * 
     * item.click();
     * 
     * Thread.sleep(3000);
     * 
     * WebElement expandedDetails =
     * driver.findElement(By.xpath("//div[@class='col-md-7 offset-md-5']//p"));
     * 
     * String details = expandedDetails.getText().trim();
     * 
     * if (!details.isEmpty()) {
     * writer.write(details + "\n\n");
     * }
     * 
     * item.click();
     * 
     * Thread.sleep(3000);
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * 
     */

    public void showHTML() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        WebDriver driver = new ChromeDriver(options);
        driver.get(
                "https://www.margaretriver.com/things-to-do/eat-drink/wineries/?#section-8");

        try {
            // Thread.sleep(11000);
            // driver.findElement(By.xpath("//div[@class='hover-global-header-icon']")).click();
            Thread.sleep(5000);
            // driver.findElement(By.xpath(
            // "//button[@id='truste-consent-button']"))
            // .click();
            // Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // try {
        // Thread.sleep(10000);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        try (FileWriter writer = new FileWriter("Marg River - NAMES.txt", StandardCharsets.UTF_8)) {
            // int totalPages = 108;
            // for (int page = 1; page <= totalPages; page++) {
            // List<WebElement> articleContent = driver
            // .findElements(By
            // .xpath("/html/body/div[1]/div/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div[3]/div[@class='flex
            // flex-wrap -mx-2']"));
            // System.out.println("Length: " + articleContent.size());

            // // WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10
            // seconds
            // // for elements to be present

            // for (int i = 0; i < articleContent.size(); i++) {
            // try {
            // // Re-find elements to avoid StaleElementReferenceException
            // // articleContent = driver
            // // .findElements(By.xpath(
            // //
            // "/html/body/div[1]/main/section[3]/div/div/div/div/div/div[7]/div[3]/div/div/div/div/div[1]/div/div/ul/li[@class='fc-component-text']/div/div[@class='fc-item-content
            // //
            // fc-item-body-text-color']/div[@class='fc-itemcontent-padding']/div[@class='fc-address
            // // fc-css']/div[@class='fc-css fc-location']"));
            // // WebElement link = articleContent.get(i);
            // // String hrefs = link.getText();
            // // System.out.println(hrefs);
            // // String romNames = link.getText();
            // // driver.get(hrefs);

            // // System.out.println(hrefs);
            // // Thread.sleep(10000);
            // // Wait for address element to be visible
            // // WebElement addressElement =
            // // wait.until(ExpectedConditions.visibilityOfElementLocated(
            // // By.xpath(
            // //
            // "//div//div[1]//div[4]//div[2]//div//div//div//div//ul//li[1]//div[2]//div[1]//pre")));
            // String pageElement = driver.findElement(By.xpath(
            // "/ul/li[@class='fc-component-text']/div/div[2]/div/div/div[@class='fc-address
            // fc-css']"))
            // .getText();

            // System.out.println(pageElement);
            // // // Scroll to the address element using JavaScript
            // // ((JavascriptExecutor)
            // // driver).executeScript("arguments[0].scrollIntoView(true);",
            // addressElement);

            // // String address = addressElement.getText();
            // // writer.write(hrefs + "\n");
            // // System.out.println(address);

            // // driver.navigate().back();
            // // Thread.sleep(1000); // Add a delay before proceeding to the next iteration
            // } catch (Exception e) {
            // e.printStackTrace();
            // }
            // }

            // // WebElement nextPageButton = driver.findElement(
            // // By.xpath(
            // //
            // "//*[@id=\"page-content\"]/section[3]/div/div/div/div/div/div[7]/div[4]/a[@class='next']"));
            // // String nextPageUrl = nextPageButton.getAttribute("href");
            // // if (nextPageUrl != null && !nextPageUrl.isEmpty()) {
            // // Thread.sleep(2000);
            // // ((JavascriptExecutor)
            // // driver).executeScript("arguments[0].scrollIntoView(true);",
            // nextPageButton);
            // // nextPageButton.click();
            // // // Thread.sleep(10000); // Wait for the next page to load
            // // } else {
            // // break; // Exit loop if there is no next page
            // // }
            // // }
            List<WebElement> itemList = driver.findElements(By.xpath(
                    "//div[@class='xs:grid xs:grid-cols-2 lg:grid-cols-3 xl:block']"));

            for (WebElement item : itemList) {
                try {

                    // item.click();
                    Thread.sleep(3000);
                    WebElement expandedDetails = item
                            .findElement(By.xpath(
                                    "//div[@class='relative flex-grow']//div[@class='xs:grid xs:grid-cols-2 lg:grid-cols-3 xl:block']//section[@class='p-4 pb-0 hover:bg-blue-100 rounded-lg xl:rounded-none']//div[@class='flex flex-col xl:flex-row pb-4 border-b md:border-none xl:border-b border-gray-300']//div[@class='w-full xl:w-2/3']//div[@class='p-4']//h3[@class='mb-2 font-medium text-md leading-5 tracking-wide']"));

                    // String details = expandedDetails.getText().trim();
                    String address = expandedDetails.getText();
                    if (!address.isEmpty()) {
                        writer.write(address + "\n");
                        System.out.println(address);
                    }

                    // item.click();

                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // driver.quit();
    }

    public static void main(String[] args) {
        SAQ scraper = new SAQ();
        scraper.showHTML();
    }
}
