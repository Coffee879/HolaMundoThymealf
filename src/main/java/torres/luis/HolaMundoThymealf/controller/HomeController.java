package torres.luis.HolaMundoThymealf.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.*;

@Controller
public class HomeController {
    @GetMapping("/")
    public  String index(@RequestParam(name="nombre",required = false,defaultValue = "Invitado") String nombre,


                             Model model, HttpSession session

                             ){
        model.addAttribute("mensajeBienvenida","hola mundo desde spring");
        model.addAttribute("nombreUsuario", nombre);
        session.setAttribute("operador","Admin");
        return "index";
    }
    @GetMapping("/saludo")
    public String saludo(Model model){

        LocalTime now= LocalTime.now();
        int hora=now.getHour();
        String saludo ;
        String claseCss;
        if(hora>= 5&& hora< 12){
            saludo="buenos dias";
            claseCss = "color: #198754";

        }else if (hora >=12&& hora< 19){
            saludo ="buenas tardes";
            claseCss="color: #0d6efd";

        } else {
            saludo= "buenas noches";
                    claseCss="color: #dc3545";
        }
        model.addAttribute("saludo",saludo);
        model.addAttribute("claseCss",claseCss);
        return "saludo";
    }

    @GetMapping ("/catalogo")
    public String catalogo (Model model){
        List<Map<String, Object>> juegos= new ArrayList<>();
        juegos.add(crearJuegos("smite","moba","P",00,true));
        juegos.add(crearJuegos("smite 2","moba","P",00,true));
        juegos.add(crearJuegos("smite","moba","P",522.00,true));
        juegos.add(crearJuegos("smite","moba","P",522.00,true));
        juegos.add(crearJuegos("smite","moba","P",522.00,true));
        model.addAttribute("juegos", juegos);

return "catalogo";


    }
    private Map<String,Object> crearJuegos(String titulo, String genero, String plataforma, double precio, boolean disponible){

        Map<String,Object> juego= new HashMap();
        juego.put("titulo",titulo);
        juego.put("genero",genero);
        juego.put("plataforma",plataforma);
        juego.put("precio",precio);
        juego.put("disponible",disponible);


        return juego;

    }








}
