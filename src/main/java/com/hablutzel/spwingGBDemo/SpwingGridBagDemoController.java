package com.hablutzel.spwingGBDemo;


import com.hablutzel.spwing.Spwing;
import com.hablutzel.spwing.annotations.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


/**
 * The controller class has the responsibility of
 * reacting to view events. Controllers are mostly
 * used to handle button clicks and the like; they
 * are not needed for reflecting changes to bound
 * values in the model.<br>
 * For this demo, the button reacts by changing
 * the text of the model.
 */
@Controller
@RequiredArgsConstructor
public class SpwingGridBagDemoController {

    /**
     * In this demo, the model is needed by multiple method.
     * Rather than adding it to each method as a parameter,
     * instead we save it as a field on the controller.
     * Since this is a <code>private final</code> field,
     * and we are annotated with {@link RequiredArgsConstructor},
     * the constructor for the controller will take this
     * model as a parameter, and the Spwing format will
     * pass the model to the controller when the controller
     * is created.
     */
    private final SpwingGridBagDemoModel model;

    /**
     * Handle the <code>show</code> button click. Note that no wiring
     * is required for this method; the name of the
     * method defines the purpose through convention
     * and the arguments are automatically provided
     * by the framework.<br>
     * Specifically, this method is the handler for
     * an AWT event. The event is "Clicked", which is
     * an alias for the native "actionPerformed" event.
     * The method is identified as an event handler
     * because the name of the method begins with "on".
     * It is identified as being a handler for a specific
     * view component because the name of the component
     * (from the SVWF file) comes before the name of the
     * event, separated by an underscore. The rest of
     * the name "Clicked" defines the event to listen for.
     * (In order to keep more natural camelCase syntax, the
     * name could be "onButton_Clicked" or "onButton_clicked").<br>
     * The method takes advantage of the {@link Spwing#postErrorDialog(String, Object...)}
     * method do display the current value of the model
     * element. [Note: This isn't really an error, and future
     * versions of Spwing will provide support for a more
     * intuitively named method.] The "error" in this case is
     * <code>"showText"</code>, and the text field from the
     * model is the parameter. The error show text will correspond
     * to a localizable string <code>showText_msg</code>, which
     * is found in the properties bundle for the main class.<br>
     * Since the compiler doesn't see that the method is
     * called (it is called via reflection), we suppress the
     * unused warnings.<br>     *
     */
    @SuppressWarnings("unused")
    public void onShow_Clicked( final Spwing spwing) {
        spwing.postErrorDialog("showText", model.getTextField());
    }


    /**
     * Handler for the <code>change</code> button. See the
     * comments on {@link #onShow_Clicked(Spwing)} for how this
     * method is connected with the button from the SVWF file.<br>
     * In this case, the functionality of the button is to change
     * the model property <code>textField</code> to a predefined
     * value.<br>
     * The method takes a {@link MessageSource} instance. This
     * is provided by the framework to allow for localization of
     * methods. The framework expects to find localization
     * strings in the property bundle associated with the main class;
     * in this since the main class is {@link SpwingGridBagDemo},
     * the resource is named <code>SpwingGridBagDemo.properties</code>
     * (and associated localized variants) localed in the path
     * "resources/com/hablutzel/spwingBTFDemo", which aligns with the
     * package of the {@link SpwingGridBagDemo} class.
     */
    @SuppressWarnings("unused")
    public void onChange_Clicked(final MessageSource messageSource) {

        // Get the current time
        final String currentTimeString = ZonedDateTime
                .now( ZoneId.systemDefault() )
                .format( DateTimeFormatter.ofPattern( "uuuu-MM-dd HH:mm:ss" ));

        // Format the message using the message formatter. Since this takes
        // an array of string parameters, we build that array on the fly
        String newValue = messageSource.getMessage("timeIs",
                new String[] { currentTimeString },
                "Don't forget to define a local definition of 'timeIs'",
                Locale.getDefault());

        // Change the model value.
        model.setTextField(newValue);
    }

}
