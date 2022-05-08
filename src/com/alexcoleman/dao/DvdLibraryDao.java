package com.alexcoleman.dao;

import com.alexcoleman.dto.DvdLibrary;

import java.util.List;

public interface DvdLibraryDao {


    DvdLibrary addDvd(String title, DvdLibrary dvd) throws DvdLibraryDaoException;


    List<DvdLibrary> getAllDvds() throws DvdLibraryDaoException;

    DvdLibrary getDvd(String title) throws DvdLibraryDaoException;

    DvdLibrary removeDvd(String title) throws DvdLibraryDaoException;
}
