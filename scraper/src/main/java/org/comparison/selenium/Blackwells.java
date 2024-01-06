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
//public class Blackwells {
//
//    MangaDao dao;
//
//    Blackwells() {
//        dao = new MangaDao();
//        dao.init();
//    }
//
//    /** Demonstrates use of ChromeDriver with Selenium */
//    public void showHTML(){
//        String item = "black clover";
//        //We need an options class to run headless - not needed if we want default options
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(false);
//
//        //Create instance of web driver - this must be on the path.
//        WebDriver driver = new ChromeDriver(options);
//
//        //Navigate Chrome to page.
//        driver.get("https://blackwells.co.uk/bookshop/search/?keyword=black+clover");
//
//        //Wait for page to load
//        try {
//            Thread.sleep(3000);
//        }
//        catch(Exception ex){
//            ex.printStackTrace();
//        }
//
//        //Output details for individual products
//        List<WebElement> mangaList = driver.findElements(By.cssSelector("li.search-result__item "));
////=======================================================================================================================
//        for (WebElement manga : mangaList) {
//
//            String links = manga.findElement(By.className("product-name")).getAttribute("href");
//            //driver.get(links);
//            System.out.println(links);
//
//            Manga manga1 = new Manga();
//
//            //String description=  driver.findElement(By.cssSelector("div.summary")).getText();
//            manga1.setDescription("description");
//
//            //WebElement coverElement = driver.findElement(By.className("productImage"));
//            //String cover = coverElement.getAttribute("src");
//            manga1.setCover_url("cover");
//
//            //String publisher = driver.findElement(By.cssSelector("li.publisher")).getText();
//            //String publisherReplaced = publisher.replace("Publisher:", "");
//            manga1.setPublisher("publisherReplaced");
//
//            //driver.navigate().back();
//
//            manga1.setAuthor("Au");
//            manga1.setTitle("au");
////=======================================================================================================================
//            String links2 = manga.findElement(By.className("product-name")).getAttribute("href");
//            driver.get(links2);
//
//            Manga_Volume volume = new Manga_Volume();
//
//            //String format = driver.findElement(By.cssSelector("li.format")).getText();
//            //String formatTrim = format.replace("Format:", "").replace("/ softback", "");
//            volume.setFormat("formatTrim");
//
//            //String stringISBN = driver.findElement(By.cssSelector("li.EAN")).getText();
//            //long isbn = Long.parseLong(stringISBN.replace("ISBN:", ""));
//            WebElement element = driver.findElement(By.cssSelector("td[itemprop='isbn']"));
//            String isbn = element.getText();
//            System.out.println(isbn);
//            volume.setISBN(123);
//
//            driver.navigate().back();
//
//            volume.setManga(manga1);
////=======================================================================================================================
//            Comparison comparison = new Comparison();
//            comparison.setManga_volume(volume);
//
////            String stringPrice = manga.findElement(By.cssSelector("p.price")).getText();
////            String trimPrice = stringPrice.replace("£", "");
////            float price = Float.parseFloat(trimPrice);
//            comparison.setPrice(12);
//
//            WebElement url = manga.findElement(By.cssSelector("a.product-name"));
//            String volURL = url.getAttribute("href");
//            comparison.setSite_url(volURL);
//
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
//
