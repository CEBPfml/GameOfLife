# GameOfLife

### Members
* Nanu Theodor
* Fitoiu Robert
* Cosma Bogdan
* Nan Bogdana

</br></br>

### Instalation
This Project can be easily imported as an Eclipse Project from the zip file.</br>
One issue that might apprear can be caused by the `.classpath` which uses JRE 13.0.2. Please follow the guidelines on this tutorial
to change JRE used to compile the project: https://crunchify.com/how-to-fix-java-lang-unsupportedclassversionerror-class-has-been-compiled-by-a-more-recent-version-of-the-java-runtime/
</br>
After the project was succesfully imported, set your own config in `src/resource/config/properties`.

</br></br>

### Overview

This is a modified implementantion of Conway's Game of life, where 2 types of cell exist:</br>
* cells that need only food to reproduce: `CelulaAsexuata`
* cells that need feed and also another cell of the same type to reproduce: `CelulaSexuata`

In `Main` a `Food` instance is created, containing the number of food units, that will later be shared by all cells.</br>
<!-- TODO change "certain" mabye -->
At the begining a certain number of cells is created which will "reproduce" and spawn other cells, each in a spearate thread.</br>
Giving the fact that every cell(thread) share the same food(instance), a race condition was created and the safest way to solve it was to use synchronized methods. This issue could have also been solved by using volatile variables, but JVM are allowed to reorder instructions thus rendering volatile unsafe.</br>
A cell can survive with one unit of food for `T_full` time after that it gets hungry and if it does not eat for `T_starve` time it dies producing a random number of food units between 1 and 5.</br>

Every action of a cell is printed to console.

