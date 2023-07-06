package com.hablutzel.spwingGBDemo;


import com.hablutzel.spwing.Spwing;
import com.hablutzel.spwing.annotations.Application;


/**
 * The demo application. This launches the Spwing
 * environment, passing the application class as
 * the context root. This root will be used to find
 * all the key objects - they will be in the same
 * package or a subpackage.
 */
@Application(applicationName = "BTF")
public class SpwingGridBagDemo {

    public static void main(String[] args) {

        // Launch Spwing
        Spwing.launch(SpwingGridBagDemo.class);
    }
}
