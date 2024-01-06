//package org.comparison.selenium;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.*;
//import java.util.List;
//
///** Demonstrates how you can use Selenium Chrome Driver to access data from websites
// that load data dynamically with JavaScript */
//public class Wordery {
//
//    /**
//     * Demonstrates use of ChromeDriver with Selenium
//     */
//    MangaDao dao;
//
//    Wordery() {
//        dao = new MangaDao();
//        dao.init();
//    }
//
//    public void showHTML() {
//        String item = "manga";
//        //We need an options class to run headless - not needed if we want default options
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(false);
//
//        //Create instance of web driver - this must be on the path.
//        WebDriver driver = new ChromeDriver(options);
//
//        //Navigate Chrome to page.
//        driver.get("https://wordery.com/search?term=my+hero");
//
//        //Wait for page to load
//        try {
//            Thread.sleep(3000);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        //Output details for individual products
//        List<WebElement> mangaList = driver.findElements(By.cssSelector("div.c-book.c-book--auto-portrait"));
////=====================================================================================================================
//        for (WebElement manga : mangaList) {
//
//            String links = manga.findElement(By.cssSelector("a.c-book__media")).getAttribute("href");
//            driver.get(links);
//            System.out.println(links);
//            Manga manga1 = new Manga();
//
//            manga1.setDescription(manga.findElement(By.cssSelector("div.js-details-expand")).getText());
//            manga1.setPublisher(manga.findElement(By.cssSelector("div.o-dl-inline")).getText());
//
//            driver.navigate().back();
//
//            String coverURL = driver.findElement(By.cssSelector("img.o-sized__content")).getAttribute("href");
//            manga1.setCover_url(coverURL);
//
//            manga1.setAuthor(manga.findElement(By.cssSelector("span.c-book__by")).getText());
//            manga1.setTitle(manga.findElement(By.className("c-book__title")).getText());
////=====================================================================================================================
//            String links2 = manga.findElement(By.cssSelector("a.c-book__media")).getAttribute("href");
//            driver.get(links2);
//            Manga_Volume volume = new Manga_Volume();
//
//            volume.setISBN(123); //isbn is in a <dd> element, bunched up with other information
//            driver.navigate().back();
//
//            String rawFormat = driver.findElement(By.cssSelector("small.c-book__meta")).getText();
//            rawFormat = rawFormat.replace("(", "");
//            rawFormat = rawFormat.replace(")", "");
//            String[] parts = rawFormat.split(",");
//            for (int i = 0; i < parts.length; i++) {
//                parts[i] = parts[i].trim();
//            }
//            String format = parts[1];
//            volume.setFormat(format);
//            volume.setManga(manga1);
////=====================================================================================================================
//            Comparison comparison = new Comparison();
//
//            comparison.setManga_volume(volume);
//
//            String priceString = manga.findElement(By.cssSelector("span.c-book__price")).getText();
//            String[] partsPrice = priceString.split(" ");
//            String value = partsPrice[0];
//            value = value.replace("£", "");
//            float price = Float.parseFloat(value);
//            comparison.setPrice(price);
//
//
//            String volURL = manga.findElement(By.cssSelector("a.c-book__media")).getAttribute("href");
//            comparison.setSite_url(volURL);
//
//            try {
//                dao.saveAndMerge(comparison);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        //Exit driver and close Chrome
//        driver.quit();
//    }
//}
//
//
