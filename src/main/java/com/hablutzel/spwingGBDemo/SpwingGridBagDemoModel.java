package com.hablutzel.spwingGBDemo;


import com.hablutzel.spwing.annotations.Model;
import com.hablutzel.spwing.model.ModelConfiguration;
import com.hablutzel.spwing.model.PropertyChangeModel;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.Serial;


/**
 * The main model for the demo. The model contains a
 * single field ({@link #textField}, which contains
 * a string. The field is bound to the label created by
 * the view, so that changes to the model are reflected
 * in the view automatically. <br>
 * Spwing supports automatic saving and opening for
 * models that implement serialization. The {@link Model}
 * annotation gives the model an opportunity to define the
 * file extension of the files. By doing this, the application
 * can automatically detect when the model changes and
 * save the file as necessary.
 */

@Service
@Scope("document")
public class SpwingGridBagDemoModel extends PropertyChangeModel
                                    implements ModelConfiguration<SpwingGridBagDemoModel> {

    @Serial
    private static final long serialVersionUID = 78432508723L;


    /**
     * The data for this model - a simple text field.
     */
    @Getter
    private String textField = "Hello World";


    /**
     * The setter of the field is augmented to signal
     * a document event when the text field changes. The
     * model signals this by noting that the state changed,
     * with the event to signal. This is functionality inherited
     * from the {@link PropertyChangeModel} class. Inheriting from this
     * class is <b>not</b> required by the framework, but it
     * does provide some useful functionality such as the
     * {@link PropertyChangeModel#signalChange(String, Object, Object)}
     *
     * @param textField The new value of the field
     */
    public void setTextField(String textField) {
        // Save the new value, and signal the change
        // This is sufficient for the bound label to be
        // updated in the view.
        final String oldValue = this.textField;
        this.textField = textField;
        this.signalChange("textField", oldValue, textField);
    }

    @Bean
    @Scope("document")
    public String fileExtensions() {
        return "sd2";
    }
}
