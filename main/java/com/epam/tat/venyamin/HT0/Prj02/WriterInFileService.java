package com.epam.tat.venyamin.HT0.Prj02;

import java.io.BufferedWriter;
import java.io.File;
import java.util.List;


interface WriterInFileService {
    File createHTMLFile();

    void writeArtistName(String artist, File file, BufferedWriter bufferedWriter);

    void writeSongAttribute(List<Track> tracks, File outputFile, BufferedWriter bufferedWriter);
}
