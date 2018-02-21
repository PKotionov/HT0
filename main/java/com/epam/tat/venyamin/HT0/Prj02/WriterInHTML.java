package com.epam.tat.venyamin.HT0.Prj02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


class WriterInHTML implements WriterInFile {

    @Override
    public void writeFilesIntoFile(Map<String, List<Track>> artistMap) {
        WriterInFileService writer = new WriterInHTMLService();
        File file = writer.createHTMLFile();
        if (file != null) {
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                Set<String> artists = artistMap.keySet();
                for (String artist : artists) {
                    writer.writeArtistName(artist, file, bufferedWriter);      // записываем в файл имя исполнителя
                    writer.writeSongAttribute(artistMap.get(artist), file, bufferedWriter);        //  записываем в файл все атрибуты mp3 файла
                }
                bufferedWriter.write("</body></html>");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
