public class Cliente extends Usuario implements Notificable{
    private int puntos;

    public Cliente(String nombre, String email) {
        super(nombre, email);
        this.puntos = 0;
    }

    public String saludar(){
        return "hola a todos";
    }

    @Override
    public String panelInicio() {
        return "Panel de Cliente: ver productos y mis compras";
    }

    @Override
    public String recibirNotificacion(String mensaje) {
        return "";
    }


}
