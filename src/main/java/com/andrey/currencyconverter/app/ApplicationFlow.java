package com.andrey.currencyconverter.app;

import com.andrey.currencyconverter.controllers.Controller;
import com.andrey.currencyconverter.view.UserInterface;

public interface ApplicationFlow {
    void startFlow(UserInterface userInterface,
                   Controller controller);

}
