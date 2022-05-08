package com.alexcoleman;

import com.alexcoleman.controller.DvdLibraryController;
import com.alexcoleman.dao.DvdLibraryDao;
import com.alexcoleman.dao.DvdLibraryDaoFileImpl;
import com.alexcoleman.ui.DvdLibraryView;
import com.alexcoleman.ui.UserIO;
import com.alexcoleman.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(myView,myDao);
        controller.run();
    }
}
