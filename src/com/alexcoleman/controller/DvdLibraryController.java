package com.alexcoleman.controller;

import com.alexcoleman.dao.DvdLibraryDao;
import com.alexcoleman.dao.DvdLibraryDaoException;
import com.alexcoleman.dto.DvdLibrary;
import com.alexcoleman.ui.DvdLibraryView;
import com.alexcoleman.ui.UserIO;
import com.alexcoleman.ui.UserIOConsoleImpl;

import java.util.List;

public class DvdLibraryController {

    private DvdLibraryView view;
    private DvdLibraryDao dao;
    private UserIO io = new UserIOConsoleImpl();

    public DvdLibraryController(DvdLibraryView view, DvdLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {


                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        listDvds();
                        break;
                    case 5:
                        viewDvd();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        DvdLibrary newDvd = view.getDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateDvdBanner();
    }

    private void editDvd() throws DvdLibraryDaoException{
        view.displayEditDvdBanner();
        DvdLibrary editDvd = view.getDvdInfo();
        dao.addDvd(editDvd.getTitle(), editDvd);
        view.displaySuccessEditDvdBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DvdLibrary> dvdLibraryList = dao.getAllDvds();
        view.displayDvdLibraryList(dvdLibraryList);
    }

    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getTitleChoice();
        DvdLibrary dvd = dao.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getTitleChoice();
        DvdLibrary removedDvd = dao.removeDvd(title);
        view.displayRemoveResults(removedDvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
