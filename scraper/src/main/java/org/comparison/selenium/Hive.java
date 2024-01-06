package org.comparison.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.List;

/** Demonstrates how you can use Selenium Chrome Driver to access data from websites
 that load data dynamically with JavaScript */
public class Hive {

    MangaDao dao;

    Hive() {
        dao = new MangaDao();
        dao.init();
    }

    /**
     * Demonstrates use of ChromeDriver with Selenium
     */
    public void showHTML() {
        //We need an options class to run headless - not needed if we want default options
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);

        //Create instance of web driver - this must be on the path.
        WebDriver driver = new ChromeDriver(options);

        //Navigate Chrome to page.

         //driver.get("https://www.hive.co.uk/Search/Keyword?keyword=black%20clover&productType=1");
        driver.get("https://www.hive.co.uk/Search/Keyword?keyword=Masashi%20Kishimoto%20naruto&productType=0");


        //Wait for page to load
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        List<WebElement> mangaList = driver.findElements(By.cssSelector("div.search-item__wrap"));
//=======================================================================================================================
        for (WebElement manga : mangaList) {

                String links = manga.findElement(By.className("jacket-Book")).getAttribute("href");
                driver.get(links);
                System.out.println(links);

                Manga manga1 = new Manga();

                String description=  driver.findElement(By.cssSelector("div.descriptionWrap")).getText();
                //String descriptionRep = description.replace("Description", "");
                manga1.setDescription(description);

                WebElement coverElement = driver.findElement(By.className("productImage"));
                String cover = coverElement.getAttribute("src");
                manga1.setCover_url(cover);

                String publisher = driver.findElement(By.cssSelector("li.publisher")).getText();
                String publisherReplaced = publisher.replace("Publisher:", "");
                manga1.setPublisher(publisherReplaced);

                driver.navigate().back();

                manga1.setAuthor(manga.findElement(By.cssSelector("h4.search-item__contributor")).getText());
                manga1.setTitle(manga.findElement(By.cssSelector("h3.search-item__title")).getText());
//=======================================================================================================================
                String links2 = manga.findElement(By.className("jacket-Book")).getAttribute("href");
                driver.get(links2);

                Manga_Volume volume = new Manga_Volume();

                String format = driver.findElement(By.cssSelector("li.format")).getText();
                String formatTrim = format.replace("Format:", "").replace("/ softback", "");
                volume.setFormat(formatTrim);

                String stringISBN = driver.findElement(By.cssSelector("li.EAN")).getText();
                long isbn = Long.parseLong(stringISBN.replace("ISBN:", ""));
                volume.setISBN(isbn);

                driver.navigate().back();

                volume.setManga(manga1);
//=======================================================================================================================
                Comparison comparison = new Comparison();
                comparison.setManga_volume(volume);

                String stringPrice = manga.findElement(By.cssSelector("p.price")).getText();
                String trimPrice = stringPrice.replace("£", "");
                float price = Float.parseFloat(trimPrice);
                comparison.setPrice(price);

                String volURL = manga.findElement(By.className("jacket-Book")).getAttribute("href");
                comparison.setSite_url(volURL);

                try {
                    //Save data with merging to avoid duplicates
                    dao.saveAndMerge(comparison);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            //Exit driver and close Chrome
            driver.quit();
        }

    }

