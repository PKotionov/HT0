package com.epam.tat.venyamin.HT0.Prj02;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MP3ParserService implements FileParserService {
    @Override
    public Map<String, List<Track>> getArtistMap(List<File> mp3FileList) {
        Map<String, List<Track>> artistMap = new HashMap<>();
        for (File mp3File : mp3FileList) {
            TrackParser parser = new MP3Parser();
            Track track = new Track(parser.getArtist(mp3File),
                    parser.getTitle(mp3File),
                    parser.getAlbum(mp3File),
                    parser.getTrackLength(mp3File),
                    mp3File.getAbsolutePath());
            if (artistMap.containsKey(track.getArtist())) {
                artistMap.get(track.getArtist()).add(track);
            } else {
                artistMap.put(track.getArtist(), new ArrayList<>());
                artistMap.get(track.getArtist()).add(track);
            }
        }
        return artistMap;
    }
}
