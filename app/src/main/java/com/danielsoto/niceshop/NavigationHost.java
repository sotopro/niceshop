package com.danielsoto.niceshop;

import androidx.fragment.app.Fragment;

/*
* un host (Decidir que pantalla va a mostrar segun el evento de navegacion)
*/

public interface NavigationHost {
    /*
    *  Disparador de navegacion hacia un fragmento especifico
    */
    void navigateTo(Fragment fragment, boolean addToBackstack);
}