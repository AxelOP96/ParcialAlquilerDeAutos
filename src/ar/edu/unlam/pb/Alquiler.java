package ar.edu.unlam.pb;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Alquiler {
    private Auto auto;
    private Date fechaInicio;
    private Date fechaFin;
    private double precioTotal;
	private Date fechaDevolucion;
	private Object fechaAlquiler;

    public Alquiler(Auto auto, Date fechaInicio, Date fechaFin) {
        this.auto = auto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = calcularPrecioTotal();
        this.fechaDevolucion = fechaDevolucion;
        this.fechaAlquiler = fechaAlquiler;
    }

    private double calcularPrecioTotal() {
        long cantidadDeDias = ((fechaFin.getTime() - fechaInicio.getTime()) / (24 * 60 * 60 * 1000)) + 1;
        double precioPorDia = auto.getPrecio();
        return cantidadDeDias * precioPorDia;
    }

    public Auto getAuto() {
        return auto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
    private double calcularDiasAlquilado() {
        long diffInMillies = fechaDevolucion.getTime() - ((Date) fechaAlquiler).getTime();
        long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        return diffInDays;
    }

    public void finalizar() {
        // Verificar si el alquiler ya fue finalizado
        if (this.fechaDevolucion != null) {
            throw new RuntimeException("Este alquiler ya ha sido finalizado.");
        }

        // Actualizar la fecha de devolución al momento actual
        this.fechaDevolucion = new Date();

        // Calcular el costo del alquiler
        long tiempoAlquilerMs = this.fechaDevolucion.getTime() - ((Date) this.fechaAlquiler).getTime();
        double tiempoAlquilerHs = TimeUnit.MILLISECONDS.toHours(tiempoAlquilerMs);
        double costo = tiempoAlquilerHs * this.auto.getPrecioPorHora();

        // Asignar el costo calculado al alquiler
        this.precioTotal = costo;
    }

    public void setFechaDevolucion(Date fechaFin2) {
        this.fechaDevolucion = fechaFin2;
    }

}