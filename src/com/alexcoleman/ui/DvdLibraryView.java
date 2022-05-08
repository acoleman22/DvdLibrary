package com.alexcoleman.ui;

import com.alexcoleman.dto.DvdLibrary;

import java.util.List;

public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection(){
        io.print(" Main Menu");
        io.print("1. Add a DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit existing DVD");
        io.print("4. list DVDs in collect");
        io.print("5. Display info for a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices ", 1, 8);
    }

    public DvdLibrary getDvdInfo(){
        String title = io.readString("Please enter Title.");
        String releaseYear = io.readString("Please enter Release Year.");
        String directorName = io.readString("Please enter the Director.");
        String studio = io.readString("Please enter Studio.");
        String userRating = io.readString("Please User Rating.");
        String mppaRating = io.readString("Please enter MPPA rating");


        DvdLibrary currentDvd = new DvdLibrary(title);
        currentDvd.setReleaseYear(releaseYear);
        currentDvd.setDirectorName(directorName);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        currentDvd.setMppaRating(mppaRating);

        return currentDvd;
    }

    public void displayCreateDvdBanner(){
        io.print("===Create DVD===");
    }

    public void displayCreateSuccessBanner(){
        io.readString("DVD successfully added. please hit enter to continue");
    }

    public void displayEditDvdBanner(){
        io.print("=== Edit DVD ===");
    }

    public void displaySuccessEditDvdBanner(){
        io.print("=== DVD was successfully Edited ===");
    }

    public void displayDvdLibraryList(List<DvdLibrary> dvdLibraryList){
        for(DvdLibrary currentDvd : dvdLibraryList){
            String dvdLibraryInfo = String.format("Title: %s, Release Year: %s, Director: %s, Studio: %s, " +
                            "User Rating : %s, MPPA Rating : %s ",
            currentDvd.getTitle(),
            currentDvd.getReleaseYear(),
            currentDvd.getDirectorName(),
            currentDvd.getStudio(),
            currentDvd.getUserRating(),
            currentDvd.getMppaRating());
            io.print(dvdLibraryInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner(){
        io.print("===Display All DVDs===");
    }

    public void displayDisplayDvdBanner(){
        io.print("=== Display Dvd ===");
    }

    public String getTitleChoice(){
        return io.readString("Please enter DVD title");
    }

    public void displayDvd(DvdLibrary dvd){
        if (dvd != null){
            io.print("Title: "+dvd.getTitle());
            io.print("Release Year: "+String.valueOf(dvd.getReleaseYear()));
            io.print("Director: "+ dvd.getDirectorName());
            io.print("Studio: "+dvd.getStudio());
            io.print("User Rating: "+dvd.getUserRating());
            io.print("MPPA Rating: "+ dvd.getMppaRating());

        } else{
            io.print("No DVD with that title");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayRemoveDvdBanner(){
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResults(DvdLibrary dvdRecord){
        if(dvdRecord != null){
            io.print("DVD was successfully removed");
        } else {
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue");
    }

    public void displayExitBanner(){
        io.print("GOOD BYE!!!");
    }

    public void displayUnknownCommandBanner(){
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg){
        io.print("=== Error ===");
        io.print(errorMsg);
    }
}
