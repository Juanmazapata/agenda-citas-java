public class Cita {
    private int id;
    private String nombrePaciente;
    private String fechaCita;
    private String horaCita;
    private String motivo;

    //Constructor, getters y setters
    public Cita(String nombrePaciente, String fechaCita, String horaCita, String motivo) {
        this.nombrePaciente = nombrePaciente;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.motivo = motivo;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
