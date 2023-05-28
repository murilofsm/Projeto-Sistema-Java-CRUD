package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    private static Calendar cal = Calendar.getInstance();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static Date createDate(int dia, int mes, int ano) {
        //cal.set(ano, mes, dia, 0 ,0);
        cal.set(Calendar.YEAR, ano);
        cal.set(Calendar.MONTH, --mes);
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal.getTime();
    }

    public static LocalDate createLocalDate(Date data) {
        cal.setTime(data);
        return LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
    }
    
    public static LocalDate createLocalDate(int dia, int mes, int ano) {
        return LocalDate.of(ano, mes, dia);
    }
    
    public static Date convertLocalDateToDate(LocalDate d){
        return createDate(d.getDayOfMonth(), d.getMonthValue(), d.getYear());
    }
    
    public static java.sql.Date convertLocalDateToSqlDate(LocalDate d){
        return new java.sql.Date(convertLocalDateToDate(d).getTime());
    }
    
    public static LocalDate convertSqlDateToLocalDate(java.sql.Date d){
        return d.toLocalDate();
    }

    public static Calendar getCal() {
        return cal;
    }

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
    }
    
    public static String formatarDataBR(LocalDate dt) {
        return dt.format(formatter);
    }

    public static Date obterDataAtualSistema() {
        return new Date();
    }

    public static LocalDate obterLocalDateAtualSistema() {
        return LocalDate.now();
    }

    public static Date parseDate(String data) {
        try {
            return dateFormat.parse(data);
        } catch (ParseException e) {
            System.out.println("Falha ao converter a data: " + data);
            return null;
        }

    }

    public static LocalDate parseLocalDate(String data) {
        return LocalDate.parse(data); // formato string ano-mes-dia
    }
    
    public static LocalDate parseLocalDateFormatado(String data) {
        //LocalDate parsedDate = LocalDate.parse(data, formatter);
        return LocalDate.parse(data, formatter);// formato string dia/mes/ano
    }

    public static int getAnoDate(Date data) {
        cal.setTime(data);
        return cal.get(Calendar.YEAR);
    }

    public static int getMesDate(Date data) {
        cal.setTime(data);
        return cal.get(Calendar.MONTH);
    }

    public static int getDiaDate(Date data) {
        cal.setTime(data);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int getDiaDaSemanaDate(Date data) {
        cal.setTime(data);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static int getHoraDate(Date data) {
        cal.setTime(data);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinutosDate(Date data) {
        cal.setTime(data);
        return cal.get(Calendar.MINUTE);
    }

    public static int getQuantidadeDiasMes(Date data) {
        cal.setTime(data);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Date addAno(Date data, int anos) {
        cal.setTime(data);
        cal.add(Calendar.YEAR, anos);
        return cal.getTime();
    }

    public static Date addMes(Date data, int mes) {
        cal.setTime(data);
        cal.add(Calendar.MONTH, mes);
        return cal.getTime();
    }

    public static Date addDia(Date data, int dia) {
        cal.setTime(data);
        cal.add(Calendar.DAY_OF_MONTH, dia);
        return cal.getTime();
    }

    public static Date addHoras(Date data, int horas) {
        cal.setTime(data);
        cal.add(Calendar.HOUR_OF_DAY, horas);
        return cal.getTime();
    }

    public static Date addMinutos(Date data, int minutos) {
        cal.setTime(data);
        cal.add(Calendar.MINUTE, minutos);
        return cal.getTime();
    }

    public static LocalDate addAno(LocalDate data, int ano) {
        return data.plusYears(ano);
    }

    public static LocalDate addMes(LocalDate data, int mes) {
        return data.plusMonths(mes);
    }

    public static LocalDate addDia(LocalDate data, int dia) {
        return data.plusDays(dia);
    }

    public static LocalTime addHora(LocalTime data, int hora) {
        return data.plusHours(hora);
    }

    public static LocalTime addMinutos(LocalTime data, int minutos) {
        return data.plusMinutes(minutos);
    }

    public static long quantidadeDiasEntreDatas(LocalDate data1, LocalDate data2) {
        return data1.until(data2, ChronoUnit.DAYS);
    }

    public static long quantidadeAnosEntreDatas(LocalDate data1, LocalDate data2) {
        return data1.until(data2, ChronoUnit.YEARS);
    }

    public static long quantidadeDiasEntreDatas(Date data1, Date data2) {
        long milisegundos = 0;
        if (data1.before(data2)) {
            milisegundos = data1.getTime() - data2.getTime();
        } else {
            milisegundos = data2.getTime() - data1.getTime();
        }
        cal.setTimeInMillis(milisegundos);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    public static long quantidadeHorasEntreDatas(Date data1, Date data2) {
        long milisegundos = 0;
        if (data1.before(data2)) {
            milisegundos = data1.getTime() - data2.getTime();
        } else {
            milisegundos = data2.getTime() - data1.getTime();
        }
        cal.setTimeInMillis(milisegundos);
        return cal.get(Calendar.HOUR_OF_DAY);
    }
    
    public static boolean isAnoBissexto(LocalDate data){
        return data.isLeapYear();
    }
    
    public static boolean isAnoBissexto(Date data){
        GregorianCalendar c = (GregorianCalendar) 
                 GregorianCalendar.getInstance();
        return c.isLeapYear(getAnoDate(data));
    }
    
    public static LocalDate quintoDiaUtilMes(LocalDate data){
        LocalDate d= data.with(firstDayOfMonth());
        int count = 0; 
        while(count < 5){
            if( d.getDayOfWeek() != DayOfWeek.SATURDAY && d.getDayOfWeek() != DayOfWeek.SUNDAY ){
                count++;
            }
            d = d.plusDays(1);
        }
        
        return d;
    }

}
