/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ratemyrateable.dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ratemyrateable.be.Rateable;

/**
 *
 * @author Rasmus
 */
public class RateDAO
{
    public void saveFile(ArrayList<Rateable> rating) throws FileNotFoundException
    {
        FileChooser saveFile = new FileChooser();
        FileChooser.ExtensionFilter txtFilter = new FileChooser.ExtensionFilter("Text document (*.txt)", "*.txt");
        saveFile.getExtensionFilters().add(txtFilter);
        saveFile.setSelectedExtensionFilter(txtFilter);
        
        File defaultDirectory = new File("src/ratemyrateable/assest");
        saveFile.setInitialDirectory(defaultDirectory);
        saveFile.setInitialFileName("gameRating");
        File gameRatingFile = saveFile.showSaveDialog(new Stage());
        
        try(PrintWriter out = new PrintWriter(gameRatingFile))
        {
            for (Rateable rateable : rating)
            {
                out.write(rateable.getDescription() + "," + rateable.getRate());
                out.println();
            }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("");
        }
    }
}
