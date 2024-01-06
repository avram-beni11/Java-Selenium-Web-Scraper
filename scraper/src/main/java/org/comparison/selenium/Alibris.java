//package org.comparison.selenium;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.*;
//import java.util.List;
//
//
///** Demonstrates how you can use Selenium Chrome Driver to access data from websites
// that load data dynamically with JavaScript */
//public class Alibris {
//
//    MangaDao dao;
//
//    Alibris() {
//        dao = new MangaDao();
//        dao.init();
//    }
//
//    /** Demonstrates use of ChromeDriver with Selenium */
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
//        driver.get("https://www.alibris.co.uk/booksearch?mtype=B&title=my+hero+academia");
//
//        //Wait for page to load
//        try {
//            Thread.sleep(3000);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//            List<WebElement> mangaList = driver.findElements(By.cssSelector("ul#works"));
////
////            for(WebElement links: mangaList){
////                String link = links.findElement(By.cssSelector("div.left")).getAttribute("href");
////                driver.get(link);
////                driver.navigate().back();
////            }
//
//            for (WebElement manga : mangaList) {
//
//                String links = manga.findElement(By.cssSelector("div.left")).getAttribute("href");
//                driver.get(links);
//                driver.navigate().back();
//                System.out.println(links);
////=====================================================================================================================
//                Manga manga1 = new Manga();
//                manga1.setDescription("Desc");
//                manga1.setCover_url("coverURl");
//                manga1.setAuthor("AUTH");
//                manga1.setPublisher("Pub");
//                manga1.setTitle("title");
////=====================================================================================================================
//                Manga_Volume volume = new Manga_Volume();
//                volume.setFormat("ebook");
//                volume.setISBN(1234);
//                volume.setManga(manga1);
////=====================================================================================================================
//                Comparison comparison = new Comparison();
//                comparison.setManga_volume(volume);
//                comparison.setPrice(12.4f);
//                comparison.setSite_url("URL");
//
//                try {
//                    //Save data with merging to avoid duplicates
//                    dao.saveAndMerge(comparison);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            }
//
//            //Exit driver and close Chrome
//            driver.quit();
//        }
//
//    }
//
