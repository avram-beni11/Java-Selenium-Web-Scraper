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

public class MultiWinery {

    public void showHTML() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        WebDriver driver = new ChromeDriver(options);
        driver.get(
                "https://demeter.net/demeter-products/wine/wineries/");

        try {

            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter("multiple importers - addresses.txt", StandardCharsets.UTF_8)) {
            int totalPages = 108;
            for (int page = 1; page <= totalPages; page++) {
                List<WebElement> articleContent = driver
                        .findElements(By
                                .xpath("/html/body/div[1]/main/section[3]/div/div/div/div/div/div[7]/div[3]/div/div"));

                for (WebElement addresses : articleContent) {
                    try {
                        String pageElement = addresses
                                .findElement(By
                                        .xpath("/ul/li[@class='fc-component-text']/div/div[2]/div/div/div[@class='fc-address fc-css']"))
                                .getText();

                        System.out.println(pageElement);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                WebElement nextPageButton = driver.findElement(
                        By.xpath(
                                "//*[@id=\"page-content\"]/section[3]/div/div/div/div/div/div[7]/div[4]/a[@class='next']"));
                String nextPageUrl = nextPageButton.getAttribute("href");
                if (nextPageUrl != null && !nextPageUrl.isEmpty()) {
                    Thread.sleep(2000);
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextPageButton);
                    nextPageButton.click();
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MultiWinery scraper = new MultiWinery();
        scraper.showHTML();
    }
}
