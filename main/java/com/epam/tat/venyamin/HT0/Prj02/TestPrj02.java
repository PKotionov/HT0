package com.epam.tat.venyamin.HT0.Prj02;

import java.io.File;
import java.util.List;
import java.util.Map;

public class TestPrj02 {
    public static void main(String[] args) {
        if (args.length > 0) {
            for (String arg : args) {
                File file = new File(arg);
                if (file.exists()) {
                    if (file.isDirectory()) {
                        FileFinder mp3Finder = new Mp3Finder();
                        List<File> mp3FileList = mp3Finder.findFilesInDir(arg);        // получаем список всех mp3 файлов в указанных директориях
                        Map<String, List<Track>> artistMap = new MP3ParserService().getArtistMap(mp3FileList);     // получаем карту с ключем - исполнитель, значением - список его песен
                        new WriterInHTML().writeFilesIntoFile(artistMap);                                           // пишем все данные в HTML-файл
                        List<Track> mp3TrackList = TrackService.getAllTracksFromMap(artistMap);                     // получаем список всех треков ввиде Track-класса
                        FileCheck.checkOnSameTrack(mp3TrackList);                                     // проверяем треки на совпадение по имени, альбому и исполнителю
                        FileCheck.checkOnSameName(mp3TrackList);                                // проверяем треки на совпадение по контрольной сумме
                    } else {
                        System.out.println(arg + " is not a directory.");
                    }
                } else {
                    System.out.println(arg + "File doesn't exist.");
                }
            }
        } else {
            System.out.println("You should input path to dirs in console, where you want to find mp3 files.");
        }
    }
}

