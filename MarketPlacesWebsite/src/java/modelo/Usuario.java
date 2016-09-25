package modelo;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String password;
    private String genero;
    private String pais;

    public Usuario(int idUsuario, String nombre, String password, String genero, String pais) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.password = password;
        this.genero = genero;
        this.pais = pais;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }   
    
}
