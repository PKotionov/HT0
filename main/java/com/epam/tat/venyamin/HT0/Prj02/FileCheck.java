package com.epam.tat.venyamin.HT0.Prj02;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


public class FileCheck {
    public static void checkOnSameTrack(List<Track> tracks) {
        for (int i = 0; i < tracks.size(); i++) {
            for (int j = i + 1; j < tracks.size(); j++) {
                String controlSum1 = getCheckSum(new File(tracks.get(i).getLink()));                // получаем контрольные суммы файлов поочереди и сравниваем их
                String controlSum2 = getCheckSum(new File(tracks.get(j).getLink()));
                int count = 1;
                if (controlSum1.equals(controlSum2)) {

                    //Логирование не осилил, поэтому сделал вывод в консоль:
                    System.out.println();
                    System.out.println("Дубликаты " + count + ": ");
                    System.out.println(tracks.get(i).getLink());
                    System.out.println(tracks.get(j).getLink());
                    count++;
                }
            }
        }
    }

    public static void checkOnSameName(List<Track> tracks) {
        for (int i = 0; i < tracks.size(); i++) {
            for (int j = i + 1; j < tracks.size(); j++) {
                if (tracks.get(i).getArtist().equals(tracks.get(j).getArtist()) &&
                        tracks.get(i).getAlbum().equals(tracks.get(j).getAlbum()) &&
                        tracks.get(i).getTitle().equals(tracks.get(j).getTitle())
                        ) {
                    System.out.println();
                    System.out.println("Исполнитель: " + tracks.get(i).getArtist() +
                            ", Альбом: " + tracks.get(i).getAlbum() +
                            ", Композиция: " + tracks.get(i).getTitle() + ":");
                    System.out.println(tracks.get(i).getLink());
                    System.out.println(tracks.get(j).getLink());
                }
            }
        }
    }

    private static final String ALGORITHM = "SHA-1";

    public static String getCheckSum(File file) {

        try {
            // Получаем контрольную сумму для файла в виде массива байт
            final MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            final FileInputStream fis = new FileInputStream(file);
            byte[] dataBytes = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(dataBytes)) > 0) {
                md.update(dataBytes, 0, bytesRead);
            }
            byte[] mdBytes = md.digest();

            // Переводим контрольную сумму в виде массива байт в
            // шестнадцатеричное представление
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mdBytes.length; i++) {
                sb.append(Integer.toString((mdBytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | IOException ex) {
            System.out.println("Контрольная сумма не может быть найдена.");
        }
        return "";
    }
}



