package com.alexcoleman.dao;

import com.alexcoleman.dto.DvdLibrary;

import java.io.*;
import java.util.*;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao{
private Map<String, DvdLibrary> dvds = new HashMap<>();

    public static final String DVD_LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    @Override
    public DvdLibrary addDvd(String title, DvdLibrary dvd) throws DvdLibraryDaoException{
            loadDvdLibrary();
            DvdLibrary newDvd = dvds.put(title,dvd);
            writeLibrary();
            return newDvd;
        }


    @Override
    public List<DvdLibrary> getAllDvds() throws DvdLibraryDaoException{
            loadDvdLibrary();
            return new ArrayList<>(dvds.values());
    }

    @Override
    public DvdLibrary getDvd(String title) throws DvdLibraryDaoException{
        loadDvdLibrary();
        return dvds.get(title);
    }

    @Override
    public DvdLibrary removeDvd(String title) throws DvdLibraryDaoException{
        loadDvdLibrary();
        DvdLibrary removeDvd = dvds.remove(title);
        writeLibrary();
        return removeDvd;
    }

    private DvdLibrary unmarshallDvdLibrary(String LibraryAsText){
        String[] dvdTokens = LibraryAsText.split(DELIMITER);

        String title = dvdTokens[0];

        DvdLibrary dvdFromFile = new DvdLibrary(title);
        dvdFromFile.setReleaseYear((dvdTokens[1]));
        dvdFromFile.setDirectorName(dvdTokens[2]);
        dvdFromFile.setStudio(dvdTokens[3]);
        dvdFromFile.setUserRating(dvdTokens[4]);
        dvdFromFile.setMppaRating(dvdTokens[5]);
        return dvdFromFile;
    }

    private void loadDvdLibrary() throws DvdLibraryDaoException{
        Scanner scanner;

        try{
            scanner = new Scanner( new BufferedReader(new FileReader(DVD_LIBRARY_FILE)));
        } catch (FileNotFoundException e){
            throw new DvdLibraryDaoException("-_- Could not load DVD Library data into memory", e);
        }
        String currentLine;
        DvdLibrary currentDvd;

        while(scanner.hasNext()){
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvdLibrary(currentLine);

            dvds.put(currentDvd.getTitle(),currentDvd);
        }
        scanner.close();
    }

    private String marshallDvdLibrary(DvdLibrary aDvd){
        String LibraryAsText = aDvd.getTitle()+DELIMITER;

        LibraryAsText += aDvd.getReleaseYear()+DELIMITER;
        LibraryAsText += aDvd.getDirectorName()+DELIMITER;
        LibraryAsText += aDvd.getStudio()+DELIMITER;
        LibraryAsText += aDvd.getUserRating()+DELIMITER;
        LibraryAsText += aDvd.getMppaRating()+DELIMITER;
        return LibraryAsText;
    }

    private void writeLibrary() throws DvdLibraryDaoException{
        PrintWriter out;

        try{
            out = new PrintWriter(new FileWriter(DVD_LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not save DVD data.",e);
        }
        String LibraryAsText;
        List<DvdLibrary> dvdLibraryList = new ArrayList<>(dvds.values());
        for(DvdLibrary currentDvd : dvdLibraryList){
            LibraryAsText = marshallDvdLibrary(currentDvd);
            out.println(LibraryAsText);
            out.flush();
        }
        out.close();
    }
}

