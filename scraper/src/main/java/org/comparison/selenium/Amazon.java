//package org.comparison.selenium;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.*;
//import java.util.List;
//
///** Demonstrates how you can use Selenium Chrome Driver to access data from websites
//    that load data dynamically with JavaScript */
//public class Amazon {
//
//    MangaDao dao;
//
//    Amazon() {
//        dao = new MangaDao();
//        dao.init();
//    }
//
//    /** Demonstrates use of ChromeDriver with Selenium */
//    public void showHTML(){
//        //We need an options class to run headless - not needed if we want default options
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(false);
//
//        //Create instance of web driver - this must be on the path.
//        WebDriver driver = new ChromeDriver(options);
//
//        //Navigate Chrome to page.
//        driver.get("https://www.amazon.co.uk/s?k=black+clover&i=stripbooks");
//
//        //Wait for page to load
//        try {
//            Thread.sleep(3000);
//        }
//        catch(Exception ex){
//            ex.printStackTrace();
//        }
//
//        List<WebElement> mangaList = driver.findElements(By.cssSelector("div.s-card-container"));
////=======================================================================================================================
//        for (WebElement manga : mangaList) {
//
//            String links = manga.findElement(By.cssSelector("h2.a-size-mini")).getAttribute("href");
//            driver.get(links);
//            System.out.println(links);
//
//            Manga manga1 = new Manga();
//
//            //String description=  driver.findElement(By.cssSelector("div.a-expander-content")).getText();
//            manga1.setDescription("description");
//
////            String publisher = driver.findElement(By.cssSelector("span.a-list-item")).getText();
////            String publisherReplaced = publisher.replace("Publisher:", "");
////            System.out.println(publisherReplaced);
//            manga1.setPublisher("publisherReplaced");
//
//            driver.navigate().back();
//
////            WebElement coverElement = driver.findElement(By.className("s-image"));
////            String cover = coverElement.getAttribute("src");
//            manga1.setCover_url("cover");
//
////            manga1.setAuthor(manga.findElement(By.cssSelector("h4.search-item__contributor")).getText());
////            manga1.setTitle(manga.findElement(By.cssSelector("span.a-size-medium")).getText());
//            manga1.setAuthor("a");
//            manga1.setTitle("ti");
//
////=======================================================================================================================
//            String links2 = manga.findElement(By.cssSelector("span.rush-component")).getAttribute("href");
//            driver.get(links2);
//
//            Manga_Volume volume = new Manga_Volume();
//
////            String stringISBN = driver.findElement(By.cssSelector("span.a-list-item")).getText();
////            System.out.println(stringISBN);
//            //long isbn = Long.parseLong(stringISBN.replace("ISBN:", ""));
//            volume.setISBN(123);
//
//            driver.navigate().back();
//
//            //String format = driver.findElement(By.cssSelector("a.a-size-base")).getText();
//            //String formatTrim = format.replace("Format:", "").replace("/ softback", "");
//            //System.out.println(format);
//            volume.setFormat("fo");
//            volume.setManga(manga1);
////=======================================================================================================================
//            Comparison comparison = new Comparison();
//            comparison.setManga_volume(volume);
////
////            String stringPrice = manga.findElement(By.cssSelector("p.price")).getText();
////            String trimPrice = stringPrice.replace("£", "");
////            float price = Float.parseFloat(trimPrice);
//            comparison.setPrice(12);
//
//            String volURL = manga.findElement(By.cssSelector("span.rush-component")).getAttribute("href");
//            comparison.setSite_url(volURL);
//
//            try {
//                //Save data with merging to avoid duplicates
//                dao.saveAndMerge(comparison);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        //Exit driver and close Chrome
//        driver.quit();
//    }
//
//}