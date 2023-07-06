Simple demo [Spwing](https://github.com/bobhablutzel/spwing) application that 
demonstrates the use of the gridBagLayout layout structure.

This demonstration builds on the [SpwingBoundTextField](https://github.com/bobhablutzel/SpwingBoundTextFieldDemo)
demonstration program. If you want more information about the bidirectional
binding of models to views, see that demo for details.

gridBagLayout provides the functionality of the Swing GridBagLayout layout class.


- The GridBagConstraints for the element are specified in
parenthesis after the name of the element. This allows
the direct setting of the weight of the item, the fill
model, and the grid positioning and width.
- The GridBagLayout constants (such as BOTH below) are
defined as Spwing constants ($BOTH) in this case.
- As an alternative to the gridx/gridy/gridwidth/gridheight
specifications, a spreadsheet-like range can be specified.
In this case the topleft cell is always specified and the
bottomright is optionally specified. If omitted, the cell
range is a single cell. This specification comes after the
@ character following the GridBagLayout constraints, and
will override any gridX/gridY specified.
- "filler" elements are allowed that will be anonymous
JPanel instances.

```
layout {
    frame: gridBagLayout (
         textField(weightx=1.0, weighty=1.0, fill=$BOTH) @A1:C1,
         filler(weightx=1.0) @A2,
         change(gridx=2, gridy=2), // Equals @B2
         show @C2
    );
}
```
