package com.trivia.trivia;

import com.trivia.trivia.entities.Categoria;
import com.trivia.trivia.entities.Pregunta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TriviaController {

    @GetMapping("/question/{categoria}")
    public Pregunta getQuestion(@PathVariable String categoria){

        //Objetos de la clase pregunta y sus posibles respuestas
        Pregunta pregunta = new Pregunta();
        List<String> options =new ArrayList<>();

        //Evalúa a qué categoría salió y llama al método correspondiente y trae la pregunta
        if (categoria.equalsIgnoreCase("Cultura")){
            getPreguntaDeCultura(pregunta, options);
            return pregunta;
        }
        if (categoria.equalsIgnoreCase("Deportes")){
            getPreguntaDeDeportes(pregunta, options);
            return pregunta;
        }
        if (categoria.equalsIgnoreCase("Arte")){
            getPreguntaDeArte(pregunta, options);
            return pregunta;
        }
        if (categoria.equalsIgnoreCase("Cine")){
            getPreguntaDeCine(pregunta, options);
            return pregunta;
        }
        if (categoria.equalsIgnoreCase("Historia")){
            getPreguntaDeHistoria(pregunta, options);
            return pregunta;
        }

        if (categoria.equalsIgnoreCase("Ciencia")){
            getPreguntaCiencia(pregunta, options);
            return pregunta;
        }
        return null;
    }

    //Métodos para crear las preguntas de cada categoría
    private static void getPreguntaCiencia(Pregunta preguntaDeCiencias, List<String> options5) {
            preguntaDeCiencias.setCategory("Ciencia");
            preguntaDeCiencias.setQuestion("¿Cuál es el elemento químico más abundante en el universo?");
            preguntaDeCiencias.setAnswer(0);
            options5.add("hidrógeno");
            options5.add("Helio");
            options5.add("Oxigeno");
            preguntaDeCiencias.setOptions(options5);
            preguntaDeCiencias.setExplanation("La Segunda Guerra Mundial terminó oficialmente el 2 de septiembre de 1945, " +
                    "después de la rendición de Japón. Este conflicto global duró casi seis años, involucró a la " +
                    "mayoría de las naciones del mundo y resultó en la derrota de las potencias del Eje, lideradas por " +
                    "Alemania, Italia y Japón.");
    }

    private static void getPreguntaDeHistoria(Pregunta preguntaDeHistoria, List<String> options4) {
            preguntaDeHistoria.setCategory("Historia");
            preguntaDeHistoria.setQuestion("¿En qué año terminó la Segunda Guerra Mundial?");
            preguntaDeHistoria.setAnswer(0);
            options4.add("1945");
            options4.add("1845");
            options4.add("1745");
            preguntaDeHistoria.setOptions(options4);
            preguntaDeHistoria.setExplanation("La Segunda Guerra Mundial terminó oficialmente el 2 de septiembre de 1945, " +
                    "después de la rendición de Japón. Este conflicto global duró casi seis años, involucró a la " +
                    "mayoría de las naciones del mundo y resultó en la derrota de las potencias del Eje, lideradas por " +
                    "Alemania, Italia y Japón.");
    }

    private static void getPreguntaDeCine(Pregunta preguntaDeCine, List<String> options3) {
            preguntaDeCine.setCategory("Cine");
            preguntaDeCine.setQuestion("¿Quién dirigió la película Pulp Fiction?");
            preguntaDeCine.setAnswer(2);
            options3.add("Steven Spielberg");
            options3.add("Martin Scorsese");
            options3.add("Quentin Tarantino");
            preguntaDeCine.setOptions(options3);
            preguntaDeCine.setExplanation("\"Pulp Fiction\" fue dirigida por Quentin Tarantino. Esta película de 1994 se " +
                    "convirtió en un clásico del cine moderno y recibió numerosos elogios por su innovadora narrativa " +
                    "no lineal y su estilo visual distintivo.");
    }

    private static void  getPreguntaDeArte(Pregunta preguntaDeArte, List<String> options2) {
            preguntaDeArte.setCategory("Arte");
            preguntaDeArte.setQuestion("¿Quién pintó la famosa obra La última cena?");
            preguntaDeArte.setAnswer(0);
            options2.add("Leonardo da Vinci");
            options2.add("Miguel Ángel Buonarroti");
            options2.add("Vincent van Gogh");
            preguntaDeArte.setOptions(options2);
            preguntaDeArte.setExplanation("La última cena fue pintada por Leonardo da Vinci. Esta obra maestra del Renacimiento " +
                    "se encuentra en el convento de Santa Maria delle Grazie en Milán, Italia. Representa el momento " +
                    "en el que Jesús comparte su última cena con sus discípulos.");
    }

    private static void getPreguntaDeDeportes(Pregunta preguntaDeDeportes, List<String> options1) {
            preguntaDeDeportes.setCategory("Deportes");
            preguntaDeDeportes.setQuestion("Qué selección nacional ha ganado la Copa del Mundo más veces en la historia?");
            preguntaDeDeportes.setAnswer(1);
            options1.add("Argentina");
            options1.add("Brazil");
            options1.add("Francia");
            preguntaDeDeportes.setOptions(options1);
            preguntaDeDeportes.setExplanation("Brasil, con un total de 5 títulos.");
    }

    private static void getPreguntaDeCultura(Pregunta preguntaDeCultura, List<String> options) {
            preguntaDeCultura.setCategory("Cultura");
            preguntaDeCultura.setQuestion("¿Qué ingredintes se necesitan para hacer una michelada?");
            preguntaDeCultura.setAnswer(0);
            options.add("Cerveza, lima/limón, sal, chile en polvo, salsa tipo inglesa, picante");
            options.add("Cerveza, lima/limón y limon");
            options.add("Cerveza, sal, tabasco y lima/limón");
            preguntaDeCultura.setOptions(options);
            preguntaDeCultura.setExplanation("La michelada, originaria de México, nacida de la creatividad y el deseo " +
                    "de refrescar, se convirtió en una popular bebida que cautivó a los amantes de la cerveza con su " +
                    "combinación única de sabores y su espíritu festivo.");
    }

    @GetMapping("/categories")
    public List<Categoria> getCategories(){

        List<Categoria> categorias = new ArrayList<>();

        Categoria categoriaCultura = new Categoria();
        categoriaCultura.setCategory("Cultura");
        categoriaCultura.setDescription("Preguntas relacionadas con pintura, escultura, arquitectura y otras formas de expresión artística.");

        Categoria categoriaDeportes = new Categoria();
        categoriaDeportes.setCategory("Deportes");
        categoriaDeportes.setDescription("Preguntas relacionadas con diversos deportes y eventos deportivos.");

        Categoria categoriaArte = new Categoria();
        categoriaArte.setCategory("Arte");
        categoriaArte.setDescription("Preguntas relacionadas con pintura, escultura, arquitectura y otras formas de expresión artística.");

        Categoria categariaCine = new Categoria();
        categariaCine.setCategory("Cine");
        categariaCine.setDescription("Preguntas relacionadas con películas, directores, actores y otros aspectos del cine.");

        Categoria categoriaHistoria = new Categoria();
        categoriaHistoria.setCategory("Historia");
        categoriaHistoria.setDescription("Preguntas relacionadas con eventos históricos, personajes y períodos importantes.");

        Categoria categoriaCiencia = new Categoria();
        categoriaCiencia.setCategory("Ciencia");
        categoriaCiencia.setDescription("Preguntas relacionadas con diferentes ramas de la ciencia, descubrimientos y avances científicos.");

        categorias.add(categoriaCultura);
        categorias.add(categoriaDeportes);
        categorias.add(categoriaArte);
        categorias.add(categariaCine);
        categorias.add(categoriaHistoria);
        categorias.add(categoriaCiencia);

        return categorias;

    }
}
