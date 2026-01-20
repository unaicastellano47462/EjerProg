public class Libro {
    private String titulo;
    private String editorial;
    private int numeroPaginas;
    private Autor autor;
    private int numEjemplares = 3;

    public Libro(String titulo, String editorial, int numeroPaginas, Autor autor) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
    }

    public boolean alquilar() {
        if (numEjemplares > 0) {
            numEjemplares--;
            return true;
        }
        return false;
    }

    public void devolver() {
        numEjemplares++;
    }

    public int getEjemplares(){
        return numEjemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }
}
