package com.epam.tat.venyamin.HT0.Prj02;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MP3Parser implements TrackParser {

    @Override
    public String getArtist(File file) {

        try {
            InputStream input = new FileInputStream(file);
            DefaultHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseContext = new ParseContext();
            parser.parse(input, handler, metadata, parseContext);
            input.close();
            String artist = metadata.get("xmpDM:artist");
            if (artist.isEmpty()) {
                return "Unknown artist.";
            } else {
                return artist;
            }
        } catch (Exception e) {
            return "Unknown artist.";
        }
    }

    @Override
    public String getAlbum(File file) {
        try {
            InputStream input = new FileInputStream(file);
            DefaultHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseContext = new ParseContext();
            parser.parse(input, handler, metadata, parseContext);
            input.close();
            String album = metadata.get("xmpDM:album");
            if (album.isEmpty()) {
                return "Unknown album.";
            }
            return album;
        } catch (Exception e) {
            return "Unknown album.";
        }
    }

    @Override
    public String getTitle(File file) {
        try {
            InputStream input = new FileInputStream(file);
            DefaultHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseContext = new ParseContext();
            parser.parse(input, handler, metadata, parseContext);
            input.close();
            String title = metadata.get("title");
            if (title.isEmpty()) {
                return "Unknown title.";
            } else {
                return title;
            }
        } catch (Exception e) {
            return "Unknown title.";
        }
    }

    @Override
    public String getTrackLength(File file) {
        final MP3File tmpMP3;
        try {
            tmpMP3 = new MP3File(file);
            return tmpMP3.getMP3AudioHeader().getTrackLengthAsString();
        } catch (IOException | TagException | InvalidAudioFrameException | ReadOnlyFileException e) {
            e.printStackTrace();
        }
        return "Unknown length.";
    }
}


