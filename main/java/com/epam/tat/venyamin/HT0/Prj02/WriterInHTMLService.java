package com.epam.tat.venyamin.HT0.Prj02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class WriterInHTMLService implements WriterInFileService {
    @Override
    public File createHTMLFile() {
        File file = new File("mp3_tree.html");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><title>Table</title></head><body>\n");
            bufferedWriter.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (file.canWrite()) {
            return file;
        } else System.out.println("Sorry, but it can't write in new HTML file (" + file.getAbsolutePath() + ").");
        return null;
    }

    @Override
    public void writeArtistName(String artist, File file, BufferedWriter bufferedWriter) {
        try {
            bufferedWriter.write("Artist: " + artist + "<p>\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeSongAttribute(List<Track> tracks, File outputFile, BufferedWriter bufferedWriter) {
        Map<String, List<Track>> albumMap = getAlbumMap(tracks);                // получаем карту альбомов, где ключ - альбом, значение - список треков
        Set<String> albums = albumMap.keySet();
        for (String album : albums) {
            try {
                bufferedWriter.write("Album : " + album + "<br>\n");
                for (Track track : tracks) {
                    if (track.getAlbum().equals(album)) {
                        bufferedWriter.write(track.getTitle() + " " +
                                track.getLength() + " <a href=\"file://" +
                                track.getLink() + "\">" +
                                track.getLink() +
                                "</a><br>\n");
                    }
                }
                bufferedWriter.write("<p>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Map<String, List<Track>> getAlbumMap(List<Track> tracks) {
        Map<String, List<Track>> albumMap = new HashMap<>();
        for (Track track : tracks) {
            if (albumMap.containsKey(track.getAlbum())) {
                albumMap.get(track.getAlbum()).add(track);
            } else {
                albumMap.put(track.getAlbum(), new ArrayList<>());
                albumMap.get(track.getAlbum()).add(track);
            }
        }
        return albumMap;
    }
}
