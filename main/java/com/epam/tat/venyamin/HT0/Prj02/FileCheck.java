package com.epam.tat.venyamin.HT0.Prj02;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;


public class FileCheck {
    public static void checkOnSameTrack(List<Track> tracks) {
        System.setProperty("log4j.configurationFile",
                "src\\com\\epam\\tat\\venyamin\\HT0\\Prj02\\log4j.xml");
        Logger logger = LogManager.getRootLogger();
        for (int i = 0; i < tracks.size(); i++) {
            for (int j = i + 1; j < tracks.size(); j++) {
//                System.out.println(tracks.get(j));
//                System.out.println(tracks.get(i));
//                System.out.println(new File(tracks.get(i).getLink()).equals(new File(tracks.get(j).getLink())));
                if (new File(tracks.get(i).getLink()).equals(new File(tracks.get(j).getLink()))) {
                    logger.info("Information message");

                    Logger logger2 = LogManager.getLogger(FileCheck.class);
                    logger2.info("2 Information message");
                    logger2.debug("2 Debug message");
                    logger2.trace("2 Trace message");
                    logger2.error("2 Error message");
                    logger2.fatal("2 Fatal message");
                    logger2.warn("2 Warning message");
                }
            }
        }
    }

    public static void checkOnSameName(List<Track> tracks) {
        System.setProperty("log4j.configurationFile",
                "src\\com\\epam\\tat\\venyamin\\HT0\\Prj02\\log4j.xml");
        Logger logger = LogManager.getRootLogger();
        for (int i = 0; i < tracks.size(); i++) {
            for (int j = i + 1; j < tracks.size(); j++) {
                if (tracks.get(i).getArtist().equals(tracks.get(j).getArtist()) &&
                        tracks.get(i).getAlbum().equals(tracks.get(j).getAlbum()) &&
                        tracks.get(i).getTitle().equals(tracks.get(j).getTitle())
                        ) {
                    System.out.println("совпадение обнаружено");
                    logger.info("Information message");
                    Logger logger2 = LogManager.getLogger(FileCheck.class);
                    logger2.info("2 Information message");
                    logger2.debug("2 Debug message");
                    logger2.trace("2 Trace message");
                    logger2.error("2 Error message");
                    logger2.fatal("2 Fatal message");
                    logger2.warn("2 Warning message");
                }
            }
        }
    }


//        logger.debug("Debug message");
//        logger.trace("Trace message");
//        logger.error("Error message");
//        logger.fatal("Fatal message");
//        logger.warn("Warning message");
//        Logger logger2 = LogManager.getLogger(App.class);
//        logger2.info("2 Information message");
//        logger2.debug("2 Debug message");
//        logger2.trace("2 Trace message");
//        logger2.error("2 Error message");
//        logger2.fatal("2 Fatal message");
//        logger2.warn("2 Warning message");

}


