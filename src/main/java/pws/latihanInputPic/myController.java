/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.latihanInputPic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author TUF GAMING
 */
@Controller
public class myController {
   public static String UP_PIC = System.getProperty("user.dir") + "/src/main/resources/static/images";
   String foto = "";
   String pertama ="";
   String kedua ="";
           

    @RequestMapping("fotoa")
    //@ResponseBody

    public String hai(
            
            
            @RequestParam(value = "varA") String isipertama,
            @RequestParam(value = "varB") String isikedua,
            @RequestParam(value = "varC") MultipartFile isifoto,
            Model jnt
    ) {
        StringBuilder filename = new StringBuilder();
        Path filenamepath = Paths.get(UP_PIC, isifoto.getOriginalFilename());
        filename.append(isifoto.getOriginalFilename());
        
        try{
            Files.write(filenamepath, isifoto.getBytes());   
        }
            catch (IOException exe){
                    Logger.getLogger(myController.class.getName()).log(Level.SEVERE, null, exe);
                    }
        
        pertama = isipertama;
        kedua = isikedua;
        foto = isifoto.getOriginalFilename();
        
        jnt.addAttribute("pertama1", isipertama);
        jnt.addAttribute("kedua1", isikedua);
        jnt.addAttribute("foto1", "/images/" +isifoto.getOriginalFilename());
        
        return "view" ;
    }
    }
