package org.comparison.selenium;

//Hibernate imports
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/** Saving and merging with Hibernate */
public class MangaDao {
    SessionFactory sessionFactory;

    public void saveAndMerge(Comparison comparison) throws Exception {
        //Get a new Session instance from the session factory and start transaction
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        //First find or create manga
        String queryStr = "from Manga where title='" + comparison.getManga_volume().getManga().getTitle() + "'";
        List<Manga> mangaList = session.createQuery(queryStr).getResultList();

        //Manga is in database
        if(mangaList.size() == 1) {//Found a single managa

            //Set mapped manga in volume
            comparison.getManga_volume().setManga(mangaList.get(0));
        }
        //No manga with that name in database
        else if (mangaList.size() == 0){
            session.saveOrUpdate(comparison.getManga_volume().getManga());
        }
        //Error
        else{
            throw new Exception("Multiple mangaas with the same name");
        }

        //Manga should now b a peristent class with correct ID set.

        //Next find or create manga volume. Need to search by manga id to handle problem
        //of volumes with the same name at different manga.
        queryStr = "from Manga_Volume where ISBN='" + comparison.getManga_volume().getISBN() + "'";
        List<Manga_Volume> volumeList = session.createQuery(queryStr).getResultList();

        //volume is in database
        if(volumeList.size() == 1) {//Found a single volume
            //Update volume description, if we want to
           // volumeList.get(0).setFormat(manga_volume.getFormat());

            //Set mapped manga in volume
            comparison.setManga_volume(volumeList.get(0));
        }
        //No volume with that name in database
        else if (volumeList.size() == 0){
            session.saveOrUpdate(comparison.getManga_volume());
        }
        //Error
        else{
            throw new Exception("Multiple Volumes with the same name");
        }

        //Next find or create comparison. Need to search by manga id to handle problem
        //of volumes with the same name at different manga.
        queryStr = "from Comparison where site_url='" + comparison.getSite_url() + "'";
        List<Comparison> comparisonList = session.createQuery(queryStr).getResultList();

        //Comparison is in database
        if(comparisonList.size() == 1) {//Found a single volume
            //Update volume price, if we want to
             comparisonList.get(0).setPrice(comparison.getPrice());
        }
        //No comparison with that url in database
        else if (comparisonList.size() == 0){
            session.saveOrUpdate(comparison);
        }
        //Error
        else{
            throw new Exception("Multiple Volumes with the same name");
        }
        //Commit transaction to save chagnes made to mapped classes
        session.getTransaction().commit();

        //Close the session and release database connection
        session.close();
    }

    /** Sets up the session factory.
     *  Call this method first.  */
    public void init(){
        try {
            //Create a builder for the standard service registry
            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();

            //Load configuration from hibernate configuration file.
            //Here we are using a configuration file that specifies Java annotations.
            standardServiceRegistryBuilder.configure("hibernate.cfg.xml");

            //Create the registry that will be used to build the session factory
            StandardServiceRegistry registry = standardServiceRegistryBuilder.build();
            try {
                //Create the session factory - this is the goal of the init method.
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                    /* The registry would be destroyed by the SessionFactory,
                        but we had trouble building the SessionFactory, so destroy it manually */
                System.err.println("Session Factory build failed.");
                e.printStackTrace();
                StandardServiceRegistryBuilder.destroy(registry);
            }

            //Ouput result
            System.out.println("Session factory built.");

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("SessionFactory creation failed." + ex);
        }
    }



}
