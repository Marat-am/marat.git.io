package com.company;

import com.company.controller.PeopleController;

public class Main {
    public static void main(String[] args) {

        PeopleController peopleController = new PeopleController();

        peopleController.generateData();

        peopleController.writeInFileWithJson();

    }
}

