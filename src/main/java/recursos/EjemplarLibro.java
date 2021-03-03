package recursos;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class EjemplarLibro {
    protected String titulo;
    protected String fechaAdquisicion;
    protected int numEjemplar;
    protected boolean prestado;

    public EjemplarLibro (String title){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.titulo = title;
        this.fechaAdquisicion = df.format(LocalDateTime.now());
        this.numEjemplar = 1;
        this.prestado = false;
    }

    public EjemplarLibro (EjemplarLibro libro) {
        this.titulo = libro.titulo;
        this.fechaAdquisicion = libro.fechaAdquisicion;
        this.numEjemplar = libro.numEjemplar + 1;
        this.prestado = false; 
    }

    public boolean prestar (){
        if (this.prestado)
            return false;
        else{
            this.prestado = true;
            return true;
        }
    }

    public boolean devolver (){
        if(!this.prestado)
            return false;
        else{
            this.prestado = false;
            return true;
        }
    }

    public String toString (){
        return titulo + " (" + fechaAdquisicion + ") " + numEjemplar;
    }
}
